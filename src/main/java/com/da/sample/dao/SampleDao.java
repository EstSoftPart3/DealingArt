package com.da.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.da.mapper.SampleMapper;
import com.da.model.MemberEntity;
import com.da.model.QMemberEntity;
import com.da.model.QSampleBoard;
import com.da.model.SampleBoard;
import com.da.repository.MemberEntityRepository;
import com.da.repository.SampleBoardRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
public class SampleDao{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	SampleMapper sampleMapper; //MyBatis와 연동하기 위해
	
	@Autowired
	MemberEntityRepository memberEntityRepository; //멤버 VO를 바라보는 Repository를 JPA 자동 완성 쿼리를 사용하기 위해
	
	@Autowired
	SampleBoardRepository sampleBoardRepository; //게시판 VO를 바라보는 Repository를 JPA 자동완성 쿼리를 사용하기 위해
	
	/*
	 * 로그인 기능
	 * param : memId, memPw
	 * return : int (해당 조건으로 조회된 회원의 row 갯수)
	 */
	public int sampleLogin(String memId, String memPw) {
		//QClass에 저장된 MemberEntity Model을 꺼내온다 
		QMemberEntity model = QMemberEntity.memberEntity;
		
		//QueryDsl의 메소드 중 count()이 long 타입으로 리턴을 해서 long으로 count를 받는다
		long result = queryFactory.select(model.count()) //count
				.from(model) //memberEntity를 조회한다
				//QClass가 가지고 있는 memberEntity Model에 저장된 memId와 String으로 화면에서 받아온 memId를 비교한다	
				.where(model.memId.eq(memId) 
						//and 절에서 저장된 memPw와 화면에서 받아온 memPw를 비교한다
						.and(model.memPw.eq(memPw)))
				//결과물 하나만 받아온다
				.fetchOne();
		//long으로 받아온 count를 int로 형변환한다
		int count = (int) result;
		System.out.println("result ========" + result);
		
		/*
		 * MyBais 사용시
		 * int count = sampleMapper.sampleLogin(memId, memPw);
		 */
		
		return count;
	}
	
	/*
	 * 게시판 목록 검색 기능
	 * param : null
	 * return : List (전체 게시판의 목록)
	 */
	public Map<String, Object> searchBoard(Map<String, Object> param) {
		//QClass에 저장된 sampleBoard Model을 꺼내온다 
		QSampleBoard sampleBoard = QSampleBoard.sampleBoard;
		Map<String, Object> result = new HashMap<String, Object>();
		System.out.println("request!!!!!!!!!!!!!!!!!! = " + param);
		int page = Integer.parseInt(String.valueOf(param.get("page")));
		int pageSize = Integer.parseInt(String.valueOf(param.get("pageSize")));
		//리스트 형식으로 결과값을 받아온다
		List<SampleBoard> board = queryFactory.selectFrom(sampleBoard) //select + from을 한줄로 표현하는 표현식
												.orderBy(sampleBoard.bNo.asc())
												.offset((page-1) * pageSize)
												.limit(pageSize)
												.fetch();
		
		Long total = queryFactory.select(sampleBoard.count())
								.from(sampleBoard)
								.fetchOne();
		
		Long totalPage = (total - 1) / pageSize + 1;
		
		result.put("list", board);
		result.put("totalCount", total);
		result.put("totalPage", totalPage);
								
		/*
		 * MyBatis 사용시
		 * List<SampleBoard> result = sampleMapper.searchBoard();
		 */
		
		//결과값의 행이 0보다 크면 결과값을 리턴한다
		if(result.size() > 0) {
			return result;
		}
		return null;
	}
	
	/*
	 * 회원가입 기능
	 * param : MemberEntity
	 * return : int
	 */
	public int insertMem(MemberEntity memberEntity) {
		QMemberEntity search = QMemberEntity.memberEntity;
		//결과값을 비교할 MemberEntity를 null로 초기화해준다
		MemberEntity result = null;
		result = queryFactory.selectFrom(search)
								//화면에서 받아온 회원가입할 Id와 기존에 db에 저장되있는 Id를 비교한다
								.where(search.memId.eq(memberEntity.getMemId()))
								.fetchOne();
		if(result!=null) { //기존에 있는 아이디면 1을 리턴해준다
			return 1;
		}else{ //기존에 없는 아이디면
			//Repository에 save 메소르를 이용하여 화면에서 받아온 회원정보를 저장한다
			result = memberEntityRepository.save(memberEntity);
			if(result.equals(memberEntity)) { //저장한 결과값과 저장할 데이터가 같으면
				logger.info("result===========" + result);
				return 0; //0을 리턴해준다
			}else {
				return 2; //기존에 없는 아이디이지만 저장도 되지 않았으면 2를 리턴해준다
			}
		}
		/*
		 * MyBatis 사용시
		 * result = sampleMapper.insertMem(memberEntity);
		 */
		
		
	}
	
	/*
	 * 게시판 게시물 작성 기능
	 * param : Map(SampleBoard)
	 * return : Map(SampleBoard)
	 */
	public SampleBoard inserBoard(SampleBoard sampleBoard) {
		System.out.println("*******SampleBoard Value :" + sampleBoard);
		//Repository에 있는 save 메소드를 이용하여 쿼리짤 필요없이 화면에서 받아온 게시물 정보를 바로 insert를 해준다
		SampleBoard result = sampleBoardRepository.save(sampleBoard);
		/*
		 * MyBatis 사용시
		 * SamplBoard result = sampleMapper.insertBoard(sampleBoard);
		 */
		if(!result.equals(null)) {
			return result;
		}else {
			return null;
		}
		
		
	}
	
	/*
	 * 게시판 게시물 조회 기능
	 * param : Map(SampleBoard)
	 * return : Map(SampleBoard)
	 */
	public SampleBoard selectBoard(SampleBoard sampleBoard) {
//		QSampleBoard model = QSampleBoard.sampleBoard;
//		SampleBoard result = queryFactory.selectFrom(model)
//											//화면에서 받아온 Model 객채 안에 있는 bNo와 기존에 저장되있는 bNo를 비교한다
//											.where(model.bNo.eq(sampleBoard.getBNo()))
//											.fetchOne();
//		System.out.println("********Result :" + result);
//		/*
//		 * MyBatis 사용시
//		 * SampleBoard result = sampleMapper.selectBoard(sampleBoard);
//		 */
//		return result;
		return null;
	}
	
	public int deleteBoard(String bNo) {
		sampleBoardRepository.deleteById(Integer.parseInt(bNo));
		QSampleBoard model = QSampleBoard.sampleBoard;
		SampleBoard sampleBoard = queryFactory.selectFrom(model)
												//화면에서 받아온 Model 객채 안에 있는 bNo와 기존에 저장되있는 bNo를 비교한다
												.where(model.bNo.eq(Integer.parseInt(bNo)))
												.fetchOne();
		System.out.println("************sampleBoard : " + sampleBoard);
		if(sampleBoard == null) {
			return 0;
		}else {
			return 1;
		}
	}
}

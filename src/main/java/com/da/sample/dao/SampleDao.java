package com.da.sample.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.SampleMapper;
import com.da.model.MemberEntity;
import com.da.model.QMemberEntity;
import com.da.model.QSampleBoard;
import com.da.model.SampleBoard;
import com.da.repository.MemberEntityRepository;
import com.da.repository.SampleBoardRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
public class SampleDao{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory;
	
	@Autowired
	SampleMapper sampleMapper;
	
	@Autowired
	MemberEntityRepository memberEntityRepository;
	
	@Autowired
	SampleBoardRepository sampleBoardRepository;
	
	public int sampleLogin(String memId, String memPw) {
		
		QMemberEntity model = QMemberEntity.memberEntity;
		long result = queryFactory.select(model.count())
				.from(model)
				.where(model.memId.eq(memId)
						.and(model.memPw.eq(memPw)))
				.fetchOne();
		int count = (int) result;
			/*
			 * int result = -1; try { result = sampleMapper.sampleLogin(memId, memPw);
			 * }catch (Exception e) { e.printStackTrace(); return -1; }
			 */
		System.out.println("result ========" + result);
		 
		return count;
	}
	
	public List<SampleBoard> searchBoard() {
		QSampleBoard sampleBoard = QSampleBoard.sampleBoard;
		List<SampleBoard> result = queryFactory.selectFrom(sampleBoard)
												.fetch();
		if(result.size() > 0) {
			return result;
		}
		return null;
	}
	
	public int insertMem(MemberEntity memberEntity) {
		QMemberEntity search = QMemberEntity.memberEntity;
		MemberEntity result = null;
		result = queryFactory.selectFrom(search)
								.where(search.memId.eq(memberEntity.getMemId()))
								.fetchOne();
		if(result!=null) {
			return 1;
		}else{
			result = memberEntityRepository.save(memberEntity);
			if(result.equals(memberEntity)) {
				logger.info("result===========" + result);
				return 0;
			}else {
				return 2;
			}
		}
	}
	
	public SampleBoard inserBoard(SampleBoard sampleBoard) {
		System.out.println("*******SampleBoard Value :" + sampleBoard);
		SampleBoard result = sampleBoardRepository.save(sampleBoard);
		if(!result.equals(null)) {
			return result;
		}else {
			return null;
		}
	}
	
	public SampleBoard selectBoard(SampleBoard sampleBoard) {
		QSampleBoard model = QSampleBoard.sampleBoard;
		SampleBoard result = queryFactory.selectFrom(model)
											.where(model.bNo.eq(sampleBoard.getBNo()))
											.fetchOne();
		System.out.println("********Result :" + result);
		return result;
	}
}

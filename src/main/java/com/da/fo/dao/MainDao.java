package com.da.fo.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.MainMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MainDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	MainMapper mainMapper;
	
	/*
	 * 메인 화면 오픈 시 영역에 보여줄 데이터를 조회한다.
	 * param : null
	 * return : 화면에 보여줄 데이터
	 */
	public Map<String, Object> openMain(Map<String, Object> param){
		Map<String, Object> result = new HashMap<>();
		List mainHotest = mainMapper.mainHotest();
		result.put("mainHotest", mainHotest);
		
		LocalDate now = LocalDate.now();
		param.put("now", now);
		param.put("page", (Integer.parseInt(String.valueOf(param.get("page")))-1)*4);
		param.put("pageSize", Integer.parseInt(String.valueOf(param.get("pageSize"))));
		List todayBid = mainMapper.mainTodayBid(param);
		List insights = mainMapper.mainInsights();
		List newDeal = mainMapper.mainNewDeal();
		List updatedArtist = mainMapper.mainUpdatedArtist();
		result.put("todayBid", todayBid);
		result.put("insights", insights);
		result.put("newDeal", newDeal);
		result.put("updatedArtist", updatedArtist);
		
		return result;
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작가를 조회환다.
	 * param : searchKeyword
	 * return : 작가에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchArtist(String searchKeyword){
		return mainMapper.totalSearchArtist(searchKeyword);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회환다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchWork(Object param){
		return mainMapper.totalSearchWork(param);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회 갯수를 가져온다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public int totalSearchWorkTotalCount(Object param){
		return mainMapper.totalSearchWorkTotalCount(param);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 컨텐츠 정보를 조회한다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchContent(String param){
		return mainMapper.totalSearchContent(param);
	}
	
	/*
	 * 메인 화면에서 통합검색시 작품 정보를 자동완성으로 가져온다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public Map<String,Object> totalSearchAutocomplete(String searchKeyword){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> param = new HashMap<>();
		param.put("searchKeyword", searchKeyword);
		//작품에 관한 정보를 가져온다.
		List work = mainMapper.totalSearchAutocompleteWork(param);
		result.put("work", work);
		//작가에 관한 정보를 가져온다.
		List artist = mainMapper.totalSearchAutocompleteArtist(param);
		result.put("artist", artist);
		//콘텐츠 정보를 가져온다.;
		List content = mainMapper.totalSearchAutocompleteContent(param);
		result.put("content", content);
		
		return result;
	}
	
	/*
	 * 메인 화면 로드시 지금 거래중인 작품 정보를 가져온다.
	 * param : 
	 * return :
	 */
	public List<Map<String, Object>> mainNowDealWorks(){
		List<Map<String, Object>> result = mainMapper.mainNowDealWorks();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 매거진9 정보를 가져온다.
	 * param : 
	 * return :
	 */
	public List<Map<String, Object>> mainMgz9s(){
		List<Map<String, Object>> result = mainMapper.mainMgz9s();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 인기 회원 정보를 가져온다.
	 * param:
	 * return :
	 */
	public List<Map<String, Object>> mainPopularMbr(){
		List<Map<String, Object>> result = mainMapper.mainPopularMbr();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 인기 전시후기/소개 정보를 가져온다.
	 * param:
	 * return :
	 */
	public List<Map<String, Object>> mainPopularExhibit(){
		List<Map<String, Object>> result = mainMapper.mainPopularExhibit();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 자랑하기 정보를 가져온다.
	 * param:
	 * return :
	 */
	public List<Map<String, Object>> mainBoa(){
		List<Map<String, Object>> result = mainMapper.mainBoa();
		return result;
	}
	
	public List<Map<String, Object>> selectBoa(String workSq){
		List<Map<String, Object>> result = mainMapper.selectBoa(workSq);
		return result;
	}
}

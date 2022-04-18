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
		result.put("todayBid", todayBid);
		
		return result;
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작가를 조회환다.
	 * param : searchKeyword
	 * return : 작가에 관한 정보
	 */
	public List totalSearchArtist(String searchKeyword){
		Map<String, Object> param = new HashMap<>();
		param.put("searchKeyword", searchKeyword);
		return mainMapper.totalSearchArtist(param);
	}
	
	/*
	 * 작가 통합검색 결과 카운트
	 * param : searchKeyword
	 * return : 카운트
	 */
	public Map<String, Object> totalSearchArtistCount(String searchKeyword){
		Map<String, Object> param = new HashMap<>();
		param.put("searchKeyword", searchKeyword);
		return mainMapper.totalSearchArtistCount(searchKeyword);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회환다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List totalSearchWork(String searchKeyword){
		Map<String, Object> param = new HashMap<>();
		param.put("searchKeyword", searchKeyword);
		return mainMapper.totalSearchWork(param);
	}
	
	/*
	 * 작품 통합검색 결과 카운트
	 * param : searchKeyword
	 * return : 카운트
	 */
	public Map<String, Object> totalSearchWorkCount(String searchKeyword){
		Map<String, Object> param = new HashMap<>();
		param.put("searchKeyword", searchKeyword);
		return mainMapper.totalSearchWorkCount(searchKeyword);
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
		return result;
	}
}

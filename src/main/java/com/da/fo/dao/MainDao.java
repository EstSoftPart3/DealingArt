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
	 * 메인 화면에서 통합검색으로 작품, 작가, 컨텐츠를 조회환다.
	 * param : searchKeyword
	 * return : 작품, 작가에 관한 정보
	 */
	public Map<String, Object> totalSearch(String searchKeyword){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> param = new HashMap<>();
		param.put("searchKeyword", searchKeyword);
		List artist = mainMapper.totalSearch_artist(param);
		result.put("artist", artist);
		List work = mainMapper.totalSearch_work(param);
		result.put("work", work);
		return result;
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
		List work = mainMapper.totalSearchAutocomplete_work(param);
		result.put("work", work);
		//작가에 관한 정보를 가져온다.
		List artist = mainMapper.totalSearchAutocomplete_artist(param);
		result.put("artist", artist);
		return result;
	}
}

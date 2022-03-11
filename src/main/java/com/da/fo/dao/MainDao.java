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
import com.da.model.QAuctnBid;
import com.da.model.QWork;
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
}

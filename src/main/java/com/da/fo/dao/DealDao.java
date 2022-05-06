package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.ArtistMapper;
import com.da.mapper.DealMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DealDao {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	DealMapper dealMapper;
	
	@Autowired
	ArtistMapper artistMapper;
	
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	public List dealSerach(Map<String, Object> searchOptions){
		List result = dealMapper.dealSerach(searchOptions);
		return result;
	}
	
	/*
	 * 딜 상세 페이지 (응찰하기)
	 * param : workSq
	 * return : 딜 상세 정보
	 */
	public Map<String, Object> dealDetail(String param){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> deal = dealMapper.dealDetail(param);
		result.put("deal", deal);
		if(deal.get("artstSq") != null) {
			Map<String, Object> artistInfo = artistMapper.artistInfo(deal.get("artstSq").toString());
			List eductn = artistMapper.artistInfoEductn(deal.get("artstSq").toString());
			List career = artistMapper.artistInfoCareer(deal.get("artstSq").toString());
			List exhbtn = artistMapper.artistInfoExhbtn(deal.get("artstSq").toString());
			List workList = artistMapper.artistWorkList(deal.get("artstSq").toString());
			result.put("artistInfo", artistInfo);
			result.put("eductn", eductn);
			result.put("career", career);
			result.put("exhbtn", exhbtn);
			result.put("workList", workList);
		}
		return result;
	}
}

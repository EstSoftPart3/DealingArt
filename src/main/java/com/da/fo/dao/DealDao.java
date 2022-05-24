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
		return dealMapper.dealSerach(searchOptions);
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
		if(!deal.get("artstSq").equals(null)) {
			Map<String, Object> artistInfo = artistMapper.artistInfo(deal.get("artstSq").toString());
			List eductn = artistMapper.artistInfoEductn(deal.get("artstSq").toString());
			List career = artistMapper.artistInfoCareer(deal.get("artstSq").toString());
			List exhbtn = artistMapper.artistInfoExhbtn(deal.get("artstSq").toString());
			List workList = artistMapper.artistWorkListAll(deal.get("artstSq").toString());
			result.put("artistInfo", artistInfo);
			result.put("eductn", eductn);
			result.put("career", career);
			result.put("exhbtn", exhbtn);
			result.put("workList", workList);
		}
		return result;
	}
	
	/*
	 * 거래등록
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int dealReg(Object param) {
		int result = dealMapper.dealReg(param);
		if(result > 0) {
			int result2 = dealMapper.updateMbrRefNo();
			return result2;
		}
		return 0;
	}
	
	/*
	 * 응찰 테이블에 응찰 정보 insert
	 * param : dealSq, mbrSq, bidPrc
	 * return : int
	 */
	public int bidReg(Object param) {
		int checkResult = dealMapper.bidRegCheck(param);
		if(checkResult > 0) {
			return -1;
		}else{
			int regResult = dealMapper.bidReg(param);
			regResult += dealMapper.updateDealAuctnPrc(param);
			return regResult;
		}
	}
	
	/*
	 * 작품 상세 페이지 (미판매)
	 * param : workSq
	 * return : 작품 상세 정보
	 */
	public Map<String, Object> workDetail(String param){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> work = dealMapper.workDetail(param);
		result.put("work", work);
		if(!work.get("artstSq").equals(null)) {
			Map<String, Object> artistInfo = artistMapper.artistInfo(work.get("artstSq").toString());
			List eductn = artistMapper.artistInfoEductn(work.get("artstSq").toString());
			List career = artistMapper.artistInfoCareer(work.get("artstSq").toString());
			List exhbtn = artistMapper.artistInfoExhbtn(work.get("artstSq").toString());
			List workList = artistMapper.artistWorkListAll(work.get("artstSq").toString());
			result.put("artistInfo", artistInfo);
			result.put("eductn", eductn);
			result.put("career", career);
			result.put("exhbtn", exhbtn);
			result.put("workList", workList);
		}
		return result;
	}
}

package com.da.fo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.DealDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService{
	@Autowired
	DealDao dealDao;
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	public List dealSerach(Map<String, Object> searchOptions){
		return dealDao.dealSerach(searchOptions);
	}
	
	/*
	 * 딜 상세 페이지 (응찰하기)
	 * param : workSq
	 * return : 딜 상세 정보
	 */
	public Map<String, Object> dealDetail(String param){
		return dealDao.dealDetail(param);
	}
	
	
	/*
	 * 거래등록
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int dealReg(Object param) {
		return dealDao.dealReg(param);
	}
	
	/*
	 * 거래수정
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int dealMod(Object param) {
		return dealDao.dealMod(param);
	}
	
	/*
	 * 응찰 테이블에 응찰 정보 insert
	 * param : dealSq, mbrSq, bidPrc
	 * return : int
	 */
	public int bidReg(Map<String, Object> param) {
		return dealDao.bidReg(param);
	}
	
	/*
	 * 작품 상세 페이지 (미판매)
	 * param : workSq
	 * return : 작품 상세 정보
	 */
	public Map<String, Object> workDetail(String param){
		return dealDao.workDetail(param);
	}
	
	/*
	 * 작품 상세 페이지 (판매완료)
	 * param : workSq
	 * return : 작품 상세 정보
	 */
	public Map<String, Object> soldoutDetail(String param){
		return dealDao.soldoutDetail(param);
	}
	
	/*
	 * 거래 정보 가져오기 (거래 수정)
	 * param : dealSq
	 * return : deal 테이블
	 */
	public Map<String, Object> selectDeal(Object param){
		return dealDao.selectDeal(param);
	}
	
	/*
	 * 거래 중단하기 (거래 삭제)
	 * param : dealSq
	 * return : int
	 */
	public int bidSuspension(Object param){
		return dealDao.bidSuspension(param);
	}
}

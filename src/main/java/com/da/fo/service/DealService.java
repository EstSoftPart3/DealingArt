package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface DealService {
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	List dealSerach(Map<String, Object> searchOptions);
	
	/*
	 * 딜 상세 페이지 (응찰하기)
	 * param : workSq
	 * return : 딜 상세 정보
	 */
	public Map<String, Object> dealDetail(String param);
	
	/*
	 * 거래등록
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int dealReg(Object param);
	
	/*
	 * 응찰 테이블에 응찰 정보 insert
	 * param : dealSq, mbrSq, bidPrc
	 * return : int
	 */
	public int bidReg(Map<String, Object> param);
	
	/*
	 * 작품 상세 페이지 (미판매)
	 * param : workSq
	 * return : 작품 상세 정보
	 */
	public Map<String, Object> workDetail(String param);
}

package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface DealMapper {
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	public List dealSerach(Object param);
	
	/*
	 * 딜 상세페이지 (응찰하기)
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
	 * 거래등록
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int updateMbrRefNo();
	
	/*
	 * 응찰 전 사용자 응찰값과 저장된 응찰가 비교
	 * param : dealSq, mbrSq, bidPrc
	 * return : int
	 */
	public int bidRegCheck(Object param);
	
	/*
	 * 응찰 테이블에 응찰 정보를 insert한다
	 * param : dealSq, mbrSq, bidPrc
	 * return : int
	 */
	public int bidReg(Object param);
	
	/*
	 * 딜 테이블에 응찰 가격을 update한다
	 * param : dealSq, mbrSq, bidPrc
	 * return : int
	 */
	public int updateDealAuctnPrc(Object param);
}

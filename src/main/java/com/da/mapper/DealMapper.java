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
	
	/*
	 * 경매 종료 된 거래 정보를 가져온다
	 * param : null
	 * return : list
	 */
	public List selectSuccessfulBidList();
	
	/*
	 * 경매 종료 된 거래 낙찰자를 가져온다
	 * param : dealSq
	 * return : String
	 */
	public String selectSuccessfulBidBuyMbrSq(Object param);
	
	/*
	 * 경매 종료 된 거래 정보를 딜 테이블에 업데이트한다
	 * param : Map
	 * return : null
	 */
	public void updateSuccessfulBidDeal(Object param);
	
	/*
	 * 작품 상세페이지 (미판매)
	 * param : workSq
	 * return : 작품 상세 정보
	 */
	public Map<String, Object> workDetail(Object param);
	
	/*
	 * 자동응찰 있는지 조회
	 * param : dealSq, bidPrc
	 * return : autoBidPrc
	 */
	public List<Map<String, Object>> selectAutoBid(Object param);
	
	/*
	 * 자동응찰 등록
	 * param : dealSq, mbrSq, autoBidPrc
	 * return : null
	 */
	public void insertAutoBid(Object param);
	
	/*
	 * 자동응찰 최고 금액 조회
	 * param : dealSq, mbrSq
	 * return : maxAutoBidPrc
	 */
	public Long selectMaxAutoBidPrc(Object param);
	
	/*
	 * 자동응찰 빠른 순으로 마지막 입찰자 변경
	 * param : dealSq, bidPrc
	 * return : null
	 */
	public void updateLastBid(Object param);
	
	/*
	 * 응찰내역 가져오기 (응찰히스토리)
	 * param : dealSq
	 * return : bidPrc, bidDate
	 */
	public List selectAuctnBidList(Object param);
	
	/*
	 * 거래 정보 가져오기 (거래 수정)
	 * param : dealSq
	 * return : deal 테이블 정보
	 */
	public Map<String, Object> selectDeal(Object param);
	
	/*
	 * 작품 정보 가져오기 (거래 수정)
	 * param : workSq
	 * return : work 테이블 정보
	 */
	public Map<String, Object> selectWork(Object param);
	
}

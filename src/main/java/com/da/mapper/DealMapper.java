package com.da.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	 * 거래등록 전 중복체크
	 * param : 거래 정보가 담긴 Map
	 * return : int
	 */
	public int dealRegOverlapChk(Object param);
	
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
	 * 경매 시간이 지나서 종료 된 거래 정보를 가져온다
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
	 * 판매 기간 종료된 거래 중 유찰된걸 유찰로 변경한다
	 * param : dealSq
	 * return : null
	 */
	public void updateFailedBidDeal(Object param);
	
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
	
	/*
	 * 거래 완료, 응찰 됬는지 확인
	 * param : dealSq
	 * return : Count
	 */
	public int selectDealSttsCd(Object param);
	
	/*
	 * 거래 중단 (거래 삭제)
	 * param : dealSq
	 * return : null
	 */
	public int deleteDeal(Object param);
	
	/*
	 * 거래 종료된 유찰자 조회
	 * param : dealSq
	 * return : mbrSq
	 */
	public List<Map<String, Object>> selectAuctioneerByMbrSq(@Param("bidDealSq") String dealSq, @Param("bidBuyMbrSq") String mbrSq);
	
	/*
	 * 판매시간이 지나서 종료 된 정찰가 거래 정보를 가져온다
	 * param : null
	 * return : list
	 */
	public List selectNotSoldSaleList();
	
	/*
	 * 구매 확정 처리할 거래 정보와 작품 정보를 조회한다.
	 * param : workSq
	 * return : 작품 정보 / 거래 정보
	 */
	public Map<String, Object> selectWorkAll(Object param);
	
	/*
	 * 구매 확정 처리를 한다
	 * param : dealSq, dealFinalPrc
	 * return : int
	 */
	public int updateDealWorkToPC(Object param);
	
	/*
	 * 구매 확정된 작품을 구매자 소장품으로 등록한다
	 * param : 작품 정보
	 * return : int
	 */
	public int insertCollectionAll(Object param);
}

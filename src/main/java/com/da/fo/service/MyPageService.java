package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface MyPageService {
	/*
	 * 구매자 운송 서비스 운송 타입 업데이트
	 * param : buyTrnsprtTypCd, dealSq
	 * return : int
	 */
	int trnsprtTypCdUpdate(Object param);
	/*
	 * 결제 시, 로그인한 회원의 사용가능한 쿠폰 리스트를 보여준다.
	 * param : mbrSq, cuponTypCd(DD:거래수수료할인/TD:운송수수료할인)
	 * return : 쿠폰목록
	 */
	List myCouponList_payment(Map<String, Object> param);
	
	/*
	 * 쿠폰 화면 오픈 시, 로그인한 회원의 쿠폰 리스트를 보여준다.
	 * param : mbrSq
	 * return : 쿠폰목록
	 */
	List myCouponList(String param);
	
	/*
	 * 쿠폰 등록
	 * param : 쿠폰식별번호, 회원순번
	 * return : 등록 시도 결과 메시지
	 */
	Map<String, String> myRegCoupon(Map<String, Object> param);
	
	/*
	 * 거래내역 화면 오픈 시, 검색 조건 입력 후 조회 시 로그인한 회원의 거래내역 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	List myDealSearchList(Map<String, Object> param);
	
	/*
	 * 나의 소장품 목록
	 * param : mbrSq
	 * return : 소장품 목록이 들어있는 리스트
	 */
	List myCollection(String param);
	
	/*
	 * 소장품 등록
	 * param : 소장품 정보가 들어있는 param
	 * return : int
	 */
	int collectionReg(Map<String, Object> param);
	
	/*
	 * 나의 작품 등록
	 * param : 나의 작품 등록 정보가 들어있는 param
	 * return : int
	 */
	int myWorkReg(Map<String, Object> param);
	
	/*
	 * 나의 작품 리스트
	 * param : mbrSq
	 * return : List
	 */
	List<Map<String, Object>> myWorkList(Map<String, Object> param);
	
	/*
	 * 나의 작품 공개/비공개 설정
	 * parameter : List
	 * return : integer
	 */
	public int myWorkOpenYn(List<Map<String, Object>> param);
	
	/*
	 * 나의 작품 삭제 처리
	 * parameter : List
	 * return : integer
	 */
	public int myWorkDelYn(List<String> param);
	
	/*
	 * 나의 작품 판매중단 처리
	 * parameter : List
	 * return : List
	 */
	public List<Map<String, Object>> myWorkDealDelete(List<String> param);
	
	/*
	 * 나의 작품 리스트
	 * param : artstSq
	 * return : List
	 */
	List myWork(String param);
	
	/*
	 * 나의 작품 수정 페이지 오픈
	 * param : workSq
	 * return : Map
	 */
	Map<String, Object> myWorkMod(String param);
	
	/*
	 * 나의 작품 수정 등록
	 * param : 나의 작품 등록 정보가 들어있는 param
	 * return : int
	 */
	int myWorkCor(Map<String, Object> param);
	
	/*
	 * 소장품 수정 페이지 오픈
	 * param : workSq
	 * return : Map
	 */
	Map<String, Object> myCollectionMod(String param);
	
	/*
	 * 나의 소장품 수정 등록
	 * param : 나의 소장품 등록 정보가 들어있는 param
	 * return : int
	 */
	int collectionCor(Map<String, Object> param);
	
	/*
	 * 스크랩 목록
	 * param : mbrSq
	 * return : 스크랩 목록이 들어있는 List
	 */
	List<Map<String, Object>> scrapList(String param);
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetailBuy(String dealSq, String mbrSq);
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetailSell(String dealSq, String mbrSq);
	
	/*
	 * 운송 옵션 가격, 코드 네임 조회
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 운송 가격, 코드 네임
	 */
	public List<Map<String, Object>> selectTrnsprtInfo(Map<String, Object> param);
	
	/*
	 * 거래내역 응찰 히스토리 가져오기
	 * param : deslSq
	 * return : bidDate, bidPrc
	 */
	public List<Map<String, Object>> myDealListBidHistory(Object param);	
	
	/*
	 * 운송 테이블에 판매자 운송 정보 입력
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 
	 */
	public int insertTrnsprt(List<Map<String, Object>> param);
	
	//나의작품 / 소장품 거래등록 확인
	public int dealWorkCount(Map<String, Object> param);
	
	/* 소장품 삭제 선택시 거래 등록 여부 확인
	 * param : workSq
	 * return : 
	 */
	public int dealCheck(String workSq);
	
	/* 소장품 삭제
	 * param : workSq
	 * return : 
	 */
	public int delCollection(String workSq);
}

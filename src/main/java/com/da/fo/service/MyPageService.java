package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface MyPageService {
	
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
	List<String> scrapList(String param);
	
	/*
	 * 1차 결제 결제정보
	 * param : dealSq, mbrSq
	 * return : 결제에 필요한 정보
	 */
	public Map<String, Object> openPaymentBuyer(Map<String, Object> param);
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetail(String dealSq, String mbrSq);
}

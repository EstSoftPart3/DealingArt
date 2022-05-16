package com.da.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MyPageMapper {
	/*
	 * 거래내역 화면 오픈 시, 검색 조건 입력 후 조회 시 로그인한 회원의 거래내역 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchList(Object param);
	
	/*
	 * 나의 소장품 목록
	 * param : mbrSq
	 * return : 소장품 목록이 들어있는 리스트
	 */
	public List myCollectionSale(String param);
	
	/*
	 * 나의 소장품 목록
	 * param : mbrSq
	 * return : 소장품 목록이 들어있는 리스트
	 */
	public List myCollectionNonSale(String param);
	
	/*
	 * 소장품 등록
	 * param : 소장품 정보가 들어있는 param
	 * return : int
	 */
	public int collectionReg(Map<String, Object> param);
	
	/*
	 * 등록된 소장품의 키워드 등록
	 * param : 소장품 정보가 들어있는 param
	 * return : int
	 */
	public int keywrdReg(Map<String, Object> param);
	
	/*
	 * 나의 작품 등록
	 * param : 나의 작품 정보가 들어있는 param
	 * return : int
	 */
	public int myWorkReg(Map<String, Object> param);
	
	/*
	 * 나의 작품 리스트
	 * param : 나의 작품 정보가 들어있는 param
	 * return : List
	 */
	public List myWorkListSale(String param);
	
	/*
	 * 나의 작품 리스트
	 * param : 나의 작품 정보가 들어있는 param
	 * return : List
	 */
	public List myWorkListNonSale(Object param);
	
	/*
	 * 나의 작품 수정
	 * param : 나의 작품 정보가 들어있는 param
	 * return : Map
	 */
	public Map<String, Object> myWorkMod(String param);
	
	/*
	 * 나의 작품 수정 등록
	 * param : 나의 작품 등록 정보가 들어있는 param
	 * return : int
	 */
	public int myWorkCor(Map<String, Object> param);
	
	/*
	 * 키워드 수정 등록
	 * param : 키워드 등록 정보가 들어있는 param
	 * return : int
	 */
	public int keywrdCor(Map<String, Object> param);
	
	/*
	 * 소장품 수정 페이지 오픈
	 * param : workSq
	 * return : Map
	 */
	public Map<String, Object> myCollectionMod(String param);
	
	/*
	 * 나의 소장품 수정 등록
	 * param : 나의 소장품 등록 정보가 들어있는 param
	 * return : int
	 */
	public int collectionCor(Map<String, Object> param);
	
	/*
	 * 스크랩 목록 조회
	 * param : mbrSq
	 * return : 스크랩 목록이 들어있는 List
	 */
	public List<String> scrapList(String param);
	
	/*
	 * 판매중이 아닌 스크랩 목록
	 * param : 스크랩한 작품 번호가 들어있는 List
	 * return : 스크랩 목록이 들어있는 List
	 */
	public List<String> scrapListNonSale(List<String> param);
	
	/*
	 * 판매중인 스크랩 목록
	 * param : 스크랩한 작품 번호가 들어있는 List
	 * return : 스크랩 목록이 들어있는 List
	 */
	public List<String> scrapListSale(List<String> param);
	
	/*
	 * 구매 결제 상태 변경
	 * param : dealSq
	 * return : int
	 */
	public int updateBuyPaymntSttsCd(@Param("dealSq") String dealSq, @Param("dealSttsCd")String dealSttsCd);
	
	/*
	 * 판매 결제 상태 변경
	 * param : dealSq
	 * return : int
	 */
	public int updateSellPaymntSttsCd(@Param("dealSq") String dealSq, @Param("dealSttsCd")String dealSttsCd);
	
	/*
	 * 1차 결제 정보 조회
	 * param : dealSq
	 * return : 결재 정보
	 */
	public Map<String, Object> getPaymentDealInfo(String param);
	
	/*
	 * 결제 구매자/배송정보 조회
	 * param : mbrSq
	 * return : 회원 정보
	 */
	public Map<String, Object> getPaymentBuyerInfo(String param);
	
	/*
	 * 결제 상세페이지 상품 정보 조회
	 * param : dealSq
	 * return : 상품 정보 조회
	 */
	public Map<String, Object> getMyDealDetailDealInfo(String param);
	
}

package com.da.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MyPageMapper {
	
	/*
	 * 구매자 운송 서비스 운송 타입 업데이트
	 * param : buyTrnsprtTypCd, dealSq
	 * return : int
	 */
	public int trnsprtTypCdUpdate(Object param);
	
	/*
	 * 결제 시, 로그인한 회원의 사용가능한 쿠폰 리스트를 보여준다.
	 * param : mbrSq, cuponTypCd(DD:거래수수료할인/TD:운송수수료할인)
	 * return : 쿠폰목록
	 */
	public List myCouponList_payment(Object param);
	
	/*
	 * 쿠폰 화면 오픈 시, 로그인한 회원의 쿠폰 리스트를 보여준다.
	 * param : mbrSq
	 * return : 쿠폰목록
	 */
	public List myCouponList(String param);
	
	/*
	 * 쿠폰식별번호 조회
	 * param : cuponIdntfctnNum
	 * return : 쿠폰 목록이 들어있는 리스트
	 */
	public Map<String, Object> searchCuponIdntfctnNum(Object param);
	
	/*
	 * 쿠폰중복등록 카운트
	 * param : cuponSq, mbrSq
	 * return : 쿠폰중복등록 카운트
	 */
	public int cntCouponOverlap(Object param);
	
	/*
	 * 쿠폰 등록
	 * param : cuponSq, mbrSq
	 * return : 쿠폰 등록
	 */
	public int insertCouponReg(Object param);
	
	/*
	 * 쿠폰 발급 중지
	 * param : cuponIdntfctnNum, endDate
	 * return : 쿠폰 등록
	 */
	public int cuponStop(Object param);
	
	/*
	 * 거래내역 정찰가 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchListSale(Object param);
	
	
	/*
	 * 거래내역 정찰가 가상계좌 입금전 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchListVACCT(Object param);
	
	/*
	 * 거래내역 구매 경매 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchListAuctionBuy(Object param);
	
	/*
	 * 거래내역 판매 경매 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchListAuctionSell(Object param);
	
	/*
	 * 나의 소장품 판매중인 것 목록
	 * param : mbrSq
	 * return : 소장품 목록이 들어있는 리스트
	 */
	public List myCollectionSale(String param);
	
	/*
	 * 나의 소장품 판매중이 아닌 것목록
	 * param : mbrSq
	 * return : 소장품 목록이 들어있는 리스트
	 */
	public List myCollectionNonSale(Object param);
	
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
	 * param : mbrSq
	 * return : List
	 */
	public List<Map<String, Object>> myWorkList(Map<String, Object> param);
	
	/*
	 * 나의 작품 공개/비공개 설정
	 * param : List
	 * return : int
	 */
	public int myWorkOpenYn(List<Map<String, Object>> param);
	
	/*
	 * 나의 작품 삭제 처리
	 * param : List
	 * return : int
	 */
	public int myWorkDelYn(List<String> param);
	
	/*
	 * 나의 작품 판매중 리스트
	 * param : 나의 작품 정보가 들어있는 param
	 * return : List
	 */
	public List myWorkListSale(String param);
	
	/*
	 * 나의 작품 판매중 아닌 것 리스트
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
	public List<Map<String, Object>> scrapListNonSale(Object param);
	
	/*
	 * 판매중인 스크랩 목록
	 * param : 스크랩한 작품 번호가 들어있는 List
	 * return : 스크랩 목록이 들어있는 List
	 */
	public List<Map<String, Object>> scrapListSale(Object param);
	
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
	 * 결제 정보 조회
	 * param : dealSq
	 * return : 결재 정보
	 */
	public Map<String, Object> getPaymentDealInfo(String param);
	
	/*
	 * 결제 구매자/배송정보 조회
	 * param : mbrSq
	 * return : 회원 정보
	 */
	public Map<String, Object> getPaymentDeliveryInfo(String param);
	
	/*
	 * 구매자 결제 상세페이지 상품 정보 조회
	 * param : dealSq
	 * return : 상품 정보 조회
	 */
	public Map<String, Object> getMyDealDetailDealInfoBuy(String param);
	
	/*
	 * 판매자 결제 상세페이지 상품 정보 조회
	 * param : dealSq
	 * return : 상품 정보 조회
	 */
	public Map<String, Object> getMyDealDetailDealInfoSell(String param);
	
	/*
	 * 운송 옵션 가격 조회
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 운송 옵션 가격
	 */
	public String selectTrnsprtPrc(Object param);
	
	/*
	 * 운송 옵션 코드 네임 조회
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 운송 옵션 코드 네임
	 */
	public Map<String, Object> selectTrnsprtCdNm(Object param);
	
	/*
	 * 운송 선택 옵션 이름, 값 조회
	 * param : trnsprtDivCd trnsprtTypCd trnsprtReqYn
	 * return : 운송 옵션 코드 네임
	 */
	public List<Map<String, Object>> selectTrnsprtInfo(Object param);
	
	/*
	 * 운송 테이블에 판매자 운송 정보 입력
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 
	 */
	public int insertTrnsprt(Object param);
	
	/*
	 * 거래 내역 조회
	 * param : mbrSq, dealSq
	 * return : 
	 */
	public Map<String, Object> selectPaymntBuy1(@Param("dealSq") String dealSq, @Param("mbrSq") String mbrSq);
	
	/*
	 * 거래 내역 조회
	 * param : mbrSq, dealSq
	 * return : 
	 */
	public Map<String, Object> selectPaymntBuy2(@Param("dealSq") String dealSq, @Param("mbrSq") String mbrSq);
	
	/*
	 * 거래 내역 조회
	 * param : mbrSq, dealSq
	 * return : 
	 */
	public Map<String, Object> selectPaymntSell(@Param("dealSq") String dealSq, @Param("mbrSq") String mbrSq);
	
	/*
	 * 운송 테이블에 저장하기 위해 해당 운송 정보 가져오기
	 * param : trnsprtServiceCdNm, trnsprtPrc
	 * return : 
	 */
	public Map<String, Object> getTrnsprt(Object param);
	
	/*
	 * 거래내역 운송 정보를 가져온다
	 * param : dealSq, mbrSq
	 * return : 운송 정보
	 */
	public List selectTrnsprtInfoBuy(@Param("dealSq") String dealSq, @Param("mbrSq") String mbrSq);
	
	/*
	 * 거래내역 운송 정보를 가져온다
	 * param : dealSq, mbrSq
	 * return : 운송 정보
	 */
	public List selectTrnsprtInfoSell(@Param("dealSq") String dealSq, @Param("mbrSq") String mbrSq);
	
	/*
	 * 거래내역 정산 정보를 가져온다
	 * param : dealSq, mbrSq
	 * return : 운송 정보
	 */
	public Map<String, Object> selectCalcInfo(@Param("dealSq") String dealSq, @Param("mbrSq") String mbrSq);
	
	//나의작품 / 소장품 거래등록 확인
	public int dealWorkCount(Map<String, Object> param);
	
	/*
	 * 부가서비스 결제 시 쿠폰 적용된 할인 금액을 가져온다
	 * param : 	cuponDiscAmt cuponNm cuponSqcuponTypCd discTypCd cuponDetailCd trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 쿠폰 적용 된 부가서비스 별 금액
	 */
	public List<Map<String, Object>> applyCupon(Object param);
	
	/*
	 * 부가서비스 결제 시 쿠폰 적용된 총 할인 금액을 가져온다
	 * param : 	cuponDiscAmt cuponNm cuponSqcuponTypCd discTypCd cuponDetailCd trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 총 결제 금액
	 */
	public Long applyCuponTotal(Object param);
	
	/*
	 * 부가서비스 결제 시 쿠폰 적용 전 총 할인 금액을 가져온다
	 * param : 	cuponDiscAmt cuponNm cuponSqcuponTypCd discTypCd cuponDetailCd trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 총 결제 금액
	 */
	public Long beforeApplyCupon(Object param);

	/*
	 * 소장품 삭제 선택시 거래 등록 여부 확인
	 * param : workSq
	 * return :
	 */
	public int dealCheck(String workSq);
	
	/*
	 * 소장품 삭제
	 * param : workSq
	 * return :
	 */
	public int delCollection(String workSq);
	
	/*
	 * 작가 정보
	 * param : mbrSq, artstSq
	 * return :
	 */
	public Map<String, Object> getArtstInfo(Object param);
	
}

package com.da.fo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.MyPageDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyPageServiceImpl implements MyPageService{
	
	@Autowired
	private MyPageDao myPageDao;
	
	/*
	 * 마이페이지 메인 회원정보 조회
	 * param : mbrSq
	 * return : Map
	 */
	public Map<String, Object> myPageMain_myInfo(Object param){
		return myPageDao.myPageMain_myInfo(param);
	}
	
	/*
	 * 마이페이지 메인 나의 작품 조회
	 * param : mbrSq
	 * return : List
	 */
	public List<Map<String, Object>> myPageMain_myWorks(Object param){
		return myPageDao.myPageMain_myWorks(param);
	}
	
	/*
	 * 마이페이지 메인 나의 작품 총 갯수 조회
	 * param : mbrSq
	 * return : int
	 */
	public int myPageMain_myWorksTotal(Object param){
		return myPageDao.myPageMain_myWorksTotal(param);
	}
	
	/*
	 * 마이페이지 메인 나의 커뮤니티 조회
	 * param : Map
	 * return : Map
	 */
	public List<Map<String, Object>> myPageMain_myCommunitys(Object param){
		return myPageDao.myPageMain_myCommunitys(param);
	}
	
	/*
	 * 마이페이지 메인 나의 커뮤니티 총 갯수 조회
	 * param : Map
	 * return : int
	 */
	public int myPageMain_myCommunitysTotal(Object param){
		return myPageDao.myPageMain_myCommunitysTotal(param);
	}
	
	/*
	 * 구매자 운송 서비스 운송 타입 업데이트
	 * param : buyTrnsprtTypCd, dealSq
	 * return : int
	 */
	public int trnsprtTypCdUpdate(Object param) {
		return myPageDao.trnsprtTypCdUpdate(param);
	}
	
	/*
	 * 결제 시, 로그인한 회원의 사용가능한 쿠폰 리스트를 보여준다.
	 * param : mbrSq, cuponTypCd(DD:거래수수료할인/TD:운송수수료할인)
	 * return : 쿠폰목록
	 */
	public List myCouponList_payment(Map<String, Object> param) {
		return myPageDao.myCouponList_payment(param);
	}
	
	/*
	 * 쿠폰 화면 오픈 시, 로그인한 회원의 쿠폰 리스트를 보여준다.
	 * param : mbrSq
	 * return : 쿠폰목록
	 */
	public List myCouponList(String param) {
		return myPageDao.myCouponList(param);
	}
	
	/*
	 * 쿠폰 등록
	 * param : 쿠폰식별번호, 회원순번
	 * return : 등록 시도 결과 메시지
	 */
	public Map<String, String> myRegCoupon(Map<String, Object> param) {
		
		Map<String, String> result = new HashMap<String, String>();
		
		//쿠폰식별번호 조회 searchCuponIdntfctnNum
		Map<String, Object> cuponMap = myPageDao.searchCuponIdntfctnNum(param);
		//List<Map<String, Object>> listMap = cuponList; 
		
		if(cuponMap != null) {
			
			String cuponSq = cuponMap.get("cuponSq").toString(); //쿠폰순번
			//int diffDay = Integer.parseInt(cuponMap.get("diffDay").toString()); //쿠폰 사용기한
			
			param.put("cuponSq", cuponSq);
			param.put("useStrtDt", cuponMap.get("useStrtDt").toString());
			param.put("useEndDt", cuponMap.get("useEndDt").toString());
			//쿠폰 중복등록 카운트 조회
			int overlapCnt = myPageDao.cntCouponOverlap(param);
			
			if(overlapCnt > 0){
				result.put("msg", "이전에 등록한 쿠폰입니다.");
			}else{
				
//				if(diffDay > 0) {
//					result.put("msg", "사용기한이 지난 쿠폰입니다.");
//				} else {
					//쿠폰 등록
					if(myPageDao.insertCouponReg(param) > 0) {
						result.put("msg", "쿠폰이 등록되었습니다.");
					} else {
						result.put("msg", "쿠폰 등록에 실패하였습니다.");
					}
				//}
			}
		}else{//등록 불가능한 쿠폰인 경우
			result.put("msg", "존재하지 않는 쿠푠입니다.");
		}
		
		return result;
	}
	
	/*
	 * 거래내역 화면 오픈 시, 검색 조건 입력 후 조회 시 로그인한 회원의 거래내역 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchList(Map<String, Object> param) {
		return myPageDao.myDealSearchList(param);
	}

	/*
	 * 소장품 등록
	 * param : 소장품 정보가 들어있는 param
	 * return : int
	 */
	public int collectionReg(Map<String, Object> param) {
		return myPageDao.collectionReg(param);
	}
	
	/*
	 * 나의 소장품 목록
	 * param : mbrSq
	 * return : 소장품 목록이 들어있는 리스트
	 */
	public List myCollection(String param) {
		return myPageDao.myCollection(param);
	}
	
	/*
	 * 나의 작품 등록
	 * param : 나의 작품 정보가 들어있는 param
	 * return : int
	 */
	public int myWorkReg(Map<String, Object> param) {
		return myPageDao.myWorkReg(param);
	}
	
	/*
	 * 나의 작품 리스트
	 * param : mbrSq
	 * return : List
	 */
	public List<Map<String, Object>> myWorkList(Map<String, Object> param) {
		return myPageDao.myWorkList(param);
	}
	
	/*
	 * 나의 작품 공개/비공개 설정
	 * parameter : List
	 * return : integer
	 */
	public int myWorkOpenYn(List<Map<String, Object>> param) {
		return myPageDao.myWorkOpenYn(param);
	}
	
	/*
	 * 나의 작품 삭제 처리
	 * parameter : List
	 * return : integer
	 */
	public int myWorkDelYn(List<Map<String, Object>> param) {
		return myPageDao.myWorkDelYn(param);
	}
	
	/*
	 * 나의 작품 판매중단 처리
	 * parameter : List
	 * return : List
	 */
	public List<Map<String, Object>> myWorkDealDelete(List<String> param) {
		return myPageDao.myWorkDealDelete(param);
	}
	
	/*
	 * 나의 작품 리스트
	 * param : artstSq
	 * return : List
	 */
	public List myWork(String param) {
		return myPageDao.myWork(param);
	}
	
	/*
	 * 나의 작품 수정 페이지 오픈
	 * param : workSq
	 * return : Map
	 */
	public Map<String, Object> myWorkMod(String param){
		return myPageDao.myWorkMod(param);
	}
	
	/*
	 * 나의 작품 수정 등록
	 * param : 나의 작품 등록 정보가 들어있는 param
	 * return : int
	 */
	public int myWorkCor(Map<String, Object> param) {
		return myPageDao.myWorkCor(param);
	}
	
	/*
	 * 소장품 수정 페이지 오픈
	 * param : workSq
	 * return : Map
	 */
	public Map<String, Object> myCollectionMod(String param){
		return myPageDao.myCollectionMod(param);
	}
	
	/*
	 * 나의 소장품 수정 등록
	 * param : 나의 소장품 등록 정보가 들어있는 param
	 * return : int
	 */
	public int collectionCor(Map<String, Object> param) {
		return myPageDao.collectionCor(param);
	}
	
	/*
	 * 스크랩 목록
	 * param : mbrSq
	 * return : 스크랩 목록이 들어있는 List
	 */
	public List<Map<String, Object>> scrapList(String param){
		return myPageDao.scrapList(param);
	}
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetailBuy(String dealSq, String mbrSq){
		return myPageDao.openMyDealDetailBuy(dealSq, mbrSq);
	}
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetailSell(String dealSq, String mbrSq){
		return myPageDao.openMyDealDetailSell(dealSq, mbrSq);
	}
	
	/*
	 * 운송 옵션 가격, 코드 네임 조회
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 운송 가격, 코드 네임
	 */
	public List<Map<String, Object>> selectTrnsprtInfo(Map<String, Object> param){
		return myPageDao.selectTrnsprtInfo(param);
	}
	
	/*
	 * 거래내역 응찰 히스토리 가져오기
	 * param : deslSq
	 * return : bidDate, bidPrc
	 */
	public List<Map<String, Object>> myDealListBidHistory(Object param){
		return myPageDao.myDealListBidHistory(param);
	}
	
	/*
	 * 운송 테이블에 판매자 운송 정보 입력
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 
	 */
	public int insertTrnsprt(List<Map<String, Object>> param) {
		return myPageDao.insertTrnsprt(param);
	}
	
	//나의작품 / 소장품 거래등록 확인
	@Override
	public int dealWorkCount(Map<String, Object> param){
		
		int dealWorkCount = myPageDao.dealWorkCount(param);
		
		return dealWorkCount;
	}
	
	/*
	 * 소장품 삭제 선택시 거래 등록 여부 확인
	 * param : workSq
	 * return :
	 */
	@Override
	public int dealCheck (String workSq) {
		int result;
		result = myPageDao.dealCheck(workSq);
		return result;
	}
	
	/*
	 * 소장품 삭제
	 * param : workSq
	 * return :
	 */
	@Override
	public int delCollection(Map<String, Object> param) {
		int result = myPageDao.delCollection(param);
		return result;
	}
	
	/* 작품, 자랑하기 등록
	 * param : 
	 * return : 
	 */
	@Override
	public int regWorkAndComtBoa(Map<String, Object> param) {
		int result = myPageDao.regWorkAndComtBoa(param);
		return result;
	}
	
	/* 커뮤니티 등록
	 * param :
	 * return :
	 */
	public int myComtReg(Map<String, Object> param) {
		return myPageDao.myComtReg(param);
	}
}

package com.da.fo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.DealMapper;
import com.da.mapper.MemberMapper;
import com.da.mapper.MyPageMapper;
import com.da.util.CommonService;

@Repository
public class MyPageDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyPageMapper myPageMapper;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private DealMapper dealMapper;
	
	/*
	 * 구매자 운송 서비스 운송 타입 업데이트
	 * param : buyTrnsprtTypCd, dealSq
	 * return : int
	 */
	public int buyTrnsprtTypCdUpdate(Object param) {
		return myPageMapper.buyTrnsprtTypCdUpdate(param);
	}
	
	/*
	 * 결제 시, 로그인한 회원의 사용가능한 쿠폰 리스트를 보여준다.
	 * param : mbrSq, cuponTypCd(DD:거래수수료할인/TD:운송수수료할인)
	 * return : 쿠폰목록
	 */
	public List myCouponList_payment(Map<String, Object> param) {
		return myPageMapper.myCouponList_payment(param);
	}
	
	/*
	 * 쿠폰 화면 오픈 시, 로그인한 회원의 쿠폰 리스트를 보여준다.
	 * param : mbrSq
	 * return : 쿠폰목록
	 */
	public List myCouponList(String param) {
		return myPageMapper.myCouponList(param);
	}
	
	/*
	 * 쿠폰식별번호 조회
	 * param : cuponIdntfctnNum
	 * return : 쿠폰 목록이 들어있는 리스트
	 */
	public Map<String, Object> searchCuponIdntfctnNum(Map<String, Object> param){
		return myPageMapper.searchCuponIdntfctnNum(param);
	}
	
	/*
	 * 쿠폰중복등록 카운트
	 * param : cuponSq, mbrSq
	 * return : 쿠폰중복등록 카운트
	 */
	public int cntCouponOverlap(Map<String, Object> param){
		return myPageMapper.cntCouponOverlap(param);
	}
	
	/*
	 * 쿠폰 등록
	 * param : cuponSq, mbrSq
	 * return : 쿠폰 등록
	 */
	public int insertCouponReg(Map<String, Object> param){
		return myPageMapper.insertCouponReg(param);
	}
	
	/*
	 * 거래내역 화면 오픈 시, 검색 조건 입력 후 조회 시 로그인한 회원의 거래내역 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchList(Map<String, Object> param) {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		if(param.get("saleOrAuction").toString().equals("ALL")){
			if(param.get("buyOrSell").toString().equals("ALL")){
				List<Map<String, Object>> resultSale = myPageMapper.myDealSearchListSale(param);
				List<Map<String, Object>> resultVACCT = myPageMapper.myDealSearchListVACCT(param);
				List<Map<String, Object>> resultAuctionBuy = myPageMapper.myDealSearchListAuctionBuy(param);
				List<Map<String, Object>> resultAuctionSell = myPageMapper.myDealSearchListAuctionSell(param);
				result = Stream.concat(resultAuctionBuy.stream(), resultAuctionSell.stream()).collect(Collectors.toList());
				result = Stream.concat(result.stream(), resultSale.stream()).collect(Collectors.toList());
				result = Stream.concat(result.stream(), resultVACCT.stream()).collect(Collectors.toList());
			}
			if(param.get("buyOrSell").toString().equals("BUY")){
				List<Map<String, Object>> resultSale = myPageMapper.myDealSearchListSale(param);
				List<Map<String, Object>> resultVACCT = myPageMapper.myDealSearchListVACCT(param);
				List<Map<String, Object>> resultAuctionBuy = myPageMapper.myDealSearchListAuctionBuy(param);
				result = Stream.concat(resultSale.stream(), resultAuctionBuy.stream()).collect(Collectors.toList());
				result = Stream.concat(resultVACCT.stream(), result.stream()).collect(Collectors.toList());
			}
			if(param.get("buyOrSell").toString().equals("SELL")){
				List<Map<String, Object>> resultSale = myPageMapper.myDealSearchListSale(param);
				List<Map<String, Object>> resultVACCT = myPageMapper.myDealSearchListVACCT(param);
				List<Map<String, Object>> resultAuctionSell = myPageMapper.myDealSearchListAuctionSell(param);
				result = Stream.concat(resultSale.stream(), resultAuctionSell.stream()).collect(Collectors.toList());
				result = Stream.concat(result.stream(), resultVACCT.stream()).collect(Collectors.toList());
			}
		}
		if(param.get("saleOrAuction").toString().equals("SALE")){
			List<Map<String, Object>> resultSale = myPageMapper.myDealSearchListSale(param);
			List<Map<String, Object>> resultVACCT = myPageMapper.myDealSearchListVACCT(param);
			result = Stream.concat(resultSale.stream(), resultVACCT.stream()).collect(Collectors.toList());
		}
		if(param.get("saleOrAuction").toString().equals("AUCTN")){
			if(param.get("buyOrSell").toString().equals("ALL")){
				List<Map<String, Object>> resultAuctionBuy = myPageMapper.myDealSearchListAuctionBuy(param);
				List<Map<String, Object>> resultAuctionSell = myPageMapper.myDealSearchListAuctionSell(param);
				result = Stream.concat(resultAuctionBuy.stream(), resultAuctionSell.stream()).collect(Collectors.toList());
			}
			if(param.get("buyOrSell").toString().equals("BUY")){
				result = myPageMapper.myDealSearchListAuctionBuy(param);
			}
			if(param.get("buyOrSell").toString().equals("SELL")){
				result = myPageMapper.myDealSearchListAuctionSell(param);
			}
		}
		return result;
	}
	
	/*
	 * 나의 소장품 목록
	 * param : mbrSq
	 * return : 소장품 목록이 들어있는 리스트
	 */
	public List myCollection(String param) {
		List<Map<String, Object>> resultSale = myPageMapper.myCollectionSale(param);
		Map<String, Object> paramMap = new HashMap<>();
		List<String> workSq = new ArrayList<String>();
		//List<String> dealSq = new ArrayList<String>();
		if(resultSale.size() > 0) {
			for(int i=0; i<resultSale.size(); i++) {
				workSq.add(resultSale.get(i).get("workSq").toString());
				//dealSq.add(resultSale.get(i).get("dealSq").toString());
			}
		}
		paramMap.put("workSq", workSq);
		//paramMap.put("dealSq", dealSq);
		paramMap.put("mbrSq", param);
		List<Map<String, Object>> resultNonSale = myPageMapper.myCollectionNonSale(paramMap);
		List<Map<String, Object>> result = Stream.concat(resultSale.stream(), resultNonSale.stream()).collect(Collectors.toList());
		return result;
	}
	
	/*
	 * 소장품 등록
	 * param : 소장품 정보가 들어있는 param
	 * return : int
	 */
	public int collectionReg(Map<String, Object> param) {
		int result = -1;
		result = myPageMapper.collectionReg(param);
		//박상현 : 결과값 1 이면 소장품이 정상등록 되어 있고 키워드가 등록 되어져 있다면
		//키워드를 등록해라
		if(result == 1) {
			if(param.get("keywrd") != null && param.get("keywrd") != "") {
				result = myPageMapper.keywrdReg(param);
			}
		}
		return result;
	}
	
	/*
	 * 나의 작품 등록
	 * param : 나의 작품 정보가 들어있는 param
	 * return : int
	 */
	public int myWorkReg(Map<String, Object> param) {
		int result = -1;
		Map<String, Object> artstInfo = myPageMapper.getArtstInfo(param);
		param.put("artstActvtyNm", artstInfo.get("artstActvtyNm"));
		param.put("artstBirthYear", artstInfo.get("artstBirthYear"));
		if(artstInfo.get("artstEnglsNm") != null) {
			param.put("artstEnglsNm", artstInfo.get("artstEnglsNm"));
		}
		if(artstInfo.get("artstYod") != null) {
			param.put("artstYod", artstInfo.get("artstYod"));
		}
		result = myPageMapper.myWorkReg(param);
		if(result == 1) {
			if(param.get("keywrd") != null && param.get("keywrd") != "") {
				result = myPageMapper.keywrdReg(param);
			}
		}
		return result;	
	}
	/*
	 * 나의 작품 리스트
	 * param : mbrSq
	 * return : List
	 */
	public List<Map<String, Object>> myWorkList(Map<String, Object> param){
		return myPageMapper.myWorkList(param);
	}
	
	/*
	 * 나의 작품 공개/비공개 설정
	 * parameter : List
	 * return : integer
	 */
	public int myWorkOpenYn(List<Map<String, Object>> param) {
		return myPageMapper.myWorkOpenYn(param);
	}
	
	/*
	 * 나의 작품 삭제 처리
	 * parameter : List
	 * return : integer
	 */
	public int myWorkDelYn(List<String> param) {
		return myPageMapper.myWorkDelYn(param);
	}
	
	/*
	 * 판매중인 작품 판매 중단
	 * parameter : List
	 * return : List
	 */
	public List<Map<String, Object>> myWorkDealDelete(List<String> param) {
		//판매 중단에 실패한 dealSq List
		List<String> failedList = new ArrayList<String>();
		
		for(int i=0; i<param.size(); i++) {
			String dealSq = param.get(i);
			//판매되었거나 응찰되었는지 확인
			int failed = dealMapper.selectDealSttsCd(dealSq);
			//판매되었거나 응찰되었으면
			if(failed > 0) {
				//판매 중단에 실패한 dealSq List에 dealSq를 담는다
				failedList.add(dealSq);
			}else{
				//판매 중단 처리를 한다
				dealMapper.deleteDeal(dealSq);
			}
		}
		//판매 중단에 실패한 dealSq가 존재하면
		if(failedList.size() > 0) {
			List<Map<String, Object>> failed = new ArrayList<Map<String,Object>>();
			for(int i=0; i<failedList.size(); i++) {
				Map<String, Object> result = dealMapper.deleteDealFailedList(failedList.get(i));
				failed.add(result);
			}
			return failed;
		}else{
			List<Map<String, Object>> success = new ArrayList<Map<String,Object>>();
			return success;
		}
	}
	
	/*
	 * 나의 작품 리스트
	 * param : 나의 작품 정보가 들어있는 param
	 * return : List
	 */
	public List myWork(String param) {
		List<Map<String, Object>> resultSale = myPageMapper.myWorkListSale(param);
		Map<String, Object> paramMap = new HashMap<>();
		List<String> workSq = new ArrayList<String>();
		//List<String> dealSq = new ArrayList<String>();
		if(resultSale.size() > 0) {
			for(int i=0; i<resultSale.size(); i++) {
				workSq.add(resultSale.get(i).get("workSq").toString());
			}
		}
		//paramMap.put("dealSq", dealSq);
		paramMap.put("workSq", workSq);
		paramMap.put("artstSq", param);
		List<Map<String, Object>> resultNonSale = myPageMapper.myWorkListNonSale(paramMap);
		List<Map<String, Object>> result = Stream.concat(resultSale.stream(), resultNonSale.stream()).collect(Collectors.toList());
		return result;
	}
	
	/*
	 * 나의 작품 수정 페이지 오픈
	 * param : workSq
	 * return : Map
	 */
	public Map<String, Object> myWorkMod(String param){
		return myPageMapper.myWorkMod(param);
	}
	
	/*
	 * 나의 작품 수정 등록
	 * param : 나의 작품 등록 정보가 들어있는 param
	 * return : int
	 */
	public int myWorkCor(Map<String, Object> param) {
		int result = -1;
		result = myPageMapper.myWorkCor(param);
		System.out.println(" myWorkDao result : " + result);
		if(!param.get("keywrd").toString().equals(null) && !param.get("keywrd").toString().equals("")) {
			result = myPageMapper.keywrdCor(param);
		}
		return result;	
	}
	
	/*
	 * 소장품 수정 페이지 오픈
	 * param : workSq
	 * return : Map
	 */
	public Map<String, Object> myCollectionMod(String param){
		return myPageMapper.myCollectionMod(param);
	}
	
	/*
	 * 나의 소장품 수정 등록
	 * param : 나의 소장품 등록 정보가 들어있는 param
	 * return : int
	 */
	public int collectionCor(Map<String, Object> param) {
		int result = -1;
		result = myPageMapper.collectionCor(param);
		if(!param.get("keywrd").toString().equals(null) && !param.get("keywrd").toString().equals("")) {
			result = myPageMapper.keywrdCor(param);
		}
		return result;	
	}
	
	/*
	 * 스크랩 목록
	 * param : mbrSq
	 * return : 스크랩 목록이 들어있는 List
	 */
	public List<Map<String, Object>> scrapList(String param){
		List<String> scrapSq = myPageMapper.scrapList(param); //스크랩한 작품 순번 조회
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		System.out.println("@@@@@@@@@@@@@@@@@@@ List Pram : " + scrapSq);
		
		if(!scrapSq.isEmpty()) {
			List<Map<String, Object>> resultSale = myPageMapper.scrapListSale(scrapSq); //판매중인 스크랩 작품 조회
			List<String> workSq = new ArrayList<String>();
			if(resultSale.size() > 0) {
				for(int i=0; i<resultSale.size(); i++) {
					workSq.add(resultSale.get(i).get("workSq").toString());
				}
			}
			paramMap.put("workSq", workSq); //판매중인 스크랩 작품 순번을 담는다
			paramMap.put("scrapSq", scrapSq); //스크랩 작품 순번을 담는다
			List<Map<String, Object>> resultNonSale = myPageMapper.scrapListNonSale(paramMap);
			result = Stream.concat(resultSale.stream(), resultNonSale.stream()).collect(Collectors.toList());
		}
		return result;
	}
	
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetailBuy(String dealSq, String mbrSq){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> dealInfo = myPageMapper.getMyDealDetailDealInfoBuy(dealSq);
		Map<String, Object> mbrInfo = myPageMapper.getPaymentDeliveryInfo(mbrSq);
		Map<String, Object> payMntInfo1 = new HashMap<>();
		Map<String, Object> payMntInfo2 = new HashMap<>();
		Map<String, Object> vacctInfo = new HashMap<>();
		List<Map<String, Object>> trnsprtInfo = new ArrayList<Map<String,Object>>();
		if(dealInfo.get("buyPaymntSttsCd").toString().equals("2PC")) {
			payMntInfo1 = myPageMapper.selectPaymntBuy1(dealSq, mbrSq);
			payMntInfo2 = myPageMapper.selectPaymntBuy2(dealSq, mbrSq);
			trnsprtInfo = myPageMapper.selectTrnsprtInfoBuy(dealSq, mbrSq);
		}
		if(dealInfo.get("payMethod") != null) {
			if(dealInfo.get("buyPaymntSttsCd").toString().equals("1PW")) {
				if(dealInfo.get("payMethod").toString().equals("VACCT")) {
					vacctInfo = myPageMapper.selectPaymntBuy1(dealSq, mbrSq);
					
				}
			}
			if(dealInfo.get("buyPaymntSttsCd").toString().equals("2PW")) {
				if(dealInfo.get("payMethod").toString().equals("VACCT")) {
					vacctInfo = myPageMapper.selectPaymntBuy2(dealSq, mbrSq);
				}
			}
			
		}
		result.put("vacctInfo", vacctInfo);
		result.put("payMntInfo1", payMntInfo1);
		result.put("payMntInfo2", payMntInfo2);
		result.put("trnsprtInfo", trnsprtInfo);
		mbrInfo.put("mbrEmail", commonService.decrypt(mbrInfo.get("mbrEmail").toString()));
		mbrInfo.put("mbrCpNum", commonService.decrypt(mbrInfo.get("mbrCpNum").toString()));
		result.put("dealInfo", dealInfo);
		result.put("mbrInfo", mbrInfo);
		return result;
	}
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetailSell(String dealSq, String mbrSq){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> dealInfo = myPageMapper.getMyDealDetailDealInfoSell(dealSq);
		Map<String, Object> mbrInfo = myPageMapper.getPaymentDeliveryInfo(mbrSq);
		Map<String, Object> payMntInfo = new HashMap<>(); //결제 정보
		Map<String, Object> vacctInfo = new HashMap<>(); //가상계좌 입금 정보
		Map<String, Object> workDealInfo = new HashMap<>(); //정산 정보
		List<Map<String, Object>> trnsprtInfo = new ArrayList<Map<String,Object>>();
		if(dealInfo.get("sellPaymntSttsCd").toString().equals("2PC")) { //2차 결제 완료면
			payMntInfo = myPageMapper.selectPaymntSell(dealSq, mbrSq); //결제 정보를 가져온다
			trnsprtInfo = myPageMapper.selectTrnsprtInfoSell(dealSq, mbrSq); //부가서비스 정보를 가져온다
		}
		if(dealInfo.get("payMethod") != null) {
			if(dealInfo.get("payMethod").toString().equals("VACCT")) {
				vacctInfo = myPageMapper.selectPaymntSell(dealSq, mbrSq);
				result.put("vacctInfo", vacctInfo);
			}
		}
		if(dealInfo.get("dealSttsCd").toString().equals("PC")) {
			workDealInfo = myPageMapper.selectCalcInfo(dealSq, mbrSq);
		}
		result.put("workDealInfo", workDealInfo);
		result.put("vacctInfo", vacctInfo);
		result.put("payMntInfo", payMntInfo);
		result.put("trnsprtInfo", trnsprtInfo);
		mbrInfo.put("mbrEmail", commonService.decrypt(mbrInfo.get("mbrEmail").toString()));
		mbrInfo.put("mbrCpNum", commonService.decrypt(mbrInfo.get("mbrCpNum").toString()));
		result.put("dealInfo", dealInfo);
		result.put("mbrInfo", mbrInfo);
		return result;
	}
	
	/*
	 * 운송 옵션 가격, 코드 네임 조회
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 운송 가격, 코드 네임
	 */
	public List<Map<String, Object>> selectTrnsprtInfo(Map<String, Object> param){
		List<Map<String, Object>> result = myPageMapper.selectTrnsprtInfo(param);
		return result;
	}
	
	/*
	 * 거래내역 응찰 히스토리 가져오기
	 * param : deslSq
	 * return : bidDate, bidPrc
	 */
	public List<Map<String, Object>> myDealListBidHistory(Object param){
		return dealMapper.selectAuctnBidList(param);
	}
	
	/*
	 * 운송 테이블에 판매자 운송 정보 입력
	 * param : trnsprtDivCd trnsprtTypCd trnsprtAreaCd trnsprtServiceCd
	 * return : 
	 */
	public void insertTrnsprt(Object param) {
		myPageMapper.insertTrnsprt(param);
	}
	
	//나의작품 / 소장품 거래등록 확인
	public int dealWorkCount(Map<String, Object> param){
		
		int dealWorkCount = myPageMapper.dealWorkCount(param);
		
		return dealWorkCount;
	}
	
	/*
	 * 소장품 삭제 선택시 거래 등록 여부 확인
	 * param : workSq
	 * return :
	 */
	public int dealCheck(String workSq) {
		int result;
		result = myPageMapper.dealCheck(workSq);
		return result;
	}
	
	/*
	 * 소장품 삭제
	 * param : workSq
	 * return :
	 */
	public int delCollection(String workSq) {	
		int result;
		result = myPageMapper.delCollection(workSq);
		return result;
	}
	
}

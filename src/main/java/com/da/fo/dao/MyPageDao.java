package com.da.fo.dao;

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

import com.da.mapper.MyPageMapper;
import com.da.sample.service.CommonService;

@Repository
public class MyPageDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyPageMapper myPageMapper;
	
	@Autowired
	private CommonService commonService;
	/*
	 * 거래내역 화면 오픈 시, 검색 조건 입력 후 조회 시 로그인한 회원의 거래내역 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchList(Map<String, Object> param) {
		return myPageMapper.myDealSearchList(param);
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
		for(int i=0; i<resultSale.size(); i++) {
			workSq.add(resultSale.get(i).get("workSq").toString());
		}
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
	 * param : 나의 작품 정보가 들어있는 param
	 * return : List
	 */
	public List myWork(String param) {
		List<Map<String, Object>> resultSale = myPageMapper.myWorkListSale(param);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("artstSq", param);
		List<String> workSq = new ArrayList<String>();
		for(int i=0; i<resultSale.size(); i++) {
			workSq.add(resultSale.get(i).get("workSq").toString());
		}
		paramMap.put("workSq", workSq);
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
	public List<String> scrapList(String param){
		List<String> paramList = myPageMapper.scrapList(param);
		List<String> result = null;
		System.out.println("@@@@@@@@@@@@@@@@@@@ List Pram : " + paramList);
		if(!paramList.isEmpty()) {
			List<String> resultNonSale = myPageMapper.scrapListNonSale(paramList);
			List<String> resultSale = myPageMapper.scrapListSale(paramList);
			result = Stream.concat(resultSale.stream(), resultNonSale.stream()).collect(Collectors.toList());
		}
		return result;
	}
	
	/*
	 * 1차 결제 결제정보
	 * param : dealSq, mbrSq
	 * return : 결제에 필요한 정보
	 */
	public Map<String, Object> openPaymentBuyer(Map<String, Object> param){
		Map<String, Object> result = new HashMap<>();
		//int resultUpdate = myPageMapper.updateDealSttsCd(param.get("dealSq").toString(), "1PW");
		//if( resultUpdate > 0) {
			Map<String, Object> result1 = myPageMapper.getPaymentDealInfo(param.get("dealSq").toString());
			Map<String, Object> result2 = myPageMapper.getPaymentBuyerInfo(param.get("mbrSq").toString());
			result2.put("mbrEmail", commonService.decrypt(result2.get("mbrEmail").toString()));
			result2.put("mbrCpNum", commonService.decrypt(result2.get("mbrCpNum").toString()));
			result.put("deal", result1);
			result.put("mbrInfo", result2);
			return result;
		//}
		//return null;
	}
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetail(String dealSq, String mbrSq){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> dealInfo = myPageMapper.getMyDealDetailDealInfo(dealSq);
		Map<String, Object> mbrInfo = myPageMapper.getPaymentBuyerInfo(mbrSq);
		mbrInfo.put("mbrEmail", commonService.decrypt(mbrInfo.get("mbrEmail").toString()));
		mbrInfo.put("mbrCpNum", commonService.decrypt(mbrInfo.get("mbrCpNum").toString()));
		result.put("dealInfo", dealInfo);
		result.put("mbrInfo", mbrInfo);
		return result;
	}
}

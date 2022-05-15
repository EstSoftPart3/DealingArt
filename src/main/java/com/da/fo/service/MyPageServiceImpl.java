package com.da.fo.service;

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
	public List<String> scrapList(String param){
		return myPageDao.scrapList(param);
	}
	
	/*
	 * 1차 결제 결제정보
	 * param : dealSq, mbrSq
	 * return : 결제에 필요한 정보
	 */
	public Map<String, Object> openPaymentBuyer(Map<String, Object> param){
		return myPageDao.openPaymentBuyer(param);
	}
	
	/*
	 * 거래 상세 페이지
	 * param : dealSq, mbrSq
	 * return : 거래에 관한 데이터
	 */
	public Map<String, Object> openMyDealDetail(String dealSq, String mbrSq){
		return myPageDao.openMyDealDetail(dealSq, mbrSq);
	}
}

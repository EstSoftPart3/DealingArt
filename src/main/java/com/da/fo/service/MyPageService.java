package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface MyPageService {
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
	
}

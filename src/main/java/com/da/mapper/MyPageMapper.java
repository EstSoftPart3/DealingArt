package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface MyPageMapper {
	/*
	 * 거래내역 화면 오픈 시, 검색 조건 입력 후 조회 시 로그인한 회원의 거래내역 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchList(Object param);
	
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
	
}

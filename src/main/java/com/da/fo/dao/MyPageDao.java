package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.MyPageMapper;

@Repository
public class MyPageDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyPageMapper myPageMapper;
	/*
	 * 거래내역 화면 오픈 시, 검색 조건 입력 후 조회 시 로그인한 회원의 거래내역 리스트를 보여준다.
	 * param : null or  searchOption
	 * return : 거래내역
	 */
	public List myDealSearchList(Map<String, Object> param) {
		return myPageMapper.myDealSearchList(param);
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
}

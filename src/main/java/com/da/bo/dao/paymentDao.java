package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import com.da.mapper.paymentMapper;

@Repository
public class paymentDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	paymentMapper paymentMapper;
	
	//작품 거래 내역
	public Map<String, Object> workDealhList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> workDealInfo = paymentMapper.workDealhList(param);
		
		result.put("workDealInfo", workDealInfo);
				
		return result;
	}
	
	
	//거래 운송 목록
	public Map<String, Object> dealMainList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> dealInfo = paymentMapper.dealMainList(param);
		
		result.put("dealInfo", dealInfo);
				
		return result;
	}
	
	
	//거래 상세 - 결제
	public Map<String, Object> payDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> detailInfo = paymentMapper.payDetail(param);
		
		result.put("detailInfo", detailInfo);
				
		return result;
	}
	
	//작품 정보
	public Map<String, Object> workInfo(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> workInfo = paymentMapper.workInfo(param);
		
		result.put("workInfo", workInfo);
				
		return result;
	}
	
	//거래 운송 목록
	public Map<String, Object> trnsprtList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> listInfo = paymentMapper.trnsprtList(param);
		
		result.put("listInfo", listInfo);
				
		return result;
	}
	
	//거래 메인 수정 : 거래_상태_코드
	public void dealMainSttsCdUpdate(Map<String, Object> param){
		paymentMapper.dealMainSttsCdUpdate(param);
	}
	
	//거래 메인 수정 :거래_메모
	public void dealMainMemoUpdate(Map<String, Object> param){
		paymentMapper.dealMainMemoUpdate(param);
	}

}

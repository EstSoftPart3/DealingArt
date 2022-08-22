package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.bo.dao.paymentDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class paymentServiceImpl implements paymentService {
	
	@Autowired
	paymentDao paymentDao;
	
	//작품 거래 내역
	@Override
	public Map<String, Object> workDealhList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentDao.workDealhList(param);
		
		return result;
	}
	
	
	//거래 운송 목록
	@Override
	public Map<String, Object> dealMainList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentDao.dealMainList(param);
		
		return result;
	}
	
	
	//거래 상세 - 결제
	@Override
	public Map<String, Object> payDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentDao.payDetail(param);
		
		return result;
	}
	
	
	//작품 정보
	@Override
	public Map<String, Object> workInfo(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentDao.workInfo(param);
		
		return result;
	}
	
	
	//거래 운송 목록
	@Override
	public Map<String, Object> trnsprtList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentDao.trnsprtList(param);
		
		return result;
	}
	
	//거래 메인 수정 : 거래_상태_코드
	@Override
	public void dealMainSttsCdUpdate(Map<String, Object> param){
		paymentDao.dealMainSttsCdUpdate(param);
	}
	
	//거래 메인 수정 : 거래_메모_코드
	@Override
	public void dealMainMemoUpdate(Map<String, Object> param){
		paymentDao.dealMainMemoUpdate(param);
	}
	
	//거래 관련 파일 업로드
	@Override
	public int dealFileUpload(Map<String, Object> param) {
		return paymentDao.dealFileUpload(param);
	}
}

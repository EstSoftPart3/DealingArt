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
	
	
	//거래 운송 목록
	@Override
	public Map<String, Object> dealMainList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentDao.dealMainList(param);
		
		return result;
	}
	
	
	
	//거래 운송 목록
	@Override
	public Map<String, Object> trnsprtList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentDao.trnsprtList(param);
		
		return result;
	}

}

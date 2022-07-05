package com.da.bo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.bo.dao.reportDao;
import com.da.fo.dao.DealDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class reportServiceImpl implements reportService {
	@Autowired
	private reportDao reportDao;
	
	@Override
	public int reportInsert(Object param) {
		// TODO Auto-generated method stub
		System.out.println("service para data: " + param);

		return reportDao.reportInsert(param);
	}

	@Override
	public List<Map<String, Object>> reportList(Object param) {
		
		List result = reportDao.reportList(param);
		
		
		
		return result;
	}
}

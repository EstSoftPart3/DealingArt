package com.da.bo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.ReportMapper;


@Repository
public class reportDao {

	@Autowired
	private ReportMapper reportMapper;
	
	public int reportInsert(Object param){
		System.out.println("Controller para data: " + param);

		int result = reportMapper.reportInsert(param);
		System.out.println("service result data: " + result);

		return result;
		
		
	}
	
	public List<Map<String, Object>>  reportList(Object param){
		List  result = reportMapper.reportList(param);
		return result;
		
		
	}
	
}

package com.da.fo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.Mgz9Dao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Mgz9ServiceImpl implements Mgz9Service{
	
	@Autowired
	Mgz9Dao mgz9Dao;
	
	/*
	 * MGZ9 목록 조회
	 * PARAM : 
		#MGZ_TYP_CD
			IST - INSIGHTS
			MDA - MEDIA
			EBI - EXHIBITION
	 * RETURN : MGZ9 목록
	 */
	@Override
	public Map<String, Object> selectMgz9List(Map<String, Object> param) {
		
		Map<String, Object> result = new HashMap<>();
		
		result = mgz9Dao.selectMgz9List(param);
		
		return result;
	}
	
	/*
	 * MGZ9 상세 조회
	 * PARAM : MGZ_SQ
	 * RETURN : MGZ9 상세
	 */
	public Map<String, Object> selectMgz9Dtl(String param){
		return mgz9Dao.selectMgz9Dtl(param);
	}
}

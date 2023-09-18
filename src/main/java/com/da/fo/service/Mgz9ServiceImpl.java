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
	 * 매거진9 홈 목록 조회
	 */
	@Override
	public Map<String, Object> searchMgz9homeList() {
		return mgz9Dao.searchMgz9homeList();
	}

	
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
	
	/* 통합 검색 */
	@Override
	public List<Map<String, Object>> result(Map<String, Object> param) {
		return mgz9Dao.result(param);
	}

	@Override
	public List<Map<String, Object>> search(Map<String, Object> param) {
		return mgz9Dao.search(param);
	}

	@Override
	public int count(String param) {
		return mgz9Dao.count(param);
	}

	@Override
	public List<Map<String, Object>> alphabet(Map<String, Object> param) {
		return mgz9Dao.alphabet(param);
	}

	@Override
	public int alphabetCount(String param) {
		return mgz9Dao.alphabetCount(param);
	}

	@Override
	public List<Map<String, Object>> korean(Map<String, Object> param) {
		return mgz9Dao.korean(param);
	}

	@Override
	public int koreanCount(String param) {
		return mgz9Dao.koreanCount(param);
	}
}

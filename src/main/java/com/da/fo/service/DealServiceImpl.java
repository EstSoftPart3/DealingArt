package com.da.fo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.DealDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DealServiceImpl implements DealService{
	@Autowired
	DealDao dealDao;
	/*
	 * 딜 페이지에서 검색 필터별로 검색 결과를 조회한다.
	 * param : searchOption
	 * return : 검색 결과
	 */
	public Map<String, Object> dealSerach(Map<String, Object> searchOptions){
		Map<String, Object> result = new HashMap<>();
		result = dealDao.dealSerach(searchOptions);
		return result;
	}
	
}

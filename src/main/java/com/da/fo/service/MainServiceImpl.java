package com.da.fo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.MainDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService{
	@Autowired
	MainDao mainDao;
	/*
	 * 메인 화면 오픈 시 영역에 보여줄 데이터를 조회한다.
	 * param : null
	 * return : 화면에 보여줄 데이터
	 */
	public Map<String, Object> openMain(Map<String, Object> param){
		Map<String, Object> result = new HashMap<>();
		result = mainDao.openMain(param);
		return result;
	}
}

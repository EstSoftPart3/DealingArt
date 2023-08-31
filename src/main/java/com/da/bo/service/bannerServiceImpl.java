package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.bo.dao.bannerDao;
import com.da.fo.dao.MainDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class bannerServiceImpl implements bannerService {

	@Autowired
	bannerDao bannerDao;
	MainDao mainDao;

	// 배너 목록
	@Override
	public Map<String, Object> bannerList(Map<String, Object> param) {

		Map<String, Object> result = new HashMap<>();

		result = bannerDao.bannerList(param);

		return result;
	}

	// 배너 등록
	@Override
	public int bannerInsert(Map<String, Object> param) {	
		return bannerDao.bannerInsert(param);			
	}
	
	//배너 삭제
	@Override
	public void bannerDelete(Map<String, Object> param) {	
		 bannerDao.bannerDelete(param);			
	}

	@Override
	public Map<String, Object> eventProList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();

		result = bannerDao.eventProList(param);

		return result;
	}

}
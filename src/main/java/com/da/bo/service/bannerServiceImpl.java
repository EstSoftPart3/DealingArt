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

	// 게시판 목록
	@Override
	public Map<String, Object> bannerList(Map<String, Object> param) {

		Map<String, Object> result = new HashMap<>();

		result = bannerDao.bannerList(param);

		return result;
	}

	// 게시판 입력
	@Override
	public void bannerInsert(Map<String, Object> param) {
		bannerDao.bannerInsert(param);
	}

	@Override
	public Map<String, Object> eventProList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();

		result = bannerDao.eventProList(param);

		return result;
	}

}
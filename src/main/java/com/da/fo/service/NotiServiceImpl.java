package com.da.fo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.NotiDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotiServiceImpl implements NotiService {

	@Autowired
	NotiDao NotiDao;
	
	//보냄 히스토리 등록
	@Override
	public int notiInsert(Map<String, Object> param){
		int insertState = -1;
		insertState = NotiDao.notiInsert(param);
		return insertState;
	}
	
	//보냄 히스토리
	@Override
	public Map<String, Object> notiSelect(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = NotiDao.notiSelect(param);
		
		return result;
	}
}

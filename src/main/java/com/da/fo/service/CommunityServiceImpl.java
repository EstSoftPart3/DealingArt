package com.da.fo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.CommunityDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	
	@Autowired
	CommunityDao communityDao;

	@Override
	public Map<String, Object> communityHomeList() {
		return communityDao.communityHomeList();
	}
	
}

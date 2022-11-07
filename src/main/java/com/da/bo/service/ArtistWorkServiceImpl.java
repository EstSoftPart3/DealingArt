package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.bo.dao.ArtistWorkDao;

import lombok.AllArgsConstructor;

@Service
public class ArtistWorkServiceImpl implements ArtistWorkService{
	
	@Autowired
	ArtistWorkDao artistWorkDao;
	
	@Override
	public Map<String, Object> artistWorkList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
		
		result = artistWorkDao.artistWorkList(param);
		
		return result;
	}

}

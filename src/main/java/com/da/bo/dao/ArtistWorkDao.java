package com.da.bo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.ArtistWorkMapper;

@Repository
public class ArtistWorkDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArtistWorkMapper artistWorkMapper;
	
	//작가 정보 리스트
	public Map<String, Object> artistWorkList(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> workList = artistWorkMapper.artistWorkList(param);
		
		result.put("List", workList);
				
		return result;
	}
	
	//작가 정보 상세
	public Map<String, Object> artistWorkDetail(Map<String, Object> param) {
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> artDetailInfo = artistWorkMapper.artistWorkDetail(param);
		
		result.put("artDetailInfo", artDetailInfo);
				
		return result;
	}

}

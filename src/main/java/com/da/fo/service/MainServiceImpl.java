package com.da.fo.service;

import java.util.HashMap;
import java.util.List;
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
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회환다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List totalSearchWork(String searchKeyword){
		return mainDao.totalSearchWork(searchKeyword);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작가을 조회환다.
	 * param : searchKeyword
	 * return : 작가에 관한 정보
	 */
	public List totalSearchArtist(String searchKeyword){
		return mainDao.totalSearchArtist(searchKeyword);
	}
	
	/*
	 * 메인 화면에서 통합검색시 작품, 작가 정보를 자동완성으로 가져온다.
	 * param : searchKeyword
	 * return : 작품, 작가에 관한 정보
	 */
	public Map<String, Object> totalSearchAutocomplete(String searchKeyword){
		Map<String, Object> result = new HashMap<>();
		result = mainDao.totalSearchAutocomplete(searchKeyword);
		return result;
	}
	
}

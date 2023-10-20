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
	 * 메인 화면에서 통합검색으로 작가을 조회환다.
	 * param : searchKeyword
	 * return : 작가에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchArtist(String searchKeyword){
		return mainDao.totalSearchArtist(searchKeyword);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회환다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchWork(Object param){
		return mainDao.totalSearchWork(param);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회 갯수를 가져온다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public int totalSearchWorkTotalCount(Object param){
		return mainDao.totalSearchWorkTotalCount(param);
	}
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회환다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchContent(String param){
		return mainDao.totalSearchContent(param);
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
	
	/*
	 * 메인 화면 로드시 지금 거래중인 작품 정보를 가져온다.
	 * param : 
	 * return :
	 */
	public List<Map<String, Object>> mainNowDealWorks(){
		List<Map<String, Object>> result = mainDao.mainNowDealWorks();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 매거진9 정보를 가져온다.
	 * param : 
	 * return :
	 */
	public List<Map<String, Object>> mainMgz9s(){
		List<Map<String, Object>> result = mainDao.mainMgz9s();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 인기 회원 정보를 가져온다.
	 * param:
	 * return :
	 */
	public List<Map<String, Object>> mainPopularMbr(){
		List<Map<String, Object>> result = mainDao.mainPopularMbr();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 인기 전시후기/소개 정보를 가져온다.
	 * param:
	 * return :
	 */
	public List<Map<String, Object>> mainPopularExhibit(){
		List<Map<String, Object>> result = mainDao.mainPopularExhibit();
		return result;
	}
	
	/*
	 * 메인 화면 로드시 자랑하기 정보를 가져온다.
	 * param:
	 * return :
	 */
	public List<Map<String, Object>> mainBoa(){
		List<Map<String, Object>> result = mainDao.mainBoa();
		return result;
	}
	
	public List<Map<String, Object>> selectBoa(String workSq){
		List<Map<String, Object>> result = mainDao.selectBoa(workSq);
		return result;
	}
}

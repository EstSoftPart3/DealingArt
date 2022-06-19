package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface MainService {
	/*
	 * 메인 화면 오픈 시 영역에 보여줄 데이터를 조회한다.
	 * param : null
	 * return : 화면에 보여줄 데이터
	 */
	Map<String, Object> openMain(Map<String, Object> param);
	
	/*
	 * 메인 화면에서 통합검색으로 작가을 조회환다.
	 * param : searchKeyword
	 * return : 작가에 관한 정보
	 */
	List<Map<String, Object>> totalSearchArtist(String searchKeyword);
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회환다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	List<Map<String, Object>> totalSearchWork(Object param);
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회 갯수를 가져온다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	int totalSearchWorkTotalCount(Object param);
	
	/*
	 * 메인 화면에서 통합검색시 작품, 작가 정보를 자동완성으로 가져온다.
	 * param : searchKeyword
	 * return : 작품, 작가에 관한 정보
	 */
	Map<String, Object> totalSearchAutocomplete(String searchKeyword);
}

package com.da.fo.service;

import java.util.Map;

public interface MainService {
	/*
	 * 메인 화면 오픈 시 영역에 보여줄 데이터를 조회한다.
	 * param : null
	 * return : 화면에 보여줄 데이터
	 */
	Map<String, Object> openMain(Map<String, Object> param);
	
	/*
	 * 메인 화면에서 통합검색시 작품, 작가 정보를 자동완성으로 가져온다.
	 * param : searchKeyword
	 * return : 작품, 작가에 관한 정보
	 */
	Map<String, Object> totalSearchAutocomplete(String searchKeyword);
}

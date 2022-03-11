package com.da.fo.service;

import java.util.Map;

public interface MainService {
	/*
	 * 메인 화면 오픈 시 영역에 보여줄 데이터를 조회한다.
	 * param : null
	 * return : 화면에 보여줄 데이터
	 */
	Map<String, Object> openMain(Map<String, Object> param);
}

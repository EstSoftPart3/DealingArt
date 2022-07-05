package com.da.bo.service;

import java.util.List;
import java.util.Map;

public interface reportService {


	/*
	 *  작품 신고하기 Insert
	 * 	param: 신고내용
	 * return: int
	 * */
	public int reportInsert(Object param);
	
	public List reportList(Object param);
	
}

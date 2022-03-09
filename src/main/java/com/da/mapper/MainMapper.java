package com.da.mapper;

import java.util.List;

public interface MainMapper {
	/*
	 * 메인화면 가장많은 입찰 데이터
	 * param : null
	 * return : List
	 */
	public List mainHotest();
	
	/*
	 * 메인화면 오늘의 낙찰 데이터
	 * param : 오늘 날짜
	 * return : List
	 */
	public List mainTodayBid(Object param);
}

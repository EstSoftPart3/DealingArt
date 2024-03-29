package com.da.mapper;

import java.util.List;
import java.util.Map;

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
	
	/*
	 * 메인화면 NEW DEAL
	 * param : null
	 * return : List
	 */
	public List mainNewDeal();
	
	/*
	 * 메인화면 UPDATED ARTIST
	 * param : null
	 * return : List
	 */
	public List mainUpdatedArtist();
	
	/*
	 * 메인화면 NEW DEAL
	 * param : null
	 * return : List
	 */
	public List mainInsights();
	
	/*
	 * 메인 화면에서 통합검색시 작가정보를 조회한다.
	 * param : searchKeyword
	 * return : 작가에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchArtist(Object param);
	
	/*
	 * 메인 화면에서 통합검색시 작품정보를 조회한다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchWork(Object param);
	
	/*
	 * 메인 화면에서 통합검색시 컨텐츠 정보를 조회한다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List<Map<String, Object>> totalSearchContent(String param);
	
	/*
	 * 메인 화면에서 통합검색으로 작품을 조회 갯수를 가져온다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public int totalSearchWorkTotalCount(Object param);
	
	/*
	 * 메인 화면에서 통합검색시 작품 정보를 자동완성으로 가져온다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	public List totalSearchAutocompleteWork(Object param);
	
	/*
	 * 메인 화면에서 통합검색시 작가 정보를 자동완성으로 가져온다.
	 * param : searchKeyword
	 * return : 작가에 관한 정보
	 */
	public List totalSearchAutocompleteArtist(Object param);
	
	/*
	 * 메인 화면에서 통합검색시 콘첸츠 정보를 자동완성으로 가져온다.
	 * param : searchKeyword
	 * return : 콘첸트에 관한 정보
	 */
	public List totalSearchAutocompleteContent(Object param);
}

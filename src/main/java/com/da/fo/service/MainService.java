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
	 * 메인 화면에서 통합검색으로 컨텐츠를 조회한다.
	 * param : searchKeyword
	 * return : 작품에 관한 정보
	 */
	List<Map<String, Object>> totalSearchContent(String param);
	
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
	
	/*
	 * 메인 화면 로드시 지금 거래중인 작품 정보를 가져온다.
	 * param : 
	 * return :
	 */
	List<Map<String, Object>> mainNowDealWorks();
	
	/*
	 * 메인 화면 로드시 매거진9 정보를 가져온다.
	 * param : 
	 * return :
	 */
	List<Map<String, Object>> mainMgz9s();
	
	/*
	 * 메인 화면 로드시 인기 회원 정보를 가져온다.
	 * param:
	 * return :
	 */
	List<Map<String, Object>> mainPopularMbr();
	
	/*
	 * 메인 화면 로드시 인기 전시후기/소개 정보를 가져온다.
	 * param:
	 * return :
	 */
	List<Map<String, Object>> mainPopularExhibit();
	
	/*
	 * 메인 화면 로드시 자랑하기 정보를 가져온다.
	 * param:
	 * return :
	 */
	List<Map<String, Object>> mainBoa();
	
	List<Map<String, Object>> selectBoa(String workSq);
}

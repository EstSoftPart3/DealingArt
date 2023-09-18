package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface ArtistMapper {
	
	/*
	 * [매거진9>홈] 신규 등록된 작가 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	public List selectNewartistList();
	/*
	 * 아티스트 라이브러리 오픈 시 신진 작가 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	public List upAndComingArtist();
	
	/*
	 * 아티스트 라이브러리 오픈 시 중견 작가 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	public List middleAgedArtist();
	
	/*
	 * 아티스트 라이브러리 오픈 시 원로 작가 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	public List seniorArtist();
	
	/*
	 * 아티스트 라이브러리 오픈 시 대가 작가 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	public List masterArtist();
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public Map<String, Object> artistInfo(Object param);
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트 학력 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public List artistInfoEductn(Object param);
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트 경력 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public List artistInfoCareer(Object param);
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트 전시 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public List artistInfoExhbtn(Object param);
	
	public List artistInfoExhbtnAword(Object param);
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트의 판매중 작품을 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public List artistWorkListSale(Object param);
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트의 판매전 작품을 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public List artistWorkListNonSale(Object param);
	
	/*
	 * 아티스트 전체 작품 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public List artistWorkListAll(Object param);
}



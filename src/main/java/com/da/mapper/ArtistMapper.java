package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface ArtistMapper {
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
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트의 작품을 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public List artistWorkList(Object param);
}

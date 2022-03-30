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
}

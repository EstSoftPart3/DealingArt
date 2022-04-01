package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface ArtistService {

	/*
	 * 아티스트 라이브러리 오픈 시 아티스트 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	Map<String, Object> openArtistLibrary();
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	Map<String, Object> artistDetail(int artstSq);
}

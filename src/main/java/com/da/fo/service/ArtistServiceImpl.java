package com.da.fo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.ArtistDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService{

	@Autowired
	private ArtistDao artistDao;
	
	/*
	 * 아티스트 라이브러리 오픈 시 아티스트 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	public Map<String, Object> openArtistLibrary(){
		return artistDao.openArtistLibrary();
	}
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public Map<String, Object> artistDetail(int artstSq){
		return artistDao.artistDetail(artstSq);
	}
	
	/*
	 * 아티스트 라이브러리에서 정렬시 정렬한 작품 목록을 가져온다.
	 * param : Map
	 * return : 정렬 결과
	 */
	public List<Map<String, Object>> artistDetailSort(Map<String, Object> param){
		return artistDao.artistDetailSort(param);
	}
}

package com.da.fo.service;

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
}

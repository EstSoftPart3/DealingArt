package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.ArtistMapper;


@Repository
public class ArtistDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArtistMapper artistMapper;
	/*
	 * 아티스트 라이브러리 오픈 시 아티스트 목록을 불러온다.
	 * param : null
	 * return : 검색 결과
	 */
	public Map<String, Object> openArtistLibrary(){
		Map<String, Object> result = new HashMap<>();
		List upAndComingArtist = artistMapper.upAndComingArtist();
		List middleAgedArtist = artistMapper.middleAgedArtist();
		List seniorArtist =artistMapper.seniorArtist();
		result.put("upAndComingArtist", upAndComingArtist);
		result.put("middleAgedArtist", middleAgedArtist);
		result.put("seniorArtist", seniorArtist);
		return result;
	}
	
	/*
	 * 아티스트 라이브러리에서 아티스트 선택 시 해당 아티스트 정보를 불러온다.
	 * param : artstSq
	 * return : 검색 결과
	 */
	public Map<String, Object> artistDetail(int artstSq){
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> param = new HashMap<>();
		Map<String, Object> artistInfo = artistMapper.artistInfo(Integer.toString(artstSq));
		List eductn = artistMapper.artistInfoEductn(Integer.toString(artstSq));
		List career = artistMapper.artistInfoCareer(Integer.toString(artstSq));
		List exhbtn = artistMapper.artistInfoExhbtn(Integer.toString(artstSq));
		List workList = artistMapper.artistWorkList(Integer.toString(artstSq));
		result.put("artistInfo", artistInfo);
		result.put("eductn", eductn);
		result.put("career", career);
		result.put("exhbtn", exhbtn);
		result.put("workList", workList);
		return result;
	}
}

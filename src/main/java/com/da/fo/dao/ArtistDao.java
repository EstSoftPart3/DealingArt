package com.da.fo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Map<String, Object> artistInfo = artistMapper.artistInfo(Integer.toString(artstSq)); //작가정보
		List eductn = artistMapper.artistInfoEductn(Integer.toString(artstSq)); //작가학력
		List career = artistMapper.artistInfoCareer(Integer.toString(artstSq)); //작가경력
		List exhbtn = artistMapper.artistInfoExhbtn(Integer.toString(artstSq)); //작가전시
		
		List exhbtnAword = artistMapper.artistInfoExhbtnAword(Integer.toString(artstSq)); //수상
		
		//작가 작품 리스트
		List<Map<String, Object>> workListSale = artistMapper.artistWorkListSale(Integer.toString(artstSq)); //작가 작품 판매중 리스트
		List<String> workSq = new ArrayList<String>();
		for(int i=0; i<workListSale.size(); i++) { //판매중인 workSq 구하기
			workSq.add(workListSale.get(i).get("workSq").toString());
		}
		param.put("artstSq", Integer.toString(artstSq));
		param.put("workSq", workSq); //판매중인 workSq 넣기
		List<Map<String, Object>> workListNonSale = artistMapper.artistWorkListNonSale(param); //작가 작품 판매중이 아닌 리스트
		List<Map<String, Object>> workList = Stream.concat(workListSale.stream(), workListNonSale.stream()).collect(Collectors.toList()); //작품 판매중과 판매아닌것 합치기
				
		result.put("artistInfo", artistInfo);
		result.put("eductn", eductn);
		result.put("career", career);
		result.put("exhbtn", exhbtn);
		result.put("exhbtnAword", exhbtnAword);
		result.put("workList", workList);
		return result;
	}
	
	/*
	 * 아티스트 라이브러리에서 정렬시 정렬한 작품 목록을 가져온다.
	 * param : Map
	 * return : 정렬 결과
	 */
	public List<Map<String, Object>> artistDetailSort(Map<String, Object> param){
		//작가 작품 리스트
		List<Map<String, Object>> workListSale = artistMapper.artistWorkListSale(param); //작가 작품 판매중 리스트
		List<String> workSq = new ArrayList<String>();
		for(int i=0; i<workListSale.size(); i++) { //판매중인 workSq 구하기
			workSq.add(workListSale.get(i).get("workSq").toString());
		}
		param.put("workSq", workSq); //판매중인 workSq 넣기
		List<Map<String, Object>> workListNonSale = artistMapper.artistWorkListNonSale(param); //작가 작품 판매중이 아닌 리스트
		List<Map<String, Object>> workList = Stream.concat(workListSale.stream(), workListNonSale.stream()).collect(Collectors.toList()); //작품 판매중과 판매아닌것 합치기
		
		return workList;
	}
}

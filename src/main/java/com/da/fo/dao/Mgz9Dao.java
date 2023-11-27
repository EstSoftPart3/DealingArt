package com.da.fo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.ArtistMapper;
import com.da.mapper.Mgz9Mapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class Mgz9Dao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	Mgz9Mapper mgz9Mapper;
	
	@Autowired
	private ArtistMapper artistMapper;
	/*
	 * 매거진9 홈 목록 조회
	 */
	public Map<String, Object> searchMgz9homeList() {
		String ist = "IST"; // 인사이트
		String mda = "MDA"; // 아티스트 영상
		String bnnDivCd = "MGH"; // 매거진9 홈 배너구분 코드
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("istList", mgz9Mapper.searchMgzhomeIstList(ist)); // 인사이트
		result.put("mdaList", mgz9Mapper.searchMgzhomeMdaList(mda)); // 아티스트 영상
		result.put("artistList", artistMapper.selectNewartistList()); // 업데이트 아티스트
		result.put("bannerDtl", mgz9Mapper.searchHomeBnnList(bnnDivCd)); // 매거진9 홈 배너
		
		return result;
	}
	
	
	/*
	 * MGZ9 목록 조회
	 * PARAM : 
		#MGZ_TYP_CD
			IST - INSIGHTS
			MDA - MEDIA
			EBI - EXHIBITION
	 * RETURN : MGZ9 목록
	 */
	public Map<String, Object> selectMgz9List(Map<String, Object> param) {
		
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> workList = mgz9Mapper.selectMgz9List(param);
		
		result.put("info", workList);
		
		return result;
	
	}
	
	/*
	 * MGZ9 상세 조회
	 * PARAM : MGZ_SQ
	 * RETURN : MGZ9 상세
	 */
	public Map<String, Object> selectMgz9Dtl(String param){
		return mgz9Mapper.selectMgz9Dtl(param);
	}
	
	/* 통합 검색 */
	public List<Map<String, Object>> result(Map<String, Object> param) {
		List<Map<String, Object>> result = mgz9Mapper.result(param);
		return result;
	}

	/* 검색 */
	public List<Map<String, Object>> search(Map<String, Object> param) {
		List<Map<String, Object>> search = mgz9Mapper.search(param);
		return search;
	}
	
	/* 검색 게시물 카운트 */
	public int count(Map<String, Object> param) {
		return mgz9Mapper.count(param);
	}
	
	/* 알파벳 검색 */
	public List<Map<String, Object>> alphabet(Map<String, Object> param) {
		return mgz9Mapper.alphabet(param);
	}
	
	/* 알파벳 게시물 카운트 */
	public int alphabetCount(String param) {
		return mgz9Mapper.alphabetCount(param);
	}
	
	/* 한글 자음 검색 */
	public List<Map<String, Object>> korean(Map<String, Object> param) {
		return mgz9Mapper.korean(param);
	}
	
	/* 한글 자음 게시물 카운트 */
	public int koreanCount(String param) {
		return mgz9Mapper.koreanCount(param);
	}
}

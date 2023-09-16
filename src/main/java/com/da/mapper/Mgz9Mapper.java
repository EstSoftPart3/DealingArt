package com.da.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Mgz9Mapper {
	
	/*
	 * 매거진9 홈 리스트 조회
	 * param : 
	 * return : 커뮤니티 홈 리스트
	 */
	public List<Map<String, Object>> searchMgzhomeList(String typeCd);
	
	/*
	 * 매거진9 홈 배너 조회
	 */
	public Map<String, Object> searchHomeBnnList(String bnnDivCd);
	
	/*
	 * MGZ9 목록 조회
	 * PARAM : 
		#MGZ_TYP_CD
			IST - INSIGHTS
			MDA - MEDIA
			EBI - EXHIBITION
	 * RETURN : MGZ9 목록
	 */
	public List selectMgz9List(Object param);
	
	/*
	 * MGZ9 상세 조회
	 * PARAM : MGZ_SQ
	 * RETURN : MGZ9 상세
	 */
	public Map<String, Object> selectMgz9Dtl(String param);
	
	/* 통합 검색 */
	public List<Map<String, Object>> result(Map<String, Object> param);
	
	/* 검색 */
	public List<Map<String, Object>> search(Map<String, Object> param);
	
	/* 검색 게시물 카운트 */
	public int count(String param);	
	
	/* 알파벳 검색 */
	public List<Map<String, Object>> alphabet(Map<String, Object> param);
	
	/* 알파벳 게시물 카운트 */
	public int alphabetCount(String param);
	
	/* 한글 자음 검색 */
	public List<Map<String,Object>> korean(Map<String, Object> param);
	
	/* 한글 자음 게시물 카운트 */
	public int koreanCount(String param);
	
}

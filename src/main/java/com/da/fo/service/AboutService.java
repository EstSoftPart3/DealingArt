package com.da.fo.service;

import java.util.List;
import java.util.Map;

public interface AboutService {
	
	/*
	 * 게시판 목록 조회
	 * PARAM : BRD_TYP_CD = #{brdTypCd}
			NT - 공지사항
			FA - faq
	 * RETURN : 게시판 목록
	 */
	List selectBrdList(String brdTypCd, String brdConTypCd);
	
	/*
	 * 게시판 상세 조회
	 * PARAM : BRD_SQ = #{brdSq}
	 * RETURN : 게시판 상세
	 */
	Map<String, Object> selectBrdDtl(String param);
	
}

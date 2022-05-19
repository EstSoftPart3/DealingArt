package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface AboutMapper {
	
	/*
	 * 게시판 목록 조회
	 * PARAM : BRD_TYP_CD = #{brdTypCd}
			NT - 공지사항
			FA - faq
	 * RETURN : 게시판 목록
	 */
	public List selectBrdList(String param);
	
	/*
	 * 게시판 상세 조회
	 * PARAM : BRD_SQ = #{brdSq}
	 * RETURN : 게시판 상세
	 */
	public Map<String, Object> selectBrdDtl(String param);
	
}

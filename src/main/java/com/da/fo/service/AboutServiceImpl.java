package com.da.fo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.fo.dao.AboutDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AboutServiceImpl implements AboutService{
	
	@Autowired
	AboutDao aboutDao;
	
	/*
	 * 게시판 목록 조회
	 * PARAM : BRD_TYP_CD = #{brdTypCd}
			NT - 공지사항
			FA - faq
	 * RETURN : 게시판 목록
	 */
	public List selectBrdList(String param) {
		return aboutDao.selectBrdList(param);
	}
	
	/*
	 * 게시판 상세 조회
	 * PARAM : BRD_SQ = #{brdSq}
	 * RETURN : 게시판 상세
	 */
	public Map<String, Object> selectBrdDtl(String param){
		return aboutDao.selectBrdDtl(param);
	}
}

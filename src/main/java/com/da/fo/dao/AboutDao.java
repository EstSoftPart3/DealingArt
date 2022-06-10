package com.da.fo.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.da.mapper.AboutMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class AboutDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	AboutMapper aboutMapper;
	
	/*
	 * 게시판 목록 조회
	 * PARAM : BRD_TYP_CD = #{brdTypCd}
			NT - 공지사항
			FA - faq
	 * RETURN : 게시판 목록
	 */
	public List selectBrdList(String brdTypCd, String brdConTypCd) {
		return aboutMapper.selectBrdList(brdTypCd,brdConTypCd);
	}
	
	/*
	 * 게시판 상세 조회
	 * PARAM : BRD_SQ = #{brdSq}
	 * RETURN : 게시판 상세
	 */
	public Map<String, Object> selectBrdDtl(String param){
		return aboutMapper.selectBrdDtl(param);
	}
	
}

package com.da.bo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.da.mapper.loginMapper;
import com.mysema.commons.lang.Assert;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class loginDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	loginMapper loginMapper;
	
	public String memberLogin(Map<String, Object> param){
				
		
		String mbrSq = loginMapper.loginMember(param);
		
		String rMbrSq;
		
		
		if(mbrSq != null) {
			
			rMbrSq = mbrSq; 
		} else {
			rMbrSq = null;
		}
		
		return rMbrSq;
	}

	
	
	
	

}

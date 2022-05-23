package com.da.bo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.da.bo.dao.loginDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class loginServiceImpl implements loginService {
	

	@Autowired
	loginDao loginDao;
	
	@Override
	public String memberLogin(Map<String, Object> param){
			
		String mbrSq = loginDao.memberLogin(param);
		String rMbrSq;
		
		if(mbrSq != null) {
			
			rMbrSq = mbrSq; 
		} else {
			rMbrSq = null;
		}
		
		return rMbrSq;
		
	}

}

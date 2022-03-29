package com.da.sample.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.da.util.EncryptUtil;
import com.da.util.RestTemplateUtil;

@Service
public class CommonService {
	
	@Value("${est.dealing.juso.key}")
	private String jusoKey;
	
	@Value("${est.dealing.juso.url}")
	private String jusoUrl;
	
	@Autowired
	private RestTemplateUtil restTemplate; 
	
	@Autowired
	private EncryptUtil encryptUtil;
	
	/**
	 * encrypt
	 * @param msg
	 * @return
	 */
	public String encrypt(String msg) {
		
		String result = "";
		try {
			result = encryptUtil.encrypt(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * decrypt
	 * @param msg
	 * @return
	 */
	public String decrypt(String msg) {
		
		String result = "";
		try {
			result = encryptUtil.decrypt(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * juso search
	 * @param keyword
	 * @param currentPage
	 * @param countPerPage
	 * @return
	 */
	public Map<String, Object> getJusoDetail(String keyword, int currentPage, int countPerPage){
		
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		
		Map<String, Object> results = new HashMap<String, Object>();
		try {
			params.add("confmKey", jusoKey);
			params.add("currentPage", currentPage);
			params.add("countPerPage", countPerPage);
			params.add("keyword", keyword);
			params.add("resultType", "json");
			
			results = restTemplate.sendPostApi(jusoUrl, "juso", params);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	//Null Check
	public static boolean isEmpty(CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

}

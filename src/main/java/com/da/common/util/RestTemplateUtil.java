package com.da.common.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateUtil {
	
	JsonToMapUtil jsonToMapUtil = new JsonToMapUtil();
	
	RestTemplate restTemplate = new RestTemplate();
	
//	public Map sendGetApi(HttpServletRequest request, String uri, String confmKey) {
//		uri = "https://www.juso.go.kr/addrlink/addrLinkApiJsonp.do";
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		
//
//		params.put("confmKey", "devU01TX0FVVEgyMDIyMDMwNzE2NTA1NDExMjMyMDA=");
//		params.put("currentPage", 1);
//		params.put("countPerPage", 10);
//		params.put("keyword", "도평리");
//		params.put("resultType", "json");
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "test key");
//		Map result = restTemplate.getForObject(uri, Map.class);
//		String result = restTemplate.getForObject(uri, params, Map.class)

//		return result;
//	}
	
	public Map<String, Object> senPostApi(String url, String type, MultiValueMap<String, Object> params) {
		Map<String, Object> results = new HashMap<String, Object>();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(params, headers);
		ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);
		
		String reString = result.getBody();
		if(type.equals("juso")) {
			String conStr = reString.substring(1).replaceFirst(".$","");
			results = jsonToMapUtil.stringToJson(conStr);
		}else {
			results = jsonToMapUtil.stringToJson(reString);
		}
		
		return results;
	}

	public void test_exchange_put() {
		String URI = "http://localhost:8080/api/test/{memberId}";
//		Member member = new Member("gg_ty", "김태연", "0309");
		Map<String, String> params = new HashMap<>();
		params.put("memberId", "11");
//		ResponseEntity<String> result = restTemplate.exchange(URI, HttpMethod.PUT, new HttpEntity<>(member),
//				String.class, params);
	}
}

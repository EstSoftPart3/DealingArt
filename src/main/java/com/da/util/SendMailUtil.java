package com.da.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
public class SendMailUtil {
	@Autowired
	private RestTemplateUtil restTemplate; 
	
	@Autowired
	private EncryptUtil encryptUtil;
	
	
	@Value("${est.dealing.ncloud.accesskey}")
	String access_key;
	
	@Value("${est.dealing.ncloud.secretkey}")
	String secret_key;
	
	@Value("${est.dealing.ncloud.mail.url}")
	String url;
	
	@Value("${est.dealing.ncloud.mail.uri}")
	String mail_uri;
	
	@Value("${est.dealing.ncloud.mail.sender}")
	String sender;
	
	@Value("${est.dealing.ncloud.mail.sendername}")
	String sender_name;
	
	public Map<String, Object> sendMail(Map<String, Object> params){
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String uri = mail_uri;
		String timestamp = Long.toString(System.currentTimeMillis());

		url = url + uri;
		try {
			/**
			 * url, timestamp, method, accessKey, secretKey
			 */
			String signature = encryptUtil.nCloudMakeSignature(uri, timestamp, "POST", access_key, secret_key);
			
			params.put("senderAddress", sender);
			params.put("senderName", sender_name);
			params.put("timestamp", timestamp);
			params.put("access_key", access_key);
			params.put("signature", signature);
			
			System.out.println(url);
			System.out.println(params);
			
			rtnMap = restTemplate.sendNCloudPostApi(url, params);
			
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return rtnMap;
	}
}

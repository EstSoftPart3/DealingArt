package com.da.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class SendSmsUtil {
	
	@Autowired
	private RestTemplateUtil restTemplate; 
	
	@Autowired
	private EncryptUtil encryptUtil;
	
	
	@Value("${est.dealing.ncloud.accesskey}")
	String access_key;
	
//	@Value("${est.dealing.ncloud.secretkey}")
//	String secret_key;
	
	@Value("${est.dealing.ncloud.sms.url}")
	String url;
	
	@Value("${est.dealing.ncloud.sms.uri}")
	String sms_uri;
	
	@Value("${est.dealing.ncloud.sms.serviceid}")
	String service_id;
	
	@Value("${est.dealing.ncloud.sms.secretkey}")
	String secret_key;
	
	@Value("${est.dealing.ncloud.sms.type}")
	String type;
	
	@Value("${est.dealing.ncloud.sms.number}")
	String number;
	
	@Value("${est.dealing.ncloud.sms.contenttype}")
	String content_type;
	
	public Map<String, Object> sendSms(Map<String, Object> params){
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String uri = sms_uri + service_id + "/messages";
		String timestamp = Long.toString(System.currentTimeMillis());

		url = url + uri;
		try {
			/**
			 * url, timestamp, method, accessKey, secretKey
			 */
			String signature = encryptUtil.nCloudMakeSignature(uri, timestamp, "POST", access_key, secret_key);
			
			params.put("type", type);
			params.put("from", number);
			params.put("contentType", content_type);
			params.put("timestamp", timestamp);
			params.put("access_key", access_key);
			params.put("signature", signature);
			
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

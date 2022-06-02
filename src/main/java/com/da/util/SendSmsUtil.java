package com.da.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.da.mapper.NotiMapper;


@Component
public class SendSmsUtil {
	
	@Autowired
	private RestTemplateUtil restTemplate; 
	
	@Autowired
	private EncryptUtil encryptUtil;
	
	@Autowired
	NotiMapper NotiMapper;
	
	
	@Value("${est.dealing.ncloud.accesskey}")
	String access_key;
	
	@Value("${est.dealing.ncloud.secretkey}")
	String secret_key;
	
	@Value("${est.dealing.ncloud.sms.url}")
	String url;
	
	@Value("${est.dealing.ncloud.sms.uri}")
	String sms_uri;
	
	@Value("${est.dealing.ncloud.sms.serviceid}")
	String service_id;
	
//	@Value("${est.dealing.ncloud.sms.secretkey}")
//	String secret_key;
	
	@Value("${est.dealing.ncloud.sms.type}")
	String type;
	
	@Value("${est.dealing.ncloud.sms.number}")
	String number;
	
	@Value("${est.dealing.ncloud.sms.contenttype}")
	String content_type;
	
	public Map<String, Object> sendSms(Map<String, Object> params){
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String uri = sms_uri + "/" + service_id + "/messages";
		String timestamp = Long.toString(System.currentTimeMillis());

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
	
	public Map<String, Object> sendSmsProc(Map<String, Object> params){
		
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> sParams = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		
		
		//히스토리 테이블 카운터
		Map<String, Object> getParam = new HashMap<String, Object>();
				
		//보낸티입
		String sndTyp = "S";
		//보낸 컨텐츠 코드
		String sndConCd = (String) params.get("sndConCd");
		//보낼 회원 아이디
		String mbrId = (String) params.get("mbrId");
		//보낸 회원 번호
		String sndNumber = (String) params.get("mbrCpNum");
		
		//MBR_EMAIL
		
		getParam.put("sndTyp", sndTyp);
		getParam.put("sndConCd", sndConCd);
		getParam.put("mbrId", mbrId);
		getParam.put("sndNumber", sndNumber);
				
		int notiCount = NotiMapper.notiCount(getParam);
		
		if(notiCount == 0) {
		
			String smsContent = null;
			
			if(sndConCd.equals("SAA")) {
				smsContent = "{딜링아트} 작가 등록 신청 완료 안내\n\n안녕하세요, "+ mbrId +"작가님!\n작가 등록을 신청해주셔서 대단히 감사합니다.\n운영자 승인이 완료되면 마이페이지에서 ‘포트폴리오’ 메뉴를 확인하세요!\n\n[안내사항]\n- 작가 등록 등록이 완료된 후 포트폴리오 메뉴가 활성화 됩니다.\n- 학력, 경력, 소속, 전시정보를 허위로 입력하는 경우 작가 등록이 보류 될 수 있으니 유의해주세요.";
			} else {
				smsContent = "내용 없음";
			}
			
			
			
			tomap.put("to", sndNumber);
			mList.add(tomap);
				
			params.put("content", smsContent);
			params.put("messages", mList);
			
			rtnMap = this.sendSms(params);
			
			
			//히스토리 저장
			NotiMapper.notiInsert(getParam);
		
		}
		return params;
			
	}
}

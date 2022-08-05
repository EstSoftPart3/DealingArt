package com.da.util;

import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
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
			System.out.println("@@@@@@@parmas:"+params);
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
		String sndConCd = params.get("sndConCd").toString();
		//보낼 회원 아이디
		String mbrId = params.get("mbrId").toString();
		//보낼 회원 활동명
		String mbrNcknm = params.get("mbrNcknm").toString();
		//보낸 회원 번호
		String sndNumber = params.get("mbrCpNum").toString();
		
		
		String regDt = null;
		String sBidDt = null;
		String workNm = null;
		String bidPrc = null;
		String dealEndngDt = null;
		String bidDt = null;
		DecimalFormat dFormat = new DecimalFormat("###,###");
		//미술품 낙찰완료(구매자)
		if(sndConCd.equals("SSA")) {
			//등록일시	
			regDt = params.get("regDt").toString();
			//낙찰일시
			sBidDt = params.get("sBidDt").toString();
			//작품명
			workNm = params.get("workNm").toString();
			//최종낙찰가
			BigDecimal num = new BigDecimal(params.get("bidPrc").toString());
			bidPrc = dFormat.format(num);
		}
		
		//미술품 낙찰완료(판매자)
		if(sndConCd.equals("SSE")) {
			//등록일시	
			regDt = params.get("regDt").toString();
			//낙찰일시
			sBidDt = params.get("sBidDt").toString();
			//작품명
			workNm = params.get("workNm").toString();
			//최종낙찰가
			BigDecimal num = new BigDecimal(params.get("bidPrc").toString());
			bidPrc = dFormat.format(num);
		}
		
		//미술품 거래 유찰 안내 - 정찰
		if(sndConCd.equals("SRES")) {
			
			//작품명
			workNm = params.get("workNm").toString();
			//만료일시
			dealEndngDt = params.get("dealEndngDt").toString();
			
		}
		//미술품 거래 유찰 안내 - 정찰
		if(sndConCd.equals("SREA")) {
			
			//작품명
			workNm = params.get("workNm").toString();
			//만료일시
			dealEndngDt = params.get("dealEndngDt").toString();
			
		}
		//미술품 거래 종료 안내 - 경매
		if(sndConCd.equals("SAE")) {
			//작품명
			workNm = params.get("workNm").toString();
			//응찰일시
			bidDt = params.get("bidDt").toString();
			//만료일시
			dealEndngDt = params.get("dealEndngDt").toString();
		}
		
		/*
		1) 작가신청완료 	: SAA
		2) 낙찰알림		: SSA
		3) 정찰-거래종료	: SRES
		4) 경매-거래종료	: SREA
		5) 경매-거래종료	: SAE
		6) 경매-낙찰완료	: SSE
		*/
		
		getParam.put("sndTyp", sndTyp);
		getParam.put("sndConCd", sndConCd);
		getParam.put("mbrId", mbrId);
		getParam.put("sndNumber", sndNumber);
		
		
		if(sndNumber.equals("01000000000") || sndNumber.equals("01000001111") || sndNumber.equals("01000002222")) {
		}else {
				
			int notiCount = NotiMapper.notiCount(getParam);
		
			String smsContent = null;
			//
			if(sndConCd.equals("SAA") && notiCount == 0) {
				smsContent = "[딜링아트] 작가 등록 신청 완료 안내\n\n"
						+ "안녕하세요, "+mbrNcknm+"작가님!\n\n"
						+ "작가 등록을 신청해주셔서 대단히 감사합니다.\n"
						+ "운영자 승인이 완료되면 마이페이지에서 ‘포트폴리오’ 메뉴를 확인하세요!\n\n"
						+ "[안내사항]\n"
						+ "- 작가 등록 등록이 완료된 후 포트폴리오 메뉴가 활성화 됩니다.\n"
						+ "- 학력, 경력, 소속, 전시정보를 허위로 입력하는 경우 작가 등록이 보류 될 수 있으니 유의해주세요.";
			} else if(sndConCd.equals("SSA")) {
				smsContent = "[딜링아트] "+mbrNcknm+"님, 콜렉팅 성공!\n"
						+ "□구매 형식 : 경매 \n"
						+ "□응찰 일시 : "+regDt+" \n"
						+ "□낙찰 일시 : "+sBidDt+" \n"
						+ "□작품명 : "+workNm+" \n"
						+ "□최종 낙찰가 : "+bidPrc+" KRW 축하합니다.\n\n"
						+ "낙찰된 작품의 결제는 48시간 안에 진행해 주세요. 결제가 완료되면 운송 일정 및 부가 서비스 확인을 위해 고객센터에서 연락 드릴 예정입니다. 꼭! 받아주세요.\n"
						+ "[유의 사항]\n"
						+ "- 운송 방법은 프리미엄 운송 서비스와 직접 운송 중 필수로 이용해야 되며 설치, 포장이 필요한 경우 추가 선택이 가능합니다.\n"
						+ "- 작품/부가 서비스 미 결제, 운송 일정 조율에 대한 응답 거부, 작품 운송의 인계 및 수취 거부, 미술품 또는 보증서 의 허위, 변조, 조작, 딜링아트 서비스 이용 약관에 위반되는 행위가 발생되는 경우 거래가 취소 될 수 있습니다.";
			} else if(sndConCd.equals("SSE")) {
				smsContent = "[딜링아트]낙찰 완료 안내\n"
						+ "□판매형식 : 경매 \n"
						+ "□등록 일시 : "+regDt+" \n"
						+ "□낙찰 일시 : "+sBidDt+" \n"
						+ "□작품명 : "+workNm+" \n"
						+ "□최종 낙찰가 : "+bidPrc+" KRW 축하합니다.\n\n"
						+ mbrNcknm +"님! 등록하신 거래가 낙찰 되었습니다.\n"
						+ "구매자가 48시간 이내 결제를 완료하면 고객센터에서 운송 일정 확인을 위해 연락 드립니다.";
			} else if(sndConCd.equals("SRES")) {
				smsContent = "[딜링아트]미술품 거래 종료 안내\n\n"
						+ "□작품명 : "+workNm+"\n"
						+ "□판매 형식 : 정찰 \n"
						+ "□거래 종료 일시 : "+dealEndngDt+"\n\n"
						+ mbrNcknm +"님! 등록하신 미술품의 판매 기간이 만료되어 아쉽게도 판매가 종료되었습니다.\n다시 판매 하시려면 마이 페이지에서 거래 등록을 진행해주세요. ";
			} else if(sndConCd.equals("SREA")) {
				smsContent = "[딜링아트]미술품 유찰 안내\n\n"
						+ "□작품명 : "+workNm+"\n"
						+ "□판매 형식 : 경매 \n"
						+ "□거래 종료 일시 : "+dealEndngDt+"\n\n"
						+ mbrNcknm +"님! 등록하신 미술품이 기간 내에 응찰이 없어 아쉽게도 유찰 되었습니다.\n마이페이지 > 나의작품/소장품 메뉴에서 다시 거래 등록이 가능합니다.";
			} else if(sndConCd.equals("SAE")) {
				smsContent = "[딜링아트]미술품 거래 종료 안내\n\n"
						+ "□작품명 : "+workNm+"\n"
						+ "□구매형식 : 경매 \n"
						+ "□응찰일시 : "+bidDt+"\n"
						+ "□거래종료일시 : "+dealEndngDt+"\n\n"
						+ mbrNcknm+"님! 응찰 하신 미술품이 아쉽게도 다른 회원님께 낙찰되었습니다.";
			}
			
			
			if( (sndConCd.equals("SAA") && notiCount == 0) || sndConCd.equals("SSA") || sndConCd.equals("SREA") || sndConCd.equals("SRES") || sndConCd.equals("SAE") || sndConCd.equals("SSE") ) {
				
				tomap.put("to", sndNumber);
				mList.add(tomap);
					
				params.put("content", smsContent);
				params.put("messages", mList);
				
				System.out.println("######params:"+params);
				rtnMap = this.sendSms(params);
				
				
				//히스토리 저장
				NotiMapper.notiInsert(getParam);
			
			}
		}
		
		return params;
			
	}
}

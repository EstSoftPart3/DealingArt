package com.da.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.da.sample.service.CommonService;
import com.da.util.SendMailUtil;
import com.da.util.SendSmsUtil;

@Controller
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SendSmsUtil sendSmsUtil;
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@RequestMapping("/")
	public String index() {
		logger.info("index");
		
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		try {
			
		String reStr = commonService.encrypt("김영삼");
		
		String deStr = commonService.decrypt("68160dc64efc04a5a68dce5320b433b3");
		
		Map<String, Object> reMap = commonService.getJusoDetail("도평리", 1, 10);
		
		/**
		 * ----------------------------------------------------------
		 */
		
		testSms();
		
		testMail();
		
		logger.info("------------------------------------------");
		System.out.println(reStr);
		System.out.println(deStr);
		System.out.println(reMap);
		logger.info("------------------------------------------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "index";
	}
	
	@RequestMapping("/checkplus_success")
	public String checkplusSuccess() {
		return "checkplus_success";
	}
	
	@RequestMapping("/checkplus_fail")
	public String checkplusFail() {
		return "checkplus_fail";
	}
	
	@RequestMapping("/test-sms")
	public String testSms() {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		/**
		 * "content":"string",
		 * "messages":[
		        {
		            "to":"string"
		        }
		    ]
		 */
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		
		tomap.put("to", "01099428461");
		mList.add(tomap);
		
		params.put("content", "테스트에용");
		params.put("messages", mList);
		
		rtnMap = sendSmsUtil.sendSms(params);
		
		System.out.println(rtnMap);
		
		return rtnMap.get("statusCode").toString();
	}
	
	@RequestMapping("/test-mail")
	public String testMail() {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String result = "";
		/**
		 * "title":"string",
		 * "body":"string",
		 * "recipients":[
		        {
		            "address":"string",
		            "type":"R"
		        }
		    ]
		 */
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		
		//tomap.put("address", "dudtka37@naver.com");
		tomap.put("address", "isonaki@naver.com");
		tomap.put("type", "R");
		mList.add(tomap);
		
		params.put("title", "테스트에용 title");
		params.put("body", "테스트에용 content");
		params.put("recipients", mList);
		
		rtnMap = sendMailUtil.sendMail(params);
		
//		if(((int) Double.parseDouble(rtnMap.get("count").toString()) < 0)){
//			result = "error";
//		}else {
//			result = "OK";
//		}
		
		return result;
	}
}


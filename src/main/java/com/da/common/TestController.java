package com.da.common;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.da.sample.service.CommonService;

@Controller
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/")
	public String index() {
		logger.info("index");
		
		try {
			
		String reStr = commonService.encrypt("김영삼");
		
		String deStr = commonService.decrypt("68160dc64efc04a5a68dce5320b433b3");
		
		Map<String, Object> reMap = commonService.getJusoDetail("도평리", 1, 10);
		
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
}


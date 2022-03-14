package com.da.common;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String index() {
		logger.info("index");
		
		try {
			
		String reStr = commonService.encrypt("¡¾e¢¯¥ì¡íi");
		
		String deStr = commonService.decrypt("68160dc64efc04a5a68dce5320b433b3");
		
		Map<String, Object> reMap = commonService.getJusoDetail("¥ì¥ì¨¡o¢¬¢ç", 1, 10);
		
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


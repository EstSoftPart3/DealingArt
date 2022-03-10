package com.da.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.da.common.util.EncryptUtil;

@Configuration
public class CommonUsingSample {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EncryptUtil encUtil;
	
	public void encryptSample() {
		String reStr = "";
		try {
			reStr = encUtil.encrypt("sampleData");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("------------------------------------------");
		logger.info(reStr);
		logger.info("------------------------------------------");
	}
}

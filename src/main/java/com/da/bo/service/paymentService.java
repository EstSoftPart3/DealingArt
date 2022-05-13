package com.da.bo.service;

import java.util.Map;

public interface paymentService {
	
	
	//거래메인
	public Map<String, Object> dealMainList(Map<String, Object> param);
	
	
	public Map<String, Object> trnsprtList(Map<String, Object> param);

}

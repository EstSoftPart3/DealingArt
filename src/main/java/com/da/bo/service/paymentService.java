package com.da.bo.service;

import java.util.Map;

public interface paymentService {
	
	
	//거래메인
	public Map<String, Object> dealMainList(Map<String, Object> param);
	
	//거래 상세 - 결제
	public Map<String, Object> payDetail(Map<String, Object> param);
	
	//작품 정보
	public Map<String, Object> workInfo(Map<String, Object> param);
	
	
	public Map<String, Object> trnsprtList(Map<String, Object> param);

}

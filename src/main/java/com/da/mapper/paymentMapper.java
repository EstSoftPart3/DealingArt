package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface paymentMapper {
	
	//거래 메인
	public List dealMainList(Map<String, Object> param);
	
	//거래 운송 목록
	public List trnsprtList(Map<String, Object> param);

}

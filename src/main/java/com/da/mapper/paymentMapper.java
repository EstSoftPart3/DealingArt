package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface paymentMapper {
	
	//작품 거래 내역
	public List workDealhList(Map<String, Object> param);
	
	//거래 메인
	public List dealMainList(Map<String, Object> param);
	
	//거래 메인 수정 : 거래_상태_코드
	public void dealMainSttsCdUpdate(Map<String, Object> param);
	
	//거래 메인 수정 : 거래_메모
	public void dealMainMemoUpdate(Map<String, Object> param);
		
	//거래 상세 - 결제
	public List payDetail(Map<String, Object> param);
	
	//작품 상세
	public List workInfo(Map<String, Object> param);
	
	//거래 운송 목록
	public List trnsprtList(Map<String, Object> param);

}

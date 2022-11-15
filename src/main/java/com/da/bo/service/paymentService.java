package com.da.bo.service;

import java.util.List;
import java.util.Map;

public interface paymentService {
	//배송 부가서비스 삭제
	public int deleteTrnsprt(List<Map<String, Object>> param);
	
	//운송서비스 매트리스 조회
	public List<Map<String, Object>> selectTrnsprtPrcMtrx(Object param);
	
	//작품 거래 내역
	public Map<String, Object> workDealhList(Map<String, Object> param);
	
	//배송 서비스 정보 조회
	public List<Map<String, Object>> trnsprtInfo(String dealSq);
	
	//거래메인
	public Map<String, Object> dealMainList(Map<String, Object> param);
	
	//거래 상세 - 결제
	public Map<String, Object> payDetail(Map<String, Object> param);
	
	//작품 정보
	public Map<String, Object> workInfo(Map<String, Object> param);
	
	//거래 메인 수정 : 거래_상태_코드
	public void dealMainSttsCdUpdate(Map<String, Object> param);
	
	//거래 메인 수정 : 거래_메모_코드
	public void dealMainMemoUpdate(Map<String, Object> param);
	
	
	public Map<String, Object> trnsprtList(Map<String, Object> param);
	
	//거래 관련 파일 업로드
	public int dealFileUpload(Map<String, Object> param);
	
	//거래 관련 파일 삭제
	public int dealFileDelte(Map<String, Object> param);
	

}

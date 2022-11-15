package com.da.mapper;

import java.util.List;
import java.util.Map;

public interface paymentMapper {
	//배송 부가서비스 삭제
	public int deleteTrnsprt(Object param);
	
	//배송 서비스 정보 조회
	public List<Map<String, Object>> trnsprtInfo(String dealSq);
	
	//운송서비스 매트리스 조회
	public List<Map<String, Object>> selectTrnsprtPrcMtrx(Object param);
	
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
	
	//거래 관련 파일 업로드
	public int dealFileUpload(Map<String, Object> param);

	//거래 관련 파일 삭제
	public int dealFileDelte(Map<String, Object> param);
	
}

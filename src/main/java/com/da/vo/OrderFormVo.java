package com.da.vo;

import lombok.Data;

@Data
public class OrderFormVo {
	/*
	 * 주문 정보
	 */
	//주문번호
	private String mbrRefNo;
	//작품번호
	private String workSq;
	//주문일시
	private String paymntDt;
	//작품가
	private String dealFinalPrc;
	//판매자 2차 결제 완료 여부
	private String sellYn2PC;
	//구매자 2차 결제 완료 여부
	private String buyYn2PC;
	
	/*
	 * 운송 정보
	 */
	//운송 구분 (프리미엄 운송 / 직접 운송)
	private String trnsprtTypNm; 
	//운송 지역 (수도권 / 비수도권)
	private String trnsprtAreaNm;
	
	/*
	 * 부가서비스 (판매자)
	 */
	//작업 할증
	private String sellEC;
	
	/*
	 * 부가서비스 (구매자)
	 */
	//작품 설치
	private String buyIS;
	//작업 할증
	private String buyEC;
	
	/*
	 * 작품 정보
	 */
	//작품명
	private String workNm;
	//작가명
	private String artstActvtyNm;
	//제작년도
	private String workProdcYear;
	//사이즈
	private String workSize;
	//소재
	private String workMatrl;
	//작품 이미지
	private String workMainImgUrl;
	
	/*
	 * 판매자 정보
	 */
	//이름
	private String sellMbrNm;
	//핸드폰 번호
	private String sellMbrDelivryCpNum;
	//주소
	private String sellDelivryAddr;
	
	/*
	 * 구매자 정보
	 */
	//이름
	private String buyMbrNm;
	//핸드폰 번호
	private String buyMbrDelivryCpNum;
	//주소
	private String buyDelivryAddr;
}

package com.da.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MainPayMapper {

	/**
	 * MainPayReadyApi
	 * @param dataMap
	 */
	void insertMainPayRequest(Map dataMap);

	/**
	 * select ReadyApi Data
	 * @param paramMap
	 * @return 
	 */
	Map<String, Object> getMainPayRequest(String param);

	/**
	 * approval s inst
	 * @param paramMap
	 */
	void insertPayMnt(Map<String, Object> paramMap);

	/**
	 * api 결과 저장
	 * @param resultMap
	 */
	void instApiResult(Map<String, Object> resultMap);

	/**
	 * 구매 완료 데이터 리스트
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> getPaymentSuccessDataList(Map<String, Object> paramMap);
	
	/**
	 * 구매 완료 데이터 단건
	 * @param paramMap
	 * @return
	 */
	Map<String, Object> getPaymentSuccessData(Map<String, Object> paramMap);

	/**
	 * 전체 취소할 데이터
	 * @param paramMap
	 * @return
	 */
	Map<String, Object> getPaymentAllCancelData(Map<String, Object> paramMap);

	/**
	 * cancel 업데이트
	 * @param paramMap
	 */
	void updateCancelApi(Map<String, Object> paramMap);

	/**
	 * 환불 등록
	 * @param paramMap
	 */
	void instRefRegisterApi(Map<String, Object> paramMap);

	/**
	 * 환불 업데이트
	 * @param paramMap
	 */
	void updateRefundDataApi(Map<String, Object> paramMap);

	/**
	 * 현금영수증 발행
	 * @param paramMap
	 */
	void instCashReceiptTransApi(Map<String, Object> paramMap);

	/**
	 * 현금영수증 발행 데이터
	 * @param paramMap
	 * @return
	 */
	Map<String, Object> getCashReceiptTransData(Map<String, Object> paramMap);

	/**
	 * 현금영수증 발행 취소 업데이트
	 * @param paramMap
	 */
	void updateCashReceiptTransApi(Map<String, Object> paramMap);
	
	/**
	 * 현금영수증 발행 취소 업데이트
	 * @param paramMap
	 */
	void insertWorkDeal(Map<String, Object> paramMap);
	
	/**
	 * 1차 결제 구매자 순번 등록
	 * @param paramMap
	 */
	void updateDealBuyMbrSq(@Param("buyMbrSq") String buyMbrSq, @Param("dealSq") String deqlSq);
	
	/**
	 * 결제되면 작품 테이블에 판매여부를 Y로 바꾼다
	 * @param paramMap
	 */
	void updateWorkSaleYn(String paramMap);
	

}

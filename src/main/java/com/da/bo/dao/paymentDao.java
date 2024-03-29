package com.da.bo.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.da.mapper.DealMapper;
import com.da.mapper.paymentMapper;

@Repository
public class paymentDao {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPAQueryFactory queryFactory; //QueryDsl을 사용하기 위해
	
	@Autowired
	paymentMapper paymentMapper;
	
	@Autowired
	DealMapper dealMapper;
	
	//배송 부가서비스 삭제
	public int deleteTrnsprt(List<Map<String, Object>> param) {
		return paymentMapper.deleteTrnsprt(param);
	}
	
	//배송 서비스 정보 조회
	public List<Map<String, Object>> trnsprtInfo(String dealSq){
		return paymentMapper.trnsprtInfo(dealSq);
	}
	
	//운송서비스 매트리스 조회
	public List<Map<String, Object>> selectTrnsprtPrcMtrx(Object param){
		return paymentMapper.selectTrnsprtPrcMtrx(param);
	}
	
	//작품 거래 내역
	public Map<String, Object> workDealhList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> workDealInfo = paymentMapper.workDealhList(param);
		
		result.put("workDealInfo", workDealInfo);
				
		return result;
	}
	
	
	//거래 운송 목록
	public Map<String, Object> dealMainList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> dealInfo = paymentMapper.dealMainList(param);
		
		result.put("dealInfo", dealInfo);
				
		return result;
	}
	
	
	//거래 상세 - 결제
	public Map<String, Object> payDetail(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> detailInfo = paymentMapper.payDetail(param);
		
		result.put("detailInfo", detailInfo);
				
		return result;
	}
	
	//작품 정보
	public Map<String, Object> workInfo(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> workInfo = paymentMapper.workInfo(param);
		
		result.put("workInfo", workInfo);
				
		return result;
	}
	
	//거래 운송 목록
	public Map<String, Object> trnsprtList(Map<String, Object> param){
		
		Map<String, Object> result = new HashMap<>();
				
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> listInfo = paymentMapper.trnsprtList(param);
		
		result.put("listInfo", listInfo);
				
		return result;
	}
	/*
	 * [수수료 변경 Task]
	 * 관리자 주문 관리(paymentDao.java)
	 * 내용 : 거래 메인 수정 클래스에서 판매 수수료 구하는 로직 변경
	 */
	//거래 메인 수정 : 거래_상태_코드
	public void dealMainSttsCdUpdate(Map<String, Object> param){
		if(param.get("dealSttsCd").toString().equals("PC")) {
			Map<String, Object> workInfo = dealMapper.selectWorkAll(param.get("dealSq").toString());
			//7월18일18시~ 8월31일24시 판매수수료 이벤트 적용
			String dealFinalPrc = workInfo.get("dealFinalPrc").toString().replaceAll("\\,","");
			long dealSellFee = Math.round(Long.parseLong(dealFinalPrc) * 0.05); //판매 수수료 5프로를 구한다
			if(workInfo.get("eventYn").toString().equals("Y")) {
				long dealSellFeeEvnet = Math.round(dealSellFee * 0.5); //판매수수료 50프로 할인 이벤트
				dealSellFee = dealSellFeeEvnet;
			}else{
				dealSellFee = Math.round(Long.parseLong(dealFinalPrc) * 0.05); //판매 수수료 5프로를 구한다
			}
			long dealSellFee2 = dealSellFee + (Math.round(dealSellFee * 0.10)); //판매 수수료에 부과세를 더한다
			long dealCalcPrc = Long.parseLong(dealFinalPrc) - dealSellFee2; //작품 금액에서 최종 판매 수수료를 빼고 정산 금액을 구한다
			workInfo.put("dealSellFee", dealSellFee2);
			workInfo.put("dealCalcPrc", dealCalcPrc);
			dealMapper.updateDealWorkToPC(workInfo);
			dealMapper.insertCollectionAll(workInfo);
		}else {
			paymentMapper.dealMainSttsCdUpdate(param);
		}
	}
	
	//거래 메인 수정 :거래_메모
	public void dealMainMemoUpdate(Map<String, Object> param){
		paymentMapper.dealMainMemoUpdate(param);
	}
	
	//거래 관련 파일 업로드
	public int dealFileUpload(Map<String, Object> param) {
		return paymentMapper.dealFileUpload(param);
	}
	
	//거래 관련 파일 삭제
	public int dealFileDelte(Map<String, Object> param) {
		return paymentMapper.dealFileDelte(param);
	}

}

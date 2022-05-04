package com.da.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.da.mapper.MainPayMapper;
import com.mainpay.sdk.net.HttpSendTemplate;
import com.mainpay.sdk.utils.ParseUtils;

@Service
public class MainPayUtil_BAK {
	
	@Autowired
	private MainPayMapper mainPayMapper;
	
	@Autowired
	private EncryptUtil encryptUtil;
	
	@Value("${est.dealing.mainpay.return.url}")
	String returnUrl;
	
	@Value("${est.dealing.mainpay.std.apibase}")
	String stdApiBase;
	
	@Value("${est.dealing.mainpay.rest.url}")
	String restUrl;
	
	@Value("${est.dealing.mainpay.apikey}")
	String apiKey;
	
	@Value("${est.dealing.mainpay.mbrno}")
	String mbrNo;
	
	@Value("${est.dealing.mainpay.mbrrefno}")
	String mbrRefNo;
	
	@Value("${est.dealing.mainpay.userid}")
	String mUserId;
	
	@Value("${est.dealing.mainpay.close.url}")
	String closeUrl;
	
	@Value("${est.dealing.mainpay.ready.uri}")
	String readyUri;
	
	@Value("${est.dealing.mainpay.pay.uri}")
	String payUri;
	
	@Value("${est.dealing.mainpay.cancel.uri}")
	String cancelUri;
	
	@Value("${est.dealing.mainpay.cancel.all.uri}")
	String allCancelUri;
	
	@Value("${est.dealing.mainpay.refund.reg.uri}")
	String refRegUri;
	
	@Value("${est.dealing.mainpay.refund.sel.uri}")
	String refSelUri;
	
	@Value("${est.dealing.mainpay.refund.can.uri}")
	String refCanUri;
	
	@Value("${est.dealing.mainpay.receipt.trans.uri}")
	String receiptTransUri;
	
	@Value("${est.dealing.mainpay.receipt.cancel.uri}")
	String receiptCancelUri;


	/**
	 * Ready 
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> readyApi(Map<String, Object> paramMap) {
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> resultMap = new HashMap<String, Object>();
	     
		/*
		  API KEY (비밀키)
		 - 생성 : http://cp.mainpay.co.kr 고객지원>기술지원>암호화키관리
		 - 가맹점번호(mbrNo) 생성시 함께 만들어지는 key (테스트 완료후 real 서비스용 발급필요) */

		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		/* 가맹점 아이디(테스트 완료후 real 서비스용 발급필요)*/
		parameters.put("version", "V001");
		parameters.put("mbrNo", mbrNo);
		/* 가맹점 유니크 주문번호 (가맹점 고유ID 대체가능) 6byte~20byte*/
		parameters.put("mbrRefNo", mbrRefNo);
		parameters.put("paymethod", paramMap.get("paymethod").toString());
		/* 결제금액 (공급가+부가세)
		(#주의#) 페이지에서 전달 받은 값을 그대로 사용할 경우 금액위변조 시도가 가능합니다.
		 DB에서 조회한 값을 사용 바랍니다. */
		parameters.put("amount", paramMap.get("amount").toString());
		/* 상품명 max 30byte*/
		parameters.put("goodsName", paramMap.get("goods_name").toString());
		/* 상품코드 max 8byte*/
		parameters.put("goodsCode", paramMap.get("goods_code").toString());
		/*인증완료 시 호출 URL*/
		parameters.put("approvalUrl", returnUrl + "/payment/approval");
		/*결제창 close시 호출 URL*/
		parameters.put("closeUrl", returnUrl);
		
		/*고객명  max 30byte*/
		parameters.put("customerName", paramMap.get("customer_name").toString());
		parameters.put("customerEmail", paramMap.get("customer_email").toString());
		
		resultMap.put("goods_name", paramMap.get("goods_name"));
		resultMap.put("goods_code", paramMap.get("goods_code"));
		resultMap.put("mbr_no", paramMap.get("mbr_sq"));
	    /*=================================================================================================
	     *	READY API 호출 (**테스트 후 반드시 리얼-URL로 변경해야 합니다.**) 
	     *=================================================================================================*/
	    /*contentType은 json으로 지정 필요*/
//	    response.setContentType("application/json");
		String responseJson = "";
		
		/* READY API 호출   */
		String readyUrl = stdApiBase + readyUri; // 테스트용
		try {
			responseJson = HttpSendTemplate.post(readyUrl, parameters, apiKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    		 
		System.out.println("responseJson:"+responseJson);
				
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);        
		String resultCode = (String) responseMap.get("resultCode");        
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //READY API 호출 실패
			String errMessage = String.format("READY API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
		
			Map dataMap = (Map)responseMap.get("data");
			
			rsltMap.put("data", dataMap);
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			
			paramMap.put("aid", dataMap.get("aid").toString());
			paramMap.put("create_time", dataMap.get("createTime").toString());
			paramMap.put("expire_time", dataMap.get("expireTime").toString());
			
			mainPayMapper.instMainPayReadyApi(paramMap);
		}
		
		resultMap.put("method", "readyApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
	
	/**
	 * 결제승인
	 * @param paramMap
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> approval(Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		Map<String, Object> getMap = mainPayMapper.getReadyApiData(paramMap);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String resultCode = "";
	    String resultMessage = "";
		Map<String, String> parameters = new HashMap<String, String>();
		
		parameters.put("version", "V001");
		parameters.put("mbrNo", mbrNo);
		parameters.put("mbrRefNo", mbrRefNo);
		parameters.put("paymethod", getMap.get("paymethod").toString()); /*DB 저장정보*/
		parameters.put("amount", getMap.get("amount").toString()); /*DB 저장정보*/
		parameters.put("goodsName", getMap.get("goods_name").toString()); /*DB 저장정보*/
		parameters.put("goodsCode", getMap.get("goods_code").toString()); /*DB 저장정보*/
		parameters.put("approvalUrl", returnUrl + "/payment/close");
		parameters.put("closeUrl", returnUrl);
		parameters.put("customerName", getMap.get("mbr_nm").toString()); /*DB 저장정보*/
		parameters.put("customerEmail", encryptUtil.decrypt(getMap.get("mbr_email").toString())); /*DB 저장정보*/
		
		resultMap.put("aid", paramMap.get("aid"));
		
		if(parameters == null) {
			System.err.println("이미 결제가 완료 되었거나, 만료된 요청입니다.");
			
			resultCode = "00";
			resultMessage = "이미 결제가 완료 되었거나, 만료된 요청입니다.";
		}
	
		/*승인요청 파라미터 세팅*/
		parameters.put("aid", paramMap.get("aid").toString());
		parameters.put("authToken", paramMap.get("authToken").toString());
		parameters.put("merchantData", paramMap.get("merchantData").toString());
		parameters.put("payType", paramMap.get("payType").toString());
	
		String responseJson = "";
		Map responseMap = null;
	    try{
	    	/* 결제준비 API 호출   */
	    	String payUrl = stdApiBase + payUri;
	    	responseJson = HttpSendTemplate.post(payUrl, parameters, apiKey);
	    } catch(Exception e) {
	    	/* 망취소 처리(승인API 호출 도중 응답수신에 실패한 경우) */
	    	String netCancelUrl = stdApiBase + cancelUri;
	    	try {
				HttpSendTemplate.post(netCancelUrl, parameters, apiKey);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	resultCode="C300";
	    	resultMessage = String.format("승인 API 결과 수신 실패 : %s", e.getMessage());
	    	
			resultMap.put("method", "approvalApi");
			resultMap.put("resultCode", resultCode);
			resultMap.put("resultMessage", resultMessage);
			
			mainPayMapper.instApiResult(resultMap);
	    }
		 
		responseMap = ParseUtils.fromJson(responseJson, Map.class);
	    resultCode = (String) responseMap.get("resultCode");
	    resultMessage = (String) responseMap.get("resultMessage");
	    
	    //승인API 호출 실패
	    if( ! "200".equals(resultCode)) {
	    	System.err.println(responseJson);
	    }else {
	   
		    Map dataMap = (Map) responseMap.get("data");
		    
		    System.out.println(dataMap);
		    
			String refNo = (String) dataMap.get("refNo");
			String tranDate = (String) dataMap.get("tranDate");
			String mbrRefNo = (String) dataMap.get("mbrRefNo");
			String applNo = (String) dataMap.get("applNo");
			String amount = (String) dataMap.get("amount");
			String payType = (String) dataMap.get("payType");
			String taxAmount = (String) dataMap.get("taxAmount");
			String feeAmount = (String) dataMap.get("feeAmount");
			String taxFreeAmount = (String) dataMap.get("taxFreeAmount");
			String cardNo = (String) dataMap.get("cardNo");
			String issueCompanyNo = (String) dataMap.get("issueCompanyNo");
			String issueCompanyName = (String) dataMap.get("issueCompanyName");
			String issueCardName = (String) dataMap.get("issueCardName");
			String acqCompanyNo = (String) dataMap.get("acqCompanyNo");
			String acqCompanyName = (String) dataMap.get("acqCompanyName");
			String merchant = (String) dataMap.get("merchantData");
			String installment = (String) dataMap.get("installment");
			
			paramMap.put("auth_token", paramMap.get("authToken").toString());
			paramMap.put("pay_type", payType);
			paramMap.put("ref_no", refNo);
			paramMap.put("tran_date", tranDate);
			paramMap.put("mbr_ref_no", mbrRefNo);
			paramMap.put("appl_no", applNo);
			paramMap.put("amount", amount);
			paramMap.put("tax_amount", taxAmount);
			paramMap.put("fee_amount", feeAmount);
			paramMap.put("tax_free_amount", taxFreeAmount);
			paramMap.put("card_no", cardNo);
			paramMap.put("issue_company_no", issueCompanyNo);
			paramMap.put("issue_company_name", issueCompanyName);
			paramMap.put("issue_card_name", issueCardName);
			paramMap.put("acq_company_no", acqCompanyNo);
			paramMap.put("acq_company_name", acqCompanyName);
			paramMap.put("merchant", merchant);
			paramMap.put("installment", installment);
			
			mainPayMapper.instMainPayApprovalS(paramMap);
			
	    }
		
	    resultMap.put("method", "approvalApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		rsltMap.put("resultCode", resultCode);
		rsltMap.put("resultMessage", resultMessage);
		
		return rsltMap;
	}
	
	/**
	 * 결제 완료 데이터
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getPaymentSuccessDataList(Map<String, Object> paramMap){
		
		List<Map<String, Object>> rsltList = new ArrayList<Map<String, Object>>();
		
		rsltList = mainPayMapper.getPaymentSuccessDataList(paramMap);
		
		return rsltList;
	}
	
	/**
	 * 전체 결제 취소
	 * @param paramMap
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> mainPayAllCancel(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentAllCancelData(paramMap);
	     
		/* Request 파라미터 map 생성 */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		parameters.put("version", "1.0");
		parameters.put("mbrNo", mbrNo);
		parameters.put("mbrRefNo", getMap.get("mbr_ref_no").toString()); 
		
		parameters.put("orgRefNo", getMap.get("ref_no").toString());
		parameters.put("orgTranDate", getMap.get("tran_date").toString());
		parameters.put("paymethod", getMap.get("paymethod").toString());
		parameters.put("amount", getMap.get("amount").toString());
		parameters.put("payType", getMap.get("pay_type").toString());
		parameters.put("isNetCancel", "N");
		parameters.put("customerName", getMap.get("mbr_nm").toString());
		parameters.put("customerEmail", encryptUtil.decrypt(getMap.get("mbr_email").toString()));
		
		String responseJson = "";
		try{
			responseJson = HttpSendTemplate.post(restUrl + allCancelUri, parameters, apiKey);
		} catch(Exception e) {
			System.err.println(String.format("CANCEL API 호출결과 수신실패 : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API 호출 실패
			String errMessage = String.format("CANCEL API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
		
			Map dataMap = (Map)responseMap.get("data");
			String refNo = (String) dataMap.get("refNo");
			String tranDate = (String) dataMap.get("tranDate");
			String tranTime = (String) dataMap.get("tranTime");
			
			paramMap.put("cancel_yn", "Y");
			paramMap.put("sid", getMap.get("sid"));
			paramMap.put("cancel_ref_no", dataMap.get("refNo"));
			paramMap.put("cancel_tran_date", dataMap.get("tranDate"));
			paramMap.put("cancel_tran_time", dataMap.get("tranTime"));
			
			mainPayMapper.updateCancelApi(paramMap);
	
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON 응답 리턴시에 사용)
		}
		
		resultMap.put("method", "cancelApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
	
	/**
	 * 환불 등록
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayRefRegister(Map<String, Object> paramMap){
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request 파라미터 map 생성 */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		parameters.put("version", "1.0");
		parameters.put("mbrNo", mbrNo);
		parameters.put("mbrRefNo", getMap.get("mbr_ref_no").toString()); 
		parameters.put("objectRefNo", getMap.get("ref_no").toString());
		parameters.put("objectTranDate", getMap.get("tran_date").toString());
		parameters.put("objectPaymethod", getMap.get("paymethod").toString());
		
		parameters.put("bankCode", paramMap.get("bank_code").toString());
		parameters.put("accountNo", paramMap.get("account_no").toString());
		parameters.put("accountOwner", paramMap.get("account_owner").toString());
		parameters.put("birthDay", paramMap.get("birth_day").toString());
		parameters.put("requestUser", mUserId);
		
		parameters.put("amount", getMap.get("amount").toString());
		parameters.put("requestSystem", getMap.get("merchant").toString());
		
		String responseJson = "";
		try{
			responseJson = HttpSendTemplate.post(restUrl + refRegUri, parameters, apiKey);
		} catch(Exception e) {
			System.err.println(String.format("CANCEL API 호출결과 수신실패 : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API 호출 실패
			String errMessage = String.format("refRegApi API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
			Map dataMap = (Map)responseMap.get("data");
			
			paramMap.put("sid", getMap.get("sid"));
			
			paramMap.put("mbr_no", mbrNo);
			paramMap.put("mbr_ref_no", dataMap.get("mbrRefNo").toString()); 
			paramMap.put("ref_no", dataMap.get("refNo").toString());
			paramMap.put("tran_date", dataMap.get("tranDate").toString());
			paramMap.put("paymethod", getMap.get("paymethod").toString());
			
			paramMap.put("request_user", mUserId);
			
			paramMap.put("amount", getMap.get("amount").toString());
			paramMap.put("refund_yn", "N");
			paramMap.put("cancel_yn", "N");
			
			mainPayMapper.instRefRegisterApi(paramMap);
	
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON 응답 리턴시에 사용)
		}
		
		resultMap.put("method", "refRegApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
	
	/**
	 * 환불 상태 조회
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayRefSelect(Map<String, Object> paramMap){
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request 파라미터 map 생성 */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		parameters.put("version", "1.0");
		parameters.put("mbrNo", mbrNo);
		parameters.put("orgRefNo", getMap.get("ref_no").toString());
		parameters.put("requestUser", mUserId);
		parameters.put("requestSystem", getMap.get("merchant").toString());
		
		String responseJson = "";
		try{
			responseJson = HttpSendTemplate.post(restUrl + refSelUri, parameters, apiKey);
		} catch(Exception e) {
			System.err.println(String.format("CANCEL API 호출결과 수신실패 : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "0000".equals(resultCode)) { //CANCEL API 호출 실패
			String errMessage = String.format("refSelApi API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
		
			paramMap.put("sid", getMap.get("sid"));
			paramMap.put("refund_yn", "Y");
			
			mainPayMapper.updateRefundDataApi(paramMap);
	
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON 응답 리턴시에 사용)
		}
		
		resultMap.put("method", "refSelApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}

	/**
	 * 환불 취소
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayRefCancel(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request 파라미터 map 생성 */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		parameters.put("version", "1.0");
		parameters.put("mbrNo", mbrNo);
		parameters.put("mbrRefNo", getMap.get("mbr_ref_no").toString()); 
		parameters.put("orgRefNo", getMap.get("ref_no").toString());
		parameters.put("requestUser", mUserId);
		parameters.put("requestSystem", getMap.get("merchant").toString());
		
		String responseJson = "";
		try{
			responseJson = HttpSendTemplate.post(restUrl + refCanUri, parameters, apiKey);
		} catch(Exception e) {
			System.err.println(String.format("CANCEL API 호출결과 수신실패 : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API 호출 실패
			String errMessage = String.format("refCanApi API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON 응답 리턴시에 사용)
		}
		
		resultMap.put("method", "refCanApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
	
	/**
	 * 현금영수증 발행
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayCashReceiptTrans(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request 파라미터 map 생성 */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		parameters.put("version", "1.0");
		parameters.put("mbrNo", mbrNo);
		parameters.put("mbrRefNo", getMap.get("mbr_ref_no").toString());
		
		parameters.put("personType", paramMap.get("person_type").toString());
		
		/*자진발급번호 01000001234 고정*/
		parameters.put("customerPk", paramMap.get("customer_pk").toString());
		
		parameters.put("amount", getMap.get("amount").toString());
		parameters.put("taxAmt", getMap.get("tax_amount").toString());
		parameters.put("feeAmt", getMap.get("fee_amount").toString());
		parameters.put("goodsName", getMap.get("goods_name").toString());
		parameters.put("customerName", getMap.get("mbr_nm").toString());
		
		String responseJson = "";
		try{
			responseJson = HttpSendTemplate.post(restUrl + receiptTransUri, parameters, apiKey);
		} catch(Exception e) {
			System.err.println(String.format("CANCEL API 호출결과 수신실패 : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API 호출 실패
			String errMessage = String.format("recTransApi API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
			
			Map dataMap = (Map)responseMap.get("data");
			
			paramMap.put("sid", getMap.get("sid"));
			
			paramMap.put("mbr_no", mbrNo);
			paramMap.put("mbr_ref_no", dataMap.get("mbr_ref_no").toString()); 
			paramMap.put("ref_no", dataMap.get("refNo").toString());
			paramMap.put("tran_date", dataMap.get("tranDate").toString());
			paramMap.put("amount", dataMap.get("amount").toString());
			paramMap.put("tax_amount", dataMap.get("taxAmount").toString());
			paramMap.put("fee_amount", dataMap.get("feeAmount").toString());
			paramMap.put("appl_no", dataMap.get("applNo").toString());
			
			mainPayMapper.instCashReceiptTransApi(paramMap);
			
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON 응답 리턴시에 사용)
		}
		
		resultMap.put("method", "recTransApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}

	/**
	 * 현금영수증 발행 취소
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayCashReceiptCancel(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getCashReceiptTransData(paramMap);
	     
		/* Request 파라미터 map 생성 */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		parameters.put("version", "1.0");
		parameters.put("mbrNo", mbrNo);
		parameters.put("mbrRefNo", getMap.get("mbr_ref_no").toString());
		parameters.put("orgRefNo", getMap.get("ref_no").toString());
		parameters.put("orgTranDate", getMap.get("tran_date").toString());
		parameters.put("amount", getMap.get("amount").toString());
		
		String responseJson = "";
		try{
			responseJson = HttpSendTemplate.post(restUrl + receiptCancelUri, parameters, apiKey);
		} catch(Exception e) {
			System.err.println(String.format("CANCEL API 호출결과 수신실패 : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API 호출 실패
			String errMessage = String.format("recTransApi API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
			
			Map dataMap = (Map)responseMap.get("data");
			
			paramMap.put("sid", getMap.get("sid"));
			paramMap.put("cancel_yn", "Y");
			
			mainPayMapper.updateCashReceiptTransApi(paramMap);
			
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON 응답 리턴시에 사용)
		}
		
		resultMap.put("method", "recTransApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
}

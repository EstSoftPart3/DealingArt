package com.da.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.da.mapper.MainPayMapper;
import com.da.mapper.MyPageMapper;
import com.mainpay.sdk.net.HttpSendTemplate;
import com.mainpay.sdk.utils.ParseUtils;

@Service
public class MainPayUtil {
	
	@Autowired
	private MainPayMapper mainPayMapper;
	
	@Autowired
	private EncryptUtil encryptUtil;
	
	@Autowired
	private MyPageMapper myPageMapper;
	
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
	 * @throws ParseException 
	 */
	public Map<String, Object> readyApi(Map<String, Object> paramMap){
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		/*
		  API KEY (비밀키)
		 - 생성 : http://cp.mainpay.co.kr 고객지원>기술지원>암호화키관리
		 - 가맹점번호(mbrNo) 생성시 함께 만들어지는 key (테스트 완료후 real 서비스용 발급필요) */

		Map<String, String> parameters = new HashMap<String, String>();
		//JSONObject parameters = new JSONObject();
		
		/*=================================================================================================
		 *	필수 파라미터 
		 *=================================================================================================*/
		/* 가맹점 아이디(테스트 완료후 real 서비스용 발급필요)*/
		parameters.put("version", "V001"); //버전정보 (샘플코드값 사용)
		/* 결제 허용할 카드사 번호 리스트*/
		//String availableCard = "['02', '03', '05', '07', '11', '12', '15', '20', '22', '23', '24', '25', '26', '28', '31', '34', 'SP', 'UP', 'PC', 'AV', 'AM', 'AJ', 'NP']";
		String availableCard = "['02', '03', '05', '07', '11', '12', '15', '20', '22', '23', '24', '25', '26', '28', '31', '34', 'SP', 'UP', 'PC', 'AV', 'AM', 'AJ', 'NP']";
		//String[] availableCard = {"01", "02", "03", "11"};
		//ArrayList<String> availableCards = new ArrayList<String>(Arrays.asList(availableCard));
		//Gson gson = new Gson();
		//JsonArray availableCards = new JsonArray();
		//availableCards = gson.fromJson(availableCard, availableCards.getClass());
		JSONArray availableCards = new JSONArray(availableCard);
		//JSONObject availableCards = new JSONObject(availableCard1);
		
		parameters.put("availableCards", availableCards.toString());
		parameters.put("mbrNo", mbrNo); //섹타나인에서 부여한 가맹점 번호 (상점 아이디)
		/* 가맹점 유니크 주문번호 (가맹점 고유ID 대체가능) 6byte~20byte*/
		parameters.put("mbrRefNo", paramMap.get("mbrRefNo").toString()); //가맹점주문번호 (가맹점에서 생성한 중복되지 않는 번호)
		parameters.put("paymethod", paramMap.get("paymethod").toString()); //지불수단 (CARD: 신용카드 | VACCT: 가상계좌 | ACCT: 계좌이체 | HPP: 휴대폰소액)(*)간편결제는 "CARD"에 포함되어 있음
		/* 결제금액 (공급가+부가세)
		(#주의#) 페이지에서 전달 받은 값을 그대로 사용할 경우 금액위변조 시도가 가능합니다.
		 DB에서 조회한 값을 사용 바랍니다. */
		parameters.put("amount", paramMap.get("amount").toString()); //총결제금액
		/* 상품명 max 30byte*/
		parameters.put("goodsName", paramMap.get("goodsName").toString()); //상품명 (일부 특수문자는 사용불가 합니다.)
		/* 상품코드 max 8byte*/
		//parameters.put("goodsCode", paramMap.get("goods_code").toString());
		/*인증완료 시 호출 URL*/
		parameters.put("approvalUrl", returnUrl + "/payment/approval"); //인증결과 수신페이지 예) https://상점도메인/approval (주의) URL내에 &,=등의 특수문자 허용안됨)
		/*결제창 close시 호출 URL*/
		parameters.put("closeUrl", returnUrl + "/payment/close"); //결제종료 수신페이지 URL 예) https://상점도메인/close (주의) URL내에 &,=등의 특수문자 허용안됨)
		
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
			System.out.println(parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    		 
		System.out.println("responseJson:"+responseJson);
		//박상현	ParseUtils ??
		Map<String, Object> responseMap = ParseUtils.fromJson(responseJson, Map.class);        
		String resultCode = responseMap.get("resultCode").toString();        
		String resultMessage = responseMap.get("resultMessage").toString();

		if( ! "200".equals(resultCode)) { //READY API 호출 실패
			String errMessage = String.format("READY API 호출결과 : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
		
			Map<String, Object> dataMap = (Map<String, Object>) responseMap.get("data");
			
			rsltMap.put("data", dataMap);
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			
			paramMap.put("aid", dataMap.get("aid").toString());
			paramMap.put("createTime", dataMap.get("createTime").toString());
			paramMap.put("expireTime", dataMap.get("expireTime").toString());
			paramMap.put("resultCode", resultCode);
			paramMap.put("resultMessage", resultMessage);
			
			/*결제 준비 정보*/
//			rsltMap.put("amount", paramMap.get("amount"));
//			rsltMap.put("sellMbrSq", paramMap.get("sellMbrSq"));
//			rsltMap.put("buyMbrSq", paramMap.get("buyMbrSq"));
//			rsltMap.put("dealSq", paramMap.get("dealSq"));
//			rsltMap.put("workSq", paramMap.get("workSq"));
//			rsltMap.put("cuponSq", paramMap.get("cuponSq"));
//			rsltMap.put("paymntDivCd", paramMap.get("paymntDivCd"));
//			rsltMap.put("paymntTypCd", paramMap.get("paymntTypCd"));
//			rsltMap.put("paymntAmt", paramMap.get("paymntAmt"));
//			rsltMap.put("paymntFeeAmt", paramMap.get("paymntFeeAmt"));
//			rsltMap.put("paymntDiscAmt", paramMap.get("paymntDiscAmt"));
//			rsltMap.put("paymethod", paramMap.get("paymethod"));
//			rsltMap.put("authToken", paramMap.get("authToken"));
//			rsltMap.put("aid", paramMap.get("aid"));
			
			mainPayMapper.insertMainPayRequest(paramMap);
		}
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ rsltMap : " + rsltMap);
		
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
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> parameters = mainPayMapper.getMainPayRequest(paramMap.get("aid").toString());
		Map<String, Object> param = new HashMap<>();
		
		System.out.println("################################# 결제 paramMap :"+paramMap);
		String resultCode = "";
	    String resultMessage = "";
	    
		if(MapUtils.isEmpty(paramMap)) {
			System.err.println("이미 결제가 완료 되었거나, 만료된 요청입니다.");
			
			resultCode = "00";
			resultMessage = "이미 결제가 완료 되었거나, 만료된 요청입니다.";
		}
		
		/*승인요청 파라미터 세팅*/
		param.put("version", "V001"); //버전정보
		param.put("mbrNo", mbrNo); //섹터나인에서 부여한 가맹점 번호(상점 아이디)
		param.put("aid", paramMap.get("aid").toString());
		param.put("mbrRefNo", parameters.get("mbrRefNo").toString());
		param.put("authToken", paramMap.get("authToken").toString()); //거래인증용 토큰, approvalUrl에서 수신한 값사용
		param.put("paymethod", paramMap.get("paymethod").toString());
		param.put("amount", parameters.get("amount").toString());
		
		String responseJson = "";
		Map<String, Object> responseMap = new HashMap<>();
	    try{
	    	/* 결제준비 API 호출   */
	    	String payUrl = stdApiBase + payUri;
	    	responseJson = HttpSendTemplate.post(payUrl, param, apiKey);
	    } catch(Exception e) {
	    	/* 망취소 처리(승인API 호출 도중 응답수신에 실패한 경우) */
	    	String netCancelUrl = stdApiBase + cancelUri;
	    	try {
				HttpSendTemplate.post(netCancelUrl, param, apiKey);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	resultCode="C300";
	    	resultMessage = String.format("승인 API 결과 수신 실패 : %s", e.getMessage());
	    	System.out.println(resultMessage + "resultCode : " + resultCode);
			//mainPayMapper.instApiResult(resultMap);
	    }
		 
		responseMap = ParseUtils.fromJson(responseJson, Map.class);
	    resultCode = (String) responseMap.get("resultCode");
	    resultMessage = (String) responseMap.get("resultMessage");
	    
	    //승인API 호출 실패
	    if( ! "200".equals(resultCode)) {
	    	//System.err.println(responseMap);
	    	
	    	return responseMap;
	    }else {
	    	Map dataMap = (Map) responseMap.get("data");
		   
	    	System.out.println(dataMap);
	    	/*결제 준비 정보*/
	    	resultMap.put("sellMbrSq", parameters.get("sellMbrSq"));
	    	resultMap.put("buyMbrSq", parameters.get("buyMbrSq"));
	    	resultMap.put("dealSq", parameters.get("dealSq"));
	    	resultMap.put("dealTypCd", parameters.get("dealTypCd"));
	    	resultMap.put("workSq", parameters.get("workSq"));
	    	resultMap.put("artstSq", parameters.get("artstSq"));
	    	resultMap.put("cuponSq", parameters.get("cuponSq"));
	    	resultMap.put("paymntDivCd", parameters.get("paymntDivCd"));
	    	resultMap.put("paymntTypCd", parameters.get("paymntTypCd"));
	    	resultMap.put("paymntAmt", parameters.get("paymntAmt"));
	    	resultMap.put("paymntFeeAmt", parameters.get("paymntFeeAmt"));
	    	resultMap.put("paymntDiscAmt", parameters.get("paymntDiscAmt"));
	    	resultMap.put("paymethod", parameters.get("paymethod"));
	    	resultMap.put("authToken", parameters.get("authToken"));
	    	resultMap.put("aid", parameters.get("aid"));
	    	resultMap.put("goodsName", parameters.get("goodsName"));
	    	/*결제 완료 기본 정보*/
	    	resultMap.put("mbrRefNo", dataMap.get("mbrRefNo"));
	    	resultMap.put("refNo", dataMap.get("refNo"));
	    	resultMap.put("tranDate", dataMap.get("tranDate"));
	    	resultMap.put("tranTime", dataMap.get("tranTime"));
	    	resultMap.put("amount", dataMap.get("amount"));
	    	resultMap.put("taxAmount", dataMap.get("taxAmount"));
	    	resultMap.put("feeAmount", dataMap.get("feeAmount"));
	    	resultMap.put("taxFreeAmount", dataMap.get("taxFreeAmount"));
	    	/*신용카드 결제시*/
		    resultMap.put("installment", dataMap.get("installment"));
		    resultMap.put("applNo", dataMap.get("applNo"));
		    resultMap.put("cardNo", dataMap.get("cardNo"));
		    resultMap.put("issueCompanyNo", dataMap.get("issueCompanyNo"));
		    resultMap.put("issueCompanyName", dataMap.get("issueCompanyName"));
		    resultMap.put("issueCardName", dataMap.get("issueCardName"));
		    resultMap.put("acqCompanyNo", dataMap.get("acqCompanyNo"));
		    resultMap.put("acqCompanyName", dataMap.get("acqCompanyName"));
		    resultMap.put("payType", dataMap.get("payType"));
		    /*계좌이체 또는 가상계좌 거래시*/
		    resultMap.put("bankCode", dataMap.get("bankCode"));
		    resultMap.put("accountNo", dataMap.get("accountNo"));
		    resultMap.put("accountCloseDate", dataMap.get("accountCloseDate"));
		    resultMap.put("accountCloseDate", dataMap.get("accountCloseDate"));
		    //거래내역 테이블에 내역을 insert한다
		    mainPayMapper.insertPayMnt(resultMap);
	    	
	    	//가상계좌가 아닐 경우
	    	if(!parameters.get("paymethod").toString().equals("VACCT")) {
	    		//거래내역 테이블에 구매자/판매자 정보와 작품 가격, 판매 수수료, 정산 금액을 저장한다. 
	    		mainPayMapper.insertWorkDeal(resultMap);
	    		//1차 결제이며 구매자인 경우 거래 상태 코드를 1차 결제 완료로 바꾼다.
			    if(parameters.get("paymntDivCd").toString().equals("B") && parameters.get("paymntTypCd").toString().equals("1")) {
			    	parameters.put("dealBuyFee", parameters.get("paymntFeeAmt").toString()); //구매 수수료를 가져온다
					mainPayMapper.insertWorkDeal(parameters); //거래 내역에 구매 수수료와 구매자를 입력한다
			    	mainPayMapper.updateDealBuyMbrSq(parameters.get("buyMbrSq").toString(), parameters.get("dealSq").toString(), parameters.get("dealTypCd").toString());
			    	myPageMapper.updateBuyPaymntSttsCd(parameters.get("dealSq").toString(), "2PW");
			    	mainPayMapper.updateWorkSaleYn(parameters.get("workSq").toString());
			    }
			    //2차 결제이며 판매자인 경우 거래 상태 코드를 2차 결제 완료로 바꾼다.
			    if(parameters.get("paymntDivCd").toString().equals("S") && parameters.get("paymntTypCd").toString().equals("2")) {
			    	mainPayMapper.insertWorkDeal(parameters); //거래 내역에 판매자를 입력한다
			    	myPageMapper.updateSellPaymntSttsCd(parameters.get("dealSq").toString(), "2PC");
			    }
			    //2차 결제이며 구매자인 경우 거래 상태 코드를 2차 결제 완료로 바꾼다.
			    if(parameters.get("paymntDivCd").toString().equals("B") && parameters.get("paymntTypCd").toString().equals("2")) {
			    	myPageMapper.updateBuyPaymntSttsCd(parameters.get("dealSq").toString(), "2PC");
			    }
			    //쿠폰 사용하면 사용롼료로 바꾼다
			    if(parameters.get("cuponSq") != null && !parameters.get("cuponSq").toString().equals("")) {
			    	mainPayMapper.updateCouponUseYn(resultMap);
			    }
	    	}
	    }
    	
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
		parameters.put("mbrRefNo", getMap.get("mbrRefNo").toString()); 
		
		parameters.put("orgRefNo", getMap.get("refNo").toString());
		parameters.put("orgTranDate", getMap.get("tranDate").toString());
		parameters.put("paymethod", getMap.get("paymethod").toString());
		parameters.put("amount", getMap.get("amount").toString());
		parameters.put("payType", getMap.get("payType").toString());
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
			
			paramMap.put("cancelYn", "Y");
			paramMap.put("sid", getMap.get("sid"));
			paramMap.put("cancel_refNo", dataMap.get("refNo"));
			paramMap.put("cancel_tranDate", dataMap.get("tranDate"));
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
		parameters.put("mbrRefNo", getMap.get("mbrRefNo").toString()); 
		parameters.put("objectRefNo", getMap.get("refNo").toString());
		parameters.put("objectTranDate", getMap.get("tranDate").toString());
		parameters.put("objectPaymethod", getMap.get("paymethod").toString());
		
		parameters.put("bankCode", paramMap.get("bankCode").toString());
		parameters.put("accountNo", paramMap.get("accountNo").toString());
		parameters.put("accountOwner", paramMap.get("accountOwner").toString());
		parameters.put("birthDay", paramMap.get("birthDay").toString());
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
			
			paramMap.put("mbrSq", mbrNo);
			paramMap.put("mbrRefNo", dataMap.get("mbrRefNo").toString()); 
			paramMap.put("refNo", dataMap.get("refNo").toString());
			paramMap.put("tranDate", dataMap.get("tranDate").toString());
			paramMap.put("paymethod", getMap.get("paymethod").toString());
			
			paramMap.put("request_user", mUserId);
			
			paramMap.put("amount", getMap.get("amount").toString());
			paramMap.put("refundYn", "N");
			paramMap.put("cancelYn", "N");
			
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
		parameters.put("orgRefNo", getMap.get("refNo").toString());
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
			paramMap.put("refundYn", "Y");
			
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
		parameters.put("mbrRefNo", getMap.get("mbrRefNo").toString()); 
		parameters.put("orgRefNo", getMap.get("refNo").toString());
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
		parameters.put("mbrRefNo", getMap.get("mbrRefNo").toString());
		
		parameters.put("personType", paramMap.get("personType").toString());
		
		/*자진발급번호 01000001234 고정*/
		parameters.put("customerPk", paramMap.get("customerPk").toString());
		
		parameters.put("amount", getMap.get("amount").toString());
		parameters.put("taxAmount", getMap.get("taxAmount").toString());
		parameters.put("feeAmount", getMap.get("feeAmount").toString());
		parameters.put("goodsName", getMap.get("goodsName").toString());
		
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
			
			paramMap.put("mbrSq", mbrNo);
			paramMap.put("mbrRefNo", dataMap.get("mbrRefNo").toString()); 
			paramMap.put("refNo", dataMap.get("refNo").toString());
			paramMap.put("tranDate", dataMap.get("tranDate").toString());
			paramMap.put("amount", dataMap.get("amount").toString());
			paramMap.put("taxAmount", dataMap.get("taxAmount").toString());
			paramMap.put("fee_amount", dataMap.get("feeAmount").toString());
			paramMap.put("applNo", dataMap.get("applNo").toString());
			
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
		parameters.put("mbrRefNo", getMap.get("mbrRefNo").toString());
		parameters.put("orgRefNo", getMap.get("refNo").toString());
		parameters.put("orgTranDate", getMap.get("tranDate").toString());
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
			paramMap.put("cancelYn", "Y");
			
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

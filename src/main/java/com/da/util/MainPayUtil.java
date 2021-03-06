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
		  API KEY (?????????)
		 - ?????? : http://cp.mainpay.co.kr ????????????>????????????>??????????????????
		 - ???????????????(mbrNo) ????????? ?????? ??????????????? key (????????? ????????? real ???????????? ????????????) */

		Map<String, String> parameters = new HashMap<String, String>();
		//JSONObject parameters = new JSONObject();
		
		/*=================================================================================================
		 *	?????? ???????????? 
		 *=================================================================================================*/
		/* ????????? ?????????(????????? ????????? real ???????????? ????????????)*/
		parameters.put("version", "V001"); //???????????? (??????????????? ??????)
		/* ?????? ????????? ????????? ?????? ?????????*/
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
		parameters.put("mbrNo", mbrNo); //?????????????????? ????????? ????????? ?????? (?????? ?????????)
		/* ????????? ????????? ???????????? (????????? ??????ID ????????????) 6byte~20byte*/
		parameters.put("mbrRefNo", paramMap.get("mbrRefNo").toString()); //????????????????????? (??????????????? ????????? ???????????? ?????? ??????)
		parameters.put("paymethod", paramMap.get("paymethod").toString()); //???????????? (CARD: ???????????? | VACCT: ???????????? | ACCT: ???????????? | HPP: ???????????????)(*)??????????????? "CARD"??? ???????????? ??????
		/* ???????????? (?????????+?????????)
		(#??????#) ??????????????? ?????? ?????? ?????? ????????? ????????? ?????? ??????????????? ????????? ???????????????.
		 DB?????? ????????? ?????? ?????? ????????????. */
		parameters.put("amount", paramMap.get("amount").toString()); //???????????????
		/* ????????? max 30byte*/
		parameters.put("goodsName", paramMap.get("goodsName").toString()); //????????? (?????? ??????????????? ???????????? ?????????.)
		/* ???????????? max 8byte*/
		//parameters.put("goodsCode", paramMap.get("goods_code").toString());
		/*???????????? ??? ?????? URL*/
		parameters.put("approvalUrl", returnUrl + "/payment/approval"); //???????????? ??????????????? ???) https://???????????????/approval (??????) URL?????? &,=?????? ???????????? ????????????)
		/*????????? close??? ?????? URL*/
		parameters.put("closeUrl", returnUrl + "/payment/close"); //???????????? ??????????????? URL ???) https://???????????????/close (??????) URL?????? &,=?????? ???????????? ????????????)
		
	    /*=================================================================================================
	     *	READY API ?????? (**????????? ??? ????????? ??????-URL??? ???????????? ?????????.**) 
	     *=================================================================================================*/
	    /*contentType??? json?????? ?????? ??????*/
//	    response.setContentType("application/json");
		String responseJson = "";
		
		/* READY API ??????   */
		String readyUrl = stdApiBase + readyUri; // ????????????
		try {
			responseJson = HttpSendTemplate.post(readyUrl, parameters, apiKey);
			System.out.println(parameters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    		 
		System.out.println("responseJson:"+responseJson);
				
		Map<String, Object> responseMap = ParseUtils.fromJson(responseJson, Map.class);        
		String resultCode = responseMap.get("resultCode").toString();        
		String resultMessage = responseMap.get("resultMessage").toString();

		if( ! "200".equals(resultCode)) { //READY API ?????? ??????
			String errMessage = String.format("READY API ???????????? : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
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
			
			/*?????? ?????? ??????*/
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
	 * ????????????
	 * @param paramMap
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> approval(Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> parameters = mainPayMapper.getMainPayRequest(paramMap.get("aid").toString());
		Map<String, Object> param = new HashMap<>();
		
		System.out.println("################################# ?????? paramMap :"+paramMap);
		String resultCode = "";
	    String resultMessage = "";
	    
		if(MapUtils.isEmpty(paramMap)) {
			System.err.println("?????? ????????? ?????? ????????????, ????????? ???????????????.");
			
			resultCode = "00";
			resultMessage = "?????? ????????? ?????? ????????????, ????????? ???????????????.";
		}
		
		/*???????????? ???????????? ??????*/
		param.put("version", "V001"); //????????????
		param.put("mbrNo", mbrNo); //?????????????????? ????????? ????????? ??????(?????? ?????????)
		param.put("aid", paramMap.get("aid").toString());
		param.put("mbrRefNo", parameters.get("mbrRefNo").toString());
		param.put("authToken", paramMap.get("authToken").toString()); //??????????????? ??????, approvalUrl?????? ????????? ?????????
		param.put("paymethod", paramMap.get("paymethod").toString());
		param.put("amount", parameters.get("amount").toString());
		
		String responseJson = "";
		Map<String, Object> responseMap = new HashMap<>();
	    try{
	    	/* ???????????? API ??????   */
	    	String payUrl = stdApiBase + payUri;
	    	responseJson = HttpSendTemplate.post(payUrl, param, apiKey);
	    } catch(Exception e) {
	    	/* ????????? ??????(??????API ?????? ?????? ??????????????? ????????? ??????) */
	    	String netCancelUrl = stdApiBase + cancelUri;
	    	try {
				HttpSendTemplate.post(netCancelUrl, param, apiKey);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	resultCode="C300";
	    	resultMessage = String.format("?????? API ?????? ?????? ?????? : %s", e.getMessage());
	    	System.out.println(resultMessage + "resultCode : " + resultCode);
			//mainPayMapper.instApiResult(resultMap);
	    }
		 
		responseMap = ParseUtils.fromJson(responseJson, Map.class);
	    resultCode = (String) responseMap.get("resultCode");
	    resultMessage = (String) responseMap.get("resultMessage");
	    
	    //??????API ?????? ??????
	    if( ! "200".equals(resultCode)) {
	    	//System.err.println(responseMap);
	    	
	    	return responseMap;
	    }else {
	    	Map dataMap = (Map) responseMap.get("data");
		   
	    	System.out.println(dataMap);
	    	/*?????? ?????? ??????*/
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
	    	/*?????? ?????? ?????? ??????*/
	    	resultMap.put("mbrRefNo", dataMap.get("mbrRefNo"));
	    	resultMap.put("refNo", dataMap.get("refNo"));
	    	resultMap.put("tranDate", dataMap.get("tranDate"));
	    	resultMap.put("tranTime", dataMap.get("tranTime"));
	    	resultMap.put("amount", dataMap.get("amount"));
	    	resultMap.put("taxAmount", dataMap.get("taxAmount"));
	    	resultMap.put("feeAmount", dataMap.get("feeAmount"));
	    	resultMap.put("taxFreeAmount", dataMap.get("taxFreeAmount"));
	    	/*???????????? ?????????*/
		    resultMap.put("installment", dataMap.get("installment"));
		    resultMap.put("applNo", dataMap.get("applNo"));
		    resultMap.put("cardNo", dataMap.get("cardNo"));
		    resultMap.put("issueCompanyNo", dataMap.get("issueCompanyNo"));
		    resultMap.put("issueCompanyName", dataMap.get("issueCompanyName"));
		    resultMap.put("issueCardName", dataMap.get("issueCardName"));
		    resultMap.put("acqCompanyNo", dataMap.get("acqCompanyNo"));
		    resultMap.put("acqCompanyName", dataMap.get("acqCompanyName"));
		    resultMap.put("payType", dataMap.get("payType"));
		    /*???????????? ?????? ???????????? ?????????*/
		    resultMap.put("bankCode", dataMap.get("bankCode"));
		    resultMap.put("accountNo", dataMap.get("accountNo"));
		    resultMap.put("accountCloseDate", dataMap.get("accountCloseDate"));
		    resultMap.put("accountCloseDate", dataMap.get("accountCloseDate"));
		    //???????????? ???????????? ????????? insert??????
		    mainPayMapper.insertPayMnt(resultMap);
	    	
	    	//??????????????? ?????? ??????
	    	if(!parameters.get("paymethod").toString().equals("VACCT")) {
	    		//???????????? ???????????? ?????????/????????? ????????? ?????? ??????, ?????? ?????????, ?????? ????????? ????????????. 
	    		mainPayMapper.insertWorkDeal(resultMap);
	    		//1??? ???????????? ???????????? ?????? ?????? ?????? ????????? 1??? ?????? ????????? ?????????.
			    if(parameters.get("paymntDivCd").toString().equals("B") && parameters.get("paymntTypCd").toString().equals("1")) {
			    	parameters.put("dealBuyFee", parameters.get("paymntFeeAmt").toString()); //?????? ???????????? ????????????
					mainPayMapper.insertWorkDeal(parameters); //?????? ????????? ?????? ???????????? ???????????? ????????????
			    	mainPayMapper.updateDealBuyMbrSq(parameters.get("buyMbrSq").toString(), parameters.get("dealSq").toString(), parameters.get("dealTypCd").toString());
			    	myPageMapper.updateBuyPaymntSttsCd(parameters.get("dealSq").toString(), "2PW");
			    	mainPayMapper.updateWorkSaleYn(parameters.get("workSq").toString());
			    }
			    //2??? ???????????? ???????????? ?????? ?????? ?????? ????????? 2??? ?????? ????????? ?????????.
			    if(parameters.get("paymntDivCd").toString().equals("S") && parameters.get("paymntTypCd").toString().equals("2")) {
			    	mainPayMapper.insertWorkDeal(parameters); //?????? ????????? ???????????? ????????????
			    	myPageMapper.updateSellPaymntSttsCd(parameters.get("dealSq").toString(), "2PC");
			    }
			    //2??? ???????????? ???????????? ?????? ?????? ?????? ????????? 2??? ?????? ????????? ?????????.
			    if(parameters.get("paymntDivCd").toString().equals("B") && parameters.get("paymntTypCd").toString().equals("2")) {
			    	myPageMapper.updateBuyPaymntSttsCd(parameters.get("dealSq").toString(), "2PC");
			    }
			    //?????? ???????????? ??????????????? ?????????
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
	 * ?????? ?????? ?????????
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getPaymentSuccessDataList(Map<String, Object> paramMap){
		
		List<Map<String, Object>> rsltList = new ArrayList<Map<String, Object>>();
		
		rsltList = mainPayMapper.getPaymentSuccessDataList(paramMap);
		
		return rsltList;
	}
	
	/**
	 * ?????? ?????? ??????
	 * @param paramMap
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> mainPayAllCancel(Map<String, Object> paramMap) throws Exception{
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentAllCancelData(paramMap);
	     
		/* Request ???????????? map ?????? */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	?????? ???????????? 
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
			System.err.println(String.format("CANCEL API ???????????? ???????????? : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API ?????? ??????
			String errMessage = String.format("CANCEL API ???????????? : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
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
			// JSON TYPE RESPONSE (JSON ?????? ???????????? ??????)
		}
		
		resultMap.put("method", "cancelApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
	
	/**
	 * ?????? ??????
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayRefRegister(Map<String, Object> paramMap){
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request ???????????? map ?????? */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	?????? ???????????? 
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
			System.err.println(String.format("CANCEL API ???????????? ???????????? : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API ?????? ??????
			String errMessage = String.format("refRegApi API ???????????? : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
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
			// JSON TYPE RESPONSE (JSON ?????? ???????????? ??????)
		}
		
		resultMap.put("method", "refRegApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
	
	/**
	 * ?????? ?????? ??????
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayRefSelect(Map<String, Object> paramMap){
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request ???????????? map ?????? */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	?????? ???????????? 
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
			System.err.println(String.format("CANCEL API ???????????? ???????????? : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "0000".equals(resultCode)) { //CANCEL API ?????? ??????
			String errMessage = String.format("refSelApi API ???????????? : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
		
			paramMap.put("sid", getMap.get("sid"));
			paramMap.put("refundYn", "Y");
			
			mainPayMapper.updateRefundDataApi(paramMap);
	
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON ?????? ???????????? ??????)
		}
		
		resultMap.put("method", "refSelApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}

	/**
	 * ?????? ??????
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayRefCancel(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request ???????????? map ?????? */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	?????? ???????????? 
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
			System.err.println(String.format("CANCEL API ???????????? ???????????? : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API ?????? ??????
			String errMessage = String.format("refCanApi API ???????????? : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON ?????? ???????????? ??????)
		}
		
		resultMap.put("method", "refCanApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
	
	/**
	 * ??????????????? ??????
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayCashReceiptTrans(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getPaymentSuccessData(paramMap);
	     
		/* Request ???????????? map ?????? */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	?????? ???????????? 
		 *=================================================================================================*/
		parameters.put("version", "1.0");
		parameters.put("mbrNo", mbrNo);
		parameters.put("mbrRefNo", getMap.get("mbrRefNo").toString());
		
		parameters.put("personType", paramMap.get("personType").toString());
		
		/*?????????????????? 01000001234 ??????*/
		parameters.put("customerPk", paramMap.get("customerPk").toString());
		
		parameters.put("amount", getMap.get("amount").toString());
		parameters.put("taxAmount", getMap.get("taxAmount").toString());
		parameters.put("feeAmount", getMap.get("feeAmount").toString());
		parameters.put("goodsName", getMap.get("goodsName").toString());
		
		String responseJson = "";
		try{
			responseJson = HttpSendTemplate.post(restUrl + receiptTransUri, parameters, apiKey);
		} catch(Exception e) {
			System.err.println(String.format("CANCEL API ???????????? ???????????? : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API ?????? ??????
			String errMessage = String.format("recTransApi API ???????????? : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
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
			// JSON TYPE RESPONSE (JSON ?????? ???????????? ??????)
		}
		
		resultMap.put("method", "recTransApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}

	/**
	 * ??????????????? ?????? ??????
	 * @param paramMap
	 * @return
	 */
	public Map<String, Object> mainPayCashReceiptCancel(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		Map<String, Object> rsltMap = new HashMap<String, Object>();

		Map<String, Object> getMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		getMap = mainPayMapper.getCashReceiptTransData(paramMap);
	     
		/* Request ???????????? map ?????? */
		Map<String, String> parameters = new HashMap<String, String>();
		
		/*=================================================================================================
		 *	?????? ???????????? 
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
			System.err.println(String.format("CANCEL API ???????????? ???????????? : %s", e.getMessage()));
			e.printStackTrace();
		}
		
		Map responseMap = ParseUtils.fromJson(responseJson, Map.class);
		String resultCode = (String) responseMap.get("resultCode");
		String resultMessage = (String) responseMap.get("resultMessage");

		if( ! "200".equals(resultCode)) { //CANCEL API ?????? ??????
			String errMessage = String.format("recTransApi API ???????????? : resultCode: %s, resultMessge: %s", resultCode, resultMessage);
			System.err.println(errMessage);
		}else {
			
			Map dataMap = (Map)responseMap.get("data");
			
			paramMap.put("sid", getMap.get("sid"));
			paramMap.put("cancelYn", "Y");
			
			mainPayMapper.updateCashReceiptTransApi(paramMap);
			
			rsltMap.put("resultCode", resultCode);
			rsltMap.put("resultMessage", resultMessage);
			// JSON TYPE RESPONSE (JSON ?????? ???????????? ??????)
		}
		
		resultMap.put("method", "recTransApi");
		resultMap.put("resultCode", resultCode);
		resultMap.put("resultMessage", resultMessage);
		
		mainPayMapper.instApiResult(resultMap);
		
		return rsltMap;
	}
}

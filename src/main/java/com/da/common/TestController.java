package com.da.common;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.da.mapper.MainPayMapper;
import com.da.mapper.MyPageMapper;
import com.da.util.CommonService;
import com.da.util.MainPayUtil;
import com.da.util.SendMailUtil;
import com.da.util.SendSmsUtil;

@Controller
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SendSmsUtil sendSmsUtil;
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@Autowired
	private MainPayUtil mainPayUtil;
	
	@Autowired
	private MainPayMapper mainPayMapper;
	
	@Autowired
	private MyPageMapper myPageMapper;
	
//	@RequestMapping("/")
//	public String index() {
//		logger.info("index");
//		
//		Map<String, Object> rtnMap = new HashMap<String, Object>();
//		
//		try {
//			
//		String reStr = commonService.encrypt("김영삼");
//		
//		String deStr = commonService.decrypt("68160dc64efc04a5a68dce5320b433b3");
//		
//		Map<String, Object> reMap = commonService.getJusoDetail("도평리", 1, 10);
		
		/**
		 * ----------------------------------------------------------
		 */
		
//		testSms();
//		
//		testMail();
		
//		logger.info("------------------------------------------");
//		System.out.println(reStr);
//		System.out.println(deStr);
//		System.out.println(reMap);
//		logger.info("------------------------------------------");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return "index";
//	}
	
	@RequestMapping("/checkplus_success")
	public String checkplusSuccess() {
		return "checkplus_success";
	}
	
	@RequestMapping("/checkplus_fail")
	public String checkplusFail() {
		return "checkplus_fail";
	}
	
	@RequestMapping("/test-sms")
	public String testSms() {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		/**
		 * "content":"string",
		 * "messages":[
		        {
		            "to":"string"
		        }
		    ]
		 */
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		
		tomap.put("to", "01099428461");
		mList.add(tomap);
		
		params.put("content", "테스트에용");
		params.put("messages", mList);
		
		rtnMap = sendSmsUtil.sendSms(params);
		
		System.out.println(rtnMap);
		
		return rtnMap.get("statusCode").toString();
	}
	
	@RequestMapping("/test-mail")
	public String testMail() {
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		String result = "";
		/**
		 * "title":"string",
		 * "body":"string",
		 * "recipients":[
		        {
		            "address":"string",
		            "type":"R"
		        }
		    ]
		 */
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		
		//tomap.put("address", "dudtka37@naver.com");
		tomap.put("address", "isonaki@naver.com");
		tomap.put("type", "R");
		mList.add(tomap);
		
		params.put("title", "테스트에용 title");
		params.put("body", "테스트에용 content");
		params.put("recipients", mList);
		
		rtnMap = sendMailUtil.sendMail(params);
		
//		if(((int) Double.parseDouble(rtnMap.get("count").toString()) < 0)){
//			result = "error";
//		}else {
//			result = "OK";
//		}
		
		return result;
	}
	
	/**
	 * MainPay 시작 화면
	 * @return
	 */
	@RequestMapping("/sample/payment")
	public String paymentTest() {
		return "/payment/payment";
	}
	
	/**
	 * MainPay 인증 후 인증 popup 으로
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/readyApi")
	public @ResponseBody Map<String, Object> mainPayReadyApi(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		rsltMap = mainPayUtil.readyApi(paramMap);
		
		return rsltMap;
	}
	
	/**
	 * 결제승인
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/payment/approval")
	public @ResponseBody void mainPayApproval(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(required = false) Map<String, Object> paramMap) throws Exception {
		
		Map<String, Object> rsltMap = mainPayUtil.approval(paramMap);
		if(rsltMap.get("resultCode").toString().equals("200")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('완료되었습니다.'); opener.call("+rsltMap.get("resultCode").toString()+"); window.close(); </script>");
			out.flush();
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('결제를 실패하였습니다. 사유 : "+rsltMap.get("resultMessage").toString()+"); "
					+ "opener.call(\"+rsltMap.get(\"resultCode\").toString()+\"); window.close(); </script>");
			out.flush();
		}
	}
	/**
	 * 가상계좌 결제 확인
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/payment/depositCompleted")
	public @ResponseBody String depositCompleted(HttpServletRequest request, HttpServletResponse response
			,@RequestParam(name = "RCPTNAME") String rcptName
			,@RequestParam(name = "TRDATE") String trDate
			,@RequestParam(name = "TRTIME") String trTime
			,@RequestParam(name = "TAX_AMOUNT") String taxAmount
			,@RequestParam(name = "REPLYCODE") String replyCode
			,@RequestParam(name = "ORDNO") String ordNo
			,@RequestParam(name = "REF_NO") String refNo
			,@RequestParam(name = "ACCOUNTNO") String accountNo
			,@RequestParam(name = "AMT") String amt) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("rcptName", rcptName);
		paramMap.put("trDate", trDate);
		paramMap.put("trTime", trTime);
		paramMap.put("taxAmount", taxAmount);
		paramMap.put("replyCode", replyCode);
		paramMap.put("ordNo", ordNo);
		paramMap.put("refNo", refNo);
		paramMap.put("accountNo", accountNo);
		paramMap.put("amt", amt);
		mainPayMapper.updatePaymntCompletedVACCT(paramMap); //결제 내역에 입금 결과 업데이트
		Map<String, Object> param = mainPayMapper.selectPaymnt(paramMap); //해당 결제 내역 정보를 가져온다
		String paymntOrder = param.get("mbrRefNo").toString(); //주문 번호를 가져온다
		paymntOrder = paymntOrder.substring(paymntOrder.length() - 1); //주문 번호 끝에 1글자만 가져온다
		if(paymntOrder.equals("1")){ //구매자 1차 결제 이면
			param.put("buyMbrSq", param.get("mbrSq").toString()); //결제 회원 순번을 구매자 회원 순번으로 입력한다
			mainPayMapper.insertWorkDeal(param); //거래 내역에 구매자 정보 입력
			String buyMbrSq = param.get("butMbrSq").toString();
			String dealSq = param.get("dealSq").toString();
			String dealTypCd = param.get("dealTypCd").toString();
			mainPayMapper.updateDealBuyMbrSq(buyMbrSq, dealSq, dealTypCd); //딜 테이블에 1차 구매자 순번 등록
			myPageMapper.updateBuyPaymntSttsCd(dealSq, "2PW"); //딜 테이블에 구매자 결제 상태 코드를 변경해준다
			mainPayMapper.updateWorkSaleYn(param.get("workSq").toString()); //작품 테이블에 판매 여부를 Y로 바꿔준다
		}
		if(paymntOrder.equals("2")){ //구매자 2차 결제 이면
			param.put("buyMbrSq", param.get("mbrSq").toString()); //결제 회원 순번을 구매자 회원 순번으로 입력한다
			mainPayMapper.insertWorkDeal(param); //거래 내역에 구매자 정보 입력
			myPageMapper.updateBuyPaymntSttsCd(param.get("dealSq").toString(), "2PC"); //딜 테이블에 구매자 결제 상태 코드를 변경해준다
		}
		if(paymntOrder.equals("3")) {//판매자
			param.put("sellMbrSq", param.get("mbrSq").toString()); //결제 회원 순번을 구매자 회원 순번으로 입력한다
			mainPayMapper.insertWorkDeal(param); //거래 내역에 판매자 정보 입력
			myPageMapper.updateSellPaymntSttsCd(param.get("dealSq").toString(), "2PC"); //딜 테이블에 판매자 결제 상태 코드를 벼녁앻준다
		}
		if(param.get("cuponSq") != null) { //쿠폰 번호가 있으면
			mainPayMapper.updateCouponUseYn(param); //쿠폰을 사용처리 해준다
		}
		return "NULL";
	}
	
	/**
	 * 결제 완료 된 데이터 가져오기
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/getPaymentSuccessDataList")
	public @ResponseBody List<Map<String, Object>> getPaymentSuccessData(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		List<Map<String, Object>> rsltList = new ArrayList<Map<String, Object>>();
		
		rsltList = mainPayUtil.getPaymentSuccessDataList(paramMap);
		
		return rsltList;
	}
	
	/**
	 * 전체 결제 취소
	 * @param paramMap
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/payment/all-cancel")
	public @ResponseBody Map<String, Object> mainPayAllCancel(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception{
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		rsltMap = mainPayUtil.mainPayAllCancel(paramMap);
		
		return rsltMap;
	}
	
	/**
	 * 환불 등록
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/ref-register")
	public @ResponseBody Map<String, Object> mainPayRefRegister(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		rsltMap = mainPayUtil.mainPayRefRegister(paramMap);
		
		return rsltMap;
	}
	
	/**
	 * 환불 상태 조회
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/ref-select")
	public @ResponseBody Map<String, Object> mainPayRefSelect(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		rsltMap = mainPayUtil.mainPayRefSelect(paramMap);
		
		return rsltMap;
	}
	
	/**
	 * 환불 취소
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/ref-cancel")
	public @ResponseBody Map<String, Object> mainPayRefCancel(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		rsltMap = mainPayUtil.mainPayRefCancel(paramMap);
		
		return rsltMap;
	}
	
	/**
	 * 현금영수증 발행
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/cash-receipt-trans")
	public @ResponseBody Map<String, Object> mainPayCashReceiptTrans(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		rsltMap = mainPayUtil.mainPayCashReceiptTrans(paramMap);
		
		return rsltMap;
	}
	
	/**
	 * 현금영수증 취소
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/cash-receipt-cancel")
	public @ResponseBody Map<String, Object> mainPayCashReceiptCancel(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		Map<String, Object> rsltMap = new HashMap<String, Object>();
		
		rsltMap = mainPayUtil.mainPayCashReceiptCancel(paramMap);
		
		return rsltMap;
	}
	
	/**
	 * MainPay 시작 화면
	 * @return
	 */
	@RequestMapping("/payment/close")
	public String paymentClose() {
		return "/payment/payment_close";
	}
	
	//계좌확인
	@RequestMapping("/memBankNum")
	public String memBankNum() {
		return "memBankNum";
	}
	
	@RequestMapping("/memBankRequest")
	public String memBankRequest() {
		return "memBankRequest";
	}
	

}


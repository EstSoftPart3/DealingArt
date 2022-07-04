package com.da.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.SocketException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
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
import org.springframework.web.servlet.ModelAndView;

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
	 * @throws ParseException 
	 */
	@PostMapping("/payment/readyApi")
	public @ResponseBody Map<String, Object> mainPayReadyApi(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		
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
			String buyMbrSq = param.get("buyMbrSq").toString();
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
		return "OK";
	}
	
	/**
	 * MainPay 닫기 버튼 누르면 호출
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/payment/close")
	@ResponseBody
	public void paymentClose(@RequestParam(name = "aid") String aid, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script> opener.parent.location.reload(); window.close(); </script>");
		out.flush();
	}
	
	/**
	 * MainPay 가상계좌 중복 체크
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/payment/VACCTOverlapChk")
	@ResponseBody
	public ModelAndView VACCTOverlapChk(@RequestParam(required = false) Map<String, Object> paramMap, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = mainPayMapper.VACCTOverlapChk(paramMap);
		mv.addObject("result", result);
		return mv;
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
	 * 결제 금액 0원이면 결제 완료 처리
	 * @param paramMap
	 * @param request
	 * @return
	 */
	@PostMapping("/payment/paymentCompleted")
	public @ResponseBody ModelAndView paymentCompleted(@RequestBody Map<String, Object> paramMap, HttpServletRequest request){
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("result", "OK");
		String paymntOrder = paramMap.get("mbrRefNo").toString(); //주문 번호를 가져온다
		paymntOrder = paymntOrder.substring(paymntOrder.length() - 1); //주문 번호 끝에 1글자만 가져온다
		if(paymntOrder.equals("2")) {
			mainPayMapper.insertPayMnt(paramMap); //결제 내역에 등록한다
			mainPayMapper.insertWorkDeal(paramMap); //거래 내역에 구매자 정보 입력
			myPageMapper.updateBuyPaymntSttsCd(paramMap.get("dealSq").toString(), "2PC"); //딜 테이블에 구매자 결제 상태 코드를 변경해준다
			mainPayMapper.updateCouponUseYn(paramMap); //쿠폰을 사용처리 해준다
		}
		if(paymntOrder.equals("3")) {
			mainPayMapper.insertPayMnt(paramMap); //결제 내역에 등록한다
			mainPayMapper.insertWorkDeal(paramMap); //거래 내역에 구매자 정보 입력
			myPageMapper.updateSellPaymntSttsCd(paramMap.get("dealSq").toString(), "2PC"); //딜 테이블에 판매자 결제 상태 코드를 변경해준다
			mainPayMapper.updateCouponUseYn(paramMap); //쿠폰을 사용처리 해준다
		}
		return mv;
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
	

	@RequestMapping("/memBankNum")
	public String memBankNum() {
		return "memBankNum";
	}
	/************************************************************************************************
	NICE평가정보 Copyright(c) KOREA INFOMATION SERVICE INC. ALL RIGHTS RESERVED
	
	서비스명 : 계좌확인 서비스 
	페이지명 : 계좌확인 인증요청 페이지

	방화벽 이용 시 아래 IP와 Port를 오픈해주셔야 합니다
	IP : 121.162.155.160 / Port : 80, 443
	 * @throws IOException 
	*************************************************************************************************/
	@RequestMapping("/memBankRequest")
	public void memBankRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String niceUid = "NID206035";				// NICE에서 발급받은 사이트코드
		String svcPwd  = "24501348";				// NICE에서 발급받은 사이트 패스워드
		String strCharset = "UTF-8";		// 인증서버의 한글 인코딩 (EUC-KR, UTF-8)
		
		// 한글 인코딩 설정
		request.setCharacterEncoding("utf-8");
		//request.setCharacterEncoding("euc-kr");
		
		// 입력 페이지에서 전달된 입력값 취득
		String service		= request.getParameter("service");		// 서비스구분
		String svcGbn		= request.getParameter("svcGbn");		// 업무구분
		String strGbn		= request.getParameter("strGbn");		// 계좌구분 (1:개인계좌, 2:법인계좌)
		String strBankCode	= request.getParameter("strBankCode");	// 은행코드
		String strAccountNo	= request.getParameter("strAccountNo");	// 계좌번호

		
	    // 예금주명 초기화 및 취득
		String strNm = "";
		if(request.getParameter("name") != null){
			strNm = request.getParameter("name");
			
			// 한글이 깨져서 들어오는 경우 한글 인코딩을 직접 변환
			// strNm = new String(request.getParameter("name").getBytes(strCharset));	

			// URL 인코딩 처리	
			strNm = URLEncoder.encode(strNm, strCharset);
		}

		// 생년월일 초기화 및 취득 (개인-생년월일 6자리, 법인-사업자번호 10자리)
		String strResId = "";
		if(request.getParameter("birth") != null){
			strResId = request.getParameter("birth");
		}
		
		// 주문번호 설정 (중복값 설정 불가, 소스 수정 불필요)	
		String strOrderNo = new SimpleDateFormat("yyyyMMdd").format(new Date()) + (Math.round(Math.random() * 10000000000L) + "");  	

		// 조회사유 설정 (10:회원가입 20:기존회원인증 30:성인인증 40:비회원확인 90:기타)	
		String inq_rsn = "10";			

		// 계좌인증 처리
		String bcResult = bankCheck(strCharset, niceUid, svcPwd, service, svcGbn, strGbn, strBankCode, strAccountNo, strNm, strResId, inq_rsn, strOrderNo); 

		// 결과값 분할
		String[] bcResults = bcResult.split("\\|");
		
		// 결과값 추출
		String resultOrderNo = bcResults[0];	// 주문번호
		String resultCode    = bcResults[1];	// 결과코드
		String resultMsg     = bcResults[2];	// 결과메세지
		
		// 결과값 출력
		System.out.println("주문번호  : "  + resultOrderNo + "<br>");
		System.out.println("결과코드  : "  + resultCode + "<br>");
		System.out.println("결과메시지 : " + resultMsg + "<br>");
		
		out.println("<script>opener.bankCheckCallBack("+resultCode+","+resultMsg+"); window.close(); </script>");
		out.flush();
	}
	//계좌인증 소켓-POST 함수
	public String bankCheck(String strCharset, String niceUid, String svcPwd, String service, String svcGbn, String strGbn, String strBankCode, String strAccountNo, String strNm, String strResId, String inq_rsn, String strOrderNo)
	{
		// 결과값 초기화
		String result = "";
		
		// NICE 계좌인증 호스트
		String host = "secure.nuguya.com";

		// NICE 계좌인증 URL(EUC-KR)																													
		String target = "https://secure.nuguya.com/nuguya/service/realname/sprealnameactconfirm.do";
		if (strCharset.equals("UTF-8")){
			// NICE 계좌인증 URL(UTF-8)
			target = "https://secure.nuguya.com/nuguya2/service/realname/sprealnameactconfirm.do";
		}	
		
		// 계좌인증 파라미터 설정
		String postValues = "niceUid" 				+ "=" + niceUid	
							+ "&" + "svcPwd"		+ "=" + svcPwd	
							+ "&" + "service"		+ "=" + service	
							+ "&" + "svcGbn"		+ "=" + svcGbn	
							+ "&" + "strGbn"		+ "=" + strGbn	
							+ "&" + "strBankCode"	+ "=" + strBankCode	
							+ "&" + "strAccountNo"	+ "=" + strAccountNo	
							+ "&" + "strNm"			+ "=" + strNm	
							+ "&" + "strResId"		+ "=" + strResId	
							+ "&" + "inq_rsn"		+ "=" + inq_rsn	
							+ "&" + "strOrderNo"	+ "=" + strOrderNo;
		
		// URL 및 파라미터 확인
		System.out.println("URL:\n" + target);
		System.out.println("POST:\n" + postValues);
		
		// 소켓 포트 설정 (HTTP:80, HTTPS:443)
		int port = 443;
		
		// 소켓 타임아웃 (10초)
		int timeout = 10;
		
		// 스트림 객체 초기화
    	BufferedReader in = null;
      	PrintWriter out = null;

      	try{
            // 결과 버퍼 생성
            StringBuffer sbResult = new StringBuffer();
      		
      		// 소켓통신 오픈
        	SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
          	SSLSocket soc = (SSLSocket)factory.createSocket(host, port);

            // 소켓통신 설정 
            soc.setSoTimeout(timeout * 1000);
        	soc.setSoLinger(true, 10);	
            soc.setKeepAlive(true);		           
      		
            // 스트림 객체 생성
            out = new PrintWriter(soc.getOutputStream());
            in  = new BufferedReader(new InputStreamReader(soc.getInputStream()), 8 * 1024);
            
	        // 요청 헤더 생성
            out.println("POST " + target + " HTTP/1.1");
            out.println("Host: " + host);
            out.println("Connection: Keep-Alive");
            out.println("Content-Type: application/x-www-form-urlencoded");
            out.println("Content-Length: " + postValues.length());
            out.println();
            out.println(postValues);
            out.flush();            
            
            // 응답헤더 초기화
            String line = null;

	        // 소켓통신 처리
			int i=0;
            boolean notYet = true;
            while((line = in.readLine())!= null){
                i++;
                if (notYet && line.indexOf("HTTP/1.") == -1 ){
                	continue;
                }
                if (notYet && line.indexOf("HTTP/1.") > -1 ){
                	notYet = false;
                }
                
                if (line.indexOf("HTTP/1.") > -1 ){
                	notYet = false;
                }
                if (line.startsWith("0") || line == null){
                    break;
                }
             	
                // 9번째 라인 추출
                if(i==9) {
                	sbResult.append(line);
                }
            }
            
            // 소켓통신 종료
            out.close();
            in.close();
            soc.close();

            // 결과값 설정
            result = sbResult.toString();
            
        }
      	// 소켓오류 처리
      	catch(SocketException e){
        	System.out.println("[계좌확인 소켓오류] " + e.getMessage());
        	result = strOrderNo + "|E999|소켓연결에 실패하였습니다.";
        }
      	// 기타 시스템 오류 처리
      	catch (Exception e){
        	System.out.println("[계좌확인 기타오류] " + e.getMessage());
        	e.printStackTrace();
        }
      	
      	// 오류 메세지 설정
      	if(result.equals("")){
        	result = strOrderNo + "|E999|소켓통신 중 오류가 발생했습니다.";
      	}
      	
		return result;
	}

}


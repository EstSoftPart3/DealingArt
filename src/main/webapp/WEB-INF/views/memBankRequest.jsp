<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="javax.net.ssl.SSLSocketFactory" %>
<%@ page import="javax.net.ssl.SSLSocket" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.net.SocketException" %>
<%@ page import="java.net.URLEncoder" %>
<%

// 보안을 위해 제공해드리는 샘플페이지는 서비스 적용 후 서버에서 삭제해 주시기 바랍니다. 

	/************************************************************************************************
		NICE평가정보 Copyright(c) KOREA INFOMATION SERVICE INC. ALL RIGHTS RESERVED
		
		서비스명 : 계좌확인 서비스 
		페이지명 : 계좌확인 인증요청 페이지

		방화벽 이용 시 아래 IP와 Port를 오픈해주셔야 합니다
		IP : 121.162.155.160 / Port : 80, 443
	*************************************************************************************************/

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
	out.println("주문번호  : "  + resultOrderNo + "<br>");
	out.println("결과코드  : "  + resultCode + "<br>");
	out.println("결과메시지 : " + resultMsg + "<br>");
%>
<%!	
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
%>
package com.da.fo.controller;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.da.util.ScriptUtils;
import com.da.fo.service.MemberService;
import com.da.util.CommonService;

@Controller 
@RequestMapping("/auth")
public class OAuthTestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/naver/callback") 
	@ResponseBody
	public String naverOAuthRedirect(HttpServletRequest request,HttpServletResponse httpResponse,@RequestParam String code, @RequestParam String state) throws JSONException, ParseException, IOException {
		          		
		//RestTemplate 인스턴스 생성
		RestTemplate rt = new RestTemplate();
		HttpHeaders accessTokenHeaders = new HttpHeaders();

		accessTokenHeaders.add("Content-type", "application/x-www-form-urlencoded");

		MultiValueMap<String, String> accessTokenParams = new LinkedMultiValueMap<>();

		accessTokenParams.add("grant_type", "authorization_code");
		accessTokenParams.add("client_id", "FXgRR5OMp34hGHwZUM6i"); 
		accessTokenParams.add("client_secret", "bJTl9NaiYe"); 
		accessTokenParams.add("code" , code); // 응답으로 받은 코드 accessTokenParams.add("state" , state); // 응답으로 받은 상태
		accessTokenParams.add("state" , state); // 응답으로 받은 상태

		HttpEntity<MultiValueMap<String, String>> accessTokenRequest = new HttpEntity<>(accessTokenParams, accessTokenHeaders);

		ResponseEntity<String> accessTokenResponse = rt.exchange( 
				"https://nid.naver.com/oauth2.0/token", 
				HttpMethod.POST, 
				accessTokenRequest, 
				String.class 
		);
		
		
		 String accessToken = accessTokenResponse.getBody();
		 
		 JSONObject jObject = new JSONObject(accessToken);
		 String access_token = jObject.getString("access_token");
		   
		 String token = access_token; // 네이버 로그인 접근 토큰;
	     String header = "Bearer " + token; // Bearer 다음에 공백 추가


	      String apiURL = "https://openapi.naver.com/v1/nid/me";
	      Map<String, String> requestHeaders = new HashMap<>();
	      requestHeaders.put("Authorization", header);
	      requestHeaders.put("client_id", "FXgRR5OMp34hGHwZUM6i"); 
	      requestHeaders.put("client_secret", "bJTl9NaiYe"); 
	      
	      String responseBody = get(apiURL,requestHeaders);

	      System.out.println(responseBody);
	      
	      JSONObject jObjectResponse = new JSONObject(responseBody);
	      String resultcode = jObjectResponse.getString("resultcode");
	      
         
	      
	      Map<String, Object> param = new HashMap<>();
    	  int resultCount = -1;
    	        
	      
	      if(resultcode.equals("00")) {
	    	  
	    	 
	    	  JSONObject jObjectUser = jObjectResponse.getJSONObject("response");
	    	
	    	  //네이버 이메일
	    	  String rEmail = jObjectUser.getString("email");
	    	  String rName = jObjectUser.getString("name");
	    	  String rId = jObjectUser.getString("id");
	    	  String mbrCpNumString = "010-0000-0000";
	    	  String mbrCpNumEncrypt = commonService.encrypt(mbrCpNumString);
	    	  
	    	  String mbrIdEncrypt = commonService.encrypt(rEmail);
	    	  param.put("mbrId", mbrIdEncrypt);
	    	  param.put("mbrEmail", mbrIdEncrypt);
	    	  param.put("mbrPasswrd", rId);
	    	  param.put("mbrNm", rName);
	    	  param.put("mbrCpNum", mbrCpNumEncrypt);
	    	  param.put("mbrCpCertYn", "N");
	    	  param.put("useYn", "Y"); 
	    	  param.put("mbrSocialSort", "NAV");
	    	  
	    	  resultCount = memberService.memberInfoCount(param);
	    	  
	    	  //회원등록이 안되어 있다면...
	    	  if(resultCount == 0) {
	    		  memberService.memberInsert(param);
	    	   } 
	    	  
	    	  HttpSession session = request.getSession();
	    	  
	    	  Map<String, Object> loginParam = new HashMap<>();
	    	  
	    	  loginParam.put("loginId", mbrIdEncrypt);
	    	  loginParam.put("loginPw", rId);
	    	  loginParam.put("email", mbrIdEncrypt);
	    	  loginParam.put("password", rId);
	    	  
	    	  Map<String, Object> resultLogin = memberService.login(loginParam);
	    	  
	    	  if(resultLogin != null) {
	    		 String mbrSq = resultLogin.get("mbrSq").toString();
				 String authSq = resultLogin.get("authSq").toString();
				 
				 session.setAttribute("mbrSq", mbrSq);
				 session.setAttribute("authSq", authSq);
				 
				 ScriptUtils.windowReload(httpResponse);
				 ScriptUtils.windowClose(httpResponse);
				 
				 
	    	  } else {
	    		  ScriptUtils.alert(httpResponse,"정상적으로 로그인되지 않았습니다. 관리자에 문의해 주세요.","reload");
	    		  ScriptUtils.windowClose(httpResponse);
	    	  }
	    	  
	    	  
	    	    	 
	    	}  
		  
		   return "resultcode: " + resultcode;
	  }	
	  
	
	
	  private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }
	  
	  private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }
	  
	  private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }
	
	
	  
	  @GetMapping("/kakao/callback") 
	  @ResponseBody
	  public String kakaoOauthRedirect(HttpServletRequest request,HttpServletResponse httpResponse,@RequestParam String code) throws JSONException, IOException { 
		  
		//RestTemplate 인스턴스 생성
			RestTemplate rt = new RestTemplate();
			HttpHeaders accessTokenHeaders = new HttpHeaders();

			accessTokenHeaders.add("Content-type", "application/x-www-form-urlencoded");

			MultiValueMap<String, String> accessTokenParams = new LinkedMultiValueMap<>();

			accessTokenParams.add("grant_type", "authorization_code");
			accessTokenParams.add("client_id", "69c902a158be248a93aca88ba9ff0929"); 
			accessTokenParams.add("client_secret", "AQB8RotIga9HUSLBEkzYoFXW4SSVwQDV"); 
			accessTokenParams.add("code" , code);
			accessTokenParams.add("redirect_uri" , "https://www.dealing-art.com/auth/kakao/callback");

			HttpEntity<MultiValueMap<String, String>> accessTokenRequest = new HttpEntity<>(accessTokenParams, accessTokenHeaders);

			ResponseEntity<String> accessTokenResponse = rt.exchange( 
					"https://kauth.kakao.com/oauth/token", 
					HttpMethod.POST, 
					accessTokenRequest, 
					String.class 
			);
			
		    String accessToken = accessTokenResponse.getBody();
		   
		    JSONObject jObject = new JSONObject(accessToken);
		    String access_token = jObject.getString("access_token");

			 
			String token = access_token; // 카카오 로그인 접근 토큰;
		    String header = "Bearer " + token; // Bearer 다음에 공백 추가

		    String apiURL = "https://kapi.kakao.com/v2/user/me";
		    Map<String, String> requestHeaders = new HashMap<>();
		    requestHeaders.put("Authorization", header);
	      
		    String responseBody = get(apiURL,requestHeaders);

		    System.out.println(responseBody);
			
			 
			JSONObject jObjectResponse = new JSONObject(responseBody);
			
			//JSONObject rId = jObjectResponse.getJSONObject("id");
			
			int id = jObjectResponse.getInt("id");
			String rId = Integer.toString(Math.abs(id));
			
			JSONObject jObjectUser = jObjectResponse.getJSONObject("kakao_account");
			
			String email = jObjectUser.getString("email");
			
			JSONObject jObjectUserProfile = jObjectUser.getJSONObject("profile");
			
			String nickname = jObjectUserProfile.getString("nickname");
		    		
		    		    
		    Map<String, Object> param = new HashMap<>();
	        int resultCount = -1;
		    
	        
		    if(!CommonService.isEmpty(email)) {
		    	
		    	    		
		    	//네이버 이메일
		    	  String rEmail = email;
		    	  String rName = nickname;
		    	  String mbrCpNumString = "010-0000-1111";
		    	  String mbrCpNumEncrypt = commonService.encrypt(mbrCpNumString);
		    	  
		    	  String mbrIdEncrypt = commonService.encrypt(rEmail);
		    	  param.put("mbrId", mbrIdEncrypt);
		    	  param.put("mbrEmail", mbrIdEncrypt);
		    	  param.put("mbrPasswrd", rId);
		    	  param.put("mbrNm", rName);
		    	  param.put("mbrCpNum", mbrCpNumEncrypt);
		    	  param.put("mbrCpCertYn", "N");
		    	  param.put("useYn", "Y"); 
		    	  param.put("mbrSocialSort", "KAO");
		    	  
		    	  resultCount = memberService.memberInfoCount(param);
		    	  
		    	  //회원등록이 안되어 있다면...
		    	  if(resultCount == 0) {
		    		  memberService.memberInsert(param);
		    	   } 
		    	  
		    	  HttpSession session = request.getSession();
		    	  
		    	  Map<String, Object> loginParam = new HashMap<>();
		    	  
		    	  loginParam.put("loginId", mbrIdEncrypt);
		    	  loginParam.put("loginPw", rId);
		    	  loginParam.put("email", mbrIdEncrypt);
		    	  loginParam.put("password", rId);
		    	  
		    	  Map<String, Object> resultLogin = memberService.login(loginParam);
		    	  
		    	  if(resultLogin != null) {
		    		 String mbrSq = resultLogin.get("mbrSq").toString();
					 String authSq = resultLogin.get("authSq").toString();
					 
					 session.setAttribute("mbrSq", mbrSq);
					 session.setAttribute("authSq", authSq);
					 
					 ScriptUtils.windowReload(httpResponse);
					 ScriptUtils.windowClose(httpResponse);
					 
		    	  } else {
		    		  ScriptUtils.alert(httpResponse,"정상적으로 로그인되지 않았습니다. 관리자에 문의해 주세요.","reload");
		    		  ScriptUtils.windowClose(httpResponse);
		    	  }
				
			}
		  
		  return "resultcode :" + nickname; 
	  }

	  @GetMapping("/google/callback") 
	  @ResponseBody
	  public String googleOAuthRedirect(HttpServletRequest request,HttpServletResponse httpResponse,@RequestParam String code) throws JSONException, IOException {
		  
		  RestTemplate rt = new RestTemplate();
		  
		  HttpHeaders headers = new HttpHeaders();
		  headers.add("Content-Type", "application/x-www-form-urlencoded");

		  MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		  params.add("client_id", "449213206661-c9iopfi3an6fglsajlq2npnp1c12f14s.apps.googleusercontent.com");
		  params.add("client_secret", "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");
		  params.add("code", code);
		  params.add("grant_type", "authorization_code");
		  params.add("redirect_uri", "https://www.dealing-art.com/auth/google/callback"); 

		  HttpEntity<MultiValueMap<String, String>> accessTokenRequest = new HttpEntity<>(params, headers);

		  ResponseEntity<String> accessTokenResponse = rt.exchange( 
				  	"https://oauth2.googleapis.com/token", 
				  	HttpMethod.POST, 
				  	accessTokenRequest, 
				  	String.class 
				  );
		  
		  String accessToken = accessTokenResponse.getBody();
		  
		  JSONObject jObject = new JSONObject(accessToken);
		  String access_token = jObject.getString("access_token");
		  
		  String token = access_token; // 구글 로그인 접근 토큰;
		  String header = "Bearer " + token; // Bearer 다음에 공백 추가

		  String apiURL = "https://www.googleapis.com/oauth2/v3/userinfo";
		  //String apiURL = "https://www.googleapis.com/oauth2/v3/userinfo?alt=json?access_token="+access_token;
		  Map<String, String> requestHeaders = new HashMap<>();
		  requestHeaders.put("Authorization", header);
		      
		  String responseBody = get(apiURL,requestHeaders);
		  JSONObject jObjectResponse = new JSONObject(responseBody);
		
		  String name = jObjectResponse.getString("name");
		  String rId = jObjectResponse.getString("sub");
		  String email = jObjectResponse.getString("email");
		  
		  Map<String, Object> param = new HashMap<>();
	      int resultCount = -1;
	      
	      if(!CommonService.isEmpty(email)) {
		    	
	    		
		    	//네이버 이메일
		    	  String rEmail = email;
		    	  String rName = name;
		    	  String mbrCpNumString = "010-0000-2222";
		    	  String mbrCpNumEncrypt = commonService.encrypt(mbrCpNumString);
		    	  
		    	  String mbrIdEncrypt = commonService.encrypt(rEmail);
		    	  param.put("mbrId", mbrIdEncrypt);
		    	  param.put("mbrEmail", mbrIdEncrypt);
		    	  param.put("mbrPasswrd", rId);
		    	  param.put("mbrNm", rName);
		    	  param.put("mbrCpNum", mbrCpNumEncrypt);
		    	  param.put("mbrCpCertYn", "N");
		    	  param.put("useYn", "Y"); 
		    	  param.put("mbrSocialSort", "GOG");
		    	  
		    	  resultCount = memberService.memberInfoCount(param);
		    	  
		    	  //회원등록이 안되어 있다면...
		    	  if(resultCount == 0) {
		    		  memberService.memberInsert(param);
		    	   } 
		    	  
		    	  HttpSession session = request.getSession();
		    	  
		    	  Map<String, Object> loginParam = new HashMap<>();
		    	  
		    	  loginParam.put("loginId", mbrIdEncrypt);
		    	  loginParam.put("loginPw", rId);
		    	  loginParam.put("email", mbrIdEncrypt);
		    	  loginParam.put("password", rId);
		    	  
		    	  Map<String, Object> resultLogin = memberService.login(loginParam);
		    	  
		    	  if(resultLogin != null) {
		    		 String mbrSq = resultLogin.get("mbrSq").toString();
					 String authSq = resultLogin.get("authSq").toString();
					 
					 session.setAttribute("mbrSq", mbrSq);
					 session.setAttribute("authSq", authSq);
					 
					 ScriptUtils.windowReload(httpResponse);
					 ScriptUtils.windowClose(httpResponse);
					 

		    	  } else {
		    		  ScriptUtils.alert(httpResponse,"정상적으로 로그인되지 않았습니다. 관리자에 문의해 주세요.","reload");
		    		  ScriptUtils.windowClose(httpResponse);
		    	  }
				
			}
		  
		  return "profileResponse :" + email;

		  

	}  
	  
	  
}

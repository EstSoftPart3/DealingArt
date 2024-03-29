<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="initial-scale=1,user-scalable=no,maximum-scale=1,width=device-width">
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="theme-color" content="#000000">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>딜링아트</title>
	
	<!-- font 추가했습니다 -->
	<link href=”https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap” rel=”stylesheet”>
	<link href='https://fonts.googleapis.com/css?family=Roboto Condensed' rel='stylesheet'>
	
	<link type="text/css" rel="stylesheet" href="resources/css/font.css" />
	<link type="text/css" rel="stylesheet" href="resources/css/swiper-bundle.min.css" />
	<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link type="text/css"rel="stylesheet" href="resources/css/common_pc.css">
	<link type="text/css" media="screen and (max-width: 750px)" rel="stylesheet" href="resources/css/ui_mo.css" />
	<link type="text/css" media="screen and (min-width: 751px) and (max-width: 1536px)" rel="stylesheet" href="resources/css/ui_tablet.css" />
	<link type="text/css" media="screen and (min-width: 1537px)" rel="stylesheet" href="resources/css/ui_pc.css" />
	
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="resources/js/common.js"></script>
</head>
<body>
	<div class="head-wrap">
		<div class="head">
			<div class="h-logo"><a href="/main"><img src="resources/img/logo.png" /></a></div>
			<div class="h-gnb">
				<div class="navbox">
					<nav>
						<li><a href="/deal">Deal</a></li>
						<li><a href="#">Megazine</a></li>
						<li><a href="/artist">Artist Library</a></li>
						<li><a href="#">About</a></li>
					</nav>
				</div>
				
				<!-- 로그인전 -->
				<div class="login-hide h-text" id="loginBf" style="display:none;">
					<span style="cursor:pointer;" data-toggle="modal" data-target="#loginModal">LOGIN</span>
					<span style="cursor:pointer;" data-toggle="modal" data-target="#memberModal">JOIN</span>
				</div>
				
				<!-- 로그인후 -->
				<div class="login-show h-img" id="loginAf" style="display:none;">
					<span class="sog-1"><a href="#"><img src="resources/img/icon-1.png" /></a></span>
					<span class="sog-2 lg-my"><a href="#"><img src="resources/img/icon-2.png" /></a></span>
					<div class="s-hov">
						<ul>
							<li><a href="#"><img src="resources/img/ic-1.jpg" /><span>마이 페이지</span></a></li>
							<li><a href="javascript:fnModalAlert();"><img src="resources/img/ic-2.jpg" /><span>경매 / 거래 내역</span></a></li>
							<li><a href="javascript:fnModalAlert();"><img src="resources/img/ic-3.jpg" /><span>마이 콜렉션</span></a></li>
							<li><a href="javascript:fnModalAlert();"><img src="resources/img/ic-4.jpg" /><span>좋아요</span></a></li>
							<li><a href="javascript:fnModalAlert();"><img src="resources/img/ic-5.jpg" /><span>고객센터</span></a></li>
						</ul>
						<button type="button" class="btn-1" onclick="logout()">로그아웃</button>
					</div>
				</div>
				
				
				<!-- 검색 -->
				<a href="" class="icon-search" data-toggle="modal" data-target="#myModal"><img src="resources/img/icon-3.png"></a>
				
				
			</div>
		</div>
		
	</div>
		
<!-- 모달검색 -->
<!-- Modal -->
<div class="modal fade modal-s" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sech">
		<div class="modal-content">
			<div class="modal-header">
				<div class="conts">
				    <div class="close" data-dismiss="modal" aria-label="Close"></div>
				</div>

			</div>
			<div class="modal-body">				
				<!-- 검색버튼 클릭시 -->
				<div class="search-show">
					<div class="sea-box">
						<img src="resources/img/w-logo.jpg" class="sea-img" />
						
						<div class="sea-won">
							<!-- <div class="select-box">
								<select>
									<option>작가명</option>
								</select>
							</div> -->
							<input type="text" id="ibx_search" onkeydown="javascript: if (event.keyCode == 13) {btn_search_onclick();}" onkeyup="ibx_search_onkeyup(this);"/>
							<a href="javascript:void(0);" onclick="btn_search_onclick();"><img src="resources/img/icon-2.jpg" /></a>
						</div>
						<div id="autocomplete">
							<div class="ta-h3">
								<h3 class="sea-h3">작품</h3>
								<a href="javascript:void(0);" class="workMore"><span>more</span></a>
							</div>
							<ul class="sea-text" id="work">
								<!-- <li><a href="#">text</a></li>
								<li><a href="#">text</a></li>
								<li><a href="#">text</a></li>
								<li><a href="#">text</a></li> -->
							</ul>
							<div class="ta-h3">
								<h3 class="sea-h3">작가</h3>
								<a href="javascript:void(0);" class="artistMore"><span>more</span></a>
							</div>
							<ul class="sea-text" id="artst">
								<!-- <li><a href="#">text</a></li>
								<li><a href="#">text</a></li>
								<li><a href="#">text</a></li>
								<li><a href="#">text</a></li> -->
							</ul>
							<div class="ta-h3">
								<h3 class="sea-h3">컨텐츠</h3>
								<a href="javascript:void(0);" class="contentMore"><span>more</span></a>
							</div>
							<ul class="sea-text">
								<li><a href="#">컨텐츠 제목입니다.</a></li>
								<li><a href="#">컨텐츠 제목입니다.</a></li>
								<li><a href="#">컨텐츠 제목입니다.</a></li>
								<li><a href="#">컨텐츠 제목입니다.</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<!-- login -->
<div class="modal fade modal-s" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-baeg max-w480 login-modal">
		<div class="modal-content">
			<div class="modal-header" style="padding: 0;min-height: 0;height: 0;">
				<div class="baegs">
				    <div class="close" data-dismiss="modal" aria-label="Close"><img src="resources/img/ba/icon-end.png" /></div>
				</div>
			</div>
			<div class="modal-body login-body">
				<img src="resources/img/icon/login-logo.png"  class="login-logo"/>
				<div class="login-box">
					<p class="lb-p1">LOGIN</p>
					<div class="input-box">
						<input type="text" class="input-3" placeholder="아이디/이메일" id="txt_Id"/>
					</div>
					<div class="input-box">
						<input type="password" class="input-3" placeholder="비밀번호" id="txt_Pw"/>
					</div>
					<div class="radio-3 rad-mg">
						<input type="radio" id="r1" name="rr">
						<label for="r1" class="wd-105"><span></span>자동로그인</label>
						<input type="radio" id="r2" name="rr">
						<label for="r2"><span></span>아이디(이메일) / 비밀번호 찾기</label>
					</div>
					<div class="bat-box3">
						<button type="button" class="ba-btn1" onclick="login()"><span>Login</span></button>
					</div>
					<p class="lb-p2"><a href="#"><span>회원가입</span></a></p>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 회원가입 -->
<div class="modal fade modal-s" id="memberModal" tabindex="-1" role="dialog" aria-labelledby="memberModalLabel" aria-hidden="true">
	<form id="memberInput" autocomplete="off">
	<div class="modal-dialog modal-baeg max-w800 momber-modal">
		<div class="modal-content">
			<div class="modal-header" style="padding: 0;min-height: 0;height: 0;">
				<div class="baegs">
				    <div class="close" data-dismiss="modal" aria-label="Close"><img src="/resources/img/ba/icon-end.png" /></div>
				</div>
			</div>
			<div class="modal-body member-body">
				<img src="resources/img/icon/login-logo.png"  class="member-logo"/>
				<div class="member-box">
					<img src="resources/img/icon/icon-bg.png" class="member-icon" />
					<h3 class="me-h3">회원가입</h3>
					<h4 class="me-h4">Dealing art  가입을 환영합니다. <span>회원 정보를 입력해 주세요.</span></h4>
				
					<div class="input-box">
						<input type="text" class="input-3 form-control" placeholder="아이디/이메일" id="mbrId" name="mbrId" autocomplete="off" required/>
						<p class="inp-p" id="mbrIdCheck">주로 사용하는 이메일을 입력해 주세요. 경매/판매 내역을 발송해 드립니다.</p>
					</div>
					<div class="input-box">
						<input type="password" class="input-3" placeholder="비밀번호" id="mbrPasswrd" name="mbrPasswrd" required/>
						<p class="inp-p" id="mbrPwdCheckU">영문/숫자/특수문자 2가지 이상 조합 (8~20자)</p>
						<p class="inp-p" id="mbrPwdCheckD">3개 이상 연속되거나 동일한 문자/숫자 제외, 아이디(이메일) 제외</p>
					</div>
					<div class="input-box">
						<input type="password" class="input-3" placeholder="비밀번호 확인" id="mbrPasswrdConfirm" name="mbrPasswrdConfirm" required/>
						<p class="inp-p" id="mbrPwdReCheck">확인을 위해 새 비밀번호를 다시 입력해주세요.</p>
					</div>					
					<div class="input-box">
						<input type="text" class="input-3" placeholder="이름" id="mbrNm" name="mbrNm" autocomplete="off" required/>
						<p class="inp-p" id="mbrNmCheck"></p>
					</div>
					<div class="input-box input-group">
						<input type="text" class="input-3" placeholder="휴대폰 번호" id="mbrCpNum" name="mbrCpNum" autocomplete="off" required/>
						<button type="button" class="group-btn">인증하기</button>
					</div>
					<div class="input-box">
						<p class="inp-p" id="mbrCpNumCheck"></p>
					</div>
					
					<div class="me-text">
						딜링아트 이용 약관에 동의해 주세요. <br/>
						경매 / 판매 알림 수신을 원하실 경우 모두 동의해 주세요.  <span class="text-line">모두 동의</span>						
					</div>
					<div class="radio-3 rad-mg">
						<input type="checkbox" id="s1" name="rr">
						<label for="s1"><span></span>(필수) 만 18세 이상입니다.</label><br/>
						<input type="checkbox" id="s2" name="rr">
						<label for="s2"><span></span>(필수) 이용 약관</label><br/>
						<input type="checkbox" id="s3" name="rr">
						<label for="s3"><span></span>(필수) 개인정보 수집 및 이용 동의</label><br/>
						<input type="checkbox" id="s4" name="rr">
						<label for="s4"><span></span>(선택) 이벤트, 프로모션 알림 메일 및 SMS 수신</label>
					</div>
					<div class="bat-box3">
						<button type="button" class="ba-btn1" id="memberInputBtn"><span>회원 가입하기</span></button>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	</form>
</div>s

<div class="modal fade modal-s" id="ModalAlert" tabindex="-1" role="dialog" aria-labelledby="myModal3Label" aria-hidden="true"></div>

<script type="text/javascript">
var loginSessionId = "";
var loginBf = document.getElementById("loginBf");
var loginAf = document.getElementById("loginAf");
$(function(){
	//로그인 세션 체크
	$.ajax({
	    type: "post",
	    url: "/loginCheck",
	    success: function(data) {
	    	if(data != null && data != ""){
	    		loginSessionId = data;
				loginBf.setAttribute("style", "display:none;");
				loginAf.setAttribute("style", "");
	    	}else{
	    		loginSessionId = "";
				loginBf.setAttribute("style", "");
				loginAf.setAttribute("style", "display:none;");
	    	}
		},
	    error: function(request, status, error){
        	alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
       	}
	})
});

//로그인 기능
function login(){
	var loginId = $("#txt_Id").val();
	var loginPw = $("#txt_Pw").val();
	if(loginId == null || loginId == "" || loginId == undefined){
		modalAlertShow("아이디가 입력되지 않았습니다.", "txt_Id");
	}else if(loginPw == null || loginPw == "" || loginPw == undefined){
		modalAlertShow("비밀번호가 입력되지 않았습니다.", "txt_Pw");
	}else{
		$.ajax({
			url:"/member/login",
			type:"post",
			data: {
				loginId : loginId,
				loginPw : loginPw
			},
			dataType:"json",
			success:function(data){
				if(data != 1){
					modalAlertShow("회원정보가 존재하지 않습니다.", "txt_Id");
					loginBf.setAttribute("style", "");
					loginAf.setAttribute("style", "display:none;");
				}else{
					modalAlertShow("성공적으로 로그인이 되었습니다.", "");
					$('#loginModal').modal("hide");
					loginBf.setAttribute("style", "display:none;");
					loginAf.setAttribute("style", "");
				}
			},
			error: function(request, status, error){
                alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
            }
			
		});
		
	}
}
//로그아웃
function logout(){
	$.ajax({
		url:"/member/logout",
		type:"post",
		success:function(data){
			if(data != null && data != ""){
				modalAlertShow("로그아웃 되었습니다.", "");
			 	loginSessionId = "";
				loginBf.setAttribute("style", "");
				loginAf.setAttribute("style", "display:none;");
	    	}
		},
		error: function(request, status, error){
        	alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
        }
		
	});
}


//Modal Call Form Reset
$('#memberModal').on('show.bs.modal', function (e) {
	
	$("#memberInput")[0].reset();
	
	fn_validation('mbrIdCheck','주로 사용하는 이메일을 입력해 주세요. 경매/판매 내역을 발송해 드립니다.', 'B');
	fn_validation('mbrPwdCheck','', 'B');
	fn_validation('mbrPwdReCheck','확인을 위해 새 비밀번호를 다시 입력해주세요.', 'B');
	fn_validation('mbrNmCheck','', 'B');
	
});

//Modal Alert Form
function modalForm(msg,obj) {
	var Html = "";
	Html +=	'<div class="modal-dialog modal-baeg max-w530">';
	Html +=	'<div class="modal-content">';
	Html +=	'<div class="modal-header" style="height: 0; min-height: 0; padding: 0;">';
	Html +=	'<div class="baegs">';
	//Html +=	'<div class="close" data-dismiss="modal" aria-label="Close"><img src="resources/img/ba/icon-end.png" /></div>';
	Html +=	'</div>';
	Html +=	'</div>';
	Html +=	'<div class="modal-body">';
	Html +=	'<div class="md-box-1">';
	Html +=	'<div class="md-ds" style="color:#333;">';
	Html +=	msg;
	Html +=	'</div>';
	Html +=	'<div class="baeg-btn mg_t30">';  //onclick="testing(\'' + text  + '\')"
	Html +=	'<button type="button" class="baeg-b1" onclick="modalAlertClose(\''+obj+'\');">확인</button>';
	Html +=	'</div>';
	Html +=	'</div>';
	Html +=	'</div>';
	Html +=	'</div>';
	Html +=	'</div>';
	$("#ModalAlert").empty();
	$("#ModalAlert").append(Html).trigger("create");
}


//회원가입
$("#memberInputBtn").on('click', function(event){

	//회원아이디
	var mbrId = $("#mbrId").val();
	//비밀번호
	var mbrPasswrd = $("#mbrPasswrd").val();
	//비밀번호 확인
	var mbrPasswrdConfirm = $("#mbrPasswrdConfirm").val();
	//성명
	var mbrNm = $("#mbrNm").val();
	//휴대번호
	var mbrCpNum = $("#mbrCpNum").val();
	
	if(isEmpty(mbrId)) {
		fn_validation('mbrIdCheck','이메일을 입력해주세요.', 'R');
		return;
	} 
	if(!CheckEmail(mbrId)) {
		fn_validation('mbrIdCheck','이메일을 올바르게 입력해주세요.', 'R');
		return;
	}
	//비밀번호--------------------------------------------------------------------//
	if(isEmpty(mbrPasswrd)) {
		$('#mbrPwdCheckU').css('color','red');
		$('#mbrPwdCheckD').css('color','#999999');
		return;
	} 
	if(!/^[a-zA-Z0-9!@#$%^&*()?_~]{8,20}$/.test(mbrPasswrd))
	{
		$('#mbrPwdCheckU').css('color','red');
		$('#mbrPwdCheckD').css('color','#999999');
		return;
	}
	var chk = 0;
	if(mbrPasswrd.search(/[0-9]/g) != -1 ) chk ++;
	if(mbrPasswrd.search(/[a-z]/ig)  != -1 ) chk ++;
	if(mbrPasswrd.search(/[!@#$%^&*()?_~]/g)  != -1  ) chk ++;
	if(chk < 2)
	{
		$('#mbrPwdCheckU').css('color','#999999');
		$('#mbrPwdCheckD').css('color','red');
		return;
	}
	 
	 var SamePass_0 = 0; //동일문자 카운트
	 var SamePass_1 = 0; //연속성(+) 카운드
	 var SamePass_2 = 0; //연속성(-) 카운드
	 
	 var chr_pass_0;
	 var chr_pass_1;
	 
	 for(var i=0; i < mbrPasswrd.length; i++) {
	  chr_pass_0 = mbrPasswrd.charAt(i);
	  chr_pass_1 = mbrPasswrd.charAt(i+1);
	 
	  //동일문자 카운트
	  if(chr_pass_0 == chr_pass_1) {
	   SamePass_0 = SamePass_0 + 1
	  } // if
	 
	 
	  //연속성(+) 카운드
	  if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == 1) {
	   SamePass_1 = SamePass_1 + 1
	  } // if
	 
	  //연속성(-) 카운드
	  if(chr_pass_0.charCodeAt(0) - chr_pass_1.charCodeAt(0) == -1) {
	  	SamePass_2 = SamePass_2 + 1
	  } // if
	 } // for
	 
	 if(SamePass_0 > 1) {
		 $('#mbrPwdCheckU').css('color','#999999');
		 $('#mbrPwdCheckD').css('color','red');
		 return;
	 } // if
	 
	 if(SamePass_1 > 1 || SamePass_2 > 1 )  {
		 $('#mbrPwdCheckU').css('color','#999999');
		 $('#mbrPwdCheckD').css('color','red');
		 return;
	 }
	
	 // 비밀번호 아이디 포함 여부
	 if(mbrPasswrd.search(mbrId)>-1)
	 {
		 $('#mbrPwdCheckU').css('color','#999999');
		 $('#mbrPwdCheckD').css('color','red');
		  return;
	 }
	
	 $('#mbrPwdCheckU').css('color','#999999');
	 $('#mbrPwdCheckD').css('color','#999999');
	 
	 
	//비밀번호.비밀번호확인 일치 체크 mbrPwdReCheck
	if(mbrPasswrd != mbrPasswrdConfirm) {
		fn_validation('mbrPwdReCheck','비밀번호가 일치 하지 않습니다.', 'R');
		return;
	}
	
	fn_validation('mbrPwdReCheck','확인을 위해 새 비밀번호를 다시 입력해주세요.', 'B');
	
	//비밀번호--------------------------------------------------------------------//
	
	 if(isEmpty(mbrNm)) {
		 fn_validation('mbrNmCheck','이름을 정확히 입력하세요', 'R');
		 return;
	 }
	 fn_validation('mbrNmCheck','', 'B');
	
	//휴대폰번호
	 if(isEmpty(mbrCpNum)) {
		 fn_validation('mbrCpNumCheck','휴대폰번호를 정확히 입력하세요.', 'R');
		 return;
	 }
	 
	fn_validation('mbrCpNumCheck','', 'B');
	 
	 let memParams = {
		  "mbrId" : mbrId,
		  "mbrPasswrd" : mbrPasswrd,
		  "mbrNm" : mbrNm,
		  "mbrCpNum" : mbrCpNum
	 }
	 
	 
	 $.ajax({
	     type: "post",
	     url: "main/memberInsertData",
	     data: memParams,
	     success: function(data) {
	    	 modalAlertShow("회원가입이 완료 되었습니다.","memberInput");
	   	 },
	     error: function(error) {
	  	   var errorJson = JSON.stringify(error);
	         console.log(errorJson);
	     }
	})
	
	
});

//이메일 형식 체크
function CheckEmail(str) {                                                 
	var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;

     if(!reg_email.test(str)) {                            
		return false;         
	} else {                       
        return true;         
    }                            
}                         



function modalAlertShow(msg,obj) {
	 //Modal Form Call
	 modalForm(msg,obj)
	 
	$("#ModalAlert").modal("show");
}

function modalAlertClose(obj) {
	
	$('#ModalAlert').modal('hide');
	
	if(obj == "memberInput") {
		//회원가입 모달
		$('#memberModal').modal('hide');
		//로그인 모달
		$('#loginModal').modal('show');
		//회원가입 Form reset
		$("#memberInput")[0].reset(); 
		
		return;
	}
	
	if(obj) {
		$('#'+obj).focus();
		return;
	}
}

//아이디 중복 체크
$("#mbrId").blur(function() {
	var dataCheckCount = {};
	
	var mbrIdParam = $("#mbrId").val();
	
	if(mbrIdParam) {
	
		let param = {
			mbrId : mbrIdParam
		}
		
		$.ajax({
			   type: "post",
			   url: "/admin/member/memberChkData",
			   data: param,
			   success: function(data) {
				   
				dataCheckCount = data.memberCheck.memberCheck[0];
				
				console.log("dataCheckCount :"+dataCheckCount);
				
				if(dataCheckCount > 0) {
								
					var msg = "이미 가입된 이메일 주소입니다. 다른 이메일을 입력해 주세요.";
					
					fn_validation('mbrIdCheck',msg, 'R');
					fn_validation('mbrPwdCheck','', 'B');
					fn_validation('mbrPwdReCheck','확인을 위해 새 비밀번호를 다시 입력해주세요.', 'B');
					fn_validation('mbrNmCheck','', 'B');
					$('#mbrPwdCheckU').css('color','#999999');
					$('#mbrPwdCheckD').css('color','#999999');
					
					return;
				
				} else {
					
					if(!CheckEmail(mbrIdParam)) {
						$('#mbrIdCheck').html('이메일을 올바르게 입력해주세요.');
						$('#mbrIdCheck').css('color','red');
					} else {
						var msg = "주로 사용하는 이메일을 입력해 주세요. 경매/판매 내역을 발송해 드립니다.";
						fn_validation('mbrIdCheck',msg, 'B');	
					}
					
					return;
				}
			   },
			   error: function(error) {
				   var errorJson = JSON.stringify(error);
			       //alert("오류 발생" + errorJson);
			       console.log(errorJson);
			   }
			})
	} else {
		
		var msg = "주로 사용하는 이메일을 입력해 주세요. 경매/판매 내역을 발송해 드립니다.";
		
		fn_validation('mbrIdCheck',msg, 'B');
		
		return;
		
	}
});


function fn_validation(inputId,msg,color) {
		
	$('#'+inputId).empty();
	
	$('#'+inputId).html(msg);
	
	if(color == 'R') {
		$('#'+inputId).css('color','red');	
	} else {
		$('#'+inputId).css('color','#999999');
	} 
	
	
}

$("#autocomplete").hide();
function ibx_search_onkeyup(e){
	var wordLength = $("#ibx_search").val().trim().length;
	if(wordLength > 1){
		$.ajax({
			url:"/main/totalSearchAutocomplete",
			type:"post",
			data: {
				searchKeyword : "*"+$("#ibx_search").val()+"*" 
			},
			dataType:"json",
			success:function(data){
				$("#work").empty();
				$("#artst").empty();
				var work = data.result.work;
				var artist = data.result.artist;
				var workHtml = '';
				var artstHtml = '';
				
				for(i=0; i<work.length; i++){
					workHtml +=	'<li><a href="javascript:void(0);" class="work" sq="'+work[i].workSq+'">'+work[i].workNm+'('+work[i].workProdcYear+')'+' - '+work[i].artstActvtyNm+'</a></li>';
				}
				$("#work").append(workHtml).trigger("create");
				
				for(i=0; i<artist.length; i++){
					artstHtml += '<li><a href="javascript:void(0);" class="artst" sq="'+artist[i].artstSq+'">'+artist[i].artstActvtyNm+' ('+artist[i].artistBirthYear+')</a></li>';
				}
				$("#artst").append(artstHtml).trigger("create");
				$("#autocomplete").show();
				
				
			},
			error: function(request, status, error){
                alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
            }
			
		});

	}
}
     
$(document).on("click",".work",function(){
	var workSq= $(this).attr("sq");
	alert(workSq); 
});

$(document).on("click",".artst",function(){
	var artistSq= $(this).attr("sq");
	alert(artistSq); 
});

$(document).on("click",".workMore",function(){
	alert("작품 검색 결과 페이지로 이동합니다"); 
});

$(document).on("click",".artistMore",function(){
	alert("작가 검색 결과 페이지로 이동합니다"); 
});

$(document).on("click",".contentMore",function(){
	alert("컨텐츠 검색 결과 페이지로 이동합니다"); 
});

function btn_search_onclick(){
	debugger;
	var searchKeyword = $("#ibx_search").val();
	if(searchKeyword == null || searchKeyword == ""){
		alert("검색어가 입력되지 않았습니다");
	}else{
		$.ajax({
	        type: "post",
	        url: "/totalSearch",
	        data: {
	     	   	"searchKeyword" : "*"+$("#ibx_search").val()+"*"
	        },
	        success: function(data) {
	     	   
	        },
	        error: function(error) {
	            alert("오류 발생" + error);
	        }
		})
	}
	
}

//Input Box Null Check
function isEmpty(str){
    
    if(typeof str == "undefined" || str == null || str == "")
        return true;
    else
        return false ;
}
</script>

</body>
</html>

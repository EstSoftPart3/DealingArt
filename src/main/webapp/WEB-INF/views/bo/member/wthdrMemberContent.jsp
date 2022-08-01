<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css">
		input[readonly].classname{
	 		 background-color:#ffffff;
		}
		 .LabelStyle
	    {
	    	background-color:#efefef;
	    	width:100px;
	    }
	    .dataValue{
	    	background-color:#ffffff;
	    }	
	</style>
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>

		<div class="content-wrapper">

			<!-- Main content -->
			<section class="content">
				<div class="card-header">
					<h3 class="card-title bTitle">회원 상세정보</h3>
				</div>

				<form class="form-horizontal">
					<!--card-body -->
					<table class="table table-bordered">
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center">회원 구분</td>
							<td id="authSqTxt" class="col-sm-2 dataValue"></td>
							<td class="col-sm-1" align="center">사용 여부</td>
							<td id="useYn" class="col-sm-2 dataValue"></td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center">아이디</td>
							<td id="mbrId" class="col-sm-2 dataValue"></td>
							<td class="col-sm-1" align="center">닉네임</td>
							<td id="mbrNcknm" class="col-sm-2 dataValue"></td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center">성명</td>
							<td id="mbrNm" class="col-sm-2 dataValue"></td>
							<td class="col-sm-1" align="center">성별</td>
							<td id="mbrSexCd" class="col-sm-2 dataValue"></td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center">생년월일</td>
							<td id="mbrBirth" class="col-sm-2 dataValue"></td>
							<td class="col-sm-1" align="center">휴대폰 번호</td>
							<td id="mbrCpNum" class="col-sm-2 dataValue"></td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center">집 주소</td>
							<td id="mbrHomeAddr" class="col-sm-2 dataValue"></td>
							<td class="col-sm-1" align="center">배송지 주소</td>
							<td id="mbrDelivryAddr" class="col-sm-2 dataValue"></td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center">이메일</td>
							<td id="mbrEmail" class="col-sm-2 dataValue"></td>
							<td class="col-sm-1" align="center">가입일</td>
							<td id="regDt" class="col-sm-2 dataValue"></td>
						</tr>
					</table>


					<!--card-footer -->
					<div class="card-footer" style="text-align: right; background-color: #ffffff">
						<button type="button" class="btn btn-info sTitle" onclick="location='/admin/member/outMemberList'">목록</button>
					</div>

				</form>

			</section>
		</div>

	</div>


	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>

	<script>
        var dataContent = {};
   
		$(document).ready(function(){
			
			//회원순번
			var mbrSq = '<c:out value="${param.mbrSqParam}" />';
			
			//회원권한순번
			var AuthSq = '<c:out value="${param.mbrAuthSq}" />';
			
			memberContentData(mbrSq);
			
		});
		
		//회원 정보 호출
		function memberContentData(mbrSq) {			
			
			$.ajax({
		           type: "post",
		           url: "/admin/member/wthdrMemberContentData",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(data) {		        	   
		        	  
		        	 dataContent = data.wthdrMemContent.wthdrMemContent[0];
		        	 
		        	 console.log(dataContent);
		        	 var mbrNm = dataContent.mbrNm						//이름
		        	 var mbrId = dataContent.mbrId						//아이디
		        	 var mbrNcknm = dataContent.mbrNcknm				//닉네임
		        	 var mbrEmail = dataContent.mbrEmail				//이메일
		        	 var mbrBirth = dataContent.mbrBirth				//생년월일
		        	 var mbrSexCd = dataContent.mbrSexCd				//성별
		        	 var mbrCpNum = dataContent.mbrCpNum				//휴대폰번호
		        	 var regDt = dataContent.regDt						//회원등록일시
		        	 var mbrHomeAddr = dataContent.mbrHomeAddr			//집주소
		        	 var mbrDelivryAddr = dataContent.mbrDelivryAddr	//배송지 주소
		        	 var useYn = dataContent.useYnRplc					//사용여부
		        	 var authSq = dataContent.authSq					//회원구분
		        	 
		        	 var mbrPasswrd = dataContent.mbrPasswrd			//회원구분
		        	 
		        	 var authSqTxt = '';
		        	 
		        	 if(authSq == '1') {
		        		 authSqTxt = '일반';
		        	 }
		        	 
		        	 if(authSq == '2') {
		        		 authSqTxt = '작가'; 
		        	 }
		        	 
		        	 if(authSq == '3') {
		        		 authSqTxt = '관리자';
		        	 }
		        	 
		        	 if(authSq == '4') {
		        		 authSqTxt = '전체관리자'; 
		        	 }
		        	 
		        	 $("#authSqTxt").text(authSqTxt);
		        	 $("#mbrNm").text(mbrNm);
		        	 $("#useYn").text(useYn);
		        	 $("#mbrId").text(mbrId);
		        	 $("#mbrNcknm").text(mbrNcknm);
		        	 $("#mbrEmail").text(mbrEmail);
		        	 $("#mbrBirth").text(mbrBirth);
		        	 $("#mbrSexCd").text(mbrSexCd);
		        	 $("#mbrCpNum").text(mbrCpNum);
		        	 $("#regDt").text(regDt);
		        	 $("#mbrHomeAddr").text(mbrHomeAddr);
		        	 $("#mbrDelivryAddr").text(mbrDelivryAddr);    	
		        	 
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}
	
	</script>
</body>

</html>
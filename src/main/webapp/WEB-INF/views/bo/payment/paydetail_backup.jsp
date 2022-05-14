<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
	String dealSq = request.getParameter("dealSq");
%>

 <style type="text/css">
	
 .infoBox {
  box-shadow: 0 0 1px rgba(0, 0, 0, 0.125), 0 1px 3px rgba(0, 0, 0, 0.2);
  border-radius: 0.25rem;
  background: #ffffff;
  display: -ms-flexbox;
  display: flex;
  margin-bottom: 1rem;
  padding: .5rem;
  position: relative;
  width: 100%;
  min-height: 30px;
 }
 
 
 </style>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		 
		 	<!-- Main content -->
	    	<section class="content">
	    	
	    		<input type="hidden" name="dealSq" id="dealSq" value="<%=dealSq%>">
	    		
	    		 
	    		  <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>구매자 </b></a></li>
		           		<li><a href="javascript:history.back();" class="sTitle"  style="padding-left:10px;"><b>[리스트로 돌아가기]</b></a></li>
		           	</ul>
				 </div>
				 
				 <div class="card">
				 
				 	
				 		<table class="table table-bordered" style="font-size:11px;">
		                  <thead>                  
		                    <tr align="center" style="background-color:#efefef">
		                     
		                      <th>거래 진행상황</th>
		                      <th>구매자명</th>
		                      <th>전화번호</th>
		                      <th>이메일</th>
		                      <th>배송지주소</th>
		                    </tr>
		                  <thead>  
		                  <tbody>
		                      <tr align="center">
		                    	<td>
		                    		<span style="color:red" id="dealSttsCd"></span>
		                    	</td>
		                    	<td>
		                    		<span id="getMbrNm"></span>
		                    	</td>
		                    	<td>
		                    		<span id="mbrCpNum"></span>
		                    	</td>
		                    	<td>
		                    		<span id="mbrEmail"></span>
		                    	</td>
		                    	<td>
		                    		<span id="mbrDelivryAddr"></span>
		                    	</td>	
		                    </tr>
		                  </tbody>
		                 </table>
				 	
				 	
				 	
				 	
	    		 </div>
	    		 
	    		 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>결제정보</b></a></li>
		           	</ul>
				 </div>
				 
				
				 <div class="card">
				 	
				 	
				 		
				 		
				 		<table class="table table-bordered" style="font-size:11px;">
		                  <thead>                  
		                    <tr align="center" style="background-color:#efefef">
		                     
		                      <th>주문번호</th>
		                      <th>주문상품</th>
		                      <th>결제수단</th>
		                      <th>결제금액(원)</th>
		                      <th>결제카드명</th>
		                      <th>결제카드번호</th>
		                      <th>결제일자</th>
		                      
		                    </tr>
		                  </thead>
		                  <tbody>
		                  
		                  	  <tr align="center">
		                    	<td>
		                    		<span id="refNo"></span>
		                    	</td>
		                    	<td>
		                    		<span id="goodsName"></span>
		                    	</td>
		                    	<td>
		                    		<span id="paymethod"></span>
		                    	</td>
		                    	<td>
		                    		<span id="taxFreeAmount"></span>
		                    	</td>
		                    	<td>
		                    		<span id="acqCompanyName"></span>
		                    	</td>
		                    	<td>
		                    		<span id="cardNo"></span>
		                    	</td>
		                    	<td>
		                    		<span id="tranDate"></span>
		                    	</td>
		                    		
		                     </tr>
		                  </tbody>
				 		</table>	
				 		
				 
				 		
				 </div>
				 
				<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
		           	<ul class="nav nav-pills">
			       		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>구매 작가/작품</b></a></li>
			       	</ul>
				</div>
				
				<div class="card">
				
				
					
						<table class="table table-bordered" style="font-size:11px;">
		                  <thead>                  
		                    <tr align="center" style="background-color:#efefef">
		                     <th></th>
		                     <th>작가정보</th>
		                     <th>구매작품</th>
		                     <th>구매정보</th>
		                    </tr>
		                  <thead>  
			    		  <tbody>
			    		  	<tr align="center">
			    		  		<td style="width:150px;">
			    		  			<img class="content" id="artstProfileImgUrl" style="cursor:pointer;height:152px;width:150px;"/>
			    		  		</td>
			    		  		<td style="width:500px;">
			    		  			<span id="mbrNm"></span>
			    		  			<br>
			    		  			<span id="artstActvtyNm"></span>
			    		  			<br>
			    		  			<span id="artstActvtyPartCdTxt"></span>
			    		  			
			    		  		</td>
			    		  		<td style="width:150px;">
			    		  			<img class="content" id="workMainImgUrl" style="cursor:pointer;height:152px;width:150px;"/>
			    		  		</td>
			    		  		<td style="width:500px;">
			    		  			
			    		  		</td>
			    		  	</tr>
			    		  </tbody>
			         	</table>	
			    		   		
								
		              	
	             
			
				</div>
				
				
				
	    		
	    	</section>
	    	
	    	
	    	
		    	
			
	</div>
	
	 

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
	   
	 	$(document).ready(function(){
	 		
	 		var dealSq = $("#dealSq").val();
	 		
	 		payDetailData(dealSq);
			
	    });
	 	
	 	function payDetailData(dealSq) {
	 		
	 		$.ajax({
		           type: "post",
		           url: "/admin/payment/payDetailData",
		           data: {
		        	   dealSq : dealSq,
		           },
		           success: function(ref) {
		        	   
		        	    
		        	 dataContent = ref.data.detailInfo[0];
		        	 
		        	 
		        	 
		        	 /* 회원번호 */
		        	 artistMemberInfoData(dataContent.artstSq);
		        	 
		        	 /* 구매회원 */
		        	 memberContentData(dataContent.mbrSq);
		        	 
		        	 /* 거래 메인 */
		        	 workMainContent(dataContent.dealSq);
		        	
		        	 
		        	 /* 주문상품 */
		        	 $('#goodsName').html(dataContent.goodsName);
		        	 
		        	 /* 결제수단 */
		        	 $('#paymethod').html(dataContent.paymethod);
		        	 
					 /* 결제금액 */ 
					 $('#taxFreeAmount').html(dataContent.taxFreeAmount);
					 
					 /* 결제카드명 */
					 $('#acqCompanyName').html(dataContent.acqCompanyName);
					 
					 /* 주문번호 */
					 $('#refNo').html(dataContent.refNo);
					 					 
					 /* 거래일자 */
					 $('#tranDate').html(dataContent.tranDate);
					 
					 /* 카드번호 */
					 $('#cardNo').html(dataContent.cardNo);
					 
					 
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
	 		
	 	}
	 	
	 	
	 	//작가정보
		function artistMemberInfoData(artstSq) {
	 		
			$.ajax({
		           type: "post",
		           url: "/admin/member/artistMemberInfoData",
		           data: {
		        	   artstSq : artstSq
		            },
		           success: function(data) {
		        	   
		        	   dataInfo = data.artistMemberInfoData.artistMemberInfo[0];
			        		        	  
			        	if(dataInfo) {
			        		
			        		var mbrNm 					= dataInfo.mbrNm;
			           		var artstSq 				= dataInfo.artstSq;
				        	var artstActvtyNm			= dataInfo.artstActvtyNm;
				        	var artstEnglsNm			= dataInfo.artstEnglsNm;
				        	var artstProfileImgUrl		= dataInfo.artstProfileImgUrl;
				        	var artstActvtyNatnCd		= dataInfo.artstActvtyNatnCd;
				        	var artstActvtyCityCd		= dataInfo.artstActvtyCityCd;
				        	var artstActvtyPartCd		= dataInfo.artstActvtyPartCd;
				        	
				        	var artstActvtyPartCdTxt = "";
				        	if(artstActvtyPartCd == "PNTNG") {
				        		artstActvtyPartCdTxt = "회화";
				        	} else if(artstActvtyPartCd == "MLDNG") {
				        		artstActvtyPartCdTxt = "조형";
				        	} else if(artstActvtyPartCd == "VDMD") {
				        		artstActvtyPartCdTxt = "영상 미디어";
				        	} else if(artstActvtyPartCd == "INSTL") {
				        		artstActvtyPartCdTxt = "설치";
				        	}
				        	
				        	
				        	console.log(artstActvtyPartCd);
				        	
				        	
				        	/* 작가영문명 */
				        	//$("#artstEnglsNm").val(artstEnglsNm);
				        	/* 활동지역 : 국가 */
					      	//$('select[name=artstActvtyNatnCd]').val(artstActvtyNatnCd);
					    	/* 활동지역 : 도시 */
					    	//$('select[name=artstActvtyCityCd]').val(artstActvtyCityCd);
					    	/* 활동분야 */
					    	/* Form checked Clear */
					    	//$(".artstActvtyPartCd").prop('checked' , false);
					    	//$(".artstActvtyPartCd:input[value='"+artstActvtyPartCd+"']").prop("checked", true);
					    	/* 자기소개 */				        	
				        	//$("#artstSelfIntro").val(artstSelfIntro);
					    	/* 프로필 이미지 */
				        	//$("#artstProfileImgUrl").val(artstProfileImgUrl);
				        	
					    	/* 프로필사진 */
					    	$("#artstProfileImgUrl").prop("src",artstProfileImgUrl);
				        	/* 작가 성명 */
					        $("#mbrNm").html(mbrNm);
					    	/* 작가횔동명 */
				        	$("#artstActvtyNm").html(artstActvtyNm);
					    	
					    	$("#artstActvtyPartCdTxt").html(artstActvtyPartCdTxt)
				        	
				        
			        	}
		        	
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
		}
	 	
		//회원 정보 호출
		function memberContentData(mbrSq) {
			
			console.log("memberContentData : "+ mbrSq);
			
			$.ajax({
		           type: "post",
		           url: "/admin/member/memberContentData",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(data) {
		        	   
		        	    
		        	 dataContent = data.memberContentData.memberContent[0];
		        	 
		        	 
		        	
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
		        	 var useYn = dataContent.useYn						//사용여부
		        	 var authSq = dataContent.authSq					//회원구분
		        	 
		        	 $("#getMbrNm").html(mbrNm);
					 $("#mbrCpNum").html(mbrCpNum);
					 $("#mbrEmail").html(mbrEmail);
					 $("#mbrHomeAddr").html(mbrHomeAddr);
					 $("#mbrDelivryAddr").html(mbrDelivryAddr);
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}
		
		
		//거래 메인 호출
		function workMainContent(mbrSq) {
			
			console.log("memberContentData : "+ mbrSq);
			
			$.ajax({
		           type: "post",
		           url: "/admin/payment/dealMainListData",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(ref) {
		        	   
		        	    
		        	 dataContent = ref.data.dealInfo[0];
		        	 
		        	 $("#dealSttsCd").html(dataContent.dealSttsCd);
		        	 
		        	 fn_workInfo(dataContent.workSqNum)
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		 }
			
			
		  //거래 작품
	     function fn_workInfo(workSqNum) {
	    	 
	    	 $.ajax({
		           type: "post",
		           url: "/admin/payment/workInfoData",
		           data: {
		        	   workSq : workSqNum
		            },
		           success: function(ref) {
		        	   
		        	    
		        	 dataContent = ref.data.workInfo[0];
		        	 
		        	 var workMainImgUrl = dataContent.workMainImgUrl;
		        	 $("#workMainImgUrl").prop("src",workMainImgUrl);
		        	 
		           }
		        	
			})
	     }
	    	 
	   

	 </script>
 
 
</body>
</html>
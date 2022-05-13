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
	    		
	    		 
	    		  <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>주문 상세 - 구매자 </b></a></li>
		           		<li><a href="javascript:history.back();" class="sTitle"  style="padding-left:10px;"><b>[리스트로 돌아가기]</b></a></li>
		           	</ul>
				 </div>
				 
				 <div class="card">
				 
				 	<div class="card-body" style="background-color:#ffffff;">
				 	
				 		<div class="col-md-9">
				 			<div class="form-group row">
				 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;color:red">거래 진행상황</label>
                    			<div class="col-sm-2" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" style="color:red" id="dealSttsCd"></span>
	                      				</div>
	                      			</div>
                    			</div>
				 			</div>
				 			
				 			<div class="form-group row">
				 				
				 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">구매자명</label>
                    			<div class="col-sm-2" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="getMbrNm"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
                    			<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">전화번호</label>
                    			<div class="col-sm-2" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="mbrCpNum"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
                    			<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">이메일</label>
                    			<div class="col-sm-2" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="mbrEmail"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
				 			</div>
				 		
				 			<div class="form-group row">
				 				
				 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">배송지주소</label>
                    			<div class="col-sm-8" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="mbrDelivryAddr"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
				 			</div>
				 			
				 			
				 			
				 		</div>
				 	
				 	</div>
				 	
	    		 </div>
	    		 
	    		 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>주문 상세 - 결제정보</b></a></li>
		           	</ul>
				 </div>
				 
				 
				 
				 <div class="card">
				 	
				 	<div class="card-body" style="background-color:#ffffff;">
				 	
				 	
				 		
				 		<div class="col-md-9">
				 		
				 			<div class="form-group row">
				 				
				 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">주문번호</label>
                    			<div class="col-sm-3" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="refNo"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
                    			<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">주문상품</label>
                    			<div class="col-sm-3" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="goodsName"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
				 			</div>
				 			
				 			
				 			
				 		</div>
				 		
				 		<div class="col-md-9">
				 		
				 			<div class="form-group row">
				 			
				 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">결제수단</label>
                    			<div class="col-sm-3" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="paymethod"></span>
	                      				</div>
	                      			</div>
                    			</div>
		               			
                    			
                    			<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">결제금액</label>
                    			<div class="col-sm-3" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="taxFreeAmount"></span>
	                      				</div>
	                      			</div>
                    			</div>
		               		 </div>
		               		   			
				 		</div>	
				 		
				 		<div class="col-md-9">
				 			<div class="form-group row">
				 				
				 				
                    			
				 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">결제카드명</label>
                    			<div class="col-sm-3" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="acqCompanyName"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
                    			<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">결제카드번호</label>
                    			<div class="col-sm-3" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="cardNo"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
				 			 </div>
				 		</div>		 		
				 		
				 		<div class="col-md-9">
				 			
				 			<div class="form-group row">
				 				
				 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:80px;">결제일자</label>
                    			<div class="col-sm-3" >
                      				<div class="infoBox bg-light">
	                      				<div class="info-box-content">
	                      					<span class="info-box-text text-center sTitle" id="tranDate"></span>
	                      				</div>
	                      			</div>
                    			</div>
                    			
				 			</div>
				 			
				 		</div>
			
				 	</div>
				 		
				 </div>
				 
				<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
		           	<ul class="nav nav-pills">
			       		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>구매작품 작가</b></a></li>
			       	</ul>
				</div>
				
				<div class="card">
				
					<div class="card-body" style="background-color:#ffffff;">
			    	
			    		
		               <div class="form-group row">
		               		<div class="col-sm-1" >
								<div style="height:152px;width:150px;background-color:#efefef">
			           	             <img class="content" id="artstProfileImgUrl" style="cursor:pointer;height:152px;width:150px;"/>
						        </div>
		               		</div>
		               								
							
			           		<div class="col-sm-3" style="padding-left:50px;">
			           			<div class="infoBox bg-light">
				         				<div class="info-box-content">
				         					<label class="col-form-label sTitle LabelStyle" style="text-align: center;width:100px;">작가(활동)명</label>
				         					<span class="info-box-text text-center sTitle" id="mbrNm" style="width:80px;"></span>
				         					(<span class="info-box-text text-center sTitle" id="artstActvtyNm" style="width:80px;"></span>)
				         				</div>
				         			</div>
			           		</div>
		               </div>
		                  		
								
		              	
	              	</div>
			
				</div>
				
				
				<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
		           	<ul class="nav nav-pills">
			       		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>구매작품</b></a></li>
			       	</ul>
				</div>
				
				<div class="card">
					<div class="card-body" style="background-color:#ffffff;">
						<div class="form-group row">
						
							<div class="col-sm-1" >
								<div style="height:152px;width:150px;background-color:#efefef">
			           	             <img class="content" id="workMainImgUrl" style="cursor:pointer;height:152px;width:150px;"/>
						        </div>
		               		</div>
							
						</div>
					</div>
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
				        	var artstActvtyNatnCd		= dataInfo.artstActvtyNatnCd;
				        	var artstActvtyCityCd		= dataInfo.artstActvtyCityCd;
				        	var artstActvtyPartCd		= dataInfo.artstActvtyPartCd;
				        	
				        	var artstActvtyCd			= dataInfo.artstActvtyCd;
				        	var artstSelfIntro			= dataInfo.artstSelfIntro;
				        	var artstProfileImgUrl		= dataInfo.artstProfileImgUrl;
				        	var artstHmpgUrl			= dataInfo.artstHmpgUrl;
				        	var artstPromtnVideoUrl		= dataInfo.artstPromtnVideoUrl;
				        	var artstFacebookUrl		= dataInfo.artstFacebookUrl;
				        	var artstInstagramUrl		= dataInfo.artstInstagramUrl;
				        	
				        	
				        	
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
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
	    		<input type="hidden" name="sellMbrSq" id="sellMbrSq" value="">
	    		<input type="hidden" name="buyMbrSq" id="buyMbrSq" value="">
	    		<input type="hidden" name="workSq" id="workSq" value="">
	    		<input type="hidden" name="artstSq" id="artstSq" value="">
	    		
	    		<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>결제진행단계</b></a></li>
		           		<li><a href="javascript:history.back();" class="sTitle"  style="padding-left:10px;"><b>[결제 리스트로 돌아가기]</b></a></li>
		           	</ul>
				 </div>
				 <div class="card">
				 
					<table class="table table-bordered" style="font-size:11px;" style="width:900px;">
		                  <thead>                  
		                    <tr align="center" style="background-color:#efefef">
		                      
		                      <th>결제자구분</th>
		                      <th>1차결제대기</th>
		                      <th>1차결제완료</th>
		                      <th>2차결제대기</th>
		                      <th>2차결제완료</th>
		                      
		                    </tr>
		                  </thead>
		                  <tbody>
		                  	<tr align="center">
		                  		<td>
		                  			판매자
		                  		</td>
			       				<td>
			                  		<input type="radio" name="sellPaymntSttsCd" class="sellPaymntSttsCd" value="1PW" onclick="dealMainSttsCdUpdate('<%=dealSq%>','1PW','buy')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="sellPaymntSttsCd" class="sellPaymntSttsCd" value="1PC" onclick="dealMainSttsCdUpdate('<%=dealSq%>','1PC','buy')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="sellPaymntSttsCd" class="sellPaymntSttsCd" value="2PW" onclick="dealMainSttsCdUpdate('<%=dealSq%>','2PW','buy')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="sellPaymntSttsCd" class="sellPaymntSttsCd" value="2PC" onclick="dealMainSttsCdUpdate('<%=dealSq%>','2PC','buy')" disabled>
			                  	</td>
			                  	
			                  </tr>
			                  <tr align="center">
		                  		<td>
		                  			구매자
		                  		</td>
			       				<td>
			                  		<input type="radio" name="buyPaymntSttsCd" class="buyPaymntSttsCd" value="1PW" onclick="dealMainSttsCdUpdate('<%=dealSq%>','1PW','sell')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="buyPaymntSttsCd" class="buyPaymntSttsCd" value="1PC" onclick="dealMainSttsCdUpdate('<%=dealSq%>','1PC','sell')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="buyPaymntSttsCd" class="buyPaymntSttsCd" value="2PW" onclick="dealMainSttsCdUpdate('<%=dealSq%>','2PW','sell')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="buyPaymntSttsCd" class="buyPaymntSttsCd" value="2PC" onclick="dealMainSttsCdUpdate('<%=dealSq%>','2PC','sell')" disabled>
			                  	</td>
			                  	
			                  </tr>
		                  </tbody>  
				 	 </table>
				 	 
				 </div>
				 
				 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>거래상태단계</b></a></li>
		            </ul>
				 </div>
				 
				 <div class="card">
				 
				 <table class="table table-bordered" style="font-size:11px;" style="width:900px;">
		                  <thead>                  
		                    <tr align="center" style="background-color:#efefef">
		                      <th>거래진행중</th>
		                      <th>거래종료</th>
		                      <th>배송준비중</th>
		                      <th>배송중</th>
		                      <th>배송완료</th>
		                      <th>구매확정</th>
		                      <th>거래중지</th>
		                    </tr>
		                  </thead>
		                  <tbody>
		                  	<tr align="center">
			                  	<td>
			                  		<input type="radio" name="dealSttsCd" class="dealSttsCd" value="TP" onclick="dealMainSttsCdUpdate('<%=dealSq%>','TP','deal')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="dealSttsCd" class="dealSttsCd" value="TC" onclick="dealMainSttsCdUpdate('<%=dealSq%>','TC','deal')" disabled>
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="dealSttsCd" class="dealSttsCd" value="PD" onclick="dealMainSttsCdUpdate('<%=dealSq%>','PD','deal')">
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="dealSttsCd" class="dealSttsCd" value="DS" onclick="dealMainSttsCdUpdate('<%=dealSq%>','DS','deal')">
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="dealSttsCd" class="dealSttsCd" value="DC" onclick="dealMainSttsCdUpdate('<%=dealSq%>','DC','deal')">
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="dealSttsCd" class="dealSttsCd" value="PC" onclick="dealMainSttsCdUpdate('<%=dealSq%>','PC','deal')">
			                  	</td>
			                  	<td>
			                  		<input type="radio" name="dealSttsCd" class="dealSttsCd" value="ST" onclick="dealMainSttsCdUpdate('<%=dealSq%>','ST','deal')">
			                  	</td>
			                  
			                  </tr>
		                  </tbody>  
				 	 </table>
				 	
				 </div>
				 
	    		
	    		 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>결제정보</b></a></li>
		           		<li><a href="javascript:void(0);" class="sTitle" id="btn_orderFormDown" onclick="orderFormExcelDown();" style="padding-left:10px; display:none;"><b>[발주서 엑셀 파일 다운로드]</b></a></li>
		           	</ul>
				 </div>
				 
				 <div class="card">
	    			<div id="paymentList" style="font-size:12px;"></div>
	    		 </div>
	    		     		 
	    		 
	    		 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>판매자</b></a></li>
		           		
		            </ul>
				 </div>
				 <div class="card">
				 
				 	<table class="table table-bordered" style="font-size:11px;" style="width:900px;">
		                  <thead>                  
		                    <tr align="center" style="background-color:#efefef">
		                      <th>구매자명</th>
		                      <th>전화번호</th>
		                      <th>이메일</th>
		                      <th>주소</th>
		                      <th>배송지주소</th>
		                      <th>은행</th>
		                      <th>계좌번호</th>
		                    </tr>
		                  <thead>  
		                  <tbody>
		                      <tr align="center">
		                    	<td style="width:100px;">
		                    		<span id="sellMbrNm"></span>
		                    	</td>
		                    	<td style="width:100px;">
		                    		<span id="sellMbrCpNum"></span>
		                    	</td>
		                    	<td style="width:150px;">
		                    		<span id="sellMbrEmail"></span>
		                    	</td>
		                    	<td style="width:500px;">
		                    		<span id="sellMbrHomeAddr"></span>
		                    	</td>
		                    	<td style="width:500px;">
		                    		<span id="sellMbrDelivryAddr"></span>
		                    	</td>
		                    	<td style="width:auto;">
		                    		<span id="sellMbrBankNm"></span>
		                    	</td>
		                    	<td style="width:auto;">
		                    		<span id="sellMbrAccountNo"></span>
		                    	</td>	
		                    </tr>
		                  </tbody>
		                 </table>
				 	
				 </div>
	    		 
	    		 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>구매자 </b></a></li>
		           	</ul>
				 </div>
				 
				 <div class="card">
				 	
				 		<table class="table table-bordered" style="font-size:11px;">
		                  <thead>                  
		                    <tr align="center" style="background-color:#efefef">
		                      <th>구매자명</th>
		                      <th>전화번호</th>
		                      <th>이메일</th>
		                      <th>주소</th>
		                      <th>배송지주소</th>
		                      <th>은행</th>
		                      <th>계좌번호</th>
		                    </tr>
		                  <thead>  
		                  <tbody>
		                      <tr align="center">
		                    	<td style="width:100px;">
		                    		<span id="buyMbrNm"></span>
		                    	</td>
		                    	<td style="width:100px;">
		                    		<span id="buyMbrCpNum"></span>
		                    	</td>
		                    	<td style="width:150px;">
		                    		<span id="buyMbrEmail"></span>
		                    	</td>
		                    	<td style="width:500px;">
		                    		<span id="buyMbrHomeAddr"></span>
		                    	</td>
		                    	<td style="width:500px;">
		                    		<span id="buyMbrDelivryAddr"></span>
		                    	</td>
		                    	<td style="width:auto;">
		                    		<span id="#buyMbrBankNm"></span>
		                    	</td>
		                    	<td style="width:auto;">
		                    		<span id="#buyMbrAccountNo"></span>
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
		                     <th></th>
		                     <th>작품정보</th>
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
			    		  			<span id="workNm"></span>
			    		  			<br>
			    		  			<span id="workProdcYear"></span>
			    		  			<br>
			    		  			<span id="workPrc"></span>
			    		  		</td>
			    		  	</tr>
			    		  </tbody>
			         	</table>	
			 	</div>
				<div id="dealFileUpload" style="display:none;">
					<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
			           	<ul class="nav nav-pills">
				       		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>거래 관련 파일 업로드</b></a></li>
				       	</ul>
					</div>
					
					<div class="card">
					
							<table class="table table-bordered" style="font-size:11px;">
			                	<thead>                  
			                  		<tr align="center" style="background-color:#efefef">
			                    		<th>거래확인서</th>
			                    		<th>거래명세서</th>
			                    		<th>거래계약서</th>
			                    		<th>컨디션체크리포트</th>
			                    		<th></th>
			                    	</tr>
			                  	<thead>  
				    		  	<tbody>
				    		  		<tr align="center">
				    		  			<td>
				    		  				<input type="file" id="dealConfirmation">
				    		  				<br/><a href="" id="dealConfirmationDown" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
				    		  			</td>
				    		  			<td>
				    		  				<input type="file" id="dealStatement">
				    		  				<br/><a href="" id="dealStatementDown" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
				    		  			</td>
				    		  			<td>
				    		  				<input type="file" id="dealContract">
				    		  				<br/><a href="" id="dealContractDown" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
				    		  			</td>
				    		  			<td>
				    		  				<input type="file" id="dealConditionCheck">
				    		  				<br/><a href="" id="dealConditionCheckDown" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
				    		  			</td>
				    		  			<td>
				    		  				<button type="button" class="btn btn-info sTitle" onclick="dealFileUpload()">저장</button>
				    		  			</td>
				    		  		</tr>
				    		  </tbody>
				         	</table>	
				 
					</div>
				</div>
				
				<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>결제 CS 메모</b></a></li>
		           	</ul>
				 </div>
	    		 <div class="card">
	    		 	
	    		 	<table border="0" cellpadding="0" cellspacing="0" align="center">
	    		 		<tr>
	    		 			<td style="width:900px;">
				    		 	<textarea name="dealMemo" id="dealMemo" style="height:150px;width:900px;font-size:12px;"></textarea>
	    		 			</td>
	    		 			<td align="left" style="vertical-align:bottom;padding-bottom:10px;padding-left:10px;">
	    		 				<button type="button" class="btn btn-info sTitle" onclick="dealMainMemoUpdateData()">저장</button>
	    		 			</td>
	    		 		</tr>
	    		 	</table>
	    		 	
	    		 </div>
			    		
	    	</section>
	  	
	</div>
</div>
	   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
	   	var dealSttsCd = "";
	  	var sellPaymntSttsCd = "";
	  	var buyPaymntSttsCd = "";
	 	$(document).ready(function(){
	 		
	 		var dealSq = $("#dealSq").val();
	 		
	 		fn_dealMainContent(dealSq);
			
	 		//작품 거래 내역
	 		//fn_workDealh(dealSq);
	 		
	    });
	 	
	 	//작품 거래 내역
	 	function fn_workDealh(dealSq) {
	 		
	 		$.ajax({
		           type: "post",
		           url: "/admin/payment/workDealhListData",
		           data: {
		        	   dealSq : dealSq
		           },
		           success: function(ref) {
		        	   	        	    
		        	 dataContent = ref.data.workDealInfo[0];
		        	 
		        	 var sellMbrSq 	= dataContent.sellMbrSq;//판매자_순번
		        	 var buyMbrSq 	= dataContent.buyMbrSq;	//구매자_순번
		        	 var artstSq 	= dataContent.artstSq;	//작가_순번
		        	 var workSq 	= dataContent.workSq;	//작품_순번
		        	
		        	 //판매자 정보 호출
		        	 fn_sellMbr(sellMbrSq);
		        	 
		        	 //구매자 정보 호출
		        	 fn_buyMbr(buyMbrSq);
		        	 
		        	 //결제 내역
		        	 paymentList(dealSq);
		        	 
		        	 //거래 메인
		        	 workMainContent(dealSq)
		        	 
		        	 //작가 정보
		        	 artistMemberInfoData(artstSq);
		        	 
		        	 //작품정보
		        	 fn_workInfo(workSq);
		        	 
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
	 		
	 	}
	 	
	 	//거래 메인
	 	function fn_dealMainContent(dealSq) {
	 		
	 		$.ajax({
		           type: "post",
		           url: "/admin/payment/dealMainListData",
		           data: {
		        	   dealSq : dealSq
		           },
		           success: function(ref) {
		        	 dataContent = ref.data.dealInfo[0];
		        	 
		        	 var sellMbrSq 	= dataContent.sellMbrSq;//판매자_순번
		        	 var buyMbrSq 	= dataContent.buyMbrSq;	//구매자_순번
		        	 var artstSq 	= dataContent.artstSq;	//작가_순번
		        	 var workSqNum 	= dataContent.workSqNum;//작품_순번
		        	 var dealSttsCd = dataContent.dealSttsCd; //거래상태
		        	 //판매자 정보 호출
		        	 fn_sellMbr(sellMbrSq);
		        	 
		        	 //구매자 정보 호출
		        	 fn_buyMbr(buyMbrSq);
		        	 
		        	 //결제 내역
		        	 paymentList(dealSq);
		        	 
		        	 //거래 메인
		        	 workMainContent(dealSq)
		        	 
		        	 //작가 정보
		        	 artistMemberInfoData(artstSq);
		        	 
		        	 //작품정보
		        	 fn_workInfo(workSqNum);
		        	 
		        	 $("#sellMbrSq").val(sellMbrSq);
		        	 $("#buyMbrSq").val(buyMbrSq);
		        	 $("#artstSq").val(artstSq);
		        	 $("#workSq").val(workSqNum);
		        	 
		        	 //거래 관련 파일 업로드 div
		        	 if(dealSttsCd == "TC" || dealSttsCd == "FB"){
		        		 $("#dealFileUpload").css("display", "none");
		        	 }else{
		        		 $("#dealFileUpload").css("display", "");
		        	 }
		        	 
		        	 if(dataContent.dealConfirmation != null && dataContent.dealConfirmation != ""){
		        		 $("#dealConfirmationDown").attr("href", dataContent.dealConfirmation);
		        		 $("#dealConfirmationDown").css("display", "");
		        	 }else{
		        		 $("#dealConfirmationDown").attr("href", "");
		        		 $("#dealConfirmationDown").css("display", "none");
		        	 }
		        	 
					 if(dataContent.dealStatement != null && dataContent.dealStatement != ""){
						 $("#dealStatementDown").attr("href", dataContent.dealStatement);
		        		 $("#dealStatementDown").css("display", "");
		        	 }else{
		        		 $("#dealStatementDown").attr("href", "");
		        		 $("#dealStatementDown").css("display", "none");
		        	 }
		        	 
					 if(dataContent.dealContract != null && dataContent.dealContract != ""){
						 $("#dealContractDown").attr("href", dataContent.dealContract);
		        		 $("#dealContractDown").css("display", "");
					 }else{
						 $("#dealContractDown").attr("href", "");
		        		 $("#dealContractDown").css("display", "none");
					 }
					 
					 if(dataContent.dealConditionCheck != null && dataContent.dealConditionCheck != ""){
						 $("#dealConditionCheckDown").attr("href", dataContent.dealConditionCheck);
		        		 $("#dealConditionCheckDown").css("display", "");
		        	 }else{
		        		 $("#dealConditionCheckDown").attr("href", "");
		        		 $("#dealConditionCheckDown").css("display", "none");
		        	 }

		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
	 		
	 	}
	 	
	 	//결제 내역 리스트
	 	function paymentList(dealSq) {
	 			 	   
	 	   let params = {
	 			dealSq : dealSq
	 	   }
	 	   
	 	   console.log(params);
	 	   
	 	   $("#paymentList").jsGrid({
	 		   locale:"ko",
	 	       height: "200px",
	 	       width: "100%",
	 	       inserting: false,
	 	       editing: false,
	 	       sorting: false,
	 	       paging: false,
	 	       autoload: true,
	 	       pageSize: 10,
	 	       gridview : true,
	 	       deleteConfirm: "정말 삭제 하시겠습니까?",
	 	       controller: {
	 	           loadData: function (filter) {
	 	        	   var d = $.Deferred();
	 	               $.ajax({
	 	      	    	 type: "post",
	 	    	    	 url: "/admin/payment/payDetailData",
	 	    	         data: params,
	 	    	         dataType: "json"
	 	    	      }).done(function(response) {
	 	    	   		 
	 	    	    	 console.log(response);
	 	    	    	  
	 	    	    	 d.resolve(response.data.detailInfo);
	 	    	    	
	 	    	    	 
	 	    	      });
	 	               return d.promise();
	 	           }
	 	       },
	 	       fields: [
	 	    	 
	 	    	{ name: "paymntSq",title:"결제_순번",type: "text" ,align:"center" },
// 	 	    	{ name: "paymntTypCd",title:"결제_유형_코드",type: "text" ,align:"center" },
	 	    	{ name: "paymntTypCdNm",title:"결제_유형_코드",type: "text" ,align:"center" },
	 	    	{ name: "mbrSq",title:"결제_회원_순번",type: "text" ,align:"center" },
	 	    	{ name: "dealSq",title:"거래_순번",type: "text" ,align:"center" },
	 	    	{ name: "dealTypCdNm",title:"거래_유형_코드",type: "text" ,align:"center" },
	 	    	{ name: "workSq",title:"작품_순번",type: "text" ,align:"center" },
	 	    	{ name: "artstSq",title:"작가_순번",type: "text" ,align:"center" },
	 	    	{ name: "cuponSq",title:"쿠폰_순번",type: "text" ,align:"center" },
	 	    	{ name: "paymntDivCdNm",title:"결제_구분_코드",type: "text" ,align:"center" },
	 	    	{ name: "paymntAmt",title:"최종_결제_금액",type: "text" ,align:"center" },
	 	    	{ name: "paymnt_feeAmt",title:"결제_거래_수수료",type: "text" ,align:"center" },
	 	    	{ name: "paymntDiscAmt",title:"결제_할인_금액",type: "text" ,align:"center" },
	 	    	{ name: "amount",title:"결제_금액",type: "text" ,align:"center" },
	 	    	{ name: "mbrRefNo",title:"결제_거래주문번호",type: "text" ,align:"center" },
	 	    	{ name: "refNo",title:"결제_거래_번호",type: "text" ,align:"center" },
	 	    	{ name: "authToken",title:"결제_거래_인증토큰",type: "text" ,align:"center" },
	 	    	{ name: "aid",title:"결제_준비_일련번호",type: "text" ,align:"center" },
	 	    	{ name: "goodsName",title:"결제_상품_명",type: "text" ,align:"center" },
	 	    	{ name: "paymethod",title:"결제_수단",type: "text" ,align:"center" },
	 	    	{ name: "tranDate",title:"결제_거래_일자",type: "text" ,align:"center" },
	 	    	{ name: "tranTime",title:"결제_거래_시각",type: "text" ,align:"center" },
	 	    	{ name: "applNo",title:"결제_신용카드_승인번호",type: "text" ,align:"center" },
	 	    	{ name: "cardNo",title:"결제_신용카드_번호",type: "text" ,align:"center" },
	 	    	{ name: "installment",title:"결제_신용카드_할부개월수",type: "text" ,align:"center" },
	 	    	{ name: "payType",title:"결제_신용카드_결제타입",type: "text" ,align:"center" },
	 	    	{ name: "issueCompanyNo",title:"결제_신용카드_발급사_코드",type: "text" ,align:"center" },
	 	    	{ name: "issueCompanyName",title:"결제_신용카드_발급사_이름",type: "text" ,align:"center" },
	 	    	{ name: "issueCardName",title:"결제_신용카드_카드사_이름",type: "text" ,align:"center" },
	 	    	{ name: "acqCompanyNo",title:"결제_신용카드_매입사_코드",type: "text" ,align:"center" },
	 	    	{ name: "acqCompanyName",title:"결제_신용카드_매입사_이름",type: "text" ,align:"center" },
	 	    	{ name: "bankCode",title:"결제_계좌이체(가상계좌)_은행사_코드",type: "text" ,align:"center" },
	 	    	{ name: "accountNo",title:"결제_가상계좌_번호",type: "text" ,align:"center" },
	 	    	{ name: "accountCloseDate",title:"결제_가상계좌_입금_마감일",type: "text" ,align:"center" },
	 	    	{ name: "taxAmount",title:"결제_메인페이_세금_금액",type: "text" ,align:"center" },
	 	    	{ name: "feeAmount",title:"결제_메인페이_수수료_금액",type: "text" ,align:"center" },
	 	    	 
	 	    	 
	 	       ]

	 	   });
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
	 	
	 	//판매자 정보
	 	function fn_sellMbr(mbrSq){

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
		        	 var mbrBankNm = dataContent.mbrBankNm				//은행코드
		        	 var mbrAccountNo = dataContent.mbrAccountNo		//은행계좌번호
		        	 $("#sellMbrNm").html(mbrNm);
					 $("#sellMbrCpNum").html(mbrCpNum);
					 $("#sellMbrEmail").html(mbrEmail);
					 $("#sellMbrHomeAddr").html(mbrHomeAddr);
					 $("#sellMbrDelivryAddr").html(mbrDelivryAddr);
					 $("#sellMbrBankNm").html(mbrBankNm);
					 $("#sellMbrAccountNo").html(mbrAccountNo);
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
	 	}
	 	
	 	//구매자 정보
	  	function fn_buyMbr(mbrSq){

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
		        	 var mbrBankNm = dataContent.mbrBankNm				//은행코드
		        	 var mbrAccountNo = dataContent.mbrAccountNo		//은행계좌번호
		        	 
		        	 $("#buyMbrNm").html(mbrNm);
					 $("#buyMbrCpNum").html(mbrCpNum);
					 $("#buyMbrEmail").html(mbrEmail);
					 $("#buyMbrHomeAddr").html(mbrHomeAddr);
					 $("#buyMbrDelivryAddr").html(mbrDelivryAddr);
					 $("#buyMbrBankNm").html(mbrBankNm);
					 $("#buyMbrAccountNo").html(mbrAccountNo);
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
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
		        	 
		        	 var workNm = dataContent.workNm;
		        	 $("#workNm").html(workNm);
		        	 
		        	 var workProdcYear = dataContent.workProdcYear;
		        	 $("#workProdcYear").html(workProdcYear);
		        	 
		        	 var workPrc = dataContent.workPrc;
		        	 $("#workPrc").html(workPrc);
		           }
		        	
			})
	     }
		
	  	//거래 메인 - 거래 상태 수정
	  	function dealMainSttsCdUpdate(dealSq	,dealCode	,gubun){
	  		var msg = '상태를 수정하시겠습니까?';
	  		if(gubun == 'buy') {
	  			alert("결제진행상태 변경 불가!");
	  			return false;
	  			var params = {
	  			   dealSq : dealSq,
	  			   buyPaymntSttsCd : dealCode	
	  			}
	  		
	  		} else if(gubun == 'sell') {
	  			alert("결제진행상태 변경 불가!");
	  			return false;
	  			var params = {
	 	  			dealSq : dealSq,
	 	  			sellPaymntSttsCd : dealCode	
	 	  		}
	  		
	  		} else if(gubun == 'deal') {
	  			
	  			var params = {
	 	  			dealSq : dealSq,
	 		  	    dealSttsCd : dealCode	
	 	  		}
	  			
	  		}
	  		if(dealSttsCd == 'PC'){
	  			alert("구매 확정된 거래는 수정할 수 없습니다.");
	  			$("input[name='dealSttsCd'][value='PC']").prop("checked", true);
	  			return false;
	  		}
	  		if(dealSttsCd != 'DC' && dealCode == 'PC'){
	  			alert("배송완료된 거래만 구매확정으로 변경할 수 있습니다.");
	  			$("input[name='dealSttsCd'][value='DC']").prop("checked", true);
	  			return false;
	  		}
	  		if(dealCode == 'PC'){
	  			msg = '구매 확정으로 상태 수정하면 되돌릴 수 없습니다.\n상태를 수정하시겠습니까?'
	  		}
	  		console.log(params);
	  		
	  		if(confirm(msg)) {
	  			
	  			 $.ajax({
	  	           type: "post",
	  	           url: "/admin/payment/dealMainSttsCdUpdateData",
	  	           data: params,
	  	           success: function(data) {
	  	        	 bootbox.alert({
						 message: "거래상태가 수정되었습니다.",
						 locale: 'kr',
						 callback: function() {
						
					     } });
	  			   },
	  	           error: function(error) {
	  	        	   var errorJson = JSON.stringify(error);
	  	               console.log(errorJson);
	  	           }
	  			})	
	  		}else{
	  			
	  		   workMainContent(dealSq);	
	 		   return false;
	 		   
	 	    }
	  		
	  		
	  	}
	  	
	  	//거래 메인 - 메모수정
	  	function dealMainMemoUpdateData() {
	  		var dealSq = '<%=dealSq%>';
	  		var dealMemo = $('#dealMemo').val();
	  		
	  		if(dealMemo == ""){
	  			alert("내용을 입력해 주세요!!");
	  			$('#dealMemo').focus();
	  			return;
	  		} else {
	  			 $.ajax({
		  	           type: "post",
		  	           url: "/admin/payment/dealMainMemoUpdateData",
		  	           data: {
		  	        	 dealSq : dealSq,
		  	        	dealMemo : dealMemo
		  	        },
		  	           success: function(data) {
		  	        	 bootbox.alert({
							 message: "결제 CS 메모 저장되었습니다.",
							 locale: 'kr',
							 callback: function() {
							
						     } });
		  			   },
		  	           error: function(error) {
		  	        	   var errorJson = JSON.stringify(error);
		  	               console.log(errorJson);
		  	           }
		  			})	
	  		}
	  		
	  	}
	  	
	  	
		//결제진행단계
		function workMainContent(dealSq) {
			
			$.ajax({
		           type: "post",
		           url: "/admin/payment/dealMainListData",
		           data: {
		        	   dealSq : dealSq
		            },
		           success: function(ref) {
		        	   
		        	    
		        	 dataContent = ref.data.dealInfo[0];
		        	 
		        	 dealSttsCd = dataContent.dealSttsCd;
		        	 sellPaymntSttsCd = dataContent.sellPaymntSttsCd;
		        	 buyPaymntSttsCd = dataContent.buyPaymntSttsCd;
		        	 
		        	 
		        	 $(".dealSttsCd").prop('checked' , false);
				     $(".dealSttsCd[value='"+dealSttsCd+"']").prop("checked", true);
				     
				     $(".sellPaymntSttsCd").prop('checked' , false);
				     $(".sellPaymntSttsCd[value='"+sellPaymntSttsCd+"']").prop("checked", true);
				     
				     $(".buyPaymntSttsCd").prop('checked' , false);
				     $(".buyPaymntSttsCd[value='"+buyPaymntSttsCd+"']").prop("checked", true);
		        	 
		        	 var dealMemo = dataContent.dealMemo;
		        	 $('#dealMemo').val(dealMemo);
		        	 
		        	 //발주서 엑셀 다운로드 버튼 활성화 / 비활성화
		        	 if(sellPaymntSttsCd != "2PC" && buyPaymntSttsCd != "2PC"){
		        		 $("#btn_orderFormDown").css("display", "none");
		        	 }else{
		        		 $("#btn_orderFormDown").css("display", "");
		        	 }
		        	 
		        	 
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		 }
			
		function orderFormExcelDown(){
			var param = {
					dealSq : $("#dealSq").val(),
					workSq : $("#workSq").val(),
					sellMbrSq : $("#sellMbrSq").val(),
					buyMbrSq : $("#buyMbrSq").val(),
					artstSq : $("#artstSq").val()
			};
			$.ajax({
				url:"/oderFormDownload",
				type:"post",
				data: param,
				cache: false,
			    xhrFields: {
			        responseType: "blob",
			    },
				success: function (data, message, xhr) { 
					if (xhr.readyState == 4 && xhr.status == 200) {
						// 성공했을때만 파일 다운로드 처리하고
						let disposition = xhr.getResponseHeader('Content-Disposition'); 
						let filename; 
						if (disposition && disposition.indexOf('attachment') !== -1) { 
							let filenameRegex = /filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/; 
							let matches = filenameRegex.exec(disposition); 
							if (matches != null && matches[1]){ 
								filename = decodeURI(matches[1].replace(/['"]/g, '')); 
							}
						}
						// for IE
				        if (window.navigator && window.navigator.msSaveOrOpenBlob) {
				            window.navigator.msSaveOrOpenBlob(data, filename);
				        } else {
				            var URL = window.URL || window.webkitURL;
				            var downloadUrl = URL.createObjectURL(data);

				            if (filename) {
				                var a = document.createElement("a");

				                // for safari
				                if (a.download === undefined) {
				                    window.location.href = downloadUrl;
				                } else {
				                    a.href = downloadUrl;
				                    a.download = filename;
				                    document.body.appendChild(a);
				                    a.click();
				                }
				            } else {
				                window.location.href = downloadUrl;
				            }
				        }
					}else{   
					    //실패했을때는 alert 메시지 출력
						alertPopup("다운로드에 실패하였습니다."); 
					} 
				}
			}); 
		}
		
		function dealFileUpload(){
			var result = new Object();
			result.dealSq = $("#dealSq").val();
			const formData = new FormData();
			
			//거래 확인서
			const dealConfirmation = document.getElementById("dealConfirmation");
			if(dealConfirmation.files[0] == null && $("#dealConfirmation").val() != null){
				result.dealConfirmation = $("#dealConfirmation").val();
			}else{
				if(dealConfirmation.files[0] != null){
					formData.append("dealConfirmation", dealConfirmation.files[0]);
				}
			}
			
			//거래 명세서
			const dealStatement = document.getElementById("dealStatement");
			if(dealStatement.files[0] == null && $("#dealStatement").val() != null){
				result.dealStatement = $("#dealStatement").val();
			}else{
				if(dealStatement.files[0] != null){
					formData.append("dealStatement", dealStatement.files[0]);
				}
			}
			
			//거래 계약서
			const dealContract = document.getElementById("dealContract");
			if(dealContract.files[0] == null && $("#dealContract").val() != null){
				result.dealContract = $("#dealContract").val();
			}else{
				if(dealContract.files[0] != null){
					formData.append("dealContract", dealContract.files[0]);
				}
			}
			
			//컨디션 체크 리포트
			const dealConditionCheck = document.getElementById("dealConditionCheck");
			if(dealConditionCheck.files[0] == null && $("#dealConditionCheck").val() != null){
				result.dealConditionCheck = $("#dealConditionCheck").val();
			}else{
				if(dealConditionCheck.files[0] != null){
					formData.append("dealConditionCheck", dealConditionCheck.files[0]);
				}
			}
			
			formData.append("param", new Blob([JSON.stringify(result)], {type: "application/json"}));
			
			 $.ajax({
	  	           type: "post",
	  	           url: "/admin/payment/dealFileUpload",
	  	           data: formData,
		  	       contentType : false,
		 	       processData : false,
	  	           success: function(data) {
	  	        	   if(data == "Success"){
	  	        		   alert("파일 업로드가 완료되었습니다.");
	  	        		   location.reload();
	  	        	   }else{
	  	        		 alert("파일 업로드를 실패하였습니다. 다시 시도해주세요.");
	  	        		   location.reload();
	  	        	   }
	  			   },
	  	           error: function(error) {
	  	        	   var errorJson = JSON.stringify(error);
	  	               console.log(errorJson);
	  	           }
	  		});
		}

	 </script>
 
 
</body>
</html>
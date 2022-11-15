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
 /* Chrome, Safari, Edge, Opera */
 input::-webkit-outer-spin-button,
 input::-webkit-inner-spin-button {
   -webkit-appearance: none;
   margin: 0;
 }

 /* Firefox */
 input[type=number] {
   -moz-appearance: textfield;
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
				 
				 <div id="div_sellTrnsprt" style="display:none;">
					 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
		             	<ul class="nav nav-pills">
			           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>판매자 운송서비스</b></a></li>
			            </ul>
					 </div>
					 <div class="card">
					 	<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
						 	<ul class="nav nav-pills">
				           		<li class="nav-item sTitle">판매자는 <b id="b_sellTrnsprtTypCd" style="color:red;">프리미엄 운송</b>을 선택했습니다.</li>
				            </ul>
				            <div id="div_sellPaymentRequest" style="display:none;">
				            	<b>결제 요청한 배송 서비스 목록</b>
           						<ul id="ul_sellPaymentRequest">
           						
           						</ul>
           						<button type="button" class="btn btn-info" onclick="sellTrnsprtDelete()">삭제</button>
				            </div>
				        </div>
				       	
					 	<table class="table table-bordered" style="font-size:11px;" id="tb_sellTrnsprtTypCd">
			                  <thead>                  
			                    <tr align="center" style="background-color:#efefef">
			                      <th colspan="4">운송 타입</th>
			                    </tr>
			                  <thead>  
			                  <tbody>
			                  	<tr align="center">
			                    	<td style="width:100px;">
			                    		<input type="radio" name="sellTrnsprtTypCd" id="cd1" value="MA"><br/>
			           	 				<label for="cd1"><span>프리미엄 운송(수도권)</span></label>
			                    	</td>
			                    	<td style="width:100px;">
			                    		<input type="radio" name="sellTrnsprtTypCd" id="cd2" value="NA"><br/>
			          					<label for="cd2"><span>프리미엄 운송(비수도권)</span></label>
			                    	</td>
			                    	<td style="width:100px;">
			                    		<input type="radio" name="sellTrnsprtTypCd" id="cd3" value="G"><br/>
			           					<label for="cd3"><span>일반 운송</span></label>
			                    	</td>
			                    	<td style="width:100px;">
			                    		 <input type="radio" name="sellTrnsprtTypCd" id="cd4" value="D"><br/>
			           					 <label for="cd4"><span>셀프 운송</span></label>
			                    	</td>
			                    </tr>
			                  </tbody>
			            </table>
			         </div>
			         
			         <div class="card" id="sellReqYtable" style="display:none;">
					 	<table class="table table-bordered" style="font-size:11px;">
			                  <thead>                  
			                    <tr align="center" style="background-color:#efefef">
			                   		<th>필수 서비스</th>
			                    	<th>가격</th>
			                    </tr>
			                  <thead>  
			                  <tbody id="sellReqYtbody">
			                  </tbody>
			         	</table>
					 </div>
					 
					 <div class="card" id="sellReqNtable" style="display:none;">
					 	<table class="table table-bordered" style="font-size:11px;">
			                  <thead>                  
			                    <tr align="center" style="background-color:#efefef">
			                    	<th>선택</th>
			                      	<th>부가 서비스</th>
			                      	<th>가격</th>
			                    </tr>
			                  <thead>  
			                  <tbody id="sellReqNtbody">
			                  </tbody>
			         	</table>
			         	<button type="button" class="btn btn-info" onclick="sellTrnsprtSave()">저장</button>
					 </div>
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
		                    		<span id="buyMbrBankNm"></span>
		                    	</td>
		                    	<td style="width:auto;">
		                    		<span id="buyMbrAccountNo"></span>
		                    	</td>	
		                    </tr>
		                  </tbody>
		                 </table>
				 	
	    		 </div>
	    		
	    		<div id="div_buyTrnsprt" style="display:none;">
					 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
		             	<ul class="nav nav-pills">
			           		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>구매자 운송서비스</b></a></li>
			            </ul>
					 </div>
					 <div class="card">
					 	<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
						 	<ul class="nav nav-pills">
				           		<li class="nav-item sTitle">구매자는 <b id="b_buyTrnsprtTypCd" style="color:red;">프리미엄 운송</b>을 선택했습니다.</li>
				            </ul>
				            <div id="div_buyPaymentRequest" style="display:none;">
				            	<b>결제 요청한 배송 서비스 목록</b>
           						<ul id="ul_buyPaymentRequest">
           						
           						</ul>
           						<button type="button" class="btn btn-info" onclick="buyTrnsprtDelete()">삭제</button>
				            </div>
				        </div>
					 	<table class="table table-bordered" style="font-size:11px;" id="tb_buyTrnsprtTypCd">
			                  <thead>                  
			                    <tr align="center" style="background-color:#efefef">
			                      <th colspan="4">운송 타입</th>
			                    </tr>
			                  <thead>  
			                  <tbody>
			                  	<tr align="center">
			                    	<td style="width:100px;">
			                    		<input type="radio" name="buyTrnsprtTypCd" id="cd5" value="MA"><br/>
			           	 				<label for="cd5"><span>프리미엄 운송(수도권)</span></label>
			                    	</td>
			                    	<td style="width:100px;">
			                    		<input type="radio" name="buyTrnsprtTypCd" id="cd6" value="NA"><br/>
			          					<label for="cd6"><span>프리미엄 운송(비수도권)</span></label>
			                    	</td>
			                    	<td style="width:100px;">
			                    		<input type="radio" name="buyTrnsprtTypCd" id="cd7" value="G"><br/>
			           					<label for="cd7"><span>일반 운송</span></label>
			                    	</td>
			                    	<td style="width:100px;">
			                    		 <input type="radio" name="buyTrnsprtTypCd" id="cd8" value="D"><br/>
			           					 <label for="cd8"><span>셀프 운송</span></label>
			                    	</td>
			                    </tr>
			                  </tbody>
			            </table>
			         </div>
			         
			         <div class="card" id="buyReqYtable" style="display:none;">
					 	<table class="table table-bordered" style="font-size:11px;">
			                  <thead>                  
			                    <tr align="center" style="background-color:#efefef">
			                   		<th>필수 서비스</th>
			                    	<th>가격</th>
			                    </tr>
			                  <thead>  
			                  <tbody id="buyReqYtbody">
			                  </tbody>
			         	</table>
					 </div>
					 
					 <div class="card" id="buyReqNtable" style="display:none;">
					 	<table class="table table-bordered" style="font-size:11px;">
			                  <thead>                  
			                    <tr align="center" style="background-color:#efefef">
			                    	<th>선택</th>
			                      	<th>부가 서비스</th>
			                      	<th>가격</th>
			                    </tr>
			                  <thead>  
			                  <tbody id="buyReqNtbody">
			                  </tbody>
			         	</table>
			         	<button type="button" class="btn btn-info" onclick="buyTrnsprtSave()">저장</button>
					 </div>
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
		                    		<th>거래명세서<b style="color:red;">(구매자 1차)</b></th>
		                    		<th>거래명세서<b style="color:red;">(구매자 2차)</b></th>
		                    		<th>거래명세서<b style="color:red;">(판매자)</b></th>
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
			    		  				<br/><button type="button" class="btn btn-info sTitle" style="display:none;" id="dealConfirmationDelete" onclick="dealConfirmationDelete()">삭제</button>
			    		  			</td>
			    		  			<td>
			    		  				<input type="file" id="dealStatementB1">
			    		  				<br/><a href="" id="dealStatementB1Down" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
			    		  				<br/><button type="button" class="btn btn-info sTitle" style="display:none;" id="dealStatementB1Delete" onclick="dealStatementB1Delete()">삭제</button>
			    		  			</td>
			    		  			<td>
			    		  				<input type="file" id="dealStatementB2">
			    		  				<br/><a href="" id="dealStatementB2Down" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
			    		  				<br/><button type="button" class="btn btn-info sTitle" style="display:none;" id="dealStatementB2Delete" onclick="dealStatementB2Delete()">삭제</button>
			    		  			</td>
			    		  			<td>
			    		  				<input type="file" id="dealStatementS">
			    		  				<br/><a href="" id="dealStatementSDown" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
			    		  				<br/><button type="button" class="btn btn-info sTitle" style="display:none;" id="dealStatementSDelete" onclick="dealStatementSDelete()">삭제</button>
			    		  			</td>
			    		  			<td>
			    		  				<input type="file" id="dealContract">
			    		  				<br/><a href="" id="dealContractDown" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
			    		  				<br/><button type="button" class="btn btn-info sTitle" style="display:none;" id="dealContractDelete" onclick="dealContractDelete()">삭제</button>
			    		  			</td>
			    		  			<td>
			    		  				<input type="file" id="dealConditionCheck">
			    		  				<br/><a href="" id="dealConditionCheckDown" target="_blank" style="display:none;"><b>DOWNLOAD</b></a> 
			    		  				<br/><button type="button" class="btn btn-info sTitle" style="display:none;" id="dealConditionCheckDelete" onclick="dealConditionCheckDelete()">삭제</button>
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
	  	var sellTrnsprtInfo = new Array(); //판매자 겔제요청 배송 부가서비스 목록
	  	var sellReqYresult = new Object(); //판매자 필수 부가서비스 목록
	  	var sellReqNresult = new Object(); //판매자 선택 부가서비스 목록
	  	var buyTrnsprtInfo = new Array(); //구매자 겔제요청 배송 부가서비스 목록
	  	var buyReqYresult = new Object(); //구매자 필수 부가서비스 목록
	  	var buyReqNresult = new Object(); //구매자 선택 부가서비스 목록
	  	
	 	$(document).ready(function(){
	 		
	 		var dealSq = $("#dealSq").val();
	 		
	 		fn_dealMainContent(dealSq);
			
	 		//작품 거래 내역
	 		//fn_workDealh(dealSq);
	 		
	    });
	 	
	 	function comma(obj){
	 		obj.value = obj.value.replace(/[^0-9]/g,'');   // 입력값이 숫자가 아니면 공백
	 		obj.value = obj.value.replace(/,/g,'');        // ,값 공백처리
	 	    obj.value = obj.value.replace(/\B(?=(\d{3})+(?!\d))/g, ","); // 정규식을 이용해서 3자리 마다 , 추가 	
	 	}
	 	//배송 서비스 정보 조회
	 	function trnsprtInfo(dealSq){
	 		$.ajax({
	            type: "post",
	           	url: "/admin/payment/trnsprtInfo",
	           	data: {
	           		dealSq : dealSq
	           	},
	           	success: function(data) {
	           		var trnsprtInfo = data.result;
	           		var sHtml = '';
	           		var bHtml = '';
	           		if(trnsprtInfo.length > 0){
           				//bHtml += '<b>결제 요청한 배송 서비스 목록</b>';
           				//bHtml += '<ul>';
	           			for(var i=0; i<trnsprtInfo.length; i++){
		           			if(trnsprtInfo[i].trnsprtDivCd == "S"){
	           					if(trnsprtInfo[i].trnsprtPrc != null && trnsprtInfo[i].trnsprtPrc != ""){ //가격이 빈 값이 아니면
	           						if(trnsprtInfo[i].trnsprtAreaCdNm != null && trnsprtInfo[i].trnsprtAreaCdNm != ""){ //운송 부가서비스 지역이 빈 값이 아니면
	           							sHtml += '	<li class="nav-item sTitle"><b style="color:red;">'+trnsprtInfo[i].trnsprtTypCdNm+'('+trnsprtInfo[i].trnsprtAreaCdNm+')</b>/ ';
	           						}else{ //빈 값이면
	           							sHtml += '	<li class="nav-item sTitle"><b style="color:red;">'+trnsprtInfo[i].trnsprtTypCdNm+'</b>/ ';
	           						}
		           					sHtml += trnsprtInfo[i].trnsprtServiceCdNm+'('+trnsprtInfo[i].trnsprtPrc+')</li>';
		           					trnsprtInfo[i].trnsprtPrc = trnsprtInfo[i].trnsprtPrc.replaceAll(/,/g, '');
	           					}else{ //가격이 빈값이면
	           						sHtml += '	<li class="nav-item sTitle"><b style="color:red;">'+trnsprtInfo[i].trnsprtTypCdNm+'</b>/ ';
		           					sHtml += trnsprtInfo[i].trnsprtServiceCdNm+'(무료)</li>';
	           					}
		           				sellTrnsprtInfo.push(trnsprtInfo[i]);
		           			}else if(trnsprtInfo[i].trnsprtDivCd == "B"){
		           				if(trnsprtInfo[i].trnsprtPrc != null && trnsprtInfo[i].trnsprtPrc != ""){ //가격이 빈 값이 아니면
		           					if(trnsprtInfo[i].trnsprtAreaCdNm != null && trnsprtInfo[i].trnsprtAreaCdNm != ""){ //운송 부가서비스 지역이 빈 값이 아니면
		           						bHtml += '	<li class="nav-item sTitle"><b style="color:red;">'+trnsprtInfo[i].trnsprtTypCdNm+'('+trnsprtInfo[i].trnsprtAreaCdNm+')</b>/ ';
		           					}else{ //빈 값이면
		           						bHtml += '	<li class="nav-item sTitle"><b style="color:red;">'+trnsprtInfo[i].trnsprtTypCdNm+'</b>/ ';
		           					}
			           				bHtml += trnsprtInfo[i].trnsprtServiceCdNm+'('+trnsprtInfo[i].trnsprtPrc+')</li>';
			           				trnsprtInfo[i].trnsprtPrc = trnsprtInfo[i].trnsprtPrc.replaceAll(/,/g, '');
		           				}else{ //가격이 빈값이면
		           					bHtml += '	<li class="nav-item sTitle"><b style="color:red;">'+trnsprtInfo[i].trnsprtTypCdNm+'</b>/ ';
		           					bHtml += trnsprtInfo[i].trnsprtServiceCdNm+'(무료)</li>';
		           				}
		           				buyTrnsprtInfo.push(trnsprtInfo[i]);
		           			}
		           		}
	           			//sHtml += '</ul>';
	           			//bHtml += '</ul>';
	           		}
	           		if(sHtml != null && sHtml != ""){
	           			$("#tb_sellTrnsprtTypCd").css("display", "none");
	           			$("#div_sellPaymentRequest").css("display", "");
	           			$("#ul_sellPaymentRequest").append(sHtml).trigger("create");
	           		}
	           		if(bHtml != null && bHtml != ""){
	           			$("#tb_buyTrnsprtTypCd").css("display", "none");
	           			$("#div_buyPaymentRequest").css("display", "");
	           			$("#ul_buyPaymentRequest").append(bHtml).trigger("create");
	           		}
	           	},
	           	error: function(error){
	        		var errorJson = JSON.stringify(error);
	            	console.log(errorJson);
	           	}
	 		});
	 	}
	 	//판매자 배송 서비스 삭제
	 	function sellTrnsprtDelete(){
	 		if (confirm("결제요청한 판매자 배송 부가서비스 목록이 전체 삭제됩니다.\n삭제 하시겠습니까?")) {
	 			var param = new Object();
				param.trnsprtInfo = sellTrnsprtInfo;
				param.dealSq = $("#dealSq").val();
				param.buyMbrSq = $("#buyMbrSq").val();
				param.sellMbrSq = $("#sellMbrSq").val();
				param.artstSq = $("#artstSq").val();
				$.ajax({
					type: "POST",
					contentType: "application/json",
			        url: "/admin/payment/deleteTrnsprt",
			        data: JSON.stringify(param),
			        async: false,
					success:function(data){
						if(data > 0){
							alert("결제 요청한 판매자 배송 서비스가 삭제되었습니다.");
							location.reload();
						}else{
							alert("삭제에 실패했습니다. 새로고침 후 다시 시도해주세요.");
						}
					},
					error: function(error) {
			            alert("오류 발생" + error);
			        }
				});
	 	    }
	 	}
	 	//구매자 배송 서비스 삭제
	 	function buyTrnsprtDelete(){
	 		if (confirm("결제요청한 구매자 배송 부가서비스 목록이 전체 삭제됩니다.\n삭제 하시겠습니까?")) {
	 			var param = new Object();
				param.trnsprtInfo = buyTrnsprtInfo;
				param.dealSq = $("#dealSq").val();
				param.buyMbrSq = $("#buyMbrSq").val();
				param.sellMbrSq = $("#sellMbrSq").val();
				param.artstSq = $("#artstSq").val();
				$.ajax({
					type: "POST",
					contentType: "application/json",
			        url: "/admin/payment/deleteTrnsprt",
			        data: JSON.stringify(param),
			        async: false,
					success:function(data){
						if(data > 0){
							alert("결제 요청한 구매자 배송 서비스가 삭제되었습니다.");
							location.reload();
						}else{
							alert("삭제에 실패했습니다. 새로고침 후 다시 시도해주세요.");
						}
					},
					error: function(error) {
			            alert("오류 발생" + error);
			        }
				});
	 	    }
	 	}
	 	//판매자 배송서비스 라디오 선택 시
	 	$("input[name='sellTrnsprtTypCd']").change(function(){
	 		
	 		var param = new Object();
	 		param.trnsprtDivCd = "S";
	 		var cd = $("input[name='sellTrnsprtTypCd']:checked").val();
	 		
	 		if(cd == "MA" || cd == "NA"){
	 			param.trnsprtTypCd = "P";
	 			param.trnsprtAreaCd = cd;
	 		}else{
	 			param.trnsprtTypCd = cd;
	 		}
	 		
	 		$.ajax({
		    	type: "post",
		        url: "/admin/payment/selectTrnsprtPrcMtrx",
		        dataType: 'json',
		        contentType: 'application/json',
		        async: false,
		        data: JSON.stringify(param),
		        success: function(data) {
		        	sellReqYresult = data.reqYresult; //필수 부가서비스 목록
		        	sellReqNresult = data.reqNresult; //선택 부가서비스 목록
		        	var reqYhtml = '';
		        	var reqNhtml = '';
		        	if(param.trnsprtTypCd == "P"){
		        		//필수 부가서비스 프리미엄 운송
		        		for(var i=0; i<sellReqYresult.length; i++){
				        	
				        	reqYhtml += '<tr align="center">';
			                reqYhtml += '	<td style="width:50%;">';
			                reqYhtml += sellReqYresult[i].trnsprtServiceCdNm;
			                reqYhtml += '	</td>';
			                reqYhtml += '	<td style="width:50%;">';
			                reqYhtml += sellReqYresult[i].trnsprtPrc;
			                reqYhtml += '	</td>';
			                reqYhtml += '</tr>';
		        		}
		        		//선택 부가서비스 프리미엄 운송
		        		for(var i=0; i<sellReqNresult.length; i++){
			        		reqNhtml += '<tr align="center">';
			        		reqNhtml += '	<td>';
			        		reqNhtml += '		<input type="checkbox" name="sellTrnsprtServiceCd" value="'+sellReqNresult[i].trnsprtServiceCd+'" index="'+i+'" onclick="sellTrnsprtServiceCd_chk_onClick(this)">';
			        		reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
					        reqNhtml += sellReqNresult[i].trnsprtServiceCdNm;
				        	reqNhtml += '	</select>';
				        	reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
				        	if(sellReqNresult[i].trnsprtPrc != null && sellReqNresult[i].trnsprtPrc != ""){
				        		reqNhtml += sellReqNresult[i].trnsprtPrc;
				        	}else{
				        		reqNhtml += '<input type="text" id="sellTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
				        	}
				        	reqNhtml += '	</td>';
				        	reqNhtml += '</tr>';
		        		}
		        	}
		        	//일반운송
		        	if(param.trnsprtTypCd == "G"){
		        		//필수 부가서비스 일반운송
		        		reqYhtml += '<tr align="center">';
		                reqYhtml += '	<td style="width:50%;">';
		                reqYhtml += '	<select id="sellTrnsprtAreaCd" style="text-align:center;" onchange="sellTrnsprtAreaCd_onchange()">';
		        		for(var i=0; i<sellReqYresult.length; i++){
				        	if(sellReqYresult[i].trnsprtReqYn == "Y"){
				                reqYhtml += '		<option value="'+sellReqYresult[i].trnsprtAreaCd+'">'+sellReqYresult[i].trnsprtAreaCdNm+'</option>';
				        	}
		        		}
		        		reqYhtml += '	</select>';
		        		reqYhtml += sellReqYresult[0].trnsprtServiceCdNm;
		                reqYhtml += '	</td>';
		                reqYhtml += '	<td style="width:50%;">';
		                reqYhtml += '	<input type="text" id="g_sellTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
		                reqYhtml += '	</td>';
		                reqYhtml += '</tr>';
		              	//선택 부가서비스 일반 운송
		                for(var i=0; i<sellReqNresult.length; i++){
			        		reqNhtml += '<tr align="center">';
			        		reqNhtml += '	<td>';
			        		reqNhtml += '		<input type="checkbox" name="sellTrnsprtServiceCd" value="'+sellReqNresult[i].trnsprtServiceCd+'" index="'+i+'" onclick="sellTrnsprtServiceCd_chk_onClick(this)">';
			        		reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
					        reqNhtml += sellReqNresult[i].trnsprtServiceCdNm;
				        	reqNhtml += '	</select>';
				        	reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
				        	if(sellReqNresult[i].trnsprtPrc != null && sellReqNresult[i].trnsprtPrc != ""){
				        		reqNhtml += sellReqNresult[i].trnsprtPrc;
				        	}else{
				        		reqNhtml += '<input type="text" id="sellTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
				        	}
				        	reqNhtml += '	</td>';
				        	reqNhtml += '</tr>';
		        		}
		        	}
		        	//셀프운송
		        	if(param.trnsprtTypCd == "D"){
		        		//선택 부가서비스 셀프 운송
		        		for(var i=0; i<sellReqNresult.length; i++){
			        		reqNhtml += '<tr align="center">';
			        		reqNhtml += '	<td>';
			        		reqNhtml += '		<input type="checkbox" name="sellTrnsprtServiceCd" value="'+sellReqNresult[i].trnsprtServiceCd+'" index="'+i+'" onclick="sellTrnsprtServiceCd_chk_onClick(this)">';
			        		reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
					        reqNhtml += sellReqNresult[i].trnsprtServiceCdNm;
				        	reqNhtml += '	</select>';
				        	reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
				        	if(sellReqNresult[i].trnsprtPrc != null && sellReqNresult[i].trnsprtPrc != ""){
				        		reqNhtml += sellReqNresult[i].trnsprtPrc;
				        	}else{
				        		reqNhtml += '<input type="text" id="sellTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
				        	}
				        	reqNhtml += '	</td>';
				        	reqNhtml += '</tr>';
		        		}
		        	}
		        	if(reqYhtml != null && reqYhtml != ""){
		        		$("#sellReqYtbody").empty();
		                $("#sellReqYtbody").append(reqYhtml).trigger("create");
		                $("#sellReqYtable").css("display", "");
		        	}else{
		        		$("#sellReqYtbody").empty();
		        		$("#sellReqYtable").css("display", "none");
		        	}
	                $("#sellReqNtbody").empty();
	                $("#sellReqNtbody").append(reqNhtml).trigger("create");
	                $("#sellReqNtable").css("display", "");
		        	
		        },
		        error: function(error) {
		        	console.log(error);
		        }
			});
	 	});
	 	//판매자 선택 부가서비스 radio 선택시
	 	function sellTrnsprtServiceCd_chk_onClick(obj){
	 		var trnsprtServiceCd = obj.value; //현재 체크된 값을 가져온다
	 		var index = obj.attributes.index.value;  //현재 체크된 값의 인덱스를 가져온다
	 		document.querySelectorAll('input[name=sellTrnsprtServiceCd]').forEach((el) => {
				if(el.value == trnsprtServiceCd && el.attributes.index.value != index){ //체크되어있던 값과 체크한 값이 같으면서 인덱스가 다른 것만 체크를 해제한다
					el.checked = false;
				}
			});
	 	}
	 	//판매자 운송서비스 저장 버튼 클릭시
	 	function sellTrnsprtSave(){
	 		var checkResult = "N"; //필수 입력값 체크
	 		var sellReqYTrnsprt = new Array(); //DB에 저장할 필수 부가서비스 리스트를 만든다
	 		var sellReqNTrnsprt = new Array(); //DB에 저장할 선택 부가서비스 리스트를 만든다
	 		
	 		//필수 부가서비스 필수값 체크 및 리스트 저장
	 		var cd = $("input[name='sellTrnsprtTypCd']:checked").val();
	 		if(cd == "G"){ //일반 운송이면 운송비 입력 되있는지 체크한다
	 			
	 			if($("#g_sellTrnsprtPrc").val() != null && $("#g_sellTrnsprtPrc").val() != "" && $("#g_sellTrnsprtPrc").val() != undefined){ //운송비가 빈 값이 아니면
	 				var returnValue = sellReqYresult.find(function(el){ return el.trnsprtAreaCd == $("#sellTrnsprtAreaCd").val()});
	 				returnValue.trnsprtPrc = $("#g_sellTrnsprtPrc").val().replaceAll(/,/g, '');
		 			sellReqYTrnsprt.push(returnValue);
		 			checkResult = "Y";
	 			}else{ //운송비가 빈값이면
	 				alert("필수 서비스 운송비를 입력하지 않았습니다!");
	 				$("#g_sellTrnsprtPrc").focus();
	 				checkResult = "N";
	 				return;
	 			}
	 			
	 		}else if(cd == "MA" || cd == "NA"){
	 			sellReqYresult.forEach((el) => {
	 				el.trnsprtPrc = el.trnsprtPrc.replaceAll(/,/g, '')
	 				sellReqYTrnsprt.push(el);
	 			});
	 			checkResult = "Y";
	 		}
	 		
	 		//선택 부가서비스 필수값 체크 및 리스트 저장
	 		var checkList = document.querySelectorAll('input[name=sellTrnsprtServiceCd]:checked'); //체크된 element를 가져온다
	 		checkList.forEach((el, i) => {
	 			var tr = checkList[i].parentElement.parentElement; //체크박스의 부모인 행을 찾는다
	 			var td = tr.children; //행의 셀을 찾는다
	 			var prc = td[2].innerText; //3번째 셀인 가격을 가져온다
	 			if(prc != null && prc != ""){ //가격이 빈 값이 아니면
	 				sellReqNresult[el.attributes.index.value].trnsprtPrc = sellReqNresult[el.attributes.index.value].trnsprtPrc.replaceAll(/,/g, ''); //가격에 콤마 제거
	 				sellReqNTrnsprt.push(sellReqNresult[el.attributes.index.value]); //체크박스로 선택한 부가서비스만 List에 담는다
	 			}else{ //가격이 빈 값이면
	 				if(td[2].children.sellTrnsprtPrc.value != null && td[2].children.sellTrnsprtPrc.value != "" && td[2].children.sellTrnsprtPrc.value != undefined){ //input에 입력된 값이 있으면
	 					var prc = td[2].children.sellTrnsprtPrc.value; //값을 가져온다
	 					sellReqNresult[el.attributes.index.value].trnsprtPrc = prc.replaceAll(/,/g, '');; //값을 선택 부가서비스 목록에 입력한다
	 					sellReqNTrnsprt.push(sellReqNresult[el.attributes.index.value]); //체크박스로 선택한 부가서비스를 List에 담는다
	 					checkResult = "Y";
	 				}else{ //입력된 값 없으면
	 					alert('"'+td[1].innerText+'"의 가격을 입력하지 않았습니다!'); //해당 부가서비스에 값을 입력하라는 alert를 띄운다
	 					td[2].children.sellTrnsprtPrc.focus();
	 					checkResult = "N";
	 				}
	 			}
	 		});
	 		if(cd == "MA" || cd == "NA" || cd == "G"){ //프리미엄 운송이나 일반 운송일 경우
	 			if(sellReqYTrnsprt.length > 0 && checkResult == "Y"){ //필수 부가서비스가 비어있는지 확인한다
		 			var param = new Object();
					param.trnsprtInfo = sellReqYTrnsprt.concat(sellReqNTrnsprt); //필수 부가서비스와 선택 부가서비스를 하나로 합친다
					param.dealSq = $("#dealSq").val();
					param.buyMbrSq = $("#buyMbrSq").val();
					param.sellMbrSq = $("#sellMbrSq").val();
					param.artstSq = $("#artstSq").val();
					$.ajax({
						type: "POST",
						contentType: "application/json",
				        url: "/insertTrnsprt",
				        data: JSON.stringify(param),
				        async: false,
						success:function(data){
							if(data > 0){
								alert("판매자 운송 부가서비스가 저장되었습니다.");
								location.reload();
							}else{
								alert("저장에 실패했습니다. 새로고침 후 다시 시도 해주세요.");
							}
						},
						error: function(error) {
				            alert("오류 발생" + error);
				        }
					});
		 		}
	 		}else if(cd == "D"){ //셀프 운송일 경우
	 			if(sellReqNTrnsprt.length > 0 && checkResult == "Y"){ //선택 부가서비스가 있으면
		 			var param = new Object();
					param.trnsprtInfo = sellReqYresult.concat(sellReqNTrnsprt); //필수 부가서비스와 선택 부가서비스를 하나로 합친다
					param.dealSq = $("#dealSq").val();
					param.buyMbrSq = $("#buyMbrSq").val();
					param.sellMbrSq = $("#sellMbrSq").val();
					param.artstSq = $("#artstSq").val();
					$.ajax({
						type: "POST",
						contentType: "application/json",
				        url: "/insertTrnsprt",
				        data: JSON.stringify(param),
				        async: false,
						success:function(data){
							if(data > 0){
								alert("판매자 운송 부가서비스가 저장되었습니다.");
								location.reload();
							}else{
								alert("저장에 실패했습니다. 새로고침 후 다시 시도 해주세요.");
							}
						},
						error: function(error) {
				            alert("오류 발생" + error);
				        }
					});
		 		}else{ //선택 부가서비스가 없는 셀프 운송이면
		 			var param = new Object();
					param.trnsprtInfo = sellReqYresult; //셀프 운송으로 넘겨준다
					param.dealSq = $("#dealSq").val();
					param.buyMbrSq = $("#buyMbrSq").val();
					param.sellMbrSq = $("#sellMbrSq").val();
					param.artstSq = $("#artstSq").val();
					$.ajax({
						type: "POST",
						contentType: "application/json",
				        url: "/insertTrnsprt",
				        data: JSON.stringify(param),
				        async: false,
						success:function(data){
							if(data > 0){
								alert("판매자 운송 부가서비스가 저장되었습니다.");
								location.reload();
							}else{
								alert("저장에 실패했습니다. 새로고침 후 다시 시도 해주세요.");
							}
						},
						error: function(error) {
				            alert("오류 발생" + error);
				        }
					});
		 		}
	 		}
	 	}
	 	//구매자 배송서비스 라디오 박스 선택 시
		$("input[name='buyTrnsprtTypCd']").change(function(){
	 		
	 		var param = new Object();
	 		param.trnsprtDivCd = "B";
	 		var cd = $("input[name='buyTrnsprtTypCd']:checked").val();
	 		
	 		if(cd == "MA" || cd == "NA"){
	 			param.trnsprtTypCd = "P";
	 			param.trnsprtAreaCd = cd;
	 		}else{
	 			param.trnsprtTypCd = cd;
	 		}
	 		
	 		$.ajax({
		    	type: "post",
		        url: "/admin/payment/selectTrnsprtPrcMtrx",
		        dataType: 'json',
		        contentType: 'application/json',
		        async: false,
		        data: JSON.stringify(param),
		        success: function(data) {
		        	buyReqYresult = data.reqYresult; //필수 부가서비스 목록
		        	buyReqNresult = data.reqNresult; //선택 부가서비스 목록
		        	var reqYhtml = '';
		        	var reqNhtml = '';
		        	if(param.trnsprtTypCd == "P"){
		        		//필수 부가서비스 프리미엄 운송
		        		for(var i=0; i<buyReqYresult.length; i++){
				        	
				        	reqYhtml += '<tr align="center">';
			                reqYhtml += '	<td style="width:50%;">';
			                reqYhtml += buyReqYresult[i].trnsprtServiceCdNm;
			                reqYhtml += '	</td>';
			                reqYhtml += '	<td style="width:50%;">';
			                reqYhtml += buyReqYresult[i].trnsprtPrc;
			                reqYhtml += '	</td>';
			                reqYhtml += '</tr>';
		        		}
		        		//선택 부가서비스 프리미엄 운송
		        		for(var i=0; i<buyReqNresult.length; i++){
			        		reqNhtml += '<tr align="center">';
			        		reqNhtml += '	<td>';
			        		reqNhtml += '		<input type="checkbox" name="buyTrnsprtServiceCd" value="'+buyReqNresult[i].trnsprtServiceCd+'" index="'+i+'" onclick="buyTrnsprtServiceCd_chk_onClick(this)">';
			        		reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
					        reqNhtml += buyReqNresult[i].trnsprtServiceCdNm;
				        	reqNhtml += '	</select>';
				        	reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
				        	if(buyReqNresult[i].trnsprtPrc != null && buyReqNresult[i].trnsprtPrc != ""){
				        		reqNhtml += buyReqNresult[i].trnsprtPrc;
				        	}else{
				        		reqNhtml += '<input type="text" id="buyTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
				        	}
				        	reqNhtml += '	</td>';
				        	reqNhtml += '</tr>';
		        		}
		        	}
		        	//일반운송
		        	if(param.trnsprtTypCd == "G"){
		        		//필수 부가서비스 일반운송
		        		reqYhtml += '<tr align="center">';
		                reqYhtml += '	<td style="width:50%;">';
		                reqYhtml += '	<select id="buyTrnsprtAreaCd" style="text-align:center;" onchange="buyTrnsprtAreaCd_onchange()">';
		        		for(var i=0; i<buyReqYresult.length; i++){
				        	if(buyReqYresult[i].trnsprtReqYn == "Y"){
				                reqYhtml += '		<option value="'+buyReqYresult[i].trnsprtAreaCd+'">'+buyReqYresult[i].trnsprtAreaCdNm+'</option>';
				        	}
		        		}
		        		reqYhtml += '	</select>';
		        		reqYhtml += buyReqYresult[0].trnsprtServiceCdNm;
		                reqYhtml += '	</td>';
		                reqYhtml += '	<td style="width:50%;">';
		                reqYhtml += '	<input type="text" id="g_buyTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
		                reqYhtml += '	</td>';
		                reqYhtml += '</tr>';
		              	//선택 부가서비스 일반 운송
		                for(var i=0; i<buyReqNresult.length; i++){
			        		reqNhtml += '<tr align="center">';
			        		reqNhtml += '	<td>';
			        		reqNhtml += '		<input type="checkbox" name="buyTrnsprtServiceCd" value="'+buyReqNresult[i].trnsprtServiceCd+'" index="'+i+'" onclick="buyTrnsprtServiceCd_chk_onClick(this)">';
			        		reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
					        reqNhtml += buyReqNresult[i].trnsprtServiceCdNm;
				        	reqNhtml += '	</select>';
				        	reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
				        	if(buyReqNresult[i].trnsprtPrc != null && buyReqNresult[i].trnsprtPrc != ""){
				        		reqNhtml += buyReqNresult[i].trnsprtPrc;
				        	}else{
				        		reqNhtml += '<input type="text" id="buyTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
				        	}
				        	reqNhtml += '	</td>';
				        	reqNhtml += '</tr>';
		        		}
		        	}
		        	//셀프운송
		        	if(param.trnsprtTypCd == "D"){
		        		//선택 부가서비스 셀프 운송
		        		for(var i=0; i<buyReqNresult.length; i++){
			        		reqNhtml += '<tr align="center">';
			        		reqNhtml += '	<td>';
			        		reqNhtml += '		<input type="checkbox" name="buyTrnsprtServiceCd" value="'+buyReqNresult[i].trnsprtServiceCd+'" index="'+i+'" onclick="buyTrnsprtServiceCd_chk_onClick(this)">';
			        		reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
					        reqNhtml += buyReqNresult[i].trnsprtServiceCdNm;
				        	reqNhtml += '	</select>';
				        	reqNhtml += '	</td>';
				        	reqNhtml += '	<td>';
				        	if(buyReqNresult[i].trnsprtPrc != null && buyReqNresult[i].trnsprtPrc != ""){
				        		reqNhtml += buyReqNresult[i].trnsprtPrc;
				        	}else{
				        		reqNhtml += '<input type="text" id="buyTrnsprtPrc" onkeyup="comma(this)" style="text-align:center;">';
				        	}
				        	reqNhtml += '	</td>';
				        	reqNhtml += '</tr>';
		        		}
		        	}
		        	if(reqYhtml != null && reqYhtml != ""){
		        		$("#buyReqYtbody").empty();
		                $("#buyReqYtbody").append(reqYhtml).trigger("create");
		                $("#buyReqYtable").css("display", "");
		        	}else{
		        		$("#buyReqYtbody").empty();
		        		$("#buyReqYtable").css("display", "none");
		        	}
	                $("#buyReqNtbody").empty();
	                $("#buyReqNtbody").append(reqNhtml).trigger("create");
	                $("#buyReqNtable").css("display", "");
		        	
		        },
		        error: function(error) {
		        	console.log(error);
		        }
			});
	 	});
	 	//구매자 선택 부가서비스 radio 선택시
	 	function buyTrnsprtServiceCd_chk_onClick(obj){
	 		var trnsprtServiceCd = obj.value; //현재 체크된 값을 가져온다
	 		var index = obj.attributes.index.value;  //현재 체크된 값의 인덱스를 가져온다
	 		document.querySelectorAll('input[name=buyTrnsprtServiceCd]').forEach((el) => {
				if(el.value == trnsprtServiceCd && el.attributes.index.value != index){ //체크되어있던 값과 체크한 값이 같으면서 인덱스가 다른 것만 체크를 해제한다
					el.checked = false;
				}
			});
	 	}
	 	//구매자 운송서비스 저장 버튼 클릭시
	 	function buyTrnsprtSave(){
	 		var checkResult = "N"; //필수 입력값 체크
	 		var buyReqYTrnsprt = new Array(); //DB에 저장할 필수 부가서비스 리스트를 만든다
	 		var buyReqNTrnsprt = new Array(); //DB에 저장할 선택 부가서비스 리스트를 만든다
	 		
	 		//필수 부가서비스 필수값 체크 및 리스트 저장
	 		var cd = $("input[name='buyTrnsprtTypCd']:checked").val();
	 		if(cd == "G"){ //일반 운송이면 운송비 입력 되있는지 체크한다
	 			
	 			if($("#g_buyTrnsprtPrc").val() != null && $("#g_buyTrnsprtPrc").val() != "" && $("#g_buyTrnsprtPrc").val() != undefined){ //운송비 input이 빈 값이 아니면
	 				var returnValue = buyReqYresult.find(function(el){ return el.trnsprtAreaCd == $("#buyTrnsprtAreaCd").val()});
	 				returnValue.trnsprtPrc = $("#g_buyTrnsprtPrc").val().replaceAll(/,/g, '');
		 			buyReqYTrnsprt.push(returnValue);
		 			checkResult = "Y";
	 			}else{ //운송비가 빈 값이면
	 				alert("필수 서비스 운송비를 입력하지 않았습니다!");
	 				$("#g_buyTrnsprtPrc").focus();
	 				checkResult = "N";
	 				return;
	 			}
	 			
	 		}else if(cd == "MA" || cd == "NA"){ //프리미엄 운송이면
	 			buyReqYresult.forEach((el) => {
	 				el.trnsprtPrc = el.trnsprtPrc.replaceAll(/,/g, ''); //가격에 콤마제거
	 				buyReqYTrnsprt.push(el);
	 			});
	 			checkResult = "Y";
	 		}
	 		
	 		//선택 부가서비스 필수값 체크 및 리스트 저장
	 		var checkList = document.querySelectorAll('input[name=buyTrnsprtServiceCd]:checked'); //체크된 element를 가져온다
	 		checkList.forEach((el, i) => {
	 			var tr = checkList[i].parentElement.parentElement; //체크박스의 부모인 행을 찾는다
	 			var td = tr.children; //행의 셀을 찾는다
	 			var prc = td[2].innerText; //3번째 셀인 가격을 가져온다
	 			if(prc != null && prc != ""){ //가격이 빈 값이 아니면
	 				buyReqNresult[el.attributes.index.value].trnsprtPrc = buyReqNresult[el.attributes.index.value].trnsprtPrc.replaceAll(/,/g, ''); //가격에 콤마 제거
	 				buyReqNTrnsprt.push(buyReqNresult[el.attributes.index.value]); //체크박스로 선택한 부가서비스만 List에 담는다
	 			}else{ //가격이 빈 값이면
	 				if(td[2].children.buyTrnsprtPrc.value != null && td[2].children.buyTrnsprtPrc.value != "" && td[2].children.buyTrnsprtPrc.value != undefined){ //input에 입력된 값이 있으면
	 					var prc = td[2].children.buyTrnsprtPrc.value; //값을 가져온다
	 					buyReqNresult[el.attributes.index.value].trnsprtPrc = prc.replaceAll(/,/g, ''); //값을 선택 부가서비스 목록에 입력한다
	 					buyReqNTrnsprt.push(buyReqNresult[el.attributes.index.value]); //체크박스로 선택한 부가서비스를 List에 담는다
	 					checkResult = "Y";
	 				}else{ //입력된 값 없으면
	 					alert('"'+td[1].innerText+'"의 가격을 입력하지 않았습니다!'); //해당 부가서비스에 값을 입력하라는 alert를 띄운다
	 					td[2].children.buyTrnsprtPrc.focus();
	 					checkResult = "N";
	 				}
	 			}
	 		});
	 		if(cd == "MA" || cd == "NA" || cd == "G"){ //프리미엄 운송이나 일반 운송일 경우
	 			if(buyReqYTrnsprt.length > 0 && checkResult == "Y"){ //필수 부가서비스가 비어있는지 확인한다
		 			var param = new Object();
					param.trnsprtInfo = buyReqYTrnsprt.concat(buyReqNTrnsprt); //필수 부가서비스와 선택 부가서비스를 하나로 합친다
					param.dealSq = $("#dealSq").val();
					param.buyMbrSq = $("#buyMbrSq").val();
					param.sellMbrSq = $("#sellMbrSq").val();
					param.artstSq = $("#artstSq").val();
					$.ajax({
						type: "POST",
						contentType: "application/json",
				        url: "/insertTrnsprt",
				        data: JSON.stringify(param),
				        async: false,
						success:function(data){
							if(data > 0){
								alert("구매자 운송 부가서비스가 저장되었습니다.");
								location.reload();
							}else{
								alert("저장에 실패했습니다. 새로고침 후 다시 시도 해주세요.");
							}
						},
						error: function(error) {
				            alert("오류 발생" + error);
				        }
					});
		 		}
	 		}else if(cd == "D"){ //셀프 운송일 경우
	 			if(buyReqNTrnsprt.length > 0 && checkResult == "Y"){ //선택 부가서비스가 있으면
		 			var param = new Object();
					param.trnsprtInfo = buyReqYresult.concat(buyReqNTrnsprt); //필수 부가서비스와 선택 부가서비스를 하나로 합친다
					param.dealSq = $("#dealSq").val();
					param.buyMbrSq = $("#buyMbrSq").val();
					param.sellMbrSq = $("#sellMbrSq").val();
					param.artstSq = $("#artstSq").val();
					$.ajax({
						type: "POST",
						contentType: "application/json",
				        url: "/insertTrnsprt",
				        data: JSON.stringify(param),
				        async: false,
						success:function(data){
							if(data > 0){
								alert("구매자 운송 부가서비스가 저장되었습니다.");
								location.reload();
							}else{
								alert("저장에 실패했습니다. 새로고침 후 다시 시도 해주세요.");
							}
						},
						error: function(error) {
				            alert("오류 발생" + error);
				        }
					});
		 		}else{ //선택 부가서비스가 없는 셀프 운송이면
		 			var param = new Object();
					param.trnsprtInfo = buyReqYresult; //셀프 운송으로 넘겨준다
					param.dealSq = $("#dealSq").val();
					param.buyMbrSq = $("#buyMbrSq").val();
					param.sellMbrSq = $("#sellMbrSq").val();
					param.artstSq = $("#artstSq").val();
					$.ajax({
						type: "POST",
						contentType: "application/json",
				        url: "/insertTrnsprt",
				        data: JSON.stringify(param),
				        async: false,
						success:function(data){
							if(data > 0){
								alert("구매자 운송 부가서비스가 저장되었습니다.");
								location.reload();
							}else{
								alert("저장에 실패했습니다. 새로고침 후 다시 시도 해주세요.");
							}
						},
						error: function(error) {
				            alert("오류 발생" + error);
				        }
					});
		 		}
	 		}
	 	}
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
	 		console.log("dealSq :"+dealSq);
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
		        	 
		        	 //배송 서비스 정보
		        	 trnsprtInfo(dealSq);
		        	 
		        	 $("#sellMbrSq").val(sellMbrSq);
		        	 $("#buyMbrSq").val(buyMbrSq);
		        	 $("#artstSq").val(artstSq);
		        	 $("#workSq").val(workSqNum);
		        	 
		        	 //거래 관련 파일 업로드 div
		        	 if(dealSttsCd == "TP" || dealSttsCd == "FB"){
		        		 $("#dealFileUpload").css("display", "none");
		        	 }else{
		        		 $("#dealFileUpload").css("display", "");
		        	 }
		        	 
		        	 if(dataContent.dealConfirmation != null && dataContent.dealConfirmation != ""){
		        		 $("#dealConfirmationDown").attr("href", dataContent.dealConfirmation);
		        		 $("#dealConfirmationDown").css("display", "");
		        		 $("#dealConfirmationDelete").css("display", "");
		        	 }else{
		        		 $("#dealConfirmationDown").attr("href", "");
		        		 $("#dealConfirmationDown").css("display", "none");
		        		 $("#dealConfirmationDelete").css("display", "none");
		        	 }
		        	 
					 if(dataContent.dealStatementB1 != null && dataContent.dealStatementB1 != ""){
						 $("#dealStatementB1Down").attr("href", dataContent.dealStatementB1);
		        		 $("#dealStatementB1Down").css("display", "");
		        		 $("#dealStatementB1Delete").css("display", "");
		        	 }else{
		        		 $("#dealStatementB1Down").attr("href", "");
		        		 $("#dealStatementB1Down").css("display", "none");
		        		 $("#dealStatementB1Delete").css("display", "none");
		        	 }
					 
					 if(dataContent.dealStatementB2 != null && dataContent.dealStatementB2 != ""){
						 $("#dealStatementB2Down").attr("href", dataContent.dealStatementB2);
		        		 $("#dealStatementB2Down").css("display", "");
		        		 $("#dealStatementB2Delete").css("display", "");
		        	 }else{
		        		 $("#dealStatementB2Down").attr("href", "");
		        		 $("#dealStatementB2Down").css("display", "none");
		        		 $("#dealStatementB2Delete").css("display", "none");
		        	 }
					 
					 if(dataContent.dealStatementS != null && dataContent.dealStatementS != ""){
						 $("#dealStatementSDown").attr("href", dataContent.dealStatementS);
		        		 $("#dealStatementSDown").css("display", "");
		        		 $("#dealStatementSDelete").css("display", "");
		        	 }else{
		        		 $("#dealStatementSDown").attr("href", "");
		        		 $("#dealStatementSDown").css("display", "none");
		        		 $("#dealStatementSDelete").css("display", "none");
		        	 }
		        	 
					 if(dataContent.dealContract != null && dataContent.dealContract != ""){
						 $("#dealContractDown").attr("href", dataContent.dealContract);
		        		 $("#dealContractDown").css("display", "");
		        		 $("#dealContractDelete").css("display", "");
					 }else{
						 $("#dealContractDown").attr("href", "");
		        		 $("#dealContractDown").css("display", "none");
		        		 $("#dealContractDelete").css("display", "none");
					 }
					 
					 if(dataContent.dealConditionCheck != null && dataContent.dealConditionCheck != ""){
						 $("#dealConditionCheckDown").attr("href", dataContent.dealConditionCheck);
		        		 $("#dealConditionCheckDown").css("display", "");
		        		 $("#dealConditionCheckDelete").css("display", "");
		        	 }else{
		        		 $("#dealConditionCheckDown").attr("href", "");
		        		 $("#dealConditionCheckDown").css("display", "none");
		        		 $("#dealConditionCheckDelete").css("display", "none");
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
	 		console.log("artstSq :"+artstSq);
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
		        	 if(dataContent.sellTrnsprtTypCd != null && dataContent.sellTrnsprtTypCd != "" && dataContent.sellTrnsprtTypCd != undefined){
		        		 var sellTrnsprtTypCd = dataContent.sellTrnsprtTypCd; //판매자 부가서비스 타입 코드
		        		 if(sellTrnsprtTypCd == "P"){ //프리미엄 운송이면
		        			 $("#b_sellTrnsprtTypCd").html("프리미엄 운송"); //프리니엄 운송 선택했다고 화면에 표시해준다.
		        		 }else if(sellTrnsprtTypCd == "G"){ //일반 운송
		        			 $("#b_sellTrnsprtTypCd").html("일반 운송"); //일반 운송 화면 표시
		        		 }else if(sellTrnsprtTypCd == "D"){ //셀프 운송
		        			 $("#b_sellTrnsprtTypCd").html("셀프 운송"); //셀프 운송 화면 표시
		        		 }
		        		 $("#div_sellTrnsprt").css("display", "");
		        	 }
		        	 if(dataContent.buyTrnsprtTypCd != null && dataContent.buyTrnsprtTypCd != "" && dataContent.buyTrnsprtTypCd != undefined){
		        		 var buyTrnsprtTypCd = dataContent.buyTrnsprtTypCd; //구매자 부가서비스 타입 코드
		        		 if(buyTrnsprtTypCd == "P"){
		        			 $("#b_buyTrnsprtTypCd").html("프리미엄 운송");
		        		 }else if(buyTrnsprtTypCd == "G"){
		        			 $("#b_buyTrnsprtTypCd").html("일반 운송");
		        		 }else if(buyTrnsprtTypCd == "D"){
		        			 $("#b_buyTrnsprtTypCd").html("셀프 운송");
		        		 }
		        		 $("#div_buyTrnsprt").css("display", "");
		        	 }
		        	 
		        	 
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
			
			//거래 명세서 구매자 1차
			const dealStatementB1 = document.getElementById("dealStatementB1");
			if(dealStatementB1.files[0] == null && $("#dealStatementB1").val() != null){
				result.dealStatementB1 = $("#dealStatementB1").val();
			}else{
				if(dealStatementB1.files[0] != null){
					formData.append("dealStatementB1", dealStatementB1.files[0]);
				}
			}
			
			//거래 명세서 구매자 1차
			const dealStatementB2 = document.getElementById("dealStatementB2");
			if(dealStatementB2.files[0] == null && $("#dealStatementB2").val() != null){
				result.dealStatementB2 = $("#dealStatementB2").val();
			}else{
				if(dealStatementB2.files[0] != null){
					formData.append("dealStatementB2", dealStatementB2.files[0]);
				}
			}
			
			//거래 명세서 판매자
			const dealStatementS = document.getElementById("dealStatementS");
			if(dealStatementS.files[0] == null && $("#dealStatementS").val() != null){
				result.dealStatementS = $("#dealStatementS").val();
			}else{
				if(dealStatementS.files[0] != null){
					formData.append("dealStatementS", dealStatementS.files[0]);
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
		
		function dealConfirmationDelete(){
			if(confirm("거래 확인서를 삭제하시겠습니까?")){
				var param = new Object();
				param.columnNm = "dealConfirmation";
				param.dealSq = $("#dealSq").val();
				$.ajax({
		  	           type: "post",
		  	           url: "/admin/payment/dealFileDelete",
		  	           data: param,
		  	           success: function(data) {
		  	        	   if(data == "Success"){
		  	        		   alert("거래 확인서가 삭제되었습니다.");
		  	        		   location.reload();
		  	        	   }else{
		  	        		 alert("거래 확인서 삭제에 실패했습니다. 다시 시도해주세요.");
		  	        		   location.reload();
		  	        	   }
		  			   },
		  	           error: function(error) {
		  	        	   var errorJson = JSON.stringify(error);
		  	               console.log(errorJson);
		  	           }
		  		});
		    }else{
		        return;
		    }
		}
		
		function dealStatementB1Delete(){
			if(confirm("거래 명세서(구매자 1차)를 삭제하시겠습니까?")){
				var param = new Object();
				param.columnNm = "dealStatementB1";
				param.dealSq = $("#dealSq").val();
				$.ajax({
		  	           type: "post",
		  	           url: "/admin/payment/dealFileDelete",
		  	           data: param,
		  	           success: function(data) {
		  	        	   if(data == "Success"){
		  	        		   alert("거래 명세서(구매자 1차)가 삭제되었습니다.");
		  	        		   location.reload();
		  	        	   }else{
		  	        		 alert("거래 명세서(구매자 1차) 삭제에 실패했습니다. 다시 시도해주세요.");
		  	        		   location.reload();
		  	        	   }
		  			   },
		  	           error: function(error) {
		  	        	   var errorJson = JSON.stringify(error);
		  	               console.log(errorJson);
		  	           }
		  		});
		    }else{
		        return;
		    }
		}
		
		function dealStatementB2Delete(){
			if(confirm("거래 명세서(구매자 2차)를 삭제하시겠습니까?")){
				var param = new Object();
				param.columnNm = "dealStatementB2";
				param.dealSq = $("#dealSq").val();
				$.ajax({
		  	           type: "post",
		  	           url: "/admin/payment/dealFileDelete",
		  	           data: param,
		  	           success: function(data) {
		  	        	   if(data == "Success"){
		  	        		   alert("거래 명세서(구매자 2차)가 삭제되었습니다.");
		  	        		   location.reload();
		  	        	   }else{
		  	        		 alert("거래 명세서(구매자 2차) 삭제에 실패했습니다. 다시 시도해주세요.");
		  	        		   location.reload();
		  	        	   }
		  			   },
		  	           error: function(error) {
		  	        	   var errorJson = JSON.stringify(error);
		  	               console.log(errorJson);
		  	           }
		  		});
		    }else{
		        return;
		    }
		}
		
		function dealStatementSDelete(){
			if(confirm("거래 명세서(판매자)를 삭제하시겠습니까?")){
				var param = new Object();
				param.columnNm = "dealStatementS";
				param.dealSq = $("#dealSq").val();
				$.ajax({
		  	           type: "post",
		  	           url: "/admin/payment/dealFileDelete",
		  	           data: param,
		  	           success: function(data) {
		  	        	   if(data == "Success"){
		  	        		   alert("거래 명세서(판매자)가 삭제되었습니다.");
		  	        		   location.reload();
		  	        	   }else{
		  	        		 alert("거래 명세서(판매자) 삭제에 실패했습니다. 다시 시도해주세요.");
		  	        		   location.reload();
		  	        	   }
		  			   },
		  	           error: function(error) {
		  	        	   var errorJson = JSON.stringify(error);
		  	               console.log(errorJson);
		  	           }
		  		});
		    }else{
		        return;
		    }
		}
		
		function dealContractDelete(){
			if(confirm("거래 계약서를 삭제하시겠습니까?")){
				var param = new Object();
				param.columnNm = "dealContract";
				param.dealSq = $("#dealSq").val();
				$.ajax({
		  	           type: "post",
		  	           url: "/admin/payment/dealFileDelete",
		  	           data: param,
		  	           success: function(data) {
		  	        	   if(data == "Success"){
		  	        		   alert("거래 확인서가 삭제되었습니다.");
		  	        		   location.reload();
		  	        	   }else{
		  	        		 alert("거래 확인서 삭제에 실패했습니다. 다시 시도해주세요.");
		  	        		   location.reload();
		  	        	   }
		  			   },
		  	           error: function(error) {
		  	        	   var errorJson = JSON.stringify(error);
		  	               console.log(errorJson);
		  	           }
		  		});
		    }else{
		        return;
		    }
		}
		
		function dealConditionCheckDelete(){
			if(confirm("컨디션 체크 리포트를 삭제하시겠습니까?")){
				var param = new Object();
				param.columnNm = "dealConditionCheck";
				param.dealSq = $("#dealSq").val();
				$.ajax({
		  	           type: "post",
		  	           url: "/admin/payment/dealFileDelete",
		  	           data: param,
		  	           success: function(data) {
		  	        	   if(data == "Success"){
		  	        		   alert("컨디션 체크 리포트가 삭제되었습니다.");
		  	        		   location.reload();
		  	        	   }else{
		  	        		 alert("컨디션 체크 리포트 삭제에 실패했습니다. 다시 시도해주세요.");
		  	        		   location.reload();
		  	        	   }
		  			   },
		  	           error: function(error) {
		  	        	   var errorJson = JSON.stringify(error);
		  	               console.log(errorJson);
		  	           }
		  		});
		    }else{
		        return;
		    }
		}

	 </script>
 
 
</body>
</html>
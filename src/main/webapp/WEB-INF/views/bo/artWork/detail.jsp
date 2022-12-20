<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<% 
	String artstSq = request.getParameter("artstSq");
%>

<style type="text/css">
	a:link {
	  color : #0000FF;
	}
	a:visited {
	  color : #000000;
	}
	a:hover {
	  color : #E9625C;
	}
	
	img {
		width:210px;
		height:250px;
	}
	
	.tdTitle {
		width:100px;
		text-align:center;
		background-color:#efefef;	
		font-weight : bold;
	}
	
	.tdData {
		font-weight : bold;
	}
</style>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     <!-- Main content -->
    		<section class="content">
    			
    			<div class="card">
    			
    				<div class="card-header">
    				
    					<h3 class="card-title bTitle"><b>작가회원 상세 정보</b></h3>
    					<input type="hidden" id="artstSq" value="<%=artstSq%>">		
    				</div>
    				
    			</div>
    			<div class="card">
	    			<div class="card-body table-responsive p-0 " style="font-size:12px;">
	    				
	    				<table border="0" align="left" cellspacing="10px" cellpadding="10px" >
	    					<tr>
	    						<td>
	    							<img src="" id="artstProfileImgUrl">
	    						</td>
	    					</tr>
	    				</table>
	    				<br>	
	    				<table border="1" align="left" cellspacing="10px" cellpadding="10px" style="width:700px;background-color:#ffffff">
							<tr>
								<td class="tdTitle">
									작가명
								</td>
								<td class="tdData">
									<span id="mbrNm"></span>
								</td>
							</tr>
							<tr>
								<td class="tdTitle">
									활동명
								</td>
								<td class="tdData">
									<span id="artstActvtyNm"></span>
								</td>
							</tr>
							<tr>
								<td class="tdTitle">
									생년월일
								</td>
								<td class="tdData">
									<span id="mbrBirth"></span>
								</td>
							</tr>
							<tr>
								<td class="tdTitle">
									활동영역
								</td>
								<td class="tdData">
									<span id="artstActvtyPartCdTxt"></span>
								</td>
							</tr>
							<tr>
								<td class="tdTitle">
									작고년도
								</td>
								<td class="tdData">
									<span id="artstYod"></span>
								</td>
							</tr>
							<tr>
								<td class="tdTitle">
									작가소개
								</td>
								<td class="tdData">
									<span id="artstSelfIntro"></span>
								</td>
							</tr>
	    				</table>
	    				
	    			</div>
    			</div>
    			
    			<div class="card">
    			
    				<div class="card-header">
    				
    					<h3 class="card-title bTitle"><b>작품</b></h3>
    					
    					<div class="card-tools">
		                  <div class="input-group input-group-sm" style="width: 650px;">
		                  
		                  
	                           <button type="button" id="returnBtn" onclick="javascript:history.back();">리스트로 돌아가기</button>
		                      
		                  
		                    
		                  </div>
		                </div>
    							
    				</div>
    				
    			</div>
    			
    			<div class="card">
    			
    				<div class="card-body table-responsive p-0 " style="font-size:13px;">
    				
    				<table border="0" align="left" cellspacing="10px" cellpadding="10px" id="dataList">

    				</table>
    				
    			</div>
    			
    			</div>
    			 
    		</section>
		 
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   $(document).ready(function(){
	   
	   artInfoData();
	   
	   workData();
	   
   });
   
   function artInfoData() {
	   
	   		var artstSqParam = $("#artstSq").val();
	   
	   		let param = {
	   			artstSq : artstSqParam	
	   		}
	   		
			$.ajax({
		           type: "post",
		           url: "/admin/artWorkList/artWorkContentData",
		           data: param,
		           success: function(data) {
		        	   
		        	console.log(data);
		        	
		        	  var artInfo = data.artist.artDetailInfo[0];
		        	  
		        	  //작가사진
		        	  $("#artstProfileImgUrl").attr("src", artInfo.artstProfileImgUrl);
		        	  //작가명
		        	  $("#mbrNm").html(artInfo.mbrNm);
		        	  //작가활동명
					  $("#artstActvtyNm").html(artInfo.artstActvtyNm);		        	  
		        	  //생년월일
		        	  $("#mbrBirth").html(artInfo.mbrBirth);
		        	  //활동영역 
		        	  $("#artstActvtyPartCdTxt").html(artInfo.artstActvtyPartCdTxt);
		        	  //작고년도
		        	  $("#artstYod").html(artInfo.artstYod);
		        	  //작가소개
		        	  $("#artstSelfIntro").html(artInfo.artstSelfIntro);
		        	 				
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
	}
   
   function workData() {
	   
	   var artstSqParam = $("#artstSq").val();
	   
		$.ajax({
	           type: "post",
	           url: "/admin/artWorkList/artWorkData",
	           data: {
	        	   artstSq : artstSqParam
	           },
	           success: function(data) {
	        	   
	        	console.log(data);
	        	
	        	dataList = data.work.list;
	        	
	        	var strHtml = '';
	        	
	        	
	        	
	        	for(j=0; j<dataList.length; j++){
	        		
	        		
	        		strHtml += '<tr>';	
	        			strHtml += '<td valign="top" align="left" style="padding-left:5px;">';
       						strHtml += '<table border="0" style="height:250px;font-weight: bold;" cellspacing="5" cellpadding="5" >';
								strHtml += '<tr>';
									strHtml += '<td style="height:250px;" valign="top" align="left">';
										strHtml += '<img src="'+ dataList[j].workMainImgUrl +'">';	
									strHtml += '</td>';
									strHtml += '<td valign="top" align="left">';
										
										strHtml += '<table border="1" align="left" cellspacing="10px" cellpadding="10px" style="width:700px;background-color:#ffffff">';
										
											strHtml += '<tr>';
												strHtml += '<td class="tdTitle">제작년도</td>';
												strHtml += '<td class="tdData" colspan="4">';
													strHtml +=  dataList[j].workProdcYear;
												strHtml += '</td>';
											strHtml += '</tr>';
										
											strHtml += '<tr>';
												strHtml += '<td class="tdTitle">작품명</td>';
												strHtml += '<td class="tdData" colspan="4">';
													strHtml +=  dataList[j].workNm;
												strHtml += '</td>';
											strHtml += '</tr>';
											
											strHtml += '<tr>';
												strHtml += '<td class="tdTitle">작품소재</td>';
												strHtml += '<td class="tdData" colspan="4">';
												strHtml +=  dataList[j].workMatrl;
												strHtml += '</td>';
											strHtml += '</tr>';
											
											strHtml += '<tr>';
												strHtml += '<td class="tdTitle">가로</td>';
												strHtml += '<td class="tdData">';
												strHtml +=  dataList[j].workSizeWidth;
												strHtml += '</td>';
												strHtml += '<td class="tdTitle">세로</td>';
												strHtml += '<td class="tdData">';
												strHtml +=  dataList[j].workSizeDepth;
												strHtml += '</td>';
											strHtml += '</tr>';
											
											strHtml += '<tr>';
												strHtml += '<td class="tdTitle">판매여부</td>';
												strHtml += '<td class="tdData" colspan="4">';
													strHtml +=  dataList[j].WorkSaleYn;
												strHtml += '</td>';
											strHtml += '</tr>';
											
											strHtml += '<tr>';
												strHtml += '<td class="tdTitle">작품소개</td>';
												strHtml += '<td class="tdData" colspan="4">';
													strHtml +=  dataList[j].workIntrdc;
												strHtml += '</td>';
											strHtml += '</tr>';
										
										strHtml += '</table>';
										
									strHtml += '</td>';
								strHtml += '</tr>';
							strHtml += '</table>';
				    	strHtml += '</td>';
	        		strHtml += '</tr>';	
	        	
	        		
	        		
	        	}
	        	
	        	$("#dataList").empty();
	        	$("#dataList").append(strHtml).trigger("create");
			
	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               //alert("오류 발생" + errorJson);
	               console.log(errorJson);
	           }
		})
	}
   
   </script>
 
 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
	//신고하기 순번
	String rprtSq = request.getParameter("rprtSq"); 
%>

<body class="hold-transition sidebar-mini">


	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     	<!-- Main content -->
	    		<section class="content">

	    			<input type="hidden" name="brdTypCd" id="brdTypCd" value="<%=rprtSq%>">
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>신고-내용보기</b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<input type="hidden" name="rprtRsltTypCdDv" id="rprtRsltTypCdDv">
					 
					 	<table class="table table-bordered" style="font-size:11px;width:900px;">
					 		
					 		<tr>
					 			<td style="width:150px;text-align:center;vertical-align: middle;background-color:#efefef"><b>신고구분(관리자 지정)</b></td>
					 			<td colspan="3">
					 			
					 				<table class="table table-bordered" style="font-size:11px;">
					 					<tr align="center" style="background-color:#efefef">
					 						<td>
					 							신고요청
					 						</td>
					 						<td>
					 							허위신고		
					 						</td>
					 						<td>
					 							허위판매
					 						</td>
					 						<td>
					 							위작		
					 						</td>
					 					</tr>
					 					<tr align="center">
					 						<td>
					 							<input type="radio" name="rprtRsltTypCd" class="rprtRsltTypCd" value="RP" onclick="detailupdate('RP')">
					 						</td>
					 						<td>
					 							<input type="radio" name="rprtRsltTypCd" class="rprtRsltTypCd" value="FR" onclick="detailupdate('FR')">		
					 						</td>
					 						<td>
					 							<input type="radio" name="rprtRsltTypCd" class="rprtRsltTypCd" value="FS" onclick="detailupdate('FS')">
					 						</td>
					 						<td>
					 							<input type="radio" name="rprtRsltTypCd" class="rprtRsltTypCd" value="FG" onclick="detailupdate('FG')">		
					 						</td>
					 					</tr>
					 				</table>
					 				
					 			</td>
					 		</tr>
					 		<tr>
					 			<td style="width:150px;text-align:center;background-color:#efefef"><b>신고자</b></td>
					 			<td>
					 				<span id="mbrNm"></span>
					 			</td>
					 			<td style="width:150px;text-align:center;background-color:#efefef"><b>작가명</b></td>
					 			<td>
					 				<span id="artstNm"></span>
					 			</td>
					 		</tr>
					 		<tr>
					 			<td style="width:120px;text-align:center;background-color:#efefef"><b>작품명</b></td>
					 			<td colspan="3">
					 				<span id="workNm"></span>
					 			</td>
					 		</tr>
					 		<tr>
					 			<td style="width:120px;text-align:center;vertical-align: middle;background-color:#efefef"><b>신고내용</b></td>
					 			<td colspan="3" style="height:400px;">
					 				<span id="rprtDtl"></span>
					 			</td>
					 		</tr>
					 	</table>
					 
					 	<table class="table table-bordered" style="font-size:11px;width:900px;">
					 		<tr>
					 			<td style="text-align:right">
					 				<button type="button" class="btn btn-info sTitle" onclick="reportList();">리스트로 돌아가기</button>
					 			</td>
                    		</tr>
					 	</table>
					 		
					 </div>
					
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   
   function detailtData() {
		
		$.ajax({
	           type: "post",
	           url: "/admin/report/reportSearch",
	           data: {
	        	   rprtSq : <%=rprtSq%>
	        },
	           success: function(data) {
	        	   console.log(data);
	        	   dataCon = data.result[0];
	        	   
	        	   $("#artstNm").html(dataCon.artstNm);
	        	   $("#workNm").html(dataCon.workNm);
	        	   $("#mbrNm").html(dataCon.mbrNm);
	        	   $("#rprtDt").html(dataCon.rprtDt);
	        	   $("#rprtDtl").html(dataCon.rprtDtl);
	        	   
	        	   var rprtRsltTypCd = dataCon.rprtRsltTypCd;
	        	   
	        	   $("#rprtRsltTypCdDv").val(rprtRsltTypCd);
	        	   
	        	   //var rprtRsltTypCd = 'FR';
	        	   $('input[name="rprtRsltTypCd"][value='+rprtRsltTypCd+']').prop("checked", true);
	        	 
	        	 console.log(dataCon.workNm);
	        	 
	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
	 
   
   function reportList() {
	   location.href = "/admin/report/reportList";
   }
   
   
   function detailupdate(cd){
	   
	   var rprtRsltTypCdVal = cd;
	   console.log(rprtRsltTypCdVal);
	   
	   if (!confirm("신고구분을 지정하시겠습니까?")) {
	        // 취소(아니오) 버튼 클릭 시 이벤트
		   var rprtRsltTypCd = $("#rprtRsltTypCdDv").val();
		   
	        $('input[name="rprtRsltTypCd"][value='+rprtRsltTypCd+']').prop("checked", true);
		   
	    } else {
	        // 확인(예) 버튼 클릭 시 이벤트
	        
	    	$.ajax({
				type: "POST",
		        url: "/admin/report/reportUpdateData",
		        data: {
		        	rprtSq : <%=rprtSq%>,
		        	rprtRsltTypCd : rprtRsltTypCdVal
		        },
				success:function(data){
					console.log(data);
				},
				error: function(error) {
		            alert("오류 발생" + error);
		        }
			});
	    }
	   
	   
	   
	  
   }
   
   $(document).ready(function() {
	   detailtData();
	});
      
   </script>
 
 
 
</body>
</html>
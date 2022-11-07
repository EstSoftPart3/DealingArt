<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

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
		width:150px;
		heihgt:150px;
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
    				
    					<h3 class="card-title bTitle">작가회원 작품</h3>
    				
    				</div>
    				
    			</div>
    			
    			<div class="card-body table-responsive p-0 " style="height: 850px;font-size:11px;">
    				
    				<table border="1" align="center" cellspacing="10px" cellpadding="10px">
    					<tr>
    						<td>
    							<table border="0">
    								<tr>
    									<td>
    										<img src="https://dealingart-resorce.s3.ap-northeast-2.amazonaws.com/dealingart/artist/17/3b93ca19-36d3-4114-8885-b3cca16a94fe%EC%88%98%EC%A0%95%EB%90%A8_M171%28%EC%88%98%EC%A0%95%29.jpg">
    									</td>
    								</tr>
    								<tr>
    									<td>
    										작가명 : 홍길동
     									<td>
    								</tr>
    								<tr>
    									<td>
    									   분야 : 회화
    									<td>
    								</tr>
    								<tr>
    									<td>
    									   생년월일 : 2000-01-01
    									<td>
    								</tr>
    							</table>
    						</td>

    					</tr>
    				</table>
    				
    			</div>
    			 
    		</section>
		 
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   $(document).ready(function(){
	   workData();
   });
   
   function workData() {
			$.ajax({
		           type: "post",
		           url: "/admin/artWorkList/artWorkListData",
		           data: {
		        	   page : 1,
		        	   pageSize : 10,
		        	},
		           success: function(data) {
		        	   
		        	console.log(data);
		        	    
		        	 
				
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
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
    			
    			<div class="card-body table-responsive p-0 " style="font-size:13px;">
    				
    				<table border="0" align="center" cellspacing="10px" cellpadding="10px" id="dataList">

    				</table>
    				
    			</div>
    			 
    		</section>
		 
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   $(document).ready(function(){
	   artInfoData();
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
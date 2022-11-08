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
    				
    					<h3 class="card-title bTitle"><b>작가회원 작품</b></h3>
    				
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
		        	
		        	dataList = data.workData.List;
		        	
		        	var strHtml = '';
		        	
		        	//개행을 위한 변수 
		        	var z = 0;
		        	
		        	strHtml += '<tr>';
		        	
		        	for(j=0; j<dataList.length; j++){
		        		
		        		z += 1;
		        		
		        		strHtml += '<td valign="top">';
	        			
						strHtml += '<table border="1" style="height:250px;font-weight: bold;" cellspacing="15" cellpadding="15">';
							/*
							strHtml += '<tr>';
								strHtml += '<td>';
									strHtml += j;
								strHtml += '</td>';
							strHtml += '</tr>';
							*/
							strHtml += '<tr>';
								strHtml += '<td style="height:250px;" valign="top">';
									if(dataList[j].artstWorkImgUrl == null) {
										strHtml += '<img src="/resources/img/404.jpg">';
									} else {
										strHtml += '<img src="'+ dataList[j].artstWorkImgUrl +'">';	
									}
									
								strHtml += '</td>';
							strHtml += '</tr>';
							strHtml += '<tr>';
								strHtml += '<td>';
								strHtml += '작가이름 : '+  dataList[j].mbrNm +'';
								strHtml += '</td>';
							strHtml += '</tr>';
							strHtml += '<tr>';
								strHtml += '<td>';
								strHtml += '작품분야 : '+ dataList[j].artstActvtyPartCdTxt+'';
								strHtml += '</td>';
							strHtml += '</tr>';
							strHtml += '<tr>';
								strHtml += '<td>';
								strHtml += '생년월일 : '+  dataList[j].mbrBirth +'';
								strHtml += '</td>';
							strHtml += '</tr>';
						strHtml += '</table>';
					        			
						strHtml += '</td>';
		        		
						//개행 변수 증가값이 4이상이면 테이블 개행한다.
		        		if(z > 4) {
		        			strHtml += '</tr>';	
		        			
		        			z = 0;
		        		}
		        		
		        		
		        	}
		        	
		        	$("#dataList").empty();
		        	$("#dataList").append(strHtml).trigger("create");
		        	
// 		        	 for(i=0; i<dataList.length; i++){
		        		 
		        		 
		        		 
// 		        	 }
		        	 
				
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
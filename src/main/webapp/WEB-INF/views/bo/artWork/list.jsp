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

<body class="hold-transition sidebar-mini" id="mainPage" style="padding-bottom:50px;">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     <!-- Main content -->
    		<section class="content">
    			
    			<div class="card">
    			
    				<div class="card-header">
    				
    					<h3 class="card-title bTitle"><b>작가회원 작품</b></h3>
    				
    				
    				
    					<div class="card-tools">
		                  <div class="input-group input-group-sm" style="width: 650px;">
		                  
		                   
		                    <select class="custom-select bTitle" id="searchGubun">
	                          <option value="">선택</option>
	                          <option value="mbrNm">작가명</option>
	                          <option value="artstActvtyNm">활동명</option>
	                       </select>
	                       
		                    <input type="text" name="table_search" id="searchWord" class="form-control float-right bTitle" placeholder="검색" style="width:200px;" >
		
		                    <div class="input-group-append">
		                     
		                      <button type="button" data-action="memberSearch" data-id="search-id" class="btn btn-default" id="searchBtn"><i class="fas fa-search"></i></button>
		                      
		                    </div>
		                    
		                  </div>
		                </div>
    				
    			</div>
    			
    			<div class="card">
    			
	    			<div class="card-body table-responsive p-0 " style="font-size:13px;">
	    				
	    				<table border="0" align="center" cellspacing="10px" cellpadding="10px" id="dataList">
	
	    				</table>
	    				
	    			</div>
    			
    			</div>
    			 
    		</section>
		 
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   
   var scrollPage  = 10;
   
   $(document).ready(function(){
	   
	   
	   
	   workData(scrollPage);
	   
	   // Scroll
	    $(window).scroll(function(){
	        var scrollNow = $(window).scrollTop();

	        if (scrollNow + $(window).height() + 250 >= $('#mainPage').height()){
	        	
	        	workData(scrollPage);
	        }
	    });
	   
	    $("#mainPage").scrollTop(0);
	    
   });
   
   function workData(page) {
			$.ajax({
		           type: "post",
		           url: "/admin/artWorkList/artWorkListData",
		           data: {
		        	   page : page,
		        	   searchWord : $("#searchWord").val(),
   		        	   searchGubun : $("#searchGubun").val()
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
		        		
		        		strHtml += '<td valign="top" onclick="artDetail('+dataList[j].artstSq+')" style="cursor:pointer">';
	        			
						strHtml += '<table border="1" style="height:250px;font-weight: bold; border-color:#eeeeee;" cellspacing="10" cellpadding="10">';
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
								strHtml += '활동명 : '+  dataList[j].artstActvtyNm +'';
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
		        	
		        	scrollPage += 5;
		        	
		        	
		        	
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

	   function artDetail(artstSq) {
		   location.href = '/admin/artDetailInfo?artstSq='+artstSq
	   }
   
 		//검색 input Box enter Key Press
		$("#searchWord").on("keydown",function(key){         
			if(key.keyCode==13) {             
				workData(scrollPage);  
			}     
		});
		
		//검색
		$("#searchBtn").on('click', function(){
				workData(scrollPage);
		 });
   
   
   </script>
 
 
</body>
</html>
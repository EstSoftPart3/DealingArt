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
	
</style>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		 
		     <!-- Main content -->
    		<section class="content">
    			
    			<div class="card">
    				
	    			<div class="card-header">
	                	<h3 class="card-title bTitle">회원 목록</h3>
	                	
		                <div class="card-tools">
		                  
		                  <div class="input-group input-group-sm" style="width: 650px;">
		                  
		                  
		                    <select class="custom-select bTitle" id="memberGubun">
	                          <option value="" selected>전체</option>
	                          <option value="1">개인/콜렉터</option>
	                          <option value="2">작가</option>
	                          <option value="3">관리자</option>
	                          <option value="4">전체관리자</option>
	                        </select>
		                    
		                    <select class="custom-select bTitle" id="searchGubun">
	                          <option value="">선택</option>
	                          <option value="mbrNm">이름</option>
	                          <option value="mbrId">아이디</option>
	                          <option value="mbrNcknm">닉네임</option>
	                          <option value="mbrSq">회원순번</option>
	                        </select>
		                    <input type="text" name="table_search" id="searchWord" class="form-control float-right bTitle" placeholder="검색" style="width:200px;" >
		
		                    <div class="input-group-append">
		                      <button type="button" data-action="memberSearch" data-id="search-id" class="btn btn-default" id="searchBtn"><i class="fas fa-search"></i></button>
		                      
		                      <button type="button" class="exportToExcel" id="excelDown">EXCEL</button>
		                      
		                    </div>
		                    
		                  </div>
		                </div>
	              	
	              	</div>
	              	
	              	 <div class="card-body table-responsive p-0 " style="height: 850px;font-size:11px;" >
	              	 
						<table class="table table-bordered exportToExcel" id="table2excel" >
							<thead>
								<tr align="center" style="background-color:#efefef;" >
									<th>회원구분</th>
									<th>이름</th>
									<th>아이디(이메일)</th>
									<th>휴대전화</th>
									<th>등록일</th>
									<th class="noExl">작가정보등록</th>
								</tr>
							</thead>
							<tbody id="dataList" >
									                   		                    
							</tbody>
						</table>
		            </div>
    			
    			</div>
    			
    		</section>
		 </div>
		 
		  <!--card-footer -->
         <div class="card-footer" >
               <button type="button" class="btn btn-info sTitle" style="float:right" onclick="goMemberInput();">회원가입</button>
         </div>
		
	</div>
	
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
    <script>
   		var dataList = {};
   
   		$(document).ready(function(){
   			searchMemberData();
   		});
   		
   		//회원 리스트 호출
   		function searchMemberData(page) {
   			$.ajax({
   		           type: "post",
   		           url: "memberSearch",
   		           data: {
   		        	   page : page,
   		        	   pageSize : 100,
   		        	   useYn : 'Y',
   		        	   memberGubun : $("#memberGubun").val(),
   		        	   searchGubun : $("#searchGubun").val(),
   		        	   searchWord : $("#searchWord").val()
   		           },
   		           success: function(data) {
   		        	   
   		        	dataList = data.memberData.memberList;
   		        	    
   		        	   var authGubun = '';
   		        	   var checkState = '';
   		        	   var strHtml = '';
   		        	   for(i=0; i<dataList.length; i++){
   		        		   
   		        		   	
   		        		    if(dataList[i].authSq == '1') {
		        		   	   authGubun = '';
		        		   		checkState = 'checked'; 
		        		   	}
   		        		   
   		        		    if(dataList[i].authSq == '2') {
   		        		   	   authGubun = '[작가]';
   		        		   		checkState = 'checked'; 
   		        		   	}
   		        		    
   		        		    if(dataList[i].authSq == '3') { 
 		        		   	   authGubun = '[관리자]';
 		        		   		checkState = 'checked'; 
 		        		   	}
   		        		    
   		        		    if(dataList[i].authSq == '4') {
		        		   	   authGubun = '[전체관리자]';
		        		   		checkState = 'checked'; 
		        		   	}
   		        			
   			        	   	strHtml += '<tr align="center" style="height:20px;">';
   			        		strHtml += '<td>'+ authGubun + ' ' + dataList[i].mbrSocialSort +'</td>';   			        					        		
   			        	   	strHtml += '<td style="cursor:pointer; color: #0000ff;"><a href="javascript:void(0)" onclick="memberContent('+ dataList[i].mbrSq +')">'+ dataList[i].mbrNm +'</td>';
   			        	   	//strHtml += '<td>'+ dataList[i].mbrSexCd +'</td>'
   			        	 	strHtml += '<td>'+ dataList[i].mbrId +'</td>';
   			        	 	strHtml += '<td>'+ dataList[i].mbrCpNum +'</td>';
   			        	 	strHtml += '<td>'+ dataList[i].regDt +'</td>';
   			        	 	
   			        	 	//if(dataList[i].authSq  == '2') {
   			        	 	strHtml += '<td class="noExl"><button onclick="artistMemberContent('+ dataList[i].mbrSq +')" style="cursor:pointer">작가정보확인</button></td>';	
   			        	 	//} else {
   			        	 	//strHtml += '<td></td>';
   			        	 	//}
   			        	 	
   			        	   	strHtml += '</tr>';
   			        	   	
   			        	 	checkState = '';
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
   		
   		//복호화
   		function memberDecrypt(str) {
   		 	var result ="";
   		 
   			$.ajax({
		           type: "post",
		           url: "memberDecrypt",
		           async: false,
		           data: {
		        	   Decryptstr : str
		           },
		           success: function(data) {
		        	 result = data;
		        	},
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
   		               console.log(errorJson);
		           }
			});
   			
   			return result;
		}
   		
   		//검색 input Box enter Key Press
   		$("#searchWord").on("keydown",function(key){         
   			if(key.keyCode==13) {             
   				searchMemberData();   
   			}     
   		});
   		
   		
   		//검색
   		$("#searchBtn").on('click', function(){
   			var memberGubun = $("#memberGubun").val(); 
   			var searchGubun = $("#searchGubun").val();
			var searchWord = $("#searchWord").val();
			 
			/* 
			 if(searchGubun == "") {
				 bootbox.alert({ 
					 	size: "small",
					 	message: "검색 조건을 선택해 주세요.",
					 	locale: 'kr',
					 	callback: function() {
					 		$("#searchGubun").focus();
				    	} });
				 
				 return;
			 } else if(searchWord == ""){
				 bootbox.alert({
					 size: "small",
					 message: "검색 단어를 선택해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#searchWord").focus();
				     } });
				 return;
			 } else {
			 	
				 searchMemberData();
			 }
		*/
		
			searchMemberData();
			 
		});
   		
   		//회원 상세정보 이동
   		function memberContent(mbrSq) {
   			
   			let param = {
   				mbrSqParam : mbrSq,
   				mbrAuthSq : '1'
   			}
   		
   			var contentUrl = "/admin/member/memberContent";
   			postForm(contentUrl, param);
   			
   		}
   		
   		//작가등록
   		function artistMemberContent(mbrSq) {
   			
   			let param = {
   	   			mbrSqParam : mbrSq,
   	   			mbrAuthSq : '1'
   	   		}
   			
   			var contentUrl = "/admin/member/insertArtistMemberPage";
   			postForm(contentUrl, param);
   		}
   		   		
   		function postForm(path, params, method) {
   		    method = method || 'post';

   		    var form = document.createElement('form');
   		    form.setAttribute('method', method);
   		    form.setAttribute('action', path);

   		    for (var key in params) {
   		        if (params.hasOwnProperty(key)) {
   		            var hiddenField = document.createElement('input');
   		            hiddenField.setAttribute('type', 'hidden');
   		            hiddenField.setAttribute('name', key);
   		            hiddenField.setAttribute('value', params[key]);

   		            form.appendChild(hiddenField);
   		        }
   		    }

   		    document.body.appendChild(form);
   		    form.submit();
   		}
   		
   		//회원입력 이동
   		function goMemberInput() {
   			location.href = '/admin/member/memberInput';	
   		}
   		
   		
   		$(function() {
			$("#excelDown").click(function(){
				$("#table2excel").table2excel({
					exclude: ".noExl",
					name: "memExl"
				}); 
			 });
		});
   		
   		
   	
   			
   	
   	</script>
	



	 
</body>
</html>
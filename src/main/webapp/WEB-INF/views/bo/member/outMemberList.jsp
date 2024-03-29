<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>


<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		 
		     <!-- Main content -->
    		<section class="content">
    			
    			<div class="card">
    				
	    			<div class="card-header">
	                	<h3 class="card-title bTitle">탈퇴 회원 목록</h3>
	
		                <div class="card-tools">
		                  <div class="input-group input-group-sm" style="width: 350px;">
		                    <select class="custom-select bTitle" id="searchGubun">
	                          <option value="">선택</option>
	                          <option value="mbrNm">이름</option>
	                          <option value="mbrId">아이디</option>
	                          <option value="mbrNcknm">닉네임</option>
	                        </select>
		                    <input type="text" name="table_search" id="searchWord" class="form-control float-right bTitle" placeholder="검색">
		
		                    <div class="input-group-append">
		                      <button type="button" data-action="memberSearch" data-id="search-id" class="btn btn-default" id="searchBtn"><i class="fas fa-search"></i></button>
		                    </div>
		                    
		                  </div>
		                </div>
	              	
	              	</div>
	              	
	              	 <div class="card-body table-responsive p-0" style="height: 850px;font-size:11px;">
	              	 
		                <table class="table table-bordered">
		                  <thead>
		                    <tr align="center" style="background-color:#efefef">
		                      <th>회원구분</th>
		                      <th>이름</th>
		                      <th>아이디(이메일)</th>
		                      <th>휴대전화</th>
		                      <th>등록일</th>
		                    </tr>
		                  </thead>
		                  <tbody id="dataList">
		                   		                    
		                  </tbody>
		                </table>
		            </div>
    			
    			</div>
    			
    		</section>
		 </div>
		 
		  <!--card-footer -->
         <div class="card-footer" >
               
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
   		        	   useYn : 'N',
   		        	   searchGubun : $("#searchGubun").val(),
   		        	   searchWord : $("#searchWord").val()
   		           },
   		           success: function(data) {
   		        	   
   		        	dataList = data.memberData.memberList;
   		        	    
   		        	   var authGubun = '';
   		        	   var checkState = '';
   		        	   var strHtml = '';
   		        	   for(i=0; i<dataList.length; i++){
   		        		   
   		        		   	if(dataList[i].authSq == '2') {
   		        		   	   authGubun = '[작가]';
   		        		   		checkState = 'checked'; 
   		        		   	} else {
   		        		   	   authGubun = '';	
   		        		   	} 
   		        			
   			        	   	strHtml += '<tr align="center" style="height:20px;">';
   			        		strHtml += '<td>'+ authGubun + ' ' + dataList[i].mbrSocialSort +'</td>';
   			        	   	strHtml += '<td style="cursor:pointer; color: #0000ff;"><a href="javascript:void(0)" onclick="wthdrMemberContent('+ dataList[i].mbrSq +')">'+ dataList[i].mbrNm +'</td>';
   			        	   	//strHtml += '<td>'+ dataList[i].mbrSexCd +'</td>'
   			        	 	strHtml += '<td>'+ dataList[i].mbrId +'</td>';
   			        	 	strHtml += '<td>'+ dataList[i].mbrCpNum +'</td>';
   			        	 	strHtml += '<td>'+ dataList[i].regDt +'</td>';
   			        	 	
   			        	 	
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
   		
   		//검색
   		$("#searchBtn").on('click', function(){
			 var searchGubun = $("#searchGubun").val();
			 var searchWord = $("#searchWord").val();
			 
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
			 
		});
   		
   		//회원 상세정보 이동
   		function wthdrMemberContent(mbrSq) {
   			
   			let param = {
   				mbrSqParam : mbrSq
   			}
   		
   			var contentUrl = "/admin/member/wthdrMemberContent";
   			postForm(contentUrl, param);
   			
   		}
   		
   		//작가등록
   		function artistMemberContent(mbrSq) {
   			let param = {
   	   				mbrSqParam : mbrSq
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
	</script>
	 
</body>
</html>
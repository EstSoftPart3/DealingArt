<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>




<body class="hold-transition sidebar-mini">

	<div class="wrapper">

		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>

		<div class="content-wrapper">

			<!-- 		     	Main content -->
			<section class="content">
				<div class="card-header p-2"
					style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
					<ul class="nav nav-pills">
						<li class="nav-item"><a class="sTitle" href="#"
							data-toggle="tab"><b>배너관리</b></a></li>
					</ul>
				</div>

				<div class="card">

					<div class="card-body" style="background-color: #ffffff;">

						<div class="card-header">
							<h3 class="card-title bTitle">배너 목록</h3>
							<button type="button" class="btn btn-default sTitle">
								<i class="fas fa-remove" onclick="bannerDelete();">삭제</i>
							</button>
							<div class="card-tools">

								<div class="input-group input-group-sm" style="width: 650px;">

									<div class="input-group-append">
										<button type="button" data-action="" data-id=""
											class="btn btn-info sTitle" id=""
											onclick="location.href='/admin/banner/bannerWrite'">배너등록</button>
									</div>
									<select class="custom-select bTitle" id="searchGubun">
										<option value="">주제유형</option>
										<option value="MIH">메인페이지홈</option>
										<option value="CMH">커뮤니티홈</option>
										<option value="MGH">매거진홈</option>
										<option value="EVH">이벤트홈</option>
									</select> <select class="custom-select bTitle" id="searchCnt">
										<option value="">SELECT</option>
										<option value="rowCnt10">10개씩 보기</option>
										<option value="rowCnt20">20개씩 보기</option>
										<option value="rowCnt30">30개씩 보기</option>
										<option value="rowCnt50">50개씩 보기</option>
										<option value="rowCnt100">100개씩 보기</option>
									</select>


								</div>
							</div>

						</div>

						<div class="card-body table-responsive p-0"
							style="height: 500px; font-size: 11px;">

							<table class="table table-bordered">
								<thead>
									<tr align="center" style="background-color: #efefef" id="bannerMainListData">
										<th><input type="checkbox" id="chkAll"></th>
										<th>순서</th>
										<th>분류</th>
										<th>제목</th>
										<th>기간</th>
										<th>등록일</th>
									</tr>
								</thead>
								<tbody id="dataList">

								</tbody>
							</table>
						
						</div>
							<button type="button" class="btn btn-info sTitle"
								style="margin: 0 auto" id="searchBtn">검색</button>
						<!-- 						</div> -->
						<!-- 			 <div class="card"> -->

						<!-- 					 	<div class="card-body" style="background-color:#ffffff;"> -->
						<!-- 					 		<div class="col-sm-9"> -->
						<!-- 					 			<div id="bannerList" style="font-size:12px;"></div> -->
						<!-- 					 		</div> -->
						<!-- 					 	</div> -->

						<!-- 					 	<div class="form-group row" > -->
						<!--                     		<div class="col-sm-9" style=""> -->
						<!--                     			<button type="button" class="btn btn-info sTitle" onclick="Input();">검색</button> -->
						<!-- 					    	</div> -->
						<!--                     	</div> -->

						<!-- 	    			</div> -->

						<!-- 					</div> -->
						<!-- 				</div> -->
			</section>

		</div>

	</div>
	
	
	<script>
	
	//var bnnSq = '<c:out value="${param.bnnSq}" />';
    //var bnnDivCd = '<c:out value="${param.bnnDivCd}" />';

	$(document).ready(function(){
		//게시물 목록 조회
		bannerMainList();
	});

	function bannerMainList(){
				
		if($("#searchGubun").val() == "" && $("#searchCnt").val() == ""){
			$.ajax({
		           type: "post",
		           url: "/admin/banner/bannerMainList",
		           data: {},
		           success: function(data) {
		        	   
		        	   var list = data.list.boardInfo;
		        	   		for(i=0; i<list.length; i++){
		        	   		 	
		        	   			var strHtml = '<tr id align="center">';
		        	   			strHtml += '<th><input type="checkbox" name="chkbox" value="'+list[i].BNN_SQ+'"></th>';
		        	   			strHtml += '<th>' + list[i].BNN_SQ + '</th>';
		        	   			
								if(list[i].BNN_DIV_CD == "MIH"){
									strHtml += '<th>메인 페이지 홈</th>';	
		        	   			}else if(list[i].BNN_DIV_CD == "CMH"){
		        	   				strHtml += '<th>커뮤니티 홈</th>';	
		        	   			}else if(list[i].BNN_DIV_CD == "EVH"){
		        	   				strHtml += '<th>이벤트 홈</th>';	
		        	   			}else if(list[i].BNN_DIV_CD == "MGH"){
		        	   				strHtml += '<th>매거진 홈</th>';	
		        	   			}
		        	   				        	   			        	   				        	 	        	   			
		        	   			strHtml += '<th>' + list[i].BNN_TITLE + '</th>';
		        	   			strHtml += '<th>' + list[i].BNN_START_DT + ' ~ ' + list[i].BNN_END_DT + '</th>';
		        	   			strHtml += '<th>' + list[i].REG_DT + '</th>';
		        	   			

			        			if(i == 0){
			        				$('#dataList').html(strHtml);
			        			}else{
			        				$('#dataList').append(strHtml);
			        			}	
		        	   				
	 					}
		        	   
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}else{
			$.ajax({
		           type: "post",
		           url: "/admin/banner/bannerMainList",
		           data: {
		        	   
		        	    searchGubun : $("#searchGubun").val(),
			        	searchCnt : $("#searchCnt").val()
		           },
		           success: function(data) {
		        	   
		        	   var list = data.list.boardInfo;
		        	   
		        	   		for(i=0; i<list.length; i++){
		        	   		 	
		        	   			var strHtml = '<tr id align="center">';
		        	   			strHtml += '<th><input type="checkbox" name="chkbox" value="'+list[i].BNN_SQ+'"></th>';
		        	   			strHtml += '<th>' + list[i].BNN_SQ + '</th>';
		        	   			
								if(list[i].BNN_DIV_CD == "MIH"){
									strHtml += '<th>메인 페이지 홈</th>';	
		        	   			}else if(list[i].BNN_DIV_CD == "CMH"){
		        	   				strHtml += '<th>커뮤니티 홈</th>';	
		        	   			}else if(list[i].BNN_DIV_CD == "EVH"){
		        	   				strHtml += '<th>이벤트 홈</th>';	
		        	   			}else if(list[i].BNN_DIV_CD == "MGH"){
		        	   				strHtml += '<th>매거진 홈</th>';	
		        	   			}
		        	   				        	   			        	   				        	 	        	   			
		        	   			strHtml += '<th>' + list[i].BNN_TITLE + '</th>';
		        	   			strHtml += '<th>' + list[i].BNN_START_DT + ' ~ ' + list[i].BNN_END_DT + '</th>';
		        	   			strHtml += '<th>' + list[i].REG_DT + '</th>';
		        	   			

			        			if(i == 0){
			        				$('#dataList').html(strHtml);
			        			}else{
			        				$('#dataList').append(strHtml);
			        			}	
		        	   				
	 					}
		        	   
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}
		
		
	}
	//검색
		$("#searchBtn").on('click', function(){
			
			//var searchGubun = $("#searchGubun").val();
        	//var searchCnt = $("#searchCnt").val();

			//if(searchGubun == "" && searchCnt == "") {
			//	alert("검색 결과가 없습니다.");
			//	return;
			//}else{
			//	
			//}
				 	
		 bannerMainList();
		 
	});	

		
	// 체크 박스 클릭 시 전체선택
	 $("#chkAll").click(function() {
		if($("#chkAll").is(":checked")) {
			$("input[name=chkbox]").prop("checked", true);
		}else{
			$("input[name=chkbox]").prop("checked", false);
		}
		//putCheckList();
	});
	
	//체크된 갯수 확인하여 전체선택 해제
	$(document).on("click", "input[name=chkbox]", function(){
	  
	    var total = $("input[name=chkbox]").length;
		console.log(total);
		var checked = $("input[name=chkbox]:checked").length;
		console.log(checked);
		if(total != checked) $("#chkAll").prop("checked", false);
		else $("#chkAll").prop("checked", true); 
	});

	
	$("input[name=chkbox]").change(function() {
		// 체크박스 갯수와  체크된 체크박스 갯수 비교 후 불일치시 헤더 체크박스 해제 
		if($(this).length != $("input[name=chkbox]:checked").length) $("#chkAll").prop("checked", false); 
		//putCheckList();
	});
	
	//배너 삭제 ( 하다가 안되서 중지함)
	function bannerDelete() {
						
			//체크박스 row 데이터 담기						
			var idxArr = new Array();
			var deleteArr = new Array();
			
			$("input[name=chkbox]:checked").each(function() {
				idxArr.push($(this).val());
			});
			
							   
		   if(confirm('정말 삭제 하시겠습니까?')) {
			   
			   $.ajax({
		           type: "post",
		           url: "/admin/banner/bannerDelete",          
		           data:{
		        	   bnnSq : idxArr
		           },
		           success: function(data) {
		        		 
		        	   location.reload();				 		
				 
				   },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
			   
		   }else{
			   return false;
		   }
		   
		  
	   }
	
	
			

		
	</script>

</body>
</html>
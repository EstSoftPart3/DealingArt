<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>


<style>
	@media (max-width: 500px){
		.col-sm-1 {
			width: 30%;
		}

		.btnCommunitySet {
			width: 55px;
		} 
	}
</style>

<body>

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		 
		     <!-- Main content -->
    		<section class="content">
    			
    			<div class="card">
    				
	    			<div class="card-header">
	                	<h3 class="card-title bTitle">게시판 관리</h3>
	                </div>

	    			<div class="card-body table-responsive p-0 " style="height: auto;font-size:11px;" >
						<table class="table table-bordered exportToExcel" id="" >
							<thead>
								<tr align="center" style="background-color:#efefef;" >
									<th><input type="checkbox"></th>
									<th>게시물 유형</th>
									<th>게시판 제목</th>
									<th>게시판 ID</th>
									<th>새글/총갯수</th>
									<th>게시물 관리</th>
									<th>표시여부</th>
								</tr>
							</thead>
							<tbody id="boardTypeList" >
								<tr align="center">
									<th><input type="checkbox"></th>
									<th>이미지</th>
									<th>자랑하기</th>
									<th>1</th>
									<th>관리자/회원</th>
									<th>0 / 99</th>
									<th>
										<div class="noExl" style="text-align:left; display: inline;">
						                 	<button class="btnCommunitySet" type="button" style="border: 1px solid grey;height: 25px;">글보기 > </button>
											<button class="btnCommunitySet" type="button" style="border: 1px solid grey;height: 25px;">공지글 > </button>
						                </div>
									</th>
									<th>표시여부</th>
								</tr>
								<tr align="center">
									<th><input type="checkbox"></th>
									<th>리스트</th>
									<th>전시후기/소개</th>
									<th>2</th>
									<th>관리자/회원</th>
									<th>0 / 99</th>
									<th>
										<div class="noExl" style="text-align:left; display: inline;">
						                 	<button type="button" style="border: 1px solid grey; height: 25px;">글보기 > </button>
											<button type="button" style="border: 1px solid grey; height: 25px;">공지글 > </button>
						                </div>
									</th>
									<th>표시여부</th>
								</tr>
								<tr align="center">
									<th><input type="checkbox"></th>
									<th>리스트</th>
									<th>이슈</th>
									<th>3</th>
									<th>관리자/회원</th>
									<th>0 / 99</th>
									<th>
										<div class="noExl" style="text-align:left; display: inline;">
											<button type="button" style="border: 1px solid grey; height: 25px;">글보기 > </button>
											<button type="button" style="border: 1px solid grey; height: 25px;">공지글 > </button>
						                </div>
									</th>
									<th>표시여부</th>
								</tr>
							</tbody>
						</table>

				 		
				 		<div id="dtlBox" hidden="true">
				 			<div class="card-header p-1" style="border-left: 5px solid blue; border-radius: 0">
			                 	<ul class="nav nav-pills">
				               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><h5 id="commuTitle"></h5></a></li>
				               	</ul>
					 		</div>
					 		<div class="card">
				    			<div class="card-header">
					               	<h6 class="card-title bTitle">게시판 정보</h6>
								</div>
									<input type="hidden" name="cmMgSq"/>
					                <!--card-body -->
					                <table class="table table-bordered">	                
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 표시여부</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgShowYn" value="Y">사용</label>
												<label><input type="radio" name="cmMgShowYn" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle"  >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 제목</td>
											<td id="commuName" class="col-sm-2 dataValue"></td>						
										</tr>
										
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 정렬 방식</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgOdDivCd" value="REGST" checked="checked">등록순 정렬</label>
												<label><input type="radio" name="cmMgOdDivCd" value="REGDT">작성일순 정렬</label>
												<label><input type="radio" name="cmMgOdDivCd" value="LIK">좋아요 많은순 정렬</label>
												<label><input type="radio" name="cmMgOdDivCd" value="VIW">조회수 많은순 정렬</label>
											</td>	
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">댓글기능</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgCmtYn" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgCmtYn" value="N">사용 안함</label>
											</td>
										</tr>
										
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">작성일 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgRegdtYn" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgRegdtYn" value="N">사용 안함</label>
											</td>
										</tr>
										
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">조회수 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgViewsYn" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgViewsYn" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">스크랩 수 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgScrapsYn" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgScrapsYn" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">좋아요 수 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgLikesYn" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgLikesYn" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">SNS 공유 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgSnsYn" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgSnsYn" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">NEW 아이콘 설정</td>
											<td id="" class="col-sm-2 dataValue">
												<div class="input-group input-group-sm">
													등록 후
													<input type="number" name="cmMgNewSet" class="form-control float-right bTitle">
													시간 이내의 글
												</div>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">읽기 권한</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="readAuth" value="admin" checked="checked">관리자</label>
												<label><input type="radio" name="readAuth" value="member">회원이상</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">쓰기 권한</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="writeAuth" value="admin" checked="checked">관리자</label>
												<label><input type="radio" name="writeAuth" value="member">회원이상</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">댓글 권한</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="commentAuth" value="admin" checked="checked">관리자</label>
												<label><input type="radio" name="commentAuth" value="member">회원이상</label>
											</td>
										</tr>
										
					                </table>
					                
					                <!--card-footer -->
					                <div style="text-align:right; margin-right: 50px; margin-bottom: 20px;">
					                	<button onclick="commuManagementInfoUpdate()" style="border: 1px solid grey; width: 100px; height: 30px;">저장</button>
					                </div>
							  </div>
						  </div>
		            </div>
    			</div>
	    			
	    	</section>
	    		
		 </div>
		
	</div>

	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
	
	<script>
	
	$(document).ready(function(){
		//게시물 목록 조회
		commuTypeList();
		
	});
	/* 게시판 관리 타입 리스트  */
	function commuTypeList(){
		$.ajax({
	           type: "post",
	           url: "/admin/community/communityManagementList",
	           data: {},
	           success: function(data) {
	        	   data.list.list.forEach(function(ele, idx){
	        			var strHtml = '<tr id align="center">';
	        			strHtml += '<th><input type="checkbox"></th>';
	        			strHtml += '<th>' + ele.DTL_CD_NM + '</th>';
	        			strHtml += '<th onclick="manageDtl(\''+ ele.COMT_TYP_CD + '\',\'' + ele.DTL_CD_NM +'\',\'' + ele.CM_MG_NM + '\')">' + ele.CM_MG_NM + '</th>';	
	        			strHtml += '<th>' + ele.CM_MG_SQ + '</th>';
	        			strHtml += '<th>' + ele.CM_MG_NEW_CNT + ' / ' + ele.CM_MG_TOT_CNT + '</th>';
	        			strHtml += '<th><div class="noExl" style="text-align:left; display: inline;">';
	        			strHtml += '<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="window.open(\'http://localhost/deal/soldoutDetail?SqNumber=651\')">글보기 > </button>';
	        			strHtml += '<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="window.open(\'http://localhost/admin/community/communityManagementNoticeUpdate\?comtTypCd=\', \'게시판 관리\', \'width=800, height=180, scrollbars=no, resizeble=no\')">공지글 > </button>';
	        			strHtml += '</div></th>';
	        			strHtml += '<th>' + ele.CM_MG_SHOW_YN + '</th>';
	        			strHtml += '</tr>';
	        			strHtml += '';
	        		  	
	        			if(idx == 0){
	        				$('#boardTypeList').html(strHtml);
	        			}else{
	        				$('#boardTypeList').append(strHtml);
	        			}
	        	   });
	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
	
	function manageDtl(comtTypCd, dtlCdNm, cmMgNm){
		//제목 및 영역 명 셋팅.
		$("#dtlBox").attr("hidden", false);
		$("#commuName").text(cmMgNm);
		$("#commuTitle").text(dtlCdNm);
		$.ajax({
	           type: "post",
	           url: "/admin/community/communityManagementDtlList",
	           data: {comtTypCd : comtTypCd},
	           success: function(data) {
				 var dtlInfo = data.hashMap.dtlList;
				 
				 //표시여부 라디오 버튼 제어
				 Object.keys(dtlInfo).forEach(function(k){
				      var key = k;
				      var iptValue = dtlInfo[k];
				      var chkName = toCamelCase(key);
					  //표시 여부 셋팅
				      if(key.indexOf("_YN") > -1){
						  if(key == "CM_MG_SHOW_YN"){
					    	  iptValue = iptValue == "표시" ? "Y" : "N";
					      }
						  $('input:radio[name='  + chkName + ']input[value=' + iptValue + ']').prop("checked", true);
					  }
					  
					 //정렬 방식 셋팅
					  if(key == "CM_MG_OD_DIV_CD"){
						  $('input:radio[name='  + chkName + ']input[value=' + iptValue + ']').prop("checked", true);
 					  }
					  //새 글 기준 셋팅
					  if(key == "CM_MG_NEW_SET"){
						  $("input[name='cmMgNewSet']").val(iptValue);
					  }
					  //게시물 관리 순번 셋팅
					  if(key == "CM_MG_SQ"){
						  $("input[name='cmMgSq']").val(iptValue);
					  }
				 });
				 
	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
	
	/* 카멜 문자 변환 함수 */
	function toCamelCase(str) {
	  return str.toLowerCase().replace(/[^a-zA-Z0-9]+(.)/g, (m, chr) => chr.toUpperCase());
	}
	
	/* 게시판 정보 저장 */
	function commuManagementInfoUpdate(){ 
		
		var params = {
				cmMgSq : $('input[name="cmMgSq"]').val(),
				boardYn : getInputValue('cmMgShowYn'),
				cmMgOdDivCd : getInputValue('cmMgOdDivCd'),
				cmMgCmtYn : getInputValue('cmMgCmtYn'),
				cmMgRegdtYn : getInputValue('cmMgRegdtYn'),
				cmMgViewsYn : getInputValue('cmMgViewsYn'),
				cmMgScrapsYn : getInputValue('cmMgScrapsYn'),
				cmMgLikesYn : getInputValue('cmMgLikesYn'),
				cmMgSnsYn : getInputValue('cmMgSnsYn'),
				cmMgNewSet : getInputValue('cmMgNewSet')
				//readAuth : getInputValue('readAuth'),
				//writeAuth : getInputValue('writeAuth'),
				//commentAuth : getInputValue('commentAuth'),
				
		};
		
		$.ajax({
        	type: "POST",
    	 	url: "/admin/community/communityManagementSave",
         	data: params,
         	dataType: "json"
 	     }).done(function(response) {
 	    	console.log(params);
 	    	 alert('저장이 완료되었습니다.');
	     }).fail(function(response) {
	    	 alert('저장이 정상적으로 완료되지 않았습니다.');
	     });

	}
	
	/* input태그의 value값 얻어오기 */
	function getInputValue(inputName){
		return $('input[name="' + inputName + '"]:checked').val();
	}
	
	</script>

</body>
</html>
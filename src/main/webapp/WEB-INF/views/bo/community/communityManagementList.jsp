<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
	/**
		타입 :  자랑하기(BOA), 전시후기 소개(EXH), 노하우(KNO)
	*/
	String commuMenuTypCd = request.getParameter("commuMenuTypCd"); 
	
	String commuName = "";
	
	if(commuMenuTypCd == null || commuMenuTypCd == ""){
		commuName = "default";
	} else if(commuMenuTypCd.equals("BOA")) {
		commuName = "자랑하기"; 
	} else if(commuMenuTypCd.equals("EXH")) {
		commuName = "전시후기/소개"; 
	} else if(commuMenuTypCd.equals("KNO")) {
		commuName = "노하우";
	}

%>

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
									<th>권한(쓰기/읽기)</th>
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
						
						
						<%  if(commuName != "default") { %>
								
						<div class="card-header p-1" style="border-left: 5px solid blue; border-radius: 0">
		                 	<ul class="nav nav-pills">
			               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><h5><%=commuName%></h5></a></li>
			               	</ul>
				 		</div>
				 		
				 		<div class="card">
			    			<div class="card-header">
				               	<h6 class="card-title bTitle">게시판 정보</h6>
							</div>
							
							<input type="hidden" name="commuMenuTypCd" id="commuMenuTypCd" value="<%=commuMenuTypCd%>">
								
				                <!--card-body -->
				                <table class="table table-bordered">	                
									<tr class="col-form-label sTitle LabelStyle" >
										<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 표시여부</td>
										<td id="" class="col-sm-2 dataValue">
											<label><input type="radio" name="boardYn" value="Y">사용</label>
											<label><input type="radio" name="boardYn" value="N">사용 안함</label>
										</td>
									</tr>
									<tr class="col-form-label sTitle LabelStyle"  >
										<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 제목</td>
										<td id="" class="col-sm-2 dataValue"><%=commuName %></td>						
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
						  <% } %>
						  
		            </div>
    			</div>
	    			
	    	</section>
	    		
		 </div>
		
	</div>

	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
	
	<script>
	
	$(document).ready(function(){
		
		commuTypeList();
		
		if(!(commuMenuTypCd == null || commuMenuTypCd == '')){
			commuManagementInfoList();
		}
		
	});
	
	/* 게시판 관리 타입 리스트  */
	function commuTypeList(){
		
		var strHtml = 
			`<tr id align="center">
				<th><input type="checkbox"></th>
				<th>이미지</th>
				<th onclick="location.href='http://localhost/admin/community/communityManagement?commuMenuTypCd=getCommuMenuTypCd'">자랑하기</th>
				<th>1</th>
				<th>관리자/회원</th>
				<th>0 / 99</th>
				<th>
					<div class="noExl" style="text-align:left; display: inline;">
					<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="window.open('http://localhost/deal/soldoutDetail?SqNumber=651')">글보기 > </button>
					<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="window.open('http://localhost/admin/community/communityManagementNoticeUpdate\?comtTypCd=', '게시판 관리', 'width=800, height=180, scrollbars=no, resizeble=no')">공지글 > </button>
		            </div>
				</th>
				<th>표시여부</th>
			</tr>`;
		
		var commuMenuTypCd = getcommuMenuTypCd('메뉴이름 넣어주기');
		/*  for문 돌려서 replace적용하기 
			공지글 url에 get방식으로 ?게시판ID 같이 보내기 
			tr태그에 href 주소에 getCommuMenuTypCd값 치환시키기
		*/
		
		$('#boardTypeList').append(strHtml);
		
	}
	
	/* 게시판 정보 리스트 */
	function commuManagementInfoList(){
		/* 
			for문 돌려서 name값에 컬럼명 넣어주고 
		*/
		$("input:radio[name ='boardYn']:input[value='DB에서조회된 value값으로 치환하기']").attr("checked", true);
		
	}
	
	/* 게시판 정보 저장 */
	function commuManagementInfoUpdate(){ 
		
		var params = {
				cmMgSq : getInputValue('cmMgSq'),
				boardYn : getInputValue('boardYn'),
				cmMgOdDivCd : getInputValue('cmMgOdDivCd'),
				cmMgCmtYn : getInputValue('cmMgCmtYn'),
				cmMgRegdtYn : getInputValue('cmMgRegdtYn'),
				cmMgViewsYn : getInputValue('cmMgViewsYn'),
				cmMgScrapsYn : getInputValue('cmMgScrapsYn'),
				cmMgLikesYn : getInputValue('cmMgLikesYn'),
				cmMgSnsYn : getInputValue('cmMgSnsYn'),
				cmMgNewSet : getInputValue('cmMgNewSet'),
				readAuth : getInputValue('readAuth'),
				writeAuth : getInputValue('writeAuth'),
				commentAuth : getInputValue('commentAuth'),
		};
		
		$.ajax({
        	type: "POST",
    	 	url: "",
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
	
	/* 메뉴 로우의 코드값 얻기 */
	function getcommuMenuTypCd(commuMenuName){
		
		var commuMenuTypCd = '';
		
		if(commuMenuName == '자랑하기'){
			commuMenuTypCd = 'BOA';
		} else if(commuMenuTypCd == '전기후기/소개'){
			commuMenuTypCd = 'EXH';
		} else if(commuMenuTypCd == '노하우'){
			commuMenuTypCd = 'KNO';
		}
		return commuMenuTypCd;
	}
	
	</script>

</body>
</html>
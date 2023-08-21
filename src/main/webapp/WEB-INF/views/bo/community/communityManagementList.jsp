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
			<div class="content-header">
				<h4 class="text-bold">게시판 관리</h4>
			</div>
    		<section class="content">
    			<div class="card">
	    			<div class="card-body table-responsive p-0" style="height: auto;font-size:11px;">
						<table class="table table-bordered exportToExcel table-hover text-nowrap">
							<thead>
								<tr align="center" style="background-color:#efefef;">
									<th>게시판 제목</th>
									<th>게시판 ID</th>
									<th>권한(읽기/쓰기/댓글)</th>
									<th>새글/총갯수</th>
									<th>게시물 관리</th>
									<th>표시여부</th>
								</tr>
							</thead>
							<tbody id="boardTypeList">
								
							</tbody>
						</table>
				 		
		            </div>
    			</div>
	    	</section>
	    	<section class="content">
	    		<div id="dtlBox" hidden="true">
					<blockquote class="mx-0 mb-0">
						<p id="commuTitle" class="line-height-2 my-0"></p>
					</blockquote>
			 		<div class="card">
		    			<div class="card-header">
			               	<h6 class="card-title bTitle">게시판 정보</h6>
						</div>
						<div class="card-body table-responsive p-0">
							<input type="hidden" name="cmMgSq"/>
			                <!--card-body -->
			                <table class="table table-bordered">	                
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" style="background-color: #efefef;">게시판 표시여부</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="useYn1" name="useYn" value="Y">
											<label for="useYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="useYn2" name="useYn" value="N">
											<label for="useYn2" class="custom-control-label line-height-2">사용 안함</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" style="background-color: #efefef;">게시판 제목</td>
									<td id="commuName" class="col-sm-2 dataValue"></td>						
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-2" style="background-color: #efefef;">게시판 정렬 구분</td>
									<td id="" class="col-sm-10 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdDivCd1" name="cmMgOdDivCd" value="LIK">
											<label for="cmMgOdDivCd1" class="custom-control-label line-height-2">좋아요 수</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdDivCd2" name="cmMgOdDivCd" value="VIW">
											<label for="cmMgOdDivCd2" class="custom-control-label line-height-2">조회 수</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdDivCd3" name="cmMgOdDivCd" value="SCP">
											<label for="cmMgOdDivCd3" class="custom-control-label line-height-2">스크랩 수</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdDivCd4" name="cmMgOdDivCd" value="SNS">
											<label for="cmMgOdDivCd4" class="custom-control-label line-height-2">SNS공유 수</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdDivCd5" name="cmMgOdDivCd" value="REG">
											<label for="cmMgOdDivCd5" class="custom-control-label line-height-2">등록일</label>
										</div>
									</td>	
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" style="background-color: #efefef;">게시판 정렬 유형</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdTypCd1" name="cmMgOdTypCd" value="ASC">
											<label for="cmMgOdTypCd1" class="custom-control-label line-height-2">오름차순</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdTypCd2" name="cmMgOdTypCd" value="DES">
											<label for="cmMgOdTypCd2" class="custom-control-label line-height-2">내림차순</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgOdTypCd3" name="cmMgOdTypCd" value="ACC">
											<label for="cmMgOdTypCd3" class="custom-control-label line-height-2">누적순</label>
										</div>
									</td>	
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">댓글기능</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgCmtYn1" name="cmMgCmtYn" value="Y">
											<label for="cmMgCmtYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block">
											<input class="custom-control-input" type="radio" id="cmMgCmtYn2" name="cmMgCmtYn" value="N">
											<label for="cmMgCmtYn2" class="custom-control-label line-height-2">사용 안함</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">작성일 표시</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgRegDtYn1" name="cmMgRegDtYn" value="Y">
											<label for="cmMgRegDtYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgRegDtYn2" name="cmMgRegDtYn" value="N">
											<label for="cmMgRegDtYn2" class="custom-control-label line-height-2">사용 안함</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">조회수 표시</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgViewsYn1" name="cmMgViewsYn" value="Y">
											<label for="cmMgViewsYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgViewsYn2" name="cmMgViewsYn" value="N">
											<label for="cmMgViewsYn2" class="custom-control-label line-height-2">사용 안함</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">스크랩 수 표시</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgScrapsYn1" name="cmMgScrapsYn" value="Y">
											<label for="cmMgScrapsYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgScrapsYn2" name="cmMgScrapsYn" value="N">
											<label for="cmMgScrapsYn2" class="custom-control-label line-height-2">사용 안함</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">좋아요 수 표시</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgLikesYn1" name="cmMgLikesYn" value="Y">
											<label for="cmMgLikesYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgLikesYn2" name="cmMgLikesYn" value="N">
											<label for="cmMgLikesYn2" class="custom-control-label line-height-2">사용 안함</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">SNS 공유 표시</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgSnsYn1" name="cmMgSnsYn" value="Y">
											<label for="cmMgSnsYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgSnsYn2" name="cmMgSnsYn" value="N">
											<label for="cmMgSnsYn2" class="custom-control-label line-height-2">사용 안함</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">NEW 아이콘 설정</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="input-group input-group-sm align-items-center">
											등록 후
											<div class="col-sm-1">
												<input type="number" name="cmMgNewSet" class="form-control float-right bTitle">
											</div>
											시간 이내의 글
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">읽기 권한</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="readAuth0" name="readAuthSq" value="0">
											<label for="readAuth0" class="custom-control-label line-height-2">비회원</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="readAuth1" name="readAuthSq" value="1">
											<label for="readAuth1" class="custom-control-label line-height-2">컬렉터</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="readAuth2" name="readAuthSq" value="2">
											<label for="readAuth2" class="custom-control-label line-height-2">아티스트</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="readAuth3" name="readAuthSq" value="3">
											<label for="readAuth3" class="custom-control-label line-height-2">관리자</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="readAuth4" name="readAuthSq" value="4">
											<label for="readAuth4" class="custom-control-label line-height-2">전체관리자</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">쓰기 권한</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="writeAuth0" name="writeAuthSq" value="0">
											<label for="writeAuth0" class="custom-control-label line-height-2">비회원</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="writeAuth1" name="writeAuthSq" value="1">
											<label for="writeAuth1" class="custom-control-label line-height-2">컬렉터</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="writeAuth2" name="writeAuthSq" value="2">
											<label for="writeAuth2" class="custom-control-label line-height-2">아티스트</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="writeAuth3" name="writeAuthSq" value="3">
											<label for="writeAuth3" class="custom-control-label line-height-2">관리자</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="writeAuth4" name="writeAuthSq" value="4">
											<label for="writeAuth4" class="custom-control-label line-height-2">전체관리자</label>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle" >
									<td class="col-sm-1" style="background-color: #efefef;">댓글 권한</td>
									<td id="" class="col-sm-2 dataValue">
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="commentAuth0" name="cmtAuthSq" value="0">
											<label for="commentAuth0" class="custom-control-label line-height-2">비회원</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="commentAuth1" name="cmtAuthSq" value="1">
											<label for="commentAuth1" class="custom-control-label line-height-2">컬렉터</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="commentAuth2" name="cmtAuthSq" value="2">
											<label for="commentAuth2" class="custom-control-label line-height-2">아티스트</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="commentAuth3" name="cmtAuthSq" value="3">
											<label for="commentAuth3" class="custom-control-label line-height-2">관리자</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="commentAuth4" name="cmtAuthSq" value="4">
											<label for="commentAuth4" class="custom-control-label line-height-2">전체관리자</label>
										</div>
									</td>
								</tr>
			                </table>
						</div>
		                <div class="card-footer text-right bg-white">
		                	<button class="btn btn-primary" onclick="commuManagementInfoUpdate()" style="width: 100px;">저장</button>
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
				success: function(data) {
					// 글보기 url
					var url = {
						BOA: "/community/worksList", // 자랑하기
						EXH: "/community/exhintList", // 전시후기/소개
						ISS: "/community/issueList" // 이슈
					}
					
					// 표시 여부
					var useYnVal = {
						Y: "표시",
						N: "미표시"
					};
					
					// 권한(읽기/쓰기/댓글)
					var authVal = {
						0: "비회원",
						1: "컬렉터",
						2: "아티스트",
						3: "관리자",
						4: "전체관리자"
					}
					
					var strHtml = '';
					
					data.list.list.forEach(function(el, idx) {
						strHtml += '<tr align="center" class="cursor-pointer" onclick="manageDtl(\''+ el.comtTypCd +'\',\''+ el.dtlCdNm +'\',\''+ el.cmMgNm +'\')">';
						strHtml += '	<th>'+ el.cmMgNm +'</th>';	
						strHtml += '	<th>'+ el.cmMgSq +'</th>';
						strHtml += '	<th>'+ authVal[el.readAuthSq] + ' / ' + authVal[el.writeAuthSq] + ' / ' + authVal[el.cmtAuthSq] +'</th>';
						strHtml += '	<th>'+ el.cmMgNewCnt +' / '+ el.cmMgTotCnt +'</th>';
						strHtml += '	<th>';
						strHtml += '		<div class="noExl" style="text-align:left; display: inline;">';
						strHtml += '			<button class="btnCommunitySet btn btn-sm btn-primary" type="button" onclick="location.href=\''+ url[el.comtTypCd] +'\'">글보기 <span class="fa fa-caret-right"></span></button>';
						strHtml += '			<button class="btnCommunitySet btn btn-sm btn-primary" type="button" onclick="openNoticePop(\''+ el.comtTypCd +'\');">공지글 <span class="fa fa-caret-right"></span></button>';
						strHtml += '		</div>';
						strHtml += '	</th>';
						strHtml += '	<th>'+ useYnVal[el.useYn] +'</th>';
						strHtml += '</tr>';
					});
					
					$('#boardTypeList').append(strHtml);
	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
			});
		}
		
		function manageDtl(comtTypCd, dtlCdNm, cmMgNm) {
			//제목 및 영역 명 셋팅.
			$("#dtlBox").attr("hidden", false);
			$("#commuName").text(cmMgNm);
			$("#commuTitle").text(dtlCdNm);
			
			$.ajax({
				type: "post",
				url: "/admin/community/communityManagementDtlList",
				data: {
					comtTypCd : comtTypCd
				},
				success: function(data) {
					var dtlInfo = data.hashMap.dtlList;
					
					//표시여부 라디오 버튼 제어
					Object.keys(dtlInfo).forEach(function(key){
						var iptValue = dtlInfo[key];

						//표시 여부 셋팅
						if(key.indexOf("Yn") > -1 || key.indexOf("AuthSq") > -1 || key == "cmMgOdDivCd" || key == "cmMgOdTypCd") {
							$('input:radio[name='+ key +']input[value='+ iptValue +']').prop("checked", true);
						}
						//새 글 기준 셋팅
						if(key == "cmMgNewSet"){
							$("input[name='cmMgNewSet']").val(iptValue);
						}
						//게시물 관리 순번 셋팅
						if(key == "cmMgSq"){
							$("input[name='cmMgSq']").val(iptValue);
						}
					});
				},
				error: function(error) {
					var errorJson = JSON.stringify(error);
					console.log(errorJson);
				}
			});
		}
		
		/* 공지사항 팝업 열기 */
		function openNoticePop(comtTypCd) {
			var url = '/admin/community/communityManagementNoticeUpdate?comtTypCd='+ comtTypCd;
			var name = '게시판 관리';
			var option = 'width=800, height=180, scrollbars=no, resizeble=no';
			
			window.open(url, name, option);
		}
		
		/* 게시판 정보 저장 */
		function commuManagementInfoUpdate(){
			var params = {
				cmMgSq : $('input[name="cmMgSq"]').val(),
				useYn : getInputValue('useYn'),
				cmMgOdDivCd : getInputValue('cmMgOdDivCd'),
				cmMgOdTypCd : getInputValue('cmMgOdTypCd'),
				cmMgCmtYn : getInputValue('cmMgCmtYn'),
				cmMgRegDtYn : getInputValue('cmMgRegDtYn'),
				cmMgViewsYn : getInputValue('cmMgViewsYn'),
				cmMgScrapsYn : getInputValue('cmMgScrapsYn'),
				cmMgLikesYn : getInputValue('cmMgLikesYn'),
				cmMgSnsYn : getInputValue('cmMgSnsYn'),
				cmMgNewSet : $("input[name=cmMgNewSet]").val(),
				readAuthSq : getInputValue('readAuthSq'),
				writeAuthSq : getInputValue('writeAuthSq'),
				cmtAuthSq : getInputValue('cmtAuthSq'),
			};
			
			var isConfirm = confirm("게시판 정보를 저장하시겠습니까?");
			
			if(isConfirm) {
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
		}
		
		/* input태그의 value값 얻어오기 */
		function getInputValue(inputName){
			return $('input[name="' + inputName + '"]:checked').val();
		}
	</script>
</body>
</html>
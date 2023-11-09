<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>


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
												<label><input type="radio" name="useYn" value="Y" id="useYn1" checked="checked">사용</label>
												<label><input type="radio" name="useYn" value="N" id="useYn2">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle"  >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 제목</td>
											<td id="commuName" class="col-sm-2 dataValue"></td>						
										</tr>
										
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 정렬 방식</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgOdDivCd" value="REG" id="cmMgOdDivCd1" checked="checked">등록순 정렬</label>
												<label><input type="radio" name="cmMgOdDivCd" value="LIK" id="cmMgOdDivCd2">좋아요 많은순 정렬</label>
												<label><input type="radio" name="cmMgOdDivCd" value="VIW" id="cmMgOdDivCd3">조회수 많은순 정렬</label>
											</td>	
										</tr>
										<!-- <tr class="col-form-label sTitle LabelStyle" name="pageViewCnt">
											<td class="col-sm-1" align="center" style="background-color: #efefef;">페이지 표시 수</td>
											<td id="" class="col-sm-2 dataValue">
												<div class="input-group input-group-sm">
													
													<input type="number" name="comtTypCdExh" class="form-control float-right bTitle">
													
												</div>
											</td>
										</tr> -->
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">댓글기능</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgCmtYn" id="cmMgCmtYn1" value="Y" checked="checked">사용
												<input type="radio" name="cmMgCmtYn" id="cmMgCmtYn2" value="N">사용 안함</label>
											</td>
										</tr>
										
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">작성일 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgRegdtYn" id="cmMgRegdtYn1" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgRegdtYn"id="cmMgRegdtYn2"  value="N">사용 안함</label>
											</td>
										</tr>
										
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">조회수 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgViewsYn" id="cmMgViewsYn1" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgViewsYn" id="cmMgViewsYn2" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">스크랩 수 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgScrapsYn" id="cmMgScrapsYn1" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgScrapsYn" id="cmMgScrapsYn2" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">좋아요 수 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgLikesYn" id="cmMgLikesYn1" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgLikesYn" id="cmMgLikesYn2" value="N">사용 안함</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">SNS 공유 표시</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmMgSnsYn" id="cmMgSnsYn1" value="Y" checked="checked">사용</label>
												<label><input type="radio" name="cmMgSnsYn" id="cmMgSnsYn2" value="N">사용 안함</label>
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
												<label><input type="radio" name="readAuthSq" id="readAuthSq1" value="3" checked="checked">관리자</label>
												<label><input type="radio" name="readAuthSq" id="readAuthSq2" value="1">회원이상</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">쓰기 권한</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="writeAuthSq" id="writeAuthSq1" value="3" checked="checked">관리자</label>
												<label><input type="radio" name="writeAuthSq" id="writeAuthSq2" value="1">회원이상</label>
											</td>
										</tr>
										<tr class="col-form-label sTitle LabelStyle" >
											<td class="col-sm-1" align="center" style="background-color: #efefef;">댓글 권한</td>
											<td id="" class="col-sm-2 dataValue">
												<label><input type="radio" name="cmtAuthSq" id="cmtAuthSq1" value="3" checked="checked">관리자</label>
												<label><input type="radio" name="cmtAuthSq" id="cmtAuthSq2" value="1">회원이상</label>
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
											<input class="custom-control-input" type="radio" id="cmMgRegdtYn1" name="cmMgRegDtYn" value="Y">
											<label for="cmMgRegdtYn1" class="custom-control-label line-height-2">사용</label>
										</div>
										<div class="custom-control custom-radio d-inline-block pr-2">
											<input class="custom-control-input" type="radio" id="cmMgRegdtYn2" name="cmMgRegDtYn" value="N">
											<label for="cmMgRegdtYn2" class="custom-control-label line-height-2">사용 안함</label>
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
	           data: {},
	           success: function(data) {
	        	   
	        	   data.list.list.forEach(function(ele, idx){
	        		         	console.log(data.list.list);
        			   var strHtml = '<tr id align="center">';
	        			//strHtml += '<th><input type="checkbox"></th>';
	        			strHtml += '<th>' + ele.dtlCdNm + '</th>';
	        			strHtml += '<th onclick="manageDtl(\''+ ele.comtTypCd + '\',\'' + ele.dtlCdNm +'\',\'' + ele.cmMgNm + '\')">' + ele.cmMgNm + '</th>';	

	        			//권한 구분
	        			if(ele.readAuthSq == 1){
	        				strHtml += '<th>회원/';
	        			}else if(ele.readAuthSq == 2){
	        				strHtml += '<th>작가/';
	        			}else if(ele.readAuthSq == 3){
	        				strHtml += '<th>관리자/';
	        			}
	        			if(ele.writeAuthSq == 1){
	        				strHtml += '회원/';
	        			}else if(ele.writeAuthSq == 2){
	        				strHtml += '작가/';
	        			}else if(ele.writeAuthSq == 3){
	        				strHtml += '관리자/';
	        			}
	        			if(ele.cmtAuthSq == 1){
	        				strHtml += '회원</th>';
	        			}else if(ele.cmtAuthSq == 2){
	        				strHtml += '작가</th>';
	        			}else if(ele.cmtAuthSq == 3){
	        				strHtml += '관리자</th>';
	        			}
	        			
	        			strHtml += '<th>' + ele.cmMgNewCnt + ' / ' + ele.cmMgTotCnt + '</th>';
	        			strHtml += '<th><div class="noExl" style="text-align:left; display: inline;">';
	        			
	        		 	if(ele.comtTypCd == "BOA"){
	        		 		strHtml += '<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="window.open(\'https://www.dealing-art.com/community/worksList?comtTypCd=\''+ele.comtTypCd+'\'\')">글보기 > </button>';
	        			}else if(ele.comtTypCd == "EXH"){
	        				strHtml += '<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="window.open(\'https://www.dealing-art.com/community/exhintList?comtTypCd=\''+ele.comtTypCd+'\'\')">글보기 > </button>';
	        			}else if(ele.comtTypCd == "ISS"){
	        				strHtml += '<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="window.open(\'https://www.dealing-art.com/community/issueList?comtTypCd=\''+ele.comtTypCd+'\'\'\')">글보기 > </button>';
	        			}
	        			
	        			
	        			strHtml += '<button class="btnCommunitySet" type="button" style="border: 1px solid grey; height: 25px;" onclick="fn_openRegNoti(\''+ele.comtTypCd+'\')">공지글 > </button>';
	        			strHtml += '</div></th>';
	        			
	        			if(ele.useYn == "Y"){
	        				strHtml += '<th>표시</th>';	
	        			}else{
	        				strHtml += '<th>미표시</th>';	
	        			}
	        			
	        			strHtml += '</tr>';
	        			strHtml += '';
	        		  	
	        			if(idx == 0){
	        				$('#boardTypeList').html(strHtml);
	        			}else{
	        				$('#boardTypeList').append(strHtml);
	        			}	        		   	        		         		   
	        			
	        	   });
	           }
		});
	}
	
	//디비 저장을 위한 시퀀스 부여
	var cmMgSq = 0;
	
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
					  
					  //게시판 사용 여부 세팅
					  if(key == "useYn"){
						  if (iptValue == "Y"){
							  $("#useYn1").prop("checked", true);
						  }else if(iptValue == "N"){
							  $("#useYn2").prop("checked", true);
						  }
					  }				     				  
					 //정렬 방식 셋팅
					  if(key == "cmMgOdDivCd"){
						  if (iptValue == "REG"){
							  $("#cmMgOdDivCd1").prop("checked", true);
						  }else if(iptValue == "LIK"){
							  $("#cmMgOdDivCd2").prop("checked", true);  
						  }else if(iptValue == "VIW"){
							  $("#cmMgOdDivCd3").prop("checked", true);
						  }  					 
					  }
					  //댓글기능 사용 여부 세팅
					  if(key == "cmMgCmtYn"){
						  if (iptValue == "Y"){
							  $("#cmMgCmtYn1").prop("checked", true);
						  }else if(iptValue == "N"){
							  $("#cmMgCmtYn2").prop("checked", true);
						  }
					  }
					  //작성일 표시 사용 여부 세팅
					  if(key == "cmMgRegDtYn"){
						  if (iptValue == "Y"){
							  $("#cmMgRegdtYn1").prop("checked", true);
						  }else if(iptValue == "N"){
							  $("#cmMgRegdtYn2").prop("checked", true);
						  }
					  }
					  //조회수 표시 사용 여부 세팅
					  if(key == "cmMgViewsYn"){
						  if (iptValue == "Y"){
							  $("#cmMgViewsYn1").prop("checked", true);
						  }else if(iptValue == "N"){
							  $("#cmMgViewsYn2").prop("checked", true);
						  }
					  }
					  //스크랩 수 표시 사용 여부 세팅
					  if(key == "cmMgScrapsYn"){
						  if (iptValue == "Y"){
							  $("#cmMgScrapsYn1").prop("checked", true);
						  }else if(iptValue == "N"){
							  $("#cmMgScrapsYn2").prop("checked", true);
						  }
					  }
					  //좋아요 수 표시 사용 여부 세팅
					  if(key == "cmMgLikesYn"){
						  if (iptValue == "Y"){
							  $("#cmMgLikesYn1").prop("checked", true);
						  }else if(iptValue == "N"){
							  $("#cmMgLikesYn2").prop("checked", true);
						  }
					  }
					  //SNS 공유 표시 사용 여부 세팅
					  if(key == "cmMgSnsYn"){
						  if (iptValue == "Y"){
							  $("#cmMgSnsYn1").prop("checked", true);
						  }else if(iptValue == "N"){
							  $("#cmMgSnsYn2").prop("checked", true);
						  }
					  }
					 
					  //게시판 관리 NEW 설정
					  if(key == "cmMgNewSet"){
						  $("input[name='cmMgNewSet']").val(iptValue);
					  }
					 
					  //읽기 권한 세팅
					  if(key == "readAuthSq"){
						  if (iptValue == "3"){
							  $("#readAuthSq1").prop("checked", true);
						  }else if(iptValue == "1"){
							  $("#readAuthSq2").prop("checked", true);
						  }
 					  }
					  //읽기 권한 세팅
					  if(key == "writeAuthSq"){
						  if (iptValue == "3"){
							  $("#writeAuthSq1").prop("checked", true);
						  }else if(iptValue == "1"){
							  $("#writeAuthSq2").prop("checked", true);
						  }
 					  }
					  //읽기 권한 세팅
					  if(key == "cmtAuthSq"){
						  if (iptValue == "3"){
							  $("#cmtAuthSq1").prop("checked", true);
						  }else if(iptValue == "1"){
							  $("#cmtAuthSq2").prop("checked", true);
						  }
 					  }
					  //디비 저장을 위한 시퀀스 벨류값 받아놓기
					  if(key == "cmMgSq"){
                          $("input[name='cmMgSq']").val(iptValue);
                      }
					  //iptValue = "";
					  
				 });
				 
	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
	           
	         /*   function dtlInfoDetail(dtlInfo) {
	        	   location.href = '/deal/soldoutDetail?SqNumber=' + dtlInfo[j].cmMgSq
	           } */
		})
	}
	
	/* 카멜 문자 변환 함수 */
	function toCamelCase(str) {
	  return str.toLowerCase().replace(/[^a-zA-Z0-9]+(.)/g, (m, chr) => chr.toUpperCase());
	}	
		
		
	/* 공지사항 팝업 열기 */
	function openNoticePop(comtTypCd) {
		var url = '/admin/community/communityManagementNoticeUpdate?comtTypCd='+ comtTypCd;
		var name = '게시판 관리';
		var option = 'width=800, height=180, scrollbars=no, resizeble=no';
		
		window.open(url, name, option);
	};
	
	/* 게시판 정보 저장 */
	function commuManagementInfoUpdate(){
		var params = {
			
			cmMgSq : $('input[name="cmMgSq"]').val(),
			useYn : getInputValue('useYn'),
			cmMgOdDivCd : getInputValue('cmMgOdDivCd'),
			cmMgOdTypCd : getInputValue('cmMgOdTypCd'),
			cmMgCmtYn : getInputValue('cmMgCmtYn'),
			cmMgRegdtYn : getInputValue('cmMgRegdtYn'),
			cmMgViewsYn : getInputValue('cmMgViewsYn'),
			cmMgScrapsYn : getInputValue('cmMgScrapsYn'),
			cmMgLikesYn : getInputValue('cmMgLikesYn'),
			cmMgSnsYn : getInputValue('cmMgSnsYn'),
			cmMgNewSet : $('input[name="cmMgNewSet"]').val(),
			useYn : getInputValue('useYn'),
			readAuthSq : getInputValue('readAuthSq'),
			writeAuthSq : getInputValue('writeAuthSq'),
			cmtAuthSq : getInputValue('cmtAuthSq'),					
		};			
		var isConfirm = confirm("게시판 정보를 저장하시겠습니까?");
		console.log(cmMgSq);
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
	
	// 공지글 등록 화면 OPEN 함수
	function fn_openRegNoti(comtTypCd){
		//window.open("https://www.dealing-art.com/admin/community/communityManagementNoticeUpdate\?comtTypCd=\'"+comtTypCd+"\'");
		window.open( "http://localhost/admin/community/communityManagementNoticeUpdate\?comtTypCd="+comtTypCd+""
				   , "게시판 관리"
				   , "width=800,height=130,scrollbars=no,resizeble=no");
	}
	</script>
</body>
</html>
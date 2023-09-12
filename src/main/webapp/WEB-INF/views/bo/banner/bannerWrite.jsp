<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<style type="text/css">
input[readonly].classname {
	background-color: #ffffff;
}

.LabelStyle {
	background-color: #efefef;
	width: 100px;
}

.dataValue {
	background-color: #ffffff;
}

.image_containerPc label {
	display: inline-block;
	padding: 10px 20px;
	color: #fff;
	vertical-align: middle;
	background-color: #999999;
	cursor: pointer;
	height: 40px;
	margin-left: 10px;
}

.image_containerM label {
	display: inline-block;
	padding: 10px 20px;
	color: #fff;
	vertical-align: middle;
	background-color: #999999;
	cursor: pointer;
	height: 40px;
	margin-left: 10px;
}

input[type="file"] {
	position: absolute;
	width: 0;
	height: 0;
	padding: 0;
	overflow: hidden;
	border: 0;
}

.image-boxPc {
	object-fit: contain;
	display: block;
	margin: 20px auto;
	height: 200px;
	width: 100%;
}

.image-boxM {
	object-fit: contain;
	display: block;
	margin: 20px auto;
	height: 200px;
	width: 100%;
}

.image-boxPc2 {
	height: 200px;
	object-fit: contain;
	display: block;
	margin: 20px auto;
	height: 200px;
	width: 100%;
}

.image-boxM2 {
	height: 200px;
	object-fit: contain;
	display: block;
	margin: 20px auto;
	width: 100%;
}
</style>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		<div class="content-wrapper">
			<section class="content">
				<div class="card-header "
					style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
					<ul class="nav nav-pills">
						<li class="nav-item"><a class="sTitle" href="#"
							data-toggle="tab"> <b>배너등록</b></a></li>
					</ul>
				</div>
				<div class="card">
					<div class="card-body" style="background-color: #ffffff;">
						<div class="card-header p-2"
							style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
							<ul class="nav nav-pills">
								<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>배너목록</b></a></li>
							</ul>
						</div>
						<!-- 폼 -->
						<form action="" enctype="multipart/form-data" method="post"
							onSubmit="return submitCheck1();">
							<table class="table table-bordered">
								<tbody>
									<tr class="col-form-label sTitle LabelStyle">
										<td class="col-sm-1" align="center">기간</td>
										<td id="" class="col-sm-4 dataValue">
										<input type="date" id="bnnStrtDt"> ~ <input type="date" id="bnnEndDt"></td>
									</tr>
									<tr class="col-form-label sTitle LabelStyle">
										<td class="col-sm-1" align="center">분류</td>
										<td id="" class="col-sm-2 dataValue">
											<div class="col-sm-5">
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a1" name="bnnDivCd" value="MIH">
													<label for="a1" class="col-form-label sTitle">메인페이지 홈</label>
												</div>
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a2" name="bnnDivCd" value="CMH">
													<label for="a2" class="col-form-label sTitle">커뮤니티 홈</label>
												</div>
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a3" name="bnnDivCd" value="MGH">
													<label for="a3" class="col-form-label sTitle">Mgz9 홈</label>
												</div>
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a4" name="bnnDivCd" value="EVH">
													<label for="a4" class="col-form-label sTitle">이벤트 홈</label>
												</div>
											</div>
										</td>
									</tr>
									<tr class="col-form-label sTitle LabelStyle">
										<td class="col-sm-1" align="center">제목</td>
										<td id="" class="col-sm-2 dataValue">
											<input type="Text" style="width: 50%" id="bnnTitle">
										</td>
									</tr>
								</tbody>
							</table>

							<!--필수 메인이미지는 항상보여야함 -->
							<div id="mainimg" style="display: none">
								<div class="card-header p-2"
									style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
									<ul class="nav nav-pills">
										<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>배너 설정</b></a></li>
									</ul>
								</div>

								<div class="card-body" style="background-color: #ffffff;">

									<div class="imgboxtest" style="min-height: 100px">
										<!-- 매거진일 때 매거진 선택 -->
										<div class="bannerNumber" style="height: 50px;" id="mgzbannerlist">
											<!-- <div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mgzNum" value="1">
												<label for="imgNumber" class="col-form-label sTitle">인사이트</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mgzNum" value="2">
												<label for="imgNumber" class="col-form-label sTitle">미디어</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mgzNum" value="3">
												<label for="imgNumber" class="col-form-label sTitle">Exhibition</label>
											</div> -->
										</div>
										<!-- 메인일 때 -->
										<div class="bannerNumber" style="height: 50px;" id="mainbannerlist">
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="1">
												<label for="imgNumber" class="col-form-label mTitle">배너 1번</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="2">
												<label for="imgNumber" class="col-form-label mTitle">배너 2번</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="3">
												<label for="imgNumber" class="col-form-label mTitle">배너 3번</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="4">
												<label for="imgNumber" class="col-form-label mTitle">배너 4번</label>
											</div>
										</div>
										
										<div class="imgboxtest1" style="width: 45%; display: inline-block; min-height: 50px;">
											<label class="col-form-label" style="text-align: center;">메인 배너 (PC)</label>
											<div class="flex-container">

												<div class="wrapper">
													<img src="/resources/img/icon/pic.png" class="image-boxPc" id="image-boxPc" />
													<label for="bnnMpImgUrl" class="btn btn-info sTitle">
														<input id="bnnMpImgUrl" type="file" accept="image/*" />
														<span>등록</span>
													</label>
												</div>
											</div>
										</div>
										<div class="imgboxtest2" style="width: 45%; display: inline-block; min-height: 50px;">
											<label class="col-form-label" style="text-align: center;">메인 배너 (MOBILE)</label>
	
											<div class="flex-container">
												<div class="wrapper">
													<img src="/resources/img/icon/pic.png" class="image-boxM" id="image-boxM"> 
													<label for="bnnMmImgUrl" class="btn btn-info sTitle"> 
														<input id="bnnMmImgUrl" type="file" accept="image/*"/>
														<span>등록</span>
													</label>
												</div>
											</div>
										</div>
										<div>
											<label class="col-form-label" style="text-align: center;">메인 배너 랜딩 페이지 URL</label>
											<input type="text" id="bnnMLndUrl" style="width:50%;">
										</div>
									</div>
								</div>
								
								<!-- 이벤트 배너 커뮤니티/매거진일때만 -->
								<div id="subimg" style="display: none;">
									<div class="card-header p-2" style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
										<ul class="nav nav-pills">
											<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>이벤트 배너 설정</b></a></li>
										</ul>
									</div>
									<div class="card-body" style="background-color: #ffffff;">

										<div class="imgboxtest" style="min-height: 100px">
											<div class="imgboxtest1" style="width: 45%; display: inline-block; min-height: 50px;">
												<label class="col-form-label" style="text-align: center;">이벤트 배너 (PC)</label>
												<div class="flex-container">

													<div class="wrapper">
														<img src="/resources/img/icon/pic.png" class="image-boxPc2" id="image-boxPc2" /> 
														<label for="bnnEpImgUrl" class="btn btn-info sTitle">
															<input id="bnnEpImgUrl" type="file" accept="image/*"/>
															<span>등록</span>
														</label>
													</div>

												</div>
											</div>
											<div class="imgboxtest2" style="width: 45%; display: inline-block; min-height: 50px;">
											<label class="col-form-label" style="text-align: center;">이벤트 배너 (MOBILE)</label>
	
												<div class="flex-container">
													<div class="wrapper">
														<img src="/resources/img/icon/pic.png" class="image-boxM2" id="image-boxM2"> 
														<label for="bnnEmImgUrl" class="btn btn-info sTitle">
															<input id="bnnEmImgUrl" type="file" accept="image/*"/> 
															<span>등록</span>
														</label>
													</div>
	
												</div>
											</div>
											
											<div>
												<label class="col-form-label" style="text-align: center;">이벤트 배너 랜딩 페이지 URL</label>
												<input name="bnnELndUrl" id="bnnELndUrl" type="text" style="width:50%;">
											</div>
												
										</div>
									</div>
								</div>
								<!-- 이벤트일때만 -->
								<div id="evtboardlist" style="display: none;">
									<div style="text-align: center">
										<button type="button" class="btn btn-info sTitle">추가</button>
									</div>

									<div>

										<div class="input-group input-group-sm"
											style="width: 200px; float: right; right: 15px;">


											<select class="custom-select bTitle" id="searchGubun">
												<option value="">10개씩 보기</option>
												<option value="mbrNm">20개씩 보기</option>
												<option value="mbrId">30개씩 보기</option>
												<option value="mbrNcknm">50개씩 보기</option>
												<option value="mbrNcknm">100개씩 보기</option>
											</select>
											<!-- jsgird테스트  -->


										</div>

										<div class="card-body table-responsive p-0"
											style="height: 300px; font-size: 11px;">

											<table class="table table-bordered">
												<thead>
													<tr align="center" style="background-color: #efefef">
														<th>선택</th>
														<th>순서</th>
														<th>제목</th>
														<th>등록인</th>
														<th>기간</th>
														<th>등록일</th>
														<th>미리보기</th>
													</tr>
												</thead>
												<tbody id="dataList">

												</tbody>
											</table>
										</div>
									</div>

								</div>
							</div>


							<div class="card-header p-2"
								style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
								<ul class="nav nav-pills">
									<li class="nav-item"><a class="sTitle" href="#"
										data-toggle="tab"><b>프로모션 영역 출력 설정</b></a></li>
								</ul>
							</div>

							<!-- 탭마다 프로모션 보여주기-->
							<div class="card-body" style="background-color: #ffffff;">
								<!-- 메인프로모션 -->
								<div id="mainlist" style="display: none">
									<table class="table table-bordered">
										<tbody>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">회원들의 작품 자랑하기</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MIH1_DIV_CD">
															<option value="">-선택-</option>												    
														    <option value="REG">등록일</option>
														    <option value="VIW">조회수</option>
														    <option value="LIK">좋아요수</option>
														    <option value="SCP">스크랩수</option>
														    <option value="CMT">댓글수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MIH1_TYP_CD">
															<option value="">-선택-</option>												    
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">지금 거래중인 작품</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MIH2_DIV_CD">
															<option value="">-선택-</option>												    
														    <option value="REG">등록일</option>
														    <option value="CLO">마감일</option>
														    <option value="PRC">가격</option>
														    <option value="BID">응찰수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MIH2_TYP_CD">
															<option value="">-선택-</option>											    
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">매거진 9</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MIH3_DIV_CD">
															<option value="">-선택-</option>										    
														    <option value="REG">등록일</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MIH3_TYP_CD">
															<option value="">-선택-</option>								    
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>

											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">인기회원</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MIH4_DIV_CD">
															<option value="">-선택-</option>									    
														    <option value="FLO">팔로잉</option>
														    <option value="VIW">조회수</option>
														    <option value="LIK">좋아요수</option>
														    <option value="SCP">스크랩수</option>
														    <option value="CMT">댓글수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MIH4_TYP_CD">
															<option value="">-선택-</option>									    
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">전시 후기/소개</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MIH5_DIV_CD">
															<option value="">-선택-</option>								    
														    <option value="REG">등록일</option>
														    <option value="VIW">조회수</option>
														    <option value="LIK">좋아요수</option>
														    <option value="SCP">스크랩수</option>
														    <option value="CMT">댓글수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MIH5_TYP_CD">
															<option value="">-선택-</option>									    
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- 커뮤니티홈 -->
								<div id="commulist" style="display: none">
									<table class="table table-bordered">
										<tbody>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">이주의 인기 작품 자랑</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="CMH1_DIV_CD">
															<option value="">-선택-</option>								    
														    <option value="REG">등록일</option>
														    <option value="VIW">조회수</option>
														    <option value="LIK">좋아요수</option>
														    <option value="SCP">스크랩수</option>
														    <option value="CMT">댓글수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="CMH1_TYP_CD">												    
														    <option value="">-선택-</option>
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">자랑하기 고수</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="CMH2_DIV_CD">												    
														    <option value="">-선택-</option>
														    <option value="REG">등록일</option>
														    <option value="VIW">조회수</option>
														    <option value="LIK">좋아요수</option>
														    <option value="SCP">스크랩수</option>
														    <option value="CMT">댓글수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="CMH2_TYP_CD">												    
														    <option value="">-선택-</option>
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">전기 후기/소개</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="CMH3_DIV_CD">												    
														    <option value="">-선택-</option>
														    <option value="REG">등록일</option>
														    <option value="VIW">조회수</option>
														    <option value="LIK">좋아요수</option>
														    <option value="SCP">스크랩수</option>
														    <option value="CMT">댓글수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="CMH3_TYP_CD">												    
														    <option value="">-선택-</option>
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>

											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">이슈</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="CMH4_DIV_CD">												    
														    <option value="">-선택-</option>
														    <option value="REG">등록일</option>
														    <option value="VIW">조회수</option>
														    <option value="LIK">좋아요수</option>
														    <option value="SCP">스크랩수</option>
														    <option value="CMT">댓글수</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="CMH4_TYP_CD">												    
														    <option value="">-선택-</option>
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- 매거진프로모션 -->
								<div id="mgzlist" style="display: none">
									<table class="table table-bordered">
										<tbody>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">인기 인사이트</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MGH1_DIV_CD">												    
														    <option value="">-선택-</option>
														    <option value="REG">등록일</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MGH1_TYP_CD">												    
														    <option value="">-선택-</option>
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">새로운 아티스트 영상</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MGH2_DIV_CD">												    
														    <option value="">-선택-</option>
														    <option value="REG">등록일</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MGH2_TYP_CD">												    
														    <option value="">-선택-</option>
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">아티스트 업데이트</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<select id="MGH3_DIV_CD">												    
														    <option value="">-선택-</option>
														    <option value="REG">등록일</option>
														</select>
													</div>
													<div style="padding-left: 10px; float: left;">
														<select id="MGH3_TYP_CD">												    
														    <option value="">-선택-</option>
														    <option value="ASC">오름차순</option>
														    <option value="DES">내림차순</option>
														</select>
													</div>
												</td>
											</tr>
										</tbody>
									</table>

								</div>
								<!-- 이벤트프로모션 -->
								<!-- <div id="eventlist" style="display: none">
									<table class="table table-bordered">
										<tbody>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">이미지 리사이징</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<label for="a3" class="col-form-label sTitle">첨부
															이미지 파일의 폭이</label><input type="text" style="width: 50px"><label
															for="a3" class="col-form-label sTitle">를 초과하면
															리사이징 하여 표시합니다</label>
													</div>
												</td>
											</tr>

										</tbody>
									</table>
								</div> -->

							</div>
							<div class="card-body"
								style="background-color: #ffffff; text-align: center;">
								<button type="button" class="btn btn-info sTitle" onClick="bannerInsert();">저장</button>
<!-- 								<button type="button" class="btn btn-info sTitle">수정</button>
								<button type="button" class="btn btn-info sTitle">삭제</button> -->
								<button type="button" class="btn btn-info sTitle" onClick="openPopup();" value="Send Value">미리보기</button>

							</div>
						</form>
					</div>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
	<script>
	var bnnDivCd = "";
	//탭메뉴 변경 (따로 보여줘야 하는게 많음음)
	$('input[type=radio][name=bnnDivCd]').change(function() {
		if (this.value == 'MIH') { //메인홈으로 보낼 때 
			bnnDivCd = "MIH";
			$("#mainimg").css("display", "block");
			$("#mainbannerlist").css("display", "block");//메인배너 선택
			$("#subimg").css("display", "none");//서브배너
			$("#mgzbannerlist").css("display", "none");//매거진배너 선택
			$("#evtboardlist").css("display", "none");//이벤트리스트불러오기
			$("#mainlist").css("display", "block");//메인프로모션
			$("#commulist").css("display", "none");//이벤트프로모션
			$("#mgzlist").css("display", "none");//매거진프로모션
			$("#eventlist").css("display", "none");//이벤트프로모션
			$('#bnnStrtDt').val('');
		} else if (this.value == 'CMH') {
			bnnDivCd = "CMH";
			$("#mainimg").css("display", "block");
			$("#mainbannerlist").css("display", "none");//메인배너 선택
			$("#subimg").css("display", "block");//서브이미지
			$("#mgzbannerlist").css("display", "none");//매거진배너 선택
			$("#evtboardlist").css("display", "none");//이벤트리스트불러오기
			$("#mainlist").css("display", "none");//메인프로모션
			$("#commulist").css("display", "block");//이벤트프로모션
			$("#mgzlist").css("display", "none");//매거진프로모션
			$("#eventlist").css("display", "none");//이벤트프로모션
		} else if (this.value == 'MGH') {
			tabTypeCd = "MGH";
			$("#mainimg").css("display", "block");
			$("#mainbannerlist").css("display", "none");//메인배너 선택
			$("#subimg").css("display", "block");//서브이미지
			$("#mgzbannerlist").css("display", "block");//매거진배너 선택
			$("#evtboardlist").css("display", "none");//이벤트리스트불러오기
			$("#mainlist").css("display", "none");//메인프로모션
			$("#commulist").css("display", "none");//이벤트프로모션
			$("#mgzlist").css("display", "block");//매거진프로모션
			$("#eventlist").css("display", "none");//이벤트프로모션
		} else if (this.value == 'EVH') {
			bnnDivCd = "EVH";
			$("#mainimg").css("display", "block");
			$("#mainbannerlist").css("display", "none");//메인배너 선택
			$("#subimg").css("display", "none");//서브이미지
			$("#mgzbannerlist").css("display", "none");//매거진배너 선택
			$("#evtboardlist").css("display", "block");//이벤트리스트불러오기
			$("#mainlist").css("display", "none");//메인프로모션
			$("#commulist").css("display", "none");//이벤트프로모션
			$("#mgzlist").css("display", "none");//매거진프로모션
			$("#eventlist").css("display", "block");//이벤트프로모션
		}

	});
	
	var filePc = document.getElementById(".image-boxPc");
	var fileM = document.getElementById(".image-boxM");//바꿀때 src 리셋해줘야함
	
	
// 	이미지 미리보기
	const fileDOM = document.querySelector('#bnnMpImgUrl');
	const previews = document.querySelectorAll('.image-boxPc');	
	const fileDOM2 = document.querySelector('#bnnMmImgUrl');
	const previews2 = document.querySelectorAll('.image-boxM');
	
	const fileDOM3 = document.querySelector('#bnnEpImgUrl');
	const previews3 = document.querySelectorAll('.image-boxPc2');	
	const fileDOM4 = document.querySelector('#bnnEmImgUrl');
	const previews4 = document.querySelectorAll('.image-boxM2');

// 메인 PC미리보기
	fileDOM.addEventListener('change', () => {
	  	const reader = new FileReader();
	 	reader.onload = ({ target }) => {
	 		 previews[0].src = target.result;
	 	 };
	  	reader.readAsDataURL(fileDOM.files[0]);
	});
//메인 Mobie 미리보기	
	fileDOM2.addEventListener('change', () => {
		const reader = new FileReader();
		reader.onload = ({ target }) => {
		    previews2[0].src = target.result;
		  };
		reader.readAsDataURL(fileDOM2.files[0]);
	});
	
	
// 서브 PC미리보기
	fileDOM3.addEventListener('change', () => {
		const reader = new FileReader();
		reader.onload = ({ target }) => {
			previews3[0].src = target.result;
	  };
		reader.readAsDataURL(fileDOM3.files[0]);
	});
	
//서브Mobie 미리보기	
	fileDOM4.addEventListener('change', () => {
		  const reader = new FileReader();
		  reader.onload = ({ target }) => {
		    previews4[0].src = target.result;
		  };
		  reader.readAsDataURL(fileDOM4.files[0]);
	});
	
	
	
//미리보기 팝업
 function openPopup(){

	var imgNum2 = $("input[name='sendimg']").val();
	console.log("메인 배너순서값 확인"+ imgNum2);
	
	var bnrTypCd = $("input[name='bnrTypCd']:checked").val();
 	var brMnPcimgUrl  = document.getElementById("image-boxPc").src;//pc이미지
 	var brMnMimgUrl  = document.getElementById("image-boxM").src; //moble이미지
 	var brMnRUrl = $("#brMnRUrl").val();//랜딩Url주소
	
 	var brSubPcimgUrl  = document.getElementById("image-boxPc2").src;//pc이미지
 	var brSubMimgUrl  = document.getElementById("image-boxM2").src; //moble이미지
 	var brSubRUrl = $("#brSubRUrl").val();//랜딩Url주소
 		
	}

//벨리데이션 체크
 function insertCheck() {
	
 	if($("#bnnStrtDt").val() == "" || $("#bnnStrtDt").val() == null){
 		alert("배너 시작일을 선택해 주세요.");
 		$("#bnnStrtDt").focus();
 		return false;
 	}
 	if($("#bnnEndDt").val() == "" || $("#bnnEndDt").val() == null){
 		alert("배너 종료일을 선택해 주세요.");
 		$("#bnnEndDt").focus();
 		return false;
 	}
 	if(bnnDivCd == "" || bnnDivCd == null){
 		alert("분류 항목을 선택해 주세요.");
 		$("input[name='bnnDivCd']").focus();
 		return false;
 	}
 	if($("#bnnTitle").val() == "" || $("#bnnTitle").val() == null){
 		alert("제목을 입력해 주세요.");
 		$("#bnnTitle").focus();
 		return false;
 	}
 	if(bnnDivCd == "MIH"){
 		if($('input[type=radio][name=mainNum]:checked').val() == "" || $('input[type=radio][name=mainNum]:checked').val() == null){
 			alert("메인 번호 순서를 선택해주세요.");
 			$("input[name='bnnDivCd']").focus();
 			return false;
 		}
 		if($("#bnnMpImgUrl").val() == '' || $("#bnnMpImgUrl").val() == null){
 	 		alert("메인 배너 (PC)를 첨부하세요.");
 	 		return false;
 	 	}
 	 	if($("#bnnMmImgUrl").val() == '' || $("#bnnMmImgUrl").val() == null){
 	 		alert("메인 배너 (MOBILE)를 첨부하세요.");
 	 		return false;
 	 	}
 	 	if($("#bnnMLndUrl").val() == '' || $("#bnnMmImgUrl").val() == null){
 	 		alert("메인 배너 랜딩 페이지 URL를 입력해주세요.");
 	 		return false;
 	 	}
 	}else{
 		if($("#bnnMpImgUrl").val() == '' || $("#bnnMpImgUrl").val() == null){
 	 		alert("메인 배너 (PC)를 첨부하세요.");
 	 		return false;
 	 	}
 	 	if($("#bnnMmImgUrl").val() == '' || $("#bnnMmImgUrl").val() == null){
 	 		alert("메인 배너 (MOBILE)를 첨부하세요.");
 	 		return false;
 	 	}
 	 	if($("#bnnMLndUrl").val() == '' || $("#bnnMmImgUrl").val() == null){
 	 		alert("메인 배너 랜딩 페이지 URL를 입력해주세요.");
 	 		return false;
 	 	}
 	 	if($("#bnnEpImgUrl").val() == '' || $("#bnnEpImgUrl").val() == null){
 	 		alert("이벤트 배너 (PC)를 첨부하세요.");
 	 		return false;
 	 	}
 	 	if($("#bnnEmImgUrl").val() == '' || $("#bnnEmImgUrl").val() == null){
 	 		alert("이벤트 배너 (MOBILE)를 첨부하세요.");
 	 		return false;
 	 	}
 	 	if($("#bnnELndUrl").val() == '' || $("#bnnELndUrl").val() == null){
 	 		alert("이벤트 배너 랜딩 페이지 URL를 입력해주세요.");
 	 		return false;
 	 	}
 	}
 	return true;
 }
	
//폼전송     
function bannerInsert() {
	
	if(insertCheck()){
		const formData = new FormData();
		
 		var bnnData = {
				bnnDivCd : bnnDivCd
				, bnnStrtDt : $("#bnnStrtDt").val()
				, bnnEndDt : $("#bnnEndDt").val()
				, bnnTitle : $("#bnnTitle").val()
				, bnnMLndUrl : $("#bnnMLndUrl").val()
				, bnnELndUrl : $("#bnnELndUrl").val()
		};
	 	
	 	switch (bnnDivCd){
	 		case "MIH" :
	 			debugger;
	 			
	 			bnnData.bnnDivCd = bnnDivCd + $('input[type=radio][name=mainNum]:checked').val();
				
				const bnnMpImgUrl = document.getElementById("bnnMpImgUrl");
				formData.append("bnnMpImgUrl", bnnMpImgUrl.files[0]);
				
				const bnnMmImgUrl = document.getElementById("bnnMmImgUrl");
				formData.append("bnnMmImgUrl", bnnMmImgUrl.files[0]);
				
				var promoData = [{
					"promoSq" : "1"
					, "bnnDivCd" : bnnDivCd
					, "promoNm" : "회원들의 작품 자랑하기"
					, "promoOdDivCd" : $("#MIH1_DIV_CD").val()
					, "promoOdTypCd" : $("#MIH1_TYP_CD").val()
				}
		 		,{
					"promoSq" : "2"
					, "bnnDivCd" : bnnDivCd
					, "promoNm" : "지금 거래중인 작품"
					, "promoOdDivCd" : $("#MIH2_DIV_CD").val()
					, "promoOdTypCd" : $("#MIH2_TYP_CD").val()
				}
		 		,{
					"promoSq" : "3"
					, "bnnDivCd" : bnnDivCd
					, "promoNm" : "매거진9"
					, "promoOdDivCd" : $("#MIH3_DIV_CD").val()
					, "promoOdTypCd" : $("#MIH3_TYP_CD").val()
				}
		 		,{
					"promoSq" : "4"
					, "bnnDivCd" : bnnDivCd
					, "promoNm" : "인기회원"
					, "promoOdDivCd" : $("#MIH4_DIV_CD").val()
					, "promoOdTypCd" : $("#MIH4_TYP_CD").val()
				}
		 		,{
					"promoSq" : "5"
					, "bnnDivCd" : bnnDivCd
					, "promoNm" : "전시소개/후기"
					, "promoOdDivCd" : $("#MIH5_DIV_CD").val()
					, "promoOdTypCd" : $("#MIH5_TYP_CD").val()
				}];
		 		formData.append("bnnData", new Blob([JSON.stringify(bnnData)], {type: "application/json"}));
				formData.append("promoData", new Blob([JSON.stringify(promoData)], {type: "application/json"}));
				break;
				
	 		case "CMH" :
	 			break;
	 	} 
		$.ajax({
	        type: "post",
	        url: "/admin/banner/bannerInsertData",
	        data: formData,
	        contentType : false,
	        processData : false,
	        success: function(data) {
	        	/* if(data != 0 || data != null || data != ""){
	        		modalAlertShow("성공적으로 저장되었습니다.", "myCollection");
		        	} */
	        	
	        	if(data == 1 ){
	        		modalAlertShow("성공적으로 저장되었습니다.", "myCollection");
		        	} else {
		        		modalAlertShow("소장품 등록에 실패했습니다. 다시 한번 등록해 주세요!!", "myCollection");
		        	}
	        	
	        },
	        error: function(error) {
	            alert("오류 발생" + error);
	        }
		});
	}
}
	
	 
	 
	
	 

	 
		
		
     
</script>

</body>
</html>

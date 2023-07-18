<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

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
	width: 30%;
	height: 200px;
	object-fit: cover;
	display: block;
	margin: 20px auto;
	height: 200px;
}

.image-boxM {
	width: 30%;
	height: 200px;
	object-fit: cover;
	display: block;
	margin: 20px auto;
}

.image-boxPc2 {
	width: 30%;
	height: 200px;
	object-fit: cover;
	display: block;
	margin: 20px auto;
	height: 200px;
}

.image-boxM2 {
	width: 30%;
	height: 200px;
	object-fit: cover;
	display: block;
	margin: 20px auto;
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
								<li class="nav-item"><a class="sTitle" href="#"
									data-toggle="tab"><b>배너목록</b></a></li>
							</ul>
						</div>
						<!-- 폼 -->
						<form action="" enctype="multipart/form-data" method="post"
							onSubmit="return submitCheck();">
							<table class="table table-bordered">
								<tbody>
									<tr class="col-form-label sTitle LabelStyle">
										<td class="col-sm-1" align="center">기간</td>
										<td id="" class="col-sm-4 dataValue"><input
											type="datetime-local" id="brWhen1"> ~ <input
											type="datetime-local" id="brWhen2"></td>
									</tr>
									<tr class="col-form-label sTitle LabelStyle">
										<td class="col-sm-1" align="center">분류</td>
										<td id="" class="col-sm-2 dataValue">
											<div class="col-sm-5">
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a1" name="bnrTypCd" value="MIH">
													<label for="a1" class="col-form-label sTitle">메인페이지홈</label>
												</div>
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a2" name="bnrTypCd" value="CMH">
													<label for="a2" class="col-form-label sTitle">커뮤니티홈</label>
												</div>
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a3" name="bnrTypCd" value="MGH">
													<label for="a3" class="col-form-label sTitle">Mgz9</label>
												</div>
												<div style="padding-left: 10px; float: left;">
													<input type="radio" id="a4" name="bnrTypCd" value="EVH">
													<label for="a4" class="col-form-label sTitle">이벤트홈</label>
												</div>
											</div>
										</td>
									</tr>
									<tr class="col-form-label sTitle LabelStyle">
										<td class="col-sm-1" align="center">제목</td>
										<td id="" class="col-sm-2 dataValue"><input type="Text"
											style="width: 50%" id="brTitle"></td>
									</tr>
								</tbody>
							</table>

							<!--필수 메인이미지는 항상보여야함 -->
							<div id="mainimg" style="display: none">
								<div class="card-header p-2"
									style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
									<ul class="nav nav-pills">
										<li class="nav-item"><a class="sTitle" href="#"
											data-toggle="tab"><b>빅 배너 설정</b></a></li>
									</ul>
								</div>

								<div class="card-body" style="background-color: #ffffff;">

									<div class="imgboxtest" style="min-height: 100px">
										<!-- 매거진일 때 매거진 선택 -->
										<div class="bannerNumber" style="height: 50px;"
											id="mgzbannerlist">
											<div style="padding-left: 10px; float: left;">
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
											</div>

											<input type="hidden" id="imgNumCheck" name="sendimg" value="">
										</div>
										<!-- 메인일 때 -->
										<div class="bannerNumber" style="height: 50px;"
											id="mainbannerlist">
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="1">
												<label for="imgNumber" class="col-form-label sTitle">배너
													1번</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="2">
												<label for="imgNumber" class="col-form-label sTitle">배너
													2번</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="3">
												<label for="imgNumber" class="col-form-label sTitle">배너
													3번</label>
											</div>
											<div style="padding-left: 10px; float: left;">
												<input type="radio" id="imgNumber" name="mainNum" value="4">
												<label for="imgNumber" class="col-form-label sTitle">배너
													4번</label>
											</div>
											<input type="hidden" id="imgNumCheck" name="sendimg" value="">
										</div>
										<div class="imgboxtest1"
											style="width: 40%; display: inline-block; min-height: 50px;">
											<label class="col-form-label sTitle LabelStyle"
												style="text-align: center;">상단배너PC</label>
											<div class="flex-container">

												<div class="wrapper">
													<img
														src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg"
														class="image-boxPc" id="image-boxPc" /> <label
														for="brMainPcimgUrl" class="btn btn-info sTitle">
														<input id="brMainPcimgUrl" type="file" accept="image/*" />
														<span>등록</span>
													</label>
												</div>

											</div>
										</div>
									</div>

									<div class="imgboxtest2"
										style="width: 40%; display: inline-block; min-height: 50px;">
										<label class="col-form-label sTitle LabelStyle"
											style="text-align: center;">상단배너MOBLE</label>

										<div class="flex-container">
											<div class="wrapper">
												<img
													src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg"
													class="image-boxM" id="image-boxM"> <label
													for="brMainMimgUrl" class="btn btn-info sTitle"> <input
													id="brMainMimgUrl" type="file" accept="image/*" /> <span>등록</span>
												</label>
											</div>


										</div>
										<div>
											<label class="col-form-label sTitle LabelStyle"
												style="text-align: center;">랜딩페이지URL</label> <input
												name="bannerUrl" id="brMainRUrl" type="text"
												style="width: 300px;">
										</div>
									</div>
								</div>
								<!-- 이벤트 배너 커뮤니티/매거진일때만 -->
								<div id="subimg" style="display: none;">
									<div class="card-header p-2"
										style="border: 1px solid rgba(0, 0, 0, .125); background-color: #efefef">
										<ul class="nav nav-pills">
											<li class="nav-item"><a class="sTitle" href="#"
												data-toggle="tab"><b>컨텐츠 배너 설정</b></a></li>
										</ul>
									</div>
									<div class="card-body" style="background-color: #ffffff;">

										<div class="imgboxtest" style="min-height: 100px">
											<div class="imgboxtest1"
												style="width: 40%; display: inline-block; min-height: 50px;">
												<label class="col-form-label sTitle LabelStyle"
													style="text-align: center;">상단배너PC</label>
												<div class="flex-container">

													<div class="wrapper">
														<img
															src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg"
															class="image-boxPc2" id="image-boxPc2" /> <label
															for="brSubPcimgUrl" class="btn btn-info sTitle">
															<input id="brSubPcimgUrl" type="file" accept="image/*" />
															<span>등록</span>
														</label>
													</div>

												</div>
											</div>
										</div>

										<div class="imgboxtest2"
											style="width: 40%; display: inline-block; min-height: 50px;">
											<label class="col-form-label sTitle LabelStyle"
												style="text-align: center;">상단배너MOBLE</label>

											<div class="flex-container">
												<div class="wrapper">
													<img
														src="https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg"
														class="image-boxM2" id="image-boxM2"> <label
														for="brSubMimgUrl" class="btn btn-info sTitle"> <input
														id="brSubMimgUrl" type="file" accept="image/*" /> <span>등록</span>
													</label>
												</div>


											</div>
											<div>
												<label class="col-form-label sTitle LabelStyle"
													style="text-align: center;">랜딩페이지URL</label> <input
													name="bannerUrl" id="brSubRUrl" type="text"
													style="width: 300px;">
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
										data-toggle="tab"><b>프로모션 영역 풀력 이벤트 설정</b></a></li>
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
														<input type="radio" id="a1" name="setList1" class=""
															value="최신순"><label for="a1"
															class="col-form-label sTitle">최신순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a2" name="setList1" class=""
															value="랜덤"> <label for="a2"
															class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">지금거래중인 작품</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="setList2" class=""
															value="최신순"> <label for="a3"
															class="col-form-label sTitle">최신순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="setList2" class=""
															value="랜덤"> <label for="a4"
															class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">매거진 9</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="setList3" class=""
															value="최신순"> <label for="a3"
															class="col-form-label sTitle">최신순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="setList3" class=""
															value="랜덤"> <label for="a4"
															class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>

											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">인기회원</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="setList4" class=""
															value="팔로잉누적순"> <label for="a3"
															class="col-form-label sTitle">팔로잉 누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="setList4" class=""
															value="랜덤"> <label for="a4"
															class="col-form-label sTitle">랜덤</label>
													</div>

												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">전시 후기/소개</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="setList5" class=""
															value="좋아요누적순"> <label for="a3"
															class="col-form-label sTitle">좋아요 누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="setList5" class=""
															value="조회수누적순"> <label for="a4"
															class="col-form-label sTitle">조회수 누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="setList5" class=""
															value="댓글누적순"> <label for="a4"
															class="col-form-label sTitle">댓글 누적순</label>
													</div>

												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- 이벤트 -->
								<div id="commulist" style="display: none">
									<table class="table table-bordered">
										<tbody>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">이주의 인기 작품 자랑</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a1" name="test1" class="" value=""><label
															for="a1" class="col-form-label sTitle">좋아요 누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a1" name="test1" class="" value=""><label
															for="a1" class="col-form-label sTitle">조회수 누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a2" name="test1" class="" value="">
														<label for="a2" class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">자랑하기 고수</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="test2" class="" value="">
														<label for="a3" class="col-form-label sTitle">좋아요
															누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="test2" class="" value="">
														<label for="a3" class="col-form-label sTitle">조회수
															누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="test2" class="" value="">
														<label for="a4" class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">전기 후기/소개</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="test3" class="" value="">
														<label for="a3" class="col-form-label sTitle">조회수누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="test3" class="" value="">
														<label for="a4" class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>

											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">이슈</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="test4" class="" value="">
														<label for="a3" class="col-form-label sTitle">조회수
															누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="test4" class="" value="">
														<label for="a4" class="col-form-label sTitle">랜덤</label>
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
														<input type="radio" id="a1" name="test1" class="" value=""><label
															for="a1" class="col-form-label sTitle">좋아요 누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a1" name="test1" class="" value=""><label
															for="a1" class="col-form-label sTitle">조회수 누적순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a2" name="test1" class="" value="">
														<label for="a2" class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">새로운 아티스트 영상</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="test2" class="" value="">
														<label for="a3" class="col-form-label sTitle">최신순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="test2" class="" value="">
														<label for="a4" class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>
											<tr class="col-form-label sTitle LabelStyle">
												<td class="col-sm-1" align="center">아티스트 업데이트</td>
												<td id="" class="col-sm-4 dataValue">
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a3" name="test3" class="" value="">
														<label for="a3" class="col-form-label sTitle">최신순</label>
													</div>
													<div style="padding-left: 10px; float: left;">
														<input type="radio" id="a4" name="test3" class="" value="">
														<label for="a4" class="col-form-label sTitle">랜덤</label>
													</div>
												</td>
											</tr>
										</tbody>
									</table>

								</div>
								<!-- 이벤트프로모션 -->
								<div id="eventlist" style="display: none">
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
								</div>

							</div>
							<div class="card-body"
								style="background-color: #ffffff; text-align: center;">
								<button type="button" class="btn btn-info sTitle"
									onClick="bannerInput();">저장</button>
								<button type="button" class="btn btn-info sTitle">수정</button>
								<button type="button" class="btn btn-info sTitle">삭제</button>
								<button type="button" class="btn btn-info sTitle"
									onClick="openPopup();" value="Send Value">미리보기</button>

							</div>
						</form>
					</div>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
	<script>
	
	//탭메뉴 변경 (따로 보여줘야 하는게 많음음)
	$('input[type=radio][name=bnrTypCd]').change(function() {
		if (this.value == 'MIH') { //메인홈으로 보낼 때 
			$("#mainimg").css("display", "block");
			$("#mainbannerlist").css("display", "block");//메인배너 선택
			$("#subimg").css("display", "none");//서브배너
			$("#mgzbannerlist").css("display", "none");//매거진배너 선택
			$("#evtboardlist").css("display", "none");//이벤트리스트불러오기
			$("#mainlist").css("display", "block");//메인프로모션
			$("#commulist").css("display", "none");//이벤트프로모션
			$("#mgzlist").css("display", "none");//매거진프로모션
			$("#eventlist").css("display", "none");//이벤트프로모션
			$('#brWhen1').val('');
		} else if (this.value == 'CMH') {
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

	</script>


	<script>

	var filePc = document.getElementById(".image-boxPc");
	var fileM = document.getElementById(".image-boxM");//바꿀때 src 리셋해줘야함
	
	
// 	이미지 미리보기
	const fileDOM = document.querySelector('#brMainPcimgUrl');
	const previews = document.querySelectorAll('.image-boxPc');	
	const fileDOM2 = document.querySelector('#brMainMimgUrl');
	const previews2 = document.querySelectorAll('.image-boxM');
	
	const fileDOM3 = document.querySelector('#brSubPcimgUrl');
	const previews3 = document.querySelectorAll('.image-boxPc2');	
	const fileDOM4 = document.querySelector('#brSubMimgUrl');
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
	
	</script>

	<script>
	
	//메인배너 순서 
	$('input[type=radio][name=mainNum]').change(function() {
		if (this.value == '1') { 
			$("input[name='sendimg']").attr('value', '1')
		}else if(this.value == '2'){
			$("input[name='sendimg']").attr('value', '2')
		}else if(this.value == '3'){
			$("input[name='sendimg']").attr('value', '3')
		}else{
			$("input[name='sendimg']").attr('value', '4')
		}
	});
	
	
	//매거진 배너 선택
	$('input[type=radio][name=mgzNum]').change(function() {
		if (this.value == '1') { 
			$("input[name='sendimg']").attr('value', 'insights')
		}else if(this.value == '2'){
			$("input[name='sendimg']").attr('value', 'media')
		}else {
			$("input[name='sendimg']").attr('value', 'exhibition')
		}
	});
	
	
	

//미리보기 팝업
 function openPopup(){

	var imgNum2 = $("input[name='sendimg']").val();
	console.log("메인 배너순서값 확인"+ imgNum2);
	
	var bnrTypCd = $("input[name='bnrTypCd']:checked").val();
 	var brMainPcimgUrl  = document.getElementById("image-boxPc").src;//pc이미지
 	var brMainMimgUrl  = document.getElementById("image-boxM").src; //moble이미지
 	var brMainRUrl = $("#brMainRUrl").val();//랜딩Url주소
	
 	var brSubPcimgUrl  = document.getElementById("image-boxPc2").src;//pc이미지
 	var brSubMimgUrl  = document.getElementById("image-boxM2").src; //moble이미지
 	var brSubRUrl = $("#brSubRUrl").val();//랜딩Url주소
 	

 	
	//폼전송     
     function bannerInput() {
  	
 		var brWhen1 = $("#brWhen1").val();//언제부터 
 		var brWhen2 = $("#brWhen2").val();//언제까지		
  		var bnrTypCd = $("input[name='bnrTypCd']:checked").val();//분류 코드 메인 MIH / 커뮤 CMH / 매거진 MGH / 이벤트 EVH
 		var brTitle = $("#brTitle").val();//제목
 		
 		var brMainPcimgUrl  = document.getElementById("image-boxPc").src;//pc이미지
 		var brMainMimgUrl  = document.getElementById("image-boxM").src; //moble이미지
 		var brMainRUrl = $("#brMainRUrl").val();//랜딩Url주소
 		
		var brSubPcimgUrl  = document.getElementById("image-boxPc2").src;//pc이미지
 		var brSubMimgUrl  = document.getElementById("image-boxM2").src; //moble이미지
 		var brSubRUrl = $("#brSubRUrl").val();//랜딩Url주소 		
 		
 		
	}
     
</script>

</body>
</html>

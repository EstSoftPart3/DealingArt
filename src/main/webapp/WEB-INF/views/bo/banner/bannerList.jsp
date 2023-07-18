<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>



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
								<i class="fas fa-remove">삭제</i>
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
										<option value="">메인페이지홈</option>
										<option value="">커뮤니티홈</option>
										<option value="">매거진홈</option>
										<option value="">이벤트홈</option>
									</select> <select class="custom-select bTitle" id="searchGubun">
										<option value="">10개씩 보기</option>
										<option value="mbrNm">20개씩 보기</option>
										<option value="mbrId">30개씩 보기</option>
										<option value="mbrNcknm">50개씩 보기</option>
										<option value="mbrNcknm">100개씩 보기</option>
									</select>


								</div>
							</div>

						</div>

						<div class="card-body table-responsive p-0"
							style="height: 500px; font-size: 11px;">

							<table class="table table-bordered"">
								<thead>
									<tr align="center" style="background-color: #efefef">
										<th><input type="checkbox"></th>
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
								style="margin: 0 auto">검색</button>
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
		$(document).ready(function() {
			bannerList();
		});

		/* 게시판 리스트 */
		function bannerList() {

			var brdTypCd = $('#brdTypCd').val();

			console.log("brdTypCd :" + brdTypCd);

			let params = {
				brdTypCd : brdTypCd
			}

			$("#bannerList")
					.jsGrid(
							{
								locale : "ko",
								height : "700px",
								width : "100%",
								inserting : false,
								editing : false,
								sorting : false,
								paging : true,
								autoload : true,
								pageSize : 10,
								gridview : true,

								deleteConfirm : "정말 삭제 하시겠습니까?",
								controller : {
									loadData : function(filter) {
										var d = $.Deferred();
										$
												.ajax(
														{
															type : "post",
															url : "/admin/banner/bannerListData",
															data : params,
															dataType : "json"
														})
												.done(
														function(response) {
															//d.resolve(response.bannerData.bannerInfo);

															d
																	.resolve($
																			.map(
																					response.bannerData.bannerInfo,
																					function(
																							item,
																							itemIndex) {

																						var rSize = response.bannerData.bannerInf.length
																								- itemIndex;

																						return $
																								.extend(
																										item,
																										{
																											"Index" : rSize
																										});
																					}));

														});
										return d.promise();
									}
								},
								fields : [

								{
									name : "Index",
									title : "선택",
									type : "checkbox",
									width : 30,
									align : "center",
								}, {
									name : "brdConTypCdTxt",
									title : "순서",
									type : "number",
									width : 200,
									align : "center",
									width : 100,
									visible : true
								}, {
									name : "brdAnTypCdTxt",
									title : "분류",
									type : "text",
									width : 150,
									align : "center",
									width : 100,
									visible : true
								}, {
									name : "brdSq",
									title : "제목",
									type : "text",
									width : 150,
									align : "center",
									width : 100,
									visible : true
								}, {
									name : "brdTitle",
									id : "기간",
									title : "제목",
									type : "text",
									width : 300,
									align : "left",
									visible : true,
									key : true
								}, {
									name : "brdTypCd",
									title : "등록일",
									type : "text",
									width : 200,
									align : "center",
									width : 100,
									visible : true
								},

								],
								rowClick : function(args) {
									//console.log(args)
									var getData = args.item.brdSq;
									console.log("getData :" + getData);
									fn_SubBrdPage(getData);

								}

							});

		}
		//  		if(brdTypCd == "FA") {

		// 		   $("#bannerList").jsGrid("fieldOption", "1", "visible", true);
		// 		   $("#bannerList").jsGrid("fieldOption", "2", "visible", false);
		// 	   }

		//    function fn_SubBrdPage(getData) {
		// 	   var brdTypCd = $('#brdTypCd').val();
		// 	   location.href='/admin/board/boardDetail?brdSq='+getData+'&brdTypCd='+brdTypCd;
		// 	}
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
// 타입 : 전체 게시물(ABL), 전체 댓글(ABR), 신고된 게시물(RBL)
String commuBorTypCd = request.getParameter("commuBorTypCd");

String commuBorName = "";

if (commuBorTypCd.equals("ABL")) {
	commuBorName = "전체 게시물 목록";
} else if (commuBorTypCd.equals("ABR")) {
	commuBorName = "전체 댓글 목록";
} else if (commuBorTypCd.equals("RBL")) {
	commuBorName = "신고된 게시물 목록";
}
%>

<style>
@media ( max-width : 500px) {
	.col-sm-1 {
		width: 30%;
	}
	.btnCommunitySet {
		width: auto;
		font-size: 12px;
		margin-bottom: 5px;
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
	               	<h3 class="card-title bTitle">게시물 관리</h3>
				</div>
				
				<input type="hidden" name="commuBorTypCd" id="commuBorTypCd" value="<%=commuBorTypCd%>">
				<input type="hidden" name="checkAllBoolean" id="checkAllBoolean" value="false">

				<div>
				 	<a href="/admin/community/communityBoardList?commuBorTypCd=ABL"><button class="btnCommunitySet" id="btn_viewAll" type="button" style="border: 1px solid grey;">전체 게시물 보기</button></a>
				 	<a href="/admin/community/communityBoardList?commuBorTypCd=ABR"><button class="btnCommunitySet" id="btn_viewReply" type="button" style="border: 1px solid grey;">전체 댓글 보기</button></a>
				 	<a href="/admin/community/communityBoardList?commuBorTypCd=RBL"><button class="btnCommunitySet" id="btn_viewReport" type="button" style="border: 1px solid grey;">신고된 게시물 보기</button></a>
				 </div>
				
                <!--card-body -->
                <table class="table table-bordered">
					<tr class="col-form-label sTitle LabelStyle" >
						<td class="col-sm-1" align="center" style="background-color: #efefef;">작성일</td>
						<td id="" class="col-sm-2 dataValue">
							<div class="noExl" style="text-align:left; display: inline;">
								<button type="button" style="border: 1px solid grey" onclick="setDate('0')">오늘</button>
								<button type="button" style="border: 1px solid grey" onclick="setDate('1')">3일</button>
								<button type="button" style="border: 1px solid grey" onclick="setDate('7')">7일</button>
								<button type="button" style="border: 1px solid grey" onclick="setDate('30')">1개월</button>
			                  	<input id="firstDate" type="date">
			                  	<input id="lastDate" type="date">
			                </div>
						</td>	
					</tr>
					<tr class="col-form-label sTitle LabelStyle"  >
						<td class="col-sm-1" align="center" style="background-color: #efefef;">게시판 분류</td>
=======
			<div class="content-header">
				<h4 class="text-bold">게시물 관리</h4>
			</div>
			<section class="content">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title bTitle">게시판 관리</h3>
					</div>
					<input type="hidden" name="commuBorTypCd" id="commuBorTypCd"
						value="<%=commuBorTypCd%>"> <input type="hidden"
						name="checkAllBoolean" id="checkAllBoolean" value="false">
					<div>
						<a href="/admin/community/communityBoardList?commuBorTypCd=ABL"><button
								class="btnCommunitySet" id="btn_viewAll" type="button"
								style="border: 1px solid grey;">전체 게시물 보기</button></a> <a
							href="/admin/community/communityBoardList?commuBorTypCd=ABR"><button
								class="btnCommunitySet" id="btn_viewReply" type="button"
								style="border: 1px solid grey;">전체 댓글 보기</button></a> <a
							href="/admin/community/communityBoardList?commuBorTypCd=RBL"><button
								class="btnCommunitySet" id="btn_viewReport" type="button"
								style="border: 1px solid grey;">신고된 게시물 보기</button></a>
					</div>
					<!--card-body -->
					<table class="table table-bordered">
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center"
								style="background-color: #efefef;">작성일</td>
							<td id="" class="col-sm-2 dataValue">
								<div class="noExl" style="text-align: left; display: inline;">
									<button type="button" style="border: 1px solid grey"
										onclick="setDate('0')">오늘</button>
									<button type="button" style="border: 1px solid grey"
										onclick="setDate('3')">3일</button>
									<button type="button" style="border: 1px solid grey"
										onclick="setDate('7')">7일</button>
									<button type="button" style="border: 1px solid grey"
										onclick="setDate('30')">1개월</button>
									<input id="firstDate" type="date"> <input id="lastDate"
										type="date">
								</div>
							</td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle">
						<td class="col-sm-1" align="center"
							style="background-color: #efefef;">게시판 분류</td>
						<td id="" class="col-sm-2 dataValue">
						<label><input type="radio" name="cmMgMenuTyp" value="" checked="checked">모두</label>
						<label><input type="radio" name="cmMgMenuTyp" value="BOA">자랑하기</label>
						<label><input type="radio" name="cmMgMenuTyp" value="EXH">전시후기/소개</label>
						<label><input type="radio" name="cmMgMenuTyp" value="ISS">이슈</label></td>
						</tr>
						<%
						if (commuBorTypCd.equals("ABL") || commuBorTypCd.equals("ABR")) {
						%>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center"
								style="background-color: #efefef;">게시글 찾기</td>
							<td id="" class="col-sm-2 dataValue">
								<div class="input-group input-group-sm">
								<select class="custom-select bTitle" id="cmMgSrchTyp">
									<option value="comtTitle" selected>제목</option>
									<option value="comtContent">내용</option>
									<option value="mbrId">아이디</option>
									<option value="nickname">닉네임</option>
								</select> <input type="text" id="cmMgSrchTxt"
									class="form-control float-right bTitle" placeholder="검색어">
								</div>
							</td>
						</tr>

						<%
						}
						if (commuBorTypCd.equals("ABL")) {
						%>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center"
								style="background-color: #efefef;">댓글여부</td>
							<td id="" class="col-sm-2 dataValue"><label><input
									type="radio" name="cmMgComntYn" value="" checked="checked">전체</label>
								<label><input type="radio" name="cmMgComntYn" value="Y">있음</label>
								<label><input type="radio" name="cmMgComntYn" value="N">없음</label>
							</td>
						</tr>

						<%
						}
						if (commuBorTypCd.equals("RBL")) {
						%>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center"
								style="background-color: #efefef;">구분</td>
							<td id="" class="col-sm-2 dataValue">
								<div class="input-group input-group-sm">
								<select class="custom-select bTitle" id="cmMgSrchRepTyp">
									<option value="writer" selected>작성자</option>
									<option value="reporter">신고자</option>
									<option value="content">게시글 내용</option>
								</select> 
								<input type="text" id="cmMgSrchRepTxt"
								class="form-control float-right bTitle" placeholder="검색">						
								</div>
							</td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center"
								style="background-color: #efefef;">신고사유</td>
							<td id="" class="col-sm-2 dataValue">
								<div class="input-group input-group-sm">
									<select class="custom-select bTitle" id="cmMgRepRsnTyp">
										<option value="all" selected>전체</option>
										<option value="irrelevantContent">관련 없는 내용</option>
										<option value="swearWord">욕설/비방</option>
										<option value="personalInformationLeakage">개인정보유출</option>
										<option value="advertising">광고/홍보글</option>
										<option value="etc">기타</option>
									</select>
								</div>
							</td>
						</tr>

						<%
						}
						if (commuBorTypCd.equals("ABL") || commuBorTypCd.equals("RBL")) {
						%>
						<tr class="col-form-label sTitle LabelStyle">
							<td class="col-sm-1" align="center"
								style="background-color: #efefef;">노출상태</td>
							<td id="" class="col-sm-2 dataValue"><label><input
								type="radio" name="cmMgRepSts" value="" checked="checked">전체</label>
							<label><input type="radio" name="cmMgRepSts" value="N">숨김 게시물</label> 
							<label><input type="radio" name="cmMgRepSts" value="Y">노출 게시물</label></td>
						</tr>
						<%
						}
						%>
					</table>

					<!--card-footer -->
					<div style="text-align: center;">
						<button type="button" style="border: 1px solid grey"
							onclick="boardList()">검색</button>
					</div>
					<section class="content">
						<div class="card-header">
							<h3 class="card-title bTitle"><%=commuBorName%></h3>
						</div>
					
						<div class="card-header">
							<div class="noExl" style="text-align: left; display: inline;">
							<%
							if (commuBorTypCd.equals("ABL")) {
							%>
								<button class="btnCommunitySet" type="button"
									style="border: 1px solid grey"
									onclick="boardStatusUpdate('hide')" value="hide">게시물 숨김</button>
								<button class="btnCommunitySet" type="button"
									style="border: 1px solid grey"
									onclick="boardStatusUpdate('nonhide')" value="nonhide">게시물 숨김 해제</button>
								<button class="btnCommunitySet" type="button"
									style="border: 1px solid grey"
									onclick="boardStatusUpdate('delete')">게시물 삭제</button>
								</div>
								<div class="card-tools">
									<div class="input-group input-group-sm">
										<select class="custom-select bTitle" id="boardAlign">
											<option value="0" selected>기본정렬</option>
											<option value="1">조회수 많은 순</option>
										</select>
									</div>
								</div>	
							<% } %>
							<%
							if (commuBorTypCd.equals("RBL")) {
							%>
								<button class="btnCommunitySet" type="button"
									style="border: 1px solid grey"
									onclick="rprtStatusUpdate('hide')" value="hide">게시물 숨김</button>
								<button class="btnCommunitySet" type="button"
									style="border: 1px solid grey"
									onclick="rprtStatusUpdate('nonhide')" value="nonhide">게시물 숨김 해제</button>
								<button class="btnCommunitySet" type="button"
									style="border: 1px solid grey"
									onclick="rprtStatusUpdate('delete')">게시물 삭제</button>
								</div>
								<div class="card-tools">
									<div class="input-group input-group-sm">
										<select class="custom-select bTitle" id="boardAlign">
											<option value="0" selected>기본정렬</option>
											<option value="1">조회수 많은 순</option>
										</select>
									</div>
								</div>
							<% } %>
							<%
							if (commuBorTypCd.equals("ABR")) {
							%>
							<div class="card-tools">
								<div class="input-group input-group-sm" style="width: 300px;">
									<select class="custom-select bTitle" id="boardAlign">
										<option value="0" selected>기본정렬</option>
										<option value="1">조회수 많은 순</option>
									</select>
								</div>
							</div>
							<%
							}
							%>
						</section>
						<div class="card">
							<div class="card-body" style="background-color: #ffffff;">
								<div class="">
									<div id="boardList" style="font-size: 12px;"></div>
								</div>
							</div>
						
						</div>
					</div>
				</section>
				</div>
			</div>
	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>

	<script>
		var table = $("table");
	
		$(document).ready(function(){
			//초기 날짜 설정
			setDate("0");
			
			// 게시물 리스트 ( 검색버튼 클릭시 보여줘야 함. 현재 확인하기 위해 동작 ) 
			boardList();
			
			clickBoardTabBtn($('#commuBorTypCd').val());
			getParamater('ABL');
			
			
		});
				
		/* 화면 초기 설정 */
		function setDate(date){
			var today = new Date();   
			var firstDate;
			var lastDate = simpleDateFormat(today);
			if(date == "1"){
				//한달 전
				firstDate = simpleDateFormat(new Date(today.setMonth(today.getMonth() - date)));
			}else{
				firstDate = simpleDateFormat(new Date(today.setDate(today.getDate() - date)));	
			}
			
			//오늘 날짜 셋팅
			$("#lastDate").val(lastDate);
			//3일 전 날짜 셋팅
			$("#firstDate").val(firstDate);
		}
		
		/* 날짜 ISO 표기법으로 변환 */
		function simpleDateFormat(date) {
			var todayString = date.getFullYear() + "-";
			var todayMonth = date.getMonth() + 1;
			if (todayMonth < 10) {
				todayString += "0";
			}
			todayString += todayMonth + "-";
			var todayDate = date.getDate();
			if (todayDate < 10) {
				todayString += "0";
			}
			todayString += todayDate;
			
			return todayString;
		}
		
		function setDate(days) {
		    var today = new Date();
		    var endDate = new Date(today);
		    if(days != '0') {
		        today.setDate(today.getDate() - days);
		    }
		    document.getElementById('firstDate').value = formatDate(today);
		    document.getElementById('lastDate').value = formatDate(endDate);
		}

		function formatDate(date) {
		    var day = ("0" + date.getDate()).slice(-2);
		    var month = ("0" + (date.getMonth() + 1)).slice(-2);
		    return date.getFullYear()+"-"+(month)+"-"+(day) ;
		}
		/* 게시글 관리 탭 클릭시 색상 변화 */
		function clickBoardTabBtn(commuBorTypCd){
			var btn;
			
			if(commuBorTypCd == 'ABL'){
				btn = $('#btn_viewAll')
			} else if(commuBorTypCd == 'ABR'){
				btn = $('#btn_viewReply')
			} else if(commuBorTypCd == 'RBL') {
				btn = $('#btn_viewReport')
			}
			
			btn.css('background-color', 'grey').css('color', 'white');
			
		}
		
		/* 게시글 리스트 */
		function boardList(){
			/* 
				게시물 조회하는 옵션 같이 파라미터 넣어서 보내기
				commuBorTypCd 값을 받아와서 값에 따른 파라미터 값 리턴하는 함수 만들기 -> getParamater(menuType)
			*/
			var commuBorTypCd = $('#commuBorTypCd').val();
			console.log("commuBorTypCd :"+commuBorTypCd);
			
			var params;
	
			if(commuBorTypCd == "ABL"){
				var firstDate = $("#firstDate").val();
				var lastDate = $("#lastDate").val();
				var cmMgMenuTyp = $('input:radio[name="cmMgMenuTyp"]:checked').val();
				
				var cmMgSrchTyp = $("#cmMgSrchTyp").val();
				var cmMgSrchTxt = $("#cmMgSrchTxt").val();
				
				var cmMgComntYn = $('input:radio[name="cmMgComntYn"]:checked').val();
				var cmMgRepSts = $('input:radio[name="cmMgRepSts"]:checked').val();
				
				params = {
					commuBorTypCd: commuBorTypCd,
					firstDate: firstDate,
					lastDate: lastDate,
					cmMgMenuTyp: cmMgMenuTyp,
					cmMgSrchTyp: cmMgSrchTyp,
					cmMgSrchTxt: cmMgSrchTxt,
					cmMgComntYn: cmMgComntYn,
					cmMgRepSts: cmMgRepSts,
				}
			}else if(commuBorTypCd == "ABR"){
				var firstDate = $("#firstDate").val();
				var lastDate = $("#lastDate").val();
				var cmMgMenuTyp = $('input:radio[name="cmMgMenuTyp"]:checked').val();
				
				var cmMgSrchTyp = $("#cmMgSrchTyp").val();
				var cmMgSrchTxt = $("#cmMgSrchTxt").val();
				params = {
					commuBorTypCd: commuBorTypCd,
					firstDate: firstDate,
					lastDate: lastDate,
					cmMgMenuTyp: cmMgMenuTyp,
					cmMgSrchTyp: cmMgSrchTyp,
					cmMgSrchTxt: cmMgSrchTxt,
				}
			}else if(commuBorTypCd == "RBL"){
				var firstDate = $("#firstDate").val();
				var lastDate = $("#lastDate").val();
				var cmMgMenuTyp = $('input:radio[name="cmMgMenuTyp"]:checked').val();
				
				var cmMgSrchRepTyp = $("#cmMgSrchRepTyp").val();
				var cmMgSrchRepTxt = $("#cmMgSrchRepTxt").val();
				debugger;
				var cmMgComntYn = $('input:radio[name="cmMgComntYn"]:checked').val();
				var cmMgRepSts = $('input:radio[name="cmMgRepSts"]:checked').val();
				
				params = {
					commuBorTypCd: commuBorTypCd,
					firstDate: firstDate,
					lastDate: lastDate,
					cmMgMenuTyp: cmMgMenuTyp,
					cmMgSrchRepTyp: cmMgSrchRepTyp,
					cmMgSrchRepTxt: cmMgSrchRepTxt,
					cmMgComntYn: cmMgComntYn,
					cmMgRepSts: cmMgRepSts,
			}
			}else{
				params = {
					commuBorTypCd: commuBorTypCd
				}
			}
			
			$("#boardList").jsGrid({
				locale:"ko",
			    height: "auto",
			    width: "100%",
			    inserting: false,
			    editing: false,
			    sorting: false,
			    paging: true,
			    autoload: true,
			    pageSize: 10,
			    pageButtonCount: 10,
			    gridview : true,
			    onPageChanged: function() {
			    	$('#checkAllBoolean').val("true");
			    	checkAll();
			    },
			    noDataContent: "검색 결과가 없습니다.",
			    controller: {
			    	loadData: function (filter) {
			     		var d = $.Deferred();
			     		
			            $.ajax({
			            	type: "post",
			 	    	 	url: "/admin/community/boardListData",
			 	         	data: params,
			 	         	dataType: "json"
				 	     }).done(function(response) {
				 	    	
				 	    	var responseLength = Object.keys(response.boardData.boardInfo).length;

							if(responseLength <= 0){
								 
								d.resolve([]);	
								/* $(".jsgrid-nodata-row").empty();
								$(".jsgrid-nodata-row").append("<br><br><p id='list_nodata' style='text-align:center; font-size:14px;'>검색 결과가 없습니다.</p>"); */
							} else {
								d.resolve($.map(response.boardData.boardInfo, function (item, itemIndex) {
					                 var rSize = response.boardData.boardInfo.length - itemIndex;   		    	    		 
					 	    		 return $.extend(item, { "Index": rSize });
					             }));
							} 	    	 
			 	      	});
			            return d.promise();
			        }
			    },
			    fields: [
			    	{ name: "checkRow",
		    	      title: "<input type=\"checkbox\" id=\"checkAll\" onclick=\"checkAll()\"/>",
		    	      align: "center",
		    	      width: 30,
		    	      itemTemplate: function(value, item) {
		    	        return $("<input>").attr("type", "checkbox")
		    	          .attr({class: "checkRow"})
		    	          .attr({name: "checkRow"})
		    	          .attr({id: "checkRow" + item.comtSq})
						  .attr({value: item.comtSq});		    	          
		    	      }
			    	 },
/* 게시판, 댓글 */		{ name: "comtSq", title: "순서", type: "text", width: 40, align: "center", visible: true},
/* 신고된 게시판 */		{ name: "rprtSq", title: "순서", type: "text", width: 60, align: "center", visible: false},
					{ name: "comtTypCd", title:"분류", type: "text", width: 100, align:"center", visible: true,
						itemTemplate: function(value, item) {
					        switch (value) {
				            case "ISS":
				                return "이슈";
				            case "EXH":
				                return "전시후기&소개";
				            case "BOA":
				                return "작품자랑";	            
				            default:
				                return value;
					        }
					     }
					},
					{ name: "", title:"작성자", type: "text", width: 80, align:"center", visible: false},
					{ name: "mbrNcknm", title:"닉네임", type: "text", width: 100,align:"center", visible: true},
					{ name: "mbrId", title:"아이디", type: "text", width: 100, align:"center", visible: true,},
					{ name: "comtTitle", title:"제목", type: "text", width: 200, align:"left", visible: true}, /* key: true 무엇 */
					{ name: "regDt", title:"작성일", type: "text", width: 100, align:"center", visible: true},
					{ name: "regDt", title:"신고일", type: "text", width: 100, align:"center", visible: false},
					{ name: "rprtTypCdNm", title:"신고사유", type: "text", width: 200, align:"center", visible: false},
					{ name: "regMbrNm", title:"신고자", type: "text", width: 80, align:"center", visible: false},
					{ name: "openYn", title:"상태", type: "text", width: 60, align:"center", visible: true,
						itemTemplate: function(value, item) {
					        switch (value) {
				            case "Y":
				                return "노출";
				            case "N":
				                return "숨김";				            
				            default:
				                return value;
					        }
					     }
					},
					{ name: "delYn", title:"삭제여부", type: "text", width: 60, align:"center", visible: true,
						itemTemplate: function(value, item) {
					        switch (value) {
				            case "Y":
				                return "삭제";
				            case "N":
				                return "유지";				            
				            default:
				                return value;
					        }
					     }
					},	
					{ name: "view", title: "미리보기", width: 80, align: "center", visible: true,
					    type: "text", editButton: false, deleteButton: false,
					    itemTemplate: function(value, item) {
					    	var comtTypCdUrl = {
								BOA: "showingOffDetail", // 작품자랑
								EXH: "exhibitDetail", // 전시후기
								ISS: "issueDetail" // 이슈
							};
					        var strView = '게시물 이동';
					        var $customPreviewButton = $("<button>")
					            .attr({style: "border: 1px solid grey; margin: auto;"})
					            .attr({role: "button"})
					            .attr({id: "btn-preview-" + item.brdSq})
					            .click(function(e) {
					            	
					            	var postUrl = "/community/" + comtTypCdUrl[item.comtTypCd] + "?SqNumber=" + item.comtSq;
					                window.open(postUrl, "_blank");
					            })
					            .append(strView);
	
					        return $("<div>").attr({class: "btn-toolbar", style: "text-align: center;"})
					            .append($customPreviewButton);
					    }
					},
					{ name: "comentSt", title: "댓글관리", width: 70, align: "center", visible: false,
					    type: "text", editButton: false, deleteButton: false,
					    itemTemplate: function(value, item) {
					    	var comtTypCdUrl = {
									BOA: "showingOffDetail", // 작품자랑
									EXH: "exhibitDetail", // 전시후기
									ISS: "issueDetail" // 이슈
								};
					        var strSelect = '조회';
					        var strView = '미리보기';	        
					        /* 
					        	조회버튼에 get방식으로 게시물 id 보내주기 - String communityBoardId
					        */
					        var $customEditButton = $("<button>")
					            .attr({style: "border: 1px solid grey"})
					            .attr({role: "button"})
					            .attr({id: "btn-edit-" + item.id})
					            .click(function(e) {
					            	window.open('http://localhost/admin/community/communityBoardCommentList', '게시판 관리', 'width=1000, height=auto, scrollbars=no, resizeble=no');
					            })
					            .append(strSelect);
					        var $customPreviewButton = $("<button>")
				            .attr({style: "border: 1px solid grey; margin: auto;"})
				            .attr({role: "button"})
				            .attr({id: "btn-preview-" + item.brdSq})
				            .click(function(e) {
				            	
				            	var postUrl = "/community/" + comtTypCdUrl[item.comtTypCd] + "?SqNumber=" + item.comtSq;
				                window.open(postUrl, "_blank");
				            })
					            .append(strView);
	
					        return $("<div>").attr({class: "btn-toolbar"})
					            .append($customEditButton)
					            .append($customPreviewButton);
					    }
					}
			    ]
			});
			
			/* 
			fieldOption : 
			0 체크박스, 1 게시판 순서, 2 신고된 게시판 순서, 3 분류, 
			4 작성자, 5 닉네임, 6 아이디, 
			7 제목, 8 작성일, 9 신고일, 10 신고사유, 
			11 신고자, 12 상태 13 삭제여부, 14 미리보기
			15 댓글관리
			*/
			commuBorTypCd: commuBorTypCd ; 
			if(commuBorTypCd == "ABR") {
				
				$("#boardList").jsGrid("fieldOption", "1", "visible", true);
				$("#boardList").jsGrid("fieldOption", "2", "visible", false);
				$("#boardList").jsGrid("fieldOption", "3", "visible", true);
				$("#boardList").jsGrid("fieldOption", "4", "visible", false);
				$("#boardList").jsGrid("fieldOption", "5", "visible", true);
				$("#boardList").jsGrid("fieldOption", "5", "width", 60);
				$("#boardList").jsGrid("fieldOption", "6", "visible", true);
				$("#boardList").jsGrid("fieldOption", "7", "visible", true);
				$("#boardList").jsGrid("fieldOption", "8", "visible", true);
				$("#boardList").jsGrid("fieldOption", "8", "width", 80);
				$("#boardList").jsGrid("fieldOption", "9", "visible", false);
				$("#boardList").jsGrid("fieldOption", "10", "visible", false);
				$("#boardList").jsGrid("fieldOption", "11", "visible", false);
				$("#boardList").jsGrid("fieldOption", "12", "visible", false);
				$("#boardList").jsGrid("fieldOption", "13", "visible", false);
				$("#boardList").jsGrid("fieldOption", "14", "visible", false);
				$("#boardList").jsGrid("fieldOption", "15", "visible", true);
			} else if(commuBorTypCd == "RBL") {
				$("#boardList").jsGrid("fieldOption", "1", "visible", false);
				$("#boardList").jsGrid("fieldOption", "2", "visible", true);
				$("#boardList").jsGrid("fieldOption", "3", "visible", true);
				$("#boardList").jsGrid("fieldOption", "4", "visible", true);
				$("#boardList").jsGrid("fieldOption", "5", "visible", false);
				$("#boardList").jsGrid("fieldOption", "6", "visible", false);
				$("#boardList").jsGrid("fieldOption", "7", "visible", true);
				$("#boardList").jsGrid("fieldOption", "8", "visible", false);
				$("#boardList").jsGrid("fieldOption", "9", "visible", true);
				$("#boardList").jsGrid("fieldOption", "10", "visible", true);
				$("#boardList").jsGrid("fieldOption", "11", "visible", true);
				$("#boardList").jsGrid("fieldOption", "12", "visible", true);
				$("#boardList").jsGrid("fieldOption", "13", "visible", true);
				$("#boardList").jsGrid("fieldOption", "14", "visible", true);
				$("#boardList").jsGrid("fieldOption", "15", "visible", false);
			}
		}
		
		/* 현재 메뉴 타입에 따른 입력값 얻어오기 */
		function getParamater(menuType){
			
			var firstDate = $("#firstDate").val();
			var lastDate = $("#lastDate").val();
			var cmMgMenuTyp = $("input[name='" + cmMgMenuTyp + "']").val();
			var cmMgSrchTyp = '';
			var cmMgSrchTxt = '';
			var cmMgComntYn = '';
			var cmMgSrchRepTyp = '';
			var cmMgSrchRepTxt = '';
			
			var cmMgRepRsnTyp = '';
			var cmMgRepSts = '';
			
			var params = {
					firstDate: firstDate,
					lastDate: lastDate,
					lastDate: lastDate,
			}
			
			console.log(params);
			
			if(menuType == 'ABL'){
				
				params.cmMgSrchTyp = $("#cmMgSrchTyp option:selected").val();
				params.cmMgSrchTxt = $("#cmMgSrchTxt").val();
				params.cmMgComntYn = $('input[name=cmMgComntYn]:checked').val();
				params.cmMgRepSts = $('input[name=cmMgRepSts]:checked').val();
				
			} else if(menuType == 'ABR'){
				
				params.cmMgSrchTyp = $("#cmMgSrchTyp option:selected").val();
				
			} else if(menuType == 'RBL'){
				
				params.cmMgSrchRepTyp = $("#cmMgSrchRepTyp option:selected").val();
				params.cmMgSrchRepTxt = $("#cmMgSrchRepTxt").val();
				params.cmMgRepRsnTyp = $("#cmMgRepRsn option:selected").val();
				params.cmMgRepSts = $("input[type=radio][name='"+ cmMgRepSts +"']:checked").val();
				
			}
			
			console.log(params);
			console.log($("#cmMgSrchTxt").val());
			
			return params;
		}
		
		function getCheckedValue() {
			
			var checkRows = $('.checkRow:checked');
			var checkedValues = [];
		    
		    $('.checkRow:checked').each(function() {
				checkedValues.push($(this).val());
			});
		    console.log(checkedValues);
		    return checkedValues;
		}
		
			
		
		/* 게시물 상태 변경 
		
			statusType
			- 게시물 숨김 : hide
			- 게시물 숨김 해제 : nonHide
			- 게시물 삭제 : delete
		*/
		function boardStatusUpdate(statusType){	
			var params = new Object();

			params.comtSq = getCheckedValue();
			params.statusType = statusType;
			debugger;
			
			$.ajax({
	        	type: "post",
	    	 	url: "/admin/community/boardStatusUpdate",
	         	data: params,
	 	    }).done(function(response) {
				alert(response.result+'개의 상태변경이 완료되었습니다.');
				boardList();
	   		}).fail(function(response){
	   			alert('게시물을 선택해야 합니다 ');
	   		});
		}
		//신고된 게시물 상태 변경
		function rprtStatusUpdate(statusType){	
			var params = new Object();
			AlertCheckbox()
			params.rprtSq = getCheckedValue();
			params.statusType = statusType;
			
			$.ajax({
	        	type: "post",
	    	 	url: "/admin/community/rprtStatusUpdate",
	         	data: params,
	 	    }).done(function(response) {
				alert(response.result+'개의 상태변경이 완료되었습니다.');
				boardList();
	   		}).fail(function(response){
	   			alert('상태변경중 오류가 발생했습니다.');
	   		});
		}
		
		/* 체크박스 전체선택 */
		function checkAll() {
		    var isChecked = $('#checkAll').prop('checked');
		    $('.checkRow').prop("checked", isChecked);
		}
		
		$(document).ready(function() {
		    // 이벤트 위임을 사용한 클릭 핸들러
		    $('body').on('click', '.checkRow', function() {
		        // 모든 checkRow 체크박스가 선택되었는지 확인
		        var allChecked = $('.checkRow').length === $('.checkRow:checked').length;
		        // 모든 checkRow 체크박스가 선택되면 "Check All"도 선택, 아니면 해제
		        $('#checkAll').prop('checked', allChecked);
		    });
		});






		

		
		/* 체크된 행의 게시글 아이디 가져오기 */
		/* function getCheckedValue(){
			var checkedSeqs = [];
			$("input:checkbox[name=checkRow]:checked").each(function(index, html) {
				
				var seq = this.id.replace('checkRow', '');	
				checkedSeqs.push(seq);
			});
			console.log(checkedSeqs);
			
			return JSON.stringify(checkedSeqs);
		} */
	</script>
</body>
</html>
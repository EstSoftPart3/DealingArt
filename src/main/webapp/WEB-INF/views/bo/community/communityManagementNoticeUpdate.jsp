<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<body>
	<div class="wrapper">
		<div class="content-wrapper">
			<section class="content">
				<div class="card">
					<input type="hidden" name="comtTypCd" id="comtTypCd" value="${param.comtTypCd }">
			 		<table class="table table-bordered">
						<tr class="col-form-label sTitle LabelStyle" >
							<td class="col-sm-1" align="center" style="background-color: #efefef;">공지글 제목</td>
							<td class="col-sm-2 dataValue">
								<input type="text" name="noticeTitle" id="noticeTitle" class="form-control float-right bTitle">
							</td>	
						</tr>
						<tr class="col-form-label sTitle LabelStyle" >
							<td class="col-sm-1" align="center" style="background-color: #efefef;">공지글 업로드</td>
							<td id="" class="col-sm-2 dataValue">
								<label class="btnNoticeFile" for="noticeFile" style="padding: 3px 15px; background-color: #dee2e6; cursor: pointer; border: 1px solid black">불러오기</label>
								<input type="file" id="noticeFile" class="uploadNotice" accept="image/*" style="display: none;">
							</td>
						</tr>
						<tr class="col-form-label sTitle LabelStyle" >
							<td id="" class="col-sm-2 dataValue">
								<button id="noticeReg" class="btn btn-sm btn-primary" type="button" onclick="noticeUpdate();">등록</button>
							</td>
						</tr>
					</table>
				 </div>
			 </section> 
		</div>    
	</div>

	<script>
		$(document).ready(function(){
			
		});
		
		/* 페이지 로딩시 공지글 제목 데이터 받아오기 */
		function getNoticeTitle(){
			
		}
		
		/* 공지글 등록 */
		function noticeUpdate(){
			// 공지 구분 코드
			var noticeDiv = {
				BOA: "CB",	// 자랑하기
				EXH: "CE",	// 전시후기/소개
				ISS: "CI"	// 이슈
			};
			
			var comtTypCd = $('#comtTypCd').val(); // 커뮤니티 구분
			var noticeTitle = $("#noticeTitle").val(); // 공지글 제목
			var noticeFile = document.getElementById("noticeFile"); // 공지글 업로드
			var noticeFileUrl = noticeFile.files[0]; // 공지글 업로드 파일
			
			if(!noticeTitle.trim()) {
				alert("공지글 제목이 입력되지 않았습니다.");
				$("#noticeTitle").focus();
				return;
			}
			
			if(!noticeFileUrl) {
				alert("공지글 업로드가 되지 않았습니다.");
				return;
			}
			
			var isConfirm = confirm("공지글을 등록하시겠습니까?");
			
			if(isConfirm) {
				var param = {
					noticeTitle: noticeTitle,
					brdTypCd: "NT",
					mbrSq: adminMbrSq,
					brdAnTypCd: noticeDiv[comtTypCd]
				};
				
				var formData = new FormData();
				formData.append("param", new Blob([JSON.stringify(param)], {type: "application/json"}));
				formData.append("noticeFileUrl", noticeFileUrl);
				
				$.ajax({
			        type: "post",
			        url: "/admin/community/communityManagementNoticeInsert",
			        data: formData,
			        contentType : false,
			        processData : false,
			        success: function(data) {
			        	alert("공지글이 등록되었습니다.");
			        	window.close();
			        },
			        error: function(error) {
			            alert("공지글 등록 중 오류가 발생했습니다.");
			        }
				});
			}
		}
	</script>

</body>
</html>
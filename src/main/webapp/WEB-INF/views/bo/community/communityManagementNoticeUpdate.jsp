<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<% 
	String comtTypCd = request.getParameter("comtTypCd");
	comtTypCd = "aaa";
%>

<body>

	<div class="wrapper">

		<div class="content-wrapper">

		     <!-- Main content -->
              <section class="content">

                <div class="card">
                
                <input type="hidden" name="comtTypCd" id="comtTypCd" value="<%=comtTypCd%>">

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
								<input type="file" id="noticeFile" class="uploadNotice" style="display: none;" onchange="noticeUpdate()">
								<label class="btnNoticeFile" for="noticeFileSave" style="padding: 3px 15px; background-color: #dee2e6; cursor: pointer; border: 1px solid black">저장</label>
								<input type="file" id="noticeSave" class="saveNotice" style="display: none;" onchange="">
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
	
	
	/* 파일 선택시 바로 업로드 */
	function noticeUpdate(){
		/* 
			어느 커뮤니티 공지글인지 구분하는 값 필요
		*/
		var comtTypCd = $('#comtTypCd').val();
		console.log(comtTypCd);
		
		var file = document.getElementById("noticeFile");
		$("#noticeTitle").val("xxxx");
		var noticeTitle = $("#noticeTitle").val();
		console.log(noticeTitle);
		console.log(file.files[0]);
		
		/* var formData = new FormData();
		
		formData.append("noticeFileUrl", file.files[0]);
		
		$.ajax({
	        type: "post",
	        url: "/admin/community/communityManagementNoticeInsert",
	        data: formData,
	        contentType : false,
	        processData : false,
	        success: function(data) {
	        	console.log('파일이 정상적으로 등록됨');
	        },
	        error: function(error) {
	            alert("파일 등록 오류" + error);
	        }
		}); */
	}

	</script>

</body>
</html>
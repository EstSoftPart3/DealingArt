<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>

<% 
	String comtTypCd = request.getParameter("comtTypCd");
	//comtTypCd = "aaa";
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
					</table>
					<button type="button" style="width:50px;margin:auto;" onclick="noticeUpdate()">저장</button>
				 </div>

			 </section> 
		</div>    
	</div>
	
	
	<script src="/resources/plugins/bootbox/bootbox.all.min.js"></script>
	<script src="/resources/plugins/bootbox/bootbox.locales.js"></script>
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
		var noticeTitle = $("#noticeTitle").val();
		var comtTypCd = "<%=comtTypCd%>";
		
		console.log(noticeTitle);
		const formData = new FormData();
		formData.append("comtTypCd", comtTypCd);
		formData.append("noticeTitle", noticeTitle);
		formData.append("mbrSq", 3);		
		
		$.ajax({
	        type: "post",
	        url: "/admin/community/communityManagementNoticeInsert",
	        data: formData,
	        contentType : false,
	        processData : false,
	        success: function(data) {
	        	
	        	alert("공지사항등록이 완료되었습니다.");
	        	console.log('파일이 정상적으로 등록됨');

	        },
	        error: function(error) {
	        	
	        	alert("공지사항등록에 실패했습니다.");
	            alert("파일 등록 오류" + error);
	            
	        }
	        
		}); 
	}

	</script>

</body>
</html>
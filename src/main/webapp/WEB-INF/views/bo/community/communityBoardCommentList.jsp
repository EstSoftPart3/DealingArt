<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
      table, th, td {
        border: 1px solid #bcbcbc;
        work-break: break-all;
        text-align: center;
      }
    </style>
<body>
	<div class="wrapper">
		
		<div class="content-wrapper">
		
		     <!-- Main content -->
              <section class="content">
				<div class="card-header">
					<div style="text-align:left; display: inline;">
	                  	<button type="button" class="btn btn-info sTitle" onclick="replyHideOn()">댓글 숨김</button>
	                  	<button type="button" class="btn btn-info sTitle" onclick="replyHideOff()">댓글 숨김 해제</button>
	                  	<button type="button" class="btn btn-info sTitle" onclick="replyDeleteOn()">댓글 삭제</button>
	                  	<button type="button" class="btn btn-info sTitle" onclick="replyDeleteOff()">댓글 삭제 해제</button>
	                </div>
				</div>				
                <div class="card">					 
				 	<div class="card-body" style="background-color:#ffffff;">
				 		<div>
				 			<div id="boardReplyList" style="font-size:12px;"></div>
				 		</div>
				 		<!-- <div class="noExl" style="text-align:center;">
		                  	<button type="button" class="btn btn-info sTitle" onclick="replyStatusUpdate()">적용</button>
		                </div> -->
				 	</div>
				 		
				 </div>
			 </section> 
		</div>    
	</div>
	
	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
	
	<script>
	var comtSq = "${comtSq}";
	$(document).ready(function(){		
		boardReplyList();
	});
	
	function chkAll() {
		if($("#cbx_chkAll").is(":checked")) {
			$("input[name=chk]").prop("checked", true);
			$("input[name=re_chk]").prop("checked", true);
		} else {
			$("input[name=chk]").prop("checked", false);
			$("input[name=re_chk]").prop("checked", false);
		}
	}

	function chk() {
		var total = $("input[name=chk]").length + $("input[name=re_chk]").length;
		var checked = $("input[name=chk]:checked").length;
		var re_checked = $("input[name=re_chk]:checked").length;
		if(total != (checked + re_checked)) {
			$("#cbx_chkAll").prop("checked", false);
		} else {
			$("#cbx_chkAll").prop("checked", true);
		}
	}
	
	/* 댓글 숨김 */
	function replyHideOn() {
		var list = [];
		$("input[name=chk]:checked").each(function(){
			list.push($(this).val());
		});
		var re_list = [];
		$("input[name=re_chk]:checked").each(function(){
			re_list.push($(this).val());
		});
		$.ajax ({
			type:"post",
			url:"/admin/community/updateReplyState",
			data: {
				list : list,
				re_list : re_list,
				state : "hideOn"
			},
			success: function(data) {
				alert(data.result + "건의 댓글이 숨김처리 되었습니다.");
				location.reload();
			},
			error: function(error) {
				console.log(error);
			}
		});		
	}
	
	/* 댓글 숨김 해제 */
	function replyHideOff() {
		var list = [];
		$("input[name=chk]:checked").each(function(){
			list.push($(this).val());
		});
		var re_list = [];
		$("input[name=re_chk]:checked").each(function(){
			re_list.push($(this).val());
		});
		$.ajax ({
			type:"post",
			url:"/admin/community/updateReplyState",
			data: {
				list : list,
				re_list : re_list,
				state : "hideOff"
			},
			success: function(data) {
				alert(data.result + "건의 댓글이 숨김해제 되었습니다.");
				location.reload();
			},
			error: function(error) {
				console.log(error);
			}
		});		
	}
	
	/* 댓글 삭제 */
	function replyDeleteOn() {
		var list = [];
		$("input[name=chk]:checked").each(function(){
			list.push($(this).val());
		});
		var re_list = [];
		$("input[name=re_chk]:checked").each(function(){
			re_list.push($(this).val());
		});
		$.ajax ({
			type:"post",
			url:"/admin/community/deleteReplyState",
			data: {
				list : list,
				re_list : re_list,
				state : "delOn"
			},
			success: function(data) {
				alert(data.result + "건의 댓글이 숨김해제 되었습니다.");
				location.reload();
			},
			error: function(error) {
				console.log(error);
			}
		});		
	}
	
	/* 댓글 삭제 해제 */
	function replyDeleteOff() {
		var list = [];
		$("input[name=chk]:checked").each(function(){
			list.push($(this).val());
		});
		var re_list = [];
		$("input[name=re_chk]:checked").each(function(){
			re_list.push($(this).val());
		});
		$.ajax ({
			type:"post",
			url:"/admin/community/deleteReplyState",
			data: {
				list : list,
				re_list : re_list,
				state : "delOff"
			},
			success: function(data) {
				alert(data.result + "건의 댓글이 숨김해제 되었습니다.");
				location.reload();
			},
			error: function(error) {
				console.log(error);
			}
		});		
	}
	
	/* 게시물 댓글 리스트 */
	function boardReplyList(){
		$.ajax({
			type: "post",
			url: "/admin/community/communityBoardCommentList",
			data: {
				comtSq: comtSq
			},
			success: function(data) {
				var result = data.result;
				var html = '';
				html += '<table id="cmtList">';
				html += '	<tr>';
				html += '		<th colspan="2"><input type="checkbox" id="cbx_chkAll" onclick="chkAll()"></th>';
				html += '		<th>순서</th>';
				html += '		<th>작성자</th>';
				html += '		<th>내용</th>';
				html += '		<th>작성일자</th>';
				html += '		<th>숨김여부</th>';
				html += '		<th>삭제여부</th>';
				html += '	</tr>';
				if(result.length > 0){
					for(i=0; i<result.length; i++){
						html += '	<tr>';
						html += '		<td colspan="2"><input type="checkbox" name="chk" onclick="chk()" value="'+result[i].cmtSq+'"></td>';
						html += '		<td>'+result[i].cmtSq+'</td>';
						html += '		<td>'+result[i].regMbrNcknm+'</td>';
						html += '		<td>'+result[i].cmtContent+'</td>';
						html += '		<td>'+result[i].regDt+'</td>';
						html += '		<td>'+result[i].openYn+'</td>';
						html += '		<td>'+result[i].delYn+'</td>';
						html += '	</tr>';
						if(result[i].replys.length > 0){
							for(j=0; j<result[i].replys.length; j++){
								html += '	<tr>';
								html += '		<td colspan="2">↳<input type="checkbox" name="re_chk" onclick="chk()" value="'+result[i].replys[j].replySq+'"></td>';
								html += '		<td>'+result[i].replys[j].replySq+'</td>';
								html += '		<td>'+result[i].replys[j].regMbrNcknm+'</td>';
								html += '		<td>'+result[i].replys[j].replyContent+'</td>';
								html += '		<td>'+result[i].replys[j].regDt+'</td>';
								html += '		<td>'+result[i].replys[j].openYn+'</td>';
								html += '		<td>'+result[i].replys[j].delYn+'</td>';
								html += '	</tr>';
							}
						}
					}
				}else{
					html += '	<tr>';
					html += '		<td colspan="8">검색 결과가 없습니다.</td>';
					html += '	</tr>';
				}
				html += '</table>';
				
				$("#boardReplyList").empty();
				$("#boardReplyList").append(html).trigger("create");
			},
			error : function(error) { // 결과 에러 콜백함수
		        console.log(error)
		    }
		});
	}	
	
	/* 체크박스 전체선택 */
	/* function checkAll(){
		var checkAllBoolean = ($('#checkAllBoolean').val() == 'false') ? 'true' : 'false';
		
		if(checkAllBoolean == 'true'){
			//$('.checkRow').attr('checked', true);
			$('.checkRow').prop("checked", true);
			//$('#checkAll').attr('checked', true);
	    	$('#checkAll').prop('checked', true);
		} else {
			$('.checkRow').attr('checked', false);
			$('.checkRow').prop("checked", false);
			$('#checkAll').attr('checked', false);
	    	$('#checkAll').prop('checked', false);
		}
		
		$('#checkAllBoolean').val(checkAllBoolean);
		
	} */
	
	/* 
		댓글 상태 변경하기 ( 댓글관련 버튼 클릭시 화면상으로 변경한 뒤, '적용' 버튼 클릭시 DB에 저장해야함 ) 
		댓글 숨김 : hidden
		댓글 숨김 해제 : unhidden
		댓글 삭제 : delete
	*/
	
	/* function changeReplyStatus(btnType){
		
		$("input:checkbox[name=checkRow]:checked").each(function(index, html) {
			console.log($("#replyStatusRow122").val());
			
			var replyIndex = html.id.replace("checkRow", "");
			var replyStatusHtml = $("#replyStatusRow"+replyIndex);
			var strReplyStatus = replyStatusHtml.val();

			if(btnType == 'hidden'){
				strReplyStatus = '숨김';
			} else if(btnType == 'unhidden'){
				strReplyStatus = '노출';
			} else if(btnType == 'delete'){
				strReplyStatus = '삭제됨';
			}
			
			replyStatusHtml.val(strReplyStatus);
			
			$('.checkRow').attr('checked', false);
			$('.checkRow').prop("checked", false);
			
		});
	} */
	
	/* 댓글 적용 */
	
	</script>

</body>
</html>
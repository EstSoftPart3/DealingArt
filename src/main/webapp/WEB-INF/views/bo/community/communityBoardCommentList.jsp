<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String communityBoardId = request.getParameter("communityBoardId");

%>

<body>

	<div class="wrapper">
		
		<div class="content-wrapper">
		
		<input type="hidden" name="checkAllBoolean" id="checkAllBoolean" value="false">
		<input type="hidden" name="communityBoardId" id="communityBoardId" value="<%=communityBoardId %>">
		     
		     <!-- Main content -->
              <section class="content">
				<div class="card-header">
					<div style="text-align:left; display: inline;">
	                  	<button type="button" class="btn btn-info sTitle" onclick="changeReplyStatus('hidden')">댓글 숨김</button>
	                  	<button type="button" class="btn btn-info sTitle" onclick="changeReplyStatus('unhidden')">댓글 숨김 해제</button>
	                  	<button type="button" class="btn btn-info sTitle" onclick="changeReplyStatus('delete')">댓글 삭제</button>
	                </div>
				</div>
				
                <div class="card">
					 
				 	<div class="card-body" style="background-color:#ffffff;">
				 		<div>
				 			<div id="boardReplyList" style="font-size:12px;"></div>
				 		</div>
				 		<div class="noExl" style="text-align:center;">
		                  	<button type="button" class="btn btn-info sTitle" onclick="replyStatusUpdate()">적용</button>
		                </div>
				 	</div>
				 		
				 </div>
			
			 </section> 
		</div>    
	</div>
	
	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
	
	<script>
	$(document).ready(function(){
		boardReplyList();
		
	});
	
	/* 게시물 댓글 리스트 */
	function boardReplyList(){
		var commuBorTypCd = $('#commuBorTypCd').val();
		   
		console.log("commuBorTypCd :"+commuBorTypCd);
		commuBorTypCd = "NT"

		let params = {
			commuBorTypCd : commuBorTypCd
		}
		
		$("#boardReplyList").jsGrid({
			locale:"ko",
		    height: "auto",
		    width: "100%",
		    inserting: false,
		    editing: false,
		    sorting: false,
		    paging: true,
		    autoload: true,
		    pageSize: 5,
		    pageButtonCount: 10,
		    gridview : true,
		    onPageChanged: function() {
		    	$('#checkAllBoolean').val("true");
		    	checkAll();
		    },
		    controller: {
		    	loadData: function (filter) {
		     		var d = $.Deferred();
		            $.ajax({
		            	type: "post",
		 	    	 	url: "/admin/board/boardListData",
		 	         	data: params,
		 	         	dataType: "json"
			 	     }).done(function(response) {
			 	    	 
			 	    	var responseLength = Object.keys(response.boardData.boardInfo).length;
			 	    	 
						if(responseLength <= 0){
							 
							d.resolve();
							
							$(".jsgrid-nodata-row").empty();
							$(".jsgrid-nodata-row").append("<br><br><p id='list_nodata' style='text-align:center; font-size:13px;'>검색 결과가 없습니다.</p>");
							
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
		    	{ name: "",
	    	      title: "<input type=\"checkbox\" id=\"checkAll\" onclick=\"checkAll()\"/>",
	    	      width: 20,
	    	      align: "center",
	    	      itemTemplate: function(value, item) {
	    	        return $("<input>").attr("type", "checkbox")
	    	          .attr({class: "checkRow"})
	    	          .attr({name: "checkRow"})
	    	          .attr({id: "checkRow" + item.brdSq});
	    	      }
		    	 },
				{ name: "", title: "순서", type: "text", width: 40, align: "center", visible: true},
				{ name: "", title: "닉네임", type: "text", width: 60,align:"center", visible: true},
				{ name: "", title: "내용", type: "text", width: 120,align:"center", visible: true},
				{ name: "brdConTypCdTxt", title: "상태", type: "text", width: 50, align: "center", visible: true,
				    itemTemplate: function(value, item) {
				    	
				       var $customStatusText = $("<span>")
				            .attr({role: "text"})
				            .attr({id: "replyStatusRow" + item.brdSq})
				            .append("zzz");

				        return $customStatusText;
				    }
				}
		    ],
		    multiselect: true,
		    rowClick: function(args) {
		    	
		    }
		});
	}
	
	/* 체크박스 전체선택 */
	function checkAll(){
		
		var checkAllBoolean = ($('#checkAllBoolean').val() == 'false') ? 'true' : 'false';
		
		if(checkAllBoolean == 'true'){
			$('.checkRow').attr('checked', true);
			$('.checkRow').prop("checked", true);
			$('#checkAll').attr('checked', true);
	    	$('#checkAll').prop('checked', true);
		} else {
			$('.checkRow').attr('checked', false);
			$('.checkRow').prop("checked", false);
			$('#checkAll').attr('checked', false);
	    	$('#checkAll').prop('checked', false);
		}
		
		$('#checkAllBoolean').val(checkAllBoolean);
		
	}
	
	/* 
		댓글 상태 변경하기 ( 댓글관련 버튼 클릭시 화면상으로 변경한 뒤, '적용' 버튼 클릭시 DB에 저장해야함 ) 
		댓글 숨김 : hidden
		댓글 숨김 해제 : unhidden
		댓글 삭제 : delete
	*/
	function changeReplyStatus(btnType){
		
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
	}
	
	/* 댓글 적용 */
	function replyStatusUpdate(){
		/* 
			댓글 상태, 게시물 id, 댓글 id 필요 
		*/
	}
	</script>

</body>
</html>
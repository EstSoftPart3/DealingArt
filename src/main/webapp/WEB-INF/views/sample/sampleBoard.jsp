<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시판 페이지</title>
    <!-- css 가져오기 -->
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/semantic.min.css">
    
    <!-- js 가져오기 -->
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/semantic.min.js"></script>
    <script src="/resources/js/pagination.js"></script>
	<script src="/resources/js/common.js"></script>
    <style type="text/css">
        body {
            background-color: #DADADA;
        }

        body>.grid {
            height: 100%;
        }

        .image {
            margin-top: -100px;
        }

        .column {
            max-width: 1000px;
        }

        .view_btn {
            cursor: pointer;
        }
        
        .paging-div { 
        	padding: 15px 0 5px 10px; 
        	display: table; 
        	margin-left: auto; 
        	margin-right: auto; 
        	text-align: center; 
        }
        .content {
        	height : 85%;
        	box-sizing: border-box;
        }
        
    </style>
    
</head>

<body>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <h2 class="ui teal image header">
                게시판 페이지
            </h2>
            <div class="ui large form">
                <div class="ui stacked segment">
                    <a href="/sample/sampleWrite"><button class="ui fluid large teal submit button">게시글 작성하기</button></a>
                    <table class="ui celled table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>제목</th>
                                <th>등록자</th>
                                <th>등록일</th>
                            </tr>
                        </thead>
                        <tbody id="list">
                        </tbody>
                    </table>
                    <div class="description">
            			<p style = "text-align: right" id = "b_count"></p>
            		</div>
            		<button class="ui submit blue button" id="moreButton" onclick="moreButton_onClick()">더보기</button>
                    <div class="paging-div"> 
                		<ul class="pagination" id="pagination"></ul> 
                	</div>
                </div>
                
                <div class="ui error message"></div>

            </div>
        </div>
    </div>

    <div class="ui modal" id="view_modal">
        <i class="close">x</i>
        <div class="header" id="b_title" style = "font-size: xx-large">
        </div>
        <div class="content">
            <div class="description">
            	<p style = "text-align: right; font-size: large" id = "b_review"></p>
            	<div id = "b_content" style = "font-size: x-large"></div>
            </div>
        </div>
        <div class="actions">
            <button class="ui submit button" onclick="updateBoard()" id="updateButton">수정</button>
            <button class="ui submit button" onclick="deleteBoard()" id="deleteButton">삭제</button>
            <div class="ui black deny button">닫기</div>
        </div>
    </div>
    <script>
    if("${massage}" != ""){
    	alert("${massage}");
    }
   	var selectBoard = {};
   	var bRegData = "";
   	var bNo = "";
   	var more = 1;
        $(document).ready(function() {
        	$('#pagination').twbsPagination({ 
            	totalPages: 10, // 전체 페이지 
            	startPage: 1, // 시작(현재) 페이지 
            	visiblePages: 10, // 최대로 보여줄 페이지 
            	prev: "‹", // Previous Button Label 
            	next: "›", // Next Button Label 
            	first: '«', // First Button Label 
            	last: '»', // Last Button Label 
            	onPageClick: function (event, page) { // Page Click event 
            		console.info("current page : " + page);
            		searchDataList(page);
            	} 
            });
        	
            $(document).on("click", ".view_btn", function() {
                bNo = $(this).parent().attr("data-id");
                $.ajax({
                    type: "post",
                    url: "/sample/selectBoard",
                    data: {
                        bNo: bNo
                    },
                    success: function(data) {
                    	selectBoard = data.sampleBoard;
                    	bRegDate = selectBoard.bregDate[0] + "년" + selectBoard.bregDate[1] + "월" + 
                    	selectBoard.bregDate[2] + "일" + " " + selectBoard.bregDate[3] + "시" +
                    	selectBoard.bregDate[4] + "분" + selectBoard.bregDate[5] + "초";
                    	$("#b_title").text(selectBoard.btitle);
                    	$("#b_review").text(selectBoard.bwriter + " - " +  bRegDate);
                    	$("#b_content").text(selectBoard.bcontent);
                    	$('#view_modal').modal('show');
                    	if(data.fix != null || data.fix != ""){
                    		$("#updateButton").hide();
                    		$("#deleteButton").hide();
                    	}
                    },
                    error: function(error) {
                        alert("오류 발생" + error);
                    }
                });
            });
            
        });
        
        var flag = true;
        
        function searchDataList(page) {
        	if(flag){
        		flag = false;
	    		$.ajax({
	                type: "post",
	                url: "/sample/searchBoard",
	                data: {
	                	page : page,
	                	pageSize : 10
	                },
	                success: function(data) {
	                	var dataList = data.list;
	                	$("#list").empty();
	                    for (var str in dataList) {
	                        var tr = $("<tr></tr>").attr("data-id", dataList[str].bno).appendTo("#list");
	                        $("<td></td>").text(dataList[str].bno).addClass("view_btn").appendTo(tr);
	                        $("<td></td>").text(dataList[str].btitle).addClass("view_btn").appendTo(tr);
	                        $("<td></td>").text(dataList[str].bwriter).addClass("view_btn").appendTo(tr);
	                        $("<td></td>").text(dataList[str].bregDate).addClass("view_btn").appendTo(tr);
	                    }
	                    $("#pagination").twbsPagination("changeTotalPages", data.totalPage, page);
	                    $("#b_count").text("전체 게시물 갯수 : " + data.totalCount);
	                },
	                complete: function(){	// 이부분 중요
						flag = true;	//호출 완료되면 flag 값을 사용가능하게 변경
					},
	                error: function(error) {
	                    alert("오류 발생" + error);
	                }
	    		})
        	}
		}
        
        function moreButton_onClick(){
        	more += 1;
        	$("#pagination").hide();
        	searchMoreList(more);
        }
        
        function searchMoreList(more) {
        	
    		$.ajax({
                type: "post",
                url: "/sample/searchBoard",
                data: {
                	page : more,
                	pageSize : 10
                },
                success: function(data) {
                	var dataList = data.list;
                    for (var str in dataList) {
                        var tr = $("<tr></tr>").attr("data-id", dataList[str].bno).appendTo("#list");
                        $("<td></td>").text(dataList[str].bno).addClass("view_btn").appendTo(tr);
                        $("<td></td>").text(dataList[str].btitle).addClass("view_btn").appendTo(tr);
                        $("<td></td>").text(dataList[str].bwriter).addClass("view_btn").appendTo(tr);
                        $("<td></td>").text(dataList[str].bregDate).addClass("view_btn").appendTo(tr);
                    }
                    $("#b_count").text("전체 게시물 갯수 : " + data.totalCount);
                },
                error: function(error) {
                    alert("오류 발생" + error);
                }
    		})
        	
		}
        
        function updateBoard(){
        	window.location.href="/sample/sampleWrite?key=" + bNo;
        }
        
        function deleteBoard(){
        	window.location.href="/sample/deleteBoard?key=" + bNo;
        }
    </script>
</body>

</html>

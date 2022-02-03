<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시판 페이지</title>
    <!-- css 가져오기 -->
    <link rel="stylesheet" type="text/css" href="/resources/css/semantic.min.css">

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

    </style>
    <!-- js 가져오기 -->
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/semantic.min.js"></script>
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
                </div>

                <div class="ui error message"></div>

            </div>
        </div>
    </div>

    <div class="ui modal" id='view_modal'>
        <i class="close">x</i>
        <div class="header" id="b_title">
            
        </div>
        <div class="content">
            <div class="description">
            	<p style = "text-align: right" id = "b_review"></p>
            	<div id = 'b_content'></div>
            </div>
        </div>
        <div class="actions">
            <div class="ui black deny button">
                닫기
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $.ajax({
                type: "get",
                url: "/sample/searchBoard",
                success: function(data) {
                    console.log(data);
                    for (var str in data) {
                        var tr = $("<tr></tr>").attr("data-id", data[str].bno).appendTo("#list");
                        $("<td></td>").text(data[str].bno).addClass("view_btn").appendTo(tr);
                        $("<td></td>").text(data[str].btitle).addClass("view_btn").appendTo(tr);
                        $("<td></td>").text(data[str].bwriter).addClass("view_btn").appendTo(tr);
                        $("<td></td>").text(data[str].bregDate).addClass("view_btn").appendTo(tr);
                    }
                },
                error: function(error) {
                    alert("오류 발생" + error);
                }
            });

            $(document).on("click", ".view_btn", function() {
                var bno = $(this).parent().attr("data-id");

                $.ajax({
                    type: "get",
                    url: "/sample/selectBoard",
                    data: {
                        bNo: bno
                    },
                    success: function(data) {
                    	debugger;
                    	console.log(data);
                    	$("#b_title").text(data.btitle);
                    	$("#b_review").text(data.bwriter + " - " +  data.bregDate);
                    	$("#b_content").text(data.bcontent);
                    	$('#view_modal').modal('show');
                    },
                    error: function(error) {
                        alert("오류 발생" + error);
                    }
                });
            });
        });

    </script>
</body>

</html>

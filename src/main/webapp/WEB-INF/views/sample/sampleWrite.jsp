<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>게시글 작성하기</title>
    <!-- css 가져오기 -->
    <link rel="stylesheet" type="text/css" href="/resources/css/semantic.min.css">
	<!-- js 가져오기 -->
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script src="/resources/js/semantic.min.js"></script>
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
            max-width: 450px;
        }

    </style>
</head>

<body>
    <div class="ui middle aligned center aligned grid">
        <div class="column">
            <h2 class="ui teal image header">
                게시글 작성하기
            </h2>
            <form class="ui large form">
                <div class="ui stacked segment">
                    <div class="field">
                        <input type="text" id="b_title" placeholder="게시글 제목" autocomplete="off" autofocus="autofocus">
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <textarea style="resize: vertical;" id="b_content" placeholder="게시글 내용" rows="8"></textarea>
                        </div>
                    </div>
                    <div class="ui fluid large teal submit button" id="write_bbs">게시글 작성하기</div>
                </div>

                <div class="ui error message"></div>

            </form>

            <a href="/sample/sampleBoard"><button class="ui fluid large teal submit button">뒤로가기</button></a>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $("#write_bbs").click(function() {
                var json = {
                    bTitle: $("#b_title").val(),
                    bContent: $("#b_content").val()
                };

                for (var str in json) {
                    if (json[str].length == 0) {
                        alert($("#" + str).attr("placeholder") + "를 입력해주세요.");
                        $("#" + str).focus();
                        return;
                    }
                }

                $.ajax({
                    type: "post",
                    url: "/sample/insertBoard",
                    data: json,
                    success: function(data) {
                        switch (Number(data)) {
                            case 0:
								alert("정상적으로 등록이 되었습니다.");
								window.location.href = "/sample/sampleBoard";
                                break;
                            case 1:
                            	alert("알수없는 오류가 발생 했습니다.[Error Code : " + Number(data) + "]");
                                break;
                        }
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

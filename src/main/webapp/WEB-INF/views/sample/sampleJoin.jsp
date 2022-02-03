<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
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
                회원가입 페이지
            </h2>
            <div class="ui large form">
                <div class="ui stacked segment">
                    <div class="field">
                        <div class="ui left icon input">
                            <input type="text" id="u_id" placeholder="아이디" autofocus autocomplete="off">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <input type="password" id="u_pw" placeholder="비밀번호">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <input type="password" id="u_pw2" placeholder="비밀번호 확인">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <input type="text" id="u_nm" placeholder="이름">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                            <input type="text" id="u_email" placeholder="이메일 주소">
                        </div>
                    </div>
                    <button class="ui fluid large teal submit button" id="register_btn">회원가입</button>
                </div>

                <div class="ui error message"></div>

            </div>

            <div class="ui message">
                로그인 할 계정이 있다면 <a href="/sample">여기</a>를 눌러주세요.
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $("#register_btn").click(function() {
                var json = {
                    memId: $("#u_id").val(),
                    memPw: $("#u_pw").val(),
                    memPw2: $("#u_pw2").val(),
                   	memNm : $("#u_nm").val(),
                   	memEmail : $("#u_email").val()
                };

                for (var str in json) {
                    if (json[str].length == 0) {
                        alert($("#" + str).attr("placeholder") + " 정보를 입력해주세요.");
                        $("#" + str).focus();
                        return false;
                    }
                }
                
                if(json[1] != json[2]){
                	alert("입력하신 비밀번호와 비밀번호 확인이 다릅니다.");
                }

                $.ajax({
					type : "post",
					url : "/sample/insertMem",
					data : json,
					success : function(data) {
						switch (Number(data)) {
						case 0:
							alert("정상적으로 회원가입 되었습니다. 로그인화면으로 이동합니다.");
							window.location.href = "/sample";
							break;
						case 1:
							alert("아이디가 중복 되었습니다.");
							break;
						case 2:
							alert("알수없는 오류가 발생 했습니다. [Error Code :" + Number(data) + "]");
							break;
						}
					},
					error : function(error) {
						alert("오류 발생"+ error);
					}
				});
            });
        });

    </script>
</body>

</html>

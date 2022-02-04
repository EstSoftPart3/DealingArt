<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
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
            max-width: 450px;
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
 				로그인 페이지
            </h2>
            <form class="ui large form">
                <div class="ui stacked segment">
                    <div class="field">
                        <div class="ui left icon input">
                        	<!-- 아이디를 입력하는 input -->
                            <input type="text" id="u_id" placeholder="아이디">
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui left icon input">
                        	<!-- 패스워드를 입력하는 input -->
                            <input type="password" id="u_pw" placeholder="비밀번호">
                        </div>
                    </div>
                    <div class="ui fluid large teal submit button" id = "login_btn">로그인</div>
                </div>

                <div class="ui error message"></div>

            </form>

            <div class="ui message">
            	<!-- 클릭시 회원가입 화면으로 이동한다 -->
                로그인 할 계정이 없다면 <a href="/sample/sampleJoin">여기</a>를 눌러주세요.
            </div>
        </div>
    </div>
    <script>
	    $(document).ready(function(){ //화면 오픈시에 바로 실행된다
			$("#login_btn").click(function(){ //로그인 버튼을 클릭시
				var json = { //JSON 방식으로 입력된 id와 pw를 담는다
					memId : $("#u_id").val(),
					memPw : $("#u_pw").val()
				};
				
				for(var str in json){ //for문을 JSON에 존재하는 행만큼 돌린다
					if(json[str].length == 0){ //행이 갖고 있는 value의 길이가 0이면
						alert($("#" + str).attr("placeholder") + "를 입력해주세요."); //입력이 안된 input을 입력하라는 메세지를 띄운다
						$("#" + str).focus(); //입력이 안된 input으로 포커스를 준다
						return;
					}
				}
				
				 $.ajax({
					type : "post",
					url : "/sampleLogin", //컨트롤러에 맵핑된 url를 보내준다
					data : json,
					success : function(data) { //ajax가 성공적으로 통신이 되면
						switch (Number(data)) {
						case 0: //컨트롤러에서 0을 리턴해주면
							alert("아이디 또는 비밀번호가 일치하지 않습니다."); //메시지창을 띄운다
							break;
						case 1: //1을 리턴해주면
							window.location.href = "/sample/sampleBoard"; //게시판 페이지로 이동하는 url을 컨트롤러에 보낸다
	
						default:
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

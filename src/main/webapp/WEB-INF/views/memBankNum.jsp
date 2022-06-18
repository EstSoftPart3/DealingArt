<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	/************************************************************************************************
		NICE평가정보 Copyright(c) KOREA INFOMATION SERVICE INC. ALL RIGHTS RESERVED
		
		서비스명 : 계좌확인 서비스 
		페이지명 : 계좌확인 입력 페이지 - 계좌 소유주 확인
	*************************************************************************************************/
%>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>NICE평가정보 계좌확인 서비스</title>
	<style type="text/css">
		input, select{
			margin: 2px;
			padding: 4px;
		}

		button {
			margin: 10px 2px;
			padding: 10px;
		}

		#form_bc {
			margin: auto;
			width: 700px;
			border: 1px solid black;
			padding: 10px;
		}
	</style>	
	<script>
		function bcSubmit(bcType){
			if(bcType == "A"){
				// 계좌 소유주 확인
				document.form_bc.service.value = "1";
				document.form_bc.svcGbn.value = "5";
			}
			else if(bcType == "B"){
				// 계좌 예금주명 확인
				document.form_bc.service.value = "2";
				document.form_bc.svcGbn.value = "2";
			}
			else
			{
				// 계좌 유효성 확인
				document.form_bc.service.value = "3";
				document.form_bc.svcGbn.value = "4";
			}
			document.form_bc.action = "/memBankRequest";
			document.form_bc.submit();
		} 
	</script>
</head>	
<body>
	<!-- NICE 계좌인증 form -->
	<form name="form_bc" method="post">
		<!-- 서비스구분 (1: 소유주 확인, 2: 예금주명 확인, 3: 계좌 유효성 확인) -->
		<input type="hidden" name="service" value="">
		<!-- 업무구분 (5: 소유주 확인, 2: 예금주명 확인, 4: 계좌 유효성 확인) -->
		<input type="hidden" name="svcGbn" value="">
		<!-- 계좌구분 (1:개인계좌, 2:법인계좌) -->
		<input type="radio" name="strGbn" id="strGbn1" value="1" checked="checked">
		<label for="strGbn1">개인계좌</label>
		<input type="radio" name="strGbn" id="strGbn2" value="2">
		<label for="strGbn2">법인계좌</label>
		<br>
		<!-- 은행코드 -->
		<label for="strBankCode">은행코드</label>
		<select name="strBankCode">
			<option value="002">산업은행</option>
			<option value="003">기업은행</option>
			<option value="004">국민은행</option>
			<option value="007">수협</option>
			<option value="011">농협</option>
			<option value="020">우리은행</option>
			<option value="023">SC제일은행</option>
			<option value="027">한국씨티은행</option>
			<option value="031">대구은행</option>
			<option value="032">부산은행</option>
			<option value="034">광주은행</option>
			<option value="035">제주은행</option>
			<option value="037">전북은행</option>
			<option value="039">경남은행</option>
			<option value="045">새마을금고</option>
			<option value="048">신협</option>
			<option value="071">우체국</option>
			<option value="081">하나은행</option>
			<option value="088">신한은행</option>
		</select>
		<!-- 계좌번호 -->
		<label for="strAccountNo">계좌번호</label>
		<input type="text" name="strAccountNo" maxlength="40" size="40" value="">
		<br>
		<!-- 예금주명 -->
		<label for="name">예금주명</label>
		<input type="text" name="name" maxlength="40" size="16" value="">
		<br>
		<!-- 생년월일/사업자번호 -->
		<label for="birth">생년월일</label>
		<input type="text" name="birth" maxlength="10" size="10" value="">
		<span>(생년월일 6자리 / 사업자번호 10자리)</span>
		<br>
		<!-- 계좌인증 버튼 -->
		<button onclick="javascript:bcSubmit('A');" >계좌 소유주 확인</button> (계좌번호 + 예금주명 + 생년월일)
	</form>	
</body>
</html>
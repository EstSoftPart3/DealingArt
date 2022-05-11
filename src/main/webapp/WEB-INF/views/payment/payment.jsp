<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<%    
	//READY API 호출 URL
	String READY_API_URL = "/payment/readyApi";
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://api-std.mainpay.co.kr/js/mainpay.pc-1.1.js"></script>
<script type='text/javascript'> 
<%-- 	var READY_API_URL = "<%=READY_API_URL%>"; --%>
// 	function payment() {		
// 		var request = Mainpay.ready(READY_API_URL); 
// 		request.done(function(response) {
// 			if (response.resultCode == '200') {
// 				/* 결제창 호출 */
// 				Mainpay.open(response.data.nextPcUrl); //*주의* PC와 Mobile은 URL이 상이합니다.
// 				return false;
// 			}
// 			alert("ERROR : "+JSON.stringify(response));			 				
// 		});		
// 	}
// 	/* 결제 팝업이 닫혔을 경우 호출*/
// 	function mainpay_close_event() {
// 		alert("결제창이 닫혔습니다.");  
// 	}
function payment() {
	var data = {
			paymethod : $("#paymethod").val()
			, goods_code : $("#goods_code").val()
			, goods_name : $("#goods_name").val()
			, amount : $("#amount").val()
			, customer_name : $("#customer_name").val()
			, customer_email : $("#customer_email").val()
			, mbr_sq : $("#mbr_sq").val()
			, mbrRefNo : "1"
	}
	$.ajax({
		type: "POST",
		contentType: 'application/json',
           url: "/payment/readyApi",
           dataType: 'json',
           data: JSON.stringify(data),
           async: false,
		success:function(response){
			console.log(response);
			if (response.resultCode == '200') {
				/* 결제창 호출 */
				Mainpay.open(response.data.nextPcUrl); //*주의* PC와 Mobile은 URL이 상이합니다.
				return false;
			}
		}
	});
}

function cancel() {
	var data = {
			sid : $("#can_sid").val()
	}
	
	$.ajax({
		type: "POST",
		contentType: 'application/json',
           url: "/payment/all-cancel",
           dataType: 'json',
           data: JSON.stringify(data),
           async: false,
		success:function(response){
			console.log(response);
			if (response.resultCode == '200') {
				/* 결제창 호출 */
				return false;
			}
		}
	});
}

function refund_reg() {
	var data = {
			sid : $("#ref_reg_sid").val()
			, bank_code : $("#bank_code").val()
			, account_no : $("#account_no").val()
			, account_owner : $("#account_owner").val()
			, birth_day : $("#birth_day").val()
			, amount : $("#amount").val()
	}
	
	$.ajax({
		type: "POST",
		contentType: 'application/json',
           url: "/payment/ref-register",
           dataType: 'json',
           data: JSON.stringify(data),
           async: false,
		success:function(response){
			console.log(response);
			if (response.resultCode == '200') {
				/* 결제창 호출 */
				return false;
			}
		}
	});
}

function refund_sel() {
	var data = {
			sid : $("#ref_sel_sid").val()
	}
	
	$.ajax({
		type: "POST",
		contentType: 'application/json',
           url: "/payment/ref-select",
           dataType: 'json',
           data: JSON.stringify(data),
           async: false,
		success:function(response){
			console.log(response);
			if (response.resultCode == '200') {
				/* 결제창 호출 */
				return false;
			}
		}
	});
}

function refund_can() {
	var data = {
			sid : $("#ref_can_sid").val()
	}
	
	$.ajax({
		type: "POST",
		contentType: 'application/json',
           url: "/payment/ref-cancel",
           dataType: 'json',
           data: JSON.stringify(data),
           async: false,
		success:function(response){
			console.log(response);
			if (response.resultCode == '200') {
				/* 결제창 호출 */
				return false;
			}
		}
	});
}

function receipt_trans() {
	var data = {
			sid : $("#rec_trans_sid").val()
			, person_type : $("#person_type").val()
			, customer_pk : $("#customer_pk").val()
	}
	
	$.ajax({
		type: "POST",
		contentType: 'application/json',
           url: "/payment/cash-receipt-trans",
           dataType: 'json',
           data: JSON.stringify(data),
           async: false,
		success:function(response){
			console.log(response);
			if (response.resultCode == '200') {
				/* 결제창 호출 */
				return false;
			}
		}
	});
}

function receipt_trans() {
	var data = {
			sid : $("#rec_can_sid").val()
	}
	
	$.ajax({
		type: "POST",
		contentType: 'application/json',
           url: "/payment/cash-receipt-cancel",
           dataType: 'json',
           data: JSON.stringify(data),
           async: false,
		success:function(response){
			console.log(response);
			if (response.resultCode == '200') {
				/* 결제창 호출 */
				return false;
			}
		}
	});
}

</script>  
</head>
<body>
	<p>PC 버전 샘플 주문페이지(NoFrame)</p>
	<div>
		<!-- id 고정 -->
		<form id="MAINPAY_FORM">
			지불수단 <input type="text" name="paymethod" id="paymethod" value="CARD"> <br>
			상품코드 <input type="text" name="goods_code" id="goods_code" value="GOOD0001"> <br> 
			상품명칭 <input type="text" name="goods_name" id="goods_name" value="카약-슬라이더406"> <br><br>
			결제금액 <input type="text" name="amount" id="amount" value="1004"> <br><br>
			고객 seq <input type="hidden" name="mbr_sq" id="mbr_sq" value="45"> <br><br>
			고객명 <input type="text" name="customer_name" id="customer_name" value="고객명"> <br><br>
			고객 E-mail <input type="text" name="customer_email" id="customer_email" value="test@test.com"> <br><br>
		</form>
		<button type="button" class="btn_submit" onclick="payment()">결제요청</button>
	</div>
	
	<div>
		<!-- id 고정 -->
		<form id="MAINPAY_FORM">
			결제완료 seq(sid) <input type="text" name="can_sid" id="can_sid" value="1"> <br>
		</form>
		<button type="button" class="btn_submit" onclick="cancel()">취소요청</button>
	</div>
	
	<div>
		<!-- id 고정 -->
		<form id="MAINPAY_FORM">
			결제완료 seq(sid) <input type="text" name="ref_reg_sid" id="ref_reg_sid" value="1"> <br>
			환불계좌 은행사코드 (공통코드표 참고) <input type="text" name="bank_code" id="bank_code" value=""> <br> 
			환불계좌번호 <input type="text" name="account_no" id="account_no" value="계좌번호"> <br><br>
			환불계좌주명 <input type="text" name="account_owner" id="account_owner" value="이름"> <br><br>
			계좌주 생년월일(YYMMDD) <input type="text" name="birth_day" id="birth_day" value="860716"> <br><br>
			환불금액 <input type="text" name="amount" id="amount" value="1000"> <br><br>
		</form>
		<button type="button" class="btn_submit" onclick="refund_reg()">환불요청</button>
	</div>
	
	<div>
		<!-- id 고정 -->
		<form id="MAINPAY_FORM">
			결제완료 seq(sid) <input type="text" name="ref_sel_sid" id="ref_sel_sid" value="1"> <br>
		</form>
		<button type="button" class="btn_submit" onclick="refund_sel()">환불 상태 조회</button>
	</div>
	
	<div>
		<!-- id 고정 -->
		<form id="MAINPAY_FORM">
			결제완료 seq(sid) <input type="text" name="ref_can_sid" id="ref_can_sid" value="1"> <br>
		</form>
		<button type="button" class="btn_submit" onclick="refund_can()">환불 취소</button>
	</div>
	
	<div>
		<!-- id 고정 -->
		<form id="MAINPAY_FORM">
			결제완료 seq(sid) <input type="text" name="rec_trans_sid" id="rec_trans_sid" value="1"> <br>
			발행인구분(01:개인 | 02:법인,개인사업자) <input type="text" name="person_type" id="person_type" value="01"> <br>
			구매자 식별자 (휴대폰번호, 주민등록번호, 사업자번호, 자진발급[01000001234] 고정) <input type="text" name="customer_pk" id="customer_pk" value="01099428461"> <br>
		</form>
		<button type="button" class="btn_submit" onclick="receipt_trans()">현금영수증 발행</button>
	</div>
	
	<div>
		<!-- id 고정 -->
		<form id="MAINPAY_FORM">
			결제완료 seq(sid) <input type="text" name="rec_can_sid" id="rec_can_sid" value="1"> <br>
		</form>
		<button type="button" class="btn_submit" onclick="receipt_can()">현금영수증 발행 취소</button>
	</div>
</body>
</html>

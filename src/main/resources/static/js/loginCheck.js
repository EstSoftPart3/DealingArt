
/******************************************************** 
   파일명 : common.js
*********************************************************/ 

/* ---------------------------------------------
 * 함수명 : loginCheck
 * 설  명 : 로그인 제한 공통 함수
 * 예) loginCheck(requestUrl,SqNumber)
 ---------------------------------------------*/
 
 function loginCheck(requestUrl,SqNumber){
	$.ajax({
		type: "post",
		url: requestUrl,
		data: {
			SqNumber : SqNumber
		},
		success: function(data) {
			if(data != null && data != ""){
				window.location.href = requestUrl+"?SqNumber="+SqNumber;
			}else{
				$(".close").trigger("click");
	        	modalConfirm("로그인 후 이용 하실 수 있습니다..<br><br>확인 버튼을 누르시면 로그인 페이지로 이동합니다.", 
        			function(confrim){
	        			if(confrim){
	        				$("#loginModal").modal("show");	
	        			}
        			}
	        	);
			}
		},
		error: function(error) {
			alert("오류 발생" + error);
		}
	});
}
/* ---------------------------------------------
 * 함수명 : loginCheckUrl
 * 설  명 : 로그인 제한 공통 함수 url로만 이동 시
 * 예) loginCheck(requestUrl,SqNumber)
 ---------------------------------------------*/
 function loginCheckUrl(requestUrl){
	$.ajax({
		type: "post",
		url: requestUrl,
		success: function(data) {
			if(data != null && data != ""){
				window.location.href = requestUrl;
			}else{
				$(".close").trigger("click");
        		modalConfirm("로그인 후 이용 하실 수 있습니다..<br><br>확인 버튼을 누르시면 로그인 페이지로 이동합니다.", 
        			function(confrim){
	        			if(confrim){
	        				$("#loginModal").modal("show");	
	        			}
        			}
        		);
			}
		},
		error: function(error) {
			alert("오류 발생" + error);
		}
	});
}
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	/********************************************************************************	
	  결제창 종료시에 PG사에서 호출하는 페이지 입니다.
	  상점에서 필요한 로직 추가	
	********************************************************************************/
%>
<html>
<head>
<script src="https://api-std.mainpay.co.kr/js/mainpay.pc-1.1.js"></script>
<script type='text/javascript'> 
opener.parent.location.reload(); 
window.close();
</script>

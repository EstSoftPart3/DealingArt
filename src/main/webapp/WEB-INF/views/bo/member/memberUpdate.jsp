<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<style type="text/css">
	input[readonly].classname{
 		 background-color:#ffffff;
	}
	 .LabelStyle
    {
    	background-color:#efefef;
    	width:100px;
    }	
   
</style>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		     
		     <!-- Main content -->
    		<section class="content">
    			 <div class="card-header">
	               	<h3 class="card-title bTitle">회원 수정</h3>
				</div>
				
				<form class="form-horizontal" name="form_member" id="form_member">
				
				<input type="hidden" name="mbrSq" value="<c:out value="${param.mbrSqParam}" />">
				
                <div class="card-body" style="background-color:#ffffff;">
                	
                	<div class="card-body table-responsive p-0" style="overflow:hidden;">
                		<hr>
                    	<div class="form-group row">
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">회원구분</label>
                    		<div class="col-sm-3">
                    			<div class="btn-group btn-group-toggle" data-toggle="buttons">
                                   <label class="btn btn-secondary sTitle r1">
                    					<input type="radio" name="authSq"  class="authSq sTitle" autocomplete="off" value="1"> 일반
                  					</label>
                  					<label class="btn btn-secondary sTitle r2">
                    					<input type="radio" name="authSq" class="authSq sTitle" autocomplete="off" value="2"> 작가
                  					</label>
                  					<label class="btn btn-secondary sTitle r3">
                    					<input type="radio" name="authSq" class="authSq sTitle" autocomplete="off" value="3"> 관리자
                  					</label>
                  					<label class="btn btn-secondary sTitle r4">
                    					<input type="radio" name="authSq" class="authSq sTitle" autocomplete="off" value="4"> 전체관리자
                  					</label>
                				</div>
                    		</div>
                  		</div>
	              	   <hr>
		               <div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">아이디</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrId" name="mbrId">
                      		</div>
                    	</div>
                    	<hr>
                  		<div class="form-group row">
                  			<label class="col-form-label sTitle LabelStyle" style="text-align: center;">성명</label>
                    		<div class="col-sm-3">
                    		
                    		<input type="text" class="form-control sTitle classname" id="mbrNm" name="mbrNm">
                    		</div>
                    	</div>
                    	<hr>
                    	<div class="form-group row">
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">생년월일</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrBirth" name="mbrBirth">
                      			
                      		</div>
                    	</div>
                    	
                    	<hr>
                    	<div class="form-group row">
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">성별</label>
                    		<div class="col-sm-3">
                    			<div class="btn-group btn-group-toggle" data-toggle="buttons">
                                   <label class="btn btn-secondary sTitle sm">
                    					<input type="radio" name="mbrSexCd"  class="mbrSexCd sTitle" autocomplete="off" value="MALE"> 남
                  					</label>
                  					<label class="btn btn-secondary sTitle sf">
                    					<input type="radio" name="mbrSexCd" class="mbrSexCd sTitle" autocomplete="off" value="FEMALE"> 여
                  					</label>
                				</div>
                    		</div>
                  		</div>
                  		<hr>
                  		<div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">닉네임</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrNcknm" name="mbrNcknm" disabled>
                    		</div>
                    	</div>
                  		<hr>
                  		<div class="form-group row">
		               		
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">이메일</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrEmail" name="mbrEmail" autocomplete="false">
                    		</div>
                    		
                  		</div>
                  		<hr>
                  		<div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">휴대폰번호</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrCpNum" name="mbrCpNum" autocomplete="false">
                    		</div>
                    		
                  		</div>
                  		<hr>
                  		<div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">집주소</label>
                    		<div class="col-sm-5">
                      			<input type="text" class="form-control sTitle classname" id="mbrHomeAddr" name="mbrHomeAddr" autocomplete="false">
                      		</div>
                    		<div class="col-sm-1">
                    			<button type="button" class="btn btn-primary sTitle" onclick="userAddress('mbrHomeAddr');">주소찾기</button>
                    		</div>
                  		</div>
                  		<hr>
                  		<div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">배송지 주소</label>
                    		<div class="col-sm-5">
                      			<input type="text" class="form-control sTitle classname" id="mbrDelivryAddr" name="mbrDelivryAddr" autocomplete="false">
                    		</div>
                    		<div class="col-sm-1">
                    			<button type="button" class="btn btn-primary sTitle" onclick="userAddress('mbrDelivryAddr');">주소찾기</button>
                    		</div>
                  		</div>
                  		
                  		<hr>
                  		<div class="form-group row">
		               		
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">사용여부</label>
                    		<div class="col-sm-3">
                      			<div class="btn-group btn-group-toggle" data-toggle="buttons">
                                   <label class="btn btn-secondary sTitle useY">
                    					<input type="radio" name="useYn" class="sTitle" autocomplete="off" value="Y"> 사용
                  					</label>
                  					<label class="btn btn-secondary sTitle useN">
                    					<input type="radio" name="useYn" class="sTitle" autocomplete="off" value="N"> 미사용
                  					</label>
                				</div>
                			</div>
                  		</div>
                  		<div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">비밀번호</label>
                    		<div class="col-sm-5">
                    			<button type="button" class="btn btn-primary sTitle" onclick="fn_passwdClear();">초기화</button>
                    			<span> 초기화 된 비밀번호 : a123456!</span>
                    		</div>
                  		</div>
                  		
                    </div>
                  
                </div>
                <!--card-body -->
                
                <!--card-footer -->
                <div class="card-footer" style="text-align:right">
                  <button type="button" class="btn btn-info sTitle" onclick="goList();">목록</button>
                  <button type="button" class="btn btn-info sTitle" onclick="memberUpdate();">수정</button>
                </div>
                
              </form>
				
    		</section>
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   
   <script>
   		
		var dataContent = {};
		var mbrSq = '<c:out value="${param.mbrSqParam}" />';
		var authSq = '<c:out value="${param.mbrAuthSq}" />';
	   
		$(document).ready(function(){
			
			memberContentData(mbrSq);
			
		});
		
		//회원 정보 호출
		function memberContentData(mbrSq) {
			
			console.log("mbrSq : "+ mbrSq);
			
			$.ajax({
		           type: "post",
		           url: "memberContentData",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(data) {
		        	   
		        	    
		        	 dataContent = data.memberContentData.memberContent[0];
		        	 
		        	 //console.log(dataContent);
		        	 var mbrNm = dataContent.mbrNm						//이름
		        	 var mbrId = dataContent.mbrId						//아이디
		        	 var mbrNcknm = dataContent.mbrNcknm				//닉네임
		        	 var mbrEmail = dataContent.mbrEmail				//이메일
		        	 var mbrBirth = dataContent.mbrBirth				//생년월일
		        	 var mbrSexCdChk = dataContent.mbrSexCdChk			//성별
		        	 var mbrCpNum = dataContent.mbrCpNum				//휴대폰번호
		        	 var regDt = dataContent.regDt						//회원등록일시
		        	 var mbrHomeAddr = dataContent.mbrHomeAddr			//집주소
		        	 var mbrDelivryAddr = dataContent.mbrDelivryAddr	//배송지 주소
		        	 var useYn = dataContent.useYn						//사용여부
		        	 var authSq = dataContent.authSq					//회원구분
		        	 
		        	 
		        	 if(authSq == '1') {
		        		 
		        		 $(":radio[name='authSq'][value='1']").attr('checked', true);
		        		 $('.r1').addClass('active');
			        	 $('.r2').removeClass('active');
			        	 $('.r3').removeClass('active');
			        	 $('.r4').removeClass('active');
			         } 
		        	 if(authSq == '2') {
			        	 $(":radio[name='authSq'][value='2']").attr('checked', true);
			         	 
			        	 $('.r1').removeClass('active');
			        	 $('.r2').addClass('active');
			        	 $('.r3').removeClass('active');
			        	 $('.r4').removeClass('active');
					 }
		        	 if(authSq == '3') {
			        	 $(":radio[name='authSq'][value='3']").attr('checked', true);
			        	 $('.r1').removeClass('active');
			        	 $('.r2').removeClass('active');
			        	 $('.r3').addClass('active');
			        	 $('.r4').removeClass('active');
					 }
		        	 if(authSq == '4') {
			        	 $(":radio[name='authSq'][value='4']").attr('checked', true);
			        	 $('.r1').removeClass('active');
			        	 $('.r2').removeClass('active');
			        	 $('.r3').removeClass('active');
			        	 $('.r4').addClass('active');
					 }
		        	 
		        	 
		        	 $("#mbrNm").val(mbrNm);
		        	 $("#mbrId").val(mbrId);
		        	 $("#mbrNcknm").val(mbrNcknm);
		        	 $("#mbrEmail").val(mbrEmail);
		        	 $("#mbrBirth").val(mbrBirth);
		        	 
		        	 if(mbrSexCdChk == 'MALE') {
		        		 $(":radio[name='mbrSexCd'][value='MALE']").attr('checked', true);
		        		 $('.sm').addClass('active');
			        	 $('.sf').removeClass('active');
			         } else {
			         	 $(":radio[name='mbrSexCd'][value='FEMALE']").attr('checked', true);
			         	 $('.sf').addClass('active');
			        	 $('.sm').removeClass('active');
					 }
		        	 
		        	 $("#mbrCpNum").val(mbrCpNum);
		        	 $("#regDt").val(regDt);
		        	 $("#mbrHomeAddr").val(mbrHomeAddr);
		        	 $("#mbrDelivryAddr").val(mbrDelivryAddr);
		        	 
		        	 if(useYn == 'Y') {
		        		$(":radio[name='useYn'][value='Y']").attr('checked', true);
		        		$('.useY').addClass('active');
		        		$('.useN').removeClass('active');
		        	 } else {
		        		$(":radio[name='useYn'][value='N']").attr('checked', true);
		        		$('.useN').addClass('active');
		        		$('.useY').removeClass('active');
					 }
					
		        	 
				
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}
   		
		    
        //회원가입 validation
        function memberUpdate() {
        	
        	//회원구분
        	var authSq = $("#authSq").val();
        	
        	//아이디
        	var mbrId = $("#mbrId").val();
        	//성명
        	var mbrNm = $("#mbrNm").val();
        	//닉네임
        	var mbrNcknm = $("#mbrNcknm").val();
        	//이메일
        	var mbrEmail = $("#mbrEmail").val();
        	//휴대번호
        	var mbrCpNum = $("#mbrCpNum").val();
        	//성별
        	var mbrSexCd = $('input[name="mbrSexCd"]:checked').val();
        	//사용 유무
        	var useYn = $('input[name="useYn"]:checked').val();
        	//주소
        	var mbrHomeAddr = $("#mbrHomeAddr").val();
        	
        	//이메일
        	if(isEmpty(mbrEmail)) {
        		bootbox.alert({
					 message: "이메일을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrEmail").focus();
				     } });
				 return;
        	}
        	//휴대번호
        	if(isEmpty(mbrCpNum)) {
        		bootbox.alert({
					 message: "휴대폰 번호를 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrCpNum").focus();
				     } });
				 return;
        	}
        	
        				
			var queryString = $("form[name=form_member]").serialize();
			
			console.log(queryString);
			$.ajax({
		           type: "post",
		           url: "memberUpdateData",
		           data: queryString,
		           success: function(data) {
		        	   bootbox.alert({
							 message: "회원정보 수정이 완료 되었습니다.",
							 locale: 'kr',
							 callback: function() {
								 	memberContent();
						     } });
				   },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}
        
       

   		//일반회원 목록 이동
		function goList(){
			location.href = '/admin/member/memberList';
		}

		//생년월일
        $('#mbrBirth').daterangepicker({
        	singleDatePicker: true,
            timePicker: false,
            showDropdowns: true,
            locale: {
            	format: 'YYYY-MM-DD',
            	"daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
            	"monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
            }
        })
        
        //Input Box Null Check
        function isEmpty(str){
            
            if(typeof str == "undefined" || str == null || str == "")
                return true;
            else
                return false ;
        }
        
      	//다음 주소 찾기
   		function userAddress(inputId) {
   			    
		     new daum.Postcode({
		           oncomplete: function(data) { //선택시 입력값 세팅
		           document.getElementById(inputId).value = data.address; // 주소 넣기
		        }
		    }).open();
	    }
      
      
   		//회원 상세정보 이동
   		function memberContent() {
   			
   			var mbrSq = '<c:out value="${param.mbrSqParam}" />';
   			
   			var authSq = '<c:out value="${param.mbrAuthSq}" />';
   			
   			let param = {
   				mbrSqParam : mbrSq,
   				mbrAuthSq : authSq 
   			}
   		
   			var contentUrl = "/admin/member/memberContent";
   			postForm(contentUrl, param);
   			
   		}
   		   		
   		function postForm(path, params, method) {
   		    method = method || 'post';

   		    var form = document.createElement('form');
   		    form.setAttribute('method', method);
   		    form.setAttribute('action', path);

   		    for (var key in params) {
   		        if (params.hasOwnProperty(key)) {
   		            var hiddenField = document.createElement('input');
   		            hiddenField.setAttribute('type', 'hidden');
   		            hiddenField.setAttribute('name', key);
   		            hiddenField.setAttribute('value', params[key]);

   		            form.appendChild(hiddenField);
   		        }
   		    }

   		    document.body.appendChild(form);
   		    form.submit();
   		}
	
   		//비밀번호 초기화
		function fn_passwdClear() {
			
			console.log("mbrSq : "+ mbrSq);
			
			$.ajax({
		           type: "post",
		           url: "/admin/member/memberPasswdClear",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(data) {
		        	   bootbox.alert({
							 message: "비밀번호 초기화가 완료 되었습니다.",
							 locale: 'kr',
							 callback: function() {
								 	memberContent();
						     } });
				   },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}

	</script>
 
 
 
 
</body>
</html>
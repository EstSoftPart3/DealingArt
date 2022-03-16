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
	               	<h3 class="card-title bTitle">회원 등록</h3>
				</div>
				
				<form class="form-horizontal" name="form_member" id="form_member">
				
				<!-- 아이디 중복 체크 -->
				<input type="hidden" name="id_check_sucess" id="id_check_sucess" value="N">
				<!-- 닉네임 중복 체크 --> 
				<input type="hidden" name="ncknm_check_sucess" id="ncknm_check_sucess" value="N">
                
                <div class="card-body" style="background-color:#ffffff;">
                	
                	<div class="card-body table-responsive p-0" style="overflow:hidden;">
	              	   <hr>
		               <div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">아이디</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrId" name="mbrId">
                      		</div>
                    		<div class="col-sm-1">
                      			<button type="button" class="btn btn-primary sTitle" id="member_id_chk_btn" onclick="member_id_chk();">아이디 중복확인</button>
                      			<button type="button" class="btn btn-primary sTitle" id="member_id_change_btn" onclick="member_id_change();" style="display:none">아이디 변경</button>
                    		</div>
                    	</div>
                    	<hr>
		                <div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">비밀번호</label>
                    		<div class="col-sm-3">
                      			<input type="password" class="form-control sTitle classname" id="mbrPasswrd" name="mbrPasswrd" autocomplete="false">
                      		</div>
                      		<div class="col-sm-1" style=" vertical-align: middle;">
                      			<button type="button" class="btn btn-primary sTitle" id="keyShow" style="float:left;">SHOW</button>
                      		</div>
                      	</div>
                      	<hr>
                      	<div class="form-group row">
                      		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">비밀번호확인</label>
                    		<div class="col-sm-3">
                      			<input type="password" class="form-control sTitle classname" id="mbrPasswrdConfirm" name="mbrPasswrdConfirm" autocomplete="false">
                    		</div>
                    		<div class="col-sm-1" style=" vertical-align: middle;">
                      			<button type="button" class="btn btn-primary sTitle" id="keyShowConfirm" style="float:left;">SHOW</button>
                      		</div>
                    	</div>
                  		<hr>
                  		<div class="form-group row">
                  			<label class="col-form-label sTitle LabelStyle" style="text-align: center;">성명</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrNm" name="mbrNm" autocomplete="false">
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
                                   <label class="btn btn-secondary sTitle">
                    					<input type="radio" name="mbrSexCd"  class="mbrSexCd sTitle" autocomplete="off" value="MALE" checked> 남
                  					</label>
                  					<label class="btn btn-secondary sTitle">
                    					<input type="radio" name="mbrSexCd" class="mbrSexCd sTitle" autocomplete="off" value="FEMALE"> 여
                  					</label>
                				</div>
                    		</div>
                  		</div>
                  		<hr>
                  		<div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">닉네임</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname" id="mbrNcknm" name="mbrNcknm" autocomplete="false">
                    		</div>
                    		<div class="col-sm-3">
                      			<button type="button" class="btn btn-primary sTitle" id="member_mbrNcknm_chk_btn" onclick="member_mbrNcknm_chk();">닉네임 중복확인</button>
                      			<button type="button" class="btn btn-primary sTitle" id="member_mbrNcknm_change_btn" onclick="member_mbrNcknm_change();" style="display:none">닉네임 변경</button>
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
                                   <label class="btn btn-secondary sTitle">
                    					<input type="radio" name="useYn" class="mbrSexCd sTitle" autocomplete="off" checked value="Y"> 사용
                  					</label>
                  					<label class="btn btn-secondary sTitle">
                    					<input type="radio" name="useYn" class="mbrSexCd sTitle" autocomplete="off" value="N"> 미사용
                  					</label>
                				</div>
                    		</div>
                  		</div>
                  		
                    </div>
                  
                </div>
                <!--card-body -->
                
                <!--card-footer -->
                <div class="card-footer" style="text-align:right">
                  <button type="button" class="btn btn-info sTitle" onclick="goList();">목록</button>
                  <button type="button" class="btn btn-info sTitle" onclick="memberInput();">등록</button>
                </div>
                
              </form>
				
    		</section>
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   
   <script>
   		
   		
		    
        //회원가입 validation
        function memberInput() {
        	
        	//회원아이디
        	var mbrId = $("#mbrId").val();
        	//비밀번호
        	var mbrPasswrd = $("#mbrPasswrd").val();
        	//비밀번호 확인
        	var mbrPasswrdConfirm = $("#mbrPasswrdConfirm").val();
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
        	//회원 아이디 중복 체크 유무
        	var id_check_sucess = $("#id_check_sucess").val();
        	//닉네임 아이디 중복 체크 유무
        	var ncknm_check_sucess = $("#ncknm_check_sucess").val();
        	
        	if(isEmpty(mbrId)) {
        		bootbox.alert({
					 message: "아이디를 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrId").focus();
				     } });
				 return false;
        	} 
        	
        	if(id_check_sucess == "N") {
        		bootbox.alert({
					 message: "아이디 중복 체크를 해주세요.",
					 locale: 'kr',
					});
				 return;	 
        	}
        	
        	//비밀번호
        	if(isEmpty(mbrPasswrd)) {
        		bootbox.alert({
					 message: "비밀번호를 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrPasswrd").focus();
				     } });
				 return;
        	}
        	
        	//비밀번호 확인
        	if(isEmpty(mbrPasswrdConfirm)) {
        		bootbox.alert({
					 message: "비밀번호 확인을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrPasswrdConfirm").focus();
				     } });
				 return;
        	}
        	
        	//비밀번호.비밀번호확인 일치 체크
        	if(mbrPasswrd != mbrPasswrdConfirm) {
        		bootbox.alert({
					 message: "비밀번호가 일치 하지 않습니다. <br> 비밀번호 확인을 다시 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
						 $("#mbrPasswrdConfirm").val('');	
					 } });
        		return;
        	}
        	
        	//성명
        	if(isEmpty(mbrNm)) {
        		bootbox.alert({
					 message: "성명을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrNm").focus();
				     } });
				 return;
        	}
        	
        	//닉네임
        	if(isEmpty(mbrNcknm)) {
        		bootbox.alert({
					 message: "닉네임을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrNcknm").focus();
				     } });
				 return;
        	}
        	//닉네임 중복 체크      	        	
        	if(ncknm_check_sucess == "N") {
        		bootbox.alert({
					 message: "닉네임 중복 체크를 해주세요.",
					 locale: 'kr',
					});
				 return;	 
        	}
        	
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
        	
        	//주소
        	/* if(isEmpty(mbrHomeAddr)) {
        		bootbox.alert({
					 message: "주소를 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrHomeAddr").focus();
				     } });
				 return;
        	} */
        	        				
			var queryString = $("form[name=form_member]").serialize();
			
			
			$.ajax({
		           type: "post",
		           url: "memberInsertData",
		           data: queryString,
		           success: function(data) {
		        	   bootbox.alert({
							 message: "회원가입이 완료 되었습니다.",
							 locale: 'kr',
							 callback: function() {
							 		location.href='/admin/member/memberList';
						     } });
				   },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			})
		}
        
        //아이디 중복 체크
        function member_id_chk() {
        	
        	var dataCheckCount = {};
        	
        	var mbrIdParam = $("#mbrId").val();
        	       	
        	if(isEmpty(mbrIdParam)) {
        		bootbox.alert({
					 message: "아이디를 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrId").focus();
				     } });
				 return;
        	}
        	
        	
        	$.ajax({
        		   type: "post",
        		   url: "memberChkData",
        		   data: {
        			   mbrId : mbrIdParam
        		   },
        		   success: function(data) {
        			   
        			dataCheckCount = data.memberCheck.memberCheck[0];
        			
        			if(dataCheckCount == 0) {
        				$("#id_check_sucess").val('Y');
        				
        				bootbox.alert({ message: "사용 가능한 아이디 입니다.",locale: 'kr'});
        				
        				//아이디 중복 확인 버튼 HIDE
        				$("#member_id_chk_btn").css("display", "none");
        				//아이디 변경 버튼 ACTIVE
        				$("#member_id_change_btn").css("display", "inline-block");
        				//아이디 Input box ReadOnly 
        				$("#mbrId").attr("readonly",true);
        				
        			} else {
        				$("#id_check_sucess").val('N');
        				
        				bootbox.alert({message: "이미 등록된 아이디 입니다.<br> 다시 등록해 주세요",locale: 'kr'});
        				$("#mbrId").val('');
        			}
        		   },
        		   error: function(error) {
        			   var errorJson = JSON.stringify(error);
        		       //alert("오류 발생" + errorJson);
        		       console.log(errorJson);
        		   }
        		})
        }
        
        //아이디 변경 
        function member_id_change() {
        	$('#id_check_sucess').val('N');
        	//아이디 중복 확인 버튼 SHOW
			$("#member_id_chk_btn").css("display", "inline-block");
			//아이디 변경 버튼 SHOW
			$("#member_id_change_btn").css("display", "none");
			//아이디 Input box readOnly false
			$("#mbrId").attr("readonly",false);
		}
        
        //닉네임 중복 체크
		function member_mbrNcknm_chk() {
        	
        	var dataCheckCount = {};
        	
        	var mbrNcknmParam = $("#mbrNcknm").val();
        	       	
        	if(isEmpty(mbrNcknmParam)) {
        		bootbox.alert({
					 message: "닉네임을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#mbrNcknm").focus();
				     } });
				 return;
        	}
        	
        	
        	$.ajax({
        		   type: "post",
        		   url: "memberChkData",
        		   data: {
        			   mbrNcknm : mbrNcknmParam
        		   },
        		   success: function(data) {
        			   
        			dataCheckCount = data.memberCheck.memberCheck[0];
        			
        			if(dataCheckCount == 0) {
        				$("#ncknm_check_sucess").val('Y');
        				
        				bootbox.alert({ message: "사용 가능한 닉네임 입니다.",locale: 'kr'});
        				
        				//닉네임 중복 확인 버튼 HIDE
        				$("#member_mbrNcknm_chk_btn").css("display", "none");
        				//닉네임 변경 버튼 ACTIVE
        				$("#member_mbrNcknm_change_btn").css("display", "inline-block");
        				//닉네임 Input box ReadOnly 
        				$("#mbrNcknm").attr("readonly",true);
        				
        			} else {
        				$("#ncknm_check_sucess").val('N');
        				
        				bootbox.alert({message: "이미 등록된 닉네임 입니다.<br> 다시 등록해 주세요",locale: 'kr'});
        				$("#mbrNcknm").val('');
        			}
        		   },
        		   error: function(error) {
        			   var errorJson = JSON.stringify(error);
        		       //alert("오류 발생" + errorJson);
        		       console.log(errorJson);
        		   }
        		})
        }
        
		//닉네임 변경 
        function member_mbrNcknm_change() {
        	$('#ncknm_check_sucess').val('N');
        	//아이디 중복 확인 버튼 SHOW
			$("#member_mbrNcknm_chk_btn").css("display", "inline-block");
			//아이디 변경 버튼 SHOW
			$("#member_mbrNcknm_change_btn").css("display", "none");
			//아이디 Input box readOnly false
			$("#mbrNcknm").attr("readonly",false);
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
      
      //비밃번호 보이기
      $("#mbrPasswrd").on("keyup", function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		    
		  } else {
		    if (this.value) {
		      $("#keyShow").css("display", "inline-block");
		    } else {
		      $("#keyShow").hide();
		    }
		  }
	 });

	$("#keyShow").on("click", function() {
	  if ($("#mbrPasswrd").attr("type") == "password") {
	    $("#mbrPasswrd").attr("type", "text");
	    $($(this)).text("HIDE");
	  } else {
	    $("#mbrPasswrd").attr("type", "password");
	    $($(this)).text("SHOW");
	  }
	});

	
	//비밃번호 확인 보이기
    $("#mbrPasswrdConfirm").on("keyup", function(event) {
		  if (event.keyCode === 13) {
		    event.preventDefault();
		   
		  } else {
		    if (this.value) {
		      $("#keyShowConfirm").css("display", "inline-block");
		    } else {
		      $("#keyShowConfirm").hide();
		    }
		  }
	 });

	$("#keyShowConfirm").on("click", function() {
	  if ($("#mbrPasswrdConfirm").attr("type") == "password") {
	    $("#mbrPasswrdConfirm").attr("type", "text");
	    $($(this)).text("HIDE");
	  } else {
	    $("#mbrPasswrdConfirm").attr("type", "password");
	    $($(this)).text("SHOW");
	  }
	});

	</script>
 
 
 
 
</body>
</html>
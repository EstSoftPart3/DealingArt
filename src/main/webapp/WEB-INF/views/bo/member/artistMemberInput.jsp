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
	               	<h3 class="card-title bTitle">작가회원</h3>
				</div>
				
				<form class="form-horizontal" name="formInfo" id="formInfo">
				
				<input type="hidden" name="mbrSq" id="mbrSq" value="<c:out value="${param.mbrSqParam}" />">
				
                <div class="card-body" style="background-color:#ffffff;">
                	
                	<h3 class="card-title bTitle">회원기본정보</h3>
                	
                	<div class="card-body table-responsive p-0" style="overflow:hidden;">
	              	   <hr>
		               <div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">아이디</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname"  id="mbrId" readonly>
                    		</div>
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">성명</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname"  id="mbrNm" readonly>
                    		</div>
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">휴대폰번호</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname"  id="mbrCpNum" readonly>
                    		</div>
                    		
                  		</div>
                  	</div>
                  	
                  	<h3 class="card-title bTitle">작가기본정보</h3>
                  	
                  	<div class="card-body table-responsive p-0" style="overflow:hidden;">
                  		<hr>
                  		 <section class="content">
      						<div class="container-fluid" style="padding-left:10px;">
        						<div class="row">
        							
            						<div class="card card-primary card-outline">
              							<div class="card-body box-profile">
                							<div class="text-center">
                								<div style="height:152px;width:150px;background-color:#efefef"></div>
                  								<!-- <img class="profile-user-img img-fluid img-circle" src=""> -->
                							</div>
											<a href="#" class="btn btn-info btn-block" style="font-size:11px;"><b>등록</b></a>
              							</div>
              						</div>
              						
              						<div class="col-md-9" style="padding-left:50px;">
              							 <div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동명</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstActvtyNm" name="artstActvtyNm" value="">
                    						</div>
                    						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">영문명</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstEnglsNm" name="artstEnglsNm" value="">
                    						</div>
		               		   			</div>
		               		   			
		               		   			<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동지역</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstActvtyCd" name="artstActvtyCd" value="">
                    						</div>
                    						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동분야</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstActvtyPartCd" name="artstActvtyPartCd" value="">
                    						</div>
		               		   			</div>
		               		   			
		               		   			<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">자기소개</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstSelfIntro" name="artstSelfIntro" cols="40" rows="5" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">홍보영상</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstPromtnVideoUrl" name="artstPromtnVideoUrl" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">홈페이지</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstHmpgUrl" name="artstHmpgUrl" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">페이스북</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstFacebookId" name="artstFacebookId" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">인스타그램</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstInstagramId" name="artstInstagramId" value="">
                    						</div>
                    					</div>
              						</div>
              						
                    							
                  				</div>
                  			</div>
                  		</section>
                </div>
                <!--card-body -->
                
                <!--card-footer -->
                <div class="card-footer" style="text-align:right;background-color:#ffffff">
                	
                  	<button type="button" class="btn btn-info sTitle" onclick="goList();">목록</button>
                  	<button type="button" class="btn btn-info sTitle" onclick="artistMemberInput();">등록</button>
                  	
                </div>
                
              </form>
				
    		</section>
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
        var dataContent = {};
   
		$(document).ready(function(){
			
			var mbrSq = '<c:out value="${param.mbrSqParam}" />';
			//회원기본정본
			memberContentData(mbrSq);
			//작가회원정보
			artistMemberInfoData(mbrSq);
		});
		
		//회원 정보 호출
		function memberContentData(mbrSq) {
			
			console.log("memberContentData : "+ mbrSq);
			
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
		        	 var mbrCpNum = dataContent.mbrCpNum				//닉네임
		        	 
		        	 $("#mbrNm").val(mbrNm);
		        	 $("#mbrId").val(mbrId);
		        	 $("#mbrCpNum").val(mbrCpNum);
		        	
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
		}
		
		//회원목록 이동
		function goList(){
			location.href = '/admin/member/memberList';
		}
		
		//작가정보 등록
		function artistMemberInput()
		{
			
			var artstActvtyNm = $("#artstActvtyNm").val();
			var artstEnglsNm = $("#artstEnglsNm").val();
			var artstSelfIntro = $("#artstSelfIntro").val();
			
			
			//활동명
        	if(isEmpty(artstActvtyNm)) {
        		bootbox.alert({
					 message: "활동명을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#artstActvtyNm").focus();
				     } });
				 return;
        	}
        	//영문명
        	if(isEmpty(artstEnglsNm)) {
        		bootbox.alert({
					 message: "영문명을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#artstEnglsNm").focus();
				     } });
				 return;
        	}		
        	//작가소개
        	if(isEmpty(artstSelfIntro)) {
        		bootbox.alert({
					 message: "작가소개를 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#artstSelfIntro").focus();
				     } });
				 return;
        	}
        	
			var queryString = $("form[name=formInfo]").serialize();
			
			console.log("artistMemberInput :"+queryString);
			
			$.ajax({
		           type: "post",
		           url: "artistMemberInputData",
		           data: queryString,
		           success: function(data) {
		        	   console.log(data);
		        	   bootbox.alert({
							 message: "작가정보 등록완료.",
							 locale: 'kr',
							 callback: function() {
							 		
						     } });
				   },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
		}
		
		//작가정보 호출
		function artistMemberInfoData(mbrSq)
		{
			$.ajax({
		           type: "post",
		           url: "artistMemberInfoData",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(data) {
		        	   
		        	   dataInfo = data.artistMemberInfoData.artistMemberInfo[0];
			        	console.log(dataInfo);
		        	  
		        	if(dataInfo) {
		        		
			        	var artstActvtyNm			= dataInfo.artstActvtyNm;
			        	var artstEnglsNm			= dataInfo.artstEnglsNm;
			        	var artstActvtyPartCd		= dataInfo.artstActvtyPartCd;
			        	var artstActvtyCd			= dataInfo.artstActvtyCd;
			        	var artstSelfIntro			= dataInfo.artstSelfIntro;
			        	var artstProfileImgUrl		= dataInfo.artstProfileImgUrl;
			        	var artstHmpgUrl			= dataInfo.artstHmpgUrl;
			        	var artstPromtnVideoUrl		= dataInfo.artstPromtnVideoUrl;
			        	var artstFacebookId			= dataInfo.artstFacebookId;
			        	var artstInstagramId		= dataInfo.artstInstagramId;
				        	 
			        	$("#artstActvtyNm").val(artstActvtyNm);
			        	$("#artstEnglsNm").val(artstEnglsNm);
			        	$("#artstActvtyPartCd").val(artstActvtyPartCd);
			        	$("#artstActvtyCd").val(artstActvtyCd);
			        	$("#artstSelfIntro").val(artstSelfIntro);
			        	$("#artstProfileImgUrl").val(artstProfileImgUrl);
			        	$("#artstPromtnVideoUrl").val(artstPromtnVideoUrl);
			        	$("#artstHmpgUrl").val(artstHmpgUrl);
			        	$("#artstFacebookId").val(artstFacebookId);
			        	$("#artstInstagramId").val(artstInstagramId);
		        	}
		        	
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
		}
		
		 //Input Box Null Check
        function isEmpty(str){
            
            if(typeof str == "undefined" || str == null || str == "")
                return true;
            else
                return false ;
        }
		
	</script>
 
 
</body>
</html>
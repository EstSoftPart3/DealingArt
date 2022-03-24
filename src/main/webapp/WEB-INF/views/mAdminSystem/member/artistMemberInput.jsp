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
				
				<form class="form-horizontal">
				
                <div class="card-body" style="background-color:#ffffff;">
                	
                	<h3 class="card-title bTitle">회원기본정보</h3>
                	
                	<div class="card-body table-responsive p-0" style="overflow:hidden;">
	              	   <hr>
		               <div class="form-group row">
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">아이디</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname"  id="mbrId" disabled>
                    		</div>
		               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">성명</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname"  id="mbrNm" disabled>
                    		</div>
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">휴대폰번호</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname"  id="mbrCpNum" disabled>
                    		</div>
                    		
                  		</div>
                  	</div>
                  	
                  	<h3 class="card-title bTitle">작가기본정보</h3>
                  	
                  	<div class="card-body table-responsive p-0" style="overflow:hidden;">
                  		<hr>
                  		 <section class="content">
      						<div class="container-fluid">
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
                      							<input type="text" class="form-control sTitle classname"  id="artstActvtyNm" >
                    						</div>
                    						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">영문명</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstEnglsNm" >
                    						</div>
		               		   			</div>
		               		   			
		               		   			<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동지역</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstActvtyCd" >
                    						</div>
                    						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동분야</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstActvtyPartCd" >
                    						</div>
		               		   			</div>
		               		   			
		               		   			<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">자기소개</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstSelfIntro" style="height:150px;" >
                    						</div>
                    					</div>
                    					
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">홈페이지</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstHmpgUrl" >
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">페이스북</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstFacebookId" >
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">인스타그램</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstInstagramId" >
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
                  	<button type="button" class="btn btn-info sTitle">등록</button>
                  	
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
			memberContentData(mbrSq);
			
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
			})
		}
		
		//회원목록 이동
		function goList(){
			location.href = '/admin/member/memberList';
		}
		
		function memberUpdate() {
   			
			var mbrSq = '<c:out value="${param.mbrSqParam}" />';
			
   			let param = {
   				mbrSqParam : mbrSq
   			}
   			
   			console.log(param);
   			
   			var contentUrl = "/admin/member/memberUpdate";
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
	</script>
 
 
</body>
</html>s
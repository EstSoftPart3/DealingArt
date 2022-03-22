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
	               	<h3 class="card-title bTitle">작가회원 등록</h3>
				</div>
				
				<form class="form-horizontal">
				
                <div class="card-body" style="background-color:#ffffff;">
                	
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
                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">닉네임</label>
                    		<div class="col-sm-3">
                      			<input type="text" class="form-control sTitle classname"  id="mbrNcknm" disabled>
                    		</div>
                    		
                  		</div>
                  </div>
                  
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
		        	 var mbrNcknm = dataContent.mbrNcknm				//닉네임
		        	 
		        	 $("#mbrNm").val(mbrNm);
		        	 $("#mbrId").val(mbrId);
		        	 $("#mbrNcknm").val(mbrNcknm);
		        	
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
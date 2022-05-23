<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
	//잡지타입 : Insights (IST), Media(MDA), Exhibition(EBI)
	String mgzTypCd = request.getParameter("mgzTypCd"); 
	String mgzName; 
	
	if(mgzTypCd.equals("IST")){
		mgzName = "인사이트"; 
	}else if(mgzTypCd.equals("MDA")){
		mgzName = "미디어"; 
	}else{
		mgzName = "전시회";
	}
%>

<body class="hold-transition sidebar-mini">

<style>
	.editable-container,
	.toolbar-container {
		position: relative;
		border: 1px solid #ddd;
		background: #eee;
	}

	.toolbar-container {
		padding: 1em;
	}

	.editable-container {
		padding: 3em;
		overflow-y: scroll;
		max-height: 500px;
	}

	.editable-container .document-editor__editable.ck-editor__editable {
		min-height: 21cm;
		padding: 2em;
		border: 1px #D3D3D3 solid;
		border-radius: var(--ck-border-radius);
		background: white;
		box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
	}
</style>

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     	<!-- Main content -->
	    		<section class="content">

	    			<input type="hidden" name="mgzTypCd" id="mgzTypCd" value="<%=mgzTypCd%>">
	    			<input type="hidden" name="mbrSq" id="mbrSq" value="78">
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b><%=mgzName%></b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 	
					 		<div class="col-md-12" style="padding-left:50px; margin: auto">
					 		
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" ">제목</label>
                    				<div class="col-sm-6">
                      						<input type="text" class="form-control sTitle classname"  id="mgzTitle" name="mgzTitle" value="" readonly="readonly">
                    				</div>
					 			</div>
					 			
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle"">설명</label>
                    				<div class="col-sm-6">
                      						<input type="text" class="form-control sTitle classname"  id="mgzDescrptn" name="mgzDescrptn" value="" readonly="readonly">
                    				</div>
					 			</div>
								

								<div class="card card-primary card-outline" style="height:380px;width:585px;">
              							<div class="card-body box-profile">
                							<div class="text-center" style="text-align: center;">
                							<label class="col-form-label sTitle LabelStyle">메인 이미지</label>
                								<div style="height:250px;width:545px;background-color:#efefef;text-align: center;">
                								
                									<input type="hidden" name="mgzMainImgUrl" id="mgzMainImgUrl">
													<input type="file" id="file" style="display:none">
													
													<img class="content" id="dropZone" style="cursor:pointer;height:300px;width:545px;text-align: center;"/>
                								
                								</div>
                  								<!-- <img class="profile-user-img img-fluid img-circle" src=""> -->
                							</div>
											<!-- <br><a href="javascript:imgInput();" class="btn btn-info btn-block" style="font-size:11px;width:150px;margin:auto;"><b>등록</b></a> -->
              							</div>
              						</div>

					 			<div class="form-group row">
					 			<label class="col-form-label sTitle LabelStyle" style="text-align: center;">내용</label>
                    				<div class="col-sm-12">
									<div id="editor" class="ck-blurred ck ck-content ck-editor__editable ck-rounded-corners ck-editor__editable_inline" lang="en" dir="ltr" role="textbox" aria-label="Rich Text Editor, main" contenteditable="false">
					 				<div id="brd" class="col-sm-9" style="margin: auto;">
					 		
					 				</div>
									</div>
                    				</div>
					 			</div>
					 			<div class="form-group row">
                    				
                    				<div class="col-sm-12" style="margin: auto">
                    					<button type="button" class="btn btn-info sTitle" onclick="boardList();">리스트로 돌아가기</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="boardUpdatepage();">수정</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="boardDelete();">삭제</button>
                    				</div>
                    				
                    			</div>
					 		</div>
					 	</div>

					 </div>
					
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   
  
   
/*    var dataContent = {};
   
	$(document).ready(function(){
		
		var mbrSq = '<c:out value="${param.mbrSqParam}" />';
		//회원기본정본
		memberContentData(mbrSq);
		//작가회원정보
		artistMemberInfoData(mbrSq);
	});  */
   
	   var mbrSq = $('#mbrSq').val();
	   var mgzSq = '<c:out value="${param.mgzSq}" />';
	   var mgzTypCd = '<c:out value="${param.mgzTypCd}" />';
	   
	   var editorContnet;
	   var dataContent = {};
	
   $(document).ready(function(){

		magazineDetailtData(mgzSq,mgzTypCd)
		
	});
   
   function magazineDetailtData(mgzSq,mgzTypCd) {

		$.ajax({
	           type: "post",
	           url: "magazineDetailData",
	           data: {
	        	   mgzSq : mgzSq,
	        	   mgzTypCd : mgzTypCd
	        	   
	            },
	           success: function(data) {
	        	   
	        	    
	        	 dataContent = data.magazineDetailData.magazineDetailData[0];
	        	 
	        	 console.log(dataContent);

	        	 var mgzTitleInput = dataContent.mgzTitle;
	        	 var mgzContentInput = dataContent.mgzContent;
	        	 var mgzDescrptnInput = dataContent.mgzDescrptn;
	        	 var mgzMainImgUrlInput = dataContent.mgzMainImgUrl;
	        	 
	        	 
	        	 $('#mgzContentInput').val(mgzContentInput);
	        	 $('#mgzTitle').val(mgzTitleInput);
	        	 $('#mgzDescrptn').val(mgzDescrptnInput);
	        	 $("#mgzMainImgUrl").val(mgzMainImgUrlInput);
	        	 
	        	 if(mgzMainImgUrlInput) {
			        	$("#dropZone").prop("src",mgzMainImgUrlInput)
				  }
	        	 
	        	 var timpStr = mgzContentInput;
	        	 timpStr = timpStr.replaceAll("&lt;","<");
	        	 timpStr = timpStr.replaceAll("&gt;",">");
	        	 timpStr = timpStr.replaceAll("&amp;lt;","<");
	        	 timpStr = timpStr.replaceAll("&amp;gt;",">");
	        	 timpStr = timpStr.replaceAll("&amp;nbsp;"," ");
	        	 timpStr = timpStr.replaceAll("&amp;amp;","&");
	        	 document.getElementById('brd').innerHTML=timpStr;

	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
   
   function boardDelete() {
   
	   
	   if(confirm('정말 삭제 하시겠습니까?')) {
		   
		   $.ajax({
	           type: "post",
	           url: "magazineDeleteData",
	           data: {
	        	   mgzTypCd : mgzTypCd,
	        	   mgzSq : mgzSq,

	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "삭제 되었습니다.",
						 locale: 'kr',
						 callback: function() {
							 
							 if(mgzTypCd == 'IST'){
								 	location.href='/admin/magazine/magazineList?mgzTypCd=IST';
							 	}else if(mgzTypCd == 'MDA'){
							 		location.href='/admin/magazine/magazineList?mgzTypCd=MDA';
							 	}else{
							 		location.href='/admin/magazine/magazineList?mgzTypCd=EBI';
							 	}
							 
						 		
					     } });
			   },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
		   
	   }else{
		   return false;
	   }
	   
	  
   }
   
   function boardUpdatepage() {
	   location.href='/admin/magazine/magazineUpdate?mgzSq='+mgzSq+'&mgzTypCd=<%=mgzTypCd%>';
   }
   
   function fn_SubBrdPage(getData) {
	   var mgzTypCd = $('#mgzTypCd').val();
	   location.href='/admin/magazine/magazineDetail?mgzSq='+mgzSq+'&mgzTypCd='+mgzTypCd;
	}
   
	 //Input Box Null Check
   function isEmpty(str){
       
       if(typeof str == "undefined" || str == null || str == "")
           return true;
       else
           return false ;
   }

   </script>
   
   <script>
    
   
     </script>
 
 
</body>
</html>
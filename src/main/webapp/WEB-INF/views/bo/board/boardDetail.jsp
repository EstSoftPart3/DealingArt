<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
	//게시판 타입 : 공지사항 (NT), 일반(GN)
	String brdTypCd = request.getParameter("brdTypCd"); 
	
	String brdName; 
	
	if(brdTypCd.equals("NT")) {
		brdName = "공지사항"; 
	} else {
		brdName = "FAQ"; 
	}

%>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     	<!-- Main content -->
	    		<section class="content">

	    			<input type="hidden" name="brdTypCd" id="brdTypCd" value="<%=brdTypCd%>">
	    			<input type="hidden" name="regMbrSq" id="regMbrSq" value="0">
	    			<input type="hidden" name="mbrSq" id="mbrSq" value="0">
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b><%=brdName%></b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 	
					 		<div class="col-md-9" style="padding-left:50px;">
					 		
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">제목</label>
                    				<div class="col-sm-6">
                      						<input type="text" class="form-control sTitle classname"  id="brdTitle" name="brdTitle" value="">
                    				</div>
					 			</div>
					 			
					 			<div class="form-group row">
                    				<div class="col-sm-9">
                      						<!-- <input type="text" class="form-control sTitle classname"  id="brdContent" name="brdContent" value=""> -->
                    				</div>
                    				<textarea name="content" id="editor"></textarea>
					 			</div>
					 			<div class="form-group row">
                    				<div class="col-sm-12">
                    				<button type="button" class="btn btn-info sTitle" onclick="boardUpdate();">수정</button>
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
   
   var mbrSq = $('#mbrSq').val();
   var brdSq = '<c:out value="${param.brdSq}" />';
   var brdTypCd = '<c:out value="${param.brdTypCd}" />';
   
   var editorContnet;
   var dataContent = {};
   
   $(document).ready(function(){

		boardDetailtData(brdSq,brdTypCd)
		
	});
   
   function boardDetailtData(brdSq,brdTypCd) {
		
		$.ajax({
	           type: "post",
	           url: "boardDetailData",
	           data: {
	        	   brdSq : brdSq,
	        	   brdTypCd : brdTypCd
	        	   
	            },
	           success: function(data) {
	        	   
	        	    
	        	 dataContent = data.boardDetailData.boardDetailData[0];
	        	 
	        	 console.log(dataContent);
	        	
	        	 
	        	 
	        	 var brdContentInput = dataContent.brdContent;
	        	 var brdTitleInput = dataContent.brdTitle;

	        	 const domEditableElement = document.querySelector( '.ck-editor__editable' );
	        	 const editorInstance = domEditableElement.ckeditorInstance;
	        	 editorInstance.setData(brdContentInput);
	        	 
	        	 $('#brdTitle').val(brdTitleInput);

	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
   

   var editorContnet;
   
   ClassicEditor
	    .create( document.querySelector( '#editor' ))
	    .then( editor => {editorContnet = editor;} )
	    .catch( error => {console.error( error );} );
   
   
   function boardUpdate() {
	
   	var brdTitle  = $("#brdTitle").val();  //게시판제목
    var brdContent = editorContnet.getData();
   	
   	
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
   	        				
		
		$.ajax({
	           type: "post",
	           url: "boardUpdateData",
	           data: {
	        	   mbrSq : mbrSq,
	        	   brdTypCd : brdTypCd,
	        	   brdSq : brdSq,
	        	   brdTitle : brdTitle,
	        	   brdContent : brdContent
	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "공지사항이 수정이완료됬습니다.",
						 locale: 'kr',
						 callback: function() {
							 if(brdTypCd == 'NT'){
							 		location.href='/admin/board/boardList?brdTypCd=NT';
							 	}else{
							 		location.href='/admin/board/boardList?brdTypCd=FA';
							 	}
					     } });
			   },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
   
   function boardDelete() {
   
	   
	   if(confirm('정말 삭제하시겠습니까?')) {
		   
		   $.ajax({
	           type: "post",
	           url: "boardDeleteData",
	           data: {
	        	   brdTypCd : brdTypCd,
	        	   brdSq : brdSq,

	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "삭제되었습니다.",
						 locale: 'kr',
						 callback: function() {
							 
							 	if(brdTypCd == 'NT'){
							 		location.href='/admin/board/boardList?brdTypCd=NT';
							 	}else{
							 		location.href='/admin/board/boardList?brdTypCd=FA';
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
   
   </script>
 
 
</body>
</html>
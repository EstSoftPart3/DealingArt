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
                      						<button type="button" class="btn btn-info sTitle" onclick="boardInput();">입력</button>
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
   var editorContnet;
   
   ClassicEditor
	    .create( document.querySelector( '#editor' ))
	    .then( editor => {editorContnet = editor;} )
	    .catch( error => {console.error( error );} );
   
   function boardInput() {
	
	var mbrSq     = $("#mbrSq").val();     //회원순번
	var brdTypCd  = $("#brdTypCd").val();  //게시판구분코드
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
	           url: "boardInsertData",
	           data: {
	        	   mbrSq : mbrSq,
	        	   brdTypCd : brdTypCd,
	        	   regMbrSq : mbrSq,
	        	   brdTitle : brdTitle,
	        	   brdContent : brdContent
	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "공지사항이 저장되었습니다.",
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
   </script>
 
 
</body>
</html>
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
		brdName = "자주하는질문"; 
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
					 	
					 		<div class="col-md-12" style="padding-left:50px;">
					 		
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">제목</label>
                    				<div class="col-sm-9">
                      					<input type="text" class="form-control sTitle classname"  id="brdTitle" name="brdTitle" readonly >
                    				</div>
					 			</div>
					 			<%
					 			if(brdTypCd.equals("FA")) {
					 			%>
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">구분</label>
                    				<div class="col-sm-9">
                      					<input type="text" class="form-control sTitle classname"  id="brdConTypCdText" name="brdConTypCdText" readonly >
                    				</div>
					 			</div>
					 			<%}%>
					 			<div class="form-group row">
                    				
                    				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">내용</label>
                    				<div class="col-sm-9">
                      					
                      					<div id="toolbar-container" style="display:none"></div>
                      					
                      					<div id="editor" class="ck-blurred ck ck-content" style="border: 1px solid #efefef;min-height:500px;padding:20px;" lang="en" dir="ltr"  aria-label="main" contenteditable="false" >
                      					</div>
                      				
                    				</div>	
					 			</div>
					 			<div class="form-group row">
                    				
                    				<div class="col-sm-9" style="text-align:right">
                    					<button type="button" class="btn btn-info sTitle" onclick="boardList();">리스트로 돌아가기</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="fn_SubBrdUpdatePage();">수정</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="boardDelete();">삭제</button>
                    				</div>
                    				
                    			</div>
					 		</div>
					 	</div>

					 		<div id="brd">
					 		
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
	        	 var brdContent = dataContent.brdContent;
	        	 var brdTitle = dataContent.brdTitle;
	        	 var brdConTypCdTxt = dataContent.brdConTypCdTxt;
	        	

				 var timpStr = brdContent;
              	 
              	 timpStr = timpStr.replaceAll("&lt;","<");
	        	 timpStr = timpStr.replaceAll("&gt;",">");
	        	 timpStr = timpStr.replaceAll("&amp;lt;","<");
	        	 timpStr = timpStr.replaceAll("&amp;gt;",">");
	        	 timpStr = timpStr.replaceAll("&amp;nbsp;"," ");
	        	 timpStr = timpStr.replaceAll("&amp;amp;","&");
	        	 //Table 수정 금지
	        	 timpStr = timpStr.replaceAll("true","false");
	        	 document.getElementById('editor').innerHTML=timpStr;
	        	 
	        	 
	        	 $('#brdTitle').val(brdTitle);
	        	 $('#brdConTypCdText').val(brdConTypCdTxt);
	        	 
	        	//ckEditor Mouse Over Class Remove
	        	 fn_styleNone();
	        	 

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
	           url: "boardDeleteData",
	           data: {
	        	   brdTypCd : brdTypCd,
	        	   brdSq : brdSq,

	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "삭제 되었습니다.",
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
   
   function boardList() {
	   location.href='/admin/board/boardList?brdTypCd=<%=brdTypCd%>';
   }
   
	 //Input Box Null Check
   function isEmpty(str){
       
       if(typeof str == "undefined" || str == null || str == "")
           return true;
       else
           return false ;
   }
	 
	 
   function fn_SubBrdUpdatePage() {
	   
	   var brdSq = '<c:out value="${param.brdSq}" />';
	   var brdTypCd = '<c:out value="${param.brdTypCd}" />';
	   
	   location.href='/admin/board/boardUpdate?brdSq='+brdSq+'&brdTypCd='+brdTypCd;
	}
	 
   //ckEditor Mouse Over Class Remove
   function fn_styleNone() {
   	$(".ck-widget__type-around__button").css("display","none");
   	$(".ck-widget").css("outline-style","none");
   	$(".ck-widget__selection-handle").css("display","none");
   }
   
   </script>
 
 
 
</body>
</html>
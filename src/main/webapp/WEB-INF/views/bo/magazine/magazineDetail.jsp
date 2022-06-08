<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
	//잡지타입 : Insights (IST), Media(MDA), Exhibition(EBI)
	String mgzTypCd = request.getParameter("mgzTypCd");
    String mgzSq = request.getParameter("mgzSq");
	
    String mgzName; 
	
	if(mgzTypCd.equals("IST")){
		mgzName = "인사이트"; 
	}else if(mgzTypCd.equals("MDA")){
		mgzName = "미디어"; 
	}else{
		mgzName = "전시회";
	}
	
// 	if(mgzTypCd.equals("MDA")) {
// 		response.sendRedirect("/admin/magazine/magazineUpdate?mgzSq="+mgzSq+"&mgzTypCd=MDA");	
// 	}
	
%>

<body class="hold-transition sidebar-mini">

<style>
	#brd { zoom: 0.8;}
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
					 	
					 		<table border="0" cellspacing="5" cellpadding="5">
					 			<tr>
					 				<td colspan="2">
					 				
					 				<div class="form-group row">
						 				<label class="col-form-label sTitle LabelStyle" ">제목</label>
	                    				<div class="col-sm-11">
	                      						<input type="text" class="form-control sTitle classname"  id="mgzTitle" name="mgzTitle" value="" readonly="readonly">
	                    				</div>
						 			</div>
					 			
						 			<div class="form-group row">
						 				<label class="col-form-label sTitle LabelStyle"">설명</label>
	                    				<div class="col-sm-11">
	                      						<input type="text" class="form-control sTitle classname"  id="mgzDescrptn" name="mgzDescrptn" value="" readonly="readonly">
	                    				</div>
						 			</div>
					 					
					 				</td>
					 			</tr>
					 			<tr>
					 				<td valign="top" id="mainImg">
					 					
					 					<div class="card card-primary card-outline" style="height:300px;width:250px;">
		              						<div class="card-body box-profile">
		                						<div class="text-center" style="text-align: center;">
		                							
		                							<label class="col-form-label sTitle LabelStyle" style="text-align: center;">메인 이미지</label>
		                								
		                							<div style="height:170px;width:200px;background-color:#efefef;text-align: center;">
		                								
		                								<input type="hidden" name="mgzMainImgUrl" id="mgzMainImgUrl">
														<input type="file" id="file" style="display:none">
															
														<img class="content" id="dropZone" style="cursor:pointer;text-align:center;height:170px;width:200px;"/>
		                								
		                							</div>
		                  								
		                						</div>
		                						<b style="font-family: sans-serif; font-size: 8px; color: gray;">※ 회색공간을 클릭해서 업로드하거나, 파일을 끌어와서 업로드 하세요.</b>
													
		              						</div>
	              						</div>
	              							
					 				</td>
					 				<td style="text-align:left" >
					 				
					 				
<!-- 					 					<div id="brd" style="border: 1px solid #efefef;padding:5px;width:1000px;"> -->
					 		
<!-- 					 					</div> -->
											
											<div id="editor" style="border: 1px solid #efefef;width:800px;pointer-events:none;">
					 				
					 				</td>
					 			</tr>
					 			<tr>
					 				<td style="text-align:right" colspan="2">
					 					<button type="button" class="btn btn-info sTitle" onclick="boardList();">리스트로 돌아가기</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="boardUpdatepage();">수정</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="boardDelete();">삭제</button>
					 				</td>
					 			</tr>
					 		</table>
					 	
					 		
					 	</div>

					 </div>
					
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   
   DecoupledDocumentEditor
	.create( document.querySelector( '#editor' ), {
		
		licenseKey: 'ExsHmoBFE5WDCOKFluh5/uyuEY1LuvUHcEq99SadAptme2Af1zXKgJX2wA==',
		
		
	} )
	.then( editor => {
		 const toolbarContainer = document.querySelector( '#toolbar-container' );

		  toolbarContainer.appendChild( editor.ui.view.toolbar.element );
         document.querySelector( '.editable-container' ).appendChild( editor.ui.view.editable.element );
	} )
	.catch( error => {
		console.error( 'Oops, something went wrong!' );
		console.error( 'Please, report the following error on https://github.com/ckeditor/ckeditor5/issues with the build id and the error stack trace:' );
		console.warn( 'Build id: ebx524mxzl84-u9490jx48w7r' );
		console.error( error );
	} );
   
  
   
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
	        	 
// 	        	 var timpStr = mgzContentInput;
// 	        	 timpStr = timpStr.replaceAll("&lt;","<");
// 	        	 timpStr = timpStr.replaceAll("&gt;",">");
// 	        	 timpStr = timpStr.replaceAll("&amp;lt;","<");
// 	        	 timpStr = timpStr.replaceAll("&amp;gt;",">");
// 	        	 timpStr = timpStr.replaceAll("&amp;nbsp;"," ");
// 	        	 timpStr = timpStr.replaceAll("&amp;amp;","&");
// 	        	//Table 수정 금지
// 	        	 timpStr = timpStr.replaceAll("true","false");
// 	        	 document.getElementById('brd').innerHTML=timpStr;
	        	 
	        	  const domEditableElement = document.querySelector( '.ck-editor__editable' );
	        	 const editorInstance = domEditableElement.ckeditorInstance;
	        	 editorInstance.setData(mgzContentInput);
	        	 
	        	 //ckEditor Mouse Over Class Remove
	        	 fn_styleNone();
	        	 
	        	 iframeSize();

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
   
   function boardList() {
	   location.href='/admin/magazine/magazineList?mgzTypCd=<%=mgzTypCd%>';
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
	 
   //ckEditor Mouse Over Class Remove
   function fn_styleNone() {
   	$(".ck-widget__type-around__button").css("display","none");
   	$(".ck-widget").css("outline-style","none");
   	$(".ck-widget__selection-handle").css("display","none");
   }
   
 

   </script>
   <% if(mgzTypCd.equals("MDA")) { %>
    <script>
    	$("#mainImg").hide(); 
    	
    		function iframeSize() {
    	
    			$(document).ready(function () {
    	      	     
    	    	$("iframe").width(987);
    			$("iframe").height(500);	
    	       		
    		});
    	}
    </script>
   <% } %>>
 
</body>
</html>
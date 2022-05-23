<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<%
	//잡지타입 : CK에디터 (CK)
	String ckTypCd = request.getParameter("ckTypCd"); 
	String ckName = "CK에디터"; 
	
	/* if(mgzTypCd.equals("IST")){
		mgzName = "인사이트"; 
	}else if(mgzTypCd.equals("MDA")){
		mgzName = "미디어"; 
	}else{
		mgzName = "전시회";
	} */
%>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     	<!-- Main content -->
	    		<section class="content">

	    			<input type="hidden" name="ckTypCd" id="ckTypCd" value="<%=ckTypCd%>">
	    			<input type="hidden" name="mbrSq" id="mbrSq" value="78">
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b><%=ckName%></b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 	
					 		<div class="col-md-9" style="padding-left:50px;">
					 		
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">제목</label>
                    				<div class="col-sm-6">
                      						<input type="text" class="form-control sTitle classname"  id="ckTitle" name="ckTitle" value="">
                    				</div>
					 			</div>
					 			
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">설명</label>
                    				<div class="col-sm-6">
                      						<input type="text" class="form-control sTitle classname"  id="ckDescrptn" name="ckDescrptn" value="">
                    				</div>
					 			</div>
								

								<div class="card card-primary card-outline" style="height:380px;width:585px;">
              							<div class="card-body box-profile">
                							<div class="text-center" style="text-align: center;">
                							<label class="col-form-label sTitle LabelStyle" style="text-align: center;">메인 이미지</label>
                								<div style="height:250px;width:545px;background-color:#efefef;text-align: center;">
                								
                									<input type="hidden" name="ckMainImgUrl" id="ckMainImgUrl">
													<input type="file" id="file" style="display:none">
													
													<img class="content" id="dropZone" style="cursor:pointer;height:250px;width:545px;text-align: center;"/>
                								
                								</div>
                  								<!-- <img class="profile-user-img img-fluid img-circle" src=""> -->
                							</div>
                							<b style="font-family: sans-serif; font-size: 8px; color: gray;">※ 회색공간을 클릭해서 업로드하거나, 파일을 끌어와서 업로드 하세요.</b>
											<!-- <br><a href="javascript:imgInput();" class="btn btn-info btn-block" style="font-size:11px;width:150px;margin:auto;"><b>등록</b></a> -->
              							</div>
              						</div>

					 			<div class="form-group row">
					 			<label class="col-form-label sTitle LabelStyle" style="text-align: center;">내용</label>
                    				<div class="col-sm-6">
                      						<!-- <input type="text" class="form-control sTitle classname"  id="brdContent" name="brdContent" value=""> -->
                    					<textarea name="content" id="editor"></textarea>
                    				</div>
					 			</div>
					 			<div class="form-group row">
                    				
                    				<div class="col-sm-6" style="text-align:right">
                    					<button type="button" class="btn btn-info sTitle" onclick="ckeditorList();">리스트로 돌아가기</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="ckeditorUpdate();">수정</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="ckeditorDelete();">삭제</button>
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
/*    var dataContent = {};
   
	$(document).ready(function(){
		
		var mbrSq = '<c:out value="${param.mbrSqParam}" />';
		//회원기본정본
		memberContentData(mbrSq);
		//작가회원정보
		artistMemberInfoData(mbrSq);
	}); */
   
	   var mbrSq = $('#mbrSq').val();
	   var ckSq = '<c:out value="${param.ckSq}" />';
	   var ckTypCd = '<c:out value="${param.ckTypCd}" />';
	   
	   var editorContnet;
	   var dataContent = {};
	
   $(document).ready(function(){

		ckeditorDetailtData(ckSq,ckTypCd)
		
		$("#file").bind('change', function() {
			uploadResource(this.files);
		});
		
		$(function() {
			// 파일 드롭 다운
			fileDropDown();
		});
		
		// 파일 드롭 다운
		function fileDropDown() {
			var dropZone = $("#dropZone");
			//Drag기능 
			dropZone.on('dragenter', function(e) {
				e.stopPropagation();
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#E3F2FC');
			});
			dropZone.on('dragleave', function(e) {
				e.stopPropagation();
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#FFFFFF');
			});
			dropZone.on('dragover', function(e) {
				e.stopPropagation();
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#E3F2FC');
			});
			dropZone.on('drop', function(e) {
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#FFFFFF');

				var fileObject = e.originalEvent.dataTransfer.files;
				
				
				
				
				if (fileObject != null) {
					if (fileObject.length < 1) {
						/* alert("폴더 업로드 불가"); */
						console.log("폴더 업로드 불가");
						return;
					} else {
						uploadResource(fileObject);
					}
				} else {
					alert("ERROR");
				}
			});
		}
		
		function uploadResource(fileObject) {
			
			var file = null;
			
			const formData = new FormData();
			
			if (fileObject != null) {
				// 파일 Drag 이용하여 등록시
				file = fileObject[0];
				formData.append("file", file);
				console.log(file);
			} else {
				file = document.getElementById("file");
				formData.append("file", file.files[0]);
			}
			
			var maxSize = 5 * 1024 * 1024; // 5MB
			var fileSize = file.size;
			
			if(fileSize > maxSize){
				alert("프로필 이미지의 용량이 5MB가 넘습니다. 5MB이상은 첨부파일을 올릴 수 없습니다.");
				return false;
			}
			
	        fetch("/file/upload", {
	            method : "POST"
	            , body : formData
	        })
	        .then(result => result.json())
	        .then(data => {
	            document.getElementById("dropZone").setAttribute("src", data.fileUrl);
	            $('#ckMainImgUrl').val(data.fileUrl);
	            //document.getElementById("remove").setAttribute("fileNm", data.fileNm)
	        })
	        .catch(error => console.log(`error => ${error}`));
	    }
		
		$("#dropZone").click(function(){
	       $('#file').click();
	    });
		
	});
   
   function ckeditorDetailtData(ckSq,ckTypCd) {

		$.ajax({
	           type: "post",
	           url: "ckeditorDetailData",
	           data: {
	        	   ckSq : ckSq,
	        	   ckTypCd : ckTypCd
	        	   
	            },
	           success: function(data) {
	        	   
	        	    
	        	 dataContent = data.ckeditorDetailData.ckeditorDetailData[0];
	        	 
	        	 console.log(dataContent);

	        	 var ckTitleInput = dataContent.ckTitle;
	        	 var ckContentInput = dataContent.ckContent;
	        	 var ckDescrptnInput = dataContent.ckDescrptn;
	        	 var ckMainImgUrlInput = dataContent.ckMainImgUrl;
	        	 
	        	 console.log(ckContentInput);
	        	 
	        	 const domEditableElement = document.querySelector( '.ck-editor__editable' );
	        	 const editorInstance = domEditableElement.ckeditorInstance;
	        	 editorInstance.setData(ckContentInput);
	        	 
	        	 $('#ckTitle').val(ckTitleInput);
	        	 $('#ckContent').val(ckContentInput);
	        	 $('#ckDescrptn').val(ckDescrptnInput);
	        	 $("#ckMainImgUrl").val(ckMainImgUrlInput);
	        	 
	        	 if(ckMainImgUrlInput) {
			        	$("#dropZone").prop("src",ckMainImgUrlInput)
				    	}
	        	 
	        	 

	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
   

   var editorContnet;
   
   ClassicEditor
   
		.create( document.querySelector( '#editor' ), {
			toolbar: {
		           items: ['heading', '|', 'bold', 'italic', 'link', 'bulletedList', 'numberedList', '|', 'indent', 'outdent', '|', 'imageUpload', 'blockQuote', 'insertTable', 'mediaEmbed', 'undo', 'redo', 'exportPdf', 'fontBackgroundColor', 'fontColor', 'fontSize', 'fontFamily', 'highlight', 'horizontalLine', 'underline', ]
		       },
		       language: 'ko',
		       image: {
		           toolbar: ['imageTextAlternative', 'imageStyle:full', 'imageStyle:side']
		       },
		       table: {
		           contentToolbar: ['tableColumn', 'tableRow', 'mergeTableCells', 'tableCellProperties', 'tableProperties']
		       },
			ckfinder: {
		        uploadUrl: 'https://ckeditor.com/apps/ckfinder/3.5.0/core/connector/php/connector.php?command=QuickUpload&type=Files&responseType=json' // 내가 지정한 업로드 url (post로 요청감)
			},
			alignment: {
	           options: [ 'left', 'center', 'right' ]
	       }
		} )
		.then( editor => {
	       console.log( 'Editor was initialized', editor );
	       editorContnet = editor;
	   } )
		.catch( error => {
		    console.error( error );
		} );
   
   
   function ckeditorUpdate() {
		
		var mbrSq     = $("#mbrSq").val();     
		var ckTitle  = $("#ckTitle").val(); 
		var ckDescrptn  = $("#ckDescrptn").val(); 
	    var ckContent = editorContnet.getData();
	    var ckMainImgUrl  = $("#ckMainImgUrl").val();  
	    var ckTypCd  = $("#ckTypCd").val();  
	    var updtMbrSq = $("#mbrSq").val();
	   
	  	 //잡지 제목
	  	 if(isEmpty(ckTitle)) {
	  		bootbox.alert({
					 message: "제목을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#ckTitle").focus();
				     } });
				 return;
	  	 }
	  	 
	  	 //잡지 설명
	  	 if(isEmpty(ckDescrptn)) {
	  		bootbox.alert({
					 message: "설명을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#ckDescrptn").focus();
				     } });
				 return;
	  	 }
	  	 
	  	 //잡지 메인 이미지
	  	 if(isEmpty(ckMainImgUrl)) {
	  		bootbox.alert({
					 message: "메인이미지를 등록해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#ckMainImgUrl").focus();
				     } });
				 return;
	  	 }
	  	 
	    //잡지 내용
	  	 if(isEmpty(ckContent)) {
	  		bootbox.alert({
					 message: "내용을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
						 $("#ckContent").focus();
				     } });
				 return;
	  	 }
   	        				
		var mbrSq     = $("#mbrSq").val();     
		var ckTitle  = $("#ckTitle").val(); 
		var ckDescrptn  = $("#ckDescrptn").val(); 
	    var ckContent = editorContnet.getData();
	    var ckMainImgUrl  = $("#ckMainImgUrl").val();  
	    var ckTypCd  = $("#ckTypCd").val();  
	    var updtMbrSq = $("#mbrSq").val();

		$.ajax({
	           type: "post",
	           url: "ckeditorUpdateData",
	           data: {
	        	   ckSq : ckSq,
	        	   mbrSq : mbrSq,
	        	   ckTitle : ckTitle,
	        	   ckDescrptn : ckDescrptn,
	        	   ckContent : ckContent,
	        	   ckMainImgUrl : ckMainImgUrl,
	        	   ckTypCd : ckTypCd,
	        	   updtMbrSq : updtMbrSq
	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "게시글이 저장 되었습니다.",
						 locale: 'kr',
						 callback: function() {
							 	location.href='/admin/ckeditor/ckeditorList?ckTypCd=CK';
					     } });
			   },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
   
   function ckeditorDelete() {
   
	   
	   if(confirm('정말 삭제 하시겠습니까?')) {
		   
		   $.ajax({
	           type: "post",
	           url: "ckeditorDeleteData",
	           data: {
	        	   ckTypCd : ckTypCd,
	        	   ckSq : ckSq,

	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "삭제 되었습니다.",
						 locale: 'kr',
						 callback: function() {
							 location.href='/admin/ckeditor/ckeditorList?ckTypCd=CK';
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
   
   function ckeditorList() {
	   location.href='/admin/ckeditor/ckeditorList?ckTypCd=<%=ckTypCd%>';
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
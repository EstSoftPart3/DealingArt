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
					 	
					 		<div class="col-md-9" style="padding-left:50px;">
					 		
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">제목</label>
                    				<div class="col-sm-6">
                      						<input type="text" class="form-control sTitle classname"  id="mgzTitle" name="mgzTitle" value="">
                    				</div>
					 			</div>
					 			
					 			<div class="form-group row">
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">설명</label>
                    				<div class="col-sm-6">
                      						<input type="text" class="form-control sTitle classname"  id="mgzDescrptn" name="mgzDescrptn" value="">
                    				</div>
					 			</div>
								

								<div class="card card-primary card-outline" style="height:380px;width:585px;">
              							<div class="card-body box-profile">
                							<div class="text-center" style="text-align: center;">
                							<label class="col-form-label sTitle LabelStyle" style="text-align: center;">메인 이미지</label>
                								<div style="height:250px;width:545px;background-color:#efefef;text-align: center;">
                								
                									<input type="hidden" name="mgzMainImgUrl" id="mgzMainImgUrl">
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
                      						<button type="button" class="btn btn-info sTitle" onclick="magazineList();">리스트로 돌아가기</button>
                      						<button type="button" class="btn btn-info sTitle" onclick="magazineInput();">저장</button>
                    				</div>

					 			</div>
					 			
					 			
					 		</div>
					 		
					 	</div>
					 		
					 </div>
					
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script type="text/javascript">
   
   //CK 에디터 활성화 시작
   /*    ClassicEditor
	    .create( document.querySelector( '#editor' ))
	    .then( editor => {editorContnet = editor;} )
	    .catch( error => {console.error( error );} ); */
	    
   var editorContnet;
   
	ClassicEditor
		.create( document.querySelector( '#editor' ), {
			toolbar: {
		           items: ['heading',
		        	       '|', 
		        	       'bold', 
		        	       'italic', 
		        	       'link', 
		        	       'bulletedList', 
		        	       'numberedList', 
		        	       '|', 
		        	       'indent', 
		        	       'outdent', 
		        	       '|', 
		        	       'imageUpload', 
		        	       'blockQuote', 
		        	       'insertTable', 
		        	       'mediaEmbed', 
		        	       'undo', 
		        	       'redo', 
		        	       'exportPdf', 
		        	       'fontBackgroundColor', 
		        	       'fontColor', 
		        	       'fontSize', 
		        	       'fontFamily', 
		        	       'highlight', 
		        	       'horizontalLine', 
		        	       'underline']
		       },
		       language: 'ko',
		       image: {
		           toolbar: ['imageTextAlternative', 
		        	   		 'imageStyle:full', 
		        	   		 'imageStyle:side']
		       },
		       table: {
		           contentToolbar: ['tableColumn', 
		        	   				'tableRow', 
		        	   				'mergeTableCells', 
		        	   				'tableCellProperties', 
		        	   				'tableProperties']
		       },
			ckfinder: {
		        uploadUrl: 'https://ckeditor.com/apps/ckfinder/3.5.0/core/connector/php/connector.php?command=QuickUpload&type=Files&responseType=json' // 내가 지정한 업로드 url (post로 요청감)
			},
			alignment: {
		          options: [ 'left', 
		        	         'center', 
		        	         'right' ]
		      }
		} )
		.then( editor => {
		      console.log( 'Editor was initialized', editor );
		      editorContnet = editor;
		} )
		.catch( error => {
		    console.error( error );
		} );
	
	$(document).ready(function() {
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
	            $('#mgzMainImgUrl').val(data.fileUrl);
	            //document.getElementById("remove").setAttribute("fileNm", data.fileNm)
	        })
	        .catch(error => console.log(`error => ${error}`));
	    }
		
		$("#dropZone").click(function(){
	       $('#file').click();
	    });
	});


	    
   function magazineInput() {
  
	var mbrSq     = $("#mbrSq").val();     
	var mgzTitle  = $("#mgzTitle").val(); 
	var mgzDescrptn  = $("#mgzDescrptn").val(); 
    var mgzContent = editorContnet.getData();
    var mgzMainImgUrl  = $("#mgzMainImgUrl").val();  
    var mgzTypCd  = $("#mgzTypCd").val();  
    var regMbrSq = $("#mbrSq").val();
    
   	 //잡지 제목
   	 if(isEmpty(mgzTitle)) {
   		bootbox.alert({
				 message: "제목을 입력해 주세요.",
				 locale: 'kr',
				 callback: function() {
				 		$("#mgzTitle").focus();
			     } });
			 return;
   	 }
   	 
   	 //잡지 설명
   	 if(isEmpty(mgzDescrptn)) {
   		bootbox.alert({
				 message: "설명을 입력해 주세요.",
				 locale: 'kr',
				 callback: function() {
				 		$("#mgzDescrptn").focus();
			     } });
			 return;
   	 }
   	 
   	 //잡지 메인 이미지
   	 if(isEmpty(mgzMainImgUrl)) {
   		bootbox.alert({
				 message: "메인이미지를 등록해 주세요.",
				 locale: 'kr',
				 callback: function() {
				 		$("#mgzMainImgUrl").focus();
			     } });
			 return;
   	 }
   	 
     //잡지 내용
   	 if(isEmpty(mgzContent)) {
   		bootbox.alert({
				 message: "내용을 입력해 주세요.",
				 locale: 'kr',
				 callback: function() {
					 $("#mgzContent").focus();
			     } });
			 return;
   	 }
   	        				
     
 	var mbrSq     = $("#mbrSq").val();     
	var mgzTitle  = $("#mgzTitle").val(); 
	var mgzDescrptn  = $("#mgzDescrptn").val(); 
    var mgzContent = editorContnet.getData();
    var mgzMainImgUrl  = $("#mgzMainImgUrl").val();  
    var mgzTypCd  = $("#mgzTypCd").val();  
    var regMbrSq = $("#mbrSq").val();
		
		$.ajax({
	           type: "post",
	           url: "magazineInsertData",
	           data: {
	        	   mbrSq : mbrSq,
	        	   mgzTitle : mgzTitle,
	        	   mgzDescrptn : mgzDescrptn,
	        	   mgzContent : mgzContent,
	        	   mgzMainImgUrl : mgzMainImgUrl,
	        	   mgzTypCd : mgzTypCd,
	        	   regMbrSq : regMbrSq
	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "게시글이 저장 되었습니다.",
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
	}
   
   function magazineList() {
	   location.href='/admin/magazine/magazineList?mgzTypCd=<%=mgzTypCd%>';
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
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

<style type="text/css">
	#toolbar-container{ position: sticky; top: 185px;}
</style>

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
					 	
					 	<table border="0">
					 			<tr>
					 				<td colspan="2">
					 					
					 					<div class="form-group row">
						 					<label class="col-form-label sTitle LabelStyle" style="text-align: center;">제목</label>
	                    					<div class="col-sm-11">
	                      						<input type="text" class="form-control sTitle classname"  id="mgzTitle" name="mgzTitle" value="">
	                    					</div>
						 				</div>
						 				
						 				<div class="form-group row">
						 					<label class="col-form-label sTitle LabelStyle" style="text-align: center;">설명</label>
	                    					<div class="col-sm-11">
	                      						<input type="text" class="form-control sTitle classname"  id="mgzDescrptn" name="mgzDescrptn" value="" style="height:80px;">
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
															
														<img class="content" id="dropZone" style="cursor:pointer;text-align: center;height:170px;width:200px;"/>
		                								
		                							</div>
		                  								
		                						</div>
		                						<b style="font-family: sans-serif; font-size: 8px; color: gray;">※ 회색공간을 클릭해서 업로드하거나, 파일을 끌어와서 업로드 하세요.</b>
													
		              						</div>
	              						</div>
	              							
					 				</td>
					 				<td>
					 					<div class="col-sm-12">
					 						<div id="toolbar-container" style="width:800px;z-index:9999"></div>
                    						<div id="editor" style="border: 1px solid #efefef;width:800px;">
					 					</div>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td  colspan="2" style="text-align:right">
					 					<button type="button" class="btn btn-info sTitle" onclick="boardList();">리스트로 돌아가기</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="boardUpdate();">수정</button>
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
				formData.append("url", "dealingart/mgz/");
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
	        	 
	        	 const domEditableElement = document.querySelector( '.ck-editor__editable' );
	        	 const editorInstance = domEditableElement.ckeditorInstance;
	        	 editorInstance.setData(mgzContentInput);
	        	 
	        	
	        	 
 	        	 $('#mgzTitle').val(mgzTitleInput);
// 	        	 $('#mgzContent').val(mgzContentInput);
 	        	 $('#mgzDescrptn').val(mgzDescrptnInput);
 	        	 $("#mgzMainImgUrl").val(mgzMainImgUrlInput);
	        	 
	        	 if(mgzMainImgUrlInput) {
			        	$("#dropZone").prop("src",mgzMainImgUrlInput)
				   }

	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
   

//    var editor;
   
//    DecoupledEditor
// 	   .create( document.querySelector( '#editor' ) ,{
// 	   	extraPlugins: [MyCustomUploadAdapterPlugin],
	   	
// 	   } )
// 	   .then( editor => {
// 	       const toolbarContainer = document.querySelector( '#toolbar-container' );
	
// 	       toolbarContainer.appendChild( editor.ui.view.toolbar.element );
// 	       document.querySelector( '.editable-container' ).appendChild( editor.ui.view.editable.element );
// 	   } )
// 	   .catch( error => {
// 	       console.error( error );
// 	   } );
	
DecoupledDocumentEditor
	.create( document.querySelector( '#editor' ), {
		
		licenseKey: 'ExsHmoBFE5WDCOKFluh5/uyuEY1LuvUHcEq99SadAptme2Af1zXKgJX2wA==',
		extraPlugins: [MyCustomUploadAdapterPlugin],
		
		
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

   function MyCustomUploadAdapterPlugin(editor) {
	    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
	        return new UploadAdapter(loader)
	    }
	}
   
   
   function boardUpdate() {
		
		var mbrSq     = $("#mbrSq").val();     
		var mgzTitle  = $("#mgzTitle").val(); 
		var mgzDescrptn  = $("#mgzDescrptn").val(); 
	    var mgzContent = $('#editor').html();
	    var mgzMainImgUrl  = $("#mgzMainImgUrl").val();  
	    var mgzTypCd  = $("#mgzTypCd").val();  
	    var updtMbrSq = $("#mbrSq").val();
	   
	   //잡지 제목
	   	 if(isEmpty(mgzTitle)) {
	   		bootbox.alert({
					 message: "제목을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#brdTitle").focus();
				     } });
				 return;
	   	 }
	   	 
	   	 //잡지 설명
	   	 if(isEmpty(mgzDescrptn)) {
	   		bootbox.alert({
					 message: "설명을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#brdTitle").focus();
				     } });
				 return;
	   	 }
	   	<% if(!mgzTypCd.equals("MDA")) { %>
	   	
	   	 //잡지 메인 이미지
	   	 if(isEmpty(mgzDescrptn)) {
	   		bootbox.alert({
					 message: "메인이미지를 등록해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#brdTitle").focus();
				     } });
				 return;
	   	 }
	   	 <% } %>
	   	 
	     //잡지 내용
	   	 if(isEmpty(mgzContent)) {
	   		bootbox.alert({
					 message: "내용을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		
				     } });
				 return;
	   	 }
   	        				
		
		$.ajax({
	           type: "post",
	           url: "magazineUpdateData",
	           data: {
	        	   mgzSq : mgzSq,
	        	   mbrSq : mbrSq,
	        	   mgzTitle : mgzTitle,
	        	   mgzDescrptn : mgzDescrptn,
	        	   mgzContent : mgzContent,
	        	   mgzMainImgUrl : mgzMainImgUrl,
	        	   mgzTypCd : mgzTypCd,
	        	   updtMbrSq : updtMbrSq
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
   
	 //Input Box Null Check
   function isEmpty(str){
       
       if(typeof str == "undefined" || str == null || str == "")
           return true;
       else
           return false ;
   }
	 
   document.querySelectorAll('.tImg').forEach((emoteImage) => {
       emoteImage.addEventListener('dragend', (event) => {
           var imgTag = '<figure class="image ck-widget ck-widget_with-resizer ck-widget_selected" contenteditable="false">'
                   + '<img src="'+event.target.dataset.url+'">';
                   + '</figure>';
           const viewFragment = wr_content_editor.data.processor.toView(imgTag);
           const modelFragment = wr_content_editor.data.toModel( viewFragment );
           wr_content_editor.model.insertContent(modelFragment);
       });
});

   
   </script>
   
   <script>
    
    class UploadAdapter {
        constructor(loader) {
            this.loader = loader;
        }
    

        upload() {
            return this.loader.file.then( file => new Promise(((resolve, reject) => {
                this._initRequest();
                this._initListeners( resolve, reject, file );
                this._sendRequest( file );
            })))
            
            // 파일 업로드가 성공했을때 resolved될 promise를 리턴하자.(server.upload(file) 메서드에서 promise를 리턴 시키라는 뜻)
            return loader.file
                .then( file => server.upload( file ) );
        }

        _initRequest() {
            const xhr = this.xhr = new XMLHttpRequest();
            xhr.open('POST', '/file/ckUpload', true);
            xhr.responseType = 'json';
        }

        _initListeners(resolve, reject, file) {
        	
            const xhr = this.xhr;
            const loader = this.loader;
            const genericErrorText = '파일을 업로드 할 수 없습니다.'

            xhr.addEventListener('error', () => {reject(genericErrorText)})
            xhr.addEventListener('abort', () => reject())
            xhr.addEventListener('load', () => {
                const response = xhr.response
                if(!response || response.error) {
                    return reject( response && response.error ? response.error.message : genericErrorText );
                }

                resolve({
                	default: response.fileUrl //업로드된 파일 주소
                	
                })
            })
        }

        _sendRequest(file) {
            const data = new FormData()
            data.append('upload',file)
            this.xhr.send(data)
        }
    }
    
   
     </script>
 
   <% if(mgzTypCd.equals("MDA")) { %>
    <script>
    	$("#mainImg").hide(); 
    </script>
   <% } %>>
 
</body>
</html>
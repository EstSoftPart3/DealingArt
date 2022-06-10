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
					 	
					 		<div class="col-md-9" style="padding-left:50px;">
					 		
					 			<div class="form-group row">
					 				
					 				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">제목</label>
                    				<div class="col-sm-9">
                      					<input type="text" class="form-control sTitle classname"  id="brdTitle" name="brdTitle" value="">
                    				</div>
					 			</div>
					 			
					 			<div class="form-group row">
		               				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">구분</label>
                    				<div class="col-sm-7">
                      					<div style="padding-left:10px;float:left;">
											<input type="radio" id="a2" name="brdConTypCd" class="brdConTypCd" value="CO" checked>
											<label for="a2" class="col-form-label sTitle">공통</label>
										</div>
                      					<div style="padding-left:10px;float:left;">
                      						<input type="radio" id="a1" name="brdConTypCd" class="brdConTypCd" value="UP">
											<label for="a1" class="col-form-label sTitle">이용정책</label>
										</div>
										<div style="padding-left:10px;float:left;">
											<input type="radio" id="a3" name="brdConTypCd" class="brdConTypCd" value="PU">
											<label for="a3" class="col-form-label sTitle">구매</label>
										</div>
										<div style="padding-left:10px;float:left;">
											<input type="radio" id="a4" name="brdConTypCd" class="brdConTypCd" value="SA">
											<label for="a4" class="col-form-label sTitle">판매</label>
										</div>
										<div style="padding-left:10px;float:left;">
											<input type="radio" id="a4" name="brdConTypCd" class="brdConTypCd" value="TR">
											<label for="a4" class="col-form-label sTitle">운송</label>
										</div>
										<div style="padding-left:10px;float:left;">
											<input type="radio" id="a4" name="brdConTypCd" class="brdConTypCd" value="DE">
											<label for="a4" class="col-form-label sTitle">거래</label>
										</div>
                    				</div>
		               		   </div>
					 			
					 			<div class="form-group row">
                    				
                    				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">내용</label>
                    				<div class="col-sm-9">
                      					
                      					
                      					<div id="toolbar-container"></div>
                      					
                      					<div id="editor" style="border: 1px solid #efefef;">
									        
									    </div>
                      				</div>
                    				
					 			</div>
					 			<div class="form-group row">
                    				
                    				<div class="col-sm-9" style="text-align:right">
                    					<button type="button" class="btn btn-info sTitle" onclick="boardList();">리스트로 돌아가기</button>
                    					<button type="button" class="btn btn-info sTitle" onclick="boardUpdate();">수정</button>
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
	        		        	 
	        	 var brdContentInput = dataContent.brdContent;
	        	 var brdTitleInput = dataContent.brdTitle;
	        	 var brdConTypCd = dataContent.brdConTypCd;
	        	 
	        	 $("input:radio[name='brdConTypCd']:radio[value='"+brdConTypCd+"']").prop('checked', true); // 선택하기

	        	 
	        	 
	        	 const domEditableElement = document.querySelector( '.ck-editor__editable' );
	        	 const editorInstance = domEditableElement.ckeditorInstance;
	        	 editorInstance.setData(brdContentInput);
	        	 
	        	 $('#brdTitle').val(brdTitleInput);
	        	 
	        	 //const element = document.getElementById('brd');
	        	 //element.innerHTML = brdContentInput;
	        	 

	           },
	           error: function(error) {
	        	   var errorJson = JSON.stringify(error);
	               console.log(errorJson);
	           }
		})
	}
   
   /*
   DecoupledEditor
       .create( document.querySelector( '#editor' ) ,{
       	
    	 
    	   extraPlugins: [MyCustomUploadAdapterPlugin],
       	
       } )
       .then( editor => {
           const toolbarContainer = document.querySelector( '#toolbar-container' );

           toolbarContainer.appendChild( editor.ui.view.toolbar.element );
           document.querySelector( '.editable-container' ).appendChild( editor.ui.view.editable.element );
       } )
       .catch( error => {
           console.error( error );
       } );
   */
   
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
	
   	var brdTitle  = $("#brdTitle").val();  //게시판제목
    var brdContent =  $('#editor').html();
   	//게시판 내용 구분
    var brdConTypCd = $("input[name='brdConTypCd']:checked").val();
    
   	
  	 //제목
  	 if(isEmpty(brdTitle)) {
  		bootbox.alert({
				 message: "제목을 입력해 주세요.",
				 locale: 'kr',
				 callback: function() {
				 		$("#brdTitle").focus();
			     } });
			 return;
  	 }
  	
  	 
    //내용
  	 if(isEmpty(brdContent)) {
  		bootbox.alert({
				 message: "내용을 입력해 주세요.",
				 locale: 'kr',
				 callback: function() {
				 		
			     } });
			 return;
  	 }
   	        				
		
		$.ajax({
	           type: "post",
	           url: "boardUpdateData",
	           data: {
	        	   mbrSq : mbrSq,
	        	   brdTypCd : brdTypCd,
	        	   brdSq : brdSq,
	        	   brdTitle : brdTitle,
	        	   brdContent : brdContent,
	        	   brdConTypCd : brdConTypCd
	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "게시글이 수정 되었습니다..",
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
 
</body>
</html>
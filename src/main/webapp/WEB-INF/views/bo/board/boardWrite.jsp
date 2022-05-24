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
                    				<div class="col-sm-9">
                      						<input type="text" class="form-control sTitle classname"  id="brdTitle" name="brdTitle" value="">
                    				</div>
					 			</div>
					 			
					 			<div class="form-group row">
					 			<label class="col-form-label sTitle LabelStyle" style="text-align: center;">내용</label>
                    				<div class="col-sm-9">
                      						<!-- <input type="text" class="form-control sTitle classname"  id="brdContent" name="brdContent" value=""> -->
                    					
                    					<div id="toolbar-container"></div>
                    					
                    					<div id="editor" style="border: 1px solid #efefef;">
									        
									    </div>

                    				</div>
                    				

                    				
					 			</div>
					 			<div class="form-group row">
                    				<div class="col-sm-9" style="text-align:right">
                      						<button type="button" class="btn btn-info sTitle" onclick="boardList();">리스트로 돌아가기</button>
                      						<button type="button" class="btn btn-info sTitle" onclick="boardInput();">저장</button>
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
   var editor;
       
	    DecoupledEditor
            .create( document.querySelector( '#editor' ) ,{
            	extraPlugins: [MyCustomUploadAdapterPlugin],
            	
            } )
            .then( editor => {
                const toolbarContainer = document.querySelector( '#toolbar-container' );

                toolbarContainer.appendChild( editor.ui.view.toolbar.element );
            } )
            .catch( error => {
                console.error( error );
            } );
	    
	    function MyCustomUploadAdapterPlugin(editor) {
		    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
		        return new UploadAdapter(loader)
		    }
		}
   
   function boardInput() {
	
	var mbrSq     = $("#mbrSq").val();     //회원순번
	var brdTypCd  = $("#brdTypCd").val();  //게시판구분코드
   	var brdTitle  = $("#brdTitle").val();  //게시판제목
    //var brdContent = editor.getData();
   	var brdContent = $('#editor').html();
   	console.log(brdContent);
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
	           url: "boardInsertData",
	           data: {
	        	   brdTypCd : brdTypCd,
	        	   regMbrSq : mbrSq,
	        	   brdTitle : brdTitle,
	        	   brdContent : brdContent
	           },
	           success: function(data) {
	        	   bootbox.alert({
						 message: "게시글이 저장 되었습니다.",
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
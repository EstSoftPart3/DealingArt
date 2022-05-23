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
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b><%=ckName%></b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 		<div id="ckeditorList" style="font-size:12px;"></div>
					 	</div>
					 	
					 	<div class="form-group row" >
                    		<div style="text-align:right;width:900px;">
                    			<button type="button" class="btn btn-info sTitle" onclick="ckeditorInput();">입력</button>
					    	</div>
                    	</div>
					 		
					 </div>
	    			
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   
   $(document).ready(function() {
	   ckeditorList();
   });
   
   /* CK에디터 등록 func */
   function ckeditorInput() {
	   var ckTypCd = $('#ckTypCd').val();
	   console.log("ckTypCd :"+ckTypCd);
	   
	    location.href = "/admin/ckeditor/ckeditorWrite?ckTypCd="+ckTypCd;
   }
   
   
   /* CK에디터 목록 func */
   function ckeditorList(){
   
	   var ckTypCd = $('#ckTypCd').val();
	   
	   let params = {
			   ckTypCd : ckTypCd
		}
	   
	   $("#ckeditorList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "900px",
	       inserting: false,
	       editing: false,
	       sorting: false,
	       paging: false,
	       autoload: true,
	       pageSize: 10,
	       gridview : true,
	      
	       deleteConfirm: "정말 삭제 하시겠습니까?",
	       controller: {
	           loadData: function (filter) {
	        	   var d = $.Deferred();
	               $.ajax({
	      	    	 type: "post",
	    	    	 url: "/admin/ckeditor/ckeditorListData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 //d.resolve(response.boardData.boardInfo);
	    	    	 
	    	    	 d.resolve($.map(response.ckeditorData.ckeditorInfo, function (item, itemIndex) {
                         return $.extend(item, { "Index": itemIndex + 1 });
                     }));
	    	    	 
	    	      });
	               return d.promise();
	           }
	       },
	       fields: [
	    	   
	    	   
	    	   { name: "Index", title: "번호", type: "number", width: 30, align: "center", },
	    	   { name: "ckSq",  title:"CK에디터순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mbrSq",title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "ckTitle",id:"CK에디터제목", title:"제목", type: "text", width: 300,align:"center", visible: true, key:true},
	    	   { name: "ckDescrptn",title:"CK에디터설명", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "ckContent",title:"CK에디터내용", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "ckMainImgUrl",title:"CK에디터대표이미지URL", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "ckTypCd",title:"CK에디터구분코드", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "regMbrSq",title:"등록회원", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "regDt",title:"등록일시", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "updtMbrSq",title:"수정회원", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "updtDt",title:"수정일시", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "useYn",title:"사용여부", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "delYn",title:"삭제여부", type: "text", width: 200,align:"center",width:100 }
	    	  
	    	   
	       ],
	       rowClick: function(args) {
	           //console.log(args)
	       	   var getData = args.item.ckSq;
	       	   console.log("getData :"+getData);
	           fn_SubBrdPage(getData);

           }

	   });
   
   }
   
   function fn_SubBrdPage(getData) {
	   var ckTypCd = $('#ckTypCd').val();
	   location.href='/admin/ckeditor/ckeditorDetail?ckSq='+getData+'&ckTypCd='+ckTypCd;
	}
   
   </script>
 
 
</body>
</html>
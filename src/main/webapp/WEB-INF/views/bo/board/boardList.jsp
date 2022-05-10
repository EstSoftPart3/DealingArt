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
		brdName = "FA"; 
	}

%>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     	<!-- Main content -->
	    		<section class="content">
	    			<input type="hidden" name="brdTypCd" id="brdTypCd" value="<%=brdTypCd%>">
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b><%=brdName%></b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 		<div id="boardList" style="font-size:12px;"></div>
					 	</div>
					 	
					 	<div class="form-group row" >
                    		<div class="col-sm-11" style="text-align:right;width:100%">
                    			<button type="button" class="btn btn-info sTitle" onclick="boardInput();">입력</button>
					    	</div>
                    	</div>
					 		
					 </div>
	    			
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   
   $(document).ready(function() {
	   boardList();
   });
   
   /* 게시판 입력 */
   function boardInput() {
	   var brdTypCd = $('#brdTypCd').val();
	   console.log("brdTypCd :"+brdTypCd);
	   
	   location.href = "/admin/board/boardWrite?brdTypCd="+brdTypCd;
   }
   
   
   /* 게시판 리스트 */
   function boardList(){
   
	   var brdTypCd = $('#brdTypCd').val();
	   
	   let params = {
			brdTypCd : brdTypCd
		}
	   
	   $("#boardList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "100%",
	       inserting: false,
	       editing: false,
	       sorting: false,
	       paging: false,
	       autoload: true,
	       pageSize: 10,
	       deleteConfirm: "정말 삭제 하시겠습니까?",
	       controller: {
	           loadData: function (filter) {
	        	   var d = $.Deferred();
	               $.ajax({
	      	    	 type: "post",
	    	    	 url: "/admin/board/boardListData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 d.resolve(response.boardData.boardInfo);
	    	      });
	               return d.promise();
	           }
	       },
	       fields: [
	    	   { name: "brdSq"	,title:"게시판순번", type: "text", width: 150,align:"center" ,width:100, visible: true},
	    	   { name: "mbrSq"	,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: true},
	    	   { name: "brdTitle"	,id:"brdTitle", title:"게시판제목", type: "text", width: 150,align:"center" ,width:100, visible: true, key:true},
	    	   { name: "brdTypCd",title:"게시판종류", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "regMbrSq",title:"등록회원순번", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "regDt",title:"등록일시", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "updtMbrSq",title:"수정회원순번", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "updtDt",title:"수정일시", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "delYn",title:"삭제여부", type: "text", width: 200,align:"center",width:100 }
	    	  
	    	   
	       ],
	       rowClick: function(args) {
	           //console.log(args)
	       	   var getData = args.item.brdSq;
	       	   console.log("getData :"+getData);
	           fn_SubBrdPage(getData);

           }

	   });
   
   }
   
   function fn_SubBrdPage(getData) {
	   var brdTypCd = $('#brdTypCd').val();
	   location.href='/admin/board/boardDetail?brdSq='+getData+'&brdTypCd='+brdTypCd;
	}
   
   </script>
 
 
</body>
</html>
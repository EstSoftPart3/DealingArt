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
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b><%=mgzName%></b></a></li>
		               	</ul>
					</div>
					 
					<div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 		<div class="col-sm-9">
					 			<div id="magazineList" style="font-size:12px;"></div>
					 		</div>
					 	</div>
					 	
					 	<div class="form-group row" >
                    		<div class="col-sm-9" style="text-align:right;right:15px;">
                    			<button type="button" class="btn btn-info sTitle" onclick="magazineInput();">입력</button>
					    	</div>
                    	</div>
					 		
					</div>
	    			
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   
   $(document).ready(function() {
	   magazineList();
   });
   
   /* 메거진 등록 func */
   function magazineInput() {
	   var mgzTypCd = $('#mgzTypCd').val();
	   console.log("mgzTypCd :"+mgzTypCd);
	   
	    location.href = "/admin/magazine/magazineWrite?mgzTypCd="+mgzTypCd;
   }
   
   
   /* 메거진 리스트 func */
   function magazineList(){
   
	   var mgzTypCd = $('#mgzTypCd').val();
	   
	   let params = {
			   mgzTypCd : mgzTypCd
		}
	   
	   $("#magazineList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "100%",
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
	    	    	 url: "/admin/magazine/magazineListData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 //d.resolve(response.boardData.boardInfo);
	    	    	 
	    	    	 d.resolve($.map(response.magazineData.magazineInfo, function (item, itemIndex) {
                         return $.extend(item, { "Index": itemIndex + 1 });
                     }));
	    	    	 
	    	      });
	               return d.promise();
	           }
	       },
	       fields: [
	    	   
	    	   
	    	   { name: "Index", title: "번호", type: "number", width: 30, align: "center", },
	    	   { name: "mgzSq",  title:"메거진순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mbrSq",title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mgzTitle",id:"메거진제목", title:"제목", type: "text", width: 300,align:"center", visible: true, key:true},
	    	   { name: "mgzDescrptn",title:"메거진설명", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "mgzContent",title:"메거진내용", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "mgzMainImgUrl",title:"메거진대표이미지URL", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "mgzTypCd",title:"메거진구분코드", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "regMbrSq",title:"등록회원", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "regDt",title:"등록일시", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "updtMbrSq",title:"수정회원", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "updtDt",title:"수정일시", type: "text", width: 200,align:"center",width:100 , visible: false},
	    	   { name: "useYn",title:"사용여부", type: "text", width: 200,align:"center",width:100 },
	    	   { name: "delYn",title:"삭제여부", type: "text", width: 200,align:"center",width:100 }
	    	  
	    	   
	       ],
	       rowClick: function(args) {
	           //console.log(args)
	       	   var getData = args.item.mgzSq;
	       	   console.log("getData :"+getData);
	           fn_SubBrdPage(getData);

           }

	   });
   
   }
   
   function fn_SubBrdPage(getData) {
	   var mgzTypCd = $('#mgzTypCd').val();
	   location.href='/admin/magazine/magazineDetail?mgzSq='+getData+'&mgzTypCd='+mgzTypCd;
	}
   
   </script>
 
 
</body>
</html>
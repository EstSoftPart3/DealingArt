<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		    
		     	<!-- Main content -->
	    		<section class="content">
	    			
	    			
	    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                 	<ul class="nav nav-pills">
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>배송</b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 		<div id="trnsprtList" style="font-size:12px;"></div>
					 	</div>
					 	
					 		
					 </div>
	    			
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   $(document).ready(function() {
	   trnsprtList();
   });
   
   
   function trnsprtList() {
	   
	   var dealSq = "";
	   
	   let params = {
			dealSq : dealSq
	   }
	   
	   $("#trnsprtList").jsGrid({
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
	    	    	 url: "/admin/payment/trnsprtListData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 //d.resolve(response.boardData.boardInfo);
	    	    	 
	    	    	 d.resolve($.map(response.data.listInfo, function (item, itemIndex) {
                         return $.extend(item, { "Index": itemIndex + 1 });
                     }));
	    	    	 
	    	      });
	               return d.promise();
	           }
	       },
	       fields: [
	    	   { name: "Index", title: "번호", type: "number", width: 30, align: "center"},
	    	   { name: "dealSq"	,title:"거래순번", type: "text",align:"center", visible: true},
	    	   { name: "sellMbrSq"	,title:"판매자순번", type: "text",align:"center", visible: true},
	    	   { name: "buyMbrSq",id:"brdTitle", title:"구매자순번", type: "text",align:"center", visible: true, key:true},
	    	   { name: "artstSq",title:"작가순번", type: "text",align:"center", visible: true},
	    	   { name: "trnsprtDivCd",title:"운송구분", type: "text",align:"center",visible: true},
	    	   { name: "trnsprtTypCd",title:"운송유형", type: "text",align:"center",visible: true},
	    	   { name: "trnsprtAreaCd",title:"운송지역", type: "text",align:"center",visible: true},
	    	   { name: "trnsprtServiceCd",title:"운송서비스", type: "text",align:"center",visible: true},
	    	   { name: "trnsprtPrc",title:"운송가격", type: "text",align:"center" }
	    	  
	    	   
	       ],
	       rowClick: function(args) {
	           //console.log(args)
	       	   var getData = args.item.brdSq;
	       	   console.log("getData :"+getData);
	           

           }

	   });
	   
   }
   </script>
 
 
</body>
</html>
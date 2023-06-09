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
		               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>결제</b></a></li>
		               	</ul>
					 </div>
					 
					 <div class="card">
					 
					 	<div class="card-body" style="background-color:#ffffff;">
					 		<div id="dealMainList" style="font-size:12px;"></div>
					 	</div>
					 	
					 		
					 </div>
	    			
	    		</section>
	    		
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   <script>
   $(document).ready(function() {
	   dealMainList();
   });
   
   
   function dealMainList() {
		
	   var dealSq = "";
	   
	   let params = {
			dealSq_temp : dealSq
	   }
	   
	   $("#dealMainList").jsGrid({
		   locale:"ko",
	       height: "900px",
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
	    	    	 url: "/admin/payment/dealMainListData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 	    	    	 
	    	    	 d.resolve($.map(response.data.dealInfo, function (item, itemIndex) {
                         return $.extend(item, { "Index": itemIndex + 1 });
                     }));
	    	    	 
	    	      });
	               return d.promise();
	           }
	       },
	       fields: [
	    	   { name: "Index"			,title: "번호"			,type: "number"	,align:"center"   ,width: 30},
	    	   { name: "mbrRefNo"		,title:"거래주문번호"		,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealSq"			,title:"거래순번"			,type: "text"	,align:"center"	 ,visible: false},
	    	   { name: "workSq"			,title:"작품명"			,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "artstSqNm"		,title:"작가명[활동명]"		,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealTypCd"		,title:"거래유형코드"		,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealTypCdTxt"	,title:"거래상태"			,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealStrtPrc"	,title:"거래시작가격(원)"	,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealAuctnPrc"	,title:"거래응찰가격(원)"	,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealFinalPrc"	,title:"거래최종가격(원)"	,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealStrtDt"		,title:"거래시작일시"		,type: "text"	,align:"center"  ,visible: true},
	    	   { name: "dealEndngDt"	,title:"거래종료일시"		,type: "text"	,align:"center"  ,visible: true}
	    	   
	       ],
	       rowClick: function(args) {
	           //console.log(args)
	       	   var getData = args.item.dealSq;
	       	   console.log("getData :"+getData);
	       	
	       	   fn_SubBrdPage(getData);
           }

	   });
	   
	   function fn_SubBrdPage(getData) {
		   location.href='/admin/payment/paydetailPage?dealSq='+getData;
		}
   }
   </script>
 
 
</body>
</html>
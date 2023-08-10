<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>


<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		 
		     <!-- Main content -->
    		<section class="content">
    		
    		<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	         	<ul class="nav nav-pills">
		        	<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>신고</b></a></li>
		    	</ul>
			</div>
    			
    			<div class="card">
    			
    			  	 <div id="grid" class="grid" style="font-size:12px;"></div>
		          
    			</div>
    			
    		</section>
    		
		 </div>
		 
		  <!--card-footer -->
         <div class="card-footer" >
              
         </div>
		
	</div>
	
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
    <script>
		function reportList(){
			
		   
			$("#grid").jsGrid({
				locale:"ko",
		       	height: "700px",
		       	width: "100%",
		       	inserting: false,
		       	editing: false,
		       	sorting: false,
		       	paging: false,
		       	autoload: true,
		       	pageSize: 10,
		       	gridview : true,
		      
		       	controller: {
		        	loadData: function (filter) {
		        		var d = $.Deferred();
		               	$.ajax({
		      	    	 	type: "post",
		    	    	 	url: "/admin/report/reportSearch",
		    	         	dataType: "json"
		    	      	}).done(function(response) {
		    	    	 	d.resolve($.map(response.result, function (item, itemIndex) {
		    	    			var rSize = response.result.length - itemIndex;
		    	    		 	return $.extend(item, { "Index": rSize });
		                	}));
		    	    	 
		    	      	});
		               	return d.promise();
		           	}
		       	},
		       	fields: [
		    	   	{ name: "Index",title:"번호", type: "text", width: 50,align:"center" , visible: true},
		    	   	{ name: "rprtSq",title:"번호", type: "text", width: 200,align:"center" , visible: false},
		    	   	{ name: "mbrSq",title:"신고자 번호", type: "text", width: 200,align:"center" , visible: false},
		    	   	{ name: "mbrNcknm",title:"신고자명", type: "text", width: 200,align:"center" , visible: true},
		    	   	{ name: "rprtContent",title:"신고내용", type: "text", width: 200,align:"center" , visible:false },
		    	   	{ name: "workSq",title:"신고된 작품 번호", type: "text", width: 200,align:"center" , visible: false},
		    	   	{ name: "artstActvtyNm",title:"작가명", type: "text", width: 200,align:"center" , visible: true},
		    	   	{ name: "workNm",title:"작품명", type: "text", width: 200,align:"center" , visible: true},
		    	   	{ name: "rprtTypCdNm",title:"처리구분", type: "text", width: 200,align:"center" , visible: true},
		    	   	{ name: "regDt",title:"신고일", type: "text", width: 200,align:"center" , visible: true},

		    	],
		    	rowClick: function(args) {
			    	var getData = args.item.rprtSq;
			       	fn_SubDetailPage(getData);
		        }  
		    });
		}
		
		$(document).ready(function() {
			reportList();
		});
		
		function fn_SubDetailPage(getData) {
			location.href='/admin/report/reportDetail?rprtSq='+getData;
		}
		   

	</script>
	 
</body>
</html>
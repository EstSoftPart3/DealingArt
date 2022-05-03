<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<style type="text/css">
	#gridCodeList, #subGridCodeList {
		font-size : 11px;
	}
	.jsgrid-table {overflow-x: hidden;}
	.jsgrid-grid-header {overflow-x: hidden;}
	.jsgrid-grid-body {overflow-x: hidden;}
</style>

<body class="hold-transition sidebar-mini">

<input type="text" name="cdSq" id="cdSq">

<input type="hidden" id="rowClickCdSq">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		 
		 	<!-- Main content -->
    		<section class="content">
    			<div class="card-header">
	               	<h3 class="card-title bTitle">공통코드</h3>
				</div>
			
				<div class="card-body" style="background-color:#ffffff;">
					
					<div class="card-body table-responsive p-0" style="overflow:hidden;">
						<section class="content">
						
							<div class="container-fluid" style="padding-left:3px;">
								<div class="row">
									<div>
										<div class="card-body" style="width:100%;" align="right">
											
											<!-- 공통코드명 -->
											<div style="float:left">
												<div style="padding:5px;">
													<button id="BtnAddgridCodeList" type="button" onclick="AddClick('gridCodeList')" style="font-size:12px;">코드추가</button>
												</div>
											
												<div id="gridCodeList"></div>
											</div>
											<div style="float:left;padding-left:10px;">
												<div style="padding:5px;">
													<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('subGridCodeList')" style="font-size:12px;">코드추가</button>
												</div>
												<div id="subGridCodeList"></div>
											</div>
										</div>
									</div>
									
									
								</div>
							</div>
							
						</section>
					</div>
					
				</div>
			</section>
		 </div>
		
	</div>

   
   <%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
   
   
   <script>
   /* TEST */
   
    function AddClick(gridId) {
	    
	    console.log("AddClick_"+gridId);
	   
	    if ($('#'+gridId+' .jsgrid-insert-row').css('display') == "none") {
	      //Add 버튼 보이기, Show Add Button
	      $('#'+gridId+' .jsgrid-insert-row').css({ display: 'table-row' });
	      $('#BtnAdd'+gridId).text('닫기');
	      return false;
	    }
	    
	    if ($('#'+gridId+' .jsgrid-insert-row').css('display') == "table-row") {
	      //Add 버튼 숨기기, Hide Add Button 
	      $('#'+gridId+' .jsgrid-insert-row').css({ display: 'none' });
	      $('#BtnAdd'+gridId).text('코드추가');
	      return false;
	    }

   }
   
   function fn_insertItem() {
	  $("#gridCodeList").jsGrid("insertItem");
   }
   
   function fn_subInsertItem() {
	   console.log("fn_subInsertItem");
		$("#subGridCodeList").jsGrid("insertItem");
	}
  
   
   function fn_GpCmCd(str) {
	   
	   let params = {
		  cdSq : str
	   }
	   
	   $("#gridCodeList").jsGrid({
		   locale:"ko",
           height: "700px",
           width: "400px",
           inserting: false,
           editing: true,
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
        	    	 url: "/admin/comCodeListData",
        	         data: params,
        	         dataType: "json"
        	      }).done(function(response) {
        	    	 d.resolve(response.comCodeList.comCodeListData);
        	      });
                   return d.promise();
               },
               insertItem: function (item) {
            	   console.log("insertItem");
            	   console.log(item);
            	               	   
                   return $.ajax({
                       type: "POST",
                       url: "/admin/comCodeInputData",
                       data: item
                   }).done(function(response) {
          	    	 	console.log("insertItem CallBack");
          	    		$("#gridCodeList").jsGrid("loadData");
          	      });
                   
               },
               updateItem: function (item) {
            	   console.log("updateItem");
            	   console.log(item);
            	   return $.ajax({
                       type: "POST",
                       url: "/admin/comCodeUpdateData",
                       data: item
                   }).done(function(response) {
          	    	 	console.log("updateItem CallBack");
          	    		$("#gridCodeList").jsGrid("loadData");
          	      });
               },
               deleteItem: function (item) {
            	   console.log("deleteItem");
            	   return $.ajax({
                       type: "POST",
                       url: "/admin/comCodeDeleteData",
                       data: item
                   }).done(function(response) {
          	    	 	console.log("insertItem CallBack");
          	    		$("#gridCodeList").jsGrid("loadData");
          	      });
               }
           },
           fields: [
        	   { name: "cdSq"	,title:"코드 순번1", type: "text", width: 150,align:"center" ,width:100, visible: false},
        	   { name: "cd"		,title:"코드", type: "text", width: 150,align:"center" ,width:100, validate: "required" },
        	   { name: "cdNm"	,title:"코드명", type: "text", width: 200,align:"center",width:100, validate: "required" },
        	   { type: "control",deleteButton: true },
        	   
           ],
           rowClick: function(args) {
        	   //console.log(args)
       	    var getData = args.item.cdSq;
       	   	console.log("getData :"+getData);
         	$('#cdSq').val(getData);
         	
         	
         	fn_SubGpCmCd(getData);
       	   	
//        	    //$("#subGridCodeList").jsGrid("loadData");
//        	    $("#subGridCodeList").jsGrid("option", "data", []);
       		
//        	   	var insert_item = {};
//        	  	//데이터를 추가를 위해서 json object 생성
//        	  	insert_item.cdSq = getData;
//        	  	insert_item.dtlCdSq = '';
//        	  	insert_item.dtlCd = '';
//        	  	insert_item.dtlCdNm = '';
//        	  	insert_item.dtlCdPrprtVal1 = '';
//        	  	insert_item.dtlCdPrprtVal2 = '';
//        	  	insert_item.dtlCdPrprtVal3 = '';
//        	  	insert_item.note = '';
//        	  	//grid에 넣을 데이터를 object의 만들기
//        	  	$("#subGridCodeList").jsGrid("insertItem", insert_item);
           
           }
       });
	   
   }
   
 

  let subfields = [
	  { name: "cdSq"	,title:"코드순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	  { name: "dtlCdSq"	,title:"상세코드순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
      { name: "dtlCd"	,title:"상세코드", type: "text", width: 200,align:"center",width:100 ,validate: "required"},
	  { name: "dtlCdNm"	,title:"상세코드명", type: "text", width: 200,align:"center",width:100 ,validate: "required"},
	  { name: "note"	,title:"비고", type: "text", width: 200,align:"center",width:100},
	  { type: "control",deleteButton: true }
  ]
  
  function fn_SubGpCmCd(str) {
		  let subParams = {
			 cdSq : str
		  }
		  
		  $("#subGridCodeList").jsGrid({
			  locale:"ko",
		  	  height: "700px",
		      width: "700px",
		      paging: false,
		      autoload: true,
		      inserting: false,
		      editing: true,
		      fields : subfields,
			  controller: {
		          loadData: function (filter) {
		       	   var d = $.Deferred();
		              $.ajax({
		     	    	 type: "post",
		   	    	 url: "/admin/comSubCodeListData",
		   	         data: subParams,
		   	         dataType: "json"
		   	      }).done(function(response) {
		   	    	 console.log(response);
		   	    	 d.resolve(response.comCodeList.comSubCodeListData);
		   	      });
		              return d.promise();
		          },
		          insertItem: function (item) {
		       	   console.log("insertItem");
		       	   //console.log(item);
		       	   
		       	   var cdSqValue =	$('#cdSq').val();
		       	   
		       	   console.log("cdSqValue :"+cdSqValue);
		       	
		       	   let iParam = {
		       			cdSq : cdSqValue,   
		       			dtlCd : item.dtlCd,
		       			dtlCdNm : item.dtlCdNm,
		       			note : item.note
		       	   }
		       	   
		       	   console.log("iParam :"+iParam);
		 
		       	   return $.ajax({
		                  type: "POST",
		                  url: "/admin/comSubCodeInsert",
		                  data: iParam
		              }).done(function(response) {
		     	    	 	console.log("insertItem CallBack");
		     	    		$("#subGridCodeList").jsGrid("loadData");
		     	    		
		     	    		$('#cdSq').val(cdSqValue);
		     	      });
		              
		          },
		          updateItem: function (item) {
		       	   console.log("updateItem");
		       	
		       	   let uParam = {
		       			cdSq : cdSqValue,   
		       			dtlCd : item.dtlCd,
		       			dtlCdNm : item.dtlCdNm,
		       			note : item.note
		       	   }
		       	
		       	   return $.ajax({
		                  type: "POST",
		                  url: "/admin/comSubCodeUpdate",
		                  data: uParam
		              }).done(function(response) {
		     	    	 	
		            	  console.log("updateItem CallBack");
		     	    	 	
		     	    		$("#subGridCodeList").jsGrid("loadData");
		     	      });
		          },
		          deleteItem: function (item) {
		       	   console.log("deleteItem");
		//        	   return $.ajax({
		//                   type: "POST",
		//                   url: "/admin/comCodeDeleteData",
		//                   data: item
		//               }).done(function(response) {
		//      	    	 	console.log("insertItem CallBack");
		//      	    		$("#gridCodeList").jsGrid("loadData");
		//      	      });
		//           }
		      }
		      
		  }
		 });
  }
	
  
  //Input Box Null Check
  function isEmpty(str){
      
      if(typeof str == "undefined" || str == null || str == "")
          return true;
      else
          return false ;
  }
 
  
   
 $( document ).ready(function() {
	 fn_GpCmCd();
	 fn_SubGpCmCd(1);
 });
   
</script>
 
 
</body>
</html>
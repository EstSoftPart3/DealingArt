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
						
							<div class="container-fluid" style="padding-left:10px;">
								<div class="row">
									<div>
										<div class="card-body" style="width:400px;">
											<!-- 공통코드명 -->
											<div id="gridCodeList"></div>
										</div>
									</div>
									
									<div class="col-md-9" style="padding-left:50px;padding-top:20px;">
									<div class="form-group row">
		               						
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">코드</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="gCd" name="gCd" value="">
                    						</div>
                    						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">코드명</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="gCdNm" name="gCdNm" value="">
                    						</div>
                    						<div class="col-sm-3">
                      							<a href="#" class="btn btn-info btn-block" style="font-size:11px;width:100px;" onclick="comnCodeInput();"><b>입력</b></a>
                    						</div>
                    						
                    						
		               		   			</div>
										<div id="subGridCodeList"></div>
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
   function comnCodeInput() {
	   var gCd 	 = $("#gCd").val();		//그룹코드
	   var gCdNm = $("#gCdNm").val();	//그루코드명
	   
	   //그룹코드
   	   if(isEmpty(gCd)) {
   			bootbox.alert({
				 message: "그룹코드를 입력해 주세요.",
				 locale: 'kr',
				 callback: function() {
				 		$("#gCd").focus();
			     } });
			 return;
   		}
	   
   		//그룹코드명
   	   if(isEmpty(gCdNm)) {
   			bootbox.alert({
				 message: "그룹코드명을 입력해 주세요.",
				 locale: 'kr',
				 callback: function() {
				 		$("#gCdNm").focus();
			     } });
			 return;
   		}
	   
	   let params = {
			   cd : gCd,
			   cdNm : gCdNm
	   }
	   
	   $.ajax({
           type: "post",
           url: "/admin/comCodeInputData",
           data: params,
           success: function(data) {
        	   console.log(data);
        	   bootbox.alert({
					 message: "그룹코드 등록완료.",
					 locale: 'kr',
					 callback: function() {
						 
						 $("#gCd").val('');
						 $("#gCdNm").val('');
						 
						 $("#gridCodeList").jsGrid("loadData");
				     } });
		   },
           error: function(error) {
        	   var errorJson = JSON.stringify(error);
               console.log(errorJson);
           }
	});
   }
   
  	   
  var height = window.screen.height * 0.6;
 
  let fields = [
	  { name: "cdSq"	,title:"코드 순번", type: "text", width: 150,align:"center" ,width:100, visible: false, width: 0},
	  { name: "cd"	,title:"코드", type: "text", width: 150,align:"center" ,width:100},
      { name: "cdNm"	,title:"코드명", type: "text", width: 200,align:"center",width:100}
	]
  
    
function codeListSearch(str) {
   
   let params = {
	   cdSq : str
   }
	
  $("#gridCodeList").jsGrid({
	  locale:"ko",
  	  height: height,
      width: "100%",
      paging: false,
      autoload: true,
	  fields: fields,
	  controller: {
	       loadData: function(filter) {
	       var d = $.Deferred();
	      $.ajax({
	    	 type: "post",
	    	 url: "/admin/comCodeListData",
	         data: params,
	         dataType: "json"
	      }).done(function(response) {
	    	  //console.log(response);
	         //조회 데이터 셋팅
	         d.resolve(response.comCodeList.comCodeListData);
	      });
	      return d.promise();
	   }
	},
	rowClick: function(args) {
	    //console.log(args)
	    var getData = args.item.cdSq;
	   	console.log("getData :"+getData);
  	

	   	$('#rowClickCdSq').val(getData);
	   	
	    //$("#subGridCodeList").jsGrid("loadData");
	    $("#subGridCodeList").jsGrid("option", "data", []);
		
	   	var insert_item = {};
	  //데이터를 추가를 위해서 json object 생성
	  insert_item.cdSq = getData;
	  insert_item.dtlCdSq = '';
	  insert_item.dtlCd = '';
	  insert_item.dtlCdNm = '';
	  insert_item.dtlCdPrprtVal1 = '';
	  insert_item.dtlCdPrprtVal2 = '';
	  insert_item.dtlCdPrprtVal3 = '';
	  insert_item.note = '';
	  //grid에 넣을 데이터를 object의 만들기
	  $("#subGridCodeList").jsGrid("insertItem", insert_item);
	
	}
 });
  
}
  

  
  
  let subfields = [
	  { name: "cdSq"	,title:"코드순번", type: "text", width: 150,align:"center" ,width:100},
	  { name: "dtlCdSq"	,title:"상세코드순번", type: "text", width: 150,align:"center" ,width:100},
      { name: "dtlCd"	,title:"상세코드", type: "text", width: 200,align:"center",width:100},
	  { name: "dtlCdNm"	,title:"상세코드명", type: "text", width: 200,align:"center",width:100},
	  { name: "dtlCdPrprtVal1"	,title:"속성값1", type: "text", width: 200,align:"center",width:100},
	  { name: "dtlCdPrprtVal2"	,title:"속성값2", type: "text", width: 200,align:"center",width:100},
	  { name: "dtlCdPrprtVal3"	,title:"속성값3", type: "text", width: 200,align:"center",width:100},
	  { name: "note"	,title:"비고", type: "text", width: 200,align:"center",width:100}
  ]
  
  $("#subGridCodeList").jsGrid({
	  locale:"ko",
  	  height: height,
      width: "100%",
      paging: false,
      autoload: true,
      inserting: false,
      editing: true,
	  fields: subfields
	
 });

	
  
  //Input Box Null Check
  function isEmpty(str){
      
      if(typeof str == "undefined" || str == null || str == "")
          return true;
      else
          return false ;
  }
  
  
   
 $( document ).ready(function() {
	 codeListSearch(3)
 });
   
</script>
 
 
</body>
</html>
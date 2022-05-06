<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

<style type="text/css">
	input[readonly].classname{
 		 background-color:#ffffff;
	}
	 .LabelStyle
    {
    	background-color:#efefef;
    	width:100px;
    }	
</style>

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
	
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		 <div class="content-wrapper">
		     
		     <!-- Main content -->
    		<section class="content">
    		
    			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
                 	<ul class="nav nav-pills">
	               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>회원기본정보</b></a></li>
	               	</ul>
				 </div>
				
				<div class="card">	
					<form class="form-horizontal" name="formInfo" id="formInfo">
				
					<input type="hidden" name="mbrSq" id="mbrSq" value="<c:out value="${param.mbrSqParam}" />">
				
	                <div class="card-body" style="background-color:#ffffff;">
	                	                	              	
	                	<div class="card-body table-responsive p-0" style="overflow:hidden;">
		              	
			               <div class="form-group row">
			               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">아이디/이메일</label>
	                    		<div class="col-sm-2">
	                      			<input type="text" class="form-control sTitle classname"  id="mbrId" readonly>
	                    		</div>
			               		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">성명</label>
	                    		<div class="col-sm-1">
	                      			<input type="text" class="form-control sTitle classname"  id="mbrNm" readonly>
	                    		</div>
	                    		<label class="col-form-label sTitle LabelStyle" style="text-align: center;">휴대폰번호</label>
	                    		<div class="col-sm-1">
	                      			<input type="text" class="form-control sTitle classname"  id="mbrCpNum" readonly>
	                    		</div>
	                    		
	                  		</div>
	                  	</div>
	             	</div>
                 </div> 
                 
                 <div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);background-color:#efefef">
                 	<ul class="nav nav-pills">
	               		<li class="nav-item"><a class="sTitle" href="#" data-toggle="tab"><b>작가회원정보</b></a></li>
	               	</ul>
				 </div>
				 
				 <div class="card">	
                  	<div class="card-body p-0" >
                  		 
      						<div class="container-fluid" style="padding-top:50px;padding-left:50px;">
        						<div class="row">
        							
            						<div class="card card-primary card-outline">
              							<div class="card-body box-profile">
                							<div class="text-center">
                								<div style="height:152px;width:150px;background-color:#efefef">
                								
                									<input type="hidden" name="artstProfileImgUrl" id="artstProfileImgUrl">
													<input type="file" id="file" style="display:none">
													<img class="content" id="dropZone" style="cursor:pointer;height:152px;width:150px;"/>
                								
                								</div>
                  								<!-- <img class="profile-user-img img-fluid img-circle" src=""> -->
                							</div>
											<a href="javascript:imgInput();" class="btn btn-info btn-block" style="font-size:11px;"><b>등록</b></a>
              							</div>
              						</div>
              						
              						<div class="col-md-9" style="padding-left:50px;">
              							<input type="hidden" name="artstSq" id="artstSq">
              							<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동명</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstActvtyNm" name="artstActvtyNm" value="">
                    						</div>
                    						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">영문명</label>
                    						<div class="col-sm-3">
                      							<input type="text" class="form-control sTitle classname"  id="artstEnglsNm" name="artstEnglsNm" value="">
                    						</div>
		               		   			</div>
		               		   			
		               		   			<div class="form-group row">
		               		   				<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동국가</label>
                    						<div class="col-sm-3">
                      							<select class="form-control sTitle" name="artstActvtyNatnCd" id="artstActvtyNatnCd">
													<option value="KR" selected>대한민국</option>
												</select>
                    						</div>
                    						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동도시</label>
                    						<div class="col-sm-3">
                      							<select class="form-control sTitle" name="artstActvtyCityCd" id="artstActvtyCityCd">
													<option value="KR-11">서울특별시</option>
													<option value="KR-26">부산광역시</option>
													<option value="KR-27">대구광역시</option>
													<option value="KR-28">인천광역시</option>
													<option value="KR-29">광주광역시</option>
													<option value="KR-30">대전광역시</option>
													<option value="KR-31">울산광역시</option>
													<option value="KR-50">세종특별자치시</option>
													<option value="KR-41">경기도</option>
													<option value="KR-42">강원도</option>
													<option value="KR-43">충청북도</option>
													<option value="KR-44">충청남도</option>
													<option	value="KR-45">전라북도</option>
													<option	value="KR-46">전라남도</option>
													<option	value="KR-47">경상북도</option>
													<option	value="KR-48">경상남도</option>
													<option	value="KR-49">제주특별자치도</option>
												</select>
                    						</div>
		               		   			</div>
		               		   			
		               		   			
		               		   			
		               		   			<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">활동분야</label>
                    						<div class="col-sm-7">
                      							<div style="padding-left:10px;float:left;">
                      								<input type="radio" id="a1" name="artstActvtyPartCd" class="artstActvtyPartCd" value="PNTNG">
													<label for="a1" class="col-form-label sTitle">회화</label>
												</div>
												<div style="padding-left:10px;float:left;">
													<input type="radio" id="a2" name="artstActvtyPartCd" class="artstActvtyPartCd" value="MLDNG">
													<label for="a2" class="col-form-label sTitle">조형</label>
												</div>
												<div style="padding-left:10px;float:left;">
													<input type="radio" id="a3" name="artstActvtyPartCd" class="artstActvtyPartCd" value="VDMD">
													<label for="a3" class="col-form-label sTitle">영상/미디어</label>
												</div>
												<div style="padding-left:10px;float:left;">
													<input type="radio" id="a4" name="artstActvtyPartCd" class="artstActvtyPartCd" value="INSTL">
													<label for="a4" class="col-form-label sTitle">설치</label>
												</div>
                    						</div>
		               		   			</div>
		               		   			
		               		   			<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">자기소개</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstSelfIntro" name="artstSelfIntro" cols="40" rows="5" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row" style="display:none">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">홍보영상</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstPromtnVideoUrl" name="artstPromtnVideoUrl" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">홈페이지</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstHmpgUrl" name="artstHmpgUrl" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">페이스북</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstFacebookUrl" name="artstFacebookUrl" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row">
		               						<label class="col-form-label sTitle LabelStyle" style="text-align: center;">인스타그램</label>
                    						<div class="col-sm-7">
                      							<input type="text" class="form-control sTitle classname"  id="artstInstagramUrl" name="artstInstagramUrl" value="">
                    						</div>
                    					</div>
                    					<div class="form-group row" >
                    						<div class="col-sm-8" style="text-align:right;">
                    							<button type="button" class="btn btn-info sTitle" onclick="goList();">목록</button>
					                  			<button type="button" class="btn btn-info sTitle" onclick="artistMemberInput();">저장</button>
					                  		</div>
                    					</div>
              						</div>
              						
                    			</div>	
                    				
                  				</div>
                  			</div>
                  		
                	</div>
                	
                	
                
                <!--card-body -->
                
             
                
              </form>
              
              <div class="card">
              
	              <div class="card-header p-2" style="border-top: 1px solid rgba(0,0,0,.125);background-color:#efefef">
	                <ul class="nav nav-pills">
	                  <li class="nav-item"><a class="nav-link active sTitle" href="#tab-1" data-toggle="tab"><b>작가학력정보</b></a></li>
	                  <li class="nav-item"><a class="nav-link sTitle" href="#tab-2" data-toggle="tab"><b>작가경력정보</b></a></li>
	                  <li class="nav-item"><a class="nav-link sTitle" href="#tab-3" data-toggle="tab"><b>작가소속정보</b></a></li>
	                  <li class="nav-item"><a class="nav-link sTitle" href="#tab-4" data-toggle="tab"><b>전시정보[개인전/단체전]</b></a></li>
	                  <li class="nav-item"><a class="nav-link sTitle" href="#tab-5" data-toggle="tab"><b>전시정보[아트페어]</b></a></li>
	                  <li class="nav-item"><a class="nav-link sTitle" href="#tab-6" data-toggle="tab"><b>전시정보[레지던시]</b></a></li>
	                  <li class="nav-item"><a class="nav-link sTitle" href="#tab-7" data-toggle="tab"><b>전시정보[수상]</b></a></li>
	                </ul>
	              </div><!-- /.card-header -->
	              
	              <div class="card-body">
	              
	              	<div class="tab-content">
	              	
	              		<div class="active tab-pane" id="tab-1">
              			   <!-- 작가학력정보 -->            
			               <div class="card-body table-responsive p-0" style="overflow:hidden;padding-top:20px;">
			                  	
			                  	<table border="0">
			                  		<tr>
			                  			<td align="right">
											<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('eductnList')" style="font-size:12px;">코드추가</button>
										</td>
									</tr>
									<tr>
										<td>
								       		<div id="eductnList" style="font-size:12px;"></div>
								       	</td>
			                  		</tr>
			                  	</table>
			                  	
			               	</div>
			               	
               			</div>
               			
               			<div class="tab-pane" id="tab-2">
               	
               	           <div class="card-body table-responsive p-0" style="overflow:hidden;padding-top:20px;">
			                  	
			                  	<table border="0">
			                  		<tr>
			                  			<td align="right">
											<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('careerList')" style="font-size:12px;">코드추가</button>
										</td>
									</tr>
									<tr>
										<td>
								       		<div id="careerList" style="font-size:12px;" ></div>
								       	</td>
			                  		</tr>
			                  	</table>
			                  	
			               	</div>
	               		</div>
	               		
		               	<div class="tab-pane" id="tab-3">
		              
			                <div class="card-body table-responsive p-0" style="overflow:hidden;padding-top:20px;">
			                  	
			                  	<table border="0">
			                  		<tr>
			                  			<td align="right">
											<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('belongList')" style="font-size:12px;">코드추가</button>
										</td>
									</tr>
									<tr>
										<td>
								       		<div id="belongList" style="font-size:12px;"></div>
								       	</td>
			                  		</tr>
			                  	</table>
			                  	
			               	 </div>
			               	             
               	 		</div>
               	 
		               <div class="tab-pane" id="tab-4">
		              
			                <div class="card-body table-responsive p-0" style="overflow:hidden;padding-top:20px;">
			                  	
			                  	<table border="0">
			                  		<tr>
			                  			<td align="right">
											<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('perDonginList')" style="font-size:12px;">코드추가</button>
										</td>
									</tr>
									<tr>
										<td>
								       		<div id="perDonginList" style="font-size:12px;"></div>
								       	</td>
			                  		</tr>
			                  	</table>
			                  	
			               	 </div>           
               	 		</div>
               	 		<div class="tab-pane" id="tab-5">
		              
		              
			                <div class="card-body table-responsive p-0" style="overflow:hidden;padding-top:20px;">
			                  	
			                  	<table border="0">
			                  		<tr>
			                  			<td align="right">
											<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('artFairList')" style="font-size:12px;">코드추가</button>
										</td>
									</tr>
									<tr>
										<td>
								       		<div id="artFairList" style="font-size:12px;"></div>
								       	</td>
			                  		</tr>
			                  	</table>
			                  	
			               	 </div> 
		               	 
		               	 </div>  
		               	 
		               	 
		               	 <div class="tab-pane" id="tab-6">
		              
		                     <div class="card-body table-responsive p-0" style="overflow:hidden;padding-top:20px;">
			                  	
			                  	<table border="0">
			                  		<tr>
			                  			<td align="right">
											<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('residencyList')" style="font-size:12px;">코드추가</button>
										</td>
									</tr>
									<tr>
										<td>
								       		<div id="residencyList" style="font-size:12px;"></div>
								       	</td>
			                  		</tr>
			                  	</table>
			                  	
			               	 </div> 
		               	 
		               	 </div>  
		               	 
		               	 
		               	 <div class="tab-pane" id="tab-7">
		              
		                     <div class="card-body table-responsive p-0" style="overflow:hidden;padding-top:20px;">
			                  	
			                  	<table border="0">
			                  		<tr>
			                  			<td align="right">
											<button id="btnAddsubGridCodeList" type="button" onclick="AddClick('awardsList')" style="font-size:12px;">코드추가</button>
										</td>
									</tr>
									<tr>
										<td>
								       		<div id="awardsList" style="font-size:12px;"></div>
								       	</td>
			                  		</tr>
			                  	</table>
			                  	
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
   /* 작가학력 */
   function AuthorEduInfoList(mbrSq,artstSq){
   
	   var mbrSq = '<c:out value="${param.mbrSqParam}" />';
	   var artstSq = $('#artstSq').val();
	   let params = {
				mbrSq : mbrSq,
				artstSq : artstSq
			 }
	   
	   $("#eductnList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "1000px",
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
	    	    	 url: "/myPage/authorEduInfoViewData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 d.resolve(response.authorEdu.eduInfo);
	    	      });
	               return d.promise();
	           },
	           insertItem: function (item) {
	        	   console.log(item);
	        	   
	        	   var edulist = new Array();
	        	   var eduData = new Object();
	        	   
	        	   eduData.eductnSq = '';
				   eduData.mbrSq = mbrSq;
				   eduData.artstSq = artstSq;
				   eduData.eductnNm = item.eductnNm;
				   eduData.eductnMajor = item.eductnMajor;
				   
				   eduData = JSON.stringify(eduData);
				   edulist.push(JSON.parse(eduData));
	        	   
				   console.log(JSON.stringify(edulist));
	        	   
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorEduInfoSaveData",
	                   data: JSON.stringify(edulist),
	                   dataType: "json",
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	    AddClick('eductnList');
	      	    		$("#eductnList").jsGrid("loadData");
	      	      });
	           },
	           updateItem: function (item) {
	        	   
	        	   var edulist = new Array();
	        	   var eduData = new Object();
	        	   
	        	   eduData.eductnSq = item.eductnSq;
				   eduData.mbrSq = mbrSq;
				   eduData.artstSq = artstSq;
				   eduData.eductnNm = item.eductnNm;
				   eduData.eductnMajor = item.eductnMajor;
				   
				   eduData = JSON.stringify(eduData);
				   edulist.push(JSON.parse(eduData));
				   
	        	   console.log(item);
	        	   return $.ajax({
	        		   type: "POST",
	                   url: "/myPage/authorEduInfoSaveData",
	                   data: JSON.stringify(edulist),
	                   dataType: "json",
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	   AddClick('eductnList');
	      	    	   $("#eductnList").jsGrid("loadData");
	      	      });
	           },
	           deleteItem: function (item) {
	        	   console.log(item);
	        	    
	        	   let eduDeleteParam = {
						eductnSq : item.eductnSq	
					}
	        	   
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorEudInfoDeleteData",
	                   data: eduDeleteParam
	               }).done(function(response) {
	            	   $("#eductnList").jsGrid("loadData");
	      	      });
	           }
	       },
	       fields: [
	    	   { name: "artstSq"	,title:"작가순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mbrSq"		,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "eductnSq"	,title:"학력순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "eductnNm"	,title:"학력명", type: "text", width: 200,align:"center",width:100, validate: "required" },
	    	   { name: "eductnMajor",title:"학력전공", type: "text", width: 200,align:"center",width:100 },
	    	   { type: "control",deleteButton: true },
	    	   
	       ]
	   });
   
   }
   
   /* 작가경력 - 경력 */
   function AuthorCareerInfoList(mbrSq,artstSq){
	   
	   var mbrSq = '<c:out value="${param.mbrSqParam}" />';
	   var artstSq = $('#artstSq').val();
	   
	   let params = {
			mbrSq : mbrSq,
			artstSq : artstSq,
			careerTypCd : 'CR'
		}
	   
	   console.log(params);
	   
	   $("#careerList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "1000px",
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
	    	    	 url: "/myPage/authorCarrerInfoViewData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 d.resolve(response.authorCarrer.carrerInfo);
	    	      });
	               return d.promise();
	           },
	           insertItem: function (item) {
	        	   console.log("insertItem :"+item);
	        	   
	        	   var careerlist = new Array();
	        	   var careerData = new Object();
	        	   
	        	   careerData.careerSq = '';
	        	   careerData.mbrSq = mbrSq;
	        	   careerData.artstSq = artstSq;
	        	   careerData.careerNm = item.careerNm;
	        	   careerData.careerTypCd = 'CR';
				   
	        	   careerData = JSON.stringify(careerData);
	        	   careerlist.push(JSON.parse(careerData));
	        	   
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorCareerInfoSaveData",
	                   data: JSON.stringify(careerlist),
	                   dataType: "json",
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	    AddClick('careerList');
	      	    		$("#careerList").jsGrid("loadData");
	      	      });
	           },
	           updateItem: function (item) {
	        	   
	        	   //console.log("updateItem :"+item);
	        	   
	        	   var careerlist = new Array();
	        	   var careerData = new Object();
	        	   
	        	   careerData.careerSq = item.careerSq;
	        	   careerData.mbrSq = mbrSq;
	        	   careerData.artstSq = artstSq;
	        	   careerData.careerNm = item.careerNm;
	        	   careerData.careerTypCd = 'CR';
				   
	        	   careerData = JSON.stringify(careerData);
	        	   careerlist.push(JSON.parse(careerData));
				   
	        	   console.log(JSON.stringify(careerlist));
	        	   
	        	   return $.ajax({
	        		   type: "POST",
	                   url: "/myPage/authorCareerInfoSaveData",
	                   data: JSON.stringify(careerlist),
	                   dataType: "json",
	                   processData : true,
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	   AddClick('careerList');
	            	   $("#careerList").jsGrid("loadData");
	      	      });
	           },
	           deleteItem: function (item) {
 	        	   
	        	    
	        	   let careerDeleteParam = {
	        			careerSq : item.careerSq	
					}
	        	   console.log(careerDeleteParam);
	        	   return $.ajax({
	                   type: "POST",
	                   
	                   url: "/myPage/authorCarrerInfoDeleteData",
	                   data: careerDeleteParam
	               }).done(function(response) {
	            	   $("#careerList").jsGrid("loadData");
	      	      });
	           }
	       },
	       fields: [
	    	   { name: "artstSq"	,title:"작가순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mbrSq"		,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "careerSq"	,title:"경력순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "careerNm"	,title:"경력명", type: "text", width: 200,align:"center",width:100, validate: "required" },
	    	   { type: "control",deleteButton: true },
	    	   
	       ]
	   });
	   
       }
	   /* 작가경력 - 소속 */
	   function AuthorBelongInfoList(mbrSq,artstSq){
		   
		   var mbrSq = '<c:out value="${param.mbrSqParam}" />';
		   var artstSq = $('#artstSq').val();
		   
		   let params = {
				mbrSq : mbrSq,
				artstSq : artstSq,
				careerTypCd : 'BL'
			}
		   
		   console.log(params);
		   
		   $("#belongList").jsGrid({
			   locale:"ko",
		       height: "400px",
		       width: "1000px",
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
		    	    	 url: "/myPage/authorCarrerInfoViewData",
		    	         data: params,
		    	         dataType: "json"
		    	      }).done(function(response) {
		    	    	 d.resolve(response.authorCarrer.carrerInfo);
		    	      });
		               return d.promise();
		           },
		           insertItem: function (item) {
		        	   console.log("insertItem :"+item);
		        	   
		        	   var careerlist = new Array();
		        	   var careerData = new Object();
		        	   
		        	   careerData.careerSq = '';
		        	   careerData.mbrSq = mbrSq;
		        	   careerData.artstSq = artstSq;
		        	   careerData.careerNm = item.careerNm;
		        	   careerData.careerTypCd = 'BL';
					   
		        	   careerData = JSON.stringify(careerData);
		        	   careerlist.push(JSON.parse(careerData));
		        	   
		        	   return $.ajax({
		                   type: "POST",
		                   url: "/myPage/authorCareerInfoSaveData",
		                   data: JSON.stringify(careerlist),
		                   dataType: "json",
		                   contentType : "application/json; charset=UTF-8"
		               }).done(function(response) {
		            	    AddClick('belongList');
		      	    		$("#belongList").jsGrid("loadData");
		      	      });
		           },
		           updateItem: function (item) {
		        	   
		        	   //console.log("updateItem :"+item);
		        	   
		        	   var careerlist = new Array();
		        	   var careerData = new Object();
		        	   
		        	   careerData.careerSq = item.careerSq;
		        	   careerData.mbrSq = mbrSq;
		        	   careerData.artstSq = artstSq;
		        	   careerData.careerNm = item.careerNm;
		        	   careerData.careerTypCd = 'BL';
					   
		        	   careerData = JSON.stringify(careerData);
		        	   careerlist.push(JSON.parse(careerData));
					   
		        	   console.log(JSON.stringify(careerlist));
		        	   
		        	   return $.ajax({
		        		   type: "POST",
		                   url: "/myPage/authorCareerInfoSaveData",
		                   data: JSON.stringify(careerlist),
		                   dataType: "json",
		                   processData : true,
		                   contentType : "application/json; charset=UTF-8"
		               }).done(function(response) {
		            	   AddClick('belongList');
		            	   $("#belongList").jsGrid("loadData");
		      	      });
		           },
		           deleteItem: function (item) {
	 	        	   
		        	    
		        	   let careerDeleteParam = {
		        			careerSq : item.careerSq	
						}
		        	   console.log(careerDeleteParam);
		        	   return $.ajax({
		                   type: "POST",
		                   
		                   url: "/myPage/authorCarrerInfoDeleteData",
		                   data: careerDeleteParam
		               }).done(function(response) {
		            	   $("#belongList").jsGrid("loadData");
		      	      });
		           }
		       },
		       fields: [
		    	   { name: "artstSq"	,title:"작가순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
		    	   { name: "mbrSq"		,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
		    	   { name: "careerSq"	,title:"경력순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
		    	   { name: "careerNm"	,title:"소속명", type: "text", width: 200,align:"center",width:100, validate: "required" },
		    	   { type: "control",deleteButton: true },
		    	   
		       ]
		   });
		   
   		}
	   
	   
function AuthorSlxbtInfoList(mbrSq,artstSq){
		   
		   var mbrSq = '<c:out value="${param.mbrSqParam}" />';
		   var artstSq = $('#artstSq').val();
		   
		   let params = {
				mbrSq : mbrSq,
				artstSq : artstSq,
				exhbtnTypCd : 'SLXBT'
			}
		   
		   console.log(params);
		   
		   $("#perDonginList").jsGrid({
			   locale:"ko",
		       height: "400px",
		       width: "1000px",
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
		    	    	 url: "/myPage/authorExhbtnInfoViewData",
		    	         data: params,
		    	         dataType: "json"
		    	      }).done(function(response) {
		    	    	 d.resolve(response.author.exhbtnInfo);
		    	      });
		               return d.promise();
		           },
		           insertItem: function (item) {
		        	   console.log("insertItem :"+item);
		        	   
		        	   var exhbtnlist = new Array();
		        	   var exhbtnData = new Object();
		        	   
		        	   exhbtnData.exhbtnSq = '';
		        	   exhbtnData.mbrSq = mbrSq;
		        	   exhbtnData.artstSq = artstSq;
		        	   exhbtnData.exhbtnNm = item.exhbtnNm;
		        	   exhbtnData.exhbtnTypCd = 'SLXBT';
					   
		        	   exhbtnData = JSON.stringify(exhbtnData);
		        	   exhbtnlist.push(JSON.parse(exhbtnData));
		        	   
		        	   return $.ajax({
		                   type: "POST",
		                   url: "/myPage/authorExhbtnInfoSaveData",
		                   data: JSON.stringify(exhbtnlist),
		                   dataType: "json",
		                   contentType : "application/json; charset=UTF-8"
		               }).done(function(response) {
		            	    AddClick('perDonginList');
		      	    		$("#perDonginList").jsGrid("loadData");
		      	      });
		           },
		           updateItem: function (item) {
		      	   
		        	   var exhbtnlist = new Array();
		        	   var exhbtnData = new Object();
		        	   
		        	   exhbtnData.exhbtnSq = item.exhbtnSq;
		        	   exhbtnData.mbrSq = mbrSq;
		        	   exhbtnData.artstSq = artstSq;
		        	   exhbtnData.exhbtnNm = item.exhbtnNm;
		        	   exhbtnData.exhbtnTypCd = 'SLXBT';
					   
		        	   exhbtnData = JSON.stringify(exhbtnData);
		        	   exhbtnlist.push(JSON.parse(exhbtnData));
					   
		        	   console.log(JSON.stringify(exhbtnlist));
		        	   
		        	   return $.ajax({
		        		   type: "POST",
		                   url: "/myPage/authorExhbtnInfoSaveData",
		                   data: JSON.stringify(exhbtnlist),
		                   dataType: "json",
		                   processData : true,
		                   contentType : "application/json; charset=UTF-8"
		               }).done(function(response) {
		            	   AddClick('perDonginList');
		            	   $("#perDonginList").jsGrid("loadData");
		      	      });
		           },
		           deleteItem: function (item) {
	 	        	    
		        	   let perDonginDeleteParam = {
		        			exhbtnSq : item.exhbtnSq	
						}
		        	    console.log(perDonginDeleteParam);
		        	   return $.ajax({
		                   type: "POST",
		                   url: "/myPage/authorExhbtnInfoDeleteData",
		                   data: perDonginDeleteParam
		               }).done(function(response) {
		            	   $("#perDonginList").jsGrid("loadData");
		      	      });
		           }
		       },
		       fields: [
		    	   { name: "artstSq"	,title:"작가순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
		    	   { name: "mbrSq"		,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
		    	   { name: "exhbtnSq"	,title:"전시순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
		    	   { name: "exhbtnNm"	,title:"전시명", type: "text", width: 200,align:"center",width:100, validate: "required" },
		    	   { type: "control",deleteButton: true },
		    	   
		       ]
		   });
		   
   		}
   		
function AuthorArtFairInfoList(mbrSq,artstSq){
	   
	   var mbrSq = '<c:out value="${param.mbrSqParam}" />';
	   var artstSq = $('#artstSq').val();
	   
	   let params = {
			mbrSq : mbrSq,
			artstSq : artstSq,
			exhbtnTypCd : 'ARTFR'
		}
	   
	   console.log(params);
	   
	   $("#artFairList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "1000px",
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
	    	    	 url: "/myPage/authorExhbtnInfoViewData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 d.resolve(response.author.exhbtnInfo);
	    	      });
	               return d.promise();
	           },
	           insertItem: function (item) {
	        	   console.log("insertItem :"+item);
	        	   
	        	   var exhbtnlist = new Array();
	        	   var exhbtnData = new Object();
	        	   
	        	   exhbtnData.exhbtnSq = '';
	        	   exhbtnData.mbrSq = mbrSq;
	        	   exhbtnData.artstSq = artstSq;
	        	   exhbtnData.exhbtnNm = item.exhbtnNm;
	        	   exhbtnData.exhbtnTypCd = 'ARTFR';
				   
	        	   exhbtnData = JSON.stringify(exhbtnData);
	        	   exhbtnlist.push(JSON.parse(exhbtnData));
	        	   
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorExhbtnInfoSaveData",
	                   data: JSON.stringify(exhbtnlist),
	                   dataType: "json",
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	    AddClick('artFairList');
	      	    		$("#artFairList").jsGrid("loadData");
	      	      });
	           },
	           updateItem: function (item) {
	      	   
	        	   var exhbtnlist = new Array();
	        	   var exhbtnData = new Object();
	        	   
	        	   exhbtnData.exhbtnSq = item.exhbtnSq;
	        	   exhbtnData.mbrSq = mbrSq;
	        	   exhbtnData.artstSq = artstSq;
	        	   exhbtnData.exhbtnNm = item.exhbtnNm;
	        	   exhbtnData.exhbtnTypCd = 'ARTFR';
				   
	        	   exhbtnData = JSON.stringify(exhbtnData);
	        	   exhbtnlist.push(JSON.parse(exhbtnData));
				   
	        	   console.log(JSON.stringify(exhbtnlist));
	        	   
	        	   return $.ajax({
	        		   type: "POST",
	                   url: "/myPage/authorExhbtnInfoSaveData",
	                   data: JSON.stringify(exhbtnlist),
	                   dataType: "json",
	                   processData : true,
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	   AddClick('artFairList');
	            	   $("#artFairList").jsGrid("loadData");
	      	      });
	           },
	           deleteItem: function (item) {
	        	    
	        	   let perDonginDeleteParam = {
	        			exhbtnSq : item.exhbtnSq	
					}
	        	    console.log(perDonginDeleteParam);
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorExhbtnInfoDeleteData",
	                   data: perDonginDeleteParam
	               }).done(function(response) {
	            	   $("#artFairList").jsGrid("loadData");
	      	      });
	           }
	       },
	       fields: [
	    	   { name: "artstSq"	,title:"작가순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mbrSq"		,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "exhbtnSq"	,title:"전시순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "exhbtnNm"	,title:"전시명", type: "text", width: 200,align:"center",width:100, validate: "required" },
	    	   { type: "control",deleteButton: true },
	    	   
	       ]
	   });
	   
	}
	
function AuthorResidencyInfoList(mbrSq,artstSq){
	   
	   var mbrSq = '<c:out value="${param.mbrSqParam}" />';
	   var artstSq = $('#artstSq').val();
	   
	   let params = {
			mbrSq : mbrSq,
			artstSq : artstSq,
			exhbtnTypCd : 'RSDNC'
		}
	   
	   console.log(params);
	   
	   $("#residencyList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "1000px",
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
	    	    	 url: "/myPage/authorExhbtnInfoViewData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 d.resolve(response.author.exhbtnInfo);
	    	      });
	               return d.promise();
	           },
	           insertItem: function (item) {
	        	   console.log("insertItem :"+item);
	        	   
	        	   var exhbtnlist = new Array();
	        	   var exhbtnData = new Object();
	        	   
	        	   exhbtnData.exhbtnSq = '';
	        	   exhbtnData.mbrSq = mbrSq;
	        	   exhbtnData.artstSq = artstSq;
	        	   exhbtnData.exhbtnNm = item.exhbtnNm;
	        	   exhbtnData.exhbtnTypCd = 'RSDNC';
				   
	        	   exhbtnData = JSON.stringify(exhbtnData);
	        	   exhbtnlist.push(JSON.parse(exhbtnData));
	        	   
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorExhbtnInfoSaveData",
	                   data: JSON.stringify(exhbtnlist),
	                   dataType: "json",
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	    AddClick('residencyList');
	      	    		$("#residencyList").jsGrid("loadData");
	      	      });
	           },
	           updateItem: function (item) {
	      	   
	        	   var exhbtnlist = new Array();
	        	   var exhbtnData = new Object();
	        	   
	        	   exhbtnData.exhbtnSq = item.exhbtnSq;
	        	   exhbtnData.mbrSq = mbrSq;
	        	   exhbtnData.artstSq = artstSq;
	        	   exhbtnData.exhbtnNm = item.exhbtnNm;
	        	   exhbtnData.exhbtnTypCd = 'RSDNC';
				   
	        	   exhbtnData = JSON.stringify(exhbtnData);
	        	   exhbtnlist.push(JSON.parse(exhbtnData));
				   
	        	   console.log(JSON.stringify(exhbtnlist));
	        	   
	        	   return $.ajax({
	        		   type: "POST",
	                   url: "/myPage/authorExhbtnInfoSaveData",
	                   data: JSON.stringify(exhbtnlist),
	                   dataType: "json",
	                   processData : true,
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	   AddClick('residencyList');
	            	   $("#residencyList").jsGrid("loadData");
	      	      });
	           },
	           deleteItem: function (item) {
	        	    
	        	   let perDonginDeleteParam = {
	        			exhbtnSq : item.exhbtnSq	
					}
	        	    console.log(perDonginDeleteParam);
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorExhbtnInfoDeleteData",
	                   data: perDonginDeleteParam
	               }).done(function(response) {
	            	   $("#residencyList").jsGrid("loadData");
	      	      });
	           }
	       },
	       fields: [
	    	   { name: "artstSq"	,title:"작가순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mbrSq"		,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "exhbtnSq"	,title:"전시순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "exhbtnNm"	,title:"전시명", type: "text", width: 200,align:"center",width:100, validate: "required" },
	    	   { type: "control",deleteButton: true },
	    	   
	       ]
	   });
	   
	}
	
function AuthorAwardsInfoList(mbrSq,artstSq){
	   
	   var mbrSq = '<c:out value="${param.mbrSqParam}" />';
	   var artstSq = $('#artstSq').val();
	   
	   let params = {
			mbrSq : mbrSq,
			artstSq : artstSq,
			exhbtnTypCd : 'AWRDS'
		}
	   
	   console.log(params);
	   
	   $("#awardsList").jsGrid({
		   locale:"ko",
	       height: "400px",
	       width: "1000px",
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
	    	    	 url: "/myPage/authorExhbtnInfoViewData",
	    	         data: params,
	    	         dataType: "json"
	    	      }).done(function(response) {
	    	    	 d.resolve(response.author.exhbtnInfo);
	    	      });
	               return d.promise();
	           },
	           insertItem: function (item) {
	        	   console.log("insertItem :"+item);
	        	   
	        	   var exhbtnlist = new Array();
	        	   var exhbtnData = new Object();
	        	   
	        	   exhbtnData.exhbtnSq = '';
	        	   exhbtnData.mbrSq = mbrSq;
	        	   exhbtnData.artstSq = artstSq;
	        	   exhbtnData.exhbtnNm = item.exhbtnNm;
	        	   exhbtnData.exhbtnTypCd = 'AWRDS';
				   
	        	   exhbtnData = JSON.stringify(exhbtnData);
	        	   exhbtnlist.push(JSON.parse(exhbtnData));
	        	   
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorExhbtnInfoSaveData",
	                   data: JSON.stringify(exhbtnlist),
	                   dataType: "json",
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	    AddClick('awardsList');
	      	    		$("#awardsList").jsGrid("loadData");
	      	      });
	           },
	           updateItem: function (item) {
	      	   
	        	   var exhbtnlist = new Array();
	        	   var exhbtnData = new Object();
	        	   
	        	   exhbtnData.exhbtnSq = item.exhbtnSq;
	        	   exhbtnData.mbrSq = mbrSq;
	        	   exhbtnData.artstSq = artstSq;
	        	   exhbtnData.exhbtnNm = item.exhbtnNm;
	        	   exhbtnData.exhbtnTypCd = 'AWRDS';
				   
	        	   exhbtnData = JSON.stringify(exhbtnData);
	        	   exhbtnlist.push(JSON.parse(exhbtnData));
				   
	        	   console.log(JSON.stringify(exhbtnlist));
	        	   
	        	   return $.ajax({
	        		   type: "POST",
	                   url: "/myPage/authorExhbtnInfoSaveData",
	                   data: JSON.stringify(exhbtnlist),
	                   dataType: "json",
	                   processData : true,
	                   contentType : "application/json; charset=UTF-8"
	               }).done(function(response) {
	            	   AddClick('awardsList');
	            	   $("#awardsList").jsGrid("loadData");
	      	      });
	           },
	           deleteItem: function (item) {
	        	    
	        	   let perDonginDeleteParam = {
	        			exhbtnSq : item.exhbtnSq	
					}
	        	    console.log(perDonginDeleteParam);
	        	   return $.ajax({
	                   type: "POST",
	                   url: "/myPage/authorExhbtnInfoDeleteData",
	                   data: perDonginDeleteParam
	               }).done(function(response) {
	            	   $("#awardsList").jsGrid("loadData");
	      	      });
	           }
	       },
	       fields: [
	    	   { name: "artstSq"	,title:"작가순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "mbrSq"		,title:"회원순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "exhbtnSq"	,title:"전시순번", type: "text", width: 150,align:"center" ,width:100, visible: false},
	    	   { name: "exhbtnNm"	,title:"수상명", type: "text", width: 200,align:"center",width:100, validate: "required" },
	    	   { type: "control",deleteButton: true },
	    	   
	       ]
	   });
	   
	}
   </script>
   
   <script>
        var dataContent = {};
   
		$(document).ready(function(){
			
			var mbrSq = '<c:out value="${param.mbrSqParam}" />';
			//회원기본정본
			memberContentData(mbrSq);
			//작가회원정보
			artistMemberInfoData(mbrSq);
		});
		
		//회원 정보 호출
		function memberContentData(mbrSq) {
			
			console.log("memberContentData : "+ mbrSq);
			
			$.ajax({
		           type: "post",
		           url: "memberContentData",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(data) {
		        	   
		        	    
		        	 dataContent = data.memberContentData.memberContent[0];
		        	 
		        	 var mbrNm = dataContent.mbrNm						//이름
		        	 var mbrId = dataContent.mbrId						//아이디
		        	 var mbrCpNum = dataContent.mbrCpNum				//닉네임
		        	 
		        	 $("#mbrNm").val(mbrNm);
		        	 $("#mbrId").val(mbrId);
		        	 $("#mbrCpNum").val(mbrCpNum);
		        	
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
		}
		
		//회원목록 이동
		function goList(){
			location.href = '/admin/member/memberList';
		}
		
		//작가정보 등록
		function artistMemberInput()
		{
			
			var artstActvtyNm = $("#artstActvtyNm").val();
			var artstEnglsNm = $("#artstEnglsNm").val();
			var artstSelfIntro = $("#artstSelfIntro").val();
			
			
			//활동명
        	if(isEmpty(artstActvtyNm)) {
        		bootbox.alert({
					 message: "활동명을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#artstActvtyNm").focus();
				     } });
				 return;
        	}
        	//영문명
        	if(isEmpty(artstEnglsNm)) {
        		bootbox.alert({
					 message: "영문명을 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#artstEnglsNm").focus();
				     } });
				 return;
        	}		
        	//작가소개
        	if(isEmpty(artstSelfIntro)) {
        		bootbox.alert({
					 message: "작가소개를 입력해 주세요.",
					 locale: 'kr',
					 callback: function() {
					 		$("#artstSelfIntro").focus();
				     } });
				 return;
        	}
        	
			var queryString = $("form[name=formInfo]").serialize();
			
			console.log("artistMemberInput :"+queryString);
			
			$.ajax({
		           type: "post",
		           url: "artistMemberInputData",
		           data: queryString,
		           success: function(data) {
		        	   console.log(data);
		        	   bootbox.alert({
							 message: "작가정보 등록완료.",
							 locale: 'kr',
							 callback: function() {
							 		
						     } });
				   },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
		           }
			});
		}
		
		//작가정보
		function artistMemberInfoData(mbrSq)
		{
			$.ajax({
		           type: "post",
		           url: "artistMemberInfoData",
		           data: {
		        	   mbrSq : mbrSq
		            },
		           success: function(data) {
		        	   
		        	   dataInfo = data.artistMemberInfoData.artistMemberInfo[0];
			        		        	  
			        	if(dataInfo) {
			        		var artstSq 				= dataInfo.artstSq;
				        	var artstActvtyNm			= dataInfo.artstActvtyNm;
				        	var artstEnglsNm			= dataInfo.artstEnglsNm;
				        	var artstActvtyNatnCd		= dataInfo.artstActvtyNatnCd;
				        	var artstActvtyCityCd		= dataInfo.artstActvtyCityCd;
				        	var artstActvtyPartCd		= dataInfo.artstActvtyPartCd;
				        	
				        	var artstActvtyCd			= dataInfo.artstActvtyCd;
				        	var artstSelfIntro			= dataInfo.artstSelfIntro;
				        	var artstProfileImgUrl		= dataInfo.artstProfileImgUrl;
				        	var artstHmpgUrl			= dataInfo.artstHmpgUrl;
				        	var artstPromtnVideoUrl		= dataInfo.artstPromtnVideoUrl;
				        	var artstFacebookUrl		= dataInfo.artstFacebookUrl;
				        	var artstInstagramUrl		= dataInfo.artstInstagramUrl;
				        	
				        	/* 작가순번 */
					        $("#artstSq").val(artstSq);
				        	/* 작가횔동명 */
				        	$("#artstActvtyNm").val(artstActvtyNm);
				        	/* 작가영문명 */
				        	$("#artstEnglsNm").val(artstEnglsNm);
				        	/* 활동지역 : 국가 */
					      	$('select[name=artstActvtyNatnCd]').val(artstActvtyNatnCd);
					    	/* 활동지역 : 도시 */
					    	$('select[name=artstActvtyCityCd]').val(artstActvtyCityCd);
					    	/* 활동분야 */
					    	/* Form checked Clear */
					    	$(".artstActvtyPartCd").prop('checked' , false);
					    	$(".artstActvtyPartCd:input[value='"+artstActvtyPartCd+"']").prop("checked", true);
					    	/* 자기소개 */				        	
				        	$("#artstSelfIntro").val(artstSelfIntro);
					    	/* 프로필 이미지 */
				        	$("#artstProfileImgUrl").val(artstProfileImgUrl);
				        	$("#dropZone").prop("src",artstProfileImgUrl)
				        	
				        	$("#artstPromtnVideoUrl").val(artstPromtnVideoUrl);
				        	
				        	$("#artstHmpgUrl").val(artstHmpgUrl);
				        	$("#artstFacebookUrl").val(artstFacebookUrl);
				        	$("#artstInstagramUrl").val(artstInstagramUrl);
				        	
				        	
				        	//작가학력정보
				        	AuthorEduInfoList(mbrSq,artstSq)
				        	
				        	//작가경력정보 - 경력
				        	AuthorCareerInfoList(mbrSq,artstSq)
				        	
				        	//작가경력정보 - 소속
				        	AuthorBelongInfoList(mbrSq,artstSq)
				        	
				        	//작가 전시 - 개인전/단체전
				        	AuthorSlxbtInfoList(mbrSq,artstSq)
				        	
				        	//작가 전시 - 아트페어
				        	AuthorArtFairInfoList(mbrSq,artstSq)
				        	
				        	//작가 전시 - 레지던시
				        	AuthorResidencyInfoList(mbrSq,artstSq)
				        	
				        	//작가 전시 - 수상
				        	AuthorAwardsInfoList(mbrSq,artstSq)
			        	}
		        	
		           },
		           error: function(error) {
		        	   var errorJson = JSON.stringify(error);
		               console.log(errorJson);
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
		
	</script>
	
	<script type="text/javascript">
		
		$(document).ready(function() {
			$("#file").bind('change', function() {
				uploadResource(this.files);
			});
		
		$(function() {
			// 파일 드롭 다운
			fileDropDown();
		});
		
		// 파일 드롭 다운
		function fileDropDown() {
			var dropZone = $("#dropZone");
			//Drag기능 
			dropZone.on('dragenter', function(e) {
				e.stopPropagation();
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#E3F2FC');
			});
			dropZone.on('dragleave', function(e) {
				e.stopPropagation();
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#FFFFFF');
			});
			dropZone.on('dragover', function(e) {
				e.stopPropagation();
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#E3F2FC');
			});
			dropZone.on('drop', function(e) {
				e.preventDefault();
				// 드롭다운 영역 css
				dropZone.css('background-color', '#FFFFFF');
		
				var fileObject = e.originalEvent.dataTransfer.files;
			
				if (fileObject != null) {
					if (fileObject.length < 1) {
						/* alert("폴더 업로드 불가"); */
						console.log("폴더 업로드 불가");
						return;
					} else {
						uploadResource(fileObject);
					}
				} else {
					alert("ERROR");
				}
			});
		}
		
		function uploadResource(fileObject) {
			
			var file = null;
			
			const formData = new FormData();
			
			if (fileObject != null) {
				// 파일 Drag 이용하여 등록시
				file = fileObject[0];
				formData.append("file", file);
				console.log(file);
			} else {
				file = document.getElementById("file");
				formData.append("file", file.files[0]);
			}
			

		       fetch("/file/upload", {
		           method : "POST"
		           , body : formData
		       })
		       .then(result => result.json())
		       .then(data => {
		           document.getElementById("dropZone").setAttribute("src", data.fileUrl);
		           $('#artstProfileImgUrl').val(data.fileUrl);
		           //document.getElementById("remove").setAttribute("fileNm", data.fileNm)
		       })
		       .catch(error => console.log(`error => ${error}`));
		   }
		
		
		$("#dropZone").click(function(){
		      $('#file').click();
		});
		
		});	
		
		function imgInput() {
			$('#file').click();
		}
	</script>
 
 
</body>
</html>
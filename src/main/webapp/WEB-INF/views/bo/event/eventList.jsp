<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/views/boInclude/include_top.jspf"%>

 <style type="text/css">
	
 .infoBox {
  box-shadow: 0 0 1px rgba(0, 0, 0, 0.125), 0 1px 3px rgba(0, 0, 0, 0.2);
  border-radius: 0.25rem;
  background: #ffffff;
  display: -ms-flexbox;
  display: flex;
  margin-bottom: 1rem;
  padding: .5rem;
  position: relative;
  width: 100%;
  min-height: 30px;
 }
 /* Chrome, Safari, Edge, Opera */
 input::-webkit-outer-spin-button,
 input::-webkit-inner-spin-button {
   -webkit-appearance: none;
   margin: 0;
 }

 /* Firefox */
 input[type=number] {
   -moz-appearance: textfield;
 }
 
 .table td {
 	vertical-align: middle;
 }
 </style>

<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/boInclude/include_left.jspf"%>
		
		<!-- 쿠폰 관리 -->
		 <div class="content-wrapper">
		 
		 	<!-- 쿠폰 관리 header -->
		 	<div class="content-header">
		 		<div class="container-fluid">
		 			<div class="row">
		 				<div class="col-sm-12">
		 					<h4>쿠폰 관리</h4>
		 				</div>
		 			</div>
		 		</div>
		 	</div>
		 	
		 	<!-- 쿠폰 관리 body -->
	    	<section class="content">
	    	
    			<!-- 쿠폰 발급 -->
	    		<div class="container-fluid">
	    			<div class="card card-outline">
	    				
	    				<!-- 쿠폰 발급 header -->
	    				<div class="card-header">
	    					<ul class="nav nav-pills">
				           		<li class="nav-item">
				           			<a class="sTitle" href="#" data-toggle="tab">
				           				<b>쿠폰 발급</b>
				           			</a>
				           		</li>
				           	</ul>
	    				</div>
	    				
	    				<!-- 쿠폰 발급 body -->
	    				<div class="card-body">
	    					<table class="table table-bordered">	                
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">쿠폰 이름</td>
									<td class="col-sm-2 dataValue">
										<input type="text" name="cuponNm" class="form-control">
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">쿠폰 설명</td>
									<td class="col-sm-2 dataValue">
										<input type="text" name="cuponCntnt" class="form-control">
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">혜택 구분</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-3">
												<select class="form-control bTitle" id="cuponTypCd">
													<option value="" selected>쿠폰 종류</option>
													<option value="">구매 수수료</option>
													<option value="">판매 수수료</option>
													<option value="">운송료</option>
						                        </select>
											</div>
											<div class="col-sm-3">
												<select class="form-control bTitle" name="discTypCd" onchange="showNoneTab(this, 'discTypCdList');">
													<option value="">할인 금액</option>
													<option value="">전액 할인</option>
													<option value="DR">할인율 적용</option>
													<option value="AD">금액 할인</option>
						                        </select>
											</div>
											<div class="col-sm-6">
												<div id="discTypCdList">
							                        <div id="DR" style="display: none;">
						                        		<div class="row">
							                        		<div class="col-sm-4">
									                        	<input type="text" name="cuponDr" class="form-control">
							                        		</div>
							                        		<div class="col-sm-1">
									                        	<span>%</span>
							                        		</div>
							                        		<div class="col-sm-2">
									                        	<span>절사단위</span>
							                        		</div>
							                        		<div class="col-sm-5">
									                        	<select class="form-control bTitle">
																	<option value="">절사 안함</option>
																	<option value="">1</option>
																	<option value="">10</option>
																	<option value="">100</option>
																	<option value="">1000</option>
										                        </select>
							                        		</div>
						                        		</div>
							                        </div>
							                        <div id="AD" style="display: none;">
						                        		<div class="row">
							                        		<div class="col-sm-5">
									                        	<input type="text" name="cuponDiscAmt" class="form-control">
							                        		</div>
							                        		<div class="col-sm-1">
									                        	<span>원</span>
							                        		</div>
						                        		</div>
							                        </div>
						                        </div>
											</div>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">발급 구분</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t1" class="form-check-input">
													<label for="t1" class="form-check-label">대상자 지정발급</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t2" class="form-check-input">
													<label for="t2" class="form-check-label">조건부 자동발급</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t3" class="form-check-input">
													<label for="t3" class="form-check-label">고객 다운로드 발급</label>
												</div>
											</div>
										</div>
									</td>
								</tr>
			                </table>
	    				</div>
	    			</div>
	    		</div>
	    		
	    		<!-- 사용 정보 -->
	    		<div class="container-fluid">
	    			<div class="card card-outline">
	    				
	    				<!-- 사용 정보 header -->
	    				<div class="card-header">
	    					<ul class="nav nav-pills">
				           		<li class="nav-item">
				           			<a class="sTitle" href="#" data-toggle="tab">
				           				<b>사용 정보</b>
				           			</a>
				           		</li>
				           	</ul>
	    				</div>
	    				
	    				<!-- 사용 정보 body -->
	    				<div class="card-body">
	    					<table class="table table-bordered">	                
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">사용 기간</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-3">
												<select class="form-control bTitle" id="">
													<option value="">기간 설정</option>
													<option value="">쿠폰 발급일 기준</option>
													<option value="">쿠폰 발급 당월 말일까지</option>
						                        </select>
											</div>
											<div class="col-sm-2">
						                        <input type="date" class="form-control">
											</div>
											<div class="col-sm-1">
												<select class="form-control bTitle" id="">
							                        <c:forEach var="num" begin="0" end="23">
							                        	<c:choose>
							                        		<c:when test="${num < 10 }">
							                        			<option value="0${num }">0${num }시</option>
							                        		</c:when>
							                        		<c:otherwise>
							                        			<option value="${num }">${num }시</option>
							                        		</c:otherwise>
							                        	</c:choose>
							                        </c:forEach>
						                        </select>
											</div>
											<div class="col-sm-1">
												<select class="form-control bTitle" id="">
							                        <c:forEach var="num" begin="0" end="59">
							                        	<c:choose>
							                        		<c:when test="${num < 10 }">
							                        			<option value="0${num }">0${num }분</option>
							                        		</c:when>
							                        		<c:otherwise>
							                        			<option value="${num }">${num }분</option>
							                        		</c:otherwise>
							                        	</c:choose>
							                        </c:forEach>
						                        </select>
											</div>
											<div class="col-sm-1">
						                        <span>~</span>
											</div>
					                        <div class="col-sm-2">
						                        <input type="date" class="form-control">
											</div>
											<div class="col-sm-1">
												<select class="form-control bTitle" id="">
							                        <c:forEach var="num" begin="0" end="23">
							                        	<c:choose>
							                        		<c:when test="${num < 10 }">
							                        			<option value="0${num }">0${num }시</option>
							                        		</c:when>
							                        		<c:otherwise>
							                        			<option value="${num }">${num }시</option>
							                        		</c:otherwise>
							                        	</c:choose>
							                        </c:forEach>
						                        </select>
											</div>
											<div class="col-sm-1">
												<select class="form-control bTitle" id="">
							                        <c:forEach var="num" begin="0" end="59">
							                        	<c:choose>
							                        		<c:when test="${num < 10 }">
							                        			<option value="0${num }">0${num }분</option>
							                        		</c:when>
							                        		<c:otherwise>
							                        			<option value="${num }">${num }분</option>
							                        		</c:otherwise>
							                        	</c:choose>
							                        </c:forEach>
						                        </select>
											</div>
				                        </div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">동일 쿠폰 사용 설정</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-1">주문서당</div>
											<div class="col-sm-2">
												<input type="text" name="" class="form-control">
											</div>
											<div class="col-sm-2">개 까지 사용가능</div>
										</div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">사용가능 결제수단</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t4" class="form-check-input">
													<label for="t4" class="form-check-label">제한 없음</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t5" class="form-check-input">
													<label for="t5" class="form-check-label">결제수단 선택</label>
												</div>
											</div>
										</div>
									</td>
								</tr>
			                </table>
	    				</div>
	    			</div>
	    		</div>
	    		
	    		<!-- 쿠폰 이미지 컬러 설정 -->
	    		<div class="container-fluid">
	    			<div class="card card-outline">
	    				
	    				<!-- 쿠폰 이미지 컬러 설정 header -->
	    				<div class="card-header">
	    					<ul class="nav nav-pills">
				           		<li class="nav-item">
				           			<a class="sTitle" href="#" data-toggle="tab">
				           				<b>쿠폰 이미지 컬러 설정</b>
				           			</a>
				           		</li>
				           	</ul>
	    				</div>
	    				
	    				<!-- 쿠폰 이미지 컬러 설정 body -->
	    				<div class="card-body">
	    					<table class="table table-bordered">	                
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">쿠폰 이미지 컬러</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t5" class="form-check-input">
													<label for="t5" class="form-check-label">레드</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t6" class="form-check-input">
													<label for="t6" class="form-check-label">그린</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" id="t6" class="form-check-input">
													<label for="t6" class="form-check-label">블루</label>
												</div>
											</div>
				                        </div>
									</td>
								</tr>
			                </table>
	    				</div>
	    			</div>
	    		</div>
	    		
	    		<!-- 부가 서비스 -->
	    		<div class="container-fluid">
	    			<div class="card card-outline">
	    				
	    				<!-- 부가 서비스 header -->
	    				<div class="card-header">
	    					<ul class="nav nav-pills">
				           		<li class="nav-item">
				           			<a class="sTitle" href="#" data-toggle="tab">
				           				<b>부가 서비스</b>
				           			</a>
				           		</li>
				           	</ul>
	    				</div>
	    				
	    				<!-- 부가 서비스 body -->
	    				<div class="card-body">
	    					<table class="table table-bordered">	                
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">쿠폰 발급 SMS 발송</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" class="form-check-input">
													<label class="form-check-label">발송함</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" class="form-check-input">
													<label class="form-check-label">발송안함</label>
												</div>
											</div>
				                        </div>
									</td>
								</tr>
								<tr class="col-form-label sTitle LabelStyle">
									<td class="col-sm-1" align="center">쿠폰 발급 이메일 발송</td>
									<td class="col-sm-2 dataValue">
										<div class="row">
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" class="form-check-input">
													<label class="form-check-label">발송함</label>
												</div>
											</div>
											<div class="col-sm-2">
												<div class="form-check">
													<input type="radio" class="form-check-input">
													<label class="form-check-label">발송안함</label>
												</div>
											</div>
				                        </div>
									</td>
								</tr>
			                </table>
	    				</div>
	    			</div>
	    		</div>
	    		
				<div class="form-group row">
					<div class="col-sm-12" style="text-align:right;right:15px;">
						<button type="button" class="btn btn-info sTitle">저장</button>
					</div>
				</div>
	    	</section>
	  		<section class="content">
	  			<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
	             	<ul class="nav nav-pills">
		           		<li class="nav-item">
		           			<a class="sTitle" href="#" data-toggle="tab">
		           				<b>쿠폰 발급 조회</b>
		           			</a>
		           		</li>
		           	</ul>
				</div>
	    		<div class="card-body" style="background-color:#ffffff;">
		    		<div class="card-header p-2" style="border: 1px solid rgba(0,0,0,.125);">
		             	<ul class="nav nav-pills">
			           		<li class="nav-item">
			           			<a class="sTitle" href="#" data-toggle="tab">
			           				<b>발급 쿠폰 검색</b>
			           			</a>
			           		</li>
			           	</ul>
					</div>
					<div class="card">
		                <table class="table table-bordered">	                
							<tr class="col-form-label sTitle LabelStyle">
								<td class="col-sm-1" align="center">
									쿠폰 이름
								</td>
								<td class="col-sm-2 dataValue">
									<input type="text" name="cuponNm" class="form-control">
								</td>
								<td class="col-sm-1" align="center">
									혜택 구분
								</td>
								<td class="col-sm-2 dataValue">
									<select class="form-control bTitle" id="">
										<option value="">전체</option>
										<option value="">할인금액</option>
										<option value="">할인율</option>
										<option value="">기본배송비 할인</option>
			                        </select>
								</td>
							</tr>
							<tr class="col-form-label sTitle LabelStyle">
								<td class="col-sm-1" align="center">
									발급 구분
								</td>
								<td class="col-sm-2 dataValue">
									<select class="form-control bTitle" id="">
										<option value="">전체</option>
										<option value="">대상자 지정발급</option>
										<option value="">조건부 자동발급</option>
										<option value="">고객 다운로드 발급</option>
			                        </select>
								</td>
								<td class="col-sm-1" align="center">
									생성 일자
								</td>
								<td class="col-sm-2 dataValue">
									<select class="form-control bTitle" onchange="showNoneTab(this, 'test');">
										<option value="">전체</option>
										<option value="createDate">생성 일자</option>
										<option value="createPeriod">생성 기간</option>
			                        </select>
			                        <div id="test">
				                        <div id="createDate" style="display: none;">
				                        	<div class="input-group input-group-sm">
					                        	<input type="date">
				                        	</div>
				                        </div>
				                        <div id="createPeriod" style="display: none;">
					                        <div class="input-group input-group-sm">
					                        	<input type="date">
					                        	<span>~</span>
					                        	<input type="date">
					                        </div>
				                        </div>
			                        </div>
								</td>
							</tr>
							<tr class="col-form-label sTitle LabelStyle">
								<td class="col-sm-1" align="center">
									삭제 여부
								</td>
								<td class="col-sm-2 dataValue">
			                    	<select class="form-control bTitle">
										<option value="" selected>전체</option>
										<option value="">삭제</option>
										<option value="">미삭제</option>
			                        </select>
								</td>
							</tr>
		                </table>
					</div>
					<div class="form-group row">
						<div class="col-sm-12" style="text-align:right;right:15px;">
							<button type="button" class="btn btn-info sTitle" onclick="cuponList();">검색</button>
						</div>
					</div>
					<div>
						<div class="form-group row">
							<div class="col-sm-12">
								<button type="button" class="btn btn-info sTitle">삭제</button>
								<select class="form-control bTitle w-auto d-inline-block" style="float: right;">
									<option value="" selected>10개씩 보기</option>
									<option value="">20개씩 보기</option>
									<option value="">30개씩 보기</option>
									<option value="">50개씩 보기</option>
									<option value="">100개씩 보기</option>
		                        </select>
							</div>
						</div>
					 	<div id="cuponList" style="font-size:12px;"></div>
					</div>
	    		</div>
	  		</section>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/boInclude/include_bottom.jspf"%>
	
	<script>
		$(document).ready(function() {
			cuponList();
		});
	
		/* 쿠폰 발급 조회 리스트 */
		function cuponList() {
			var params = {
				cuponNm : $("input[name='cuponNm']").val(),
			}
			
			$("#cuponList").jsGrid({
				locale:"ko",
				height: "300px",
				width: "100%",
				inserting: false,
				editing: false,
				sorting: false,
				paging: false,
				autoload: true,
				pageSize: 3,
				pageButtonCount: 3,
				gridview : true,
				deleteConfirm: "정말 삭제 하시겠습니까?",
				fields: [
					{ name: "Index", 			title: "번호",	type: "text", width: 30, align: "center", },
					{ name: "cuponIdntfctnNum",	title: "쿠폰번호",	type: "text", width: 30, align: "center", },
					{ name: "cuponNm",			title: "쿠폰명",	type: "text", width: 30, align: "center", },
					{ name: "cuponTypNm",		title: "혜택",	type: "text", width: 30, align: "center", },
					{ name: "useDt",				title: "사용기간",	type: "text", width: 30, align: "center", },
					{ name: "issuedCnt",			title: "발급수",	type: "text", width: 30, align: "center", },
					{ name: "", 					title: "발급구분",	type: "text", width: 30, align: "center", },
					{ name: "stat",				title: "상태",	type: "text", width: 30, align: "center", },
				],
			});
		}
		
		/* 탭 이벤트 */
		function showNoneTab(obj, element) {
			var val = $(obj).val();
			$("#" + element).removeClass("d-block");
			$("#" + element).children().removeClass("d-block");
			if (val) {
				$("#" + element).children("#" + val).addClass("d-block");
			}
		}
	</script>
	
</body>
</html>
/* ---------------------------------------------
 * 함수명 : enter
 * 설  명 : 나의 작품 검색 엔터키 누르면 검색함수 불러오도록함
 ---------------------------------------------*/

function enter(e){
	if(e.keyCode == 13){
		searchMyShow();
	}
}

/* ---------------------------------------------
 * 함수명 : searchMyShow
 * 설  명 : 나의 작품 검색 엔터키 누르면
 * 예) loginCheck(requestUrl,SqNumber)
 ---------------------------------------------*/
function searchMyShow(){
	var keyword = $("#search_input").val();
	if(keyword != "" && keyword.length > 1){
		searchOptions.keyword = keyword;
		ShowListAjax();
	}
	if(keyword == ""){
		searchOptions.keyword = null;
		ShowListAjax();
	}
	if(keyword != "" && keyword.length < 2){
		if(!isMobile){
			modalAlertShow("검색어를 2글자 이상 입력해주세요.", "searchKeyword");
		}else{
			alert("검색어를 2글자 이상 입력해주세요.");
			$("#search_input").focus();
		}
	}
}


//전체 버튼 클릭시
$("#btn_nal1").click(function() { 
	$('#btn_nal1').addClass('active');
	$('#btn_nal1').addClass('on bg_no'); 
	$('#btn_nal2').removeClass('active');
	$('#btn_nal2').removeClass('on bg_no'); 
	$('#btn_nal3').removeClass('active');
	$('#btn_nal3').removeClass('on bg_no'); 
	$('.iv-span').css('display', 'none');
	searchOptions.dealYn = null;
	searchOptions.workTypCd = null;
	searchOptions.dealBidYn = null;
	ShowListAjax();

});

//나의 창작 작품 클릭시
$("#btn_nal2").click(function() { 
	//workTypCd WORK로 sorting on bg_no
	$('#btn_nal1').removeClass('active'); 
	$('#btn_nal1').removeClass('on bg_no'); 
	$('#btn_nal2').addClass('active'); 
	$('#btn_nal2').addClass('on bg_no'); 
	$('#btn_nal3').removeClass('active'); 
	$('#btn_nal3').removeClass('on bg_no'); 
	$('.iv-span').css('display', 'none');
	searchOptions.workTypCd = "COLL";
	ShowListAjax();

});

//소장중인 작품 클릭시
$("#btn_nal3").click(function() { 
	//workTypCd COLL로 sorting
	$('#btn_nal1').removeClass('active');
	$('#btn_nal1').removeClass('on bg_no'); 
	$('#btn_nal2').removeClass('active');
	$('#btn_nal2').removeClass('on bg_no'); 
	$('#btn_nal3').addClass('active');
	$('#btn_nal3').addClass('on bg_no'); 
	$('.iv-span').css('display', 'none');
	searchOptions.workTypCd = "WORK";
	ShowListAjax();

});

//공개 유무 select값 변경시
$('#sel_open').change(function() {
  var sel_val = $(this).val();
	searchOptions.WorkOpenYn = sel_val;

	ShowListAjax();
});

//정렬 select값 변경시
$('#sel_sort').change(function() {
  var sel_val = $(this).val();
	searchOptions.sortCd = sel_val;

	ShowListAjax();
});

//전시구분 코드 select값 변경시
$('#sel_gubun').change(function() {
  var sel_val = $(this).val();
	searchOptions.selGubun = sel_val;

	ShowListAjax();
});


//전시 지역 select값 변경시
$('#sel_region').change(function() {
  var sel_val = $(this).val();
	searchOptions.selRegion = sel_val;

	ShowListAjax();
});


//게시글 관리 오픈
$("#btn_nal4").click(function() { 
	$('.work-hov').toggleClass('active');
});

//공개/비공개 컨트롤 패널 클릭
$(".wrh-1").click(function() {
	$("#selectedCount").text("(0)");
	//판매중, 거래완료 상태빼고 sorting
	searchOptions.dealYn = null;
	searchOptions.dealBidYn = null;
	searchOptions.dealYn = "N";
	ShowListAjax("wrh1");
});

//판매등록 컨트롤 패널 클릭
$(".wrh-2").click(function() { 
	$("#selectedCount").text("(0)");
	//판매중, 거래완료 상태빼고 sorting
	searchOptions.dealYn = null;
	searchOptions.dealBidYn = null;
	searchOptions.dealYn = "N";
	ShowListAjax("wrh2");
});

//작품정보수정 컨트롤 패널 클릭
$(".wrh-3").click(function() { 
	$("#selectedCount").text("(0)");
	//판매중, 거래완료 상태빼고 sorting
	searchOptions.dealYn = null;
	searchOptions.dealBidYn = null;
	searchOptions.dealYn = "N";
	ShowListAjax("wrh3");
});

//공개/비공개 컨트롤 패널 클릭 콜백
function wrh1Callback(){
	$("input[name=chkWorkSq]").attr("disabled", false);
	document.querySelectorAll(".check-div").forEach((el) => {
		el.style.display = "";
	});
	//체크박스로 바꾼다
	document.getElementsByName('chkWorkSq').forEach((el) => {
		el.type = "checkbox";
		el.checked = false;
	});
	$('.work-hov').removeClass('active'); 
	$('.work-drp-2').removeClass('dp_n'); 
	$('.wdb-1').addClass('active'); 
	$('.wdb-2').removeClass('active'); 
	$('.wdb-3').removeClass('active'); 
	$('.iv-span').css('display', '');
}

//판매등록 컨트롤 패널 클릭 콜백
function wrh2Callback(){
	$("input[name=chkWorkSq]").attr("disabled", false);
	document.querySelectorAll(".check-div").forEach((el) => {
		el.style.display = "";
	});
	//라디오 버튼으로 바꾼다
	document.getElementsByName('chkWorkSq').forEach((el) => {
		el.type = "radio";
		el.checked = false;
	});
	$('.work-hov').removeClass('active'); 
	$('.work-drp-2').removeClass('dp_n'); 
	$('.wdb-1').removeClass('active'); 
	$('.wdb-2').addClass('active'); 
	$('.wdb-3').removeClass('active'); 
	$('.iv-span').css('display', 'none');
}

//작품정보수정 컨트롤 패널 클릭 콜백
function wrh3Callback(){
	$("input[name=chkWorkSq]").attr("disabled", false);
	document.querySelectorAll(".check-div").forEach((el) => {
		el.style.display = "";
	});
	//라디오 버튼으로 바꾼다
	document.getElementsByName('chkWorkSq').forEach((el) => {
		el.type = "radio";
		el.checked = false;
	});
	$('.work-hov').removeClass('active'); 
	$('.work-drp-2').removeClass('dp_n'); 
	$('.wdb-1').removeClass('active'); 
	$('.wdb-2').removeClass('active'); 
	$('.wdb-3').addClass('active'); 
	$('.wdb-4').removeClass('active'); 
	$('.wdb-5').removeClass('active'); 
	$('.wdb-6').removeClass('active'); 
	$('.iv-span').css('display', 'none');
}

//취소 컨트롤 패널 클릭시
$(".wdb-all").click(function() { 
	$("#selectedCount").text("(0)");
	searchOptions.dealYn = null;
	searchOptions.dealBidYn = null;
	ShowListAjax();
	document.querySelectorAll(".check-div").forEach((el) => {
		el.style.display = "none";
	});
	//체크박스로 바꾸고 선택 초기화
	document.getElementsByName('chkWorkSq').forEach((el) => {
		el.type = "checkbox";
		el.checked = false;
	});
	$('.work-hov').removeClass('active'); 
	$('.work-drp-2').addClass('dp_n'); 
	//공개 버튼
	$('.wdb-1').removeClass('active'); 
	$('.wdb-2').removeClass('active'); 
	$('.wdb-3').removeClass('active'); 
	$('.wdb-4').removeClass('active'); 
	$('.wdb-5').removeClass('active'); 
	$('.wdb-6').removeClass('active'); 
	$('.iv-span').css('display', 'none');
});

//선택된 작품 갯수 카운트
function selectedCount(){
	var selectedCount = document.querySelectorAll('input[name=chkWorkSq]:checked').length;
	$("#selectedCount").text("("+selectedCount+")");
}


//공개/비공개 버튼 클릭
$('.wdb-1').click(function(e){
	$("input[name=chkWorkSq]").attr("disabled", true);
	$('.iv-span').css('display', 'none');
	var comtSqList = new Array();
	document.querySelectorAll('input[name=chkWorkSq]:checked').forEach((el) => {
		comtSqList.push(el.id);
	});
	if(e.target.innerHTML == "공개"){
		if(comtSqList.length < 1){
			if(!isMobile){
				modalAlertShow("작품을 선택하지 않았습니다.", "checkbox");
			}else{
				alert("작품을 선택하지 않았습니다.");
				$("input[name=chkWorkSq]").attr("disabled", false);
				$('.iv-span').css('display', '');
			}
		}else{
			if(!isMobile){
				modalConfirm("선택한 작품을 <b class='c-red dib'>공개</b> 처리 하시겠습니까?", function(confirm){
					if(confirm){
						ComtOpenYn(comtSqList, "Y");
					}else{
						$("input[name=chkWorkSq]").attr("disabled", false);
						$('.iv-span').css('display', '');
						$("#selectedCount").text("(0)");
						searchOptions.dealYn = null;
						searchOptions.dealBidYn = null;
						ShowListAjax();
						document.querySelectorAll(".check-div").forEach((el) => {
							el.style.display = "none";
						});
						//체크박스로 바꾸고 선택 초기화
						document.getElementsByName('chkWorkSq').forEach((el) => {
							el.type = "checkbox";
							el.checked = false;
						});
						$('.work-hov').removeClass('active'); 
						$('.work-drp-2').addClass('dp_n'); 
					}
				});
			}else{
				if(confirm("선택한 작품을 공개 처리 하시겠습니까?")){
					ComtOpenYn(comtSqList, "Y");
				}else{
					$("input[name=chkWorkSq]").attr("disabled", false);
					$('.iv-span').css('display', '');
					$("#selectedCount").text("(0)");
					searchOptions.dealYn = null;
					searchOptions.dealBidYn = null;
					ShowListAjax();
					document.querySelectorAll(".check-div").forEach((el) => {
						el.style.display = "none";
					});
					//체크박스로 바꾸고 선택 초기화
					document.getElementsByName('chkWorkSq').forEach((el) => {
						el.type = "checkbox";
						el.checked = false;
					});
					$('.work-hov').removeClass('active'); 
					$('.work-drp-2').addClass('dp_n'); 
				}
			}
		}
	}else if (e.target.innerHTML == "비공개"){
		if(comtSqList.length < 1){
			if(!isMobile){
				modalAlertShow("작품을 선택하지 않았습니다.", "checkbox");
			}else{
				alert("작품을 선택하지 않았습니다.");
				$("input[name=chkWorkSq]").attr("disabled", false);
				$('.iv-span').css('display', '');
			}
		}else{
			if(!isMobile){
				modalConfirm("선택한 작품을 <b class='c-red dib'>비공개</b> 처리 하시겠습니까?", function(confirm){
					if(confirm){
						//alert("비공개 처리 workSq:" + workSq);
						ComtOpenYn(comtSqList, "N");
					}else{
						$("input[name=chkWorkSq]").attr("disabled", false);
						$('.iv-span').css('display', '');
						$("#selectedCount").text("(0)");
						searchOptions.dealYn = null;
						searchOptions.dealBidYn = null;
						ShowListAjax();
						document.querySelectorAll(".check-div").forEach((el) => {
							el.style.display = "none";
						});
						//체크박스로 바꾸고 선택 초기화
						document.getElementsByName('chkWorkSq').forEach((el) => {
							el.type = "checkbox";
							el.checked = false;
						});
						$('.work-hov').removeClass('active'); 
						$('.work-drp-2').addClass('dp_n'); 
					}
				});
			}else{
				if(confirm("선택한 작품을 비공개 처리 하시겠습니까?")){
					ComtOpenYn(comtSqList, "N");
				}else{
					$("input[name=chkWorkSq]").attr("disabled", false);
					$('.iv-span').css('display', '');
					$("#selectedCount").text("(0)");
					searchOptions.dealYn = null;
					searchOptions.dealBidYn = null;
					ShowListAjax();
					document.querySelectorAll(".check-div").forEach((el) => {
						el.style.display = "none";
					});
					//체크박스로 바꾸고 선택 초기화
					document.getElementsByName('chkWorkSq').forEach((el) => {
						el.type = "checkbox";
						el.checked = false;
					});
					$('.work-hov').removeClass('active'); 
					$('.work-drp-2').addClass('dp_n'); 
				}
			}
			
		}
	}
});


//작품 공개 비공개 처리
function ComtOpenYn(list, yn){
	var param = {
			comtSqList : list,
			comtOpenYn : yn
	};
	//공개처리 ajax후 reload
	$.ajax({
      type: "post",
      url: "/myPage/myComtOpenYn",
      data: param,
      success: function(data) {
      	if(data.result > 0 && yn == "Y"){
      		if(!isMobile){
      			modalAlertShow("선택한 작품 공개처리가 완료되었습니다.", "reload");
      		}else{
      			alert("선택한 작품 공개처리가 완료되었습니다.");
          		location.reload();
      		}
      	}else if(data.result > 0 && yn == "N"){
      		if(!isMobile){
      			modalAlertShow("선택한 작품 비공개처리가 완료되었습니다.", "reload");
      		}else{
      			alert("선택한 작품 비공개처리가 완료되었습니다.");
          		location.reload();
      		}
      	}else if(data.result < 1 && yn == "Y"){
      		if(!isMobile){
      			modalAlertShow("공개처리에 실패했습니다.<br/>다시 시도해주세요.", "reload");
      		}else{
      			alert("공개처리에 실패했습니다.\n다시 시도해주세요.");
          		location.reload();
      		}
      	}else if(data.result < 1 && yn == "N"){
      		if(!isMobile){
      			modalAlertShow("비공개처리에 실패했습니다.<br/>다시 시도해주세요.", "reload");
      		}else{
      			alert("비공개처리에 실패했습니다.\n다시 시도해주세요.");
          		location.reload();
      		}
      	}
      },
      error: function(error) {
          alert("공개/비공개에 실패했습니다. 관리자에게 문의해주세요."); 
          location.reload();
      }
	});
}

//작품 공개 버튼 클릭시
function openYn(obj){
	$("input[name=chkWorkSq]").attr("disabled", true);
	$('.iv-span').css('display', 'none');
	var comtSqList = new Array();
	document.querySelectorAll('input[name=chkWorkSq]:checked').forEach((el) => {
		comtSqList.push(el.id);
	});
	if(obj.target.innerHTML == "공개"){
		if(comtSqList.length < 1){
			if(!isMobile){
				modalAlertShow("작품을 선택하지 않았습니다.", "checkbox");
			}else{
				alert("작품을 선택하지 않았습니다.");
				$("input[name=chkWorkSq]").attr("disabled", false);
				$('.iv-span').css('display', '');
			}
		}else{
			if(!isMobile){
				modalConfirm("선택한 작품을 <b class='c-red dib'>공개</b> 처리 하시겠습니까?", function(confirm){
					if(confirm){
						ComtOpenYn(comtSqList, "Y");
					}else{
						$("input[name=chkWorkSq]").attr("disabled", false);
						$('.iv-span').css('display', '');
						$("#selectedCount").text("(0)");
						searchOptions.dealYn = null;
						searchOptions.dealBidYn = null;
						ShowListAjax();
						document.querySelectorAll(".check-div").forEach((el) => {
							el.style.display = "none";
						});
						//체크박스로 바꾸고 선택 초기화
						document.getElementsByName('chkWorkSq').forEach((el) => {
							el.type = "checkbox";
							el.checked = false;
						});
						$('.work-hov').removeClass('active'); 
						$('.work-drp-2').addClass('dp_n'); 
					}
				});
			}else{
				if(confirm("선택한 작품을 공개 처리 하시겠습니까?")){
					ComtOpenYn(comtSqList, "Y");
				}else{
					$("input[name=chkWorkSq]").attr("disabled", false);
					$('.iv-span').css('display', '');
					$("#selectedCount").text("(0)");
					searchOptions.dealYn = null;
					searchOptions.dealBidYn = null;
					ShowListAjax();
					document.querySelectorAll(".check-div").forEach((el) => {
						el.style.display = "none";
					});
					//체크박스로 바꾸고 선택 초기화
					document.getElementsByName('chkWorkSq').forEach((el) => {
						el.type = "checkbox";
						el.checked = false;
					});
					$('.work-hov').removeClass('active'); 
					$('.work-drp-2').addClass('dp_n'); 
				}
			}
		}
	}else if (obj.target.innerHTML == "비공개"){
		if(comtSqList.length < 1){
			if(!isMobile){
				modalAlertShow("작품을 선택하지 않았습니다.", "checkbox");
			}else{
				alert("작품을 선택하지 않았습니다.");
				$("input[name=chkWorkSq]").attr("disabled", false);
				$('.iv-span').css('display', '');
			}
		}else{
			if(!isMobile){
				modalConfirm("선택한 작품을 <b class='c-red dib'>비공개</b> 처리 하시겠습니까?", function(confirm){
					if(confirm){
						//alert("비공개 처리 workSq:" + workSq);
						ComtOpenYn(comtSqList, "N");
					}else{
						$("input[name=chkWorkSq]").attr("disabled", false);
						$('.iv-span').css('display', '');
						$("#selectedCount").text("(0)");
						searchOptions.dealYn = null;
						searchOptions.dealBidYn = null;
						ShowListAjax();
						document.querySelectorAll(".check-div").forEach((el) => {
							el.style.display = "none";
						});
						//체크박스로 바꾸고 선택 초기화
						document.getElementsByName('chkWorkSq').forEach((el) => {
							el.type = "checkbox";
							el.checked = false;
						});
						$('.work-hov').removeClass('active'); 
						$('.work-drp-2').addClass('dp_n'); 
					}
				});
			}else{
				if(confirm("선택한 작품을 비공개 처리 하시겠습니까?")){
					ComtOpenYn(comtSqList, "N");
				}else{
					$("input[name=chkWorkSq]").attr("disabled", false);
					$('.iv-span').css('display', '');
					$("#selectedCount").text("(0)");
					searchOptions.dealYn = null;
					searchOptions.dealBidYn = null;
					ShowListAjax();
					document.querySelectorAll(".check-div").forEach((el) => {
						el.style.display = "none";
					});
					//체크박스로 바꾸고 선택 초기화
					document.getElementsByName('chkWorkSq').forEach((el) => {
						el.type = "checkbox";
						el.checked = false;
					});
					$('.work-hov').removeClass('active'); 
					$('.work-drp-2').addClass('dp_n'); 
				}
			}
			
		}
	}
}

//작품정보수정 버튼 클릭시
$('.wdb-2').click(function(e){
	$("input[name=chkWorkSq]").attr("disabled", true);
	if(document.querySelector('input[name=chkWorkSq]:checked') == null || document.querySelector('input[name=chkWorkSq]:checked') == ""){
		if(!isMobile){
			modalAlertShow("게시글을 선택하지 않았습니다.", "radio");
		}else{
			alert("게시글을 선택하지 않았습니다.");
			$("input[name=chkWorkSq]").attr("disabled", false);
		}
	}else{
		var comtSq = document.querySelector('input[name=chkWorkSq]:checked').id;
		if(!isMobile){
			modalConfirm("게시글수정 페이지로 이동합니다.", function(confirm){
				if(confirm){
					
					//커뮤니티 코드
					var comtTypCd = searchOptions.comtTypCd;
					
					//자랑하기 수정페이지
					if(comtTypCd == "BOA"){
						location.href = "/myPage/myWork_mod?comtSq="+comtSq;
					//전시소개&후기 수정페이지
					}else if(comtTypCd == "EXH"){
						location.href = "/myPage/myExhibit_mod?comtSq="+comtSq;
					//이슈 수정페이지	
					}else if(comtTypCd == "ISS"){
						location.href = "/myPage/myIssue_mod?comtSq="+comtSq;
					}

				}else{
					$("input[name=chkWorkSq]").attr("disabled", false);
					$("#selectedCount").text("(0)");
					searchOptions.dealYn = null;
					searchOptions.dealBidYn = null;
					ShowListAjax();
					document.querySelectorAll(".check-div").forEach((el) => {
						el.style.display = "none";
					});
					//체크박스로 바꾸고 선택 초기화
					document.getElementsByName('chkWorkSq').forEach((el) => {
						el.type = "checkbox";
						el.checked = false;
					});
					$('.work-hov').removeClass('active'); 
					$('.work-drp-2').addClass('dp_n'); 
				}
			});
		}else{
			if(confirm("게시글 수정 페이지로 이동합니다.")){
				
				//커뮤니티 코드
				var comtTypCd = searchOptions.comtTypCd;
				
				//자랑하기 수정페이지
				if(comtTypCd == "BOA"){
					location.href = "/myPage/myWork_mod?comtSq="+comtSq;
				//전시소개&후기 수정페이지
				}else if(comtTypCd == "EXH"){
					location.href = "/myPage/myExhibit_mod?comtSq="+comtSq;
				//이슈 수정페이지	
				}else if(comtTypCd == "ISS"){
					location.href = "/myPage/myIssue_mod?comtSq="+comtSq;
				}
				
			}else{
				$("input[name=chkWorkSq]").attr("disabled", false);
				$("#selectedCount").text("(0)");
				searchOptions.dealYn = null;
				searchOptions.dealBidYn = null;
				ShowListAjax();
				document.querySelectorAll(".check-div").forEach((el) => {
					el.style.display = "none";
				});
				//체크박스로 바꾸고 선택 초기화
				document.getElementsByName('chkWorkSq').forEach((el) => {
					el.type = "checkbox";
					el.checked = false;
				});
				$('.work-hov').removeClass('active'); 
				$('.work-drp-2').addClass('dp_n'); 
			}
		}
	}
});

//삭제 컨트롤 패널 클릭 콜백
function wrh3Callback(){
	$("input[name=chkWorkSq]").attr("disabled", false);
	document.querySelectorAll(".check-div").forEach((el) => {
		el.style.display = "";
	});
	//체크박스로 바꾼다
	document.getElementsByName('chkWorkSq').forEach((el) => {
		el.type = "checkbox";
		el.checked = false;
	});
	$('.work-hov').removeClass('active'); 
	$('.work-drp-2').removeClass('dp_n'); 
	$('.wdb-1').removeClass('active'); 
	$('.wdb-2').removeClass('active'); 
	$('.wdb-3').addClass('active'); 
	$('.iv-span').css('display', 'none');
}


//삭제 버튼 클릭시
$('.wdb-3').click(function(e){
	$("input[name=chkWorkSq]").attr("disabled", true);
	var comtSqList = new Array();
	document.querySelectorAll('input[name=chkWorkSq]:checked').forEach((el) => {
		comtSqList.push(el.id);
	});
	if(comtSqList.length < 1){
		if(!isMobile){
			modalAlertShow("작품을 선택하지 않았습니다.", "radio");
		}else{
			alert("작품을 선택하지 않았습니다.");
			$("input[name=chkWorkSq]").attr("disabled", false);
		}
	}else{
		if(!isMobile){
			modalConfirm("선택한 작품을 정말 <b class='c-red dib'>삭제</b>하시겠습니까?</br>(삭제 후 복구할 수 없습니다.)", function(confirm){
				if(confirm){
					//삭제 처리 ajax후 reload
					$.ajax({
				        type: "post",
				        url: "/myPage/myComtDelYn",
				        data: {
				        	comtSqList : comtSqList
				        },
				        success: function(data) {
				        	if(data.result > 0){
				        		modalAlertShow("선택한 작품 " + data.result + "개 삭제가 완료되었습니다.", "reload");
				        	}else{
				        		modalAlertShow("작품 삭제에 실패했습니다.<br/>다시 시도해주세요.", "reload");
				        	}
				        },
				        error: function(error) {
				            alert("삭제처리에 실패했습니다.\n관리자에게 문의해주세요."); 
				            location.reload();
				        }
					});
				}else{
					$("input[name=chkWorkSq]").attr("disabled", false);
					$("#selectedCount").text("(0)");
					searchOptions.dealYn = null;
					searchOptions.dealBidYn = null;
					ShowListAjax();
					document.querySelectorAll(".check-div").forEach((el) => {
						el.style.display = "none";
					});
					//체크박스로 바꾸고 선택 초기화
					document.getElementsByName('chkWorkSq').forEach((el) => {
						el.type = "checkbox";
						el.checked = false;
					});
					$('.work-hov').removeClass('active'); 
					$('.work-drp-2').addClass('dp_n'); 
				}
			});
		}else{
			if(confirm("선택한 작품을 정말 삭제 하시겠습니까?\n(삭제 후 복구할 수 없습니다.)")){
				//삭제 처리 ajax후 reload
				$.ajax({
			        type: "post",
			        url: "/myPage/myComtDelYn",
			        data: {
			        	comtSqList : comtSqList
			        },
			        success: function(data) {
			        	if(data.result > 0){
			        		alert("선택한 작품 삭제가 완료되었습니다.");
			        		location.reload();
			        	}else{
			        		alert("작품 삭제에 실패했습니다.\n다시 시도해주세요.");
			        		location.reload();
			        	}
			        },
			        error: function(error) {
			            alert("삭제처리에 실패했습니다.\n관리자에게 문의해주세요."); 
			            location.reload();
			        }
				});
			}else{
				$("input[name=chkWorkSq]").attr("disabled", false);
				$("#selectedCount").text("(0)");
				searchOptions.dealYn = null;
				searchOptions.dealBidYn = null;
				ShowListAjax();
				document.querySelectorAll(".check-div").forEach((el) => {
					el.style.display = "none";
				});
				//체크박스로 바꾸고 선택 초기화
				document.getElementsByName('chkWorkSq').forEach((el) => {
					el.type = "checkbox";
					el.checked = false;
				});
				$('.work-hov').removeClass('active'); 
				$('.work-drp-2').addClass('dp_n'); 
			}
		}
	}
});
	
function setPagenation(count){
	var html = '';
	var totalCount = count.myTotal;
	var i = 0;

	realEndPage = Math.ceil( totalCount / 4 );												// 최종 페이지 페이징시 리스트 갯수 바꿀러면 이부분 숫자 변경
	endPage = Math.ceil( realEndPage / 10 ) > 10 ? 10 : realEndPage % 10;					// 10개씩 보여줄 마지막 페이지
	next = ( Math.ceil( realEndPage / 10 ) ) > pageNextBtnCount + 1 ? true : false;			// 다음 10개버튼 보여주기 위한 boolean
	prev = pageNextBtnCount > 0 ? true : false;
	  
	// 이전 페이지
	if(prev) {
		html += '<a href="javascript:pageNextBtnCount = 0; nowPage = 0; ShowListAjax();" class="next_end ml5"></a>';
		html += '<a href="javascript:pageNextBtnCount--; nowPage = 10 * pageNextBtnCount; ShowListAjax();" class="next ml10"></a>'
	}
	
 	// 1~5만큼 페이지네이션 그려줌
	for(i = 0 * ( pageNextBtnCount * 10 ); i < endPage; i++) {
 	  	if(nowPage == i) {
			console.log("들어옴");
			html += '<a href="javascript:nowPage ='+ i +'; ShowListAjax();"><strong>'+ ( i + 1 ) +'</strong></a>';
		} else {
 			html += '<a href="javascript:nowPage ='+ i +'; ShowListAjax();">'+ ( i + 1 ) +'</a>';
		}
 	}
 	
	// 다음 페이지
	if(next){
		html += '<a href="javascript:pageNextBtnCount++; nowPage = 10 * pageNextBtnCount; ShowListAjax();" class="next ml10"></a>'
		
		var finalPage = Math.ceil( realEndPage / 10 );
		html += '<a href="javascript:pageNextBtnCount = finalPage - 1; nowPage = ( finalPage - 1 ) * 10 ; ShowListAjax();" class="next_end ml5"></a>';
	}
	
	$(".paginate").empty();
    $(".paginate").append(html);
}

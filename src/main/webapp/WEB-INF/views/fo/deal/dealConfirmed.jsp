<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
    <style>
    	.head-wrap{border-bottom:#e9e9e9 1px solid;}
    	.swi-box::before{background-color:#f9f9f9;}
    	.footer-wrap{margin-top:0;}
    	.hd-div{background-color:#fff;}
    	input[type="radio"] + label{margin-bottom:0;}
    </style>
</head>

<body>
	<div class="wrap">
		<jsp:include page="/WEB-INF/views/fo/main/header.jsp"></jsp:include>
		
		<div class="body-wrap">
			
			<div class="contents max-1500">
				<div class="sub-title">
					<h3 class="">거래 등록 (경매)</h3>
				</div>
				
				<div class="baeg-wrap">
					<div class="baeg-left">
						<img src="resources/img/de/sub-img.jpg" />
					</div>
					<div class="baeg-right">
					
						<div class="med">
							<h2 class="mo-mt100">판매방식</h2>
							<div class="med-ic">
								<div class="por">
									<div class="tootip-4">거래 전<br/>꼭! 확인하세요</div>
									<img src="resources/img/ba/me-icon.png" class="med-me" />
								</div>
							</div>
							<div class="med-box radio-2">
								<input type="radio" id="r1" name="rr">
								<label for="r1" class="wd-145"><span></span>경매</label>
								<input type="radio" id="r2" name="rr">
								<label for="r2"><span></span>정찰가</label>
							</div>
						</div>
						
						<div class="med">
							<h2>기간설정</h2>
							<div class="med-box radio-2">
								<input type="radio" id="w1" name="aa">
								<label for="w1" class="wd-145"><span></span>즉시 시작</label>
								<input type="radio" id="w2" name="aa">
								<label for="w2"><span></span>시작 시간 선택</label>
								
								<ul class="med-ul">
									<li class="active"><a href="#">1주</a></li>
									<li><a href="#">2주</a></li>
									<li><a href="#">3주</a></li>
									<li><a href="#">4주</a></li>
									<li><a href="#">5주</a></li>
								</ul>
							</div>
						</div>
						
						<div class="med">
							<h2>낙찰 희망가</h2>
							<div class="med-box radio-2">
								<input type="radio" id="t1" name="cc" checked>
								<label for="t1" class="c-red" ><span></span>경매 시작가 <div class="mg_l30 di-b">2,240,000 원</div></label>
								<span class="to-red">판매 희망가의 70%로 자동 설정 됩니다.</span>
								
								<div class="input-box">
									<input type="text" class="input-1" placeholder="희망가를 입력해주세요" />
								</div>
							</div>
						</div>
						
						<div class="med">
							<h2>배송 시작 주소</h2>
							<div class="med-box radio-2">
								<input type="radio" id="q1" name="vv" class="user-on" checked>
								<label for="q1" class="wd-185"><span></span>회원 정보와 동일</label>
								<input type="radio" id="q2" name="vv" class="home-on">
								<label for="q2"><span></span>새로운 주소</label>
								
								<div class="home-1">
									<table class="tstyle3">
										<tr>
											<th>받는사람</th>
											<td>홍길동</td>
										</tr>
										<tr>
											<th>주 소</th>
											<td>111 - 22    서울시 마포구 성산동 111번지   3F</td>
										</tr>
										<tr>
											<th>휴대전화</th>
											<td>010 - 000 - 0000</td>
										</tr>
									</table>
								</div>
								
								<div class="home-2" style="display:none;">
									<div class="input-box">
										<input type="text" class="input-2" placeholder="받는사람을 입력해주세요" />
										<span class="span-in">기본 주소</span>
									</div>
									
									<a href="" class="btn-3">우편번호 검색</a>
										
									<div class="input-box">
										<input type="text" class="input-2" placeholder="우편번호를 검색하세요" />
										<span class="span-in">기본 주소</span>
									</div>
									<div class="input-box">
										<input type="text" class="input-2" placeholder="상세주소를 입력하세요" />
										<span class="span-in">상세 주소</span>
									</div>
									<div class="input-box">
										<input type="text" class="input-2" placeholder="휴대전화를 입력해주세요" />
										<span class="span-in">휴대전화</span>
									</div>
								</div>
							</div>
							
						</div>
						
						<div class="bat-box2">
							<button type="button" class="ba-btn1"  data-toggle="modal" data-target="#myModal4"><span>경매 시작하기</span></button>
						</div>
						
					</div>
				</div>
			</div>
			
			
		</div>
		<jsp:include page="/WEB-INF/views/fo/main/footer.jsp"></jsp:include>
	</div>

<!-- 모달검색 -->



<div class="modal fade modal-s" id="paintModal" tabindex="-1" role="dialog" aria-labelledby="paintModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sech2">
		<div class="modal-content">
			<div class="modal-body">
				<div class="modal-bs">
					<div class="mb-img-1"><a href="#" alt="작가 본인 선택"></a></div>
					<div class="mb-img-2"><a href="#" alt="소장중인 작품"></a></div>
					<a href="#" class="mb-a" data-dismiss="modal" aria-label="Close"><img src="resources/img/de/end-btn.png" /></a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade modal-s" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sech">
		<div class="modal-content">
			<div class="modal-header">
				<div class="conts">
				    <div class="close" data-dismiss="modal" aria-label="Close"></div>
				</div>

			</div>
			<div class="modal-body">				
				<!-- 검색버튼 클릭시 -->
				<div class="search-show">
					<div class="sea-box">
						<img src="resources/img/w-logo.jpg" class="sea-img" />
						
						<div class="sea-won">
							<!-- <div class="select-box">
								<select>
									<option>작가명</option>
								</select>
							</div> -->
							<input type="text" class="" />
							<a href="#"><img src="resources/img/icon-2.jpg" /></a>
						</div>
						<div class="ta-h3">
							<h3 class="sea-h3">작품</h3>
							<a href="#"><span>more</span></a>
						</div>
						<ul class="sea-text">
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
						</ul>
						<div class="ta-h3">
							<h3 class="sea-h3">작가</h3>
							<a href="#"><span>more</span></a>
						</div>
						<ul class="sea-text">
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
						</ul>
						<div class="ta-h3">
							<h3 class="sea-h3">컨텐츠</h3>
							<a href="#"><span>more</span></a>
						</div>
						<ul class="sea-text">
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->
<div class="modal fade modal-s" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModal1Label" aria-hidden="true">
	<div class="modal-dialog modal-sech3">
		<div class="modal-content">
			<div class="modal-header">
				<div class="conts">
				    <div class="close" data-dismiss="modal" aria-label="Close"></div>
				</div>

			</div>
			<div class="modal-body">
				<div class="pons-div">
					<button type="button" class="pons-btn">동양화</button>
					<button type="button" class="pons-btn">동양화</button>
					<button type="button" class="pons-btn">동양화</button>
					<button type="button" class="pons-btn">동양화</button>
					<button type="button" class="pons-btn">동양화</button>
					<button type="button" class="pons-btn">동양화</button>
					<button type="button" class="pons-btn">동양화</button>
				</div>
				<ul class="drop-ul">
					<li role="presentation">
						<div class="drop-title">
							<span>Deal wtith</span>
						</div>
						<div class="drop-body">
							<div class="db-div">
								<input type="checkbox" id="s1" name="ss" />
								<label for="s1"><span></span>Collector</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="s2" name="ss" />
								<label for="s2"><span></span> Artist</label>
							</div>
						</div>
					</li>
					<li role="presentation">
						<div class="drop-title">
							<span>거래</span>
						</div>
						<div class="drop-body">
							<div class="db-div">
								<input type="checkbox" id="z1" name="cc" />
								<label for="z1"><span></span>진행 중인 거래</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="z2" name="cc" />
								<label for="z2"><span></span>종료된 거래</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="z3" name="cc" />
								<label for="z3"><span></span>경매</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="z4" name="cc" />
								<label for="z4"><span></span>정찰가</label>
							</div>
						</div>
					</li>
					<li role="presentation">
						<div class="drop-title">
							<span>형태</span>
						</div>
						<div class="drop-body">
							<div class="db-div">
								<input type="checkbox" id="x1" name="cc" />
								<label for="x1"><span></span>평면</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="x2" name="cc" />
								<label for="x2"><span></span>입체</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="x3" name="cc" />
								<label for="x3"><span></span>NFT</label>
							</div>
						</div>
					</li>
					<li role="presentation">
						<div class="drop-title">
							<span>분류</span>
						</div>
						<div class="drop-body">
							<div class="db-div">
								<input type="checkbox" id="v1" name="cc" />
								<label for="v1"><span></span>동양화</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="v2" name="cc" />
								<label for="v2"><span></span>서양화</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="v3" name="cc" />
								<label for="v3"><span></span>팝아트</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="v4" name="cc" />
								<label for="v4"><span></span>현대미술</label>
							</div>
							<div class="db-div">
								<input type="checkbox" id="v5" name="cc" />
								<label for="v5"><span></span>고미술</label>
							</div>
						</div>
					</li>
					<li role="presentation">
						<div class="drop-title">
							<span>유형</span>
						</div>
						<div class="drop-body">
						
						</div>
					</li>
					<li role="presentation">
						<div class="drop-title">
							<span>종류</span>
						</div>
						<div class="drop-body">
						
						</div>
					</li>
					<div class="drop-btnb">
						<button type="button" class="dbtn-1">선택</button>
						<button type="button" class="dbtn-2">rereset</button>
					</div>
				</ul>
			</div>
		</div>
	</div>
</div>


<!-- 거래 등록 전 꼭! 확인하세요 -->
<div class="modal fade modal-s" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModal3Label" aria-hidden="true">
	<div class="modal-dialog modal-baeg max-w530">
		<div class="modal-content">
			<div class="modal-header">
				<div class="baegs">
					<h2>거래 등록 전 <br/>꼭! 확인하세요</h2>
				    <img src="resources/img/ba/icon-1.png" class="con-img" />
				    <div class="close" data-dismiss="modal" aria-label="Close"><img src="resources/img/ba/icon-end.png" /></div>
				</div>

			</div>
			<div class="modal-body">
				<div class="md-box-1">
					<p class="min-h240">
					위작, 허위판매 등 신고 사유를 가능한 상세히 작성해 주시기 바랍니다.<br />
					허위 신고는 제재를 받을 수 있으며 민형사상의 법적 책임을 물을 수 있습니다.
					</p>
					
					<div class="baeg-btn mg_t30">
						<a href="#"><button type="button" class="baeg-b1">확인</button></a>
						<a href="#" data-dismiss="modal" aria-label="Close"><button type="button" class="baeg-b2">취소</button></a>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 신고하기 완료 -->
<div class="modal fade modal-s" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModal4Label" aria-hidden="true">
	<div class="modal-dialog modal-baeg max-w530">
		<div class="modal-content">
			<div class="modal-header" style="height: 0; min-height: 0; padding: 0;">
				<div class="baegs">
				    <div class="close" data-dismiss="modal" aria-label="Close"><img src="resources/img/ba/icon-end.png" /></div>
				</div>

			</div>
			<div class="modal-body">
				<div class="md-box-1">
					<div class="md-ds" style="color:#333;">
						경매가 시작되면 취소할 수 없습니다.<br/>
						신중히 결정해 주세요.
					</div>
					
					<div class="baeg-btn mg_t30">
						<a href="#"><button type="button" class="baeg-b1">확인</button></a>
						<a href="#" data-dismiss="modal" aria-label="Close"><button type="button" class="baeg-b2">취소</button></a>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript">      
      
      $(window).on("resize", function () {
	   	    if(window.matchMedia('(min-width: 1537px)').matches)
	   	    {
	   	    	
	   	    	var swiper = new Swiper(".mySwiper2", {
		   	          slidesPerView: 4,
		   	          spaceBetween: 30,
		   	          slidesPerGroup: 1,
		   	          loop: true,
		   	          loopFillGroupWithBlank: true,
		   	       	  /* autoplay: {
		               delay: 3000,
		               disableOnInteraction: false,
		             }, */
		   	          pagination: {
		   	            el: ".swiper-pagination",
		   	            clickable: true,
		   	          },
		   	          navigation: {
		   	            nextEl: ".swiper-button-next",
		   	            prevEl: ".swiper-button-prev",
		   	          },
		   	        });
	   	    	
		       	  
		       	  
	   	    	
	   	    	
	   	    }  else if(window.matchMedia('(min-width: 751px)').matches) {
	   	    	
	   	    	var swiper = new Swiper(".mySwiper2", {
		   	          slidesPerView: 3,
		   	          spaceBetween: 30,
		   	          slidesPerGroup: 1,
		   	          loop: true,
		   	          loopFillGroupWithBlank: true,
		   	       /* autoplay: {
		               delay: 3000,
		               disableOnInteraction: false,
		             }, */
		   	          pagination: {
		   	            el: ".swiper-pagination",
		   	            clickable: true,
		   	          },
		   	          navigation: {
		   	            nextEl: ".swiper-button-next",
		   	            prevEl: ".swiper-button-prev",
		   	          },
		   	     });
	   	    	
		       	
	   	    	
	   	     } else {
	   	    	var swiper = new Swiper(".mySwiper2", {
		   	          slidesPerView: 2,
		   	       	  spaceBetween: 30,
		   	          slidesPerGroup: 1,
		   	          loop: true,
		   	          loopFillGroupWithBlank: true,
		   	       /* autoplay: {
		               delay: 3000,
		               disableOnInteraction: false,
		             }, */
		   	          pagination: {
		   	            el: ".swiper-pagination",
		   	            clickable: true,
		   	          },
		   	          navigation: {
		   	            nextEl: ".swiper-button-next",
		   	            prevEl: ".swiper-button-prev",
		   	          },
		   	     });
	   	    	
	   	     };
	   	}).resize();
      
      
      
      $(document).ready(function () {
	      $(".elm").hover(
	    	function(){ $(this).addClass('hover') },
	   	    function(){ $(this).removeClass('hover') }
	   	  )
	   	  $(".cn-b").hover(
	    	function(){ $(this).addClass('gis') },
	   	    function(){ $(this).removeClass('gis') }
	   	  )
	   	  
	   	  $("#myModal3").modal("show");
      });
      
      $(function() {                      
    	  $(".bab-bo").click(function() { 
    	    $(this).toggleClass("bashow");     
    	  });
    	  
    	  $(".lg-my").click(function() { 
      	    $('.bg-sh').toggleClass('bg-show');     
      	 	 $('.s-hov').toggleClass('s-hov-show');     
      	  });
    	  
    	  
    	  $(".user-on").click(function() {   
        	    $('.home-1').show();  
        	    $('.home-2').hide()
        	  });
    	  
    	  $(".home-on").click(function() {  
      	    $('.home-1').hide();  
      	    $('.home-2').show()
      	  });
    	  
    	});
      
      
      
      
      /* 메뉴바 FIXED */
      if (jQuery(window).width() > 0) {
          jQuery(window).on("scroll",function(ev){
              if(jQuery(window).scrollTop() > 80 ) { /* 해당 높이를 벗어나면 fixed 클래스 추가 */
                  jQuery('.head-wrap').addClass('fixed');
              }
              else{
                  jQuery('.head-wrap').removeClass('fixed');
              }
              return false;
          });
      }
      
      
      /* jQuery(function($) {

    	    window.onresize = function(){
    	      document.location.reload();
    	    };

    	}); */
      
      
      
      var delay = 300;
      var timer = null;

      //Javascript
      window.addEventListener('resize', function(){
      	clearTimeout(timer);
      	timer = setTimeout(function(){
      		document.location.reload();
      	}, delay);
      });

      //jQuery
      $(window).on('resize', function(){
      	clearTimeout(timer);
      	timer = setTimeout(function(){
      		document.location.reload();
      	}, delay);
      });
      
      $('ul.dropdown-menu.mega-dropdown-menu').on('click', function(event){
    	    // The event won't be propagated up to the document NODE and 
    	    // therefore delegated events won't be fired
    	    event.stopPropagation();
    	});
      
      $('.selectpicker').selectpicker();
      
    </script>
    
	
	
	
	
</body>

</html>

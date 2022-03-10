<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="ko">

<head>
    <style>
    	.head-wrap{border-bottom:#e9e9e9 1px solid;}
    </style>
</head>

<body>
	<div class="wrap">
		<jsp:include page="/WEB-INF/views/fo/main/header.jsp"></jsp:include>
		
		<div class="body-wrap">
			<div class="contents">
				
				<div class="con-wrap">
					<div class="con-left">
						<div class="con-btn">
							<a href="#" data-toggle="modal" data-target="#paintModal"><img src="resources/img/de/paint.png" /></a>
						</div>
					
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading1">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion1" href="#collapse1" aria-expanded="true" aria-controls="collapse1">
											Deal wtith
										</a>
									</h4>
								</div>
								<div id="collapse1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading1">
									<div class="panel-body">
										<input type="radio" id="r1" name="rr" />
										<label for="r1"><span></span>Collector</label><br/>
										<input type="radio" id="r2" name="rr" />
										<label for="r2"><span></span> Artist</label>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading2">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion2" href="#collapse2" aria-expanded="true" aria-controls="collapse2">
											거래
										</a>
									</h4>
								</div>
								<div id="collapse2" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading2">
									<div class="panel-body">
										<input type="checkbox" id="a1" name="cc" />
										<label for="a1"><span></span>진행 중인 거래</label><br/>
										<input type="checkbox" id="a2" name="cc" />
										<label for="a2"><span></span>종료된 거래</label><br/>
										<input type="checkbox" id="a3" name="cc" />
										<label for="a3"><span></span>경매</label><br/>
										<input type="checkbox" id="a4" name="cc" />
										<label for="a4"><span></span>정찰가</label>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading3">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion3" href="#collapse3" aria-expanded="true" aria-controls="collapse3">
											형태
										</a>
									</h4>
								</div>
								<div id="collapse3" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading3">
									<div class="panel-body">
										<input type="checkbox" id="b1" name="cc" />
										<label for="b1"><span></span>평면</label><br/>
										<input type="checkbox" id="b2" name="cc" />
										<label for="b2"><span></span>입체</label><br/>
										<input type="checkbox" id="b3" name="cc" />
										<label for="b3"><span></span>NFT</label>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading3">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion4" href="#collapse4" aria-expanded="true" aria-controls="collapse4">
											분류
										</a>
									</h4>
								</div>
								<div id="collapse4" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading4">
									<div class="panel-body">
										<input type="checkbox" id="c1" name="cc" />
										<label for="c1"><span></span>동양화</label><br/>
										<input type="checkbox" id="c2" name="cc" />
										<label for="c2"><span></span>서양화</label><br/>
										<input type="checkbox" id="c3" name="cc" />
										<label for="c3"><span></span>팝아트</label>
										<input type="checkbox" id="c4" name="cc" />
										<label for="c4"><span></span>현대미술</label><br/>
										<input type="checkbox" id="c5" name="cc" />
										<label for="c5"><span></span>고미술</label>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading5">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion5" href="#collapse5" aria-expanded="true" aria-controls="collapse5">
											유형
										</a>
									</h4>
								</div>
								<div id="collapse5" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading5">
									<div class="panel-body">
									
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading6">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion6" href="#collapse6" aria-expanded="true" aria-controls="collapse6">
											종류
										</a>
									</h4>
								</div>
								<div id="collapse6" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading6">
									<div class="panel-body">
									
									</div>
								</div>
							</div>
						</div>
						<button type="button" class="btn-more2"><span>reset</span></button>
					</div>
					
					<div class="con-right">
					
						<div class="sea-won2">
							<input type="text" class="" placeholder="작품이나 작가를 검색해 보세요" />
							<a href="#" data-toggle="modal" data-target="#myModal"><img src="resources/img/de/sech-icon.jpg" /></a>
						</div>
					
						<div class="reds-box">
							<ul class="pc-on">
								<li>
									<a href="#" class="up-on">
										최신 순
									</a>
								</li>
								<li>
									<a href="#" class="down-on">
										제작년도
									</a>
								</li>
								<li>
									<a href="#" class="">
										작가명 <span>ㄱ</span> - <span>ㅎ</span>
									</a>
								</li>
								<li>
									<a href="#" class="">
										작가명 <span>A</span> - <span>Z</span>
									</a>
								</li>
								<li>
									<a href="#" class="">
										가격
									</a>
								</li>
								<li>
									<a href="#" class="">
										남은거래
									</a>
								</li>
							</ul>
							
							<ul class="ta-on">
								<li>
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle de-btn" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="trfalseue">최신 순</button>
										<ul class="dropdown-menu ds-bo" role="menu" aria-labelledby="dropdownMenu1">
											<li role="presentation">
												<div class="drop-body pd_0">
													<div class="drop-select">
														<a href="#" class="active">최신 순</a>
														<a href="#">제작년도</a>
														<a href="#">작가명</a>
														<a href="#">작가명</a>
														<a href="#">가격</a>
														<a href="#">남은 거래</a>
													</div>
												</div>
											</li>
										</ul>
									</div>
								</li>
								<li>
									<div class="dropdown" style="position:inherit;">
										<button class="btn btn-default dropdown-toggle de-btn mo-no" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-expanded="trfalseue">Filter</button>
										<button class="btn btn-default dropdown-toggle de-btn mo-on " type="button" id="" data-toggle="modal" data-target="#myModal1">Filter</button>
										

										<ul class="dropdown-menu drop-ul" role="menu" aria-labelledby="dropdownMenu2">
											<li role="presentation">
												<div class="drop-title">
													<span>Deal wtith</span>
												</div>
												<div class="drop-body">
													<input type="radio" id="m1" name="rr" />
													<label for="m1"><span></span>Collector</label><br/>
													<input type="radio" id="m2" name="rr" />
													<label for="m2"><span></span> Artist</label>
												</div>
											</li>
											<li role="presentation">
												<div class="drop-title">
													<span>거래</span>
												</div>
												<div class="drop-body">
													<input type="checkbox" id="p1" name="cc" />
													<label for="p1"><span></span>진행 중인 거래</label><br/>
													<input type="checkbox" id="p2" name="cc" />
													<label for="p2"><span></span>종료된 거래</label><br/>
													<input type="checkbox" id="p3" name="cc" />
													<label for="p3"><span></span>경매</label><br/>
													<input type="checkbox" id="p4" name="cc" />
													<label for="p4"><span></span>정찰가</label>
												</div>
											</li>
											<li role="presentation">
												<div class="drop-title">
													<span>형태</span>
												</div>
												<div class="drop-body">
													<input type="checkbox" id="o1" name="cc" />
													<label for="o1"><span></span>평면</label><br/>
													<input type="checkbox" id="o2" name="cc" />
													<label for="o2"><span></span>입체</label><br/>
													<input type="checkbox" id="o3" name="cc" />
													<label for="o3"><span></span>NFT</label>
												</div>
											</li>
											<li role="presentation">
												<div class="drop-title">
													<span>분류</span>
												</div>
												<div class="drop-body">
													<input type="checkbox" id="i1" name="cc" />
													<label for="i1"><span></span>동양화</label><br/>
													<input type="checkbox" id="i2" name="cc" />
													<label for="i2"><span></span>서양화</label><br/>
													<input type="checkbox" id="i3" name="cc" />
													<label for="i3"><span></span>팝아트</label><br/>
													<input type="checkbox" id="i4" name="cc" />
													<label for="i4"><span></span>현대미술</label><br/>
													<input type="checkbox" id="i5" name="cc" />
													<label for="i5"><span></span>고미술</label>
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
								</li>
								
							</ul>
						</div>
						
						<div>
							<div class="columns-wrap2" id="columns2">
								
								<figure class="item">
								
									<!-- 하트 on하면 색상 -->
									<div class="heart on"></div>
									
									<!-- active하고 hover하면 나오고 /  sale 넣고 hover하면나옵니다 / auction hover -->
									<div class="item-div-img active">
										<img src="resources/img/de/be-bg1.png">
										
										<div class="item-ho">
											<p>2022. 01. 01 – 2022. 01.30</p>
											<p>응찰수 : 12</p>
											<ul>
												<li>03<span>day</span></li>
												<li>03<span>hrs</span></li>
												<li>03<span>min</span></li>
												<li>03<span>sec</span></li>
											</ul>
											<h4>시작가  3,700,000 원</h4>
										</div>
										
										<div class="item-ho2 sale-div">
											<h3>판매중</h3>
											<ul>
												<li>03<span>day</span></li>
												<li>03<span>hrs</span></li>
												<li>03<span>min</span></li>
												<li>03<span>sec</span></li>
											</ul>
										</div>
										
										<div class="item-ho2 auction-div">
											<h3>경매중</h3>
											<ul>
												<li>03<span>day</span></li>
												<li>03<span>hrs</span></li>
												<li>03<span>min</span></li>
												<li>03<span>sec</span></li>
											</ul>
											
										</div>
									</div>
									
									<!-- 하단텍스트 -->
									<div class="item-body">
										<div class="uesr-s">
											<img src="resources/img/de/ues-icon.png" />
										</div>
										<div class="text-s">
											<h3>작가명 (1983년생)</h3>
											<p class="ts-1">작품명 입니다작품명입니다작품명입니다(2021...</p>
											<p>Oil & Canvas</p>
											<p>72.7x90.9cm</p>
											
											<h4>판매가 3,700,000</h4>
											
											<p class="ts-2">
												2022. 01. 01 – 2022. 01.30<br/>
												응찰수 : 12<br/>
												03일   07시    10분   30초 
											</p>
										</div>
										
										<!-- artist active넣어야지나옴 -->
										<div class="artist active"><span>Artist</span></div>
									</div>
									
								</figure>
						
								<figure class="item">
									<!-- 하트 on하면 색상 -->
									<div class="heart"></div>
									
									<!-- sold-1 ~ 4 넣으면 나옵니다 -->
									<div class="item-div-img sold-2">
										<img src="resources/img/de/be-bg2.png">
									</div>
									
									<!-- 하단텍스트 -->
									<div class="item-body">
										<div class="uesr-s">
											<img src="resources/img/de/ues-icon.png" />
										</div>
										<div class="text-s">
											<h3>작가명 (1983년생)</h3>
											<p class="ts-1">작품명 입니다작품명입니다작품명입니다(2021...</p>
											<p>Oil & Canvas</p>
											<p>72.7x90.9cm</p>
											
											<h4>판매가 3,700,000</h4>
											
										</div>
										
										<!-- artist -->
										<div class="artist"><span>Artist</span></div>
									</div>
								</figure>
								
								<figure class="item">
									<!-- 하트 on하면 색상 -->
									<div class="heart"></div>
									
									<div class="item-div-img sale">
										<img src="resources/img/de/be-bg3.png">										
									</div>
									
									<!-- 하단텍스트 -->
									<div class="item-body">
										<div class="uesr-s">
											<img src="resources/img/de/ues-icon.png" />
										</div>
										<div class="text-s">
											<h3>작가명 (1983년생)</h3>
											<p class="ts-1">작품명 입니다작품명입니다작품명입니다(2021...</p>
											<p>Oil & Canvas</p>
											<p>72.7x90.9cm</p>
											
											<h4>판매가 3,700,000</h4>
										</div>
										
										<!-- artist -->
										<div class="artist"><span>Artist</span></div>
									</div>
								</figure>
								
							</div>
						</div>
						
						<div class="text-center mg_t50">
							<button type="button" class="btn-more"><span>more</span></button>
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
					<div class="mb-img-1"><a href="/dealConfirmed" alt="작가 본인 선택"></a></div>
					<div class="mb-img-2"><a href="/dealConfirmed" alt="소장중인 작품"></a></div>
					<a href="#" class="mb-a" data-dismiss="modal" aria-label="Close"><img src="resources/img/de/end-btn.png" /></a>
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
								<input type="radio" id="s1" name="ss" />
								<label for="s1"><span></span>Collector</label>
							</div>
							<div class="db-div">
								<input type="radio" id="s2" name="ss" />
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


<script type="text/javascript">      
      
      $(window).on("resize", function () {
	   	    if(window.matchMedia('(min-width: 1537px)').matches)
	   	    {
		   	    document.querySelectorAll(".item").forEach((item) => {
		       	     item.style.gridRowEnd = `span ${item.clientHeight + 0}`;
		       	  });
		       	  const wrap = document.querySelector(".columns-wrap2");
		       	  wrap.style.display = "grid";
		       	  wrap.style.gridTemplateColumns = "repeat(auto-fill, 353px)";
		       	  wrap.style.gridAutoRows = "1px";
		       	  
		       	  
	   	    	
	   	    	
	   	    }  else if(window.matchMedia('(min-width: 751px)').matches) {
	   	    	
		   	      document.querySelectorAll(".item").forEach((item) => {
		       	     item.style.gridRowEnd = `span ${item.clientHeight + 280}`;
		       	  });
		       	  const wrap = document.querySelector(".columns-wrap2");
		       	  wrap.style.display = "grid";
		       	  wrap.style.gridTemplateColumns = "repeat(auto-fill, 65rem)";
		       	  wrap.style.gridAutoRows = "1px";
		       	
	   	    	
	   	     } else {
	   	    	var swiper = new Swiper(".mySwiper2", {
	   	          slidesPerView: 1,
	   	          slidesPerGroup: 1,
	   	          loop: true,
	   	          loopFillGroupWithBlank: true,
	   	          pagination: {
	   	            el: ".swiper-pagination",
	   	            clickable: true,
	   	          },
	   	          navigation: {
	   	            nextEl: ".swiper-button-next",
	   	            prevEl: ".swiper-button-prev",
	   	          },
	   	     });
	   	    	
	   	    	document.querySelectorAll(".item").forEach((item) => {
		       	     item.style.gridRowEnd = `span ${item.clientHeight + 150}`;
		       	  });
		       	  const wrap = document.querySelector(".columns-wrap2");
		       	  wrap.style.display = "grid";
		       	  wrap.style.gridTemplateColumns = "repeat(auto-fill, )";
		       	  wrap.style.gridAutoRows = "1px";
	   	    	
	       	  
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
      });
      
      $(function() {                      
    	  $(".bab-bo").click(function() { 
    	    $(this).toggleClass("bashow");     
    	  });
    	  
    	  $(".lg-my").click(function() { 
      	    $('.bg-sh').toggleClass('bg-show');     
      	 	 $('.s-hov').toggleClass('s-hov-show');     
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
      
    </script>
    
	
	
	
</body>

</html>

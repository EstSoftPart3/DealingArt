<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="ko">

<head>
</head>


<body>
	<div class="wrap">
		<jsp:include page="header.jsp"></jsp:include>
		
			<!-- 메인 배너 -->
			<div class="contents">
				<div class="bg-sh"></div>
				<div class="main-banner">						
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
							<div class="swiper-slide">
								<img src="resources/img/banner-1.jpg" />
								<div class="mab-text">
									<div class="mb-box">
										<div class="mab-title">작가</div>
										<h2>MeME (b. 1983)</h2>
										<p class="mab-p1">WITH LOVE #4 (edition10),</p>
										<p class="mab-p2">35x35cm,  Lenticular & mixed media, 2021</p>
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<img src="resources/img/banner-2.jpg" />
							</div>
							<div class="swiper-slide">
								<img src="resources/img/banner-3.jpg" />
							</div>
							<div class="swiper-slide">
								<img src="resources/img/banner-4.jpg" />
							</div>
							<div class="swiper-slide">
								<img src="resources/img/banner-5.jpg" />
							</div>
							<div class="swiper-slide">
								<img src="resources/img/banner-6.jpg" />
							</div>
							<div class="swiper-slide">
								<img src="resources/img/banner-7.jpg" />
							</div>
						</div>
						<div class="swiper-pagination swpa-1"></div>
					</div>
					
					<div class="bab-bo">
						<div class="ta-sho">
							<a href="#"><span>Guide</span></a>
						</div>
						<div class="mab-rb">
							<a href="javascript:fnModalAlert();" class="mab-a"><span>Guide</span></a>
							<ul class="mab-ul">
								<li><a href="javascript:fnModalAlert();"><img src="resources/img/icon-4.png" /> <span>거래방법</span></a></li>
								<li><a href="javascript:fnModalAlert();"><img src="resources/img/icon-5.png" /> <span>작가등록</span></a></li>
								<li><a href="javascript:fnModalAlert();"><img src="resources/img/icon-6.png" /> <span>작품등록</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 모바일일때 -->
			<div class="contents mo-nav">
				<nav>
					<li><a href="#">Deal</a></li>
					<li><a href="#">Megazine</a></li>
					<li><a href="#">Artist Library</a></li>
					<li><a href="#">About</a></li>
				</nav>
			</div>
			
			<!-- 진행 순서 -->
			<div class="contents bg-1">
				<div class="da-snm">
					<ul class="">
						<li>
							<img src="resources/img/img-1.png" />
							<p class="da-p1">안전한 거래</p>
							<p class="da-p2 pc-on">딜링아트를 통한 거래는<br/>안전합니다.</p>
							<p class="da-p2 ta-on">딜링아트를 통한<br/>거래는 안전합니다.</p>
						</li>
						<li>
							<img src="resources/img/img-2.png" />
							<p class="da-p1">공개경매</p>
							<p class="da-p2 pc-on">경매 진행 현황을<br/>실시간으로 확인하세요.</p>
							<p class="da-p2 ta-on">경매 진행 현황을<br/>실시간으로 확인하세요.</p>
						</li>
						<li>
							<img src="resources/img/img-3.png" />
							<p class="da-p1">온라인 결제</p>
							<p class="da-p2 pc-on">번거로운 작품 거래. 더 이상<br/>직접 움직일 필요가 없습니다.</p>
							<p class="da-p2 ta-on">번거로운 작품 거래<br/>간편하게 결재하시요.</p>
						</li>
						<li>
							<img src="resources/img/img-4.png" />
							<p class="da-p1">저렴한 수수료</p>
							<p class="da-p2 pc-on">비상식적인 미술품 거래 수수료<br/>거품을 제거했습니다.</p>
							<p class="da-p2 ta-on">비상식적인 미술품 거래<br/>거품을 제거했습니다.</p>
						</li>
						<li>
							<img src="resources/img/img-5.png" />
							<p class="da-p1">간편매물 등록</p>
							<p class="da-p2 pc-on">보증서만 업로드 하면<br/>딜링아트에서 입력해 드립니다.</p>
							<p class="da-p2 ta-on">보증서만 업로드 하면<br/>정보를 입력해 드립니다.</p>
						</li>
					</ul>
				</div>
			</div>
			
			<!-- hotest deal 스와이퍼 -->
			<div class="contents max-1500">
				<div class="cont-title">
					<h3>hotest deal</h3>
				</div>
				<div class="swi-box">
					<div class="swiper mySwiper2">
						<div class="swiper-wrapper" id="mainHotestContent">
							<!-- <div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>작가명</h4>
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>작가명</h4>
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>작가명</h4>
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>작가명</h4>
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>작가명</h4>
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</a>
							</div> -->
						</div>
						<div class="swiper-pagination swpa-2 pc-no"></div>
					</div>
					<div class="swiper-button-next sbn ta-no"><span><img src="resources/img/arr-r.jpg"></span></div>
					<div class="swiper-button-prev sbp ta-no"><span><img src="resources/img/arr-l.jpg"></span></div>
				</div>
				<!-- <div class="text-center">
					<button type="button" class="btn-more ta-no"><span>more</span></button>
				</div> -->
			</div>
			
			<!-- Dealing Art Insights -->
			<div class="contents max-1500">
				<div class="cont-title ta-t60">
					<h3>Dealing Art <span class="ta-no"><br/></span>Insights</h3>
					<!-- <a href="#" class="ct-more"><img src="img/icon-p.jpg" /><span>more</span></a> -->
				</div>
				<div class="cns-div">
				
					<div class="swiper mySwiper3">
						<div class="swiper-wrapper cn-b">
							<div class="swiper-slide elm">
								<a href="#">
									<div class="cns-box">
										<img src="resources/img/img-test.jpg" />
										<div class="cns-sb">
											<p class="cns-p1">LIV -ing ART : New year</p>
											<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum Lorem Ipsum Lorem Ipsum</p>
										</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide elm">
								<a href="#">
									<div class="cns-box">
										<img src="resources/img/img-test.jpg" />
										<div class="cns-sb">
											<p class="cns-p1">LIV -ing ART : New year</p>
											<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum Lorem Ipsum Lorem Ipsum</p>
										</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide elm">
								<a href="#">
									<div class="cns-box">
										<img src="resources/img/img-test.jpg" />
										<div class="cns-sb">
											<p class="cns-p1">LIV -ing ART : New year</p>
											<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum Lorem Ipsum Lorem Ipsum</p>
										</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide elm">
								<a href="#">
									<div class="cns-box">
										<img src="resources/img/img-test.jpg" />
										<div class="cns-sb">
											<p class="cns-p1">LIV -ing ART : New year</p>
											<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum Lorem Ipsum Lorem Ipsum</p>
										</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide elm">
								<a href="#">
									<div class="cns-box">
										<img src="resources/img/img-test.jpg" />
										<div class="cns-sb">
											<p class="cns-p1">LIV -ing ART : New year</p>
											<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum Lorem Ipsum Lorem Ipsum</p>
										</div>
									</div>
								</a>
							</div>
						</div>
					</div>
				
					<!-- <ul class="cn-b">
						<li class="elm">
							<a href="#">
								<div class="cns-box">
									<img src="resources/img/img-test.jpg" />
									<div class="cns-sb">
										<p class="cns-p1">LIV -ing ART : New year</p>
										<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum Lorem Ipsum Lorem Ipsum</p>
									</div>
								</div>
							</a>
						</li>
						<li class="elm">
							<a href="#">
								<div class="cns-box">
									<img src="resources/img/img-test.jpg" />
									<div class="cns-sb">
										<p class="cns-p1">LIV -ing ART : New year</p>
										<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum</p>
									</div>
								</div>
							</a>
						</li>
						<li class="elm">
							<a href="#">
								<div class="cns-box">
									<img src="resources/img/img-test.jpg" />
									<div class="cns-sb">
										<p class="cns-p1">LIV -ing ART : New year</p>
										<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum</p>
									</div>
								</div>
							</a>
						</li>
						<li class="elm">
							<a href="#">
								<div class="cns-box">
									<img src="resources/img/img-test.jpg" />
									<div class="cns-sb">
										<p class="cns-p1">LIV -ing ART : New year</p>
										<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum</p>
									</div>
								</div>
							</a>
						</li>
						<li class="elm">
							<a href="#">
								<div class="cns-box">
									<img src="resources/img/img-test.jpg" />
									<div class="cns-sb">
										<p class="cns-p1">LIV -ing ART : New year</p>
										<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum</p>
									</div>
								</div>
							</a>
						</li>
					</ul>  -->
					<div class="text-center">
						<button type="button" class="btn-more" onclick=""><span>more</span></button>
					</div>
				</div>
			</div>
			
			  <style type="text/css">
				.columns-wrap {
					display: grid;
					/* grid-template-columns: 150px 50px; */
					grid-template-columns: 1fr 1fr 1fr;
					grid-template-rows: 300px 50px;
					gap: 40px 10px; 
					row-gap:30px; column-gap:10px;
				}
  			</style>
			
			
			<!-- 가장 많은 입찰 / 오늘의 낙찰 -->
			<div class="contents max-1500 gridContent" style="border: 0px solid red; height: 700px;">
				<div class="cont-title" style="margin-top:0px;">
					<h3>오늘의 낙찰</h3>
					<!-- <a href="#" class="ct-more mo-no"><img src="img/icon-p.jpg" /><span>more</span></a> -->
				</div>
				<div class="cns-div">
				
					<div class="columns-wrap" id="columns">
						<!-- <figure class="item">
							<img src="resources/img/img-1.jpg">
							<a class="hd-div2">								
								<div class="hd-text">
									<h4>작가명</h4>
									<div class="hd-tc">
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</div>
							</a>
						</figure>
						<figure class="item">
							<img src="resources/img/img-2.jpg">
							<a class="hd-div2">								
								<div class="hd-text">
									<h4>작가명</h4>
									<div class="hd-tc">
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</div>
							</a>
						</figure>
						<figure class="item">
							<img src="resources/img/img-3.jpg">
							<a class="hd-div2">								
								<div class="hd-text">
									<h4>작가명</h4>
									<div class="hd-tc">
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</div>
							</a>
						</figure>
						<figure class="item">
							<img src="resources/img/img-4.jpg">
							<a class="hd-div2">								
								<div class="hd-text">
									<h4>작가명</h4>
									<div class="hd-tc">
										<div class="hd-d1">작품명(2021)<br/>소재 Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">낙찰가 3,700,000 원</div>
									</div>
								</div>
							</a>
						</figure> -->
					
					</div>
					
				</div>
				
		</div>
		<div class="text-center">
			<button type="button" class="btn-more" onclick="more_onCilck()"><span>more</span></button>
		</div>
		
		<jsp:include page="footer.jsp"></jsp:include>
		
	</div>




<script type="text/javascript">
	var mainHotest = {};
	var mainTodayBid = {};
	var page = 1;
	$(document).ready(function() {
	    $(".elm").hover(
	  	function(){ $(this).addClass('hover') },
	 	    function(){ $(this).removeClass('hover') }
	 	  )
	 	$(".cn-b").hover(
	  	function(){ $(this).addClass('gis') },
	 	    function(){ $(this).removeClass('gis') }
	 	  )
	 	searchMainData(page);
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

	  var myArray = ["01","02","03","04","05","06","07","08","09"];
      var swiper = new Swiper(".mySwiper", {
    	  autoplay: {
              delay: 3000,
              disableOnInteraction: false,
            },
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
          renderBullet: function (index, className) {
            return '<span class="' + className + '">' + myArray[index + 0] + '</span>';
          },
        },
      });
      
      
      
      $(window).on("resize", function () {
	   	    if(window.matchMedia('(min-width: 1537px)').matches)
	   	    {
	   	    	var swiper = new Swiper(".mySwiper2", {
	   	          slidesPerView: 4,
	   	          spaceBetween: 30,
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
		       	     item.style.gridRowEnd = `span ${item.clientHeight + 20}`;
		       	  });
		       	  const wrap = document.querySelector(".columns-wrap");
		       	  wrap.style.display = "grid";
		       	  wrap.style.gridTemplateColumns = "repeat(auto-fill, 360px)";
		       	  wrap.style.gridAutoRows = "1px";
		       	  
		       	  
		       	var swiper = new Swiper(".mySwiper3", {
		      	  slidesPerView: 5,
		            spaceBetween: 20,
		            slidesPerGroup: 1,
		            loop: true,
		            loopFillGroupWithBlank: true,
		        });
	   	    	
	   	    	
	   	    }  else if(window.matchMedia('(min-width: 751px)').matches) {
	   	    	var swiper = new Swiper(".mySwiper2", {
	   	          slidesPerView: 2,
	   	          spaceBetween: 30,
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
		       	     item.style.gridRowEnd = `span ${item.clientHeight + 20}`;
		       	  });
		       	  const wrap = document.querySelector(".columns-wrap");
		       	  wrap.style.display = "grid";
		       	  wrap.style.gridTemplateColumns = "repeat(auto-fill, 42rem)";
		       	  wrap.style.gridAutoRows = "1px";
		       	  
		       	  
		       	var swiper = new Swiper(".mySwiper3", {
		      	  slidesPerView: 3,
		            spaceBetween: 20,
		            slidesPerGroup: 1,
		            loop: true,
		            loopFillGroupWithBlank: true,
		        });
		       	
		       	
	   	    	
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
	   	    	
	       	  
	       	var swiper = new Swiper(".mySwiper3", {
	       		slidesPerView: 3,
	            spaceBetween: 30,
	            grabCursor: true,
	            pagination: {
	              el: ".swiper-pagination",
	              clickable: true,
	            },
	        });
	       	  
	       	  
	   	     };
	   	}).resize();
      
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
      
  	function searchMainData(page) {
  		
		$.ajax({
	           type: "post",
	           url: "main/mainData",
	           data: {
	        	   page : page,
	        	   pageSize : 4
	           },
	           success: function(data) {
	        	   mainHotest = data.mainData.mainHotest;
	        	   mainTodayBid = data.mainData.todayBid;
	        	   var hotestHtml = '';
	        	   for(i=0; i<mainHotest.length; i++){
		        	   hotestHtml += '<div class="swiper-slide">';
		        	   hotestHtml += '<a class="hd-div">';
		        	   hotestHtml += '<img src="'+ mainHotest[i].workMainImgUrl +'" class="hd-img" />';
		        	   hotestHtml += '		<div class="hd-text">';
		        	   hotestHtml += '			<h4>'+ mainHotest[i].artstActvtyNm +'</h4>';
		        	   hotestHtml += '			<div class="hd-d1">'+ mainHotest[i].workNm +'('+ mainHotest[i].workProdcYear +')';
		        	   hotestHtml += '			<br/>소재 '+ mainHotest[i].workMatrl +', '+ mainHotest[i].workSizeWidth +'x'+ mainHotest[i].workSizeDepth +'x'+ mainHotest[i].workSizeHeight +'</div>';
		        	   hotestHtml += '			<div class="hd-d2">응찰가 '+ formatComma(mainHotest[i].maxBidPrc) +'</div>';
		        	   hotestHtml += '		</div>';
		        	   hotestHtml += '	</a>';
		        	   hotestHtml += '</div>';
	        	   }
	        	   $("#mainHotestContent").append(hotestHtml).trigger("create");
	        	   
	        	   var todayBidHtml = '';
	        	   for(i=0; i<mainTodayBid.length; i++){
	        		   var cid = Date.now().toString(36) + Math.random().toString(36).substr(2);
	        		  
	        		   todayBidHtml += '<figure class="item">';
	        		   todayBidHtml += '<img src="'+ mainTodayBid[i].workMainImgUrl +'" id="img_'+cid+'" onmouseover="imageInfo(\''+cid+'\')" style="height: 300px; width:100%;  object-fit: contain">';
	        		   todayBidHtml += '	<a class="hd-div2">';								
	        		   todayBidHtml += '		<div class="hd-text">';
	        		   todayBidHtml += '			<h4>'+ mainTodayBid[i].artstActvtyNm +'</h4>';
	        		   todayBidHtml += '			<div class="hd-tc" id="imgInfo_'+cid+'">';
	        		   todayBidHtml += '				<div class="hd-d1">'+ mainTodayBid[i].workNm +'('+ mainTodayBid[i].workProdcYear +')';
	        		   todayBidHtml += '				<br/>'+ mainTodayBid[i].workMatrl +', '+ mainTodayBid[i].workSizeWidth +'x'+ mainHotest[i].workSizeDepth +'x'+ mainHotest[i].workSizeHeight +'</div>';
	        		   todayBidHtml += '				<div class="hd-d2">낙찰가 '+ formatComma(mainTodayBid[i].dealSbidPrc) +'</div>';
	        		   todayBidHtml += '			</div>';
	        		   todayBidHtml += '		</div>';
	        		   todayBidHtml += '	</a>';
	        		   todayBidHtml += '</figure>';
	        		  
	        		 }
	        	  
	        	   	$("#columns").append(todayBidHtml).trigger("create");
	        	  
	        		
	        	  
	        	   
	        	   
	           },
	           error: function(error) {
	               alert("오류 발생" + error);
	           }
		})
	}
  	
  	function more_onCilck(){
  		//debugger;
  		page += 1;
  		searchMainData(page);
  		
  		/* var gh = $('.gridContent').height();
  		
  		$('.gridContent').height(gh+700); */
  		
  	}
	
  	function imageInfo(i) {
  		
  		var imgId = "img_"+i; 
  		var w = $("#" + imgId).width();//width 구하기 
  		var h = $("#" + imgId).height();//height 구하기 

  		var imgInfo = "imgInfo_"+i;
  		 $('#'+imgInfo).width(w);
         $('#'+imgInfo).height(h-50);
	}
  	
  	
      
    </script>
	
	
</body>

</html>

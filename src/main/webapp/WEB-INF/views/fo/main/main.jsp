<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>
<html lang="ko">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="initial-scale=1,user-scalable=no,maximum-scale=1,width=device-width">
	<meta name="mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="theme-color" content="#000000">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>딜링아트</title>
	<link type="text/css" rel="stylesheet" href="resources/css/font.css" />
	<link type="text/css" rel="stylesheet" href="resources/css/swiper-bundle.min.css" />
	<link type="text/css" rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link type="text/css"rel="stylesheet" href="resources/css/common_pc.css">
	<link type="text/css" media="screen and (max-width: 750px)" rel="stylesheet" href="resources/css/ui_mo.css" />
	<link type="text/css" media="screen and (min-width: 751px) and (max-width: 1536px)" rel="stylesheet" href="resources/css/ui_tablet.css" />
	<link type="text/css" media="screen and (min-width: 1537px)" rel="stylesheet" href="resources/css/ui_pc.css" />

	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</head>

<body>
	<div class="wrap">
		<div class="head-wrap">
			<div class="head">
				<div class="h-logo"><a href="#"><img src="resources/img/logo.png" /></a></div>
				<div class="h-gnb">
					<div class="navbox">
						<nav>
							<li><a href="#">Deal</a></li>
							<li><a href="#">Megazine</a></li>
							<li><a href="#">Artist Library</a></li>
							<li><a href="#">About</a></li>
						</nav>
					</div>
					
					<!-- 로그인전 -->
					<div class="login-hide h-text"  style="display:none;">
						<span>LOGIN</span>
						<span>JOIN</span>
					</div>
					
					<!-- 로그인후 -->
					<div class="login-show h-img">
						<span class="sog-1"><a href="#"><img src="resources/img/icon-1.png" /></a></span>
						<span class="sog-2 lg-my"><a href="#"><img src="resources/img/icon-2.png" /></a></span>
						<div class="s-hov">
							<ul>
								<li><a href="#"><img src="resources/img/ic-1.jpg" /><span>마이 페이지</span></a></li>
								<li><a href="#"><img src="resources/img/ic-2.jpg" /><span>경매 / 거래 내역</span></a></li>
								<li><a href="#"><img src="resources/img/ic-3.jpg" /><span>마이 콜렉션</span></a></li>
								<li><a href="#"><img src="resources/img/ic-4.jpg" /><span>좋아요</span></a></li>
								<li><a href="#"><img src="resources/img/ic-5.jpg" /><span>고객센터</span></a></li>
							</ul>
							<button type="button" class="btn-1">로그아웃</button>
						</div>
					</div>
					
					
					<!-- 검색 -->
					<a href="" class="icon-search" data-toggle="modal" data-target="#myModal"><img src="resources/img/icon-3.png"></a>
					
					
				</div>
			</div>
			
		</div>
		
		<div class="body-wrap">
		
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
							<a href="#" class="mab-a"><span>Guide</span></a>
							<ul class="mab-ul">
								<li><a href="#"><img src="resources/img/icon-4.png" /> <span>거래방법</span></a></li>
								<li><a href="#"><img src="resources/img/icon-5.png" /> <span>작가등록</span></a></li>
								<li><a href="#"><img src="resources/img/icon-6.png" /> <span>작품등록</span></a></li>
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
						<div class="swiper-wrapper">
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
									<img src="img/img-test.jpg" />
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
									<img src="img/img-test.jpg" />
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
									<img src="img/img-test.jpg" />
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
									<img src="img/img-test.jpg" />
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
									<img src="img/img-test.jpg" />
									<div class="cns-sb">
										<p class="cns-p1">LIV -ing ART : New year</p>
										<p class="cns-p2">Lorem Ipsum is simply dummy text<br/>of the printing and typesetting<br/>industry. Lorem Ipsum</p>
									</div>
								</div>
							</a>
						</li>
					</ul> -->
				</div>
			</div>
			
			<!-- 가장 많은 입찰 / 오늘의 낙찰 -->
			<div class="contents max-1500">
				<div class="cont-title">
					<h3>가장 많은 입찰 / 오늘의 낙찰</h3>
					<!-- <a href="#" class="ct-more mo-no"><img src="img/icon-p.jpg" /><span>more</span></a> -->
				</div>
				<div class="cns-div">
					<div class="columns-wrap" id="columns">
						<figure class="item">
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
						</figure>
						<figure class="item">
							<img src="resources/img/img-3.jpg">
						</figure>
						<figure class="item">
							<img src="resources/img/img-4.jpg">
						</figure>
					</div>
				</div>
				<div class="text-center">
					<button type="button" class="btn-more"><span>more</span></button>
				</div>
			
		</div>
		
		<div class="footer-wrap">
			<div class="footer-box">
				<div class="footer-nav">
					<ul class="">
						<li><a href="#">경매약관</a></li>
						<li><a href="#">온라인경매약관</a></li>
						<li><a href="#">개인정보처림방침</a></li>
						<li><a href="#">내부정보관리규정</a></li>
					</ul>
					<div class="footer-icon">
						<a href="#"><img src="resources/img/sns-f.jpg" /></a>
						<a href="#"><img src="resources/img/sns-t.jpg" /></a>
						<a href="#"><img src="resources/img/sns-i.jpg" /></a>
					</div>
				</div>
				
				<div class="pc-on">
					<div class="footer-text">상호 : MANSION9  대표 : 이영선  사업자등로번호 : 473-81-01206[사업자정보확인]</div>
					<div class="footer-text">
						<ol>
							<li>주소 : 04075 서울특별시 마포구 토정로 11길 60(상수동)1F</li>
							<li>대표번호 : 070-4267-7371</li>
							<li>팩스번호 : 02-336-2920</li>
						</ol>
					</div>
					<div class="footer-text">
						<ol>
							<li>통신판매업 신고 : 제 2019-서울마포-1063호</li>
							<li>개인정보관리책임자 : 이영선(privacy@mainsion9.co.kr</li>
							<li>이메일 : cafe24@mainsion9.co,kr</li>
						</ol>
					</div>
				</div>
				
				
				<div class="tb-on max-100">
					<div class="footer-text">상호 : MANSION9<br/>대표 : 이영선  사업자등로번호 : 473-81-01206[사업자정보확인]</div>
					<div class="footer-text">
						<ol>
							<li class="dib af-dn">주소 : 04075 서울특별시 마포구 토정로 11길 60(상수동)1F</li>
							<li class="">대표번호 : 070-4267-7371</li>
							<li class="af-dn">팩스번호 : 02-336-2920</li>
						</ol>
					</div>
					<div class="footer-text">
						<ol>
							<li class="af-dn">통신판매업 신고 : 제 2019-서울마포-1063호</li>
							<li>개인정보관리책임자 : 이영선(privacy@mainsion9.co.kr 이메일 : cafe24@mainsion9.co,kr</li>
						</ol>
					</div>
				</div>
				
				<div class="mo-on max-100">
					<div class="footer-text">상호 : MANSION9<br/>대표 : 이영선</div>
					<div class="footer-text">
						<ol>
							<li class="dib af-dn">주소 : 04075 서울특별시 마포구 토정로 11길 60(상수동)1F</li>
							<li class="dib af-dn">대표번호 : 070-4267-7371</li>
							<li class="af-dn">팩스번호 : 02-336-2920</li>
							<li class="af-dn">이메일 : cafe24@mainsion9.co,kr</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
	</div>


<!-- 모달검색 -->
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

<script type="text/javascript">
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
      
    </script>
	
	
</body>

</html>

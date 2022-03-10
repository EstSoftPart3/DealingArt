<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <script src="resources/js/common.js"></script>
</head>
<body>
	<div class="head-wrap">
		<div class="head">
			<div class="h-logo"><a href="#"><img src="resources/img/logo.png" /></a></div>
			<div class="h-gnb">
				<div class="navbox">
					<nav>
						<li><a href="/deal">Deal</a></li>
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
</body>
</html>
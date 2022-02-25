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
	<title>������Ʈ</title>
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
					
					<!-- �α����� -->
					<div class="login-hide h-text"  style="display:none;">
						<span>LOGIN</span>
						<span>JOIN</span>
					</div>
					
					<!-- �α����� -->
					<div class="login-show h-img">
						<span class="sog-1"><a href="#"><img src="resources/img/icon-1.png" /></a></span>
						<span class="sog-2 lg-my"><a href="#"><img src="resources/img/icon-2.png" /></a></span>
						<div class="s-hov">
							<ul>
								<li><a href="#"><img src="resources/img/ic-1.jpg" /><span>���� ������</span></a></li>
								<li><a href="#"><img src="resources/img/ic-2.jpg" /><span>��� / �ŷ� ����</span></a></li>
								<li><a href="#"><img src="resources/img/ic-3.jpg" /><span>���� �ݷ���</span></a></li>
								<li><a href="#"><img src="resources/img/ic-4.jpg" /><span>���ƿ�</span></a></li>
								<li><a href="#"><img src="resources/img/ic-5.jpg" /><span>������</span></a></li>
							</ul>
							<button type="button" class="btn-1">�α׾ƿ�</button>
						</div>
					</div>
					
					
					<!-- �˻� -->
					<a href="" class="icon-search" data-toggle="modal" data-target="#myModal"><img src="resources/img/icon-3.png"></a>
					
					
				</div>
			</div>
			
		</div>
		
		<div class="body-wrap">
		
			<!-- ���� ��� -->
			<div class="contents">
				<div class="bg-sh"></div>
				<div class="main-banner">						
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
							<div class="swiper-slide">
								<img src="resources/img/banner-1.jpg" />
								<div class="mab-text">
									<div class="mb-box">
										<div class="mab-title">�۰�</div>
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
								<li><a href="#"><img src="resources/img/icon-4.png" /> <span>�ŷ����</span></a></li>
								<li><a href="#"><img src="resources/img/icon-5.png" /> <span>�۰����</span></a></li>
								<li><a href="#"><img src="resources/img/icon-6.png" /> <span>��ǰ���</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			
			<!-- ������϶� -->
			<div class="contents mo-nav">
				<nav>
					<li><a href="#">Deal</a></li>
					<li><a href="#">Megazine</a></li>
					<li><a href="#">Artist Library</a></li>
					<li><a href="#">About</a></li>
				</nav>
			</div>
			
			<!-- ���� ���� -->
			<div class="contents bg-1">
				<div class="da-snm">
					<ul class="">
						<li>
							<img src="resources/img/img-1.png" />
							<p class="da-p1">������ �ŷ�</p>
							<p class="da-p2 pc-on">������Ʈ�� ���� �ŷ���<br/>�����մϴ�.</p>
							<p class="da-p2 ta-on">������Ʈ�� ����<br/>�ŷ��� �����մϴ�.</p>
						</li>
						<li>
							<img src="resources/img/img-2.png" />
							<p class="da-p1">�������</p>
							<p class="da-p2 pc-on">��� ���� ��Ȳ��<br/>�ǽð����� Ȯ���ϼ���.</p>
							<p class="da-p2 ta-on">��� ���� ��Ȳ��<br/>�ǽð����� Ȯ���ϼ���.</p>
						</li>
						<li>
							<img src="resources/img/img-3.png" />
							<p class="da-p1">�¶��� ����</p>
							<p class="da-p2 pc-on">���ŷο� ��ǰ �ŷ�. �� �̻�<br/>���� ������ �ʿ䰡 �����ϴ�.</p>
							<p class="da-p2 ta-on">���ŷο� ��ǰ �ŷ�<br/>�����ϰ� �����Ͻÿ�.</p>
						</li>
						<li>
							<img src="resources/img/img-4.png" />
							<p class="da-p1">������ ������</p>
							<p class="da-p2 pc-on">�������� �̼�ǰ �ŷ� ������<br/>��ǰ�� �����߽��ϴ�.</p>
							<p class="da-p2 ta-on">�������� �̼�ǰ �ŷ�<br/>��ǰ�� �����߽��ϴ�.</p>
						</li>
						<li>
							<img src="resources/img/img-5.png" />
							<p class="da-p1">����Ź� ���</p>
							<p class="da-p2 pc-on">�������� ���ε� �ϸ�<br/>������Ʈ���� �Է��� �帳�ϴ�.</p>
							<p class="da-p2 ta-on">�������� ���ε� �ϸ�<br/>������ �Է��� �帳�ϴ�.</p>
						</li>
					</ul>
				</div>
			</div>
			
			<!-- hotest deal �������� -->
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
										<h4>�۰���</h4>
										<div class="hd-d1">��ǰ��(2021)<br/>���� Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">������ 3,700,000 ��</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>�۰���</h4>
										<div class="hd-d1">��ǰ��(2021)<br/>���� Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">������ 3,700,000 ��</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>�۰���</h4>
										<div class="hd-d1">��ǰ��(2021)<br/>���� Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">������ 3,700,000 ��</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>�۰���</h4>
										<div class="hd-d1">��ǰ��(2021)<br/>���� Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">������ 3,700,000 ��</div>
									</div>
								</a>
							</div>
							<div class="swiper-slide">
								<a class="hd-div">
									<img src="resources/img/imgs.png" class="hd-img" />
									
									<div class="hd-text">
										<h4>�۰���</h4>
										<div class="hd-d1">��ǰ��(2021)<br/>���� Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">������ 3,700,000 ��</div>
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
			
			<!-- ���� ���� ���� / ������ ���� -->
			<div class="contents max-1500">
				<div class="cont-title">
					<h3>���� ���� ���� / ������ ����</h3>
					<!-- <a href="#" class="ct-more mo-no"><img src="img/icon-p.jpg" /><span>more</span></a> -->
				</div>
				<div class="cns-div">
					<div class="columns-wrap" id="columns">
						<figure class="item">
							<img src="resources/img/img-1.jpg">
							<a class="hd-div2">								
								<div class="hd-text">
									<h4>�۰���</h4>
									<div class="hd-tc">
										<div class="hd-d1">��ǰ��(2021)<br/>���� Oil & Canvas, 72.7x90.9cm</div>
										<div class="hd-d2">������ 3,700,000 ��</div>
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
						<li><a href="#">��ž��</a></li>
						<li><a href="#">�¶��ΰ�ž��</a></li>
						<li><a href="#">��������ó����ħ</a></li>
						<li><a href="#">����������������</a></li>
					</ul>
					<div class="footer-icon">
						<a href="#"><img src="resources/img/sns-f.jpg" /></a>
						<a href="#"><img src="resources/img/sns-t.jpg" /></a>
						<a href="#"><img src="resources/img/sns-i.jpg" /></a>
					</div>
				</div>
				
				<div class="pc-on">
					<div class="footer-text">��ȣ : MANSION9  ��ǥ : �̿���  ����ڵ�ι�ȣ : 473-81-01206[���������Ȯ��]</div>
					<div class="footer-text">
						<ol>
							<li>�ּ� : 04075 ����Ư���� ������ ������ 11�� 60(�����)1F</li>
							<li>��ǥ��ȣ : 070-4267-7371</li>
							<li>�ѽ���ȣ : 02-336-2920</li>
						</ol>
					</div>
					<div class="footer-text">
						<ol>
							<li>����Ǹž� �Ű� : �� 2019-���︶��-1063ȣ</li>
							<li>������������å���� : �̿���(privacy@mainsion9.co.kr</li>
							<li>�̸��� : cafe24@mainsion9.co,kr</li>
						</ol>
					</div>
				</div>
				
				
				<div class="tb-on max-100">
					<div class="footer-text">��ȣ : MANSION9<br/>��ǥ : �̿���  ����ڵ�ι�ȣ : 473-81-01206[���������Ȯ��]</div>
					<div class="footer-text">
						<ol>
							<li class="dib af-dn">�ּ� : 04075 ����Ư���� ������ ������ 11�� 60(�����)1F</li>
							<li class="">��ǥ��ȣ : 070-4267-7371</li>
							<li class="af-dn">�ѽ���ȣ : 02-336-2920</li>
						</ol>
					</div>
					<div class="footer-text">
						<ol>
							<li class="af-dn">����Ǹž� �Ű� : �� 2019-���︶��-1063ȣ</li>
							<li>������������å���� : �̿���(privacy@mainsion9.co.kr �̸��� : cafe24@mainsion9.co,kr</li>
						</ol>
					</div>
				</div>
				
				<div class="mo-on max-100">
					<div class="footer-text">��ȣ : MANSION9<br/>��ǥ : �̿���</div>
					<div class="footer-text">
						<ol>
							<li class="dib af-dn">�ּ� : 04075 ����Ư���� ������ ������ 11�� 60(�����)1F</li>
							<li class="dib af-dn">��ǥ��ȣ : 070-4267-7371</li>
							<li class="af-dn">�ѽ���ȣ : 02-336-2920</li>
							<li class="af-dn">�̸��� : cafe24@mainsion9.co,kr</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		
	</div>


<!-- ��ް˻� -->
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
				<!-- �˻���ư Ŭ���� -->
				<div class="search-show">
					<div class="sea-box">
						<img src="resources/img/w-logo.jpg" class="sea-img" />
						
						<div class="sea-won">
							<!-- <div class="select-box">
								<select>
									<option>�۰���</option>
								</select>
							</div> -->
							<input type="text" class="" />
							<a href="#"><img src="resources/img/icon-2.jpg" /></a>
						</div>
						<div class="ta-h3">
							<h3 class="sea-h3">��ǰ</h3>
							<a href="#"><span>more</span></a>
						</div>
						<ul class="sea-text">
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
						</ul>
						<div class="ta-h3">
							<h3 class="sea-h3">�۰�</h3>
							<a href="#"><span>more</span></a>
						</div>
						<ul class="sea-text">
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
							<li><a href="#">text</a></li>
						</ul>
						<div class="ta-h3">
							<h3 class="sea-h3">������</h3>
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
      
      
      
      /* �޴��� FIXED */
      if (jQuery(window).width() > 0) {
          jQuery(window).on("scroll",function(ev){
              if(jQuery(window).scrollTop() > 80 ) { /* �ش� ���̸� ����� fixed Ŭ���� �߰� */
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

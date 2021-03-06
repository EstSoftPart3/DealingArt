<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<style>
    	.head-wrap{border-bottom:#e9e9e9 1px solid;}
    </style>
</head>

<body>
	<div class="wrap">
		<jsp:include page="/WEB-INF/views/fo/main/header.jsp"></jsp:include>
		<div class="body-wrap">
		
			<ul class="nav nav-pills ait-nav" id="pills-tab" role="tablist">
				<li class="nav-item active">
					<a class="nav-link" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">작가프로필보기</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">작품보기</a>
				</li>
			</ul>
			<div class="tab-content ait-tab" id="pills-tabContent">
				<div class="tab-pane fade active in tab-pane1" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
				
					<div class="contents max-1500">
						<div class="cont-title3 mg-at">
							<h3>Artist library</h3>
						</div>
						
						<div class="ad-sty">
							<div class="ad-user"><img src="resources/img/icon/user-2.png" /></div>
							<div class="ad-text">
								<h3>이 용은</h3>
								<h4>Lee Yongeun</h4>
								<p>
									이용은 작가는 사람들이 가진 고유의 향기를 매화 꽃으로 비유한다. 깨달은 사람을 뜻하는 ‘향 코끼리’는 작가만의 “꽃끼리(flowerphant)”로 새롭게 표현된다. 동양화를 전공한 작가는 코끼리의 ‘겹’을 구겨진 한지에 먹을 묻혀 표현하여 인생을 담아내고, 배경에 금을 많이 사용하여 ‘복’의 뜻을 더하는 등 의미를 더욱 풍부하게 담는다. 다채로운 배경의 팝적인 요소가 가미된 작품들은 올바른 깨달음을 나누고 원하는 색채의 삶을 만드는 긍정적 효과를 기대하였다면, 금박이 배경이 된 작품은 더 나아가 원하는 소망을 이룰 수 있다는 믿음이 더해진다.
									작가는 꽃과 코끼리를 대조되는 친숙한 두 소재를 동서양의 물감을 다르게 바르는 등 조화롭게 풀어내어 독창적인 ‘꽃끼리’를 만들어 냈으며, 인간이 살면서 목표하는 진리에 더 가깝게 다가갈 수 있도록 도와준다.
									다양한 방법으로 이상향을 담는 이용은 작가의 작품은 지속적인 발전을 통해 단단해지고 있어 앞으로의 성장이 더 기대된다.
								</p>
							</div>
							
							<dl class="ad-dl">
								<dt>SNS</dt>
								<dd>
									<a href="#" class="if-img"><img src="resources/img/icon/i-1.png" /></a>
									<a href="#" class="if-img"><img src="resources/img/icon/i-2.png" /></a>
									<a href="#" class="if-img"><img src="resources/img/icon/i-3.png" /></a>
									<a href="#" class="if-img"><img src="resources/img/icon/i-4.png" /></a>
									<a href="#" class="if-img"><img src="resources/img/icon/i-5.png" /></a>
									<a href="#" class="if-img"><img src="resources/img/icon/i-6.png" /></a>
								</dd>
							</dl>
							<dl class="ad-dl">
								<dt>홈페이지</dt>
								<dd>
									<p>https://mansion9.co.kr/</p>
								</dd>
							</dl>
							<dl class="ad-dl">
								<dt>학력</dt>
								<dd>
									<p>2018 동국대학교 대학원 미술학과 한국화전공 석사 졸업</p>
									<p>2015 동국대학교 미술학부 졸업</p>
									<p>2010 선화예술고등학교 졸업</p>
								</dd>
							</dl>
							<dl class="ad-dl">
								<dt>경력</dt>
								<dd>
									<p>2021 상상하다, 맨션나인 방배</p>
									<p>2021 A flowerphant in the garden, 유니온아트스페이스</p>
									<p>2021 시작부터 지금까지, 뮤지엄 남해</p>
									<p>2020 꽃끼리 Flower_phant, 갤러리 라이프</p>
									<p>2019 이용은개인전, KBS 시청자갤러리</p>
									<p>2019 꽃끼리, 서진아트스페이스</p>
									<p>2018 이용은 전, 갤러리 일호</p>
								</dd>
							</dl>
							<dl class="ad-dl">
								<dt>전시 정보</dt>
								<dd>
									<p>2018 想象 전, 블러프 퍼블릭 갤러리 주</p>
									<p>2017 꽃끼리, 불일미술관</p>
									<p>2022 MANSION9 LIV-ing ART : New year, 현대리바트 용산</p>
									<p>2021 MANSION9 LIV-ing ART : In Your Life, 현대리바트 용산</p>
									<p>2021 MANSION9 Emerging Artist NATURE & POP, 대전 신세계</p>
									<p>2021 아트플렉스마켓, 충무로갤러리</p>
									<p>2021 MANSION9 Emerging Artist with SHINSEGAE, 신세계 타임스퀘어</p>
									<p>2021 MANSION9 Emerging Artist with SHINSEGAE, 신세계 경기</p>
									<p>2021 MANSION9 Emerging Artist with SHINSEGAE, 신세계 강남</p>
									<p>2021 아트도산, 꼴라보하우스</p>
									<p>2021 젊은작가특별전, 금산갤러리</p>
									<p>2021 Passion week, 맨션나인 상수</p>
									<p>2021 RE; CREATION, 공간와디즈</p>
									<p>2021 POP IN UNTACT, 비움갤러리</p>
									<p>2021 새해선물전, 비움갤러리</p>
									<p>2020 우리 만날까요?, 뱅커스 갤러리</p>
									<p>2020 동시대의 비상, 금보성아트센터</p>
									<p>2020 Trendy Sensibility, 로운아뜨리움</p>
									<p>2020 붓다의 향기, 동덕아트갤러리</p>
									<p>2020 제5,6회 신진작가 작품구입 공모전시, 미누현대미술관</p>
									<p>2020 NEXT PRESENT 갤러리포월스</p>
									<p>2020 50전, 비움갤러리</p>
								</dd>
							</dl>
							<dl class="ad-dl">
								<dt>수상</dt>
								<dd>
									<p>2020 Fly High, 충무로갤러리</p>
									<p>2019 크리스마스 아트마켓, 갤러리오</p>
									<p>2019 Falling in Animal, 비움갤러리</p>
									<p>2019 취하다 아트페어, 프로타주갤러리</p>
									<p>2019 be coming a collector, 연희예술극장</p>
									<p>2019 이원생중계, 갤러리라메르</p>
								</dd>
							</dl>
							<dl class="ad-dl">
								<dt>인터뷰영상</dt>
								<dd>
									<p>https://youtu.be/bRY2uftc9pQ</p>
									<p>https://youtu.be/bRY2uftc9pQ</p>
								</dd>
							</dl>
							<dl class="ad-dl">
								<dt>논문, 평론, 기사</dt>
								<dd>
									<p>2014 동심을 깨우는 강한 숨결 전, 전북대학교 국립 박물관</p>
									<p>2013 50만원 전, 경민미술관</p>
									<p>2013 가미갤러리 초대작가전, 가미갤러리</p>
									<p>2013 블라블라, 인사토포하우스</p>
								</dd>
							</dl>
							
							<button type="button" class="the-more2 mg_t60" data-toggle="modal" data-target="#myModal">더보기</button>
						</div>
					</div>
				
				</div>
				<div class="tab-pane fade tab-pane2" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
					
					<div class="reds-box ati-reds">
						<ul class="pc-on">
							<li>
								<a href="#" class="down-on">
									제작년도
								</a>
							</li>
							<li>
								<a href="#" class="">
									가격
								</a>
							</li>
						</ul>
					</div>
					
					<div>
						<div class="columns-wrap2" id="columns2">
							
							<figure class="item">
								<div class="item-div-img">
									<img src="resources/img/icon/bg-2.png" class="items">
								</div>
							</figure>
							<figure class="item">
								<div class="item-div-img">
									<img src="resources/img/icon/bg-3.png" class="items">
								</div>
							</figure>
							<figure class="item">
								<div class="item-div-img">
									<img src="resources/img/icon/bg-3.png" class="items">
								</div>
							</figure>
							<figure class="item">
								<div class="item-div-img">
									<img src="resources/img/icon/bg-2.png" class="items">
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
		
		<jsp:include page="/WEB-INF/views/fo/main/header.jsp"></jsp:include>
		
	</div>


<!-- 모달검색 -->
<!-- Modal -->
<!-- 거래 등록 전 꼭! 확인하세요 -->
<div class="modal fade modal-s" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-baeg max-w1200">
		<div class="modal-content">
			<div class="modal-header" style="padding: 0;min-height: 0;">
				<div class="baegs">
				    <div class="close" data-dismiss="modal" aria-label="Close"><img src="resources/img/ba/icon-end.png" /></div>
				</div>

			</div>
			<div class="modal-body pd60 h850-o">
				<div class="ad-text">
					<h3>이 용은</h3>
					<h4>Lee Yongeun</h4>
					<p>
						이용은 작가는 사람들이 가진 고유의 향기를 매화 꽃으로 비유한다. 깨달은 사람을 뜻하는 ‘향 코끼리’는 작가만의 “꽃끼리(flowerphant)”로 새롭게 표현된다. 동양화를 전공한 작가는 코끼리의 ‘겹’을 구겨진 한지에 먹을 묻혀 표현하여 인생을 담아내고, 배경에 금을 많이 사용하여 ‘복’의 뜻을 더하는 등 의미를 더욱 풍부하게 담는다. 다채로운 배경의 팝적인 요소가 가미된 작품들은 올바른 깨달음을 나누고 원하는 색채의 삶을 만드는 긍정적 효과를 기대하였다면, 금박이 배경이 된 작품은 더 나아가 원하는 소망을 이룰 수 있다는 믿음이 더해진다.
						작가는 꽃과 코끼리를 대조되는 친숙한 두 소재를 동서양의 물감을 다르게 바르는 등 조화롭게 풀어내어 독창적인 ‘꽃끼리’를 만들어 냈으며, 인간이 살면서 목표하는 진리에 더 가깝게 다가갈 수 있도록 도와준다.
						다양한 방법으로 이상향을 담는 이용은 작가의 작품은 지속적인 발전을 통해 단단해지고 있어 앞으로의 성장이 더 기대된다.
					</p>
				</div>
				
				<dl class="ad-dl">
					<dt>SNS</dt>
					<dd>
						<a href="#" class="if-img"><img src="resources/img/icon/i-1.png" /></a>
						<a href="#" class="if-img"><img src="resources/img/icon/i-2.png" /></a>
						<a href="#" class="if-img"><img src="resources/img/icon/i-3.png" /></a>
						<a href="#" class="if-img"><img src="resources/img/icon/i-4.png" /></a>
						<a href="#" class="if-img"><img src="resources/img/icon/i-5.png" /></a>
						<a href="#" class="if-img"><img src="resources/img/icon/i-6.png" /></a>
					</dd>
				</dl>
				<dl class="ad-dl">
					<dt>홈페이지</dt>
					<dd>
						<p>https://mansion9.co.kr/</p>
					</dd>
				</dl>
				<dl class="ad-dl">
					<dt>학력</dt>
					<dd>
						<p>2018 동국대학교 대학원 미술학과 한국화전공 석사 졸업</p>
						<p>2015 동국대학교 미술학부 졸업</p>
						<p>2010 선화예술고등학교 졸업</p>
					</dd>
				</dl>
				<dl class="ad-dl">
					<dt>경력</dt>
					<dd>
						<p>2021 상상하다, 맨션나인 방배</p>
						<p>2021 A flowerphant in the garden, 유니온아트스페이스</p>
						<p>2021 시작부터 지금까지, 뮤지엄 남해</p>
						<p>2020 꽃끼리 Flower_phant, 갤러리 라이프</p>
						<p>2019 이용은개인전, KBS 시청자갤러리</p>
						<p>2019 꽃끼리, 서진아트스페이스</p>
						<p>2018 이용은 전, 갤러리 일호</p>
					</dd>
				</dl>
				<dl class="ad-dl">
					<dt>전시 정보</dt>
					<dd>
						<p>2018 想象 전, 블러프 퍼블릭 갤러리 주</p>
						<p>2017 꽃끼리, 불일미술관</p>
						<p>2022 MANSION9 LIV-ing ART : New year, 현대리바트 용산</p>
						<p>2021 MANSION9 LIV-ing ART : In Your Life, 현대리바트 용산</p>
						<p>2021 MANSION9 Emerging Artist NATURE & POP, 대전 신세계</p>
						<p>2021 아트플렉스마켓, 충무로갤러리</p>
						<p>2021 MANSION9 Emerging Artist with SHINSEGAE, 신세계 타임스퀘어</p>
						<p>2021 MANSION9 Emerging Artist with SHINSEGAE, 신세계 경기</p>
						<p>2021 MANSION9 Emerging Artist with SHINSEGAE, 신세계 강남</p>
						<p>2021 아트도산, 꼴라보하우스</p>
						<p>2021 젊은작가특별전, 금산갤러리</p>
						<p>2021 Passion week, 맨션나인 상수</p>
						<p>2021 RE; CREATION, 공간와디즈</p>
						<p>2021 POP IN UNTACT, 비움갤러리</p>
						<p>2021 새해선물전, 비움갤러리</p>
						<p>2020 우리 만날까요?, 뱅커스 갤러리</p>
						<p>2020 동시대의 비상, 금보성아트센터</p>
						<p>2020 Trendy Sensibility, 로운아뜨리움</p>
						<p>2020 붓다의 향기, 동덕아트갤러리</p>
						<p>2020 제5,6회 신진작가 작품구입 공모전시, 미누현대미술관</p>
						<p>2020 NEXT PRESENT 갤러리포월스</p>
						<p>2020 50전, 비움갤러리</p>
					</dd>
				</dl>
				<dl class="ad-dl">
					<dt>수상</dt>
					<dd>
						<p>2020 Fly High, 충무로갤러리</p>
						<p>2019 크리스마스 아트마켓, 갤러리오</p>
						<p>2019 Falling in Animal, 비움갤러리</p>
						<p>2019 취하다 아트페어, 프로타주갤러리</p>
						<p>2019 be coming a collector, 연희예술극장</p>
						<p>2019 이원생중계, 갤러리라메르</p>
					</dd>
				</dl>
				<dl class="ad-dl">
					<dt>인터뷰영상</dt>
					<dd>
						<p>https://youtu.be/bRY2uftc9pQ</p>
						<p>https://youtu.be/bRY2uftc9pQ</p>
					</dd>
				</dl>
				<dl class="ad-dl">
					<dt>논문, 평론, 기사</dt>
					<dd>
						<p>2014 동심을 깨우는 강한 숨결 전, 전북대학교 국립 박물관</p>
						<p>2013 50만원 전, 경민미술관</p>
						<p>2013 가미갤러리 초대작가전, 가미갤러리</p>
						<p>2013 블라블라, 인사토포하우스</p>
					</dd>
				</dl>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/fo/main/footer.jsp"></jsp:include>
</div>

<script type="text/javascript">
      


      
      $(window).on("resize", function () {
	   	    if(window.matchMedia('(min-width: 1537px)').matches)
	   	    {
	   	    	document.querySelectorAll(".item").forEach((item) => {
		       	     item.style.gridRowEnd = `span ${item.clientHeight + 20}`;
		       	  });
		       	  const wrap = document.querySelector(".columns-wrap2");
		       	  wrap.style.display = "grid";
		       	  wrap.style.gridTemplateColumns = "repeat(auto-fill, 465px)";
		       	  wrap.style.gridAutoRows = "1px";
		       	  
	   	    	
	   	    	
	   	    }  else if(window.matchMedia('(min-width: 751px)').matches) {
	   	    		       	
	   	    	 
	   	    	$(window).click(function () {
	   	    		clearTimeout(timer);
	   	     		timer = setTimeout(function(){			    		
	   	     		document.querySelectorAll(".item").forEach((items) => {
	   	         		items.style.gridRowEnd = `span ${items.clientHeight + 243}`;
	   	         	});

	   	         	const wrap = document.querySelector(".columns-wrap2");
	   	         	wrap.style.display = "grid";
	   	         	wrap.style.gridTemplateColumns = "repeat(auto-fill, 65rem)";
	   	         	wrap.style.gridAutoRows = "1px";
	   	     	}, 200);
	   	    	});
		       	  
			       	
	   	    	
	   	     } else {
	       	
	   	    	$(window).click(function () {
	   	    		clearTimeout(timer);
	   	     		timer = setTimeout(function(){			    		
	   	     		document.querySelectorAll(".item").forEach((items) => {
	   	         		items.style.gridRowEnd = `span ${items.clientHeight + 20}`;
	   	         	});

	   	         	const wrap = document.querySelector(".columns-wrap2");
	   	         	wrap.style.display = "grid";
	   	         	wrap.style.gridTemplateColumns = "repeat(auto-fill, )";
	   	         	wrap.style.gridAutoRows = "1px";
	   	     	}, 200);
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
      
      
      var delay = 300;
      var timer = null;

      //Javascript
      window.addEventListener('resize', function(){
      	clearTimeout(timer);
      	timer = setTimeout(function(){
      		document.location.reload();
      	}, delay);
      	
      	document.querySelectorAll(".item").forEach((item) => {
      	   item.style.gridRowEnd = `span ${item.clientHeight + 20}`;
      	});
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

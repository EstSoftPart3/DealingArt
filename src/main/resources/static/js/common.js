$(window).on("resize", function () {
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
	   	        
	   	        }).resize();
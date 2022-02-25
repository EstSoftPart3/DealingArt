/*
*********************************************************************************************************
* 함수설명	: 리사이즈
* str	: 
* ch    :  
***********************************************************************************************************
*/

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
	   	        
	   	        
// Trim 함수 ##################################################
// Ex) str = "    테 스트   ".trim(); => str = "테 스트";
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

// 문자열 공백제거 함수 ##################################################
// Ex) str = "    테 스   트   ".stripspace(); => str = "테스트";
String.prototype.stripspace = function() {
 return this.replace(/ /g, "");
}

// 전체 문자열 바꾸기 함수 ##################################################
// Ex) str = "a테스트bcd테스트efg".replaceAll("테스트", ""); => str = "abcdefg";
String.prototype.replaceAll = function(a, b) {
 var s = this;
 var n1, n2, s1, s2;

 while (true) {
  if ( s=="" || a=="" ) break;
  n1 = s.indexOf(a);
  if ( n1 < 0 ) break;
  n2 = n1 + a.length;
  if ( n1==0 ) {
   s1 = b;
  }
  else {
   s1 = s.substring(0, n1) + b;
  }
  if ( n2 >= s.length ) {
   s2 = "";
  }
  else {
   s2 = s.substring(n2, s.length);
  }
  s = s1 + s2;
 }
 return s;
}

/*
*********************************************************************************************************
* 함수설명	: 문자열에서 특정문자를 제거한 새로운 문자열을 만든다.
* str	: 문자열
* ch    : 제거할 문자
***********************************************************************************************************
*/
function delChar(str, ch){

 var len = str.length;
 var ret = "";
 
 //문자열에서 ch 문자를 제거한다. 예) ,  - 등등
 for (i=0; i<len; ++i)
 {
  if (str.substring(i,i+1) != ch)
   ret = ret + str.substring(i,i+1);
 }
 
 return ret;
}

/*
*********************************************************************************************************
* 함수설명		: 숫자를 세자리마다 컴마를 찍은 형식으로 바꾸어 준다.
* argStr	: argument
***********************************************************************************************************
*/
function formatComma(argStr){

 if (argStr == null)  return;
 var argStr = argStr + ""; //숫자인 경우 문자열로 변환
 var rule = /[^0-9-.]/g;  // 숫자, 부호 및 소수점 이외의 데이터 제거

 argStr = getFilledCommaStr(argStr.replace(rule, ""));
 return argStr;
}


/*
*********************************************************************************************************
* 함수설명  	: 숫자에 천단위로 ','를 붙여서 반환
* argNumber	: 숫자
***********************************************************************************************************
*/
function getFilledCommaStr(argNumber) {

        argNumber = argNumber.toString();

        if (isEmpty(argNumber))  return argNumber;

        // 숫자 항목에서 부호(-), 소수점(.) 체크
        var sourceStr = trim(argNumber);
        var signStr   = ""
        var dotStr    = "";


        if (sourceStr.substring(0, 1) == "-") {
            signStr   = "-";
            sourceStr = sourceStr.substring(1, sourceStr.length);
        }
        if (sourceStr.indexOf(".") >= 0) {
            dotStr    = sourceStr.substring(sourceStr.indexOf("."), sourceStr.length);
            sourceStr = sourceStr.substring(0, sourceStr.indexOf("."));
        }

        var sourceLen = sourceStr.length;
        var filledStr = "";
        var checkIdx  = 0;

        for (var idx = sourceLen - 1; idx >= 0; idx--) {
            if (checkIdx++ % 3 == 0 && idx != sourceLen -1) {
                filledStr = "," + filledStr;
                checkIdx = 1;
            }
            filledStr = sourceStr.substring(idx, idx + 1) + filledStr;
        }
        return signStr + filledStr + dotStr;
}

// 팝업 ##################################################
function openPopup(theURL, winName, width, height, remFeatures) {
 var features = "";
 if (typeof winName == "undefined") winName = "";
 if (typeof width != "undefined") features += ((features) ? "," : "")+"width="+width;
 if (typeof height != "undefined") features += ((features) ? "," : "")+"height="+height;
 if (typeof remFeatures != "undefined") features += ((features) ? "," : "")+remFeatures;
 if (features.indexOf("status") < 0) features += ",status=yes";

 var popup = window.open(theURL, winName, features);
 popup.focus();

 return popup;
}

// 팝업 - 팝업창 화면중앙 오픈 ##################################################
function openPopupCenter(theURL, winName, width, height, remFeatures) {
 var left = (screen.width/2) - (width/2);
 var top = (screen.availHeight/2) - (height/2);
 var features = "left="+left+",top="+top+",width="+width+",height="+height;
 if (typeof winName == "undefined") winName = "";
 if (typeof remFeatures != "undefined") features += ","+remFeatures;
 if (features.indexOf("status") < 0) features += ",status=yes";

 var popup = window.open(theURL, winName, features);
 popup.focus();

 return popup;
}

// 팝업 - 팝업창 사이즈 조정 ##################################################
function resizePopupWindow_browser(width, height)
{
 var reWidth = width ;
 var reHeight = height ;
 var appname;
 var  useragent;
 var IE55,IE6,IE7,IE8;
 appname = navigator.appName;
 useragent = navigator.userAgent;
 if(appname == "Microsoft Internet Explorer") appname = "IE";
  IE55 = (useragent.indexOf('MSIE 5.5')>0);  //5.5 버전
  IE6  = (useragent.indexOf('MSIE 6')>0);     //6.0 버전
  IE7  = (useragent.indexOf('MSIE 7')>0);     //7.0 버전
  IE8  = (useragent.indexOf('MSIE 8')>0);     //8.0 버전
 if(appname=="IE")
 {
  if(IE55){reWidth = width;reHeight = height ;}
  if(IE6) {reWidth = width;reHeight = height - 22;}
  if(IE7) {reWidth = width;reHeight = height - 22;}
  if(IE8) {reWidth = width;reHeight = height ;}
 }
 resizePopupWindow(reWidth,reHeight)
}


function resizePopupWindow(width, height) {
 var strAgent = navigator.userAgent.toLowerCase();
 var bIE7 = (strAgent.indexOf("msie 7.0") != -1);
 window.resizeTo(width+10, height+(bIE7 ? 69 : 49));
}

// 팝업 - 팝업창 위치 조정 ##################################################
function movePopupWindow(left, top) {
 window.moveTo(left, top);
}

// 페이지 이동 ##################################################
function gotoUrl(url) {
 if (url.stripspace() != "") {
  location.href = url;
 }
}

// 페이지 최상단으로 ##################################################
function goTop() {
 window.scrollTo(0, 0);
}

// 체크박스 전체선택 ##################################################
function checkCbAll(cbList, isChecked) {
 if (cbList) {
  if (typeof(cbList.length) == "undefined") {
   if (!cbList.disabled) cbList.checked = isChecked;
  }
  else {
   for (var i=0; i<cbList.length; i++) {
    if (cbList[i].type.toUpperCase() == 'CHECKBOX') {
     if (cbList[i].value.stripspace() != "" && !cbList[i].disabled) {
      cbList[i].checked = isChecked;
     }
    }
   }
  }
 }
}

// 텍스트 길이 확인 (일반) ##################################################
function checkTextLen(obj, mLen) {
 if (obj.value.length > mLen){
  alert("1~"+mLen+"자까지 입력이 가능합니다.");
  obj.value = obj.value.substring(0, mLen);
  obj.focus();
  return false;
 }

 return true;
}

// 텍스트 길이 확인 (Byte) ##################################################
function checkTextLenByte(obj, mLen) {
 var i, len;
 var byteLen = 0;
 var value = obj.value;

 for (i=0, len=value.length; i<len; i++) {
  ++byteLen;

  if ((value.charCodeAt(i) < 0) || (value.charCodeAt(i) > 127)) ++byteLen;

  if (byteLen > mLen) {
   alert("1~"+(mLen / 2)+"자의 한글, 또는 2~"+mLen+"자의 영문, 숫자, 문장기호로 입력이 가능합니다.");
   obj.value = value.substring(0, i);
   obj.focus();
   return false;
  }
 }

 return true;
}
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
* 함수설명  	: 문자열에서 특정문자를 다른 문자로 치환한 새로운 문자열을 만든다.
* str    	: 문자열
* oldChar   : 바꾸기 전의 문자
* newChar   : 바꿔서 넣을 문자
***********************************************************************************************************
*/
function replace(str,oldChar,newChar){
    var oldstr="";
    while(oldstr!=str){
     oldstr=str;
     str=str.replace(oldChar,newChar);
    }
 return str;
}

/*
*********************************************************************************************************
* 함수설명	: 문자열에서 왼쪽의 공백을 제거한다.
* str   : 문자열
***********************************************************************************************************
*/
function lTrim(str){
  var i;
  i = 0;
  while (str.substring(i,i+1) == ' ' || str.substring(i,i+1) == '　')  i = i + 1;
  return str.substring(i);
}

/*
*********************************************************************************************************
* 함수설명	: 문자열에서 오른쪽의 공백을 제거한다.
* str	: 문자열
***********************************************************************************************************
*/
function rTrim(str){

  var i = str.length - 1;
  while (i >= 0 && (str.substring(i,i+1) == ' ' || str.substring(i,i+1) == '　')) i = i - 1;
  return str.substring(0,i+1);
}

/*
*********************************************************************************************************
* 함수설명	: 문자열에서 양쪽의 공백을 제거한다.
* str	: 문자열
***********************************************************************************************************
*/
function trim(str){

    if( str == "" || str.length ==0 ) 
    {
      return str; 
    } 
    else
    {
      return(lTrim(rTrim(str)));
    }   
}

 

//오른쪽에 ch 문자 채우기
/*
*********************************************************************************************************
* 함수설명	 : 문자열을 정해진 길이만큼 오른쪽을 특정 문자로 채운다.
* str    : 문자열
* len    : 총길이
***********************************************************************************************************
*/
function rPadString(str, ch, len){

 var strlen = trim(str).length;
 var ret = "";
 var alen = len - strlen;
 var astr = ""; 
 
 //부족한 숫자만큼  len 크기로 ch 문자로 채우기
 for (i=0; i<alen; ++i)
 {
  astr = astr + ch;
 }
 
 ret = trim(str) + astr; //뒤에서 채우기
 return ret;
}

/*
*********************************************************************************************************
* 함수설명	 : 문자열을 정해진 길이만큼 왼쪽을 특정 문자로 채운다.
* str	 : 문자열
* len    : 총길이
***********************************************************************************************************
*/
function lPadString(str, ch, len){

 var strlen = trim(str).length;
 var ret = "";
 var alen = len - strlen;
 var astr = ""; 
 
 
 //부족한 숫자만큼  len 크기로 ch 문자로 채우기
 for (i=0; i<alen; ++i)
 {
  astr = astr + ch;
 }
 
 ret = astr + trim(str); //앞에서 채우기
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

/*
*********************************************************************************************************
* 함수설명	 : 날짜형식으로 년,월,일 사이에 구분자를 넣어준다.
* str    : 날짜가 YYMMDD형식으로 담겨있는 문자열
* mark   : 년,월,일 사이에 들어갈 구분자
***********************************************************************************************************
*/
function formatDate(str,mark){

 if(str != "" && str.length == 8) {
  return str.substring(0,4)+mark+str.substring(4,6)+mark+str.substring(6,8);
 }  else {
  return "";
 }
}

/* 
****************************************************************************************************
* 함수설명	: 입력란을 오늘날짜로 채워준다.
* field	: html에서 name으로 지정된 입력필드의 명
****************************************************************************************************
*/
function setToday(field){

 var cDate=new Date();
 var year=cDate.getYear();
 var month=(cDate.getMonth()+1).toString();
 month=month.length==1?"0"+month:month;
 var day=cDate.getDate().toString();
 day=day.length==1?"0"+day:day;
 field.value="" +year+month+day;
}

/* 
****************************************************************************************************
* 함수설명	: 입력란을 이번달의 첫날로 채워준다..
* field : html에서 name으로 지정된 입력필드의 명
****************************************************************************************************
*/
function setMonthFirstDay(field){

 var cDate=new Date();
 var year=cDate.getYear();
 var month=(cDate.getMonth()+1).toString();
 month=month.length==1?"0"+month:month;
    var day="01";
 field.value="" +year+month+day;
}

/* 
****************************************************************************************************
* 함수설명	: 입력란을 올해 1월1일로 채워준다.
* field	: html에서 name으로 지정된 입력필드의 명
****************************************************************************************************
*/
function setYearFirstDay(field){


    var cDate=new Date();
    var year=cDate.getYear();
    var month="01";
    var day="01";
    field.value="" +year+month+day;
}

/* 
****************************************************************************************************
* 함수설명	: 입력란을 오늘보다 한달전의 날짜로 채워준다..
* field : html에서 name으로 지정된 입력필드의 명
****************************************************************************************************
*/
function setOneMonthBefore(field){

 var cDate=new Date();
 var year=cDate.getYear();
 var month=(cDate.getMonth()).toString();
 month=month.length==1?"0"+month:month;
 if (month=="00"){
  month="12";
  year--;
 }
 var day=cDate.getDate().toString();
 day=day.length==1?"0"+day:day;
 field.value="" +year+month+day;
}

/* 
****************************************************************************************************
* 함수설명	: 입력란을 오늘보다 1년전의 날짜로 채워준다..
* field : html에서 name으로 지정된 입력필드의 명
****************************************************************************************************
*/
function setOneYearBefore(field){
    
 var cDate=new Date();
 var year=cDate.getYear()-1;
 var month=(cDate.getMonth()+1).toString();
 month=month.length==1?"0"+month:month;
 var day=cDate.getDate().toString();
 day=day.length==1?"0"+day:day;
 field.value="" +year+month+day;
}

/*
***********************************************************************************************************
* 함수설명	: 문자열이 빈문자열 혹은 공백만 있는 문자열이지 검사한다.
* str	: 문자열
***********************************************************************************************************
*/
function isEmpty(str){
    
 if (trim(str) == ''|| trim(str) == null) return true;
 return false;

}

/*
***********************************************************************************************************
* isEmptyMessage(param1,param2) 
* 해당 객체의 값이 null 또는 빈값인지 검사한다.
* obj     : 검사할 객체
* message : 검사후 null 이나 빈값일경우 보여줄 message
***********************************************************************************************************
*/
function isEmptyMessage(obj, message){
	var varObj = obj.value;
	if(trim(varObj) == '' || trim(varObj) == null){
		alert(message);
		obj.focus();
		return false;
	}
	return true;
}

/*
*********************************************************************************************************
* 함수설명	: 문자열이 특정문자열을 포함하고 있는지 체크한다.
* str   : 특정문자 포함여부를 체크할 대상 문자열
* ch    : 지정된 특정문자
***********************************************************************************************************
*/
function isContains(str,ch){
    
     var i=0;
     for(i=0;i < str.length;i++){
     if(str.charAt(i)==ch) return true;
     }
     return false;
}

/*
*********************************************************************************************************
* 함수설명	: 해당문자열이 지정된 문자들만을 포함하고 있는지 검사한다.
* str	: 검사할 문자열
* chars	: 지정된 문자들의 나열
***********************************************************************************************************
*/   
function isContainsOnly(str,chars) {
      
    for (var inx = 0; inx < str.length; inx++) {
       if (chars.indexOf(str.charAt(inx)) == -1)
       return false; 
    }
    return true;
}

/*
*********************************************************************************************************
* 함수설명		: 문자열의 글자수체크를 한다. checkInputLength 등의 함수 내에서 호출된다.
* StrName	: 글자수 체크를 할 문자열의 한글명칭. 에러 메시지 출력 시에 사용한다.
* str    	: 글자 수 체크를 할 문자열
* maxLen    : 해당 필드의 최대글자수 (한글2,영문1)
***********************************************************************************************************
*/
function isUnderMaxLen(strName,str , maxLen){
    
     var i, len=0;
     var korLen = maxLen / 2;
     
     for(i=0;i < str.length; i++) (str.charCodeAt(i) > 255)? len+=2:len++;
     if (maxLen < len) {
      alert(strName + "은(는) 영문(숫자)"+maxLen+"자, 한글"+korLen+"자까지만 가능합니다. 현재 글자수(영문기준) : "+len);
      return false;
     }
     return true;
}

 
/*
*********************************************************************************************************
* 함수설명	: 지정하는 년,월,일이 달력상으로 존재하는 날짜인지 검사한다.
* year  : 년
* month : 월
* day   : 일
***********************************************************************************************************
*/     
function isValidDay(year, month, day) {
    
    var m = parseInt(month,10) - 1;
    var d = parseInt(day,10);

    var end = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        end[1] = 29;
    }

    return (d >= 1 && d <= end[m]);
}

/* 
****************************************************************************************************
* 함수설명				: 한글2,영문숫자1을 기준으로 입력란의 글자수(byte)를 검사한다.
* fieldCalledName	: 글자수 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객
****************************************************************************************************
*/
function checkInputLength(fieldCalledName,field,maxLen){
    
    
 if(field.value != ""){

  if(isContains(field.value,"'")) {
      alert(" ' 문자는 허용되지 않습니다.");
      field.focus(); 
   field.value=delChar(field.value,"'");
            field.select();
      return false;
  } 

  if(!isUnderMaxLen(fieldCalledName,field.value,maxLen)) {
      field.focus(); 
      field.value=field.value.substring(0,maxLen); 
      return false;
  }
 }
  
 return true;
}

/* 
****************************************************************************************************
* 함수설명				: 입력란에 숫자만이 입력되는지 체크한다.
* fieldCalledName 	: 글자수 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객체
****************************************************************************************************
*/
function checkInputNumber(fieldCalledName,field){
    
 if(field.value != ""){
  if(!isContainsOnly(field.value, "0123456789")) {
    alert(fieldCalledName + "은(는) 숫자외의 문자열을 입력할 수 없습니다.");
  field.focus(); 
  field.value=field.value.substring(0,field.value.length-1); 
  return false;
  }
 }
    return true;
}

/* 
****************************************************************************************************
* 함수설명				: 입력란에 최종적으로 적합한 범위내의 숫자가 들어왔는지 검사한다.
* fieldCalledName 	: 글자수 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객체
* min    			: 최소값
* max    			: 최대값
****************************************************************************************************
*/
function checkNumber(fieldCalledName,field,min,max){

 field.value=trim(field.value);
 if(!checkInputNumber(fieldCalledName,field)) {
  return false;
 }

 var fieldNumber=parseInt(field.value);
 if ( !(fieldNumber>=min && fieldNumber<=max) )
 {
  alert(fieldCalledName+"의 값이" + parseInt(field.value)+ "로 [" + min + " ~ " + max + "] 사이의 범위를 벗어나 있습니다.");
  field.focus();
  return false;
 }
    return true;
}

/* 
****************************************************************************************************
* 함수설명				: 최종적으로 입력된 날짜가 적합한지를 검사한다.
* fieldCalledName	: 글자수 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객체
* 사용예  <input type='text' name='test3' onBlur="javascript:checkDate('시작일',this);" >
****************************************************************************************************
*/
function checkDate(fieldCalledName,field){
    
 field.value=trim(field.value);    
 if(!checkInputNumber(fieldCalledName,field)) {
  return false;
 }
 var year = field.value.substring(0, 4);
 var month = field.value.substring(4, 6);
 var day = field.value.substring(6,8);
 //alert(year+"년 "+month+"월 "+day+"일");

    if (year < 1900 || year >2037){
        alert('날짜가 잘못 입력되었습니다. 년도는 1900년에서 2037년까지 입니다.');
  field.select(); 
        return false;
    }
    if (month <1 || month > 12){
        alert('날짜가 잘못 입력되었습니다. 달은 1월에서 12월까지 입니다.');
  field.select(); 
        return false;
    }
    if (day < 1 ||  !isValidDay(year, month,day)){
        alert('날짜가 잘못 입력되었습니다. '+ year+ "년 " +month+'월에는 '+ day+'일이 없습니다.');
  field.value=field.value.substring(0,field.value.length-2);
  field.select();         
        return false;
    } 
 return true;

}

/* 
****************************************************************************************************
* 함수설명		: 최종적으로 입력된 시작일과 종료일 두 날짜가 적합한지를 검사한다.
* fromField : 시작일자 입력란의 필드 객체
* ToField   : 종료일자 입력란의 필드 객체
* 사용예  <input type='text' name='test3' onBlur="javascript:checkDate('시작일',this);" >
****************************************************************************************************
*/
function checkDateFromTo(fromField,toField){
    
 if(!checkDate("시작일자",fromField) || !checkDate("종료일자",toField) ) {
 return false;
 }
 else if(fromField.value > toField.value){
 alert("시작일자가 종료일자보다 큽니다");
 fromField.focus();
 fromField.select(); 
 return false; 
 }
 return true;

}

/* 
****************************************************************************************************
* 함수설명				: 필수적으로 입력되어야 하는 입력란이 비어있지거나 공백 밖에 있지 않은지 검사한다.
* fieldCalledName 	: 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객체
* 사용예  <input type='text' name='test3' onBlur="javascript:checkDate('시작일',this);" >
****************************************************************************************************
*/
function checkNotEmpty(fieldCalledName,field){
    
    if(isEmpty(field.value))
    {
     alert(fieldCalledName+"은(는) 필수적으로 입력되어야 하는 값이므로 비워두면 안 됩니다");
     field.focus();
     field.select();
     return false;
    }
    return true;
}
/* 
****************************************************************************************************
* 함수설명	: 해당필드가 주민등록번호로 적합한지 검사를 한다.
* field : html에서 name으로 지정된 입력필드 객체
* 사용예 	:  <input type="text" value="" name='RCN' maxlength=13 onBlur="javascript:checkRCN(this);"
     		onkeyup="javascript:checkInputNumber('주민등록번호',this);">
*                   최종제출값 검사 스크립트에도 포함
****************************************************************************************************
*/
function checkRCN(field){
    
 field.value=trim(field.value);
 if(!checkInputNumber("주민등록번호",field)) return false;  // 숫자로만 이루어 있지 않으면 부적합
 if(field.value.length!=13) {        // 글자수가 13자리가 아니라면 부적합
  alert("주민등록번호 자리수가 모자랍니다."); 
        field.focus();
        field.select();
  return false;
 }

 var sex = field.value.substring(6,7); 

 if(!isContainsOnly(sex,"1234")) { 
  alert("주민등록번호 8번째 자리의 성별표시가 맞지 않습니다."); 
        field.focus();
        field.select();
  return false;
 } 
 

 var year = field.value.substring(0, 2);
 var month = field.value.substring(2, 4);
 var day = field.value.substring(4,6);

 
 if ( sex=="1" || sex=="2" ) year="19"+year;
 if ( sex=="3" || sex=="4" ) year="20"+year;

 // alert(year+"년 "+month+"월 "+day+"일" + "성별코드은 "+ sex);

    if (!isValidDay(year, month,day)){       // 앞자리의 생년월일 체크
        alert("주민등록번호 앞의 생년월일 부분이 잘못되었습니다. "+ year+ "년 " +month+"월 "+ day+"일이라는 날은 존재하지 않습니다.");
        field.focus();
        field.select();
        return false;
        }

 var mappingMulti=[2,3,4,5,6,7,8,9,2,3,4,5];
 var mustLastDigit=0;
 for (var i=0;i<12;i++)
 {
  mustLastDigit+= parseInt(field.value.substring(i,i+1))*mappingMulti[i];
 }
 mustLastDigit= (11-mustLastDigit%11)%10;
 if (field.value.substring(12,13)!=mustLastDigit) {   //주민등록번호 마지막자리 검사
  alert("유효한 주민등록번호가 아닙니다."); 
        field.focus();
        field.select();
  return false; 
 }
 return true;
}

/* 
****************************************************************************************************
* 함수설명				: 텍스트의 필수입력여부체크와 길이체크를 같이 한다.
* fieldCalledName 	: 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객체
* maxlen    		: 허용되는 글자의 최대길이
* notNull   		: 필수입력 필드인지의 여부(true,false)
* 사용예  <input type='text' name='test3' onBlur="javascript:checkTogetherText('테스트필드',this,10,true);"
   		onkeyup="javascript:checkInputNumber('테스트필드',this);" >
****************************************************************************************************
*/
function checkTogetherText(fieldCalledName,field,maxLen,notNull){

 field.value=trim(field.value);
    
    if ( ( notNull==true) && checkNotEmpty(fieldCalledName,field) && checkInputLength(fieldCalledName,field,maxLen) ) {
     return true;
    }
 
 if( (notNull==false)&& checkInputLength(fieldCalledName,field,maxLen) ) {
     return true; 
 }
 return false;

}

/*
****************************************************************************************************
* 함수설명				: 해당 필드의 필수입력여부체크와 숫자의 범위체크를 같이 한다.
* fieldCalledName 	: 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객체
* min    			: 허용되는 숫자의 최소값
* max    			: 허용되는 숫자의 최대값
* notNull   		: 필수입력 필드인지의 여부(true,false)
* 사용예  <input type='text' name='test3' onBlur="javascript:checkTogetherNumber('테스트필드',this,10,100,true);"
   onkeyup="javascript:checkInputNumber('테스트필드',this);" >
****************************************************************************************************
*/ 
function checkTogetherNumber(fieldCalledName, field,min,max,notNull) {
    

    if ( ( notNull==true) && checkNotEmpty(fieldCalledName,field) && checkNumber(fieldCalledName,field,min,max)) {
     return true;
    }
    if ( notNull==false) {
     if(isEmpty(field.value) || (checkNumber(fieldCalledName,field,min,max)) ) return true;
    }
    
    return false;
}

/* 
****************************************************************************************************
* 함수설명				: 날짜의 필수입력여부체크와 적합성 체크를 같이 한다.
* fieldCalledName 	: 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field    			: html에서 name으로 지정된 입력필드 객체
* notNull   		: 필수입력 필드인지의 여부(true,false)
* 사용예  <input type='text' name='test3' onBlur="javascript:checkTogetherText('테스트필드',this,true);"
   onkeyup="javascript:checkInputNumber('테스트필드',this);" >
****************************************************************************************************
*/   
function checkTogetherDate(fieldCalledName, field, notNull){
    
    
    if ( ( notNull==true) && checkNotEmpty(fieldCalledName,field) && checkDate(fieldCalledName,field)) {
     return true;
    }
    if ( notNull==false) {
     if(isEmpty(field.value) || (checkDate(fieldCalledName,field)) ) return true;
    }
    
    return false;
}


/* 
****************************************************************************************************
* 함수설명				: 필드 이름을 기준으로 최종적으로 입력된 시작일과 종료일 두 날짜의 짝들이 적합한지를 검사한다.
* from_field_name  	: 시작일자 입력란의 필드명을 나타내는 문자열
* to_field_name  	: 종료일자 입력란의 필드명을 나타내는 문자열
****************************************************************************************************
*/ 
function checkDatesFromTo(from_field_name, to_field_name) {

    
 var from_fields = document.getElementsByName(from_field_name);
 var to_fields = document.getElementsByName(to_field_name);

 for(var i=0; i<from_fields.length; i++) {
  if(!checkDateFromTo(from_fields[i], to_fields[i])) return false
 }
 return true;
}


/* 
****************************************************************************************************
* 함수설명			: 해당필드가 주민등록번호로 적합한지 검사를 한다.
* field_name   	: html에서 name으로 지정된 입력필드명을 나타내는 문자열
****************************************************************************************************
*/ 
function checkRCNs(field_name) {
    
 var fields = document.getElementsByName(field_name); 
 for(var i=0; i<fields.length; i++) {
  //if(!checkRCNs(fields[i])) return false
  if(!checkRCN(fields[i])) return false
 }
 return true;
}

/* 
****************************************************************************************************
* 함수설명				: 해당 필드명을 가진 텍스트필드들의  필수입력여부체크와 길이체크를 같이 한다.
* fieldCalledName 	: 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field_name   		: html에서 name으로 지정된 입력필드명을 나타내는 문자열
* maxlen    		: 허용되는 글자의 최대길이
* notNull   		: 필수입력 필드인지의 여부(true,false)
****************************************************************************************************
*/
function checkTogetherTexts(fieldCalledName, field_name, maxLen, notNull) {


 var fields = document.getElementsByName(field_name); 
 for(var i=0; i<fields.length; i++) {
  if(!checkTogetherText(fieldCalledName, fields[i], maxLen, notNull)) return false
 }
 return true;
}

/* 
****************************************************************************************************
* 함수설명				: 해당 필드명을 가진 필드들의 필수입력여부체크와 길이체크를 같이 한다.
* fieldCalledName 	: 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field_name   		: html에서 name으로 지정된 입력필드명을 나타내는 문자열
* min    			: 허용되는 숫자의 최소값
* max    			: 허용되는 숫자의 최대값
* notNull   		: 필수입력 필드인지의 여부(true,false)
****************************************************************************************************
*/
function checkTogetherNumbers(fieldCalledName, field_name, min, max, notNull) {
    
 var fields = document.getElementsByName(field_name); 
 for(var i=0; i<fields.length; i++) {
  if(!checkTogetherNumber(fieldCalledName, fields[i], min, max, notNull)) return false
 }
 return true;
}

/* 
****************************************************************************************************
* 함수설명				: 해당 필드명을 가진 필드들의 필수입력여부체크와 날짜 적합성 체크를 같이 한다.
* fieldCalledName	: 체크를 할 입력필드의 한글명칭. 에러 메시지 출력 시에 사용한다.
* field_name   		: html에서 name으로 지정된 입력필드명을 나타내는 문자열
* notNull   		: 필수입력 필드인지의 여부(true,false)
****************************************************************************************************
*/   
function checkTogetherDates(fieldCalledName, field_name, notNull) {

 var fields = document.getElementsByName(field_name); 
 for(var i=0; i<fields.length; i++) {
  if(!checkTogetherDate(fieldCalledName, fields[i], notNull)) return false
 }
 return true;
}

/* 
****************************************************************************************************
* 함수설명			: 정해진 두 날짜 사이에 어느 날짜가 속하는지 검사한다.
* checkField    : 검사를 할 필드
* fromDate    	: 시작일자를 나타낸 문자열
* ToDate    	: 종료일자를 나타낸 문자열
****************************************************************************************************
*/
function checkDateWithin(checkField,fromDate,toDate){
     
 
 if  ( (fromDate>checkField.value) || (checkField.value>toDate )) {
     alert("날짜가 적절한 범위를 벗어났습니다."); 
     checkField.focus();
     checkField.select(); 
     return false;
 }
 else return true;

}

/* 
****************************************************************************************************
* 함수설명					: 시작일과 종료일의 짝들이 큰 범위의 시작일과 종료일의 범위에 속하는지를 검사한다.
* innerFromField_name 	: 작은 범위의 시작일 필드이름을 나타내는 문자열. 예를 들면 수감별 감사시작일 입력 필드의 이름.
* innerToField_name 	: 작은 범위의 종료일 필드이름을 나타내는 문자열. 예를 들면 수감별 감사종료일 입력 필드의 이름.
* outerFromField  		: 큰 범위의 시작일 필드객체. 예를 들면 전체 감사기간의 시작일 필드 객체
* outerToField  		: 큰 범위의 종료일 필드객체. 예를 들면 전체 감사기간의 종료일 필드 객체
* 사용예    (스크립트 내에서)
* if(!checkDatesInOut("aud_sdate", "aud_edate", document.all.tot_aud_sdate,document.all.tot_aud_edate)) return false;
****************************************************************************************************
*/
function checkDatesInOut(innerFromField_name,innerToField_name, outerFromField,outerToField){
 
 if(!checkDateFromTo(outerFromField, outerToField)) return false;
 
 var innerFromFields = document.getElementsByName(innerFromField_name); 
 var innerToFields = document.getElementsByName(innerToField_name);  

 for(var i=0; i<innerToFields.length; i++) {
 if(!checkDateFromTo(innerFromFields[i], innerToFields[i])) return false;
 if(!checkDateWithin(innerFromFields[i],outerFromField.value, outerToField.value)) return false;
 if(!checkDateWithin(innerToFields[i],outerFromField.value, outerToField.value)) return false;
 } 
 return true;
}

/*
*********************************************************************************************************
* 함수설명	: 날짜에 해당하는 분기를 반환한다.
* date	: YYYYMMDD
***********************************************************************************************************
*/
function getQuartetFromDate(date){

 if(date.substring(5,7) == "01") {
  date = date.substring(0,4) + "년 " + " 1/4분기";
 } else if(date.substring(5,7) == "04") {
  date = date.substring(0,4) + "년 " + " 2/4분기";
 } else if(date.substring(5,7) == "07") {
  date = date.substring(0,4) + "년 " + " 3/4분기";
 } else if(date.substring(5,7) == "10") {
  date = date.substring(0,4) + "년 " + " 4/4분기";
 } else {
  date = date.substring(0,4) + "년 ";
 }
 return date;
}

/* 
********************************************************************************************************* 
* 함수설명	: 문자열에서 문자간의 공백을 제거한다. 
* str	: 문자열 
*********************************************************************************************************** 
*/ 
function perfactTrim(val){ 
       var rtnVal = ""; 
       var len = val.length; 
 
       for(var i=0;i<len;i++){ 
         if(val.substring(i, i+1) != " "){ 
          rtnVal = rtnVal + val.substring(i, i+1);  
         } 
       } 
       
       return rtnVal; 
}  

/*
***************************************************************************************
* 파일 용량 체크하기
* <form>
* <input type=file name="filename" onChange="getFileSize(this.value,this.name)">
* </form>
* <img name=tmp width=0 height=0>
***************************************************************************************
*/
function getFileSize(url,name)
{
 tmp.dynsrc = url;
 if (tmp.fileSize > 8388608)
 {
  alert ("8M 이상은 안되요");
  document.getElementById(name).value = "";
 }
}


/* ---------------------------------------------
 * 함수명 : checkSpecialChar
 * 설  명 : 특수문자 체크
 * 예) if(!checkSpecialChar()) return;
 ---------------------------------------------*/
function checkSpecialChar(_obj){
    if(_obj.value.search(/[\",\',<,>]/g) >= 0) {
        alert("문자열에 특수문자( \",  ',  <,  > )가 있습니다.\n특수문자를 제거하여 주십시오!");
        _obj.select();
        _obj.focus();
    }
}

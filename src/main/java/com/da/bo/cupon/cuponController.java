package com.da.bo.cupon;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class cuponController {
	@RequestMapping("/admin/cuponnum")
	public void couponnum(){
		//실행시 ???개 쿠폰 생성  
		int couponSize = 1;
		final char[] possibleCharacters =
				{'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F',
			'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
			'W','X','Y','Z'};
		
		final int possibleCharacterCount = possibleCharacters.length;
		String[] arr = new String[couponSize];
		Random rnd = new Random();
		int currentIndex = 0;
		int i = 0;
		while (currentIndex < couponSize) {
			StringBuffer buf = new StringBuffer(16);
			//i는 8자리의 랜덤값을 의미   
			for (i= 16; i > 0; i--) {
				buf.append(possibleCharacters[rnd.nextInt(possibleCharacterCount)]);
			}
			String couponnum = buf.toString();
			String cuponNum = couponnum.substring(0, 4)+"-"+couponnum.substring(4, 8)+"-"+couponnum.substring(8, 12)+"-"+couponnum.substring(12, 16);
			System.out.println("cuponNum==>"+cuponNum);
			arr[currentIndex] = cuponNum;
			currentIndex++;
		}
	}
}

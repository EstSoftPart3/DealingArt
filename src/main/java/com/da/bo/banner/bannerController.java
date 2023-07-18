package com.da.bo.banner;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.bo.service.*;
import com.da.fo.service.MainService;

@Controller
public class bannerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	bannerService bannerService;

	@Autowired
	MainService mainService;

	// 배너관리 목록 페이지 이동
	@RequestMapping("/admin/banner/bannerList")
	public String openBannerList(HttpServletRequest req) {

		return "bo/banner/bannerList";
	}

	// 배너 등록 페이지
	@RequestMapping("/admin/banner/bannerWrite")
	public String writeBanner(HttpServletRequest req) {
		return "bo/banner/bannerWrite";
	}

	// 배너정보
	@RequestMapping("/admin/banner/bannerInsertData")
	@ResponseBody
	public void BannerInsertData(@RequestParam Map<String, Object> param) {
		System.out.println("=======테스트======");
		System.out.println(param);

	}


	
	// 미리보기 팝업테스트
	@RequestMapping("/admin/banner/brPreview")
	public String openPopup(@RequestParam Map<String, Object> param) {
		String bnrTypCd = (String) param.get("bnrTypCd");
		System.out.println("=======openPop테스트======");
		System.out.println(param);
		param.put("bnrTypCd", bnrTypCd);
		return "bo/banner/bannerWrite";
	}


	//메인 
	@RequestMapping("/admin/banner/mainPopup")
	public String mainPopup() {
		return "thymeleaf/index";
	}
	
	
	// 매거진미리보기-인사이트
	@RequestMapping("/admin/banner/mgzPopup")
	public String mgzInPopup() {
		return "thymeleaf/fo/mgz/insights";
	}
	
	// 매거진미리보기-미디어
	@RequestMapping("/admin/banner/media")
	public String mgzMdPopup() {
		return "thymeleaf/fo/mgz/media";
	}
	
	// 매거진미리보기-Exhibition
	@RequestMapping("/admin/banner/exhibition")
	public String mgzExPopup() {
		return "thymeleaf/fo/mgz/exhibition";
	}
	
	//메인화면 데이터 가져오기
	@RequestMapping("/admin/banner/main/mainData")
	@ResponseBody
	public ModelAndView brmainData(@RequestParam @Nullable Map<String, Object> param) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		result = mainService.openMain(param);
		mv.addObject("brmainData", result);

		return mv;
	}

}

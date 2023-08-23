package com.da.fo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.AboutService;

@Controller
public class AboutController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AboutService aboutService;
	
	
	@RequestMapping("/about/serviceIntro")
	public String serviceIntro() {
		return "thymeleaf/fo/about/serviceIntro";
	}
	
	@RequestMapping("/about/notice")
	public String notice() {
		return "thymeleaf/fo/about/notice";
	}
	
	
	@RequestMapping("/about/customerService")
	public String customerService() {
		return "thymeleaf/fo/about/customerService";
	}
	
	//이용약관
	@RequestMapping("/about/termOfService")
	public String openTermOfService() {
		return "thymeleaf/fo/about/terms_1";
	}
	
	//개인정보취급방침
	@RequestMapping("/about/privacyPolicy")
	public String openPrivacyPolicy() {
		return "thymeleaf/fo/about/terms_2";
	}
	
	//마케팅및광고
	@RequestMapping("/about/marketing")
	public String openMarketing() {
		return "thymeleaf/fo/about/terms_3";
	}
	/*
	 * 게시판 목록 조회
	 * PARAM : BRD_TYP_CD = #{brdTypCd}
			NT - 공지사항
			FA - faq
	 * RETURN : 게시판 목록
	 */
	@RequestMapping("/about/selectBrdList")
	@ResponseBody
	public ModelAndView selectBrdList(@RequestParam(value = "brdTypCd", required = true) String brdTypCd,@RequestParam(value = "brdConTypCd", required = true) String brdConTypCd) {
		ModelAndView mv = new ModelAndView("jsonView");
		logger.debug("############# brdTypCd : " + brdTypCd);
		
		List result = aboutService.selectBrdList(brdTypCd,brdConTypCd);
		mv.addObject("result", result);
		return mv;
	}
	
	
	/*
	 * 게시판 상세 조회
	 * PARAM : BRD_SQ = #{brdSq}
	 * RETURN : 게시판 상세
	 */
	@RequestMapping("/about/selectBrdDtl")
	@ResponseBody
	public ModelAndView selectBrdDtl(@RequestParam(value = "brdSq", required = true) String brdSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		logger.debug("############# brdSq : " + brdSq);
		
		Map<String, Object> result = aboutService.selectBrdDtl(brdSq);
		mv.addObject("result", result);
		return mv;
	}
}

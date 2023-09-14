package com.da.fo.controller;

import java.util.HashMap;
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

import com.da.fo.service.Mgz9Service;

@Controller
public class Mgz9Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Mgz9Service mgz9Service;
	
	//매거진9 메인 페이지
	@RequestMapping("/mgz9/magazine9_main")
	public String magazine9Main() {
		return "thymeleaf/fo/mgz/magazine9_main";
	}
	
	//매거진9 메인 모바일 페이지
	@RequestMapping("/mgz9/magazine9_mainMobile")
	public String magazine9MainMobile() {
		return "thymeleaf/fo/mgz/magazine9_main_mo";
	}
	
	@RequestMapping("/mgz9/insights")
	public String openInsights() {
		return "thymeleaf/fo/mgz/insights";
	}
	
	@RequestMapping("/mgz9/media")
	public String openMedia() {
		return "thymeleaf/fo/mgz/media";
	}
	
	@RequestMapping("/mgz9/exhibition")
	public String openExhibition() {
		return "thymeleaf/fo/mgz/exhibition";
	}
	
	@RequestMapping("/mgz9/artist")
	public String openArtist() {
		return "thymeleaf/fo/mgz/magazine9_artist";
	}

	/*
	 * MGZ9 목록 조회
	 * PARAM : 
		#MGZ_TYP_CD
			IST - INSIGHTS
			MDA - MEDIA
			EBI - EXHIBITION
	 * RETURN : MGZ9 목록
	 */
	@RequestMapping("/mgz9/selectMgz9List")
	@ResponseBody
	//public ModelAndView selectMgz9List(@RequestParam(value = "mgzTypCd", required = true) String mgzTypCd) {
	public ModelAndView selectMgz9List(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		int pagestart = Integer.parseInt((String) param.get("pagestart"));
		int page = Integer.parseInt((String) param.get("page"));
		String mgzTypCd = (String) param.get("mgzTypCd");
		
		
		param.put("pagestart", pagestart);
		param.put("page", page);
		param.put("mgzTypCd", mgzTypCd);
		
		result = mgz9Service.selectMgz9List(param);
		
		mv.addObject("list", result);
		
		return mv;
	}
	
	/*
	 * MGZ9 상세 조회
	 * PARAM : MGZ_SQ
	 * RETURN : MGZ9 상세
	 */
	@RequestMapping("/mgz9/selectMgz9Dtl")
	@ResponseBody
	public ModelAndView selectMgz9Dtl(@RequestParam(value = "mgzSq", required = true) String mgzSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		//logger.debug("############# mgzSq : " + mgzSq);
		
		Map<String, Object> result = mgz9Service.selectMgz9Dtl(mgzSq);
		mv.addObject("result", result);
		return mv;
	}
	
}

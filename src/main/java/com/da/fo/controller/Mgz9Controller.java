package com.da.fo.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.Put;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.Mgz9Service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

@Controller
public class Mgz9Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Mgz9Service mgz9Service;
	
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
	
	/* 통합 검색 */
	/*
	 * @RequestMapping("/mgz9/result")
	 * 
	 * @ResponseBody public ModelAndView result(@RequestParam Map<String, Object>
	 * param) { String currentNum = (String)param.get("currentNum");
	 * System.out.println("################################## : " + currentNum); if
	 * (currentNum == null) { currentNum = "1"; } int searchedCount =
	 * mgz9Service.count(param); int postNum = 10; int indexNum =
	 * (Integer.parseInt(currentNum) - 1) * postNum; int totalPage =
	 * (int)Math.ceil((double)searchedCount/postNum); param.put("postNum", postNum);
	 * param.put("indexNum", indexNum); int startNum = Integer.parseInt(currentNum)
	 * - ((Integer.parseInt(currentNum) - 1) % 10); int endNum = Math.min(startNum +
	 * 9, totalPage); List<Map<String, Object>> result = mgz9Service.result(param);
	 * ModelAndView mv = new ModelAndView("jsonView"); mv.addObject("result",
	 * result); mv.addObject("searchedCount", searchedCount);
	 * mv.addObject("totalPage", totalPage); mv.addObject("startNum", startNum);
	 * mv.addObject("endNum", endNum); return mv; }
	 */
	
	/* 검색 */
	@RequestMapping("/mgz9/search")
	@ResponseBody
	public ModelAndView search(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");		
		/* 전체 게시글 수 */
		int totalCount = mgz9Service.count((String)param.get("keyword"));
		
		/* 화면에 표시될 페이지 수 */
		int postNum = 12;
		
		/* 전체 페이지 수 */
		int totalNum = (int)Math.ceil((double)totalCount/postNum);
		
		/* 현재 페이지 번호 */
		String currentNum = (String)param.get("currentNum");
		if(currentNum == null) {
			currentNum = "1";
		}
		
		/* 페이지 시작 번호 */
		int startNum = Integer.parseInt(currentNum) - ((Integer.parseInt(currentNum) - 1) % 10);
		
		/* 페이지 끝 번호 */
		int endNum = Math.min(startNum + 9, totalNum);
		
		/* 인덱스 번호 */
		int indexNum = (Integer.parseInt(currentNum) - 1) * postNum;
		param.put("indexNum", indexNum);
		param.put("postNum", postNum);		
		mv.addObject("totalCount", totalCount);
		mv.addObject("result", mgz9Service.search(param));
		mv.addObject("totalNum", totalNum);
		mv.addObject("currentNum", Integer.parseInt(currentNum));
		mv.addObject("startNum", startNum);
		mv.addObject("endNum", endNum);
		return mv;
	}
	
	/* 알파벳 검색 */
	@RequestMapping("/mgz9/alphabet")
	@ResponseBody
	public ModelAndView alphabet(@RequestParam Map<String, Object> param) {		
		ModelAndView mv = new ModelAndView("jsonView");
		String currentNum = (String)param.get("currentNum");
		if(currentNum == null) {
			currentNum = "1";
		}
		int totalCount = mgz9Service.alphabetCount((String)param.get("keyword"));
		int postNum = 12;
		int indexNum = (Integer.parseInt(currentNum) - 1) * postNum;
		int totalNum = (int)Math.ceil((double)totalCount/postNum);
		int startNum = Integer.parseInt(currentNum) - ((Integer.parseInt(currentNum) - 1) % 10);
		int endNum = Math.min(startNum + 9, totalNum);
		param.put("indexNum", indexNum);
		param.put("postNum", postNum);
		List<Map<String, Object>> result = mgz9Service.alphabet(param);
		mv.addObject("result", result);
		mv.addObject("currentNum", Integer.parseInt(currentNum));
		mv.addObject("totalCount", totalCount);
		mv.addObject("totalNum", totalNum);
		mv.addObject("startNum", startNum);
		mv.addObject("endNum", endNum);
		return mv;
	}
	
	/* 한글 자음 검색 */
	@RequestMapping("/mgz9/korean")
	@ResponseBody
	public ModelAndView korean(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int totalCount = mgz9Service.koreanCount((String)param.get("keyword"));
		int postNum = 12;
		int totalNum = (int)Math.ceil((double)totalCount/postNum);
		String currentNum = (String)param.get("currentNum");
		if(currentNum == null) {
			currentNum = "1";
		}
		int indexNum = (Integer.parseInt(currentNum) - 1) * postNum;
		int startNum = Integer.parseInt(currentNum) - ((Integer.parseInt(currentNum) - 1) % 10);
		int endNum = Math.min(startNum + 9, totalNum);
		param.put("indexNum", indexNum);
		param.put("postNum", postNum);
		mv.addObject("result", mgz9Service.korean(param));
		mv.addObject("currentNum", Integer.parseInt(currentNum));
		mv.addObject("totalCount", totalCount);
		mv.addObject("totalNum", totalNum);
		mv.addObject("startNum", startNum);
		mv.addObject("endNum", endNum);
		return mv;
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

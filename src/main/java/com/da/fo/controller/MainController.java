package com.da.fo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.da.fo.service.DealService;
import com.da.fo.service.MainService;


@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private DealService dealService;
	
	@RequestMapping("/main")
	public String openMain() {
		return "thymeleaf/index";
	}
	
	@RequestMapping("/main/mainData")
	@ResponseBody
	public ModelAndView mainData(@RequestParam @Nullable Map<String, Object>  param) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		Map<String, Object> result = new HashMap<>();
		result = mainService.openMain(param);
		mv.addObject("mainData", result);
		
		return mv;
	}
	
	@RequestMapping("/fileUpload")
	public String openfileUpload() {
		return "fo/main/fileUpload";
	}
	
	//네이버 SEO
	@RequestMapping("/naver31b27d248ba6c35c148f71e04a92cef6.html")
	public String naverSeoHtml() {
		return "thymeleaf/naver31b27d248ba6c35c148f71e04a92cef6.html";
	}
	
	//구글 SEO
	@RequestMapping("/sitemap.xml")
	public String googleSeoXml() {
		return "thymeleaf/sitemap.xml";
	}
	
	@RequestMapping("/totalSearch_artist")
	@ResponseBody
	public ModelAndView totalSearchArtist(@RequestParam(value="searchKeyword", required = false) String searchKeyword) {
		ModelAndView mv = new ModelAndView("thymeleaf/result_artist");
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> artstList = mainService.totalSearchArtist(searchKeyword);
		result.put("artstList", artstList);
		if(artstList.size() > 0) {
			result.put("totalCount", artstList.size());
		}else {
			result.put("totalCount", 0);
		}
		result.put("searchKeyword", searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/totalSearch_work")
	@ResponseBody
	public ModelAndView totalSearchWork(@RequestParam(value="searchKeyword", required = false) String searchKeyword) {
		ModelAndView mv = new ModelAndView("thymeleaf/result_work");
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> param = new HashMap<>();
		param.put("searchKeyword", searchKeyword);
		param.put("startRow", 0);
		List<Map<String, Object>> workList = mainService.totalSearchWork(param);
		int totalCount = mainService.totalSearchWorkTotalCount(param);
		result.put("workList", workList);
		if(totalCount > 0) {
			result.put("totalCount", totalCount);
		}else {
			result.put("totalCount", 0);
		}
		result.put("sort", null);
		result.put("type", null);
		result.put("searchKeyword", searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/totalSearch_content")
	@ResponseBody
	public ModelAndView totalSearchContent(@RequestParam(value="searchKeyword", required = false) String searchKeyword) {
		ModelAndView mv = new ModelAndView("thymeleaf/result_content");
		Map<String, Object> result = new HashMap<>();
		List<Map<String, Object>> contentList = mainService.totalSearchContent(searchKeyword);
		result.put("contentList", contentList);
		result.put("searchKeyword", searchKeyword);
		result.put("totalCount", contentList.size());
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/totalSearchAutocomplete")
	@ResponseBody
	public ModelAndView totalSearchAutocomplete(@RequestParam String searchKeyword) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> result = mainService.totalSearchAutocomplete(searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/totalSearch_work/searchOptions")
	public String totalSearchWorkSearchOptions(Model model, @RequestBody Map<String, Object> param) {
		Map<String,Object> result = new HashMap<>();
		int page = Integer.parseInt(param.get("page").toString());
		int startRow = ((page-1)*6+1);
		if(page == 1){
			startRow = 0;
		}
		param.put("startRow", startRow);
		List<Map<String, Object>> workList = mainService.totalSearchWork(param);
		int totalCount = mainService.totalSearchWorkTotalCount(param);
		result.put("workList", workList);
		if(totalCount > 0) {
			result.put("totalCount", totalCount);
		}else {
			result.put("totalCount", 0);
		}
		result.put("sort", param.get("sort"));
		result.put("type", param.get("type"));
		result.put("workList", workList);
		result.put("searchKeyword", param.get("searchKeyword"));
		model.addAttribute("result", result);
		System.out.println("result:"+result);
		return "thymeleaf/result_work :: fragment-resultWork";
	}
}

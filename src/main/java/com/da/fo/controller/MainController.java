package com.da.fo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/main_2")
	public String openMain2() {
		return "thymeleaf/da_main";
	}
	
	@RequestMapping("/main_3")
	public String openMain3() {
		return "thymeleaf/main";
	}
	
	//로그인 페이지
	@RequestMapping("/main/mlogin")
	public String openLogin() {
		return "thymeleaf/index";
	}
	
	//오픈 이벤트 이벤트 랜딩
//	@RequestMapping("/event")
//	public String openEvent() {
//		return "thymeleaf/fo/event/event_v1";
//	}
	
	@RequestMapping("/event")
	public String openEvent() {
		return "thymeleaf/fo/event/event_v2";
	}
	
	//회원가입 본인인증
	@RequestMapping("/main/joinStep1")
	public String openJoinStep1() {
		return "thymeleaf/fo/member/join_1";
	}
	
	@RequestMapping("/evening")
	public String openLanding1006() {
		return "thymeleaf/fo/landing/1006/index";
	}
	
	
	//회원가입 본인인증
	@RequestMapping("/main/joinStep2")
	public String openJoinStep2() {
		return "thymeleaf/fo/member/join_2";
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
	
	//페이스북 SEO
	@RequestMapping("/bgotqya9tcsrgrmspnq0uywh85kjzh.html")
	public String faceBookSeoHtml() {
		return "thymeleaf/bgotqya9tcsrgrmspnq0uywh85kjzh.html";
	}
	
	@RequestMapping("/naver6e452542a97ecbfc50130958195020e5.html")
	public String naverSeoHtml2() {
		return "thymeleaf/naver6e452542a97ecbfc50130958195020e5.html";
	}
	
	//robot
	@RequestMapping("/robots.txt")
	public String robotSeo() {
		return "thymeleaf/robots.txt";
	}
	
	//구글 SEO
	@RequestMapping("/sitemap.xml")
	public String googleSeoXml() {
		return "thymeleaf/sitemap.xml";
	}
	
	@RequestMapping("/main/totalSearch_artist")
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
	
	@RequestMapping("/main/totalSearch_work")
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
	
	@RequestMapping("/main/totalSearch_content")
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
	
	@RequestMapping("/main/totalSearchAutocomplete")
	@ResponseBody
	public ModelAndView totalSearchAutocomplete(@RequestParam String searchKeyword) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String,Object> result = mainService.totalSearchAutocomplete(searchKeyword);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/main/totalSearch_work/searchOptions")
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
	
	@RequestMapping("/main/totalContent")
	@ResponseBody
	public ModelAndView totalContent() {
		ModelAndView mv = new ModelAndView("jsonView");
		
		// 자랑하기 정보
		List<Map<String, Object>> boas = mainService.mainBoa();
		mv.addObject("boas", boas);
		
		// 지금 거래중인 작품 정보 
		List<Map<String, Object>> nowDealWorks = mainService.mainNowDealWorks();
		mv.addObject("nowDealWorks", nowDealWorks);
		
		// 매거진9 정보
		List<Map<String, Object>> mgz9s = mainService.mainMgz9s();
		mv.addObject("mgz9s", mgz9s);
		
		// 인기회원 정보
		List<Map<String, Object>> popularMbr = mainService.mainPopularMbr();
		mv.addObject("popularMbr", popularMbr);
		
		// 인기있는 전시후기/소개 정보
		List<Map<String, Object>> popularExhibit = mainService.mainPopularExhibit();
		mv.addObject("popularExhibit", popularExhibit);
		
		return mv;
	}
}

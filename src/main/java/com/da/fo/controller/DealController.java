package com.da.fo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.DealService;
import com.da.fo.service.MemberService;
import com.da.fo.service.MyPageService;
import com.da.sample.service.CommonService;
import com.da.vo.MbrInfoVo;


@Controller
public class DealController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DealService dealService;
	
	@Autowired
	private MyPageService myPageService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/deal")
	public String goDeal() {
		logger.info("gogogogogogogogogogogo Deal!!!!!");
		return "thymeleaf/fo/deal/deal";
	}
	
	@RequestMapping("/bidding")
	@ResponseBody
	public ModelAndView bidding(@RequestParam(value="workSq", required=false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/bidding");
		Map<String, Object> result = dealService.dealDetail(workSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//거래 등록
	@RequestMapping("/dealReg")
	@ResponseBody
	public ModelAndView dealReg(@RequestParam(value="workSq", required=false) String workSq, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/dealReg");
		Map<String, Object> result = myPageService.myWorkMod(workSq);
		MbrInfoVo mbrInfo = memberService.mbrInfo(session.getAttribute("mbrSq").toString());
		mbrInfo.setMbrCpNum(commonService.decrypt(mbrInfo.getMbrCpNum()));
		result.put("mbrInfo", mbrInfo);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/dealSearch")
	@ResponseBody
	public ModelAndView dealSerach(@RequestParam @Nullable Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> searchOptions = new HashMap<>();
		List<String> dealTypCds = new ArrayList<>();
		List<String> dealSttsCds = new ArrayList<>();
		List<String> workShpCds = new ArrayList<>();
		List<String> workClsfcCds = new ArrayList<>();
		if(param.get("dealTypCds") != null) {
			dealTypCds = Arrays.asList(param.get("dealTypCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		if(param.get("dealSttsCds") != null) {
			dealSttsCds = Arrays.asList(param.get("dealSttsCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		if(param.get("workShpCds") != null) {
			workShpCds = Arrays.asList(param.get("workShpCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		if(param.get("workClsfcCds") != null) {
			workClsfcCds = Arrays.asList(param.get("workClsfcCds").toString().replaceAll("\\[|\\]|\"", "").split(","));
		}
		if(param.get("authSq") != null) {
			searchOptions.put("authSq", Integer.parseInt((String) param.get("authSq")));
		}else{
			searchOptions.put("authSq", null);
		}
		searchOptions.put("dealTypCds", dealTypCds);
		searchOptions.put("dealSttsCds", dealSttsCds);
		searchOptions.put("workShpCds", workShpCds);
		searchOptions.put("workClsfcCds", workClsfcCds);
		System.out.println("################# searchOptions : " + searchOptions);
		List result = dealService.dealSerach(searchOptions);
		mv.addObject("result", result);
		return mv;
	}
}

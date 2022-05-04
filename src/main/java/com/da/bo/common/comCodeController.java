package com.da.bo.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.sample.service.CommonService;
import com.da.bo.service.comCodeService;

@Controller
public class comCodeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private comCodeService comCodeService;
	
	
	@RequestMapping("/admin/comCode")
	public String openArtistMemberInput() {
		return "bo/member/comCode";
	}
	
	//공통코드 입력
	@RequestMapping("/admin/comCodeInputData")
	@ResponseBody
	public int comCodeInputData(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		resultState = comCodeService.comCodeInsert(param);
		return resultState;
	}
	
	
	//공통코드 수정
	@RequestMapping("/admin/comCodeUpdateData")
	@ResponseBody
	public int comCodeUpdateData(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		resultState = comCodeService.comCodeUpdate(param);
		return resultState;
	}
	
	//공통코드 삭제
	@RequestMapping("/admin/comCodeDeleteData")
	@ResponseBody
	public int comCodeDeleteData(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		resultState = comCodeService.comCodeDelete(param);
		return resultState;
	}
	
	//공통코드 리스트
	@RequestMapping("/admin/comCodeListData")
	@ResponseBody
	public ModelAndView comCodeListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		Map<String, Object> result = new HashMap<>();
		
		result = comCodeService.comCodeList(param);
		
		mv.addObject("comCodeList", result);
		
		return mv;

	}
	
	
	//공통 서브코드 리스트
	@RequestMapping("/admin/comSubCodeListData")
	@ResponseBody
	public ModelAndView comSubCodeListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		Map<String, Object> result = new HashMap<>();
		
		result = comCodeService.comSubCodeList(param);
		
		mv.addObject("comCodeList", result);
		
		return mv;

	}
	
	
	//공통 서브코드 입력
	@RequestMapping("/admin/comSubCodeInsert")
	@ResponseBody
	public int comSubCodeInsert(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		
		resultState = comCodeService.comSubCodeInsert(param);
		
		return resultState;
	}
	
	
	//공통 서브코드 수정
	@RequestMapping("/admin/comSubCodeUpdate")
	@ResponseBody
	public int comSubCodeUpdateData(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		
		resultState = comCodeService.comSubCodeUpdate(param);
		
		return resultState;
	}
	
	
	//공통 서브코드 삭제
	@RequestMapping("/admin/comSubCodeDeleteData")
	@ResponseBody
	public int comSubCodeDeleteData(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		resultState = comCodeService.comSubCodeDelete(param);
		return resultState;
	}
}

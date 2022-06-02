package com.da.fo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.common.AwsS3Service;
import com.da.fo.service.NotiService;

@Controller
public class NotiController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AwsS3Service awsS3Service;
	
	
	@Autowired
	private NotiService NotiService;
	
	
	//보냄 히스토리 등록
	@RequestMapping("/admin/noti/notiInsertData")
	@ResponseBody
	public int NotiInsertData(@RequestParam Map<String, Object> param) {
		
		return NotiService.notiInsert(param);
		
	}
	
	
	//보냄 히스토리 리스트
	@RequestMapping("/admin/noti/notiList")
	@ResponseBody
	public ModelAndView notiListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = NotiService.notiSelect(param);
									
		mv.addObject("notiData", result);
		
		return mv;
	}
		
	

}

package com.da.bo.report;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.bo.service.reportService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class reportController {
	
	
	@Autowired
	private reportService reportService;
	
	//신고접수 입력
	@RequestMapping("/admin/report/reportInsData")
	@ResponseBody
	public int report(@RequestParam Map<String, Object> param)throws IOException  {
		
		System.out.println("Controller para data: " + param);
		
		int result = reportService.reportInsert(param);
		
		return result;
	}
	
	//신고하기 리스트
	@RequestMapping("/admin/report/reportList")
	public ModelAndView reportPage() {
		
		ModelAndView mv = new ModelAndView("bo/declaration/reportMain");
		
		return mv;
	}
	
	//신고하기 리스트
	@RequestMapping("/admin/report/reportDetail")
	public ModelAndView reportDetailPage() {
		
		ModelAndView mv = new ModelAndView("bo/declaration/reportDetail");
		
		return mv;
	}
	
	@RequestMapping("/admin/report/reportSearch")
	@ResponseBody
	public ModelAndView reportSearch(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		List result = reportService.reportList(param);
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	
	@RequestMapping("/admin/report/reportUpdateData")
	@ResponseBody
	public int boardUpdateData(@RequestParam Map<String, Object> param) {
		
		int updateState = -1;
		
		updateState = reportService.reportUpdate(param);
		
		return updateState;
	}
	
	
	
}

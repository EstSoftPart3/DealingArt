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
	@RequestMapping("/admin/reportInsData")
	@ResponseBody
	public int report(@RequestParam Map<String, Object> param)throws IOException  {
		
		System.out.println("Controller para data: " + param);
		
		int result = reportService.reportInsert(param);
		
		return result;
	}
	
	@RequestMapping("/admin/reportMain")
	public ModelAndView reportPage() {
		
		ModelAndView mv = new ModelAndView("bo/member/reportMain");
		
		return mv;
	}
	
	@RequestMapping("/admin/reportSearch")
	@ResponseBody
	public ModelAndView reportSearch(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		List result = reportService.reportList(param);
		
		mv.addObject("result", result);
		
		return mv;
	}
	
	
}

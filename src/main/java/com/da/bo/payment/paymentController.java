package com.da.bo.payment;

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

import com.da.bo.service.paymentService;

@Controller
public class paymentController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AwsS3Service awsS3Service;
	
	@Autowired
	private paymentService paymentService;
	
	@RequestMapping("/admin/payment")
	public String openPayment() {
		return "bo/payment/payproc";
	}
	
	
	@RequestMapping("/admin/transit")
	public String openTransit() {
		return "bo/payment/transitproc";
	}
	
	
	//거래 메인
	@RequestMapping("/admin/payment/dealMainListData")
	@ResponseBody
	public ModelAndView dealMainListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentService.dealMainList(param);
									
		mv.addObject("data", result);
		
		return mv;
	}
	
	
	@RequestMapping("/admin/payment/trnsprtListData")
	@ResponseBody
	public ModelAndView trnsprtListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentService.trnsprtList(param);
									
		mv.addObject("data", result);
		
		return mv;
	}

}

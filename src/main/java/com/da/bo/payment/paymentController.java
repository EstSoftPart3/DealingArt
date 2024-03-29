package com.da.bo.payment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.da.common.AwsS3Service;
import com.da.vo.FileVo;
import com.google.gson.Gson;
import com.da.bo.service.paymentService;

@Controller
public class paymentController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AwsS3Service awsS3Service;
	
	@Autowired
	private paymentService paymentService;
	
	//주문리스트
	@RequestMapping("/admin/payment/paymentListPage")
	public String openPayment() {
		return "bo/payment/payproc";
	}
	
	//주문상세
	@RequestMapping("/admin/payment/paydetailPage")
	public String openPaymentDetail() {
		return "bo/payment/paydetail";
	}
	
	//배송리스트
	@RequestMapping("/admin/payment/transit")
	public String openTransit() {
		return "bo/payment/transitproc";
	}
	//운송 서비스 정보 조회
	@RequestMapping("/admin/payment/trnsprtInfo")
	@ResponseBody
	public ModelAndView trnsprtInfo(@RequestParam(value="dealSq", required=false) String dealSq){
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = paymentService.trnsprtInfo(dealSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//배송 부가서비스 삭제
	@RequestMapping("/admin/payment/deleteTrnsprt")
	@ResponseBody
	public int deleteTrnsprt(@RequestBody Map<String, Object> param) {
		List<Map<String, Object>> paramList = (List<Map<String, Object>>) param.get("trnsprtInfo");
		for(int i=0; i<paramList.size(); i++) {
			paramList.get(i).put("dealSq", param.get("dealSq"));
			paramList.get(i).put("buyMbrSq", param.get("buyMbrSq"));
			paramList.get(i).put("sellMbrSq", param.get("sellMbrSq"));
			paramList.get(i).put("artstSq", param.get("artstSq"));
		}
		int result = paymentService.deleteTrnsprt(paramList);
		return result;
	}
	
	//판매자 운송서비스 선택시
	@RequestMapping("/admin/payment/selectTrnsprtPrcMtrx")
	@ResponseBody
	public ModelAndView selectTrnsprtPrcMtrx(@RequestBody Map<String, Object> param) {
		System.out.println(param);
		ModelAndView mv = new ModelAndView("jsonView");
		//필수 부가서비스
		param.put("trnsprtReqYn", "Y");
		List<Map<String, Object>> reqYresult = paymentService.selectTrnsprtPrcMtrx(param);
		//선택 부가서비스
		param.put("trnsprtReqYn", "N");
		List<Map<String, Object>> reqNresult = paymentService.selectTrnsprtPrcMtrx(param);
		
		mv.addObject("reqYresult", reqYresult);
		mv.addObject("reqNresult", reqNresult);
		
		return mv;
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
	
	
	//거래 상세
	@RequestMapping("/admin/payment/payDetailData")
	@ResponseBody
	public ModelAndView payDetailData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentService.payDetail(param);
									
		mv.addObject("data", result);
		
		return mv;
	}
	
	//작품 거래 내역
	@RequestMapping("/admin/payment/workDealhListData")
	@ResponseBody
	public ModelAndView workDealhListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentService.workDealhList(param);
									
		mv.addObject("data", result);
		
		return mv;
	}
	
	
	//작품 정보
	@RequestMapping("/admin/payment/workInfoData")
	@ResponseBody
	public ModelAndView workInfoData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = paymentService.workInfo(param);
									
		mv.addObject("data", result);
		
		return mv;
	}
	
	//거래 메인 수정 : 거래_상태_코드
	@RequestMapping("/admin/payment/dealMainSttsCdUpdateData")
	@ResponseBody
	public void dealMainSttsCdUpdateData(@RequestParam Map<String, Object> param) {
		
		int dealSq = Integer.parseInt((String) param.get("dealSq"));
		String dealSttsCd = (String) param.get("dealSttsCd");
		
		param.put("dealSq", dealSq);
		param.put("dealSttsCd", dealSttsCd);
		
		paymentService.dealMainSttsCdUpdate(param);
	}
	
	
	//거래 메인 수정 : 거래_메모_코드
	@RequestMapping("/admin/payment/dealMainMemoUpdateData")
	@ResponseBody
	public void dealMainMemoUpdateData(@RequestParam Map<String, Object> param) {
		
		int dealSq = Integer.parseInt((String) param.get("dealSq"));
		String dealMemo = (String) param.get("dealMemo");
		
		param.put("dealSq", dealSq);
		param.put("dealMemo", dealMemo);
		
		paymentService.dealMainMemoUpdate(param);
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
	
	//거래 관련 파일 업로드
	@RequestMapping("/admin/payment/dealFileUpload")
	@ResponseBody
	public String dealFileUpload(@RequestPart(value = "param") Map<String, Object> param, 
			@RequestPart(value = "dealConfirmation") @Nullable MultipartFile dealConfirmation,
			@RequestPart(value = "dealStatementB1") @Nullable MultipartFile dealStatementB1,
			@RequestPart(value = "dealStatementB2") @Nullable MultipartFile dealStatementB2,
			@RequestPart(value = "dealStatementS") @Nullable MultipartFile dealStatementS,
			@RequestPart(value = "dealContract") @Nullable MultipartFile dealContract,
			@RequestPart(value = "dealConditionCheck") @Nullable MultipartFile dealConditionCheck) throws IOException {
		
		System.out.println("##################### collectionReg param : " + param);
		//거래 순번
		String dealSq = param.get("dealSq").toString();
		//db에 담을 Map
		Map<String, Object> deal = new HashMap<String, Object>();
		deal.put("dealSq", dealSq);
		
		//거래 확인서
		if(dealConfirmation != null){
			FileVo file = awsS3Service.upload(dealConfirmation, "dealingart/dealFile/"+dealSq);
			deal.put("dealConfirmation", file.getFileUrl());
		}
		//거래 명세서 구매자 1차
		if(dealStatementB1 != null){
			FileVo file = awsS3Service.upload(dealStatementB1, "dealingart/dealFile/"+dealSq);
			deal.put("dealStatementB1", file.getFileUrl());
		}
		//거래 명세서 구매자 2차
		if(dealStatementB2 != null){
			FileVo file = awsS3Service.upload(dealStatementB2, "dealingart/dealFile/"+dealSq);
			deal.put("dealStatementB2", file.getFileUrl());
		}
		//거래 명세서 판매자 
		if(dealStatementS != null){
			FileVo file = awsS3Service.upload(dealStatementS, "dealingart/dealFile/"+dealSq);
			deal.put("dealStatementS", file.getFileUrl());
		}
		//거래 계약서
		if(dealContract != null){
			FileVo file = awsS3Service.upload(dealContract, "dealingart/dealFile/"+dealSq);
			deal.put("dealContract", file.getFileUrl());
		}
		//컨디션 체크 리포트
		if(dealConditionCheck != null){
			FileVo file = awsS3Service.upload(dealConditionCheck, "dealingart/dealFile/"+dealSq);
			deal.put("dealConditionCheck", file.getFileUrl());
		}
		
		int result = paymentService.dealFileUpload(deal);
		if(result > 0) {
			return "Success";
		}else {
			return "Fail";
		}
	}
	
	//거래 관련 파일 업로드
	@RequestMapping("/admin/payment/dealFileDelete")
	@ResponseBody
	public String dealFileDelete(@RequestParam Map<String, Object> param) {
		System.out.println("delete Param : "+param);
		int result = paymentService.dealFileDelte(param);
		if(result > 0) {
			return "Success";
		}else{
			return "Fail";
		}
		
	}

}

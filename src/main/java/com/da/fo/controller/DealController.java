package com.da.fo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.da.common.AwsS3Service;
import com.da.fo.service.DealService;
import com.da.fo.service.MemberService;
import com.da.fo.service.MyPageService;
import com.da.util.CommonService;
import com.da.vo.FileVo;
import com.da.vo.MbrInfoVo;
import com.google.gson.Gson;


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
	
	@Autowired
	private AwsS3Service awsS3Service;
	
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
	
	//?????? ?????? ????????? ??????
	@RequestMapping("/dealReg")
	@ResponseBody
	public ModelAndView dealReg(@RequestParam(value="workSq", required=false) String workSq,
								@RequestParam(value="workTypCd", required=false) String workTypCd,
								@RequestParam(value="mbrSq", required=false) String mbrSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/dealReg");
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> work = new HashMap<>(); 
		if(workTypCd.equals("WORK")) {
			work = myPageService.myWorkMod(workSq);
		}
		if(workTypCd.equals("COLL")) {
			work = myPageService.myCollectionMod(workSq);
		}
		MbrInfoVo mbrInfo = memberService.mbrInfo(mbrSq);
		
		if(mbrInfo.getMbrDelivryCpNum() == null) {
			mbrInfo.setMbrDelivryCpNum(commonService.decrypt(mbrInfo.getMbrCpNum()));
		}else {
			mbrInfo.setMbrDelivryCpNum(commonService.decrypt(mbrInfo.getMbrDelivryCpNum()));
		}
		
		result.put("work", work);
		result.put("mbrInfo", mbrInfo);
		mv.addObject("result", result);
		return mv;
	}
	
	//?????? ?????? ??????
	@RequestMapping("/dealReg/reg")
	@ResponseBody
	public int myWorkCor(@RequestPart(value = "param") Map<String, Object> param, 
			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl) throws IOException {
		
		System.out.println("##################### collectionReg param : " + param);
		System.out.println("##################### collectionReg file : " + workGrtUrl + workImgLefUrl + workImgRitUrl + workImgTopUrl + workImgBotUrl);
		JSONObject jsonObject = new JSONObject(new Gson().toJson(param));
		//?????? ??????
		Map<String, Object> mbrInfo = new Gson().fromJson(jsonObject.getJSONObject("mbrInfo").toString(), new HashMap().getClass());
		//?????? ???????????? ????????? ??????
		mbrInfo.put("mbrDelivryCpNum", commonService.encrypt(mbrInfo.get("mbrDelivryCpNum").toString()));
		//?????? ??????
		Map<String, Object> work = new Gson().fromJson(jsonObject.getJSONObject("work").toString(), new HashMap().getClass());
		//?????? ??????
		Map<String, Object> deal = new Gson().fromJson(jsonObject.getJSONObject("deal").toString(), new HashMap().getClass());
		//?????????
		if(workGrtUrl != null){
			FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workGrtUrl", file.getFileUrl());
		}
		//?????? ?????? ???
		if(workImgLefUrl != null){
			FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgLefUrl", file.getFileUrl());
		}
		//?????? ?????? ???
		if(workImgRitUrl != null){
			FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgRitUrl", file.getFileUrl());
		}
		//?????? ?????? ???
		if(workImgTopUrl != null){
			FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgTopUrl", file.getFileUrl());
		}
		//?????? ?????? ???
		if(workImgBotUrl != null){
			FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgBotUrl", file.getFileUrl());
		}
		int result1 = myPageService.myWorkCor(work); 
		int result2 = 0;
		int result3 = 0;
		if(result1 > 0) {
			result2 = memberService.mbrDelivryAddrCor(mbrInfo);
			if(result2 > 0) {
				result3 = dealService.dealReg(deal);
			}
		}
		
		System.out.println("@@@@@@@@@@@@ deal : "+result3);
		
		return result3;
	}
	
	//?????? ?????? ????????? ??????
	@RequestMapping("/dealMod")
	@ResponseBody
	public ModelAndView dealReg(@RequestParam(value="dealSq", required=false) String dealSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/dealMod");
		Map<String, Object> result = dealService.selectDeal(dealSq);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/dealSearch")
	@ResponseBody
	public ModelAndView dealSerach(@RequestBody @Nullable Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int page = Integer.parseInt(param.get("page").toString());
		int startRow = ((page-1)*6);
		if(page == 1){
			startRow = 0;
		}
		param.put("startRow", startRow);
		List result = dealService.dealSerach(param);
		mv.addObject("result", result);
		return mv;
	}
	
	//???????????? ???????????? ?????? ???????????? ????????? ???????????? ????????? ?????? ?????? ???????????? ??????????????? insert??????.
	@RequestMapping("/bidReg")
	@ResponseBody
	public ModelAndView bidReg(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = dealService.bidReg(param);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/workDetail")
	@ResponseBody
	public ModelAndView workDetail(@RequestParam(value="workSq", required=false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/workDetail");
		Map<String, Object> result = dealService.workDetail(workSq);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/dealMod/bidSuspension")
	@ResponseBody
	public ModelAndView bidSuspension(@RequestParam(value="dealSq", required=false) String dealSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = dealService.bidSuspension(dealSq);
		mv.addObject("result", result);
		return mv;
	}
}

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
import com.da.mapper.DealMapper;
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
	
	@Autowired
	private DealMapper dealMapper;
	
	@RequestMapping("/deal")
	public String goDeal() {
		logger.info("gogogogogogogogogogogo Deal!!!!!");
		return "thymeleaf/fo/deal/deal";
	}
	
	@RequestMapping("/deal/bidding")
	@ResponseBody
	public ModelAndView bidding(@RequestParam(value="SqNumber", required=false) String dealSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/bidding");
		Map<String, Object> result = dealService.dealDetail(dealSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//거래 등록 페이지 오픈
	@RequestMapping("/deal/openDealReg")
	@ResponseBody
	public ModelAndView openDealReg(@RequestParam(value="workSq", required=false) String workSq,
									@RequestParam(value="mbrSq", required=false) String mbrSq) {
									//@RequestParam(value="workTypCd", required=false) String workTypCd)
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/dealReg");
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> work = new HashMap<>(); 
		work = myPageService.myWorkMod(workSq);
//		if(workTypCd.equals("WORK")) {
//			work = myPageService.myWorkMod(workSq);
//		}
//		if(workTypCd.equals("COLL")) {
//			work = myPageService.myCollectionMod(workSq);
//		}
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
	
	//거래 등록 기능
	@RequestMapping("/deal/dealReg")
	@ResponseBody
	public int dealReg(@RequestPart(value = "param") Map<String, Object> param, 
			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl) throws IOException {
		
		System.out.println("##################### collectionReg param : " + param);
		System.out.println("##################### collectionReg file : " + workGrtUrl + workImgLefUrl + workImgRitUrl + workImgTopUrl + workImgBotUrl);
		JSONObject jsonObject = new JSONObject(new Gson().toJson(param));
		
		//박상현 : Gson JSON을 HashMap으로 변경
		
		//회원 정보
		Map<String, Object> mbrInfo = new Gson().fromJson(jsonObject.getJSONObject("mbrInfo").toString(), new HashMap().getClass());
		//회원 배송받을 핸드폰 번호
		mbrInfo.put("mbrDelivryCpNum", commonService.encrypt(mbrInfo.get("mbrDelivryCpNum").toString()));
		//작품 정보
		Map<String, Object> work = new Gson().fromJson(jsonObject.getJSONObject("work").toString(), new HashMap().getClass());
		//거래 정보
		Map<String, Object> deal = new Gson().fromJson(jsonObject.getJSONObject("deal").toString(), new HashMap().getClass());
		//보증서
		if(workGrtUrl != null){
			FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workGrtUrl", file.getFileUrl());
		}
		//작품 사진 좌
		if(workImgLefUrl != null){
			FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgLefUrl", file.getFileUrl());
		}
		//작품 사진 우
		if(workImgRitUrl != null){
			FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgRitUrl", file.getFileUrl());
		}
		//작품 사진 상
		if(workImgTopUrl != null){
			FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgTopUrl", file.getFileUrl());
		}
		//작품 사진 하
		if(workImgBotUrl != null){
			FileVo file = awsS3Service.upload(workImgBotUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgBotUrl", file.getFileUrl());
		}
		//작품정보중 변경된것 있다면 수정한다.
		int result1 = myPageService.myWorkCor(work); 
		int result2 = 0;
		int result3 = 0;
		if(result1 > 0) {
			//박상현 : 배송주소 등록후 거래를 등록한다.
			result2 = memberService.mbrDelivryAddrCor(mbrInfo);
			if(result2 > 0) {
				result3 = dealService.dealReg(deal);
			}
		}
		
		System.out.println("@@@@@@@@@@@@ deal : "+result3);
		
		return result3;
	}
	//응찰 또는 판매 되었는지 확인
	@RequestMapping("/deal/dealTPyn")
	@ResponseBody
	public String dealTPyn(@RequestParam(value="dealSq", required=false) String dealSq) {
		String dealTPyn = "Y";
		//응찰 또는 판매되었는지 확인
		int failed = dealMapper.selectDealSttsCd(dealSq);
		if(failed > 0) {
			dealTPyn = "N";
		}
		return dealTPyn;
	}
	//거래 수정 페이지 오픈
	@RequestMapping("/deal/openDealMod")
	@ResponseBody
	public ModelAndView openDealMod(@RequestParam(value="dealSq", required=false) String dealSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/dealMod");
		Map<String, Object> result = dealService.selectDeal(dealSq);
		mv.addObject("result", result);
		return mv;
	}
	
	//거래 수정
	@RequestMapping("/deal/dealMod")
	@ResponseBody
	public int dealMod(@RequestPart(value = "param") Map<String, Object> param, 
			@RequestPart(value = "workGrtUrl") @Nullable MultipartFile workGrtUrl,
			@RequestPart(value = "workImgLefUrl") @Nullable MultipartFile workImgLefUrl,
			@RequestPart(value = "workImgRitUrl") @Nullable MultipartFile workImgRitUrl,
			@RequestPart(value = "workImgTopUrl") @Nullable MultipartFile workImgTopUrl,
			@RequestPart(value = "workImgBotUrl") @Nullable MultipartFile workImgBotUrl) throws IOException {
		
		System.out.println("##################### collectionReg param : " + param);
		System.out.println("##################### collectionReg file : " + workGrtUrl + workImgLefUrl + workImgRitUrl + workImgTopUrl + workImgBotUrl);
		JSONObject jsonObject = new JSONObject(new Gson().toJson(param));
		//회원 정보
		Map<String, Object> mbrInfo = new Gson().fromJson(jsonObject.getJSONObject("mbrInfo").toString(), new HashMap().getClass());
		//회원 배송받을 핸드폰 번호
		mbrInfo.put("mbrDelivryCpNum", commonService.encrypt(mbrInfo.get("mbrDelivryCpNum").toString()));
		//작품 정보
		Map<String, Object> work = new Gson().fromJson(jsonObject.getJSONObject("work").toString(), new HashMap().getClass());
		//거래 정보
		Map<String, Object> deal = new Gson().fromJson(jsonObject.getJSONObject("deal").toString(), new HashMap().getClass());
		//보증서
		if(workGrtUrl != null){
			FileVo file = awsS3Service.upload(workGrtUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workGrtUrl", file.getFileUrl());
		}
		//작품 사진 좌
		if(workImgLefUrl != null){
			FileVo file = awsS3Service.upload(workImgLefUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgLefUrl", file.getFileUrl());
		}
		//작품 사진 우
		if(workImgRitUrl != null){
			FileVo file = awsS3Service.upload(workImgRitUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgRitUrl", file.getFileUrl());
		}
		//작품 사진 상
		if(workImgTopUrl != null){
			FileVo file = awsS3Service.upload(workImgTopUrl, "dealingart/work/"+mbrInfo.get("mbrSq").toString());
			work.put("workImgTopUrl", file.getFileUrl());
		}
		//작품 사진 하
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
				result3 = dealService.dealMod(deal);
			}
		}
		
		System.out.println("@@@@@@@@@@@@ deal : "+result3);
		
		return result3;
	}
	
	@RequestMapping("/deal/dealSearch")
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
	
	//응찰하기 전 실시간 응찰가와 현재 화면의 응찰가를 비교한다
	@RequestMapping("/deal/bidRegCheck")
	@ResponseBody
	public ModelAndView bidRegCheck(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = dealMapper.bidRegCheck1(param);
		mv.addObject("result", result);
		return mv;
	}
		
	//응찰버튼 클릭하면 응찰 테이블에 마지막 응찰가랑 비교를 하고 응찰 테이블에 응찰정보를 insert한다.
	@RequestMapping("/deal/bidReg")
	@ResponseBody
	public ModelAndView bidReg(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = dealService.bidReg(param);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/deal/workDetail")
	@ResponseBody
	public ModelAndView workDetail(@RequestParam(value="SqNumber", required=false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/workDetail");
		Map<String, Object> result = dealService.workDetail(workSq);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/deal/soldoutDetail")
	@ResponseBody
	public ModelAndView soldoutDetail(@RequestParam(value="SqNumber", required=false) String dealSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/deal/soldoutDetail");
		Map<String, Object> result = dealService.soldoutDetail(dealSq);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/deal/dealMod/bidSuspension")
	@ResponseBody
	public ModelAndView bidSuspension(@RequestParam(value="dealSq", required=false) String dealSq) {
		ModelAndView mv = new ModelAndView("jsonView");
		int result = dealService.bidSuspension(dealSq);
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/deal/workDetail1")
	public String workDetail1() {
		return "thymeleaf/fo/myPage/search__collection_creation_detailpage_notsold";
	}
	
	@RequestMapping("/deal/workDetail2")
	public String workDetail2() {
		return "thymeleaf/fo/myPage/search__collection_creation_detailpage_sold";
	}
}

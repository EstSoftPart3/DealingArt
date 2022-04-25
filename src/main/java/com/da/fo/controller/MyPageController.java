package com.da.fo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.da.common.AwsS3Service;
import com.da.fo.service.MemberService;
import com.da.fo.service.MyPageService;
import com.da.sample.service.CommonService;
import com.da.util.SendMailUtil;
import com.da.util.SendSmsUtil;
import com.da.vo.FileVo;

@Controller
public class MyPageController {

	@Autowired
	private AwsS3Service awsS3Service;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CommonService commonService;

	@Autowired
	private SendSmsUtil sendSmsUtil;

	@Autowired
	private SendMailUtil sendMailUtil;

	@Autowired
	private MyPageService myPageService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/withdrawal")
	public String withdrawal() {
		return "thymeleaf/fo/myPage/secession";
	}

	// 회원수정 페이지
	@RequestMapping("/memberEdit")
	public String memberEdit() {
		return "thymeleaf/fo/myPage/memberEdit";
	}

	// 소장품 등록
	@RequestMapping("/collection_reg")
	public String collectionReg() {
		return "thymeleaf/fo/myPage/collection_reg";
	}

	// 소장품 수정
	@RequestMapping("/myWork_reg")
	public String myWorkReg() {
		return "thymeleaf/fo/myPage/myWork_reg";
	}

	// 알림
	@RequestMapping("/alarm")
	public String alarm() {
		return "thymeleaf/fo/myPage/alarm";
	}

	// 쿠폰
	@RequestMapping("/coupon")
	public String coupon() {
		return "thymeleaf/fo/myPage/coupon";
	}

	// 소장품
	@RequestMapping("/myCollection")
	@ResponseBody
	public ModelAndView myCollection(@RequestParam(value = "mbrSq", required = false) String mbrSq) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ mbrSq : " + mbrSq);
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myGallery_myCollection");
		List result = myPageService.myCollection(mbrSq);
		mv.addObject("result", result);
		return mv;
	}

	// 스크랩
	@RequestMapping("/scrap")
	public String scrap() {
		return "thymeleaf/fo/myPage/myGallery_scrap";
	}

	// 나의 작품
	@RequestMapping("/myWork")
	@ResponseBody
	public ModelAndView myWork(@RequestParam(value = "artstSq", required = false) String artstSq) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ artstSq : " + artstSq);
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/portfolio_myWork");
		List result = myPageService.myWork(artstSq);
		mv.addObject("result", result);
		return mv;
	}

	// 거래내역
	@RequestMapping("/myDeal")
	public String myDeal() {
		return "thymeleaf/fo/myPage/myDeal_list";
	}

	@RequestMapping("/myDealSearchList")
	@ResponseBody
	public ModelAndView myDealSearchList(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		System.out.println("############# param : " + param);
		List result = myPageService.myDealSearchList(param);
		mv.addObject("result", result);
		return mv;
	}

	// 작가정보등록
	@RequestMapping("/information")
	public String information() {
		return "thymeleaf/fo/myPage/portfolio_info";
	}

	@RequestMapping("/withdrawalSubmit")
	@ResponseBody
	public int withdrawalSubmit(@RequestParam @Nullable Map<String, Object> param) {
		System.out.println("############## param : " + param);
		param.put("email", commonService.encrypt((String) param.get("email")));
		param.put("password", commonService.encrypt((String) param.get("password")));
		int chk = memberService.memberWithdrawalCheck(param);
		if (chk > 0) {
			return 2;
		} else {
			return memberService.memberWithdrawal(param);
		}
	}

	// 회원수정 이메일인증 메일보내기 테스트
	@RequestMapping("/myPage/memberUpdatEmailCertification")
	@ResponseBody
	public String emailCertification(@RequestParam Map<String, Object> param) {

		String result = "";
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		Map<String, Object> tomap = new HashMap<String, Object>();
		List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();

		int serti = (int) ((Math.random() * (99999 - 10000 + 1)) + 10000);

		String title = "Dealing Art 회원수정시 필요한 인증번호 입니다.";
		String content = "[인증번호] " + serti + " 입니다. <br/> 인증번호 확인란에 기입해주십시오.";

		String memberEmail = (String) param.get("mbrId");

		tomap.put("type", "R");
		tomap.put("address", memberEmail);
		mList.add(tomap);

		params.put("title", title);
		params.put("body", content);
		params.put("recipients", mList);

		rtnMap = sendMailUtil.sendMail(params);
		if (((int) Double.parseDouble(rtnMap.get("count").toString()) < 0)) {
			result = "error";
		} else {
			String sertiString = Integer.toString(serti);
			result = sertiString;
		}
		int paramStatus = -1;

		return result;
	}

	// 소장품 등록
	@PostMapping("/collectionReg")
	@ResponseBody
	public int collectionReg(@RequestPart(value = "work") Map<String, Object> param,
			@RequestPart(value = "file") List<MultipartFile> multipartFiles) {
		System.out.println("##################### collectionReg param : " + param);
		System.out.println("##################### collectionReg file : " + multipartFiles);
		System.out.println("######### file : " + multipartFiles);
		List<FileVo> fileVo = awsS3Service.uploadFiles(multipartFiles, "userCollection");
		System.out.println("############## fileVO : " + fileVo);
		param.put("workMainImgUrl", fileVo.get(0).getFileUrl());
		param.put("workImgFrtUrl", fileVo.get(1).getFileUrl());
		param.put("workImgRerUrl", fileVo.get(2).getFileUrl());
		if (fileVo.size() >= 4) {
			param.put("workGrtUrl", fileVo.get(3).getFileUrl());
		}
		if (fileVo.size() >= 5) {
			param.put("workImgLefUrl", fileVo.get(4).getFileUrl());
		}
		if (fileVo.size() >= 6) {
			param.put("workImgRitUrl", fileVo.get(5).getFileUrl());
		}
		if (fileVo.size() >= 7) {
			param.put("workImgTopUrl", fileVo.get(6).getFileUrl());
		}
		if (fileVo.size() >= 8) {
			param.put("workImgBotUrl", fileVo.get(7).getFileUrl());
		}
		int result = myPageService.collectionReg(param);
		return result;
	}

	// 나의 작품 등록
	@PostMapping("/myWorkReg")
	@ResponseBody
	public int myWorkReg(@RequestPart(value = "work") Map<String, Object> param,
			@RequestPart(value = "file") List<MultipartFile> multipartFiles) {
		System.out.println("##################### collectionReg param : " + param);
		System.out.println("##################### collectionReg file : " + multipartFiles);
		System.out.println("######### file : " + multipartFiles);
		List<FileVo> fileVo = awsS3Service.uploadFiles(multipartFiles, "artistWork");
		System.out.println("############## fileVO : " + fileVo);
		param.put("workMainImgUrl", fileVo.get(0).getFileUrl());
		param.put("workImgFrtUrl", fileVo.get(1).getFileUrl());
		param.put("workImgRerUrl", fileVo.get(2).getFileUrl());
		if (fileVo.size() >= 4) {
			param.put("workGrtUrl", fileVo.get(3).getFileUrl());
		}
		if (fileVo.size() >= 5) {
			param.put("workImgLefUrl", fileVo.get(4).getFileUrl());
		}
		if (fileVo.size() >= 6) {
			param.put("workImgRitUrl", fileVo.get(5).getFileUrl());
		}
		if (fileVo.size() >= 7) {
			param.put("workImgTopUrl", fileVo.get(6).getFileUrl());
		}
		if (fileVo.size() >= 8) {
			param.put("workImgBotUrl", fileVo.get(7).getFileUrl());
		}
		int result = myPageService.myWorkReg(param);
		return result;
	}

	// 나의 작품 수정 페이지 오픈
	@RequestMapping("/myWorkMod")
	@ResponseBody
	public ModelAndView myWorkMod(@RequestParam(value = "workSq", required = false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/myWork_mod");
		Map<String, Object> result = myPageService.myWorkMod(workSq);
		mv.addObject("result", result);
		return mv;
	}

	// 나의 작품 수정
	@PostMapping("/myWorkCor")
	@ResponseBody
	public int myWorkCor(@RequestPart(value = "work") Map<String, Object> param, @RequestPart(value = "file") @Nullable List<MultipartFile> multipartFiles) {
		System.out.println("##################### collectionReg param : " + param);
		System.out.println("##################### collectionReg file : " + multipartFiles);
		System.out.println("######### file : " + multipartFiles);
		if (multipartFiles != null) {
			List<FileVo> fileVo = awsS3Service.uploadFiles(multipartFiles, "artistWork");
			param.put("workMainImgUrl", fileVo.get(0).getFileUrl());
			param.put("workImgFrtUrl", fileVo.get(1).getFileUrl());
			param.put("workImgRerUrl", fileVo.get(2).getFileUrl()); 
			if(fileVo.size() >= 4){ 
				param.put("workGrtUrl", fileVo.get(3).getFileUrl()); 
			} 
			if(fileVo.size() >= 5){ 
				param.put("workImgLefUrl", fileVo.get(4).getFileUrl()); 
				}
			if(fileVo.size() >= 6){ 
				param.put("workImgRitUrl",fileVo.get(5).getFileUrl()); 
			} 
			if(fileVo.size() >= 7){
				param.put("workImgTopUrl", fileVo.get(6).getFileUrl()); 
			} 
			if(fileVo.size() >= 8){ 
				param.put("workImgBotUrl", fileVo.get(7).getFileUrl()); 
			}
			System.out.println("############## fileVO : " + fileVo);
		}
		
		int result = myPageService.myWorkCor(param);
		 
		return result;
	}
	
	// 나의 작품 수정 페이지 오픈
	@RequestMapping("/myCollectionMod")
	@ResponseBody
	public ModelAndView myCollectionMod(@RequestParam(value = "workSq", required = false) String workSq) {
		ModelAndView mv = new ModelAndView("thymeleaf/fo/myPage/collection_mod");
		Map<String, Object> result = myPageService.myCollectionMod(workSq);
		mv.addObject("result", result);
		return mv;
	}
	
	// 소장품 등록
		@PostMapping("/collectionCor")
		@ResponseBody
		public int collectionCor(@RequestPart(value = "work") Map<String, Object> param, @RequestPart(value = "file") @Nullable List<MultipartFile> multipartFiles) {
			System.out.println("##################### collectionReg param : " + param);
			System.out.println("##################### collectionReg file : " + multipartFiles);
			System.out.println("######### file : " + multipartFiles);
			if (multipartFiles != null) {
				List<FileVo> fileVo = awsS3Service.uploadFiles(multipartFiles, "userCollection");
				System.out.println("############## fileVO : " + fileVo);
				param.put("workMainImgUrl", fileVo.get(0).getFileUrl());
				param.put("workImgFrtUrl", fileVo.get(1).getFileUrl());
				param.put("workImgRerUrl", fileVo.get(2).getFileUrl());
				if (fileVo.size() >= 4) {
					param.put("workGrtUrl", fileVo.get(3).getFileUrl());
				}
				if (fileVo.size() >= 5) {
					param.put("workImgLefUrl", fileVo.get(4).getFileUrl());
				}
				if (fileVo.size() >= 6) {
					param.put("workImgRitUrl", fileVo.get(5).getFileUrl());
				}
				if (fileVo.size() >= 7) {
					param.put("workImgTopUrl", fileVo.get(6).getFileUrl());
				}
				if (fileVo.size() >= 8) {
					param.put("workImgBotUrl", fileVo.get(7).getFileUrl());
				}
			}
			int result = myPageService.collectionCor(param);
			return result;
		}

}

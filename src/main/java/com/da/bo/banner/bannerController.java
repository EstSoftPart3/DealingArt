package com.da.bo.banner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.da.bo.service.bannerService;
import com.da.common.AwsS3Service;
import com.da.fo.service.MainService;
import com.da.vo.FileVo;

@Controller
public class bannerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	bannerService bannerService;

	@Autowired
	MainService mainService;
	
	@Autowired
	AwsS3Service awsS3Service;

	// 배너관리 목록 페이지 이동
	@RequestMapping("/admin/banner/bannerList")
	public String openBanner(HttpServletRequest req) {

		return "bo/banner/bannerList";
	}
	
	//배너 목록 조회	 
	 @RequestMapping("/admin/banner/bannerMainList")	 
	 @ResponseBody 
	 public ModelAndView bannerList(@RequestParam Map<String,Object> param) {
	 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
			
		//관리 페이지 이동 시 게시물 관리 목록 조회 후 리턴 해주기.
		Map<String, Object> result = new HashMap<>();
		result = bannerService.bannerList(param);
			System.out.println(param);
		mv.addObject("list", result);
						  
		return mv; 	 
	 } 
	 	

	// 배너 등록 페이지 이동
	@RequestMapping("/admin/banner/bannerWrite")
	public String writeBanner(HttpServletRequest req) {
		return "bo/banner/bannerWrite";
	}

	// 배너 등록
	@RequestMapping("/admin/banner/bannerInsertData")
	@ResponseBody
	public int bannerInsertData(@RequestPart(value="bnnData") Map<String, Object> bnnData
			,@RequestPart(value="promoData") @Nullable List<Map<String, Object>>  promoData
			,@RequestPart(value="bnnMpImgUrl") @Nullable MultipartFile bnnMpImgUrl
			,@RequestPart(value="bnnMmImgUrl") @Nullable MultipartFile bnnMmImgUrl
			,@RequestPart(value="bnnEpImgUrl") @Nullable MultipartFile bnnEpImgUrl
			,@RequestPart(value="bnnEmImgUrl") @Nullable MultipartFile bnnEmImgUrl) throws IOException {
		System.out.println(bnnData.toString());
		System.out.println(promoData.toString());
		System.out.println(bnnMpImgUrl.getName());
		System.out.println(bnnMmImgUrl.getName());
		
		Map<String, MultipartFile> imgUrl = new HashMap<String, MultipartFile>();
		
		imgUrl.put("bnnMpImgUrl", bnnMpImgUrl);
		imgUrl.put("bnnMpImgUrl", bnnMpImgUrl);
		imgUrl.put("bnnMmImgUrl", bnnMmImgUrl);
		imgUrl.put("bnnEmImgUrl", bnnEmImgUrl);
		
		//배너 파일 업로드 후 url 담기
		for (String key : imgUrl.keySet()) {
			MultipartFile url = imgUrl.get(key);
			
			if (url != null) {
				FileVo file = awsS3Service.upload(url, "dealingart/banner/"+bnnData.get("bnnDivCd").toString());
				bnnData.put(key, file.getFileUrl());
			}
		}
		//int result = bannerService.bannerInsert(param);
		//System.out.println(param);
		
		//return result;
		
		return 1;
	}
	
	//게시판 삭제
	@RequestMapping("/admin/banner/bannerDelete")
	@ResponseBody
	public void bannerDelete(@RequestParam Map<String, Object> param) {
		
		int bnnSq = Integer.parseInt((String) param.get("bnnSq"));
		//String bnnDivCd = (String) param.get("bnnDivCd");
		System.out.println("=======테스트======");
		System.out.println(param);
	
		param.put("bnnSq", bnnSq);
		//param.put("bnnDivCd", bnnDivCd);
		
		bannerService.bannerDelete(param);
	}


	
	// 미리보기 팝업테스트
	@RequestMapping("/admin/banner/brPreview")
	public String openPopup(@RequestParam Map<String, Object> param) {
		String bnrTypCd = (String) param.get("bnrTypCd");
		System.out.println("=======openPop테스트======");
		System.out.println(param);
		param.put("bnrTypCd", bnrTypCd);
		return "bo/banner/bannerWrite";
	}


	//메인 
	@RequestMapping("/admin/banner/mainPopup")
	public String mainPopup() {
		return "thymeleaf/index";
	}
	
	
	// 매거진미리보기-인사이트
	@RequestMapping("/admin/banner/mgzPopup")
	public String mgzInPopup() {
		return "thymeleaf/fo/mgz/insights";
	}
	
	// 매거진미리보기-미디어
	@RequestMapping("/admin/banner/media")
	public String mgzMdPopup() {
		return "thymeleaf/fo/mgz/media";
	}
	
	// 매거진미리보기-Exhibition
	@RequestMapping("/admin/banner/exhibition")
	public String mgzExPopup() {
		return "thymeleaf/fo/mgz/exhibition";
	}
	
	//메인화면 데이터 가져오기
	@RequestMapping("/admin/banner/main/mainData")
	@ResponseBody
	public ModelAndView brmainData(@RequestParam @Nullable Map<String, Object> param) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		result = mainService.openMain(param);
		mv.addObject("brmainData", result);

		return mv;
	}

}

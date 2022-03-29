package 	com.da.bo.member.controller;

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

import  com.da.bo.service.artistMemberService;
import com.da.sample.service.CommonService;;

@Controller
public class artistMemberController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private artistMemberService artistMemberService;
	
	
	@RequestMapping("/admin/member/artistMemberInput")
	public String openArtistMemberInput() {
		return "bo/member/artistMemberInput";
	}
	
	//작가정보 입력
	@RequestMapping("/admin/member/artistMemberInputData")
	@ResponseBody
	public int artistMemberInputData(@RequestParam Map<String, Object> param) {
		
		int resultState = -1;
		
		int mbrSq 	  				= Integer.parseInt((String) param.get("mbrSq"));//작가순번
		String artstActvtyNm 	  	= (String) param.get("artstActvtyNm");			//활동명
		String artstEnglsNm 	  	= (String) param.get("artstEnglsNm");			//영문명
		String artstActvtyPartCd  	= (String) param.get("artstActvtyPartCd");		//활동분야코드
		String artstActvtyCd 	  	= (String) param.get("artstActvtyCd");			//활동지역코드
		String artstSelfIntro 	  	= (String) param.get("artstSelfIntro");			//자기소개
		String artstProfileImgUrl 	= (String) param.get("artstProfileImgUrl");		//프로필 이미지
		String artstHmpgUrl 		= (String) param.get("artstHmpgUrl");			//홈페이지 URL
		String artstPromtnVideoUrl 	= (String) param.get("artstPromtnVideoUrl");	//홍보영상 URL
		String artstFacebookId 		= (String) param.get("artstFacebookId");		//페이스북 URL
		String artstInstagramId 	= (String) param.get("artstInstagramId");		//인스타그램 URL
		
		
		Map<String, Object> requestData = new HashMap<>();
		
		
		requestData.put("mbrSq", mbrSq);
		
		if(!CommonService.isEmpty(artstActvtyNm)) {
			requestData.put("artstActvtyNm", artstActvtyNm);
		}
		if(!CommonService.isEmpty(artstEnglsNm)) {
			requestData.put("artstEnglsNm", artstEnglsNm);
		}
		if(!CommonService.isEmpty(artstActvtyPartCd)) {
			requestData.put("artstActvtyPartCd", artstActvtyPartCd);
		}
		if(!CommonService.isEmpty(artstActvtyCd)) {
			requestData.put("artstActvtyCd", artstActvtyCd);
		}
		if(!CommonService.isEmpty(artstSelfIntro)) {
			requestData.put("artstSelfIntro", artstSelfIntro);
		}
		if(!CommonService.isEmpty(artstProfileImgUrl)) {
			requestData.put("artstProfileImgUrl", artstProfileImgUrl);
		}
		if(!CommonService.isEmpty(artstHmpgUrl)) {
			requestData.put("artstHmpgUrl", artstHmpgUrl);
		}
		if(!CommonService.isEmpty(artstPromtnVideoUrl)) {
			requestData.put("artstPromtnVideoUrl", artstPromtnVideoUrl);
		}
		if(!CommonService.isEmpty(artstFacebookId)) {
			requestData.put("artstFacebookId", artstFacebookId);
		}
		if(!CommonService.isEmpty(artstInstagramId)) {
			requestData.put("artstInstagramId", artstInstagramId);
		}
		resultState = artistMemberService.artistMemberInsert(requestData);
		return resultState;
	}
	
	
	
	//작가정보 
	@RequestMapping("/admin/member/artistMemberInfoData")
	@ResponseBody
	public ModelAndView memberContentData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		Map<String, Object> result = new HashMap<>();
		
		result = artistMemberService.artistMemberInfo(param);
		
		mv.addObject("artistMemberInfoData", result);
		
		return mv;
	}

}
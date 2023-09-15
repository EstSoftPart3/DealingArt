package com.da.bo.community;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.da.bo.service.CommunityManagementService;
import com.da.common.AwsS3Service;
import com.da.vo.FileVo;
import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback;


@Controller
public class CommunityManagementController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AwsS3Service awsS3Service;
	
	@Autowired
	private CommunityManagementService communityManagementService;

	/**
	 * 
	 * 게시판 관리 
	 * 
	 * */
	// 게시판 관리 페이지 이동 
	@RequestMapping("/admin/community/communityManagement")
	public ModelAndView communityManagementPage(@RequestParam Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("bo/community/communityManagementList");
		return mv;
	}
	
	// 게시판 관리 목록 조회
	@RequestMapping("/admin/community/communityManagementList")
	@ResponseBody
	public ModelAndView communityManagementList(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		//관리 페이지 이동 시 게시물 관리 목록 조회 후 리턴 해주기.
		Map<String, Object> result = new HashMap<>();
		result = communityManagementService.communityManagementList(param);
		
		mv.addObject("list", result);
		
		return mv;
	}
	
	// 게시판 관리 상세 조회
	@RequestMapping("/admin/community/communityManagementDtlList")
	@ResponseBody
	public ModelAndView communityManagementDtlList(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		//관리 페이지 이동 시 게시물 관리 목록 조회 후 리턴 해주기.
		Map<String, Object> result = new HashMap<>();
		result = communityManagementService.communityManagementDtlList(param);
		
		mv.addObject(result);
		
		return mv;
	}
	
	// 게시판 공지글 업로드 설정 페이지 이동
	@RequestMapping("/admin/community/communityManagementNoticeUpdate")
	public ModelAndView communityManagementNoticeUpdatePage() {
		ModelAndView mv = new ModelAndView("bo/community/communityManagementNoticeUpdate");
		return mv;
	}
	
	//게시판 관리 정보 저장 
	@RequestMapping("/admin/community/communityManagementSave")
	@ResponseBody
	public int communityManagementSave(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		resultState = communityManagementService.communityManagementSave(param);
		return resultState;
	}
	
	//게시판 관리 공지글 등록
	@RequestMapping("/admin/community/communityManagementNoticeInsert")
	@ResponseBody
	public int communityManagementNoticeInsert(@RequestPart Map<String, Object> param,
			@RequestPart(value = "noticeFileUrl") @Nullable MultipartFile noticeFileUrl) throws IOException {
		
		//공지글 업로드
		if (noticeFileUrl != null) {
			FileVo file = awsS3Service.upload(noticeFileUrl, "dealingart/admin/comtMng/notice/"+param.get("mbrSq").toString());
			param.put("noticeFileUrl", file.getFileUrl());
			System.out.println(file.getFileUrl());
		}
		
		int result = communityManagementService.insertCommunityManagementNotice(param);
		
		return result;
	}
	
	/**
	 * 
	 * 게시물 관리
	 * 
	 * */
	
	// 게시물 관리 페이지 이동
	@RequestMapping("/admin/community/communityBoardList")
	public ModelAndView communityBoardListPage() {
		ModelAndView mv = new ModelAndView("bo/community/communityBoardList");
		return mv;
	}
		
	// 게시물 관리 목록 조회
	@RequestMapping("/admin/community/boardListData")
	@ResponseBody
	public ModelAndView boardListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		//관리 페이지 이동 시 게시물 관리 목록 조회 후 리턴 해주기.
		Map<String, Object> result = new HashMap<>();
		
		String commuBorTypCd = String.valueOf(param.get("commuBorTypCd"));
		
		switch (commuBorTypCd) {
		case "ABL":
			// 전체 게시물 보기 쿼리 실행
			result = communityManagementService.searchAllBoardList(param);
			break;
		case "ABR":
			result = communityManagementService.searchAllReplyList(param);
			break;
		case "RBL":
			result = communityManagementService.searchAllRprtList(param);
			break;

		default:
			break;
		}
		
		mv.addObject("boardData", result);
		
		return mv;
	}
	
	// 전체 게시물 체크박스 선택 후 게시물 숨김,해제, 삭제
		@RequestMapping("/admin/community/boardStatusUpdate")
		@ResponseBody
		public ModelAndView boardStatusUpdate(@RequestParam(value = "comtSq[]", required = false) List<String> comtSq,
											@RequestParam(value = "statusType", required = false) String statusType) {
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("jsonView");
			System.out.println("@@@@@@@@@@@@@@@@@pram: " + comtSq);
			
			int result = 0;
			for(int i=0; i<comtSq.size(); i++) {
				System.out.println("testlist: "+comtSq.get(i));
				result += communityManagementService.boardStatusUpdate(statusType, comtSq.get(i));
			}
					
			mv.addObject("result", result);
			
			return mv;
		}
		
		
	// 신고된 게시물 체크박스 선택 후 게시물 숨김,해제, 삭제
	@RequestMapping("/admin/community/rprtStatusUpdate")
	@ResponseBody
	public ModelAndView rprtStatusUpdate(@RequestParam(value = "rprtSq[]", required = false) List<String> rprtSq,
										@RequestParam(value = "statusType", required = false) String statusType) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		System.out.println("@@@@@@@@@@@@@@@@@pram: " + rprtSq);
		
		int result = 0;
		for(int i=0; i<rprtSq.size(); i++) {
			result += communityManagementService.rprtStatusUpdate(statusType, rprtSq.get(i));
		}
				
		mv.addObject("result", result);
		
		return mv;
	}
		
	
	// 게시물 댓글 페이지 이동
	@RequestMapping("/admin/community/communityBoardCommentPage")
	@ResponseBody
	public ModelAndView communityBoardCommentPage(@RequestParam(value="comtSq")int comtSq) {
		//List<Map<String, Object>> result = communityManagementService.boardAllCmtsList(param);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bo/community/communityBoardCommentList");
		mv.addObject("comtSq", comtSq);
		
		return mv;
	}
	
	// 게시물 댓글 불러오기
	@RequestMapping("/admin/community/communityBoardCommentList")
	@ResponseBody
	public ModelAndView communityBoardCommentList(@RequestParam(value="comtSq")int comtSq) {
		List<Map<String, Object>> result = communityManagementService.boardAllCmtsList(comtSq);
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("result", result);
		
		return mv;
	}
	
	//댓글 숨김 상태 변경
	@RequestMapping("/admin/community/updateReplyState")
	@ResponseBody
	public ModelAndView updateReplyState(@RequestParam(value = "list[]", required = false) List<Integer> list, @RequestParam(value = "re_list[]", required = false) List<Integer> re_list, @RequestParam("state") String state) {
		int result = 0;
		if (list != null && list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				result += communityManagementService.updateReplyState(state, list.get(i));
			}			
		}
		if (re_list != null && re_list.size() > 0) {
			for(int i = 0; i < re_list.size(); i++) {
				result += communityManagementService.updateReReplyState(state, re_list.get(i));
			}
		}		
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("result", result);
		return mv;
	}
	
	//댓글 삭제 상태 변경
	@RequestMapping("/admin/community/deleteReplyState")
	@ResponseBody
	public ModelAndView deleteReplyState(@RequestParam(value = "list[]", required = false) List<Integer> list, @RequestParam(value = "re_list[]", required = false) List<Integer> re_list, @RequestParam("state") String state) {		
		int result = 0;
		if (list != null && list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				result += communityManagementService.deleteReplyState(state, list.get(i));
			}
		}
		if (re_list != null && re_list.size() > 0) {
			for(int i = 0; i < re_list.size(); i++) {
				result += communityManagementService.deleteReReplyState(state, re_list.get(i));
			}
		}
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("result", result);
		return mv;
	}

}

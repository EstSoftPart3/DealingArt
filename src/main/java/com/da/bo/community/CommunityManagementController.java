package com.da.bo.community;

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

import com.da.bo.service.CommunityManagementService;

@Controller
public class CommunityManagementController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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

	//게시물 관리 정보 저장 
	@RequestMapping("/admin/community/communityManagementSave")
	@ResponseBody
	public int communityManagementSave(@RequestParam Map<String, Object> param) {
		int resultState = -1;
		resultState = communityManagementService.communityManagementSave(param);
		return resultState;
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
		
	// 게시판 관리 목록 조회
	@RequestMapping("/admin/community/boardListData")
	@ResponseBody
	public ModelAndView boardListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		//관리 페이지 이동 시 게시물 관리 목록 조회 후 리턴 해주기.
		Map<String, Object> result = new HashMap<>();
		result = communityManagementService.boardListData(param);
		
		mv.addObject("boardData", result);
		
		return mv;
	}
	
	// 게시물 댓글 페이지 이동
	@RequestMapping("/admin/community/communityBoardCommentList")
	public ModelAndView communityBoardCommentPage() {
		ModelAndView mv = new ModelAndView("bo/community/communityBoardCommentList");
		return mv;
	}

}

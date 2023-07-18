package com.da.bo.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.da.common.AwsS3Service;

@Controller
public class CommunityManagementController {
	
	@Autowired
	private AwsS3Service awsS3Service;
	

	/**
	 * 
	 * 게시판 관리 
	 * 
	 * */
	// 게시판 관리 페이지 이동 
	@RequestMapping("/admin/community/communityManagement")
	public ModelAndView communityManagementPage() {
		ModelAndView mv = new ModelAndView("bo/community/communityManagementList");
		return mv;
	}
	
	// 게시판 공지글 업로드 설정 페이지 이동
	@RequestMapping("/admin/community/communityManagementNoticeUpdate")
	public ModelAndView communityManagementNoticeUpdatePage() {
		ModelAndView mv = new ModelAndView("bo/community/communityManagementNoticeUpdate");
		return mv;
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
		
	// 게시물 댓글 페이지 이동
	@RequestMapping("/admin/community/communityBoardCommentList")
	public ModelAndView communityBoardCommentPage() {
		ModelAndView mv = new ModelAndView("bo/community/communityBoardCommentList");
		return mv;
	}

}

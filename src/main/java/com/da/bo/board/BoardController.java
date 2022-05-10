package com.da.bo.board;

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

import com.da.bo.service.boMemberService;
import com.da.bo.service.boardService;
import com.da.common.AwsS3Service;

@Controller
public class BoardController {
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AwsS3Service awsS3Service;
	
	@Autowired
	private boardService boardService;
	
	
	
	
	//게시판 목록 페이지 이동
	@RequestMapping("/admin/board/boardList")
	public String openMemberList(HttpServletRequest req) {
		
		String brdTypCd = req.getParameter("brdTypCd");
		
		return "bo/board/boardList";
	}
	
	//게시판 목록 페이지 이동
	@RequestMapping("/admin/board/boardWrite")
	public String openMemberWrite(HttpServletRequest req) {
		
		String brdTypCd = req.getParameter("brdTypCd");
		
		return "bo/board/boardWrite";
	}
	
	//게시판 목록 데이터
	@RequestMapping("/admin/board/boardListData")
	@ResponseBody
	public ModelAndView boardListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.boardList(param);
									
		mv.addObject("boardData", result);
		
		return mv;
	}

}

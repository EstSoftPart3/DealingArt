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
	
	/**
	 * 공지사항,FAQ DAO
	 * 
	 * **/
	
	//게시판 목록 페이지 이동
	@RequestMapping("/admin/board/boardList")
	public String openBoardList(HttpServletRequest req) {
		
		String brdTypCd = req.getParameter("brdTypCd");
		
		return "bo/board/boardList";
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
	
	//게시판 등록 페이지 이동
	@RequestMapping("/admin/board/boardWrite")
	public String openBoardWrite(HttpServletRequest req) {
		
		String brdTypCd = req.getParameter("brdTypCd");
		return "bo/board/boardWrite";
		
	}
	
	//게시판 등록
	@RequestMapping("/admin/board/boardInsertData")
	@ResponseBody
	public void BoardInsertData(@RequestParam Map<String, Object> param) {
		
		System.out.println("dddd");
		
		int mbrSq = Integer.parseInt((String) param.get("mbrSq"));
		String brdTitle = (String) param.get("brdTitle");
		String brdContent = (String) param.get("brdContent");
		String brdTypCd = (String) param.get("brdTypCd");
		int regMbrSq = Integer.parseInt((String) param.get("regMbrSq"));

		param.put("mbrSq", mbrSq);
		param.put("brdTitle", brdTitle);
		param.put("brdContent", brdContent);
		param.put("brdTypCd", brdTypCd);
		param.put("regMbrSq", regMbrSq);

		
		boardService.boardInsert(param);
		
	}
	
	//게시판 상세 페이지 이동
	@RequestMapping("/admin/board/boardDetail")
	public String openBoardDetail() {
		
		return "bo/board/boardDetail";
	}
	
	//게시판 삭제
	@RequestMapping("/admin/board/boardDetailData")
	@ResponseBody
	public ModelAndView memberContentData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.boardDetail(param);
		
		System.out.println("ㄹㅇㄹㅇㅇㄹㅇㄹㅇㄹ" + result);
		
		mv.addObject("boardDetailData", result);
		
		return mv;
	}

	//게시판 삭제
	@RequestMapping("/admin/board/boardDeleteData")
	@ResponseBody
	public void boardDelete(@RequestParam Map<String, Object> param) {
		
		int brdSq = Integer.parseInt((String) param.get("brdSq"));
		String brdTypCd = (String) param.get("brdTypCd");
	
		param.put("brdSq", brdSq);
		param.put("brdTypCd", brdTypCd);
		
		boardService.boardDelete(param);
		
	}
	
	//게시판 수정
	@RequestMapping("/admin/board/boardUpdateData")
	@ResponseBody
	public void boardUpdateData(@RequestParam Map<String, Object> param) {

		
		int brdSq = Integer.parseInt((String) param.get("brdSq"));
		int mbrSq = Integer.parseInt((String) param.get("mbrSq"));
		String brdTitle = (String) param.get("brdTitle");
		String brdContent = (String) param.get("brdContent");
		String brdTypCd = (String) param.get("brdTypCd");
		

		param.put("brdSq", brdSq);
		param.put("mbrSq", mbrSq);
		param.put("brdTitle", brdTitle);
		param.put("brdContent", brdContent);
		param.put("brdTypCd", brdTypCd);

		
		boardService.boardUpdate(param);
		
	}
	
	/**
	 * 공지사항,FAQ DAO
	 * 
	 * **/
	
	//게시판 목록 페이지 이동
	@RequestMapping("/admin/magazine/magazineList")
	public String openMagazineList(HttpServletRequest req) {
		
		String mgzTypCd = req.getParameter("mgzTypCd");
		
		return "bo/magazine/magazineList";
	}
	
	//게시판 목록 데이터
	@RequestMapping("/admin/magazine/magazineListData")
	@ResponseBody
	public ModelAndView MagazineListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.magazineList(param);
									
		mv.addObject("magazineData", result);
		
		return mv;
	}
	
	//게시판 등록 페이지 이동
	@RequestMapping("/admin/magazine/magazineWrite")
	public String openMagazineWrite(HttpServletRequest req) {
		
		String mgzTypCd = req.getParameter("mgzTypCd");
		return "bo/magazine/magazineWrite";
		
	}
	


	
	
}

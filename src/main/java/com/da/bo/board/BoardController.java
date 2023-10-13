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
	 * 공지사항,FAQ Controller
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
		//System.out.println("dddd");
		
		
		String brdTitle = (String) param.get("brdTitle");
		String brdContent = (String) param.get("brdContent");
		String brdTypCd = (String) param.get("brdTypCd");
		String brdConTypCd = (String) param.get("brdConTypCd");
		String brdAnTypCd = (String) param.get("brdAnTypCd");
		String useYn = (String) param.get("useYn");
		int regMbrSq = Integer.parseInt((String) param.get("regMbrSq"));

		param.put("brdTitle", brdTitle);
		param.put("brdContent", brdContent);
		param.put("brdTypCd", brdTypCd);
		param.put("regMbrSq", regMbrSq);
		param.put("brdConTypCd", brdConTypCd);
		param.put("brdAnTypCd", brdAnTypCd);
		param.put("useYn", useYn);
		
		
		System.out.println(param);
		
		boardService.boardInsert(param);
		
	}
	
	//게시판 상세 페이지 이동
	@RequestMapping("/admin/board/boardDetail")
	public String openBoardDetail() {
		
		return "bo/board/boardDetail";
	}
	
	//게시판 상세 페이지 이동
	@RequestMapping("/admin/board/boardUpdate")
	public String openBoardUpdate() {
		
		return "bo/board/boardUpdate";
	}
	
	//게시판 상세 정보
	@RequestMapping("/admin/board/boardDetailData")
	@ResponseBody
	public ModelAndView boardDetailData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.boardDetail(param);
		
		//System.out.println("ㄹㅇㄹㅇㅇㄹㅇㄹㅇㄹ" + result);
		
		mv.addObject("boardDetailData", result);
		
		return mv;
	}
	
	//긴급 게시판 상세
	@RequestMapping("/admin/board/emBoardDetailData")
	@ResponseBody
	public ModelAndView emBoardDetailData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.emBoardDetail(param);
		
		//System.out.println("emBoardDetail" + result);
		
		mv.addObject("emBoard", result);
		
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
		String brdConTypCd = (String) param.get("brdConTypCd");
		String brdAnTypCd = (String) param.get("brdAnTypCd");
		String useYn = (String) param.get("useYn");

		param.put("brdSq", brdSq);
		param.put("brdTitle", brdTitle);
		param.put("brdContent", brdContent);
		param.put("brdTypCd", brdTypCd);
		param.put("brdConTypCd", brdConTypCd);
		param.put("brdAnTypCd", brdAnTypCd);
		param.put("useYn", useYn);
		
		boardService.boardUpdate(param);
		
	}
	
	/**
	 * 메거진 Controller
	 * 
	 * **/
	
	//메거진 목록 페이지 이동
	@RequestMapping("/admin/magazine/magazineList")
	public String openMagazineList(HttpServletRequest req) {
		
		String mgzTypCd = req.getParameter("mgzTypCd");
		
		return "bo/magazine/magazineList";
	}
	
	//메거진 목록 데이터
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
	
	//메거진 상세 페이지 이동
	@RequestMapping("/admin/magazine/magazineDetail")
	public String openMagazineDetail() {
		
		return "bo/magazine/magazineDetail";
	}
	
	//메거진 수정 페이지 이동
	@RequestMapping("/admin/magazine/magazineUpdate")
	public String openMagazineUpdate() {
		
		return "bo/magazine/magazineUpdate";
	}
	
	//메거진 상세 정보
	@RequestMapping("/admin/magazine/magazineDetailData")
	@ResponseBody
	public ModelAndView magazineDetailData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.magazineDetail(param);
		
		mv.addObject("magazineDetailData", result);
		
		return mv;
	}
	
	//메거진 등록 페이지 이동
	@RequestMapping("/admin/magazine/magazineWrite")
	public String openMagazineWrite(HttpServletRequest req) {
		
		String mgzTypCd = req.getParameter("mgzTypCd");
		return "bo/magazine/magazineWrite";
		
	}
	
	//메거진 등록
	@RequestMapping("/admin/magazine/magazineInsertData")
	@ResponseBody
	public void MagazineInsertData(@RequestParam Map<String, Object> param) {
		
		System.out.println("dddd");

		
	    int mbrSq = Integer.parseInt((String) param.get("mbrSq"));
		String mgzTitle = (String) param.get("mgzTitle");
		String mgzDescrptn = (String) param.get("mgzDescrptn");
		String mgzContent = (String) param.get("mgzContent");
		String mgzMainImgUrl = (String) param.get("mgzMainImgUrl");
		String mgzTypCd = (String) param.get("mgzTypCd");
		 int regMbrSq = Integer.parseInt((String) param.get("regMbrSq"));

		
		param.put("mbrSq", mbrSq);
		param.put("mgzTitle", mgzTitle);
		param.put("mgzDescrptn", mgzDescrptn);
		param.put("mgzContent", mgzContent);
		param.put("mgzMainImgUrl", mgzMainImgUrl);
		param.put("mgzTypCd", mgzTypCd);
		param.put("regMbrSq", regMbrSq);
		
		System.out.println(param);
		
		boardService.magazineInsert(param);
		
//		   Map<String, Object> magazineData = MagazineData(param);
//		    boardService.magazineInsert(magazineData); 중복부분 리팩토링

		
	}
	
	//메거진 삭제
	@RequestMapping("/admin/magazine/magazineDeleteData")
	@ResponseBody
	public void magazineDelete(@RequestParam Map<String, Object> param) {
		
		int mgzSq = Integer.parseInt((String) param.get("mgzSq"));
		String mgzTypCd = (String) param.get("mgzTypCd");
	
		param.put("mgzSq", mgzSq);
		param.put("mgzTypCd", mgzTypCd);
		
		boardService.magazineDelete(param);
		
//		  Map<String, Object> magazineData = MagazineData(param);
//		    int mgzSq = Integer.parseInt((String) param.get("mgzSq"));
//			String mgzTypCd = (String) param.get("mgzTypCd");
//		    magazineData.put("mgzSq", mgzSq);
//		    boardService.magazineDelete(magazineData); 중복부분 리팩토링
		
	}
	
	//메거진 수정
	@RequestMapping("/admin/magazine/magazineUpdateData")
	@ResponseBody
	public void magazineUpdateData(@RequestParam Map<String, Object> param) {

		
	    int mbrSq = Integer.parseInt((String) param.get("mbrSq"));
		String mgzTitle = (String) param.get("mgzTitle");
		String mgzDescrptn = (String) param.get("mgzDescrptn");
		String mgzContent = (String) param.get("mgzContent");
		String mgzMainImgUrl = (String) param.get("mgzMainImgUrl");
		String mgzTypCd = (String) param.get("mgzTypCd");
		int updtMbrSq = Integer.parseInt((String) param.get("updtMbrSq"));

		
		param.put("mbrSq", mbrSq);
		param.put("mgzTitle", mgzTitle);
		param.put("mgzDescrptn", mgzDescrptn);
		param.put("mgzContent", mgzContent);
		param.put("mgzMainImgUrl", mgzMainImgUrl);
		param.put("mgzTypCd", mgzTypCd);
		param.put("updtMbrSq", updtMbrSq);
		
		System.out.println(param);

		
		boardService.magazineUpdate(param);
		
	}
	
//	private Map<String, Object> MagazineData(Map<String, Object> param) {
//	    int mbrSq = Integer.parseInt((String) param.get("mbrSq"));
//	    String mgzTitle = (String) param.get("mgzTitle");
//	    String mgzDescrptn = (String) param.get("mgzDescrptn");
//	    String mgzContent = (String) param.get("mgzContent");
//	    String mgzMainImgUrl = (String) param.get("mgzMainImgUrl");
//	    String mgzTypCd = (String) param.get("mgzTypCd");
//	    int regMbrSq = Integer.parseInt((String) param.get("regMbrSq"));
//
//	    Map<String, Object> magazineData = new HashMap<>();
//	    magazineData.put("mbrSq", mbrSq);
//	    magazineData.put("mgzTitle", mgzTitle);
//	    magazineData.put("mgzDescrptn", mgzDescrptn);
//	    magazineData.put("mgzContent", mgzContent);
//	    magazineData.put("mgzMainImgUrl", mgzMainImgUrl);
//	    magazineData.put("mgzTypCd", mgzTypCd);
//	    magazineData.put("regMbrSq", regMbrSq);
//
//	    return magazineData;
//	} 중복부분 리팩토링
	
	/**
	 * CK에디터 통합 Controller
	 * 
	 * **/
	
	//CK에디터 통합 목록 페이지 이동
	@RequestMapping("/admin/ckeditor/ckeditorList")
	public String openCkeditorList(HttpServletRequest req) {
		
		String ckCd = req.getParameter("ckCd");
		
		return "bo/ckeditor/ckeditorList";
	}
	
	//CK에디터 통합 목록 데이터
	@RequestMapping("/admin/ckeditor/ckeditorListData")
	@ResponseBody
	public ModelAndView ckeditorListData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.ckeditorList(param);
									
		mv.addObject("ckeditorData", result);
		
		return mv;
	}
	
	//CK에디터 통합 상세 페이지 이동
	@RequestMapping("/admin/ckeditor/ckeditorDetail")
	public String openCkeditorDetail() {
		
		return "bo/ckeditor/ckeditorDetail";
	}
	
	//CK에디터 통합 상세 정보
	@RequestMapping("/admin/ckeditor/ckeditorDetailData")
	@ResponseBody
	public ModelAndView ckeditorDetailData(@RequestParam Map<String, Object> param) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("jsonView");
		
		Map<String, Object> result = new HashMap<>();
		
		result = boardService.ckeditorDetail(param);
		
		mv.addObject("ckeditorDetailData", result);
		
		return mv;
	}
	
	//CK에디터 통합 등록 페이지 이동
	@RequestMapping("/admin/ckeditor/ckeditorWrite")
	public String openCkeditorWrite(HttpServletRequest req) {
		
		String ckCd = req.getParameter("ckCd");
		return "bo/ckeditor/ckeditorWrite";
		
	}
	
	//CK에디터 통합 등록
	@RequestMapping("/admin/ckeditor/ckeditorInsertData")
	@ResponseBody
	public void ckeditorInsertData(@RequestParam Map<String, Object> param) {
		
		System.out.println("dddd");
		
	    int mbrSq = Integer.parseInt((String) param.get("mbrSq"));
		String ckTitle = (String) param.get("ckTitle");
		String ckDescrptn = (String) param.get("ckDescrptn");
		String ckContent = (String) param.get("ckContent");
		String ckMainImgUrl = (String) param.get("ckMainImgUrl");
		String ckTypCd = (String) param.get("ckTypCd");
		 int regMbrSq = Integer.parseInt((String) param.get("regMbrSq"));

		
		param.put("mbrSq", mbrSq);
		param.put("ckTitle", ckTitle);
		param.put("ckDescrptn", ckDescrptn);
		param.put("ckContent", ckContent);
		param.put("ckMainImgUrl", ckMainImgUrl);
		param.put("ckTypCd", ckTypCd);
		param.put("regMbrSq", regMbrSq);
		
		System.out.println(param);
		
		boardService.ckeditorInsert(param);

	}
	
	//CK에디터 통합 삭제
	@RequestMapping("/admin/ckeditor/ckeditorDeleteData")
	@ResponseBody
	public void ckeditorDelete(@RequestParam Map<String, Object> param) {
		
		int ckSq = Integer.parseInt((String) param.get("ckSq"));
		String ckTypCd = (String) param.get("ckTypCd");
	
		param.put("ckSq", ckSq);
		param.put("ckTypCd", ckTypCd);
		
		boardService.ckeditorDelete(param);
		
	}
	
	//CK에디터 통합 수정
	@RequestMapping("/admin/ckeditor/ckeditorUpdateData")
	@ResponseBody
	public void ckeditorUpdateData(@RequestParam Map<String, Object> param) {

		
	    int mbrSq = Integer.parseInt((String) param.get("mbrSq"));
		String ckTitle = (String) param.get("ckTitle");
		String ckDescrptn = (String) param.get("ckDescrptn");
		String ckContent = (String) param.get("ckContent");
		String ckMainImgUrl = (String) param.get("ckMainImgUrl");
		String ckTypCd = (String) param.get("ckTypCd");
		int updtMbrSq = Integer.parseInt((String) param.get("updtMbrSq"));

		
		param.put("mbrSq", mbrSq);
		param.put("ckTitle", ckTitle);
		param.put("ckDescrptn", ckDescrptn);
		param.put("ckContent", ckContent);
		param.put("ckMainImgUrl", ckMainImgUrl);
		param.put("ckTypCd", ckTypCd);
		param.put("updtMbrSq", updtMbrSq);
		
		System.out.println(param);

		boardService.ckeditorUpdate(param);
		
	}
	
}

package com.da.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.da.model.MemberEntity;
import com.da.model.SampleBoard;
import com.da.sample.service.SampleService;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SampleController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private SampleService sampleService;
	
	@Autowired
	public SampleController(SampleService sampleService) {
		this.sampleService = sampleService;
	}
	
	/*
	 * idex 화면에서 샘플페이지로 이동 버튼클릭시 로그인화면으로 이동한다
	 */
	@RequestMapping("/sample")
	public String sample() {
		logger.info("sample");
		//샘플페이지.jsp 화면 경로를 리턴한다
		return "sample/sampleIdex";
	}
	
	/*
	 * 로그인 화면에서 로그인 버튼을 누르면 실행된다
	 * param : String memId, String memPw (화면에서 입력한 아이디와 패스워드)
	 * return : 조회된 회원의 row 갯수 true == 1, false == 0
	 */
	@RequestMapping("/sampleLogin")
	@ResponseBody
	public int sampleLogin(String memId, String memPw, HttpServletRequest request) {
		//session에 로그인한 회원의 id를 저장한다
		HttpSession session = request.getSession();
		session.setAttribute("memId", memId);
		//입력된 회원 아이디와 패스워드를 서비스로 보낸다
		return sampleService.sampleLogin(memId, memPw);
	}
	
	/*
	 * 로그인 화면에서 회원가입 버튼을 누르면 회원가입 페이지로 이동한다
	 */
	@RequestMapping("/sample/sampleJoin")
	public String sampleJoin() {
		//회원가입 화면의 경로를 리턴해준다
		return "sample/sampleJoin";
	}
	
	/*
	 * 회원가입화면에서 회원가입 버튼을 누르면 실행된다
	 * param : 화면에서 입력한 정보를 JSON으로 받아서 VO으로 전달해준다
	 * return : MemberEntity
	 */
	@RequestMapping("/sample/insertMem")
	@ResponseBody
	public int insertMem(MemberEntity memberEntity) {
		//회원정보를 저장하는 서비스로 보낸다
		return sampleService.insertMem(memberEntity);
	}
	
	/*
	 * 로그인이 되면 게시물 목록이 있는 게시판 화면으로 이동된다
	 */
	@RequestMapping("/sample/sampleBoard")
	public String sampleBoard(HttpSession session) {
		System.out.println("#############################login User Id : '" + (String) session.getAttribute("memId")+ "'");
		//게시판 경로를 리턴한다
		return "sample/sampleBoard";
	}
	/*
	 * 게시판 화면 오픈시에 게시판에 게시물 목록을 조회해준다
	 * return : List로 변환된 VO SampleBoard
	 */
	@RequestMapping("/sample/searchBoard")
	@ResponseBody
	public List<SampleBoard> searchBoard() {
		//게시물 목록을 조회하는 서비스를 호출한다
		return sampleService.searchBoard();
	}
	/*
	 * 게시판 화면에서 게시물 작성 클릭 시 게시판 작성 화면으로 이동한다 
	 */
	@RequestMapping("/sample/sampleWrite")
	public String sampleWrite() {
		//게시판 작성 페이지 경로를 리턴한다
		return "sample/sampleWrite";
	}
	/*
	 * 게시판 작성 화면에서 게시물 등록 버튼을 눌렀을 때 실행된다
	 * param : 화면에서 작성한 게시물
	 * return : int (성공시 0을 리턴하고 실패시 1을 리턴한다)
	 */
	@RequestMapping("/sample/insertBoard")
	@ResponseBody
	public int insertBoard(HttpSession session, SampleBoard sampleBoard) {
		//게시물 작성 일자를 VO에 자동으로 입력해준다
		sampleBoard.setBRegDate(LocalDateTime.now());
		//게시물 작성자를 세션에서 저장한 회원 id를 자동으로 입력해준다
		sampleBoard.setBWriter((String) session.getAttribute("memId"));
		//VO객체에 결과값을 반환하는 게시물을 insert해주는 서비스를 호출한다
		SampleBoard result = sampleService.insertBoard(sampleBoard);
		if(!result.equals(null)) { //저장된게 null이 아니면 0을 리턴한다
			return 0;
		}else{ //저장된게 null이면 1을 리턴한다
			return 1;
		}
	}
	
	/*
	 * 게시판 목록 화면에서 게시글을 클릭했을 때 실행된다
	 * param : JSON 방식으로 클릭한 해당 row의 정보를 VO 형태로 받아온다
	 * return : 해당 row 정보로 조회를 하여 다시 VO로 보내준다
	 */
	@RequestMapping("/sample/selectBoard")
	@ResponseBody
	public SampleBoard selectBoard(SampleBoard sampleBoard) {
		//선택한 게시물을 조회하는 서비스를 호출한다
		return sampleService.selectBoard(sampleBoard);
	}
}
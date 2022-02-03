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
	
	@RequestMapping("/sample")
	public String sample() {
		logger.info("sample");
		return "sample/sampleIdex";
	}
	
	@RequestMapping("/sampleLogin")
	@ResponseBody
	public int sampleLogin(String memId, String memPw, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("memId", memId);
		return sampleService.sampleLogin(memId, memPw);
	}
	
	@RequestMapping("/sample/sampleJoin")
	public String sampleJoin() {
		return "sample/sampleJoin";
	}
	
	@RequestMapping("/sample/insertMem")
	@ResponseBody
	public int insertMem(MemberEntity memberEntity) {
		return sampleService.insertMem(memberEntity);
	}
	
	@RequestMapping("/sample/sampleBoard")
	public String sampleBoard(HttpSession session) {
		System.out.println("#############################login User Id : '" + (String) session.getAttribute("memId")+ "'");
		return "sample/sampleBoard";
	}
	
	@RequestMapping("/sample/searchBoard")
	@ResponseBody
	public List<SampleBoard> searchBoard() {
		return sampleService.searchBoard();
	}
	
	@RequestMapping("/sample/sampleWrite")
	public String sampleWrite() {
		return "sample/sampleWrite";
	}
	
	@RequestMapping("/sample/insertBoard")
	@ResponseBody
	public int insertBoard(HttpSession session, SampleBoard sampleBoard) {
		sampleBoard.setBRegDate(LocalDateTime.now());
		sampleBoard.setBWriter((String) session.getAttribute("memId"));
		SampleBoard result = sampleService.insertBoard(sampleBoard);
		if(!result.equals(null)) {
			return 0;
		}else{
			return 1;
		}
	}
	
	@RequestMapping("/sample/selectBoard")
	@ResponseBody
	public SampleBoard selectBoard(HttpSession session, SampleBoard sampleBoard) {
		return sampleService.selectBoard(sampleBoard);
	}
}
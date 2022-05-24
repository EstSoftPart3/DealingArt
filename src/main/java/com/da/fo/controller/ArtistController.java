package com.da.fo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.da.fo.service.ArtistService;


@Controller
public class ArtistController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ArtistService artistService;
	
	@RequestMapping("/artist")
	public String openArtist() {
		return "thymeleaf/fo/artistLibrary/artist";
	}
	
	@RequestMapping("/openArtistLibrary")
	@ResponseBody
	public ModelAndView openArtistLibrary() {
		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> result = artistService.openArtistLibrary();
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping("/artistDetail")
	@ResponseBody
	public ModelAndView artistDetail(@RequestParam(value="artstSq", required = false) @Nullable int artstSq) {
		System.out.println("################## artstSq : "+artstSq);
		ModelAndView mv = new ModelAndView("thymeleaf/fo/artistLibrary/artistDetail");
		Map<String, Object> result = artistService.artistDetail(artstSq);
		mv.addObject("result", result);
		return mv;
		
	}
	
	
	@RequestMapping("/artistDetailWork")
	@ResponseBody
	public ModelAndView artistDetailWork(@RequestParam(value="artstSq", required = false) @Nullable int artstSq) {
		System.out.println("################## artstSq : "+artstSq);
		ModelAndView mv = new ModelAndView("thymeleaf/fo/artistLibrary/artistDetailWork");
		Map<String, Object> result = artistService.artistDetail(artstSq);
		mv.addObject("result", result);
		return mv;
		
	}
	
	@RequestMapping("/artistDetail/sort")
	@ResponseBody
	public ModelAndView artistDetailSort(@RequestBody @Nullable Map<String, Object> param) {
		ModelAndView mv = new ModelAndView("jsonView");
		List<Map<String, Object>> result = artistService.artistDetailSort(param);
		mv.addObject("result", result);
		return mv;
		
	}
}

package com.da.fo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}

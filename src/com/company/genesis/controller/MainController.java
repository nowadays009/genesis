package com.company.genesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main")
	public ModelAndView main(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	//테스트 확힌후 삭제
	@RequestMapping("/joinFormOrigin")
	public ModelAndView joinFormOrigin(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/join/joinFormOrigin");
		return mav;
	}
	
}

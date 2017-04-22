package com.company.genesis.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.genesis.model.dto.Member;
import com.company.genesis.model.service.MemberMapperService;
@Controller
public class PersonController {
	
	@Autowired
	MemberMapperService memberService;
	
	@RequestMapping("/joinForm")
	public ModelAndView main(ModelAndView mav){
		mav.addObject("member", new Member());
		mav.setViewName("/join/joinForm");
		return mav;
	}
	
	@RequestMapping("/insertMemberProc")
	public String insertMemberProc(@Valid Member member, BindingResult result){
		if(result.hasErrors()){
			System.out.println("폼점검 문제 발생!");
			//return "redirect:joinForm"; //폼 점검시 에러 메시지 전달(x) 
			return "/join/joinForm"; //폼 점검시 에러 메시지 전달(o)
		}else{
			//회원 정보 저장
			memberService.insertMember(member);
			return "main";
		}
	}
	
	@RequestMapping("/personManagement")
	public ModelAndView personManagement(){
		
		ModelAndView mav = new ModelAndView();
		ArrayList<Member> list = memberService.getAllMembers();
		mav.addObject("members", list);
		mav.setViewName("/person/personManagement");
		
		return mav;
	}
	
	@RequestMapping("/updatePerson/{id}")
	public ModelAndView updatePerson(@PathVariable String id){
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", memberService.getMember(id));
		mav.setViewName("/person/updatePerson");
		return mav;
	}//
	
	@RequestMapping("/updatePersonProc")
	public String updateMemberAction(@Valid Member member, BindingResult result){
		
		if(result.hasErrors()){
			System.out.println("폼점검 문제 발생!");
			return "/person/updatePerson";
		}else{
			//회원 정보 수정
			memberService.updateMember(member);
			return "redirect:/personManagement";
		}
	}//
	
	@RequestMapping("/deletePerson/{id}")
	public String deleteMemberAction(@PathVariable String id){
		
		memberService.deleteMember(id);

		return "redirect:/personManagement";
		
	}//
}

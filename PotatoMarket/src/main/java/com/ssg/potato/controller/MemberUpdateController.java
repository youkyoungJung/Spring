package com.ssg.potato.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.ssg.potato.domain.Member;
import com.ssg.potato.service.MemberService;
import com.ssg.potato.service.MemberValidator;

@Controller
@RequestMapping("/member")

public class MemberUpdateController {
	private static final String FORM_VIEW = "../jsp/profileUpdate";
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@ModelAttribute("member")
	public Member formBacking(HttpServletRequest request) throws Exception  {
		
		String member_id = UserSession.getLoginMemberId(request.getSession());	
		Member member = memberService.memberFind(member_id);
			
		return member;
	}   
	
	@RequestMapping(value="/update" ,method = RequestMethod.GET)
	public String form() {
		return FORM_VIEW;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String submit(
			@ModelAttribute("member") Member member,
			BindingResult result, Model model, SessionStatus sessionStatus) throws Exception {		
		
		System.out.println("command 객체: " + member);	
	    new MemberValidator().validate(member, result);

		if (result.hasErrors()) {
			return FORM_VIEW;
		}
		
		memberService.memberUpdate(member);	
		return "redirect:/member/profile";

	}


}

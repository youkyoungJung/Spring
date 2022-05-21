package com.ssg.potato.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.potato.domain.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssg.potato.service.MemberService;

@Controller
public class MemberProfileController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberservice;

	//마이포테토 페이지 이동
	@RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
	public ModelAndView myPotatoGet(HttpServletRequest request) throws Exception{
		// 로그인 여부 확인
		if (!UserSession.hasLogined(request.getSession())) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");
			return mav;		
		}
		logger.info("마이포테토페이지 컨트롤러 진입");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage");
		logger.info("마이포테토페이지 진입");

		return mav;		
	}
	//회원정보 이동, HttpServletRequest request
	@RequestMapping(value = "/member/profile", method = RequestMethod.GET)
	public ModelAndView myProfileGet(HttpServletRequest request) throws Exception{
		logger.info("프로필 진입");

		String member_id = UserSession.getLoginMemberId(request.getSession());

		Member member = memberservice.memberFind(member_id);

		logger.info("C: 리턴VO결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미) "+member);

		ModelAndView mav = new ModelAndView();
		mav.addObject("name", member.getName());
		mav.addObject("member_id", member.getMember_id());
		mav.addObject("email", member.getEmail());
		mav.addObject("tel", member.getTel());
		mav.setViewName("profile");

		return mav;	

	}

	//회원삭제
	@RequestMapping(value = "/member/delete") 
	public ModelAndView memberDeletePost(HttpServletRequest request,  HttpSession session)throws Exception{
		String member_id = request.getParameter("member_id");
		logger.info("멤버 삭제 메퍼전");
		memberservice.memberDelete(member_id);
		session.invalidate();
		logger.info("멤버 삭제 완료");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;	
	}

}

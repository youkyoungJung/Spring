package com.ssg.potato.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.potato.domain.Member;
import com.ssg.potato.service.MemberService;

@Controller
public class MemberController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberservice;
	
		//로그인 페이지 이동
		@RequestMapping(value = "/member/login", method = RequestMethod.GET)
		public ModelAndView loginGET() throws Exception{
			
			logger.info("로그인 페이지 진입");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");
			
			return mav;		
			
		}
		
		//로그인 처리
		@RequestMapping(value = "/member/login", method = RequestMethod.POST)
		public String loginPOST(Member vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
			logger.info("C: 로그인 처리페이지 POST");
			logger.info("C: "+ vo.getMember_id() + vo.getPw());
		
			Member returnVO = memberservice.loginMember(vo);
			logger.info("C: 리턴VO결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미) "+returnVO);
			
			if(returnVO != null) {
				//5.세션값생성
				/*session.setAttribute("member", returnVO.getMember_id());*/
				HttpSession session = request.getSession();
	            session.setAttribute(UserSession.MEMBER_SESSION_KEY, returnVO.getMember_id());
	            session.setAttribute("isLogin", UserSession.isLoginUser(returnVO.getMember_id(), session));

				return "redirect:/"; 
			} else {
				// 해당 정보 없는 경우 : => login페이지로 이동
				request.setAttribute("loginFailde", true);
				return "redirect:/member/login";
			}
		}
		//로그아웃 처리
		@RequestMapping(value = "/member/logout")
		public ModelAndView logOutGet(HttpServletRequest request, HttpServletResponse response) throws Exception{
			//세션에 저장된 사용자 이이디를 삭제하고 세션을 무효화 함 
			HttpSession session = request.getSession();
			session.removeAttribute(UserSession.MEMBER_SESSION_KEY);
			session.invalidate();
			logger.info("로그인 세션 끊음");
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("login");
			logger.info("로그인 페이지 진입(로그아웃됨.로그인창띄우기)");
			return mav;	
			
		}
}

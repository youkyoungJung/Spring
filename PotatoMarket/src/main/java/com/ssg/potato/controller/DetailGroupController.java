package com.ssg.potato.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.potato.domain.Group;
import com.ssg.potato.service.CartServiceImpl;
import com.ssg.potato.service.GroupService;

@Controller
public class DetailGroupController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DetailGroupController.class);


	private GroupService gService;
	
	@Autowired
	public void setGroupService(GroupService service) {
		this.gService = service;
	}
	
	private CartServiceImpl cService;

	@Autowired
	public void setCartService(CartServiceImpl service) {
		this.cService = service;
	}
	
	@RequestMapping("/detail/group")
	public String handleRequest(
			@RequestParam("group_id") int group_id, 
			ModelMap model
			) throws Exception {
		Group group = this.gService.selectGroup(group_id);
		if(group.getFileName() == null) {
			group.setFileName("logo.png");
		}
		model.put("product", group);
		return "group";
	}
	
	@RequestMapping("/shop/addGroupToCart")
	public String handleRequest(
			@RequestParam("group_id") int group_id,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		HttpSession session = request.getSession();
		
		if(UserSession.hasLogined(session)) {
			String member_id = UserSession.getLoginMemberId(session);
			Group group = gService.selectGroup(group_id);
			
			if(group.getStatus().equals("CLOSE")) {
				logger.info("이미 판매완료!");
				response.setContentType("text/html; charset=UTF-8");
				RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
				dispatcher.include(request, response);
				response.getWriter().write("<script> alert('판매가 완료된 상품입니다. 죄송합니다.'); history.go(-1);</script>");
				response.getWriter().flush();
				return null;
			}
			else if (cService.getCountReserve(member_id, group_id) > 0) {
				logger.info("이미 장바구니!");
				response.setContentType("text/html; charset=UTF-8");
				RequestDispatcher dispatcher = request.getRequestDispatcher("cart");
				dispatcher.include(request, response);
				response.getWriter().write("<script> alert('이미 장바구니에 담겨있습니다!'); history.go(-1);</script>");
				response.getWriter().flush();
				return null;
			}else {
				cService.insertGroupReserve(member_id, group_id);
				logger.info("공구 장바구니 추가 성공! ");
			}
		}else {
	        return "login";		
		}
		
		return "redirect:/shop/viewCart2";
	}
}

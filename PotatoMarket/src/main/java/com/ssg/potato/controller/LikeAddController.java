package com.ssg.potato.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ssg.potato.service.LikeServiceImpl;

@Controller
public class LikeAddController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LikeAddController.class);

	private LikeServiceImpl service;

	@Autowired
	public void setLikeService(LikeServiceImpl service) {
		this.service = service;
	}

	@RequestMapping("/shop/addItemLike")
	public String addItemLike(
			HttpServletRequest request, 
			@RequestParam("item_id") int item_id
			)throws Exception {
		HttpSession session = request.getSession();
		
		if(UserSession.hasLogined(session)) {
			String member_id = UserSession.getLoginMemberId(session);
			if(service.getCountLike(member_id, item_id) > 0) {
				logger.info("이미 관심종목 존재");
				service.deleteItemLike(member_id, item_id);
				logger.info("관심종목 삭제 성공");
				return "redirect:/detail/item?item_id="+ item_id;
			}else {
				service.insertItemLike(member_id, item_id);
				logger.info("관심종목 추가 성공");
			}
		}else {
	        return "login";		
		}
		
		return "redirect:/detail/item?item_id="+ item_id;
	}
	
	@RequestMapping("/shop/addGroupLike")
	public String addGroupLike(
			HttpServletRequest request, 
			@RequestParam("group_id") int group_id
			)throws Exception {
		HttpSession session = request.getSession();
		
		if(UserSession.hasLogined(session)) {
			String member_id = UserSession.getLoginMemberId(session);
			if(service.getCountLike(member_id, group_id) > 0) {
				logger.info("이미 관심종목 존재");
				service.deleteGroupLike(member_id, group_id);
				logger.info("관심종목 삭제 성공");
				return "redirect:/detail/group?group_id="+ group_id;
			}else {
				service.insertGroupLike(member_id, group_id);
				logger.info("관심종목 추가 성공");
			}
		}else {
	        return "login";		
		}
		
		return "redirect:/detail/group?group_id="+ group_id;
	}
	
	@RequestMapping("/shop/addAuctionLike")
	public String addAuctionLike(
			HttpServletRequest request, 
			@RequestParam("auction_id") int auction_id
			)throws Exception {
		HttpSession session = request.getSession();
		
		if(UserSession.hasLogined(session)) {
			String member_id = UserSession.getLoginMemberId(session);
			if(service.getCountLike(member_id, auction_id) > 0) {
				logger.info("이미 관심종목 존재");
				service.deleteAuctionLike(member_id, auction_id);
				logger.info("관심종목 삭제 성공");
				return "redirect:/detail/auction?auction_id="+ auction_id;
			}else {
				service.insertAuctionLike(member_id, auction_id);
				logger.info("관심종목 추가 성공");
			}
		}else {
	        return "login";		
		}
		
		return "redirect:/detail/auction?auction_id="+ auction_id;
	}

	@RequestMapping("/delete/itemLike") // 직거래 삭제
	public String deleteItemLike(
			HttpServletRequest request,
			@ModelAttribute("item_id") int item_id
			) throws Exception {

		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		service.deleteItemLike(member_id, item_id);
		logger.info("관심종목 삭제 성공");
		
		return "redirect:/detail/item?item_id="+ item_id;
	}
	
	@RequestMapping("/delete/groupLike") // 공구 삭제
	public String deleteGroupLike(
			HttpServletRequest request,
			@ModelAttribute("group_id") int group_id
			) throws Exception {

		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		service.deleteGroupLike(member_id, group_id);
		logger.info("관심종목 삭제 성공");
		
		return "redirect:/detail/group?group_id="+ group_id;
	}
	
	@RequestMapping("/delete/auctionLike") // 경매 삭제
	public String deleteAuctionLike(
			HttpServletRequest request,
			@ModelAttribute("auction_id") int auction_id
			) throws Exception {

		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		service.deleteAuctionLike(member_id, auction_id);
		logger.info("관심종목 삭제 성공");
		
		return "redirect:/detail/auction?auction_id="+ auction_id;
	}
	
	@RequestMapping("/delete/itemLike2") // 직거래 삭제
	public String deleteItemLike2(
			HttpServletRequest request,
			@ModelAttribute("item_id") int item_id
			) throws Exception {

		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		service.deleteItemLike(member_id, item_id);
		logger.info("관심종목 삭제 성공");
		
		return "redirect:/member/likes1";
	}
	
	@RequestMapping("/delete/groupLike2") // 공구 삭제
	public String deleteGroupLike2(
			HttpServletRequest request,
			@ModelAttribute("group_id") int group_id
			) throws Exception {

		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		service.deleteGroupLike(member_id, group_id);
		logger.info("관심종목 삭제 성공");
		
		return "redirect:/member/likes2";
	}
	
	@RequestMapping("/delete/auctionLike2") // 경매 삭제
	public String deleteAuctionLike2(
			HttpServletRequest request,
			@ModelAttribute("auction_id") int auction_id
			) throws Exception {

		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		service.deleteAuctionLike(member_id, auction_id);
		logger.info("관심종목 삭제 성공");
		
		return "redirect:/member/likes3";
	}
}

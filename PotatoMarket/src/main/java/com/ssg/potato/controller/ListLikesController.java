package com.ssg.potato.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.service.LikeService;

@Controller
@SessionAttributes("{productList, category}")
public class ListLikesController {

	@Autowired
	private LikeService like;

	@Autowired
	public void setLikeService(LikeService like) {
		this.like = like;
	}

	// 구매내역 페이지 이동
	@RequestMapping(value = "/member/likes1", method = RequestMethod.GET)
	public String likes1(HttpServletRequest request, ModelMap model) throws Exception {
		HttpSession session = request.getSession();
		String move = "";
		if (UserSession.hasLogined(session)) {
			String member_id = UserSession.getLoginMemberId(session);

			List<ItemThumb> itemList = new ArrayList<>(this.like.findItemLikes(member_id));
			model.put("productList", itemList);
			model.put("category", 1);
			move = "likes";
		} else {
			move = "login";
		}
		return move;
	}

	// 구매내역 페이지 이동
	@RequestMapping(value = "/member/likes2", method = RequestMethod.GET)
	public String likes2(HttpServletRequest request, ModelMap model) throws Exception {
		String member_id = UserSession.getLoginMemberId(request.getSession());
		String move = "";

		List<GroupThumb> itemGList = new ArrayList<>(this.like.findGItemLikes(member_id));

		model.put("productList", itemGList);
		model.put("category", 2);
		move = "likes";
		return move;
	}

	// 구매내역 페이지 이동
	@RequestMapping(value = "/member/likes3", method = RequestMethod.GET)
	public String likes3(HttpServletRequest request, ModelMap model) throws Exception {
		String member_id = UserSession.getLoginMemberId(request.getSession());
		String move = "";

		List<AuctionThumb> itemAList = new ArrayList<>(this.like.findAItemLikes(member_id));
		model.put("productList", itemAList);
		model.put("category", 3);
		move = "likes";
		return move;
	}

}
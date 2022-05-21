package com.ssg.potato.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.service.HistoryService;

@Controller
public class ItemHistoryController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ItemHistoryController.class);

	@Autowired
	private HistoryService history;
	
	
	public HistoryService getHistory() {
		return history;
	}


	public void setHistory(HistoryService history) {
		this.history = history;
	}


	public static org.slf4j.Logger getLogger() {
		return logger;
	}


	//구매내역 페이지 이동
	@RequestMapping(value = "/member/purchaseDetail1", method = RequestMethod.GET)
	public String salesDetail1(HttpServletRequest request, ModelMap model) throws Exception{
		String member_id = UserSession.getLoginMemberId(request.getSession());
		String move = "";
		
		PagedListHolder<ItemThumb> itemList = new PagedListHolder<>(this.history.findItem(member_id));
		model.put("productList", itemList);
		model.put("category", 1);
		move = "purchaseDetail";			
		return move;		
	}
	//구매내역 페이지 이동
	@RequestMapping(value = "/member/purchaseDetail2", method = RequestMethod.GET)
	public String salesDetail2(HttpServletRequest request, ModelMap model) throws Exception{
		String member_id = UserSession.getLoginMemberId(request.getSession());
		String move = "";
		
		PagedListHolder<GroupThumb> itemGList = new PagedListHolder<>(this.history.findGItem(member_id));
		model.put("productList", itemGList);
		model.put("category", 2);
		move = "purchaseDetail";			
		return move;		
	}
	//구매내역 페이지 이동
	@RequestMapping(value = "/member/purchaseDetail3", method = RequestMethod.GET)
	public String salesDetail3(HttpServletRequest request, ModelMap model) throws Exception{
		String member_id = UserSession.getLoginMemberId(request.getSession());
		String move = "";
		
		PagedListHolder<AuctionThumb> itemAList = new PagedListHolder<>(this.history.findAItem(member_id));
		itemAList.setPageSize(20);
		model.put("productList", itemAList);
		model.put("category", 3);
		move = "purchaseDetail";			
		return move;		
	}

}


package com.ssg.potato.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.Bid;
import com.ssg.potato.domain.Group;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.service.AuctionService;
import com.ssg.potato.service.BidService;
import com.ssg.potato.service.CartService;
import com.ssg.potato.service.SucbidService;

@Controller
public class CartController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CartController.class);

	private CartService service;
	
	private SucbidService sucbid;

	private BidService bid;

	private AuctionService auction;
	
	@Autowired
	public void setCartService(CartService service) {
		this.service = service;
	}
	
	@Autowired
	public void setSucbidService(SucbidService sucbid) {
		this.sucbid = sucbid;
	}
	
	@Autowired
	public void setBidService(BidService bid) {
		this.bid = bid;
	}
	
	@Autowired 
	public void setAuctionService(AuctionService auction) {
		this.auction = auction;
	}

	
	@RequestMapping("/shop/viewCart1")
	public String viewCart1(
			HttpServletRequest request,
			ModelMap model
			) throws Exception {
		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		
		List<ItemThumb> itemList = new ArrayList<>(this.service.getItemListById(member_id));
		model.put("productList", itemList);
		model.put("category", 1);
		
		return "cart";
	}
	
	@RequestMapping("/shop/viewCart2")
	public String viewCart2(
			HttpServletRequest request,
			ModelMap model
			) throws Exception {
		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		
		List<GroupThumb> groupList = new ArrayList<>(this.service.getGroupListById(member_id));
		model.put("productList", groupList);
		model.put("category", 2);
		
		return "cart";
	}
	
	@RequestMapping("/shop/viewCart3")
	public String handleRequest3(
			HttpServletRequest request,
			ModelMap model
			) throws Exception {
		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);

		List<AuctionThumb> sucbidList = new ArrayList<>(this.sucbid.getNoConfirmSucbidListById(member_id));
		model.put("productList", sucbidList);
		model.put("category", 3);
		
		return "cart";
	}
	
	@RequestMapping("/item/delete")//직거래 삭제
	public String delete(
			HttpServletRequest request,
			@ModelAttribute("item_id") int item_id) 
			throws Exception {
		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		
		service.deleteItemReserve(member_id, item_id);
		
		return "redirect:/shop/viewCart1";
	}

	@RequestMapping("/group/purchase")//공동 구매 결제
	public String purchase1(
			HttpServletRequest request,
			ModelMap model,
			@ModelAttribute("group_id") int group_id) 
			throws Exception {
		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		
		Group group = service.getGroupReserve(group_id);
		logger.info("현재 인원" + group.getCurrentPeople());
		
		service.insertGroupPurchase(group, member_id);
		
		model.put("product", group);
		
		return "purchaseResult";
	}
	
	@RequestMapping("/group/delete")//공동 구매 삭제
	public String delete1(
			HttpServletRequest request,
			@ModelAttribute("group_id") int group_id) 
			throws Exception {
		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);
		
		service.deleteGroupReserve(member_id, group_id);
		
		return "redirect:/shop/viewCart2";
	}
	
	@RequestMapping("/auction/purchase") // 경매 - 최종 구매 확정
	public String purchase2(
			HttpServletRequest request,
			ModelMap model,
			@ModelAttribute("auction_id") int auction_id) 
			throws Exception {
		
		sucbid.updateConfirm(auction_id);
		logger.info("최종 구매 확정 -> 최종 낙찰자");
		
		HttpSession session = request.getSession();
		String member_id = UserSession.getLoginMemberId(session);		
		String seller_id = auction.selectAuction(auction_id).getMember_id();
		int payment = sucbid.selectSucbid(auction_id).getSucbid_price();		
		
		sucbid.insertAuctionPurchase(seller_id, auction_id, member_id, payment);
		logger.info("purchaseHistory 테이블에 저장 성공!");

		AuctionThumb result = sucbid.selectSucbid(auction_id);
		
		model.put("result", result);
		
		return "purchaseResultAuction";
	}
	
	@RequestMapping("/auction/delete") // 경매 - 낙찰 포기
	public String delete2(
			HttpServletRequest request,
			@ModelAttribute("auction_id") int auction_id) 
			throws Exception {
		HttpSession session = request.getSession();
		String buyer_id = UserSession.getLoginMemberId(session);
		
		sucbid.deleteSucbid(auction_id, buyer_id);
		logger.info("낙찰 포기 성공");
		
		int high_price = bid.selectBidHighBidPrice(auction_id);
		Bid b = bid.selectBid(auction_id, high_price);
		sucbid.deleteBid(auction_id, buyer_id, b.getBid_id());
		logger.info("입찰 테이블에서도 삭제");		
			
		if (bid.dataCountBidCheck(auction_id) != 0) {
			int new_high_price = bid.selectBidHighBidPrice(auction_id);
			Bid newB = bid.selectBid(auction_id, new_high_price);
			sucbid.updateNoConfirmSucbid(auction_id, newB.getBuyer_id(), newB.getBid_id(), new_high_price);	
			logger.info("후순위자 낙찰자 다시 선정 성공! ");	
		} else {
			logger.info("더이상의 후순위자가 없음.");	
		}

		return "redirect:/shop/viewCart3";
	}

}

package com.ssg.potato.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.potato.domain.Auction;
import com.ssg.potato.service.AuctionServiceImpl;
import com.ssg.potato.service.BidServiceImpl;

@Controller
public class BidAddController {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BidAddController.class);

	private BidServiceImpl bidService;

	private AuctionServiceImpl auctionService;

	@Autowired
	public void setBidService(BidServiceImpl service) {
		this.bidService = service;
	}

	@Autowired
	public void setAuctionService(AuctionServiceImpl service) {
		this.auctionService = service;
	}
	
	@RequestMapping("/bid/bidAdd")
	public String handleRequest(
			@RequestParam("auction_id") int auction_id,
			HttpSession session,
			HttpServletResponse response,
			HttpServletRequest request
			) throws Exception {

		String buyer_id = UserSession.getLoginMemberId(session);

		Auction item = auctionService.selectAuction(auction_id);
		int startPrice = item.getPrice();
		int auction_price = item.getAuctionPrice();

		if (bidService.dataCountBidCheck(auction_id) == 0) {
			bidService.insertBid(auction_id, buyer_id, startPrice + auction_price);
		} else {
			int maxPrice = bidService.selectBidHighBidPrice(auction_id);
			bidService.insertBid(auction_id, buyer_id, maxPrice + auction_price);
		}

		response.setContentType("text/html; charset=UTF-8"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher( "/bid/bidList?auction_id=" + auction_id );
		dispatcher.include( request, response );
		response.getWriter().write("<script>alert('"+ buyer_id + "님, 경매 입찰에 성공하셨습니다!'); </script>");
		response.getWriter().flush();
		
		logger.info("경매 입찰 성공!");

		return null;
	}
}
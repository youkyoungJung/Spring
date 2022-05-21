package com.ssg.potato.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ssg.potato.domain.Bid;
import com.ssg.potato.service.AuctionService;
import com.ssg.potato.service.BidService;

@Controller
@SessionAttributes("bidlist")
public class BidListController {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BidListController.class);

	private BidService service;
	
	private AuctionService auctionService;

	@Autowired
	public void setBidService(BidService service) {
		this.service = service;
	}
	
	@Autowired
	public void setAuctionService(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	@RequestMapping("/bid/bidList")
	public String viewCart(
			@RequestParam("auction_id") int auction_id,
			ModelMap model
			) throws Exception {
		
		String title = auctionService.selectAuction(auction_id).getTitle();
		List<Bid> bidlist = service.selectBidList(auction_id);	
		model.put("title", title);
		model.addAttribute("bidlist", bidlist);
		logger.info("bid table 띄우기 성공! ");
		
		return "bidForm";
	}

}

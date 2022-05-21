package com.ssg.potato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssg.potato.domain.Auction;
import com.ssg.potato.service.AuctionService;

@Controller
public class DetailAuctionController {

private AuctionService service;
	
	@Autowired
	public void setAuctionService(AuctionService service) {
		this.service = service;
	}
	
	@RequestMapping("/detail/auction")
	public String handleRequest(
			@RequestParam("auction_id") int auction_id, 
			ModelMap model) throws Exception {
		Auction item = this.service.selectAuction(auction_id);
		if (item.getFileName() == null) {
			item.setFileName("logo.png");
		}
		model.put("product", item);
		return "auction";
	}
}

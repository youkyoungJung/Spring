package com.ssg.potato.service;

import java.util.List;

import com.ssg.potato.domain.Bid;

public interface BidService {

	List<Bid> selectBidList(int auction_id);

//	List<Bid> selectGoodsBidList(Bid bid);

	void insertBid(int auction_id, String buyer_id, int bid_price);

	int selectBidHighBidPrice(int auction_id);
	
	String selectHighBidPriceBuyer(int auction_id, int bid_price);

	int dataCountBidCheck(int auction_id);
	
	Bid selectBid(int auction_id, int bid_price);
}

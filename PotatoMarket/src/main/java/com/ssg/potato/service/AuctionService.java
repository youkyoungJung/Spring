package com.ssg.potato.service;

import java.util.Date;
import java.util.List;

import com.ssg.potato.domain.Auction;

public interface AuctionService {
	void insert(Auction auction, String member_id);

	void update(Auction auction);

	void delete(int auction_id);
	
	void deleteLike(int auction_id);

	Auction selectAuction(int auction_id);

	List<Auction> selectCloseAuctionId();
	
	void closeAuction(Date curTime);
	
	int selectAuctionId(String member_id);
}

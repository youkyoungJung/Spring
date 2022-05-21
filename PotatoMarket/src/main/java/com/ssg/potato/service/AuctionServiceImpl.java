package com.ssg.potato.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.dao.AuctionDao;
import com.ssg.potato.domain.Auction;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private AuctionDao dao;
	
	public void insert(Auction auction, String member_id) {
		dao.insert(auction, member_id);
	}
	
	public void deleteLike(int auction_id) {
		dao.deleteLike(auction_id);
	}

	public void update(Auction auction) {
		dao.update(auction);
	}

	public void delete(int auction_id) {
		dao.delete(auction_id);
	}

	public Auction selectAuction(int auction_id) {
		return dao.selectAuction(auction_id);
	}
	
	public void closeAuction(Date curTime) {
		dao.closeAuction(curTime);
	}
	
	public List<Auction> selectCloseAuctionId() {
		return dao.selectCloseAuctionId();
	}
	
	public int selectAuctionId(String member_id) {
		return dao.selectAuctionId(member_id);
	}

}

package com.ssg.potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.domain.Bid;
import com.ssg.potato.dao.BidDao;

@Service
@Transactional
public class BidServiceImpl implements BidService {

	@Autowired
	private BidDao dao;

	// 입찰자 리스트 조회
	public List<Bid> selectBidList(int auction_id) {
		return dao.selectBidList(auction_id);
	}

	// 품목별 입찰자 리스트 조회
	//	public List<Bid> selectGoodsBidList(Bid bid) {
	//		return dao.selectGoodsBidList(bid);
	//	}

	// 입찰 버튼 클릭 시 insert
	public void insertBid(int auction_id, String buyer_id, int bid_price) {
		dao.insertBid(auction_id, buyer_id, bid_price);
	}

	// 최고 입찰 금액
	public int selectBidHighBidPrice(int auction_id) {
		return dao.selectBidHighBidPrice(auction_id);
	}

	// 최고 입찰 금액의 입찰자 아이디
	public String selectHighBidPriceBuyer(int auction_id, int bid_price) {
		return dao.selectHighBidPriceBuyer(auction_id, bid_price);
	}

	//입찰 테이블 데이터 개수 확인
	public int dataCountBidCheck(int auction_id) {
		return dao.dataCountBidCheck(auction_id);
	}
	
	// 최고 입찰 금액의 입찰자 정보
	public Bid selectBid(int auction_id, int bid_price) {
		return dao.selectBid(auction_id, bid_price);
	}

}

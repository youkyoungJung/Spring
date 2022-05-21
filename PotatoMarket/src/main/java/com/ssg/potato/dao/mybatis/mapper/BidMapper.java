package com.ssg.potato.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssg.potato.domain.Bid;

@Mapper
public interface BidMapper {
	
	List<Bid> selectBidList(int auction_id);

//	List<Bid> selectGoodsBidList(Bid bid);

	void insertBid(int auction_id, String buyer_id, int bid_price);

	int selectBidHighBidPrice(int auction_id);

	String selectHighBidPriceBuyer(int auction_id, int bid_price);
	
	Bid selectBid(int auction_id, int bid_price);
	
	int dataCountBidCheck(int auction_id);

}

package com.ssg.potato.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssg.potato.domain.Auction;

@Mapper
public interface AuctionMapper {
	
	void insert(@Param("auction")Auction auction, @Param("member_id") String member_id);

	void update(@Param("auction")Auction auction);

	void delete(int auction_id);
	
	void deleteLike(int auction_id);

	Auction selectAuction(int auction_id);
	
	List<Auction> selectCloseAuctionId();
	
	void closeAuction(Date curTime);
	
	int selectAuctionId(String member_id);
}

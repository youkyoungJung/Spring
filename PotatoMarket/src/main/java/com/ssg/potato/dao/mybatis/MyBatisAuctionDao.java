package com.ssg.potato.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.AuctionDao;
import com.ssg.potato.dao.mybatis.mapper.AuctionMapper;
import com.ssg.potato.domain.Auction;

@Repository
public class MyBatisAuctionDao implements AuctionDao {

	@Autowired
	private AuctionMapper auctionMapper;

	// 추가(삽입)
	@Override
	public void insert(Auction auction, String member_id) throws DataAccessException {
		auctionMapper.insert(auction, member_id);
	}
	
	// 수정(업데이트)
	@Override
	public void update(Auction auction) throws DataAccessException{
		auctionMapper.update(auction);
	}

	// 삭제(delete)
	@Override
	public void delete(int auction_id) throws DataAccessException {
		auctionMapper.delete(auction_id);
	}

	@Override
	public void deleteLike(int auction_id) throws DataAccessException {
		auctionMapper.deleteLike(auction_id);
	}

	// 선택시, 해당 경매 정보 가져오기
	@Override
	public Auction selectAuction(int auction_id) throws DataAccessException {
		return auctionMapper.selectAuction(auction_id);
	}
	
	@Override
	public List<Auction> selectCloseAuctionId() throws DataAccessException {
		return auctionMapper.selectCloseAuctionId();
	}
	
	@Override
	public void closeAuction(Date curTime) throws DataAccessException {
		auctionMapper.closeAuction(curTime);
	}
	
	@Override
	public int selectAuctionId(String member_id) throws DataAccessException {
		return auctionMapper.selectAuctionId(member_id);
	}

}

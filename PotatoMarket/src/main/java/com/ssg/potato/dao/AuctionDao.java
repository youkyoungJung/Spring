package com.ssg.potato.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.domain.Auction;

public interface AuctionDao {

	// 추가(삽입)
	public void insert(Auction auction, String member_id) throws DataAccessException;
	
	// 수정(업데이트)
	public void update(Auction auction) throws DataAccessException;

	// 삭제(delete)
	public void delete(int auction_id) throws DataAccessException;
	public void deleteLike(int auction_id) throws DataAccessException;

	// 상품 목록에서 선택 시, 해당 경매상품 정보 가져오기
	public Auction selectAuction(int auction_id) throws DataAccessException;

	public List<Auction> selectCloseAuctionId() throws DataAccessException;
	
	public void closeAuction(Date curTime) throws DataAccessException;
	
	public int selectAuctionId(String member_id) throws DataAccessException;

}

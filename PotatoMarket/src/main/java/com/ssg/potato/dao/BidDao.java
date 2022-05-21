package com.ssg.potato.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.domain.Bid;

public interface BidDao {

	// 입찰자 리스트 조회
	public List<Bid> selectBidList(int auction_id) throws DataAccessException;

	// 품목별 입찰자 리스트 조회
	//	public List<Bid> selectGoodsBidList(Bid bid) throws DataAccessException;

	// 입찰 버튼 클릭 시 insert
	public void insertBid(int auction_id, String buyer_id, int bid_price) throws DataAccessException;

	// 최고 입찰 금액
	public int selectBidHighBidPrice(int auction_id) throws DataAccessException;

	// 최고 입찰 금액의 입찰자 아이디
	public String selectHighBidPriceBuyer(int auction_id, int bid_price) throws DataAccessException;

	// 최고 입찰 금액의 입찰자 정보
	public Bid selectBid(int auction_id, int bid_price) throws DataAccessException;

	// 입찰 테이블 데이터 개수 확인
	public int dataCountBidCheck(int auction_id) throws DataAccessException;

}

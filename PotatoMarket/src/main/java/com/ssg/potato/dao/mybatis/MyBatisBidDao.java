package com.ssg.potato.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.BidDao;
import com.ssg.potato.dao.mybatis.mapper.BidMapper;
import com.ssg.potato.domain.Bid;

@Repository
public class MyBatisBidDao implements BidDao {

	@Autowired
	private BidMapper bidMapper;

	// 입찰자 리스트 조회
	@Override
	public List<Bid> selectBidList(int auction_id) throws DataAccessException {
		return bidMapper.selectBidList(auction_id);
	}

	// 품목별 입찰자 리스트 조회
	//	@Override
	//	public List<Bid> selectGoodsBidList(Bid bid) throws DataAccessException {
	//		return bidMapper.selectGoodsBidList(bid);
	//	}

	// 입찰 버튼 클릭 시 insert
	@Override
	public void insertBid(int auction_id, String buyer_id, int bid_price) throws DataAccessException {
		bidMapper.insertBid(auction_id, buyer_id, bid_price);
	}

	// 최고 입찰 금액
	@Override
	public int selectBidHighBidPrice(int auction_id) throws DataAccessException {
		return bidMapper.selectBidHighBidPrice(auction_id);
	}

	// 최고 입찰 금액의 입찰자 아이디
	@Override
	public String selectHighBidPriceBuyer(int auction_id, int bid_price) throws DataAccessException {
		return bidMapper.selectHighBidPriceBuyer(auction_id, bid_price);
	}

	// 최고 입찰 금액의 입찰자 정보
	@Override
	public Bid selectBid(int auction_id, int bid_price) throws DataAccessException {
		return bidMapper.selectBid(auction_id, bid_price);
	}


	//입찰 테이블 데이터 개수 확인
	@Override
	public int dataCountBidCheck(int auction_id) throws DataAccessException {
		return bidMapper.dataCountBidCheck(auction_id);
	}

}

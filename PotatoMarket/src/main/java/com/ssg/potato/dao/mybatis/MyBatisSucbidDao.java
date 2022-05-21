package com.ssg.potato.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.SucbidDao;
import com.ssg.potato.dao.mybatis.mapper.SucbidMapper;
import com.ssg.potato.domain.AuctionThumb;

@Repository
public class MyBatisSucbidDao implements SucbidDao {

	@Autowired
	private SucbidMapper sucbidMapper;

	// 낙찰자 insert -> 최초 낙찰자 선정(최종 낙찰 아니고 중간 단계임!)
	@Override
	public void insertNoConfirmSucbid(int auction_id, String buyer_id, int bid_id, int sucbid_price) throws DataAccessException {
		sucbidMapper.insertNoConfirmSucbid(auction_id, buyer_id, bid_id, sucbid_price);
	}

	// 낙찰 포기 시, delete
	@Override
	public void deleteSucbid(int auction_id, String buyer_id) throws DataAccessException {
		sucbidMapper.deleteSucbid(auction_id, buyer_id);
	}

	// 최종 낙찰 확정 후, confirm 1로 변경(이때, 최종 낙찰이 됨!)
	@Override
	public void updateConfirm(int auction_id) throws DataAccessException {
		sucbidMapper.updateConfirm(auction_id);
	}

	// 낙찰자 update(insert) -> 후 순위자 낙찰 선정
	@Override
	public void updateNoConfirmSucbid(int auction_id, String buyer_id, int bid_id, int sucbid_price) throws DataAccessException {
		sucbidMapper.updateNoConfirmSucbid(auction_id, buyer_id, bid_id, sucbid_price);
	}

	// 최종 낙찰 확정 후, 조회
	@Override
	public AuctionThumb selectSucbid(int auction_id) throws DataAccessException {
		return sucbidMapper.selectSucbid(auction_id);
	}

	// 결제
	@Override
	public void insertAuctionPurchase(String seller_id, int transaction_id, String member_id, int payment) throws DataAccessException {
		sucbidMapper.insertAuctionPurchase(seller_id, transaction_id, member_id, payment);
	}

	// 낙찰 내역 조회(장바구니에 담겨져 있을 때 : 구매확정 X )
	@Override
	public List<AuctionThumb> getNoConfirmSucbidListById(String member_id) throws DataAccessException {
		return sucbidMapper.getNoConfirmSucbidListById(member_id);
	}
	
	// 해당 상품이 insert가 되었는지 확인 
	@Override
	public int getCountAuctionId(int auction_id) throws DataAccessException {
		return sucbidMapper.getCountAuctionId(auction_id);
	}
	
	// 해당 상품이 최종 낙찰된 상품인지 확인
	@Override
	public int getCountOKConfirmAuctionId(int auction_id) throws DataAccessException {
		return sucbidMapper.getCountOKConfirmAuctionId(auction_id);
	}
	
	// 낙찰 포기 시, bid 테이블에서도 삭제 delete
	@Override
	public void deleteBid(int auction_id, String buyer_id, int bid_id) throws DataAccessException {
		sucbidMapper.deleteBid(auction_id, buyer_id, bid_id);
	}
}

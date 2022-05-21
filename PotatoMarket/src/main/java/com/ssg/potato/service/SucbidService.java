package com.ssg.potato.service;

import java.util.List;

import com.ssg.potato.domain.AuctionThumb;

public interface SucbidService {

	// 낙찰자 insert -> 최초 낙찰자 선정(최종 낙찰 아니고 중간 단계임!)
	public void insertNoConfirmSucbid(int auction_id, String buyer_id, int bid_id, int sucbid_price);

	// 낙찰 포기 시, delete
	public void deleteSucbid(int auction_id, String buyer_id);

	// 낙찰 포기 시, bid 테이블에서도 삭제 delete
	public void deleteBid(int auction_id, String buyer_id, int bid_id);

	// 낙찰자 update(insert) -> 후 순위자 낙찰 선정
	public void updateNoConfirmSucbid(int auction_id, String buyer_id, int bid_id, int sucbid_price);

	// 최종 낙찰 확정 후, confirm 1로 변경(이때, 최종 낙찰이 됨!)
	public void updateConfirm(int auction_id);

	// 낙찰 내역 조회(장바구니에 담겨져 있을 때 : 구매확정 X )
	public List<AuctionThumb> getNoConfirmSucbidListById(String member_id);

	// 최종 낙찰 확정 정보 조회
	public AuctionThumb selectSucbid(int auction_id);

	// 결제
	public void insertAuctionPurchase(String seller_id, int transaction_id, String member_id, int payment);

	public int getCountAuctionId(int auction_id);

	public int getCountOKConfirmAuctionId(int auction_id);
}

package com.ssg.potato.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bid implements Serializable {
	
	private int bid_id;			// 입찰 아이디
	private int bid_price;		// 입찰 가격
	private String bid_date;	// 입찰 일자	
	private String buyer_id;	// 구매자 아이디
	private String seller_id;	// 판매자 아이디
	private int rank;			// 입찰 순위
	private int auction_id;		// 경매 물품 아이디

	public Bid() {

	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public int getBid_price() {
		return bid_price;
	}

	public void setBid_price(int bid_price) {
		this.bid_price = bid_price;
	}

	public String getBid_date() {
		return bid_date;
	}

	public void setBid_date(String bid_date) {
		this.bid_date = bid_date;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getAuction_id() {
		return auction_id;
	}

	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}
	
}

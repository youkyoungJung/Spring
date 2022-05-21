package com.ssg.potato.domain;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Sucbid implements Serializable {
	
	private int sucbid_id;			// 낙찰 아이디
	private int sucbid_price;		// 낙찰 가격
	private Date sucbid_date;		// 낙찰 일자	
	private String buyer_id;		// 구매자 아이디
	private int auction_id;			// 경매 물품 아이디
	private int bid_id;				// 입찰 아이디
	private int confirm;			
	
	public Sucbid() {

	}

	public int getSucbid_id() {
		return sucbid_id;
	}

	public void setSucbid_id(int sucbid_id) {
		this.sucbid_id = sucbid_id;
	}

	public int getSucbid_price() {
		return sucbid_price;
	}

	public void setSucbid_price(int sucbid_price) {
		this.sucbid_price = sucbid_price;
	}

	public Date getSucbid_date() {
		return sucbid_date;
	}

	public void setSucbid_date(Date sucbid_date) {
		this.sucbid_date = sucbid_date;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public int getAuction_id() {
		return auction_id;
	}

	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}
	
	public int getConfirm() {
		return confirm;
	}

	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}
	
}

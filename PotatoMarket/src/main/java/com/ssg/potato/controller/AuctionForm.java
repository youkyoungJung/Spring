package com.ssg.potato.controller;

import java.io.Serializable;

import com.ssg.potato.domain.Auction;

@SuppressWarnings("serial")
public class AuctionForm implements Serializable {
	private Auction auction;
	
	private boolean newAuction;
	
	public AuctionForm(Auction auction) {
		this.auction = auction;
		this.newAuction = false;
	}
	
	public AuctionForm() {
		this.auction = new Auction();
		this.newAuction = true;
	}
	
	public Auction getAuction() {
		return auction;
	}
	
	public boolean isNewAuction() {
		return newAuction;
	}
}

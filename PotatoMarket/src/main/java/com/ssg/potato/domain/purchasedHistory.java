package com.ssg.potato.domain;

import java.sql.Date;

public class purchasedHistory {
	private int purchase_id;
	private String seller_id;
	private int transaction;
	private int transaction_id;
	private Date purchasedDate;
	private String member_id;
	
	public purchasedHistory() {}
	public purchasedHistory(int purchase_id, String seller_id, int transaction,
			int transaction_id, Date purchasedDate, String member_id) {
		this.purchase_id = purchase_id;
		this.seller_id = seller_id;
		this.transaction = transaction;
		this.transaction_id = transaction_id;
		this.purchasedDate = purchasedDate;
		this.member_id = member_id;
		
	}
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public int getTransaction() {
		return transaction;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	

}

package com.ssg.potato.domain;

import java.sql.Date;

public class salesHistory {
	private int sales_id;
	private String buyer_id;
	private int transaction;
	private int transaction_id;
	private Date saleDate;
	private String member_id;
	
	public salesHistory(){}
	public salesHistory(int sales_id, String buyer_id, int transaction, int transaction_id
			, Date saleDate, String member_id){
		this.sales_id = sales_id;
		this.buyer_id = buyer_id;
		this.transaction = transaction;
		this.transaction_id = transaction_id;
		this.saleDate = saleDate;
		this.member_id = member_id;
	}
	public salesHistory(int sales_id, String buyer_id){
		this.sales_id = sales_id;
		this.buyer_id = buyer_id;
	}
	
	public int getSales_id() {
		return sales_id;
	}
	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
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
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
	
}

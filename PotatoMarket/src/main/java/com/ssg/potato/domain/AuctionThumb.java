package com.ssg.potato.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="AUCTION")
public class AuctionThumb implements Serializable{

	@Id
	@Column
	private int auction_id;			// 경매 물품 아이디
	
	@Column
	private String title;			// 상품명
	
	@Column
	private int price;				// 시작 가격
	
	@Column(name="AUCTIONPRICE")
	private int auctionPrice;		// 입찰 단위
	
	@Column
	private Date start_date;		// 경매 시작일
	
	@Column
	private Date end_date;			// 경매 종료일
	
	@Column
	private String status;			// 상태
	
	@Column(name="FILENAME")
	private String fileName;		// 이미지 파일 이름
	
	@Transient
	private int sucbid_price;		// 최고 낙찰 금액
	
	@Transient
	private Date purchasedDate; 
	
	@Transient
	private int payment;
	
	public AuctionThumb() {

	}
	public int getAuction_id() {
		return auction_id;
	}
	public void setAuction_id(int auction_id) {
		this.auction_id = auction_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getSucbid_price() {
		return sucbid_price;
	}
	public void setSucbid_price(int sucbid_price) {
		this.sucbid_price = sucbid_price;
	}
	
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
}
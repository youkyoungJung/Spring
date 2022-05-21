package com.ssg.potato.domain;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Auction implements Serializable{

	private int auction_id;			// 경매 물품 아이디
	private String title;			// 상품명
	private String content;			// 상세 내용
	private int price;				// 시작 가격
	private int auctionPrice;		// 입찰 단위
	private Date start_date;		// 경매 시작일
	private Date end_date;			// 경매 종료일
	private String member_id;		// 회원 아이디
	private int likes;				// 좋아요 수
	private String status;			// 상태
	private String fileName;     	// 저장할 파일
	

	public Auction() {

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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
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
}

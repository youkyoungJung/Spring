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
@Table(name="GROUPITEM")
public class GroupThumb implements Serializable {
	
	@Id
	@Column
	private int group_id;
	
	@Column
	private String title;
	
	@Column(name="DISCOUNTPRICE")
	private int discountPrice;
	
	@Column(name="CURRENTPEOPLE")
	private int currentPeople;
	
	@Column
	private String status;
	
	@Column(name="FILENAME")
	private String fileName;
	
	@Transient
	private Date purchasedDate; 
	
	@Transient
	private int price;
	
	public GroupThumb( ) {}
	
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getCurrentPeople() {
		return currentPeople;
	}

	public void setCurrentPeople(int currentPeople) {
		this.currentPeople = currentPeople;
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

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Date getPurchasedDate() {
		return purchasedDate;
	}
	
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}


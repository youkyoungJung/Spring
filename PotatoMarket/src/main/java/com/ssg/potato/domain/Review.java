package com.ssg.potato.domain;

public class Review{
	   private int review_id;
	   private String text;
	   private String member_id;
	   private int purchase_id;
	   
	   public Review() {}
	   
	   public Review(int review_id, String text) {
	      super();      
	      this.text = text;
	      this.review_id = review_id;
	   }
	   
	   public Review(int review_id, String text, String member_id, int purchase_id) {
	      super();
	      this.review_id = review_id;
	      this.text = text;
	      this.member_id = member_id;
	      this.purchase_id = purchase_id;
	   }

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}


	   
	}
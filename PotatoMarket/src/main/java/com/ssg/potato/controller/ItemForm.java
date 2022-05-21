package com.ssg.potato.controller;

import java.io.Serializable;

import com.ssg.potato.domain.Item;

@SuppressWarnings("serial")
public class ItemForm implements Serializable {
	private Item item;
	
	private boolean newItem;
	
	public ItemForm(Item item) {
		this.item = item;
		this.newItem = false;
	}
	
	public ItemForm() {
		this.item = new Item();
		this.newItem = true;
	}
	
	public Item getItem() {
		return item;
	}
	
	public boolean isNewItem() {
		return newItem;
	}
}

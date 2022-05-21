package com.ssg.potato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.dao.ItemDao;
import com.ssg.potato.domain.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao dao;
	
	public Item selectItem(int item_id) {
		return dao.selectItem(item_id);
	}

	public void insert(Item item, String member_id) {
		dao.insert(item, member_id);
		
	}
	
	public int selectItemId(String member_id) {
		return dao.selectItemId(member_id);
	}


	public void update(Item item) {
		dao.update(item);
	}

	public void delete(int item_id) {
		dao.delete(item_id);
		dao.deleteLike(item_id);
	}

	public void updateComplete(int item_id, String member_id) {
		dao.updateComplete(item_id,member_id);
		Item item = dao.selectItem(item_id);
		dao.insertItemPurchase(item);
		dao.deleteReserve(item_id);
	}

	@Override
	public void reserve(int item_id, String member_id) {
		dao.reserve(item_id, member_id);
	}

}

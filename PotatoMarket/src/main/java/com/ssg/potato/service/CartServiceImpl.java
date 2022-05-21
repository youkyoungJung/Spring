package com.ssg.potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.dao.CartDao;
import com.ssg.potato.domain.Group;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.Item;
import com.ssg.potato.domain.ItemThumb;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cart;
	
	//item
	public Item getItemReserve(int group_id) {
		return cart.getItemReserve(group_id);
	}

	public List<ItemThumb> getItemListById(String member_id) {
		return cart.getItemListById(member_id);
	}
	
	@Override
	public void deleteItemReserve(String member_id, int item_id) {
		cart.deleteItemReserve(member_id, item_id);
	}

	//group
	public void insertGroupReserve(String member_id, int group_id) {
		cart.insertGroupReserve(member_id, group_id);
	}

	public void deleteGroupReserve(String member_id , int group_id) {
		cart.deleteGroupReserve(member_id, group_id);
	}

	public Group getGroupReserve(int group_id) {
		return cart.getGroupReserve(group_id);
	}

	public List<GroupThumb> getGroupListById(String member_id) {
		return cart.getGroupListById(member_id);
	}
	
	@Override
	public int getCountReserve(String member_id, int group_id) {
		return cart.getCountReserve(member_id, group_id);
	}

	@Override
	public void insertGroupPurchase(Group group, String member_id) {
		cart.insertGroupPurchase(group, member_id);
		cart.deleteGroupReserve(member_id, group.getGroup_id());
		cart.updateAddCurrent(group.getGroup_id());
		int current = group.getCurrentPeople();
		int max = group.getMaxPeople();
		if(current + 1 == max) {
			cart.closeById(group.getGroup_id());
			cart.deleteByClose(group.getGroup_id());
		}
	}
}

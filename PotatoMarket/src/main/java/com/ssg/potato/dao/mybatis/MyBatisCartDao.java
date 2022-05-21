package com.ssg.potato.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.CartDao;
import com.ssg.potato.dao.mybatis.mapper.CartMapper;
import com.ssg.potato.domain.Group;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.Item;
import com.ssg.potato.domain.ItemThumb;

@Repository
public class MyBatisCartDao implements CartDao{
	
	@Autowired
	private CartMapper cartMapper;

	//장바구니 담기
	@Override
	public void insertGroupReserve(String member_id, int group_id ) throws DataAccessException{
		cartMapper.insertGroupReserve(member_id, group_id);
	}
	
	// 삭제(delete)
	@Override
	public void deleteGroupReserve(String member_id, int group_id) throws DataAccessException{
		cartMapper.deleteGroupReserve(member_id, group_id);
	}
	
	// 수정(업데이트)
	@Override
	public void updateAddCurrent(int group_id)  throws DataAccessException{
		cartMapper.updateAddCurrent(group_id);
	}

	@Override
	public Group getGroupReserve(int group_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getGroupReserve(group_id);
	}

	@Override
	public List<GroupThumb> getGroupListById(String member_id) throws DataAccessException {
		return cartMapper.getGroupListById(member_id);
	}

	@Override
	public int getCountReserve(String member_id, int group_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return cartMapper.getCountReserve(member_id, group_id);
	}

	@Override
	public void insertGroupPurchase(Group group, String member_id) throws DataAccessException {
		cartMapper.insertGroupPurchase(group, member_id);
	}

	@Override
	public Item getItemReserve(int item_id) throws DataAccessException {
		return cartMapper.getItemReserve(item_id);
	}

	@Override
	public List<ItemThumb> getItemListById(String member_id) throws DataAccessException {
		return cartMapper.getItemListById(member_id);
	}

	@Override
	public void deleteItemReserve(String member_id, int item_id) throws DataAccessException {
		cartMapper.deleteItemReserve(member_id, item_id);
	}

	@Override
	public void closeById(int group_id) throws DataAccessException {
		cartMapper.closeById(group_id);
	}

	@Override
	public void deleteByClose(int group_id) throws DataAccessException {
		cartMapper.deleteByClose(group_id);
	}
	
}

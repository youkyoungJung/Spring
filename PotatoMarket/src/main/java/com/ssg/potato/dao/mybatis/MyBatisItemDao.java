package com.ssg.potato.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.ItemDao;
import com.ssg.potato.dao.mybatis.mapper.ItemMapper;
import com.ssg.potato.domain.Item;

@Repository
public class MyBatisItemDao implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;

	// 선택시, 해당 공동구매 정보 가져오기
	@Override
	public Item selectItem(int item_id) throws DataAccessException {
		return itemMapper.selectItem(item_id);
	}

	@Override
	public void insert(Item item, String member_id) throws DataAccessException {
		itemMapper.insert(item, member_id);

	}

	@Override
	public void update(Item item) throws DataAccessException {
		itemMapper.update(item);

	}

	@Override
	public void delete(int item_id) throws DataAccessException {
		itemMapper.delete(item_id);

	}

	@Override
	public void updateComplete(int item_id, String member_id) throws DataAccessException {
		itemMapper.updateComplete(item_id, member_id);
	}

	@Override
	public void deleteLike(int item_id) throws DataAccessException {
		itemMapper.deleteLike(item_id);
	}

	@Override
	public void reserve(int item_id, String member_id) throws DataAccessException {
		itemMapper.reserve(item_id, member_id);
	}

	@Override
	public void insertItemPurchase(Item item) throws DataAccessException {
		itemMapper.insertItemPurchase(item);
	}

	@Override
	public void deleteReserve(int item_id) throws DataAccessException {
		itemMapper.deleteReserve(item_id);
	}

	@Override
	public int selectItemId(String member_id) throws DataAccessException {
		return itemMapper.selectItemId(member_id);
	}

}

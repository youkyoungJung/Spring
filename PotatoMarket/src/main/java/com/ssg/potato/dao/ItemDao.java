package com.ssg.potato.dao;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.domain.Item;

public interface ItemDao {
	// 선택시, 해당 아이템 정보 가져오기
	public Item selectItem(int item_id) throws DataAccessException;

	// 추가(삽입)
	public void insert(Item item, String member_id) throws DataAccessException;

	// 수정(업데이트)
	public void update(Item item) throws DataAccessException;

	// 삭제(delete)
	public void delete(int item_id) throws DataAccessException;
	
	public void updateComplete(int item_id, String member_id) throws DataAccessException;

	public void deleteLike(int item_id)  throws DataAccessException;
	
	public void reserve(int item_id, String member_id) throws DataAccessException;
	
	public void insertItemPurchase(Item item) throws DataAccessException;
	
	public void deleteReserve(int item_id) throws DataAccessException; 
	
	public int selectItemId(String member_id ) throws DataAccessException; 

}

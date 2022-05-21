package com.ssg.potato.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.domain.Group;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.Item;
import com.ssg.potato.domain.ItemThumb;

public interface CartDao {
	//item
	// 장바구니 저장된 item
	public Item getItemReserve(int item_id) throws DataAccessException;

	// 장바구니 저장된 item
	public List<ItemThumb> getItemListById(String member_id) throws DataAccessException;

	// 장바구니 삭제
	public void deleteItemReserve(String member_id, int item_id) throws DataAccessException;

	//group
	// 장바구니 담기
	public void insertGroupReserve(String member_id, int group_id) throws DataAccessException;

	// 공동구매 예약 삭제
	public void deleteGroupReserve(String member_id, int group_id) throws DataAccessException;

	// 예약시, 현재 인원 추가
	public void updateAddCurrent(int group_id) throws DataAccessException;

	// 공구 예약 찾기
	public Group getGroupReserve(int group_id) throws DataAccessException;

	// 장바구니 저장된 공구 찾기
	public List<GroupThumb> getGroupListById(String member_id) throws DataAccessException;

	// 장바구니에 이미 있나 없나 확인
	public int getCountReserve(String member_id, int group_id) throws DataAccessException;

	// 결제
	public void insertGroupPurchase(Group group, String member_id) throws DataAccessException;

	// 공구 닫기
	public void closeById(int group_id) throws DataAccessException;
	
	public void deleteByClose(int group_id) throws DataAccessException;
}

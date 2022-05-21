package com.ssg.potato.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssg.potato.domain.Item;

@Mapper
public interface ItemMapper {
	Item selectItem(int item_id);

	// 추가(삽입)
	void insert(@Param("item")Item item, @Param("member_id")String member_id);
	
	// 수정(업데이트)
	void update(@Param("item")Item item);

	// 삭제(delete)
	void delete(int item_id);
	
	void updateComplete(int item_id, String member_id);
	
	void deleteLike(int item_id);
	
	void reserve(int item_id, String member_id);
	
	void insertItemPurchase(Item item);
	
	void deleteReserve(int item_id);
	
	int selectItemId(String member_id);
}

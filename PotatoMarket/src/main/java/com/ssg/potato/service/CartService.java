package com.ssg.potato.service;


import java.util.List;


import com.ssg.potato.domain.Group;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.Item;
import com.ssg.potato.domain.ItemThumb;

public interface CartService {

	// 장바구니 담기
	void insertGroupReserve(String member_id, int group_id);

	// 삭제(delete)
	void deleteGroupReserve(String member_id, int group_id);

	// 수정(업데이트)
//	void updateDeleteCurrent(int group_id);

	Group getGroupReserve(int group_id);
	
	List<GroupThumb> getGroupListById(String member_id);
	
	int getCountReserve(String member_id, int group_id);
	
	void insertGroupPurchase(Group group, String member_id);
	
	Item getItemReserve(int item_id) ;
	
	List<ItemThumb> getItemListById(String member_id);
	
	void deleteItemReserve(String member_id, int item_id);
}

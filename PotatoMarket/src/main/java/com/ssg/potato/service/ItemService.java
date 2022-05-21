package com.ssg.potato.service;

import com.ssg.potato.domain.Item;

public interface ItemService {
	Item selectItem(int item_id);

	// 추가(삽입)
	void insert(Item item, String member_id);

	// 수정(업데이트)
	void update(Item item);

	// 삭제(delete)
	void delete(int item_id);
	
	void updateComplete(int item_id, String member_id);
	
	void reserve(int item_id, String member_id );
	
	int selectItemId(String member_id);
}

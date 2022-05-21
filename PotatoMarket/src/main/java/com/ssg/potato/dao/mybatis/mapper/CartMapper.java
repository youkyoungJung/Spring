package com.ssg.potato.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssg.potato.domain.Group;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.Item;
import com.ssg.potato.domain.ItemThumb;

@Mapper
public interface CartMapper {
	//item
	public Item getItemReserve(int group_id);

	public List<ItemThumb> getItemListById(String member_id);

	public void deleteItemReserve(String member_id, int item_id);

	//group
	public void insertGroupReserve(String member_id, int group_id);

	public void deleteGroupReserve(String member_id, int group_id);

	public void updateAddCurrent(int group_id);

	public Group getGroupReserve(int group_id);

	public List<GroupThumb> getGroupListById(String member_id);

	public int getCountReserve(String member_id, int group_id);

	public void insertGroupPurchase(Group group, String member_id);

	public void closeById(int group_id);
	
	public void deleteByClose(int group_id);
}

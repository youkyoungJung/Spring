package com.ssg.potato.service;

import java.util.List;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.domain.Thumb;

public interface SearchService {
	List<GroupThumb> getGroupsList();

	List<ItemThumb> getItemsList();

	List<AuctionThumb> getAuctionsList();

	List<GroupThumb> getGroupsAddList(String member_id);

	List<AuctionThumb> getAuctionsAddList(String member_id);

	List<ItemThumb> getItemsAddList(String member_id);

	List<Thumb> getMainList();

	//검색창 검색
	List<ItemThumb> searchItemList(String title);

	List<GroupThumb> searchGroupList(String title);

	List<AuctionThumb> searchAuctionList(String title);
}

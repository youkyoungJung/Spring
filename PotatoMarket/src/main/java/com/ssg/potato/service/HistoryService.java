package com.ssg.potato.service;

import java.util.List;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

public interface HistoryService {
	List<ItemThumb> findItem(String member_id) throws Exception;
	List<GroupThumb> findGItem(String member_id) throws Exception;
	List<AuctionThumb> findAItem(String member_id) throws Exception;

}

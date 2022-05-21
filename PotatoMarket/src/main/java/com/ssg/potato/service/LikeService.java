package com.ssg.potato.service;

import java.util.List;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

public interface LikeService {

	void insertItemLike(String member_id, int item_id);

	void insertGroupLike(String member_id, int group_id);

	void insertAuctionLike(String member_id, int auction_id);

	// 좋아요 취소
	void deleteItemLike(String member_id, int item_id);
	void deleteGroupLike(String member_id, int group_id);
	void deleteAuctionLike(String member_id, int auction_id);

	// 이미 좋아요 누른 상태인지?
	int getCountLike(String member_id, int transaction_id);
	
	//좋아요 리스트 반환 (직접, 공동, 경매)
	List<ItemThumb> findItemLikes(String member_id) throws Exception;
	List<GroupThumb> findGItemLikes(String member_id) throws Exception;
	List<AuctionThumb> findAItemLikes(String member_id) throws Exception;
}

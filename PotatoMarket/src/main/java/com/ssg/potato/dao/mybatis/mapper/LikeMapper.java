package com.ssg.potato.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

@Mapper
public interface LikeMapper {
	// 좋아요
	public void insertItemLike(String member_id, int item_id);

	public void insertGroupLike(String member_id, int group_id);

	public void insertAuctionLike(String member_id, int auction_id);

	// 좋아요 취소
	public void deleteLike(String member_id, int transaction_id);

	// 이미 좋아요 누른 상태인지?
	public int getCountLike(String member_id, int transaction_id);
	
	public void upItemLike(int item_id);

	public void downItemLike(int item_id);
	
	public void upGroupLike(int group_id);

	public void downGroupLike(int group_id);
	
	public void upAuctionLike(int auction_id);

	public void downAuctionLike(int auction_id);
	
	//리스트반환
	public List<ItemThumb> LikesItemFind(String member_id);
	public List<GroupThumb> LikesGItemFind(String member_id);
	public List<AuctionThumb> LikesAItemFind(String member_id);
}

package com.ssg.potato.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

public interface LikeDao {

	//좋아요 
	public void insertItemLike(String member_id, int group_id) throws DataAccessException;

	public void insertGroupLike(String member_id, int group_id) throws DataAccessException;
	
	public void insertAuctionLike(String member_id, int group_id) throws DataAccessException;
	
	//좋아요 취소
	public void deleteLike(String member_id, int transaction_id) throws DataAccessException;
	
	//이미 좋아요 누른 상태인지?
	public int getCountLike(String member_id, int transaction_id ) throws DataAccessException;

	public void upItemLike(int item_id) throws DataAccessException;
	
	public void downItemLike(int item_id) throws DataAccessException;
	
	public void upGroupLike(int group_id) throws DataAccessException;

	public void downGroupLike(int group_id) throws DataAccessException;
	
	public void upAuctionLike(int auction_id) throws DataAccessException;

	public void downAuctionLike(int auction_id) throws DataAccessException;
	
	//직접거래아이템정보 찾기
	public List<ItemThumb> LikesItemFind(String member_id)throws Exception;
	//공동구매아이템정보 찾기
	public List<GroupThumb> LikesGItemFind(String member_id) throws Exception;
	//경매아이템정보 찾기
	public List<AuctionThumb> LikesAItemFind(String member_id) throws Exception;
}

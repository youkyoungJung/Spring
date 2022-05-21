package com.ssg.potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.dao.LikeDao;
import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

@Service
@Transactional
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	private LikeDao dao;
	
	@Override
	public void insertItemLike(String member_id, int item_id) {
		dao.insertItemLike(member_id, item_id);
		dao.upItemLike(item_id);
	}

	@Override
	public void insertGroupLike(String member_id, int group_id) {
		dao.insertGroupLike(member_id, group_id);
		dao.upGroupLike(group_id);
	}

	@Override
	public void insertAuctionLike(String member_id, int auction_id) {
		dao.insertAuctionLike(member_id, auction_id);
		dao.upAuctionLike(auction_id);
	}

	@Override
	public void deleteItemLike(String member_id, int item_id) {
		dao.deleteLike(member_id, item_id);
		dao.downItemLike(item_id);
	}
	
	@Override
	public void deleteGroupLike(String member_id, int group_id) {
		dao.deleteLike(member_id, group_id);
		dao.downGroupLike(group_id);
	}
	
	@Override
	public void deleteAuctionLike(String member_id, int auction_id) {
		dao.deleteLike(member_id, auction_id);
		dao.downAuctionLike(auction_id);
	}

	@Override
	public int getCountLike(String member_id, int transaction_id) {
		return dao.getCountLike(member_id, transaction_id);
	}
	
	//리스트 반환
	@Override
	public List<ItemThumb> findItemLikes(String member_id) throws Exception {
		return dao.LikesItemFind(member_id);
	}

	@Override
	public List<GroupThumb> findGItemLikes(String member_id) throws Exception {
		return dao.LikesGItemFind(member_id);
	}

	@Override
	public List<AuctionThumb> findAItemLikes(String member_id) throws Exception {
		return dao.LikesAItemFind(member_id);
	}
}

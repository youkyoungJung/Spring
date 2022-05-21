package com.ssg.potato.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.LikeDao;
import com.ssg.potato.dao.mybatis.mapper.LikeMapper;
import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

@Repository
public class MyBatisLikeDao implements LikeDao{
	@Autowired
	private LikeMapper likeMapper;

	@Override
	public void insertItemLike(String member_id, int item_id) throws DataAccessException {
		likeMapper.insertItemLike(member_id, item_id);
		
	}

	@Override
	public void insertGroupLike(String member_id, int group_id) throws DataAccessException {
		likeMapper.insertGroupLike(member_id, group_id);
		
	}

	@Override
	public void insertAuctionLike(String member_id, int auction_id) throws DataAccessException {
		likeMapper.insertAuctionLike(member_id, auction_id);
	}

	@Override
	public void deleteLike(String member_id, int transaction_id) throws DataAccessException {
		likeMapper.deleteLike(member_id, transaction_id);
	}

	@Override
	public int getCountLike(String member_id, int transaction_id) throws DataAccessException {
		return likeMapper.getCountLike(member_id, transaction_id);
	}

	@Override
	public void upItemLike(int item_id) throws DataAccessException {
		likeMapper.upItemLike(item_id);
		
	}

	@Override
	public void downItemLike(int item_id) throws DataAccessException {
		likeMapper.downItemLike(item_id);
		
	}

	@Override
	public void upGroupLike(int group_id) throws DataAccessException {
		likeMapper.upGroupLike(group_id);
	}

	@Override
	public void downGroupLike(int group_id) throws DataAccessException {
		likeMapper.downGroupLike(group_id);
	}

	@Override
	public void upAuctionLike(int auction_id) throws DataAccessException {
		likeMapper.upAuctionLike(auction_id);
	}

	@Override
	public void downAuctionLike(int auction_id) throws DataAccessException {
		likeMapper.downAuctionLike(auction_id);
	}
	
	//리스트반환
	@Override
	public List<ItemThumb> LikesItemFind(String member_id) throws Exception {
		return likeMapper.LikesItemFind(member_id);
	}

	@Override
	public List<GroupThumb> LikesGItemFind(String member_id) throws Exception {
		return likeMapper.LikesGItemFind(member_id);
	}

	@Override
	public List<AuctionThumb> LikesAItemFind(String member_id) throws Exception {
		return likeMapper.LikesAItemFind(member_id);
	}
}

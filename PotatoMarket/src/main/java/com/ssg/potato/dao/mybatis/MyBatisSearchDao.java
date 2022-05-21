package com.ssg.potato.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.SearchDao;
import com.ssg.potato.dao.mybatis.mapper.SearchMapper;
import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.domain.Thumb;

@Repository
public class MyBatisSearchDao implements SearchDao{
	
	@Autowired
	private SearchMapper searchMapper;
	
	public List<GroupThumb> getGroupsList()throws DataAccessException {
		return searchMapper.getGroupsList();
	}
	
	public List<ItemThumb> getItemsList() throws DataAccessException {
		return searchMapper.getItemsList();
	}
	
	public List<AuctionThumb> getAuctionsList() throws DataAccessException {
		return searchMapper.getAuctionsList();
	}

	@Override
	public List<GroupThumb> getGroupsAddList(String member_id) throws DataAccessException {
		return searchMapper.getGroupsAddList(member_id);
	}

	@Override
	public List<ItemThumb> getItemsAddList(String member_id) throws DataAccessException {
		return searchMapper.getItemsAddList(member_id);
	}

	@Override
	public List<AuctionThumb> getAuctionsAddList(String member_id) throws DataAccessException {
		return searchMapper.getAuctionsAddList(member_id);
	}


	@Override
	public List<Thumb> getMainList() throws DataAccessException {
		return searchMapper.getMainList();
	}

}

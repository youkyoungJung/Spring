package com.ssg.potato.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.domain.Thumb;

public interface SearchDao {
	
	public List<GroupThumb> getGroupsList() throws DataAccessException ;
	
	public List<ItemThumb> getItemsList() throws DataAccessException ;
	
	public List<AuctionThumb> getAuctionsList() throws DataAccessException ;
	
	public List<GroupThumb> getGroupsAddList(String member_id) throws DataAccessException ;
	
	public List<ItemThumb> getItemsAddList(String member_id) throws DataAccessException ;
	
	public List<AuctionThumb> getAuctionsAddList(String member_id) throws DataAccessException ;
	
	public List<Thumb> getMainList() throws DataAccessException;
	
}

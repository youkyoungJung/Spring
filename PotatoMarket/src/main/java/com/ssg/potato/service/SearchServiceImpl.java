package com.ssg.potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.dao.SearchDao;
import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.domain.Thumb;
import com.ssg.potato.repository.AuctionSearchRepository;
import com.ssg.potato.repository.GroupSearchRepository;
import com.ssg.potato.repository.ItemSearchRepository;

@Service
@Transactional
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchDao dao;

	@Autowired
	private ItemSearchRepository iRepository;

	@Autowired
	private GroupSearchRepository gRepository;

	@Autowired
	private AuctionSearchRepository aRepositry;

	public List<GroupThumb> getGroupsList(){
		return dao.getGroupsList();
	}

	public List<ItemThumb> getItemsList(){
		return dao.getItemsList();
	}

	public List<AuctionThumb> getAuctionsList(){
		return dao.getAuctionsList();
	}

	@Override
	public List<GroupThumb> getGroupsAddList(String member_id) {
		return dao.getGroupsAddList(member_id);
	}

	@Override
	public List<AuctionThumb> getAuctionsAddList(String member_id) {
		return dao.getAuctionsAddList(member_id);
	}

	@Override
	public List<ItemThumb> getItemsAddList(String member_id) {
		return dao.getItemsAddList(member_id);
	}

	@Override
	public List<Thumb> getMainList() {
		return dao.getMainList();
	}

	//검색창 검색
	public List<ItemThumb> searchItemList(String title){
		return iRepository.findByTitleContaining(title);
	}

	public List<GroupThumb> searchGroupList(String title){
		return gRepository.findByTitleContaining(title);
	}

	public List<AuctionThumb> searchAuctionList(String title){
		return aRepositry.findByTitleContaining(title);
	}
}

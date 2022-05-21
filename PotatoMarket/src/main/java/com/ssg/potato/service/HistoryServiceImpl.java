package com.ssg.potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.dao.HistoryDao;
import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	private HistoryDao dao;
	
	public List<ItemThumb> findItem(String member_id) throws Exception {
		return dao.PurchasedItemFind(member_id);
	}

	@Override
	public List<GroupThumb> findGItem(String member_id) throws Exception {
		return  dao.PurchasedGItemFind(member_id);
	}

	@Override
	public List<AuctionThumb> findAItem(String member_id) throws Exception {
		return  dao.PurchasedAItemFind(member_id);
	}

}

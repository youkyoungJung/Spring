package com.ssg.potato.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.HistoryDao;
import com.ssg.potato.dao.mybatis.mapper.HistoryMapper;
import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;

@Repository
public class MyBatisHistoryDao implements HistoryDao{

	@Autowired
	private HistoryMapper historyMapper;
		
	@Override
	public List<ItemThumb> PurchasedItemFind(String member_id) throws Exception {
		return historyMapper.PurchasedItemFind(member_id);
	}
	@Override
	public List<GroupThumb> PurchasedGItemFind(String member_id) throws Exception {
		return historyMapper.PurchasedGItemFind(member_id);
	}
	@Override
	public List<AuctionThumb> PurchasedAItemFind(String member_id) throws Exception {
		return historyMapper.PurchasedAItemFind(member_id);
	}

}

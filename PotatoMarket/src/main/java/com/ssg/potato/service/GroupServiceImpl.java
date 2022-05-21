package com.ssg.potato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.potato.dao.GroupDao;
import com.ssg.potato.domain.Group;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{
	@Autowired
	private GroupDao dao;
	
	public void insert(Group group, String member_id) {
		dao.insert(group, member_id);
	}

	public void update(Group group) {
		dao.update(group);
	}

	public void delete(int group_id) {
		dao.delete(group_id);
		dao.deleteReserve(group_id);
		dao.deleteLike(group_id);
	}

	public Group selectGroup(int group_id) {
		return dao.selectGroup(group_id);
	}

	@Override
	public int selectGroupId(String member_id) {
		return dao.selectGroupId(member_id);
	}

}

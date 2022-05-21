package com.ssg.potato.dao.mybatis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.GroupDao;
import com.ssg.potato.dao.mybatis.mapper.GroupMapper;
import com.ssg.potato.domain.Group;

@Repository
public class MyBatisGroupDao implements GroupDao {

	@Autowired
	private GroupMapper groupMapper;
	
	// 추가(삽입)
	@Override
	public void insert(Group group, String member_id) throws DataAccessException {
		groupMapper.insert(group, member_id);
	}

	// 수정(업데이트)
	@Override
	public void update(Group group) throws DataAccessException{
		groupMapper.update(group);
	}

	// 삭제(delete)
	@Override
	public void delete(int group_id) throws DataAccessException {
		groupMapper.delete(group_id);
	}

	// 선택시, 해당 공동구매 정보 가져오기
	@Override
	public Group selectGroup(int group_id) throws DataAccessException {
		return groupMapper.selectGroup(group_id);
	}

	@Override
	public void deleteReserve(int group_id) throws DataAccessException {
		groupMapper.deleteReserve(group_id);
	}

	@Override
	public void deleteLike(int group_id) throws DataAccessException {
		groupMapper.deleteLike(group_id);
	}

	@Override
	public int selectGroupId(String member_id) throws DataAccessException {
		return groupMapper.selectGroupId(member_id);
	}
	
	@Override
	public void close(Date curTime) throws DataAccessException {
		groupMapper.close(curTime);
	}

}

package com.ssg.potato.dao;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import com.ssg.potato.domain.Group;

public interface GroupDao {
	// 추가(삽입)
	public void insert(Group group, String member_id) throws DataAccessException;

	// 수정(업데이트)
	public void update(Group group) throws DataAccessException;

	// 삭제(delete)
	public void delete(int group_id) throws DataAccessException;
	public void deleteReserve(int group_id) throws DataAccessException;
	public void deleteLike(int group_id) throws DataAccessException;

	// 선택시, 해당 공동구매 정보 가져오기
	public Group selectGroup(int group_id) throws DataAccessException;
	
	public int selectGroupId(String member_id) throws DataAccessException;
	
	public void close(Date curTime) throws DataAccessException;
	
}

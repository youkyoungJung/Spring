package com.ssg.potato.dao.mybatis.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssg.potato.domain.Group;

@Mapper
public interface GroupMapper {

	void insert(@Param("group")Group group, @Param("member_id") String member_id);

	void update(@Param("group")Group group);

	void delete(int group_id);

	Group selectGroup(int group_id);

	void deleteReserve(int group_id);
	
	void deleteLike(int group_id);
	
	int selectGroupId(String member_id);
	
	void close(Date curTime);
}

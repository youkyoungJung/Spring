package com.ssg.potato.service;

import com.ssg.potato.domain.Group;

public interface GroupService {
	void insert(Group group, String member_id);

	void update(Group group);

	void delete(int group_id);

	Group selectGroup(int group_id);
	
	int selectGroupId(String member_id);
}

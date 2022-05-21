package com.ssg.potato.controller;

import java.io.Serializable;

import com.ssg.potato.domain.Group;

@SuppressWarnings("serial")
public class GroupForm implements Serializable {
	private Group group;
	
	private boolean newGroup;
	
	public GroupForm(Group group) {
		this.group = group;
		this.newGroup = false;
	}
	
	public GroupForm() {
		this.group = new Group();
		this.newGroup = true;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public boolean isNewGroup() {
		return newGroup;
	}
}

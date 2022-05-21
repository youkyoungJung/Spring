package com.ssg.potato.domain;

public class GroupReserve {
	private int reserve_id;
	private int group_id;
	private String member_id;
	
	public GroupReserve() {
	}
	public int getReserve_id() {
		return reserve_id;
	}
	public void setReserve_id(int reserve_id) {
		this.reserve_id = reserve_id;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getUser_id() {
		return member_id;
	}
	public void setUser_id(String user_id) {
		this.member_id = user_id;
	}
	
	
}

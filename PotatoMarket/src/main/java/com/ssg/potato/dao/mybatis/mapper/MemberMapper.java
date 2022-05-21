package com.ssg.potato.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.potato.domain.Member;

@Mapper
public interface MemberMapper {
	///회원가입
	public void memberJoin(Member member);
	
	public Member readMemberWithIDPW(String member_id, String pw);
	
	//public Member memberUpdate(Member member);
	
	public Member memberFind(String member_id);
}

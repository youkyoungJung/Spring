package com.ssg.potato.dao;

import com.ssg.potato.domain.Member;

public interface MemberDao {
	//회원가입
	public void memberJoin(Member member) throws Exception;
	//로그인
	public Member readMemberWithIDPW(String member_id, String pw) throws Exception;
	
	//회원정보 수정
	public void memberUpdate(Member member)throws Exception;
	
	//회원정보 찾기
	public Member memberFind(String member_id)throws Exception;
	
	//회원삭제
	public void memberDelete(String member_id)throws Exception;
}

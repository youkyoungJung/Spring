package com.ssg.potato.dao.mybatis;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.potato.dao.MemberDao;
import com.ssg.potato.domain.Member;

@Repository
public class MyBatisMemberDao implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	//mapper구분하는 값 namespace
	private static final String namespace ="com.ssg.potato.dao.mybatis.mapper.MemberMapper";
	
	@Override
	public void memberJoin(Member member) throws Exception {
		sqlSession.insert(namespace+".memberJoin", member);
	}

	@Override
	public Member readMemberWithIDPW(String member_id, String pw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("member_id", member_id);
		paramMap.put("pw", pw);

		return sqlSession.selectOne(namespace+".readMemberWithIDPW", paramMap);
	}

	@Override
	public void memberUpdate(Member member) throws Exception {
		sqlSession.update(namespace+".memberUpdate", member);
	}

	@Override
	public Member memberFind(String member_id) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("member_id", member_id);
		return sqlSession.selectOne(namespace+".memberFind", paramMap);
		
	}

	@Override
	public void memberDelete(String member_id) throws Exception {
		sqlSession.update(namespace+".memberDelete", member_id);
	}

	

}

package com.ssg.potato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.potato.dao.MemberDao;
import com.ssg.potato.domain.Member;

@Service
public class MemberServiceImpl  implements MemberService{

	@Autowired
	MemberDao dao;
	
	@Override
	public void memberJoin(Member member) throws Exception {
		System.out.println("회원가입 동작");
		if(member == null)
			return;
		dao.memberJoin(member);
	}
	
	@Override
	public Member loginMember(Member vo) {
		System.out.println("S : 컨트롤러에서 호출받으면 필요한 정보를 받아서 DAO로 전달");
		Member returnVO = null;
		try {
			returnVO = dao.readMemberWithIDPW(vo.getMember_id(), vo.getPw());
		} catch (Exception e) {
			e.printStackTrace();
			returnVO = null; //실행하다 문제가 생겼을때 해당 데이터를 보내지않겠다는 의미 = 예외처리
		}
		return returnVO; //null이 반환되면 앞의 코드가 문제가 있다는 것을 바로 알수있다.
	}

	@Override
	public void memberUpdate(Member member) throws Exception {
		dao.memberUpdate(member);
	}


	@Override
	public Member findingMember(Member vo) throws Exception {
		System.out.println("S : findingMember");
		Member member = null;
		try {
			member =  dao.memberFind(vo.getMember_id());
			System.out.println("S: findinMember"+ member);
		} catch (Exception e) {
			e.printStackTrace();
			member = null;
		}
		return member;
	}

	@Override
	public Member memberFind(String member_id) throws Exception {
		return dao.memberFind(member_id);
	}

	@Override
	public void memberDelete(String member_id) throws Exception {
		dao.memberDelete(member_id);	
	}
}

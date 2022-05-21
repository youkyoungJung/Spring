package com.ssg.potato.domain;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;

@SuppressWarnings("serial")
public class Member implements Serializable{
	private String member_id;
	private String pw;
	private String name;
	private String email;
	private String tel;
	
	private String pw2;

	public Member() { }

	public Member(String member_id, String name, String email, String tel) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}

	public Member(String member_id, String pw, String pw2, String name, String email, String tel) {
		super();
		
		this.member_id = member_id;
		this.pw = pw;
		this.pw2 = pw2;
		this.name = name;
		this.email = email;
		this.tel = tel;
	}

	public boolean hasPassword() {
		return pw != null && pw.trim().length() > 0;
	}
	
	@AssertTrue
	public boolean isSamePasswordConfirmPassword() {
		if (pw == null || pw2 == null)
			return false;
		return pw.equals(pw2);
	}
	
	
	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	/* 비밀번호 검사 */
	public boolean matchPassword(String pw) {
		if (pw == null) {
			return false;
		}
		return this.pw.equals(pw);
	}

	public boolean isSameUser(String id) {
		return this.member_id.equals(id);
	}
}
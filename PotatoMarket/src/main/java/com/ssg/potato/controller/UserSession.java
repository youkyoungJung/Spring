package com.ssg.potato.controller;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.support.PagedListHolder;

import com.ssg.potato.domain.Group;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 */
@SuppressWarnings("serial")
public class UserSession implements Serializable {

	public static final String MEMBER_SESSION_KEY = "member_id";
	
	private Group group;
	
	public UserSession(Group group) {
		this.group = group;
	}
	
	private PagedListHolder<Group> myList;
	
	public void setMyList(PagedListHolder<Group> myList) {
		this.myList = myList;
	}

	public PagedListHolder<Group> getMyList() {
		return myList;
	}
	
    /* 현재 로그인한 사용자의 ID를 구함 */
    public static String getLoginMemberId(HttpSession session) {
        String memberId = (String)session.getAttribute(MEMBER_SESSION_KEY);
        return memberId;
    }

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginMemberId(session) != null) {
            return true;
        }
        return false;
    }

    /* 현재 로그인한 사용자의 ID가 memberId인지 검사 */
    public static boolean isLoginUser(String member_id, HttpSession session) {
        String loginMember = getLoginMemberId(session);
        if (loginMember == null) {
            return false;
        }
        return loginMember.equals(member_id);
    }
}

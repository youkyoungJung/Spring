package com.ssg.potato.dao;

import java.util.List;

import com.ssg.potato.domain.Message;

public interface MessageDao {

	//채팅 
	public List<Message> messageList(Message m)throws Exception;

	//메시지함
	public List<Message> messagebox(String caller_id)throws Exception;

	//메시지보내기
	public void messagesend(Message m)throws Exception;
}

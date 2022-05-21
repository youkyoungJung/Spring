package com.ssg.potato.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssg.potato.domain.Message;

@Mapper
public interface MessageMapper {
	
	//채팅 
	public List<Message> messageList(Message m)throws Exception;

	//메시지함
	public List<Message> messagebox(String caller_id)throws Exception;

	//메시지보내기
	public void messagesend(Message m)throws Exception;

}

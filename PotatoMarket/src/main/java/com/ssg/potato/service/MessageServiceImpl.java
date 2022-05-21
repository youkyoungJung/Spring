package com.ssg.potato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.ssg.potato.dao.MessageDao;
import com.ssg.potato.domain.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageDao dao;
	
	@Override
	public List<Message> messageList(Message m) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.messageList(m);
	}

	@Override
	public List<Message> messagebox(String caller_id) throws Exception {
		// TODO Auto-generated method stub
		return dao.messagebox(caller_id);
		
	}

	@Override
	public void  messagesend(Message m)throws Exception{
		// TODO Auto-generated method stub
		dao.messagesend(m);
	}

}

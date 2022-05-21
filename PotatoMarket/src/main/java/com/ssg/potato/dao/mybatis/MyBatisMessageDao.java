package com.ssg.potato.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.ssg.potato.dao.MessageDao;
import com.ssg.potato.dao.mybatis.mapper.MessageMapper;
import com.ssg.potato.domain.Message;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisMessageDao implements MessageDao{

	
	@Autowired
	private MessageMapper messageMapper;
	
	//채팅
	public List<Message> messageList(Message m) throws Exception{
		return messageMapper.messageList(m);
	}
	
	//메세지함
	public List<Message> messagebox(String caller_id) throws Exception{
		
		List<Message> messagebox = messageMapper.messagebox(caller_id);
		
		System.out.println("얘 크기는 " + messagebox.size());
		if (messagebox.size() == 0) {
			
		}
		for(int i = 0; i < messagebox.size(); i++) {
			Message x = messagebox.get(i); // 
			
			for(int j = 0; j < messagebox.size(); j++) {
				Message y = messagebox.get(j);
				
				if(x.getCaller_id().equals(y.getReceiver_id()) && x.getReceiver_id().equals(y.getCaller_id())) {

					if(x.getMessage_id() < y.getMessage_id()) {
						messagebox.remove(x);
						i--;
						break;
					}else {
						messagebox.remove(y);
						j--;
					}				
				}
			
			}				
		}
		
		return messagebox;
	}
	
	//메세지 보내기
	public void messagesend(Message m) throws Exception{
		messageMapper.messagesend(m);
	}
	
}

package com.ssg.potato.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssg.potato.domain.Message;
import com.ssg.potato.service.MessageService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	private MessageService service;

	@Autowired
	public void setMessageService(MessageService service) {
		this.service = service;
	}

	//메세지함
	@RequestMapping("/chat/{caller_id}")
	public ModelAndView messageBox(@PathVariable String caller_id) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		List<Message> messagebox = service.messagebox(caller_id);
		
		mav.addObject("box", messagebox);
		mav.setViewName("talker_list");

		System.out.println("controller");
		return mav;
	}

	//개인당 메시지 주고받음
	@RequestMapping("/chat/{caller_id}/{receiver_id}")
	public ModelAndView messagelist(@PathVariable String caller_id, @PathVariable String receiver_id, Message m) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		m.setCaller_id(caller_id);
		m.setReceiver_id(receiver_id);
		
		List<Message> messagelist = service.messageList(m);

		System.out.println("messagelist 크기 " + messagelist.size());
		
		mav.setViewName("chat");
		
		mav.addObject("list", messagelist);
		mav.addObject("caller", caller_id);
		mav.addObject("receiver", receiver_id);

		return mav;
	}
	
//	//메시지 보내기
	@RequestMapping(value = "/chat/send", method = RequestMethod.POST)
	public ModelAndView messagesend(@ModelAttribute Message m, HttpSession session) throws Exception {
		
		System.out.println("send caller" + m.getCaller_id());
		System.out.println("send reciever" + m.getReceiver_id());
		
		String caller_id = (String)session.getAttribute("member_id");
		
		m.setCaller_id(caller_id);
		
		service.messagesend(m);
		
		String receiver_id = m.getReceiver_id();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/chat/" + caller_id + "/" + receiver_id);
		
		return mav;
	}
	
	
	//rest 이용하여 메세지 받기
	@ResponseBody
	@GetMapping(value = "/chat/{caller_id}/{receiver_id}/list.json", produces="application/json")
	public List<Message> getMessage(@PathVariable String caller_id, @PathVariable String receiver_id, Message m) throws Exception{
		
		
		m.setCaller_id(caller_id);
		m.setReceiver_id(receiver_id);
		
		List<Message> messagelist = service.messageList(m);
		
		return messagelist;
	}
}

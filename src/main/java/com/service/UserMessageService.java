package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.mapper.UserMessageMapper;
import com.entity.UserMessage;
import com.service.iface.UserMessageServiceIface;

@Service
public class UserMessageService implements UserMessageServiceIface {
	
	@Autowired
	public UserMessageMapper userMessageMapper;

	@Override
	public List<UserMessage> findMsgByReceiverId(int receiverId) {
		// TODO Auto-generated method stub
		return userMessageMapper.findMsgByReceiverId(receiverId);
	}

	@Override
	public int updateReadStatus(int receiverId) {
		// TODO Auto-generated method stub
		return userMessageMapper.updateReadStatus(receiverId);
	}
	
	

}

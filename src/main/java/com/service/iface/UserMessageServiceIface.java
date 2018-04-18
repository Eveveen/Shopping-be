package com.service.iface;

import java.util.List;

import com.entity.UserMessage;

public interface UserMessageServiceIface {
	
	public List<UserMessage> findMsgByReceiverId(int receiverId);
	
	
	public int updateReadStatus(int receiverId);

}

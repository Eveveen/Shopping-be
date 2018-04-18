package com.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.UserMessage;

@Repository
public interface UserMessageMapper {
	
	public List<UserMessage> findMsgByReceiverId(int receiverId);
	
	
	
	public int updateReadStatus(int receiverId);

}

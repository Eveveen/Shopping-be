package com.dao.mapper;

import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserMapper {
	
	public User findUserByNameAndPassword(User user);
	
	public int findUserByTelphone(User user);
	
	public int addUser(User user);
	
	public User findUserByName(String name);
	
	public int updateActivationStatus(User user);
	
	public int updateUser(User user);
	
	public User findSenderBySenderId(int senderId);

}

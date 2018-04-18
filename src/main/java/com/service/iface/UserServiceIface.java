package com.service.iface;

import com.entity.User;

public interface UserServiceIface {
	
	public User findUserByNameAndPassword(User user);
	
	public User findUserByName(String name);
	
	public int updateActivationStatus(User user);
	
	public int addUser(User user);
	
	public int updateUser(User user);
	
	public User findSenderBySenderId(int senderId);
}

package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.mapper.UserMapper;
import com.entity.User;
import com.service.iface.UserMessageServiceIface;
import com.service.iface.UserServiceIface;

@Service
public class UserService implements UserServiceIface {

	@Autowired
	public UserMapper userMapper;
	
	@Override
	public User findUserByNameAndPassword(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUserByNameAndPassword(user);
	}
	
	@Override
	public int findUserByTelphone(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUserByTelphone(user);
	}
	
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.addUser(user);
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName(name);
	}

	@Override
	public int updateActivationStatus(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateActivationStatus(user);
	}

	

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}
	
	@Override
	public User findSenderBySenderId(int senderId) {
		// TODO Auto-generated method stub
		return userMapper.findSenderBySenderId(senderId);
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
		UserServiceIface userService = (UserServiceIface) ac.getBean("userService");
		
		System.out.println(userService.findSenderBySenderId(7566).getUserName());
	}

}

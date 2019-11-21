package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.Users;
@Service("userService")

public class UserService implements UserServiceInt {
	
	 @Autowired
	  public UserDao userDao;

	public List<Users> getUsers() {
		 List<Users>  list = userDao.getUsers();
		  return list;
		  
	}

	public Users getUser(String userid) {
		
		return userDao.getUser(userid);
	}
	
	
	
	
	
	


}
package com.service;

import java.util.List;

import com.model.Users;

public interface UserServiceInt {
	
	public List<Users> getUsers();
	public Users getUser(String id);

}
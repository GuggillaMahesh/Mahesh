package com.mahi.free.service;

import java.util.List;

import com.mahi.free.model.User;

public interface UserService {

	void addUser(User user);
	List<User> viewUser();
	User getUserByName(String name);
}

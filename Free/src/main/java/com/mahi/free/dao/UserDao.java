package com.mahi.free.dao;

import java.util.List;

import com.mahi.free.model.User;

public interface UserDao {
	void addUser(User user);
	List<User> viewUser();
	User getUserByName(String name);

}

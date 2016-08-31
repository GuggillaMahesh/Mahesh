package com.mahi.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.free.dao.UserDao;
import com.mahi.free.model.User;
@Service
public class UserServiceImpl implements UserService{
	 @Autowired
	UserDao userDao;
	 
	 public void addUser(User user){
		 System.out.println("i am in servive now");
		 userDao.addUser(user);
	 }

	@Override
	public List<User> viewUser() {

List<User> list=userDao.viewUser();
		return list;
	}

	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);

		
	}

}

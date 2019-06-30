package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
 private IUserDao dao;
	public int saveUser(User user) {
		return dao.saveUser(user);
	}
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}
	public User getUserByEmail(String email) {
		return dao.getUserByEmail(email);
	}
	public User getUserByNameAndPwd(String un, String pwd) {
		return dao.getUserByNameAndPwd(un,pwd);
	}
	
	public void deleteUser(int userId) {
		dao.deleteUser(userId);
		
	}
	public User getUserById(int userId) {
		return dao.getUserById(userId);
	}
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
}

package com.app.dao;

import java.util.List;
import com.app.model.User;

public interface IUserDao {
	public int saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userId);
    public User getUserById(int userId);
    public List<User> getAllUsers();
	public User getUserByEmail(String email);
	public User getUserByNameAndPwd(String un,String pwd);
}
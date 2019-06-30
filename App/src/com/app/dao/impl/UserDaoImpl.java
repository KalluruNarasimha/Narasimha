package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
  private HibernateTemplate ht;
	public int saveUser(User user) {
		return (Integer)ht.save(user);
	}
	public void updateUser(User user) {
		ht.update(user);
		
	}
	public User getUserByEmail(String email) {
		User user=null;
		String hql="from com.app.model.User where userEmail=?";
		@SuppressWarnings("unchecked")
		List<User> ulist=ht.find(hql,email);
		if(ulist!=null && ulist.size()>0){
			user=ulist.get(0);
		}
		return user;
	}
	public User getUserByNameAndPwd(String un, String pwd) {
		User user=null;
		String hql="from com.app.model.User "+" where (userEmail=? or userContact=?) "+ "and userPwd=?";
		@SuppressWarnings("unchecked")
		List<User> list=ht.find(hql,un,un,pwd);
		if(list!=null && list.size()>0){
			user=list.get(0);
		}
		return user;
	}
	
	public void deleteUser(int userId) {
	ht.delete(new User(userId));
		
	}
	public User getUserById(int userId) {
		User user=ht.get(User.class,userId);
		return user;
	}
	public List<User> getAllUsers() {
		List<User> ulist=ht.loadAll(User.class);
		return ulist;
	}
	
	

}

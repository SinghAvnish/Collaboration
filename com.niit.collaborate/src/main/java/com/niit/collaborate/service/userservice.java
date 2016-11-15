package com.niit.collaborate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.UserDAOImpl;
import com.niit.collaborate.model.User;
@Service
@Transactional

public class UserService
{
	@Autowired (required=true)
	UserDAOImpl userdao;


	public List<User> list() 
	{
		return userdao.list();
	}
	
	public boolean save(User user)
	{
		  userdao.save(user);
		  
		  return false;
	}
		
	public void Update(User user)
	{
		  userdao.Update(user);
	}
	
	public void delete(int userId) 
	{
		userdao.delete(userId);
		
	}
	public User get(int userId){
		return userdao.get(userId);
	}
	
	public User getUsername(int username){
		return userdao.get(username);
	}
	public User authenticate(String username, String password)
	{
		return userdao.authenticate(username, password);
	}
	
}




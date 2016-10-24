package com.niit.collaborate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.userdaoimpl;
import com.niit.collaborate.model.User;
@Transactional
@Service
public class userservice
{
	@Autowired (required=true)
	userdaoimpl userdao;


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
	
	
}



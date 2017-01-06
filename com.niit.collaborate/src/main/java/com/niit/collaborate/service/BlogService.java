package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.BlogDAOImpl;
import com.niit.collaborate.dao.UserDAOImpl;
import com.niit.collaborate.model.Blog;
@Service
@Transactional
public class BlogService {
	@Autowired (required=true)
	BlogDAOImpl BlogDAO;


	public List<Blog> getAllBlogs() 
	{
		return BlogDAO.getAllBlogs();
	}
	
	public boolean save(Blog blog)
	{
		BlogDAO.save(blog);
		  
		  return false;
	}
		
	public void update(Blog blog)
	{
		BlogDAO.update(blog);
	}
	
	public void delete(int blogId) 
	{
		BlogDAO.delete(blogId);
		
	}
	public Blog get(int blogId)
	{
		return BlogDAO.get(blogId);
	}
	

}

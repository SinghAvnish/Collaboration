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
	BlogDAOImpl blogdao;


	public List<Blog> getAllBlogs() 
	{
		return blogdao.getAllBlogs();
	}
	
	public boolean save(Blog blog)
	{
		  blogdao.save(blog);
		  
		  return false;
	}
		
	public void update(Blog blog)
	{
		  blogdao.update(blog);
	}
	
	public void delete(int blogId) 
	{
		blogdao.delete(blogId);
		
	}
	public Blog get(int blogId)
	{
		return blogdao.get(blogId);
	}
	

}

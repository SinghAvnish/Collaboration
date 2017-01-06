package com.niit.collaborate.dao;


	
	import java.util.List;

import com.niit.collaborate.model.Blog;


	public interface BlogDAO {
		

		public List<Blog> getAllBlogs();
		
		public Blog get(int blogId);
		
		public boolean save(Blog blog);
		
		public void update(Blog blog);
		
		public void delete(int blogId);
		    
		} 


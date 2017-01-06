package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.BlogLikeDAOImpl;
import com.niit.collaborate.model.BlogLike;

@Service
@Transactional
public class BlogLikeService 
{
	@Autowired(required=true)
	BlogLikeDAOImpl blogLikeDAO;
	
	public void saveOrUpdateBlogLike(BlogLike blogLike){
		blogLikeDAO.saveOrUpdateBlogLike(blogLike);
	}
	
	
	public List<BlogLike> listBloglikes()
	{
		return blogLikeDAO.listBlogLikes();
	}

}
package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.BlogLike;



public interface BlogLikeDAO 
{
	
	void saveOrUpdateBlogLike(BlogLike blogLike);
	
	List<BlogLike> listBlogLikes();
	
	

}

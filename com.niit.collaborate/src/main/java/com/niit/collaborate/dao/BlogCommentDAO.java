package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.BlogComment;



public interface BlogCommentDAO 
{

	void saveOrUpdateBlogComment(BlogComment blogComment);

	void deleteBlogComment(int blogId);

	BlogComment getBlogComment(int blogId);

	List<BlogComment> listBlogComments();
	
	List<BlogComment> listBlogByCreatedAt(int c_id);
}

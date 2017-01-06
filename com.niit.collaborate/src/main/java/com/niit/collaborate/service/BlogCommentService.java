package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.BlogCommentDAOImpl;
import com.niit.collaborate.model.BlogComment;


@Service
@Transactional
public class BlogCommentService {
	@Autowired(required=true)
	BlogCommentDAOImpl blogCommentDAO;
	
	public void saveOrUpdateBlogComment(BlogComment blogComment){
		blogCommentDAO.saveOrUpdateBlogComment(blogComment);
	}
	
	public void deleteBlogComment(int blogCommentId){
		blogCommentDAO.deleteBlogComment(blogCommentId);
	}
	
	public BlogComment getBlogComment(int blogCommentId){
		return blogCommentDAO.getBlogComment(blogCommentId);
	}
	
	public List<BlogComment> listBlogComments(){
		return blogCommentDAO.listBlogComments();
	}
	public List<BlogComment> listBlogByCreatedAt(int c_id){
		return blogCommentDAO.listBlogByCreatedAt(c_id);
	}
}
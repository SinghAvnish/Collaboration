package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.BlogDAOImpl;
import com.niit.collaborate.dao.ForumDaoImpl;
import com.niit.collaborate.model.Blog;
import com.niit.collaborate.model.Forum;

@Service
@Transactional
public class ForumService {
	
	@Autowired (required=true)
	ForumDaoImpl forumdao;
	
	
	public List<Forum> listForumByCreatedAt(char status)
	{
		 return  forumdao.listForumByCreatedAt(status);
	}
	
	
	public List<Forum> listForums()
	{
		return forumdao.listForums();
	}
	
	public boolean saveOrUpdateForum(Forum forum)
	{
		  forumdao.saveOrUpdateForum(forum);
		  
		  return false;
	}
		
	
	public void deleteForum(int forumId)
	{
		forumdao.deleteForum(forumId);
		
	}
	
	public Forum getForum(int forumId)
	{
		return forumdao.getForum(forumId);
	}
	

	

}

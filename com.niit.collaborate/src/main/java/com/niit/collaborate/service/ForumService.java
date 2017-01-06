package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.ForumDaoImpl;
import com.niit.collaborate.model.Forum;


@Service
@Transactional
public class ForumService 
{
	@Autowired(required=true)
	ForumDaoImpl forumDao;
	
	public boolean add(Forum forum) {
		return forumDao.add(forum);
	}
	
	public List<Forum> listForum() {
		return forumDao.listForum();
	}
	
	public Forum getForumById(int forumId) {
		return forumDao.getForumById(forumId);
	}
	
	public void update(Forum forum) {
		forumDao.update(forum);
	}
	
	public void delete(int forumId) {
		forumDao.delete(forumId);
	}

}
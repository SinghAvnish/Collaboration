package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.Forum;

public interface ForumDao {

	public boolean add(Forum forum);
	
	List<Forum> listForum();
	
	Forum getForumById(int forumId);
	
	void update(Forum forum);
	
    void delete(int forumId);
}
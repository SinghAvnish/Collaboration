package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.Forum;

public interface ForumDao {

	void saveOrUpdateForum(Forum forum);

	void deleteForum(int forumId);

	Forum getForum(int forumId);

	List<Forum> listForums();
	
	List<Forum> listForumByCreatedAt(char status);
}
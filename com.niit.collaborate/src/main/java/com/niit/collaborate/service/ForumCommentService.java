package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.ForumCommentDAOImpl;
import com.niit.collaborate.model.ForumComment;


@Service
@Transactional
public class ForumCommentService {
	
	@Autowired
	public ForumCommentDAOImpl forumCommentDAOImpl;
	
	public void addForumComment(ForumComment forumComment)
	{
		forumCommentDAOImpl.addForumComment(forumComment);
	}
	/*public List<ForumComment> listForumComments()
	{
		return forumCommentDAOImpl.listForumComments();
	}*/
	public List<ForumComment> listByForumId(int forumId)
	{
		return forumCommentDAOImpl.listByForumId(forumId);
	}
	public void delete(int forumCommentId)
	{
		forumCommentDAOImpl.delete(forumCommentId);
	}
	public ForumComment get(int forumCommentId)
	{
		return forumCommentDAOImpl.get(forumCommentId);
	}
	public void updateForumComment(ForumComment forumComment)
	{
		forumCommentDAOImpl.updateForumComment(forumComment);
	}

}
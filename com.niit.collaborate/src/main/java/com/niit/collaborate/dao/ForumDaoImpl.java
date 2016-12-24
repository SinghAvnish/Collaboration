package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.model.Blog;
import com.niit.collaborate.model.Forum;

@Repository("forumDao")
public class ForumDaoImpl implements ForumDao{
	@Autowired(required=true)
	SessionFactory sessionFactory;
	
	

	
	public void saveOrUpdateForum(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);

	}

	
	public void deleteForum(int forumId) {
		Forum forumToDelete = new Forum();
		forumToDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(forumToDelete);
	}

	
    public Forum getForum(int forumId) {
		Session session=sessionFactory.openSession();
		Forum forum = (Forum)session.get(Forum.class, forumId);
		if(forum!=null)
			return forum;
		else
		return null;
	}
	

	
	public List<Forum> listForums() 
	{
		@SuppressWarnings("unchecked")
	    List<Forum> listForums = (List<Forum>) sessionFactory.getCurrentSession().createCriteria(Forum.class)
	    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listForums;
	}
	
	
	
	public List<Forum> listForumByCreatedAt(char status)
	{
		String hql = "from Forum where status=:status order by createdAt desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("status", status);
		List<Forum> listOfForums = query.list();
		return listOfForums;
	}

	
	

}
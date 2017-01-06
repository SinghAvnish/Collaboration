package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.BlogLike;


@Repository
public class BlogLikeDAOImpl implements BlogLikeDAO {
	
	public BlogLikeDAOImpl() {

	}
	@Autowired(required=true)
	private SessionFactory sessionFactory;


	public BlogLikeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveOrUpdateBlogLike(BlogLike blogLike) {
		sessionFactory.getCurrentSession().saveOrUpdate(blogLike);

	}

	
	
	@SuppressWarnings("unchecked")
	public List<BlogLike> listBlogLikes() 
	{
		String hql = "from BlogLike";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogLike> listOfBlogLikes = query.list();
		
		return listOfBlogLikes;
	}

	

	
	

}
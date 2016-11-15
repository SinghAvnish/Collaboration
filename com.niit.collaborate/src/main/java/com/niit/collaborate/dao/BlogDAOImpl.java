package com.niit.collaborate.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.model.Blog;


@Repository
public class BlogDAOImpl implements BlogDAO 
{
		@Autowired(required=true)
		private SessionFactory sessionFactory;
		
		public BlogDAOImpl(){
			
		}
		
	    @Autowired(required=true)
		public BlogDAOImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

	    public List<Blog> getAllBlogs() {
		@SuppressWarnings("unchecked")
	    List<Blog> getAllBlogs = (List<Blog>) sessionFactory.getCurrentSession().createCriteria(Blog.class)
	    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return getAllBlogs ;
	    }

	    public Blog get(int id) {
		Session session=sessionFactory.openSession();
		Blog blog = (Blog)session.get(Blog.class, id);
		if(blog!=null)
			return blog;
		else
		return null;
	}
     
	   public boolean save(Blog blog) 
	   {
		sessionFactory.getCurrentSession().save(blog);
		return false;
	   }

	   public void update(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		
	  } 

	   public void delete(int id) {
		Blog blogToDelete = new Blog();
		blogToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(blogToDelete);
		
	}

	

}
package com.niit.collaborate.dao;


	import java.util.List;
	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.User;

	


	@Repository
	public class userdaoimpl implements userdao
	{
		public userdaoimpl() 
		{

		}
		@Autowired(required=true)
		private SessionFactory sessionFactory;


		public userdaoimpl(SessionFactory sessionFactory)
		{
			this.sessionFactory = sessionFactory;
		}
		
		public List<User> list() 
		{
			
			@SuppressWarnings("unchecked")
			List<User> listuser = (List<User>) 
			          sessionFactory.getCurrentSession()
					.createCriteria(User.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return listuser;
		}
		
		public boolean save(User user)
		{
		      sessionFactory.getCurrentSession().save(user);
		      
		      return false;
		}
		
		public void Update(User user)
		{
		    sessionFactory.getCurrentSession().update(user);
		    
		}

		public void delete(int userId)
		{
			User UserToDelete = new User();
			UserToDelete.setUserId(userId);
			sessionFactory.getCurrentSession().delete(UserToDelete);
		}


		
		public User get(int userId)
		{
			
			String hql = "from User where userId=" + "'"+ userId +"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<User> listuser = (List<User>) query.list();
			
			if (listuser != null && !listuser.isEmpty()) {
				return listuser.get(0);
			}
			
			return null;
		}
		
	
	}



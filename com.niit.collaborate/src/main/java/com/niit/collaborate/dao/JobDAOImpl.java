package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.Job;
import com.niit.collaborate.model.JobApplication;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JobDAOImpl implements JobDAO{
	@Autowired
	private SessionFactory sessionFactory;


	public JobDAOImpl() {
		
	}

	public JobDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	public boolean postJob(Job job) {
		try {
			
			sessionFactory.getCurrentSession().save(job);
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
		} catch (HibernateException e) {

			e.printStackTrace();
			return false;
		}
		return true;

	}

	public List<Job> getAllVacantJobs() {
		String hql="from Job where status='V' ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<Job> getAllJobs() {
		String hql="from Job";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public boolean applyForJob(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().save(jobApplication);
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean updateJobApplication(JobApplication jobApplication) {
		try {
			sessionFactory.getCurrentSession().save(jobApplication);
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public JobApplication get(String id, String jobId) {
		String hql="from JobApplication where id ='"+id+"' and jobId='"+jobId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
			
		return (JobApplication)query.list();
	}

	public List<JobApplication> getMyAppliedJobs(String id) {
		 String hql="from JobApplication where id='"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list(); 
	}
	/*private Integer getMaxId(){
		Integer maxId=100;
		
		try {
			String hql="select max(id) from Job";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			maxId=(Integer)query.uniqueResult();
		} catch (HibernateException e) {
		    maxId=100;
			e.printStackTrace();
		}
		return maxId+1;
		
	}*/

}
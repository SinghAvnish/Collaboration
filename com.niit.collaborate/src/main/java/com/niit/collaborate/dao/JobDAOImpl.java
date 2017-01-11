package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.Job;





@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addJob(Job job) {
		sessionFactory.getCurrentSession().save(job);	
	}

	public List<Job> listJob() {
		@SuppressWarnings("unchecked")
		List<Job> listJob = (List<Job>)sessionFactory.getCurrentSession().createCriteria(Job.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJob;
	}

	public void delete(int jobId) {
		Job jobToDelete = new Job();
		jobToDelete.setJobId(jobId);
		sessionFactory.getCurrentSession().delete(jobToDelete);	
	}

	public Job get(int jobId) {

		String hql = "from Job where jobID=" + "'" + jobId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Job> listJob = (List<Job>) query.list();

		if (listJob != null && !listJob.isEmpty()) {
			return listJob.get(0);
		}
		return null;
	}

	public void updateJob(Job job) {
		Job j =get(job.getJobId());
		j.setTitle(job.getTitle());
		j.setDescription(job.getDescription());
		j.setQualification(job.getQualification());
		j.setStatus(job.getStatus());
		sessionFactory.getCurrentSession().update(j);
		
	}

	/*public boolean postJob(Job job) {
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
	@SuppressWarnings("unchecked")
	public List<Job> getAllVacantJobs() {
		String hql="from Job where status= 'v'";
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
			sessionFactory.getCurrentSession().update(jobApplication);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public JobApplication get(int userId, int jobId) {
		String hql="from JobApplication where userId= '"+userId+"' and jobId='"+jobId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication)query.list();
	}
	public JobApplication getMyAppliedJobs(int userId) {
		String hql="from Job where userId in (select userId from JobApplication where userId= '"+userId+"')";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication)query.list();
		
	}
	@SuppressWarnings("unchecked")
	public List<Job> getAllJobs() {
		String hql="from Job";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();	
	}
	@SuppressWarnings("unchecked")
	public List<JobApplication> listJobApplication() {
		String hql="from JobApplication";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	public Job getJobDetails(int jobId) {
		return (Job) sessionFactory.getCurrentSession().get(Job.class, jobId);
	}
	public JobApplication getJobApplication(int userId) {
		String hql="from JobApplication where userId= '"+userId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (JobApplication)query.list();
	}*/
}
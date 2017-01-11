package com.niit.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaborate.model.JobApplication;

@Repository("jobApplicationDAO")
public class JobApplicationDAOImpl implements JobApplicationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public JobApplicationDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addJobApplication(JobApplication jobApplication) {
		sessionFactory.getCurrentSession().save(jobApplication);
		
	}

	/*public List<JobApplication> listJobApplication() {
		@SuppressWarnings("unchecked")
		List<JobApplication> listJobApplication = (List<JobApplication>)sessionFactory.getCurrentSession().createCriteria(JobApplication.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJobApplication;
	}*/

	public void delete(int jobApplicationId) {
		JobApplication jobApplicationToDelete = new JobApplication();
		jobApplicationToDelete.setJobApplicationId(jobApplicationId);
		sessionFactory.getCurrentSession().delete(jobApplicationToDelete);		
	}

	public JobApplication get(int jobApplicationId) {
		String hql = "from JobApplication where jobApplicationID=" + "'" + jobApplicationId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<JobApplication> listJobApplication = (List<JobApplication>) query.list();

		if (listJobApplication != null && !listJobApplication.isEmpty()) {
			return listJobApplication.get(0);
		}
		return null;
	}

	public void updateJobApplication(JobApplication jobApplication) {
		JobApplication j =get(jobApplication.getJobApplicationId());
		j.setStatus(jobApplication.getStatus());
		sessionFactory.getCurrentSession().update(j);
	}

	public List<JobApplication> listByUserId(int userId) {
		String hql="from JobApplication where userId= " + "'" + userId + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<JobApplication> list = (List<JobApplication>)query.list();
		return list;
	}
	
	

}
package com.niit.collaborate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.niit.collaborate.dao.JobDAOImpl;
import com.niit.collaborate.model.Job;
import com.niit.collaborate.model.JobApplication;


@Service
@Transactional
public class JobService    
{
	@Autowired(required=true)
  JobDAOImpl JobDAO;
	
	
	public boolean postJob(Job job) {
		return JobDAO.postJob(job);
	}
	
	public boolean updateJob(Job job) {
		return JobDAO.update(job);
	}
	
	public List<Job> getAllVacantJobs() {
		return JobDAO.getAllVacantJobs();
	}
	
	public List<Job> getAllJobs() {
		return JobDAO.getAllJobs();
	}
	
	public boolean applyForJob(JobApplication jobApplication) {
		return JobDAO.applyForJob(jobApplication);
	}
	
	public boolean updateJobApplication(JobApplication jobApplication) {
		
		return JobDAO.updateJobApplication(jobApplication);
	}
	
	public JobApplication get(int id, int c_id) {
		return JobDAO.get(id, c_id);
	}
	
	public JobApplication getMyAppliedJobs(int id) {
		return JobDAO.getMyAppliedJobs(id);
	}
}
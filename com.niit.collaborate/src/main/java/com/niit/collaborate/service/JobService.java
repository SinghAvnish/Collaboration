package com.niit.collaborate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.JobDAOImpl;
import com.niit.collaborate.model.Job;
import com.niit.collaborate.model.JobApplication;



@Transactional
@Service
public class JobService {
	@Autowired (required=true)
	JobDAOImpl jobDAO;
	
	
	public boolean postJob(Job job) {
		return jobDAO.postJob(job);
	}
	
	public boolean updateJob(Job job) {
		return jobDAO.updateJob(job);
	}
	
	public List<Job> getAllVacantJobs() {
		return jobDAO.getAllVacantJobs();
	}
	
	public List<Job> getAllJobs() {
		return jobDAO.getAllJobs();
	}
	
	public boolean applyForJob(JobApplication jobApplication) {
		return jobDAO.applyForJob(jobApplication);
	}
	
	public boolean updateJobApplication(JobApplication jobApplication) {
		
		return jobDAO.updateJobApplication(jobApplication);
	}
	
	public JobApplication get(String id, String jobId) {
		return jobDAO.get(id, jobId);
	}
	
	public List<JobApplication> getMyAppliedJobs(String id) {
		return jobDAO.getMyAppliedJobs(id);
	}

}
package com.niit.collaborate.dao;

import java.util.List;

import com.niit.collaborate.model.Job;
import com.niit.collaborate.model.JobApplication;

public interface JobDAO {
	
    public boolean postJob(Job job);
	
	public boolean updateJob(Job job);
	
	public List<Job> getAllVacantJobs();
	
	public List<Job> getAllJobs();
	
	
	public boolean applyForJob(JobApplication jobApplication);
	
	public boolean updateJobApplication(JobApplication jobApplication);
	
	public JobApplication get(String id, String jobId);
	
	public List<JobApplication> getMyAppliedJobs(String id);
	
}
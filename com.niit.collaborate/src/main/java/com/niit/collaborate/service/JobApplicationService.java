package com.niit.collaborate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.JobApplicationDAOImpl;
import com.niit.collaborate.model.JobApplication;



@Service
@Transactional
public class JobApplicationService {
	
	@Autowired
	public JobApplicationDAOImpl jobApplicationDAOImpl;
	
	public void addJobApplication(JobApplication jobApplication)
	{
		jobApplicationDAOImpl.addJobApplication(jobApplication);
	}
	/*public List<JobApplication> listJobApplication()
	{
		return jobApplicationDAOImpl.listJobApplication();
	}*/
	public void delete(int jobApplicationId)
	{
		jobApplicationDAOImpl.delete(jobApplicationId);
	}
	public JobApplication get(int jobApplicationId)
	{
		return jobApplicationDAOImpl.get(jobApplicationId);
	}
	public void updateJobApplication(JobApplication jobApplication)
	{
		jobApplicationDAOImpl.updateJobApplication(jobApplication);
	}
	public List<JobApplication> listByUserId(int userId)
	{
		return jobApplicationDAOImpl.listByUserId(userId);
	}
}
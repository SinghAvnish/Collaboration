package com.niit.collaborate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.JobDAOImpl;
import com.niit.collaborate.model.Job;


@Service
@Transactional
public class JobService {
	
	@Autowired
	public JobDAOImpl jobDAOImpl;
	
	
	public void addJob(Job job)
	{
		jobDAOImpl.addJob(job);
	}
	public List<Job> listJob()
	{
		return jobDAOImpl.listJob();
	}
	public void delete(int jobId)
	{
		jobDAOImpl.delete(jobId);
	}
	public Job get(int jobId)
	{
		return jobDAOImpl.get(jobId);
	}
	public void updateJob(Job job)
	{
		jobDAOImpl.updateJob(job);
	}
}
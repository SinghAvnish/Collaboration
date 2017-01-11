package com.niit.collaborate.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborate.model.Job;
import com.niit.collaborate.service.JobService;



@RestController
public class JobController 
{
	@Autowired(required = true)
	private JobService jobService;

	@RequestMapping(value="/job", method=RequestMethod.GET)
	public ResponseEntity<List<Job>> listJobs(){
		
		List<Job> job = jobService.listJob();
		if(job.isEmpty()){		
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);		
		}	
		return new ResponseEntity<List<Job>>(job,HttpStatus.OK);	
	}
	
	@RequestMapping(value="/job", method=RequestMethod.POST)
	public ResponseEntity<Job> createJob(@RequestBody Job job, HttpSession session){
		
		if(jobService.get(job.getJobId())== null)
		{
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			job.setUserId(loggedInUserID);
			job.setStatus('V');
			jobService.addJob(job);
			return new ResponseEntity<Job>(job,HttpStatus.OK);
		}
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/job/{jobId}", method=RequestMethod.DELETE)
	public ResponseEntity<Job> deleteJob(@PathVariable("jobId") int jobId)
	{
		Job job=jobService.get(jobId);
		if(job==null)
		{
			job=new Job();
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);
		}
		jobService.delete(jobId);
		return new ResponseEntity<Job>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/job/{jobId}", method=RequestMethod.GET)
	public ResponseEntity<Job> getJob(@PathVariable("jobId") int jobId, HttpSession session)
	{
		Job job=jobService.get(jobId);
		session.setAttribute("jId", job.getJobId());
		/*if(job==null)
		{
			job=new Job();
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/job/{jobId}", method=RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(@RequestBody Job job){
		
		if(jobService.get(job.getJobId())== null)
		{
			job=new Job();
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);	
		}
		jobService.updateJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
}
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
import com.niit.collaborate.model.JobApplication;
import com.niit.collaborate.service.JobApplicationService;
import com.niit.collaborate.service.JobService;



@RestController
public class JobApplicationController {
		

	@Autowired(required = true)
	private JobApplicationService jobApplicationService;

	@RequestMapping(value="/jobapplication", method=RequestMethod.GET)
	public ResponseEntity<List<JobApplication>> getJobApplicationByUserId(HttpSession session)
	{
		int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
		List<JobApplication> jobApplication = jobApplicationService.listByUserId(loggedInUserID);
		return new ResponseEntity<List<JobApplication>>(jobApplication, HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/jobapplication", method=RequestMethod.GET)
	public ResponseEntity<List<JobApplication>> listJobApplications(){
		
		List<JobApplication> jobApplication = jobApplicationService.listJobApplication();
		if(jobApplication.isEmpty()){		
			return new ResponseEntity<List<JobApplication>>(HttpStatus.NO_CONTENT);		
		}	
		return new ResponseEntity<List<JobApplication>>(jobApplication,HttpStatus.OK);	
	}*/
	
	@RequestMapping(value="/jobapplication", method=RequestMethod.POST)
	public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication, HttpSession session){
		
		if(jobApplicationService.get(jobApplication.getJobApplicationId())== null)
		{
			int loggedInUserID = (Integer)session.getAttribute("loggedInUserId");
			jobApplication.setUserId(loggedInUserID);
			int jobId = (Integer)session.getAttribute("jId");
			jobApplication.setJobId(jobId);
			jobApplication.setStatus('N');
			jobApplicationService.addJobApplication(jobApplication);
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
		}
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobapplication/{jobApplicationId}", method=RequestMethod.DELETE)
	public ResponseEntity<JobApplication> deleteJobApplication(@PathVariable("jobApplicationId") int jobApplicationId)
	{
		JobApplication jobApplication=jobApplicationService.get(jobApplicationId);
		if(jobApplication==null)
		{
			jobApplication=new JobApplication();
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.NOT_FOUND);
		}
		jobApplicationService.delete(jobApplicationId);
		return new ResponseEntity<JobApplication>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobapplication/{jobApplicationId}", method=RequestMethod.GET)
	public ResponseEntity<JobApplication> getJobApplication(@PathVariable("jobApplicationId") int jobApplicationId, HttpSession session)
	{
		JobApplication jobApplication=jobApplicationService.get(jobApplicationId);
		if(jobApplication==null)
		{
			jobApplication=new JobApplication();
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobapplication/{jobApplicationId}", method=RequestMethod.PUT)
	public ResponseEntity<JobApplication> updateJobApplication(@RequestBody JobApplication jobApplication){
		
		if(jobApplicationService.get(jobApplication.getJobApplicationId())== null)
		{
			jobApplication=new JobApplication();
			return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.NOT_FOUND);	
		}
		jobApplicationService.updateJobApplication(jobApplication);
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}
}
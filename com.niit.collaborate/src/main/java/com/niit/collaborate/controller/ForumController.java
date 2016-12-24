package com.niit.collaborate.controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaborate.model.Forum;
import com.niit.collaborate.service.ForumService;

@RestController
public class ForumController {
	
	@Autowired(required=true) 
	ForumService forumservice;
	
	
	@RequestMapping(value= "/forum", method = RequestMethod.GET)
	public ResponseEntity<List<Forum>> listForum(){
		List<Forum> listOfForums = forumservice.listForumByCreatedAt('A');
		//List<Forum> listOfForums = forumDAO.listForums();
		if(listOfForums==null && listOfForums.isEmpty()){
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(listOfForums,HttpStatus.OK);
	}
	
	@RequestMapping(value= "/forum", method = RequestMethod.POST)
	public ResponseEntity<Forum> createForum(@RequestBody Forum forum,UriComponentsBuilder ucBuilder){

		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		forum.setCreatedAt(timestamp);
		forum.setModifiedAt(timestamp);
		forum.setStatus('P');
		//forum.setUserId("USR001");
		forumservice.saveOrUpdateForum(forum);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ucBuilder.path("/forums/{id}").buildAndExpand(forum.getForumId()).toUri());
		return new ResponseEntity<Forum>(httpHeaders,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/forum{forumid}", method = RequestMethod.PUT )
	public ResponseEntity<Forum> updateForum(@RequestBody Forum forum,@PathVariable("forumId")int forumId){
		forum=forumservice.getForum(forumId);
		if(forum == null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		forum.setForumTitle(forum.getForumTitle());
		forum.setForumDescription(forum.getForumDescription());
		Date date = new Date();
		long time = date.getTime();
		Timestamp timestamp = new Timestamp(time);
		forum.setModifiedAt(timestamp);
		forumservice.saveOrUpdateForum(forum);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/forums/{forumId}")
	public ResponseEntity<Forum> deleteforum(@PathVariable("forumId")int forumId){
		if(forumservice.getForum(forumId)==null)
		{
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		
		forumservice.deleteForum(forumId);
		return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value="/forum{forumId}", method = RequestMethod.GET )
	public ResponseEntity<Forum> getForum(@PathVariable("forumId")int forumId, Forum forum){
		forum=forumservice.getForum(forumId);
		if(forum==null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	
}
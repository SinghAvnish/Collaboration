package com.niit.collaborate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaborate.model.User;

@RestController
public class usercontroller
{
		@Autowired(required=true)
		private com.niit.collaborate.service.userservice userservice;
		
		@RequestMapping("/homes")
		public String homes() 
		{
	 		return "home";
	 	}
		
		@RequestMapping(value="/user{userId}", method = RequestMethod.GET )
		public ResponseEntity<User> get(@PathVariable("userId") Integer userId) 
		{
			User user = userservice.get(userId);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		@RequestMapping(value= "/user", method = RequestMethod.GET)
		public ResponseEntity<List<User>> list() 
		{
			List<User> list = userservice.list();
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
		
		@RequestMapping(value= "/user", method = RequestMethod.POST)
		public ResponseEntity<Void> save(@RequestBody User user, UriComponentsBuilder builder)
		{
	        boolean flag = userservice.save(user);
	               if (flag == false) {
	        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	               }
	               HttpHeaders headers = new HttpHeaders();
	               headers.setLocation(builder.path("/user{userId}").buildAndExpand(user.getUserId()).toUri());
	               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		@RequestMapping(value="/user{userId}", method = RequestMethod.PUT )
		public ResponseEntity<User> updateUser(@RequestBody User user) 
		{
			userservice.Update(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		
		@RequestMapping(value="/user{userId}", method = RequestMethod.DELETE )
		public ResponseEntity<Void> delete(@PathVariable("userId") Integer userId) {
			userservice.delete(userId);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}	
	}   
	


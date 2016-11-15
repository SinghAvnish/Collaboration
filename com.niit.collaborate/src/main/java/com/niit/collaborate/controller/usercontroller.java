package com.niit.collaborate.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaborate.model.User;
import com.niit.collaborate.service.UserService;



 

@RestController
public class UserController
{
	
	@Autowired(required=true)
	private UserService userservice;
		
		@RequestMapping(value="/user{id}", method = RequestMethod.GET )
		public ResponseEntity<User> get(@PathVariable("id") Integer id) 
		{
			User user = userservice.get(id);
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
	               headers.setLocation(builder.path("/user{id}").buildAndExpand(user.getId()).toUri());
	               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		@RequestMapping(value="/user{id}", method = RequestMethod.PUT )
		public ResponseEntity<User> Update(@RequestBody User user) 
		{
			userservice.Update(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		
		@RequestMapping(value="/user{id}", method = RequestMethod.DELETE )
		public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
			userservice.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}	
		
		@RequestMapping(value="/user/authenticate", method=RequestMethod.POST)
		public ResponseEntity<User> authenticate(@RequestBody User user, HttpSession session) {
	     user=userservice.authenticate(user.getUsername(),user.getPassword());
	     if(user==null){
	    	 user=new User();
	    	
	     }else
	     {
	    	
	    	 session.setAttribute("loggedInUser", user);
	    	 session.setAttribute("loggedInUsername", user.getUsername());
	    	 
	    	 
	     }
			return new ResponseEntity<User>(user, HttpStatus.OK);
			
		}
	}   
	


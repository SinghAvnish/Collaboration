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
import com.niit.collaborate.service.FriendService;
import com.niit.collaborate.service.UserService;




		



 

@RestController
public class UserController
{
	
	@Autowired(required=true)
	private UserService userservice;
	
	@Autowired(required=true)
	private FriendService friendservice;
		
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
		  public ResponseEntity<User> authenticate(@RequestBody User user, HttpSession session){
			  user = userservice.authenticate(user.getUsername(), user.getPassword());
			  if(user==null){
				  user = new User(); // Do we need to create new user?
				  user.setErrorCode("404");
				  user.setErrorMessage("Invalid Credentials. please enter valid credentials");
				  }
			  else
			  {
				  user.setErrorCode("200");
				  session.setAttribute("loggedInUser", user);
				  session.setAttribute("loggedInUserId", user.getId());
				  int loggedInUserId =(Integer)session.getAttribute("loggedInUserId");
				  System.out.println("stored in session"+loggedInUserId);
				  System.out.println("user name is="+user.getUsername());
				  System.out.println("password is="+user.getPassword());
				  System.out.println("user id"+user.getId());
				  friendservice.setOnline(user.getId());
				 /*userService.setOnline(user.getId());*/
				  
			  }
			  return new ResponseEntity<User> (user, HttpStatus.OK );
		  }
		    
		  @RequestMapping(value="/user/logout", method=RequestMethod.GET)
		  public  String logout(HttpSession session){
			  int loggedInUserId =(Integer)session.getAttribute("loggedInUserId");
			  session.invalidate();
			  return("You successfully loggedout");
		  }
	}   
	


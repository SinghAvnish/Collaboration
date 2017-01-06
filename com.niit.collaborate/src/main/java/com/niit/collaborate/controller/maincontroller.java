package com.niit.collaborate.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class maincontroller {

	@RequestMapping("/")
	public String gethome() 
	{
 		return "index";
 	}
	

	/*@RequestMapping("/userPage")
	public String getUser()
	{
		return "user";
	}
	
	@RequestMapping("/blogPage")
	public String getBlog()
	{
		return "blog";
	}
	
	@RequestMapping("/eventPage")
	public String getEvent()
	{
		return "event";
	}
	
	@RequestMapping("/login")
	public String getlogin()
	{
		return "login";
	}
	
*/	
}

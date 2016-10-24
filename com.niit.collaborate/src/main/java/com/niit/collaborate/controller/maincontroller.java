package com.niit.collaborate.controller;

 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class maincontroller
{
	@RequestMapping("/")
	public String getHome()
	{
		return "index";
	}

}


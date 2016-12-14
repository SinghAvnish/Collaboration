package com.niit.collaborate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.collaborate.service.BlogService;
@Controller
public class MainController {

	
	@Autowired(required=true)
	private BlogService blogservice;
	
	@RequestMapping("/")
	public String gethome() 
	{
 		return "index";
 	}
	
	@RequestMapping("/blogview{id}")
	public String view(@PathVariable("id") int id, Model model) {
		System.out.println("view");
		model.addAttribute("blog", this.blogservice.get(id));
		model.addAttribute("blogdetails", this.blogservice.get(id));
		return "viewblog";
	}

	}

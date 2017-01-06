package com.niit.collaborate.controller;

import java.util.List;

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

import com.niit.collaborate.model.Blog;
import com.niit.collaborate.service.BlogService;
@RestController
public class BlogController
{
	@Autowired(required=true)
	private BlogService blogservice;
	
	@RequestMapping(value="/blog/{c_id}", method = RequestMethod.GET )
	public ResponseEntity<Blog> get(@PathVariable("c_id") Integer c_id) 
	{
		Blog blog = blogservice.get(c_id);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/blog", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> list() 
	{
		List<Blog> list = blogservice.getAllBlogs();
		return new ResponseEntity<List<Blog>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/blog", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Blog blog, UriComponentsBuilder builder)
	{
        boolean flag = blogservice.save(blog);
               if (flag == false) {
        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
               }
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/blog{c_id}").buildAndExpand(blog.getId()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/blog/{c_id}", method = RequestMethod.PUT )
	public ResponseEntity<Blog> Update(@RequestBody Blog blog) 
	{
		blogservice.update(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/blog/{c_id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("c_id") Integer c_id) {
		blogservice.delete(c_id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	


}

package com.niit.collaborate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaborate.model.Blog;
import com.niit.collaborate.model.BlogComment;
import com.niit.collaborate.service.BlogCommentService;

@RestController
public class BlogCommentController 
{
	@Autowired(required=true)
	BlogCommentService blogCommentService;
	
	@RequestMapping(value= "/blogcomment", method = RequestMethod.POST)
	
	public ResponseEntity<Void> saveOrUpdateBlogComment(@RequestBody BlogComment blogComment, UriComponentsBuilder ucBuilder) {
		blogCommentService.saveOrUpdateBlogComment(blogComment);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders	.setLocation(ucBuilder.path("/blogcomments/{blogCommentId}").buildAndExpand(blogComment.getBlogCommentId()).toUri());
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);

	}
	
	
	@RequestMapping(value= "/blogcomment", method = RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> list() 
	{
		List<BlogComment> list = blogCommentService.listBlogComments();
		return new ResponseEntity<List<BlogComment>>(list, HttpStatus.OK);
	}
}


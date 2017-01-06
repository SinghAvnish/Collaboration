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

import com.niit.collaborate.model.BlogLike;
import com.niit.collaborate.service.BlogLikeService;

@RestController
public class BlogLikeController {

	@Autowired(required=true)
	BlogLikeService blogLikeService;
	
	@RequestMapping(value= "/bloglike", method = RequestMethod.POST)
	
	public ResponseEntity<Void> saveOrUpdateBlogLike(@RequestBody BlogLike blogLike, UriComponentsBuilder ucBuilder) {
		blogLikeService.saveOrUpdateBlogLike(blogLike);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders	.setLocation(ucBuilder.path("/blogLikes/{getBlogLikeId}").buildAndExpand(blogLike.getBlogLikeId()).toUri());
		return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);

	}
	
	
	@RequestMapping(value= "/bloglike", method = RequestMethod.GET)
	public ResponseEntity<List<BlogLike>> list() 
	{
		List<BlogLike> list = blogLikeService.listBloglikes();
		return new ResponseEntity<List<BlogLike>>(list, HttpStatus.OK);
	}
}

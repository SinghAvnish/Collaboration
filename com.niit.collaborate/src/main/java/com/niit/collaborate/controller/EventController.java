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
import com.niit.collaborate.model.Event;
import com.niit.collaborate.service.EventService;
@RestController
public class EventController
{

	@Autowired(required=true)
	private EventService eventservice;
	
	@RequestMapping(value="/event{id}", method = RequestMethod.GET )
	public ResponseEntity<Event> get(@PathVariable("id") Integer id) 
	{
		Event event = eventservice.getEventById(id);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/event", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> list() 
	{
		List<Event> list = eventservice.getAllEvents();
		return new ResponseEntity<List<Event>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/event", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Event event, UriComponentsBuilder builder)
	{
        boolean flag = eventservice.save(event);
               if (flag == false) {
        	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
               }
               HttpHeaders headers = new HttpHeaders();
               headers.setLocation(builder.path("/event{id}").buildAndExpand(event.getId()).toUri());
               return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/event{id}", method = RequestMethod.PUT )
	public ResponseEntity<Event> Update(@RequestBody Event event) 
	{
		eventservice.update(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/event{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		eventservice.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	


}

package com.niit.collaborate.dao;

	import java.util.List;

	import com.niit.collaborate.model.*;



	public interface EventDAO 
	{
		List<Event> getAllEvent();
		Event getEventById(int id);
	    boolean addEvent(Event event);
	    void updateEvent(Event event);
	    void deleteEvent(int id);
		
	} 

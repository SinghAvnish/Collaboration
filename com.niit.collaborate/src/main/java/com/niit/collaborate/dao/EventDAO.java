package com.niit.collaborate.dao;

	import java.util.List;

	import com.niit.collaborate.model.*;



	public interface EventDAO 
	{
		public List<Event> getAllEvents();
		public Event getEvent(int id);
		public boolean save(Event event);
		public void update(Event event);
		public void delete(int id);
		 
		
	} 

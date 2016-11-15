package com.niit.collaborate.service;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.EventDAOImpl;
import com.niit.collaborate.model.Event;

	@Service
	@Transactional
	public class EventService 
	{


			@Autowired(required=true)
			EventDAOImpl eventdao ;
			public List<Event> getAllEvents()
			{
					return eventdao.getAllEvents();
				}
			public boolean save(Event event){
				eventdao.save(event);
				 return false;
					
			    }
			
			public void update(Event event){
				eventdao.update(event);
			}
					
			public void delete(int eventId) {
				eventdao.delete(eventId);
					
			}
			public Event getEventById(int eventId) {
				return eventdao.getEvent(eventId);
				    
			}
	      
}

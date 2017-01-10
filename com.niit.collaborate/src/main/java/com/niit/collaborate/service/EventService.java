package com.niit.collaborate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborate.dao.EventDAOImpl;
import com.niit.collaborate.model.Event;


@Service
@Transactional

public class EventService {
	@Autowired (required=true)
	EventDAOImpl eventDAO;
	
	
	public List<Event> getAllEvent() {
		return eventDAO.getAllEvent();
	}

	public Event getEventById(int id) {
		return eventDAO.getEventById(id);
	}
	
	public boolean addEvent(Event event) {
		return eventDAO.addEvent(event);
	}
	
	public void updateEvent(Event event) {
		 eventDAO.updateEvent(event);
	}
	
	
	public void deleteEvent(int id) {
		eventDAO.deleteEvent(id);
	}
}
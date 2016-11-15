package com.niit.collaborate.dao;

import com.niit.collaborate.model.Event;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class EventDAOImpl implements EventDAO
{
	
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	
    @Autowired(required=true)
	public EventDAOImpl(SessionFactory sessionFactory)
    {
		this.sessionFactory = sessionFactory;
	}



public List<Event> getAllEvents() {
	@SuppressWarnings("unchecked")
    List<Event> getAllEvents = (List<Event>) sessionFactory.getCurrentSession().createCriteria(Event.class)
    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

    return getAllEvents ;
}

public Event getEvent(int id) {
	Session session=sessionFactory.openSession();
	Event event = (Event)session.get(Event.class, id);
	if(event!=null)
		return event;
	else
	return null;
}

public boolean save(Event event) 
{
	sessionFactory.getCurrentSession().save(event);
	return false;
}

public void update(Event event)
{
	sessionFactory.getCurrentSession().update(event);
	
}

public void delete(int id) 
{
	Event eventToDelete = new Event();
	eventToDelete.setId(id);
	sessionFactory.getCurrentSession().delete(eventToDelete);
	
	
}


}

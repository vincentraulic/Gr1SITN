package com.pmo.dao;

import java.util.List;

import javax.ejb.Local;

import com.pmo.event.type.EventType;
import com.pmo.model.Event;


@Local
public interface EventDao {

	public int createEvent(Event event);
	
	public Event getEvent(int id);
	
	public List<Event> getEvents(int id_employee);
	
	public List<Event> getEvents(int id_employee, EventType type);
	
	public int updateEvent(Event event);
	
}

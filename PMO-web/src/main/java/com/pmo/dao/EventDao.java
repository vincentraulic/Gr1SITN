package com.pmo.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Event;


@Local
public interface EventDao {

	public int createEvent(int id_employee,
							 String type,
							 String reason,
							 Date dateStart,
							 Date dateEnd);
	
	public Event getEvent(int id);
	
	public List<Event> getEvents(int id_employee);
	
	public List<Event> getEvents(int id_employee, String type);
	
}

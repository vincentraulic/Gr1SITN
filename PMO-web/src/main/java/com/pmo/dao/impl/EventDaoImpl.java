package com.pmo.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.util.StringUtils;

import com.pmo.dao.EventDao;
import com.pmo.model.Event;
import com.pmo.model.Employee;

@Stateless
public class EventDaoImpl implements EventDao{

    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;
	
	public int createEvent(int id_employee, String type, String reason, Date dateStart,
			Date dateEnd) {
		if(StringUtils.isEmpty(reason) || dateStart == null 
				|| dateEnd == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		if(dateEnd.compareTo(dateStart) < 0)
			throw new IllegalArgumentException("dateStart must be before the dateEnd");
		
		Event event = new Event();
		event.setType(type);
		event.setReason(reason);
		event.setDateStart(dateStart);
		event.setDateEnd(dateEnd);
		
		try{
			Employee employee = em.getReference(Employee.class, id_employee);
			event.setEmployee(employee);
			em.persist(event);
			return event.getId_event();
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Employee not found in database");
		}
	}

	public Event getEvent(int id) {
		return em.find(Event.class, id);
	}

	public List<Event> getEvents(int id_employee) {
		try{
			em.getReference(Employee.class, id_employee);
		} catch(EntityNotFoundException e){
			return null;
		}
		
		List<Event> list = (List<Event>) em.createQuery("SELECT a FROM Event a "
								+ "WHERE a.id_employee = :id_e")
								.setParameter("id_e", id_employee);
		return list;
	}

	@Override
	public List<Event> getEvents(int id_employee, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}

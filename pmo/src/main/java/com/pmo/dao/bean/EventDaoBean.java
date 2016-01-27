package com.pmo.dao.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.pmo.dao.EventDao;
import com.pmo.event.type.EventType;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.utils.StringUtils;

@Stateless(name = "pmo/EventDao", mappedName = "pmo/EventDao")
public class EventDaoBean implements EventDao{

    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;
	
	public int createEvent(Event event) {
		if(StringUtils.isEmpty(event.getReason()) || event.getStart() == null 
				|| event.getEnd() == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		if(event.getEnd().compareTo(event.getStart()) < 0)
			throw new IllegalArgumentException("dateStart must be before the dateEnd");
		
		try{
			Employee employee = em.getReference(Employee.class, event.getEmployee().getId());
			event.setEmployee(employee);
			em.persist(event);
			return event.getId();
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Employee not found in database");
		}
	}

	public Event getEvent(int id) {
		return em.find(Event.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Event> getEvents(int id_employee) {
		try{
			em.getReference(Employee.class, id_employee);
		} catch(EntityNotFoundException e){
			return null;
		}
		
		List<Event> list = em.createQuery("SELECT a FROM Event a "
								+ "WHERE a.employee.id = :id_e")
								.setParameter("id_e", id_employee)
								.getResultList();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Event> getEvents(int id_employee, EventType type) {
		try{
			em.getReference(Employee.class, id_employee);
		} catch(EntityNotFoundException e){
			return null;
		}
		
		List<Event> list = em.createQuery("SELECT a FROM Event a "
								+ "WHERE a.employee.id = :id_e "
								+ "AND a.type = :typ")
								.setParameter("id_e", id_employee)
								.setParameter("typ", type)
								.getResultList();
		return list;
	}


	public int updateEvent(Event event) {
		em.merge(event);
		return event.getId();
	}


}

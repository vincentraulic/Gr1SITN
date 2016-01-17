package com.pmo.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.EmployeeDao;
import com.pmo.dao.EventDao;
import com.pmo.dao.UserDao;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.service.EmployeeService;

@Stateless
public class EmployeeServiceImpl implements EmployeeService{

	@EJB(mappedName="java:module/EmployeeDaoImpl")
	private EmployeeDao employeeDao;
	
	@EJB(mappedName="java:module/UserDaoImpl")
	private UserDao userDao;
	
	@EJB(mappedName="java:module/EventDaoImpl")
	private EventDao eventDao;
	
	@Override
	public int createEmployee(String lastname, String firstname,
			String password, Date dateStart) {
		//to do verifier les champs
		
		return employeeDao.createEmployee(lastname, firstname, password, dateStart);
	}

	@Override
	public Employee getDetails(String username) {
		//to do gérer si l'username n'existe pas
		
		return userDao.getUser(username);
	}

	@Override
	public Employee getEmployee(int id) {
		//to do gérer si l'id n'existe pas
		
		return employeeDao.getEmployee(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public int createEvent(int idEmployee, String type, String reason, Date dateStart,
			Date dateEnd, boolean allDay) {
		//to do check si dateEnd > dateStart
		
		int id = eventDao.createEvent(idEmployee,
											type,
											reason, 
											dateStart, 
											dateEnd,
											allDay);
		return id;
	}
	
	@Override
	public List<Event> getEvents(int idEmployee) {
		//to do gérer si l'id n'existe pas
		
		return eventDao.getEvents(idEmployee);
	}

	@Override
	public List<Event> getEvents(int idEmployee, String type) {
		//to do check si le type de Event existe
		return eventDao.getEvents(idEmployee, type);
	}

	@Override
	public int updateEvent(int idEvent, Date dateStart, Date dateEnd, boolean allDay) {
		//to do check dateEnd > dateStart
		return eventDao.updateEvent(idEvent, dateStart, dateEnd, allDay);
	}
	
	

}

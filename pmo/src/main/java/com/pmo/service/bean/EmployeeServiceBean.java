package com.pmo.service.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.EmployeeDao;
import com.pmo.dao.EventDao;
import com.pmo.dao.UserDao;
import com.pmo.event.type.EventType;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.service.EmployeeService;

@Stateless
public class EmployeeServiceBean implements EmployeeService{

	@EJB
	private EmployeeDao employeeDao;
	
	@EJB
	private UserDao userDao;
	
	@EJB
	private EventDao eventDao;
	
	@Override
	public int createEmployee(Employee employee) {
		//to do verifier les champs
		
		return employeeDao.createEmployee(employee);
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
	public int createEvent(Event event) {
		//to do check si dateEnd > dateStart
		
		int id = eventDao.createEvent(event);
		return id;
	}
	
	@Override
	public List<Event> getEvents(int idEmployee) {
		//to do gérer si l'id n'existe pas
		
		return eventDao.getEvents(idEmployee);
	}

	@Override
	public List<Event> getEvents(Employee employee, EventType type) {
		//to do check si le type de Event existe
		return eventDao.getEvents(employee.getId(), type);
	}

	@Override
	public int updateEvent(Event event) {
		//to do check dateEnd > dateStart
		return eventDao.updateEvent(event);
	}
	
	

}

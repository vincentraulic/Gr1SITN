package com.pmo.service.bean;

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

@Stateless(name = "pmo/EmployeeService", mappedName = "pmo/EmployeeService")
public class EmployeeServiceBean implements EmployeeService{

	@EJB
	private EmployeeDao employeeDao;
	
	@EJB
	private UserDao userDao;
	
	@EJB
	private EventDao eventDao;
	

	public int createEmployee(String lastname, String firstname,
			String password, Date dateStart) {
		//to do verifier les champs
		
		return employeeDao.createEmployee(lastname, firstname, password, dateStart);
	}

	
	public Employee getDetails(String username) {
		//to do gérer si l'username n'existe pas
		
		return userDao.getUser(username);
	}

	
	public Employee getEmployee(int id) {
		//to do gérer si l'id n'existe pas
		
		return employeeDao.getEmployee(id);
	}

	
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	
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
	
	
	public List<Event> getEvents(int idEmployee) {
		//to do gérer si l'id n'existe pas
		
		return eventDao.getEvents(idEmployee);
	}

	
	public List<Event> getEvents(int idEmployee, String type) {
		//to do check si le type de Event existe
		return eventDao.getEvents(idEmployee, type);
	}

	
	public int updateEvent(int idEvent, Date dateStart, Date dateEnd, boolean allDay) {
		//to do check dateEnd > dateStart
		return eventDao.updateEvent(idEvent, dateStart, dateEnd, allDay);
	}
	
	

}

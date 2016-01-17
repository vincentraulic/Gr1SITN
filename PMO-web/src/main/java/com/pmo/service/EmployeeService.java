package com.pmo.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Event;
import com.pmo.model.Employee;

@Local
public interface EmployeeService {

	public int createEmployee(String lastname, String firstname, String password, Date dateStart);
	
	public Employee getDetails(String username);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getEmployees();
	
	public int createEvent(int idEmployee, String type, String reason, Date dateStart, Date dateEnd, boolean allDay);
	
	public List<Event> getEvents(int idEmployee);
	
	public List<Event> getEvents(int idEmployee, String type);
	
	public int updateEvent(int idEvent, Date dateStart, Date dateEnd, boolean allDay);
	
	
}

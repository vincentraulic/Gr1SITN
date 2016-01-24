package com.pmo.service;

import java.util.List;

import javax.ejb.Local;

import com.pmo.event.type.EventType;
import com.pmo.model.Employee;
import com.pmo.model.Event;

@Local
public interface EmployeeService {

	public int createEmployee(Employee employee);
	
	public Employee getDetails(String username);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getEmployees();
	
	public int createEvent(Event event);
	
	public List<Event> getEvents(int idEmployee);
	
	public List<Event> getEvents(Employee employee, EventType type);
	
	public int updateEvent(Event event);
	
	
}

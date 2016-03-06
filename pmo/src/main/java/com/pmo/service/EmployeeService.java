package com.pmo.service;

import java.util.List;

import javax.ejb.Local;

import com.pmo.event.type.EventType;
import com.pmo.exception.EventTypeNotFoundException;
import com.pmo.exception.InvalidDateException;
import com.pmo.exception.UnknownEmployeeException;
import com.pmo.model.Employee;
import com.pmo.model.Event;

@Local
public interface EmployeeService {

	public int createEmployee(Employee employee);
	
	public Employee getDetails(String username);
	
	public Employee getEmployee(int id) throws UnknownEmployeeException;
	
	public List<Employee> getEmployees();
	
	public int createEvent(Event event) throws InvalidDateException;
	
	public List<Event> getEvents(int idEmployee) throws UnknownEmployeeException;
	
	public List<Event> getEvents(Employee employee, EventType type) throws UnknownEmployeeException, EventTypeNotFoundException;
	
	public int updateEvent(Event event) throws InvalidDateException;
	
}

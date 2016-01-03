package com.pmo.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Absence;
import com.pmo.model.Employee;

@Local
public interface EmployeeService {

	public int createEmployee(String lastname, String firstname, String password, Date dateStart);
	
	public Employee getDetails(String username);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getEmployees();
	
	public List<Absence> getAbsences(int idEmployee);
	
	
	
}

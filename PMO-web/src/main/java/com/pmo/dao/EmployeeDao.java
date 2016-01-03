package com.pmo.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;

@Local
public interface EmployeeDao {

	public int createEmployee(String lastname, String firstname, String password, Date dateStart);
	
	public int endEmployee(String id, Date dateEnd);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int id);
	
	public Employee getEmployee(String lastname, String firstname);
	
}

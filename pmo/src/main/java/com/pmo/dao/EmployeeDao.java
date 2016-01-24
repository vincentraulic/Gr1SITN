package com.pmo.dao;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;

@Local
public interface EmployeeDao {

	public int createEmployee(Employee employee);
	
	public void endEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int id);
	
	public Employee getEmployee(String lastname, String firstname);
	
}

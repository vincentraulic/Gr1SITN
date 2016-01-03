package com.pmo.service;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Absence;
import com.pmo.model.Employee;
import com.pmo.model.Project;

@Local
public interface ProjectService {

	public int createProject(String name, int cost, Date dateStart, Date dateEnd);
	
	public Project getProject(String name);
	
	public Project getProject(int id);
	
	public List<Employee> getEmployees(String projectName);
	
	public List<Absence> getAbsenceEmployees(int idProject);
}

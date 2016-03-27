package com.pmo.service;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.model.Project;

@Local
public interface ProjectService {

	public int createProject(Project project);
	
	public Project getProject(String name);
	
	public Project getProject(int id);
	
	public List<Employee> getEmployees(Project project);
	
	public List<Event> getEventEmployees(int idProject);

	public List<Project> getProjects();
	
	public void update(Project project);
}

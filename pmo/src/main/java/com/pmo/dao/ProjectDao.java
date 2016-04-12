package com.pmo.dao;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;
import com.pmo.model.Project;

@Local
public interface ProjectDao {
	
	public int createProject(Project project);
	
	public Project getProject(int id);
	
	public Project getProjectByName(String name);
	
	public void deleteProject(Project project);
	
	public void deleteProject(String name);
	
	public List<Project> getProjects();
	
	public List<Project> getProjects(Employee employee);
	
	public void update(Project project);
	
}

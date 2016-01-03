package com.pmo.dao;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Project;

@Local
public interface ProjectDao {
	
	public int createProject(String name, int cost, Date dateStart, Date dateEnd);
	
	public int createProject(Project project);
	
	public Project getProject(int id);
	
	public Project getProject(String name);
	
	public void deleteProject(int id);
	
	public void deleteProject(String name);
	
	public void deleteProject(Project project);
	
	public List<Project> getProjects();
	

}

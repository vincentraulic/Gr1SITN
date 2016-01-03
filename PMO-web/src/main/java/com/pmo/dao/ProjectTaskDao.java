package com.pmo.dao;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.ProjectTask;

@Local
public interface ProjectTaskDao {

	public int createProjectTask(int id_project,
								  String name,
								  int cost);
	
	public void deleteProjectTask(int id);
	
	public List<ProjectTask> getProjectTasks(int id_project);
}

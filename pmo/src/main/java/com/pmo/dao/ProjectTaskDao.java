package com.pmo.dao;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.ProjectTask;

@Local
public interface ProjectTaskDao {

	public int createProjectTask(ProjectTask projectTask);
	
	public void deleteProjectTask(ProjectTask projectTask);
	
	public List<ProjectTask> getProjectTasks(int id_project);
}

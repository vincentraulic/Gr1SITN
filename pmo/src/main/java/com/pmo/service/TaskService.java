package com.pmo.service;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;
import com.pmo.model.Project;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;

@Local
public interface TaskService {

	public int createTask(Task task);
	
	public int createProjectTask(ProjectTask projectTask);
	
	public void delete(ProjectTask projectTask);
	
	public void update(ProjectTask projectTask);
	
	public List<Task> getTasks(Employee employee);
	
	public void updateTask(Task task);
	
	public void delete(Task task);
	
	public List<Task> getTasks(Project project);
	
	public int calculateProgression(Task task);
	
	public ProjectTask getProjectTaskById(int id);
}

package com.pmo.service;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;
import com.pmo.model.Project;
import com.pmo.model.Task;

@Local
public interface TaskService {

	public int createTask(Task task);
	
	public List<Task> getTasks(Employee employee);
	
	public void updateTask(Task task);
	
	public List<Task> getTasks(Project project);
	
	public int calculateProgression(Task task);
}

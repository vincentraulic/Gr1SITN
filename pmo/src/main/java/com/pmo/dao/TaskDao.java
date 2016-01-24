package com.pmo.dao;

import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;

@Local
public interface TaskDao {

	public int createTask(Task task);
	
	public void deleteTask(Task task);
	
	public Task getTask(int id);
	
	public List<Task> getTasks(ProjectTask projectTask);
	
	public List<Task> getTasks(Employee employee);
}

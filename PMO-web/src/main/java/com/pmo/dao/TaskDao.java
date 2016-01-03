package com.pmo.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;

@Local
public interface TaskDao {

	public int createTask(int id_projectTask,
						   int id_employee,
						   int cost,
						   Date dateStart,
						   Date dateEnd,
						   int weekNumber,
						   int year);
	
	public void deleteTask(int id);
	
	public Task getTask(int id);
	
	public List<Task> getTasks(ProjectTask projectTask);
	
	public List<Task> getTasks(Employee employee);
}

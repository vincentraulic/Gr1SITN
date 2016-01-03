package com.pmo.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.pmo.model.Employee;
import com.pmo.model.Project;
import com.pmo.model.Task;

@Local
public interface TaskService {

	public int createTask(int id_projectTask,
			   int id_employee,
			   int cost,
			   Date dateStart,
			   Date estimateDateEnd);
	
	public List<Task> getTasks(Employee employee);
	
	public void updateTask(Task task);
	
	public List<Task> getTasks(Project project);
	
	
}

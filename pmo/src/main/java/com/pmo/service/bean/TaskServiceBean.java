package com.pmo.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.ProjectDao;
import com.pmo.dao.TaskDao;
import com.pmo.model.Employee;
import com.pmo.model.Project;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;
import com.pmo.service.TaskService;

@Stateless
public class TaskServiceBean implements TaskService{

	@EJB
	private TaskDao taskDao;
	
	@EJB
	private ProjectDao projectDao;
	
	
	public int createTask(Task task) {
		return taskDao.createTask(task);
	}

	
	public List<Task> getTasks(Employee employee) {
		return taskDao.getTasks(employee);
	}

	
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Task> getTasks(Project project) {
		
		List<Task> tasks = new ArrayList<Task>();
		
		for(ProjectTask pT : project.getProjectTasks()){
			tasks.addAll(pT.getTasks());
		}
		
		return tasks;
	}

}

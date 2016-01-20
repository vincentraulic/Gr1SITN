package com.pmo.service.impl;

import java.util.ArrayList;
import java.util.Date;
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

@Stateless(name = "pmo/TaskService", mappedName = "pmo/TaskService")
public class TaskServiceImpl implements TaskService{

	@EJB
	private TaskDao taskDao;
	
	@EJB
	private ProjectDao projectDao;
	
	
	public int createTask(int id_projectTask, int id_employee, int cost,
			Date dateStart, Date estimateDateEnd) {
		return taskDao.createTask(id_projectTask, id_employee, cost, dateStart, estimateDateEnd, 0, 0);
	}

	
	public List<Task> getTasks(Employee employee) {
		return taskDao.getTasks(employee);
	}

	
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	
	public List<Task> getTasks(Project project) {
		Project p = projectDao.getProject(project.getId_project());
		
		List<Task> tasks = new ArrayList<Task>();
		
		for(ProjectTask pT : p.getProjectTasks()){
			tasks.addAll(pT.getTasks());
		}
		
		return tasks;
	}

}

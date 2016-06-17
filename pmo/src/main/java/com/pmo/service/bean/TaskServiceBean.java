package com.pmo.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.ProjectDao;
import com.pmo.dao.ProjectTaskDao;
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
	private ProjectTaskDao projectTaskDao;
	
	@EJB
	private ProjectDao projectDao;
	
	@Override
	public int createTask(Task task) {
		//TODO check coût ne dépasse le total du projectTask
		//TODO check des tâches n'empiètent pas sur d'autres tâches
		//TODO check dateEnd-dateStart >= coût JH
		//TODO check coût JH >= mandayUsed
		return taskDao.createTask(task);
	}

	@Override
	public List<Task> getTasks(Employee employee) {
		return taskDao.getTasks(employee);
	}

	@Override
	public void updateTask(Task task) {
		taskDao.update(task);
	}
	
	@Override
	public void delete(Task task) {
		taskDao.deleteTask(task);
	}

	@Override
	public List<Task> getTasks(Project project) {
		//get from database
		project = projectDao.getProject(project.getId());
		List<Task> tasks = new ArrayList<>();
		
		for(ProjectTask pT : project.getProjectTasks()){
			tasks.addAll(pT.getTasks());
		}
		
		return tasks;
	}

	@Override
	public int calculateProgression(Task task) {
		//integer to float pour les divisions
		float manD = task.getMandayUsed();
		float cost = task.getCost();
		float value = (int) manD / cost * 100;
		return (int) value;
	}

	@Override
	public int createProjectTask(ProjectTask projectTask) {
		return projectTaskDao.createProjectTask(projectTask);
	}
	
	@Override
	public void delete(ProjectTask projectTask) {
		projectTaskDao.deleteProjectTask(projectTask);
	}

	@Override
	public ProjectTask getProjectTaskById(int id) {
		return projectTaskDao.getProjectTaskById(id);
	}

	@Override
	public void update(ProjectTask projectTask) {
		projectTaskDao.updateProjectTask(projectTask);
	}

	

}

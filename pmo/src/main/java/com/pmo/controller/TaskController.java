package com.pmo.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.pmo.model.Project;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;
import com.pmo.service.TaskService;

@ViewScoped
@Named
public class TaskController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9148660482678453432L;

	@EJB
	private transient TaskService taskService;
	
	private ProjectTask projectTask;

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}

	public int calculateProgression(Task task) {
		return taskService.calculateProgression(task);
	}
	
	@PostConstruct
	private void init(){	
		projectTask = new ProjectTask();
	}
	
	public void addProjectTask(Project project){
		project.getProjectTasks().add(projectTask);
		projectTask.setProject(project);
		taskService.createProjectTask(projectTask);
	}
	
}

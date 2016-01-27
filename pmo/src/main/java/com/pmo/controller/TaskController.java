package com.pmo.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.pmo.model.Task;
import com.pmo.service.TaskService;

@SessionScoped
@Named("taskController")
public class TaskController implements Serializable{
	
	@EJB
	private transient TaskService taskService;
	
	public int calculateProgression(Task task){
		return taskService.calculateProgression(task);
	}

}

package com.pmo.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.pmo.model.Task;
import com.pmo.service.TaskService;

@RequestScoped
@Named("taskController")
public class TaskController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9148660482678453432L;

	@EJB
	private transient TaskService taskService;

	public int calculateProgression(Task task) {
		return taskService.calculateProgression(task);
	}
	
}

package com.pmo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.pmo.model.Project;
import com.pmo.service.ProjectService;

@RequestScoped
@Named("projectController")
public class ProjectController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6372999549377720106L;
	@EJB
	private transient ProjectService projectService;

	public List<Project> getProjects(){
		return new ArrayList<Project>(projectService.getProjects());
	}
	
}

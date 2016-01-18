package com.pmo.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.ProjectDao;
import com.pmo.model.Event;
import com.pmo.model.Employee;
import com.pmo.model.Project;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;
import com.pmo.service.ProjectService;

@Stateless(name = "pmo/ProjectService", mappedName = "pmo/ProjectService")
public class ProjectServiceImpl implements ProjectService{

	@EJB
	private ProjectDao projectDao;
	
	@Override
	public int createProject(String name, int cost, Date dateStart, Date dateEnd) {
		//to do vérifier les champs
		
		return projectDao.createProject(name, cost, dateStart, dateEnd);
	}

	@Override
	public Project getProject(String name) {
		//to do gérer si le nom n'existe pas
		
		return projectDao.getProject(name);
	}

	@Override
	public Project getProject(int id) {
		//to do gérer si l'id n'existe pas
		
		return projectDao.getProject(id);
	}

	@Override
	public List<Employee> getEmployees(String projectName) {
		Project project = projectDao.getProject(projectName);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		for(ProjectTask pT : project.getProjectTasks()){
			for(Task t : pT.getTasks()){
				employees.add(t.getEmployee());
			}
		}
		
		return employees;
		
	}

	@Override
	public List<Event> getEventEmployees(int idProject) {
		Project project = projectDao.getProject(idProject);
		
		List<Event> events = new ArrayList<Event>();
		
		for(ProjectTask pT : project.getProjectTasks()){
			for(Task t : pT.getTasks()){
				events.addAll(t.getEmployee().getEvents());
			}
		}
		
		return events;
	}

}

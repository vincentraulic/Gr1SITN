package com.pmo.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.ProjectDao;
import com.pmo.model.Employee;
import com.pmo.model.Event;
import com.pmo.model.Phase;
import com.pmo.model.Project;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;
import com.pmo.service.ProjectService;

@Stateless
public class ProjectServiceBean implements ProjectService{

	@EJB
	private ProjectDao projectDao;

	@Override
	public int createProject(Project project) {
		if(project.getDateEnd() != null && project.getDateEnd().compareTo(project.getDateStart()) < 0){
			throw new IllegalArgumentException("La date de fin du projet ne peut pas être avant la date du début");
		}
		
		int cost = 0;
		for(Phase p : project.getPhases()){
			if(p.getStart() != null && p.getEnd()!= null && p.getEnd().compareTo(p.getStart()) < 0)
				throw new IllegalArgumentException("La date de fin de la phase ne peut pas être avant la date de début");				
			if(p.getStart() != null && p.getStart().compareTo(project.getDateStart()) < 0)
				throw new IllegalArgumentException("La date de début de la phase ne peut pas être avant la date de début du projet");	
			if(p.getEnd() != null && p.getEnd().compareTo(project.getDateEnd()) > 0)
				throw new IllegalArgumentException("La date de fin de la phase ne peut pas être aprés la date de fin du projet");	
			cost += p.getCost();
		}
		if(cost > project.getCost())
			throw new IllegalArgumentException("L'ensemble des coûts des phases est supérieur au budget du projet");
		
		for(Project p : projectDao.getProjects()){
			if(p.getName().equals(project.getName())){
				throw new IllegalArgumentException("Le nom du projet est déjà pris");				
			}
		}
		
		return projectDao.createProject(project);
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
	public List<Employee> getEmployees(Project project) {

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

	@Override
	public List<Project> getProjects() {
		return projectDao.getProjects();
	}

}

package com.pmo.service.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pmo.dao.ProjectDao;
import com.pmo.model.Employee;
import com.pmo.model.Event;
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
		//to do vérifier les champs
		//TODO v�rifier le projet n'existe pas

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

	@Override
	public List<Project> getProjects(Employee employee) {
		return projectDao.getProjects(employee);
	}

}

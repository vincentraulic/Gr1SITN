package com.pmo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.util.StringUtils;

import com.pmo.dao.ProjectTaskDao;
import com.pmo.model.Project;
import com.pmo.model.ProjectTask;

@Stateless
public class ProjectTaskDaoImpl implements ProjectTaskDao{

	@PersistenceContext(unitName = "pmodb")
	private EntityManager em ;
	
	public int createProjectTask(int id_project, String name, int cost) {
		if(StringUtils.isEmpty(name) || cost < 0)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		Project project = null;
		try{
			project = em.getReference(Project.class, id_project);
		} catch (EntityNotFoundException e){
			throw new IllegalArgumentException("Can't reference to project,"
					+ " Project not found in database");
		}
		
		ProjectTask projectTask = new ProjectTask();
		projectTask.setName(name);
		projectTask.setCost(cost);
		projectTask.setProject(project);
		
		em.persist(projectTask);
		
		return projectTask.getId_projecttask();
	}

	public void deleteProjectTask(int id) {
		try{
			ProjectTask projectTask = em.getReference(ProjectTask.class, id);
			em.remove(projectTask);
		} catch (EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, ProjectTask not found in database");
		}
	}

	public List<ProjectTask> getProjectTasks(int id_project) {
		List<ProjectTask> list = em.createQuery("SELECT p FROM ProjectTask p "
									+ "WHERE p.id_project = :project")
									.setParameter("project", id_project)
									.getResultList();
		return list;
		
	}

}

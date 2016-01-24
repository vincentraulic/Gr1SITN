package com.pmo.dao.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.pmo.dao.ProjectTaskDao;
import com.pmo.model.Project;
import com.pmo.model.ProjectTask;
import com.pmo.utils.StringUtils;

@Stateless
public class ProjectTaskDaoBean implements ProjectTaskDao{

	@PersistenceContext(unitName = "pmodb")
	private EntityManager em ;
	
	public int createProjectTask(ProjectTask projectTask) {
		if(StringUtils.isEmpty(projectTask.getName()) || projectTask.getCost() < 0)
			throw new IllegalArgumentException("Argument(s) null or empty");

		try{
			em.getReference(Project.class, projectTask.getProject().getId());
		} catch (EntityNotFoundException e){
			throw new IllegalArgumentException("Can't reference to project,"
					+ " Project not found in database");
		}
		
		em.persist(projectTask);
		
		return projectTask.getId();
	}

	public void deleteProjectTask(ProjectTask projectTask) {
		try{
			projectTask = em.getReference(ProjectTask.class, projectTask.getId());
			em.remove(projectTask);
		} catch (EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, ProjectTask not found in database");
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProjectTask> getProjectTasks(int id_project) {
		List<ProjectTask> list = em.createQuery("SELECT p FROM ProjectTask p "
									+ "WHERE p.id_project = :project")
									.setParameter("project", id_project)
									.getResultList();
		return list;
		
	}

}

package com.pmo.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.util.StringUtils;

import com.pmo.dao.ProjectDao;
import com.pmo.model.Project;

@Stateless
public class ProjectDaoImpl implements ProjectDao{

	@PersistenceContext(unitName = "pmodb")
	private EntityManager em ;

	public int createProject(String name, int cost, Date dateStart, Date dateEnd) {
		if(StringUtils.isEmpty(name) || cost < 0 
				|| dateStart == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		Project project = new Project();
		project.setName(name);
		project.setCost(cost);
		project.setDateStart(dateStart);
		project.setDateEnd(dateEnd);
		
		em.persist(project);
		
		return project.getId_project();
	}

	public int createProject(Project project) {
		if(StringUtils.isEmpty(project.getName()) || project.getCost() < 0 
				|| project.getDateStart() == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		em.persist(project);
		
		return project.getId_project();
		
	}

	public Project getProject(int id) {
		return em.find(Project.class, id);
	}

	public Project getProject(String name) {
		List<Project> list = em.createQuery("SELECT p FROM Project p "
				+ "WHERE p.name = :name")
				.setParameter("name", name)
				.getResultList();
		
		if(! list.isEmpty())
			return list.get(0);
		return null;
	}

	public void deleteProject(int id) {
		try{
			Project project = em.getReference(Project.class, id);
			em.remove(project);
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, Project not found in database");
		}
	}

	public void deleteProject(String name) {
		List<Project> list = em.createQuery("SELECT p FROM Project p "
				+ "WHERE p.name = :name")
				.setParameter("name", name)
				.getResultList();
		
		if(list.isEmpty())
			throw new IllegalArgumentException("Can't delete, Project not found in database");
		
		em.remove(list.get(0));
	}
	
	public void deleteProject(Project project) {
		try{
			Project p = em.getReference(Project.class, project.getId_project());
			em.remove(p);
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, Project not found in database");
		}
	}

	public List<Project> getProjects() {
		List<Project> list = em.createQuery("SELECT p FROM Project p ")
				.getResultList();
		return list;
	}


}

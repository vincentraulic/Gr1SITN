package com.pmo.dao.bean;

import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.pmo.dao.ProjectDao;
import com.pmo.model.Employee;
import com.pmo.model.Phase;
import com.pmo.model.Project;
import com.pmo.utils.StringUtils;

@Stateless
public class ProjectDaoBean implements ProjectDao{

	@PersistenceContext(unitName = "pmodb")
	private EntityManager em ;

	public int createProject(Project project) {
		if(StringUtils.isEmpty(project.getName()) || project.getCost() < 0 
				|| project.getDateStart() == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		em.persist(project);
		
		return project.getId();
	}

	public Project getProject(int id) {
		return em.find(Project.class, id);
	}

	@SuppressWarnings("unchecked")
	public Project getProject(String name) {
		List<Project> list = em.createQuery("SELECT p FROM Project p "
				+ "WHERE p.name = :name")
				.setParameter("name", name)
				.getResultList();
		
		if(! list.isEmpty())
			return list.get(0);
		else
			throw new IllegalArgumentException("Project name not found");
	}

	public void deleteProject(int id) {
		try{
			Project project = em.getReference(Project.class, id);
			em.remove(project);
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, Project not found in database");
		}
	}

	@SuppressWarnings("unchecked")
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
			Project p = em.getReference(Project.class, project.getId());
			em.remove(p);
		} catch(EntityNotFoundException e){
			throw new IllegalStateException("Can't delete, Project not found in database");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Project> getProjects() {
		List<Project> list = em.createQuery("SELECT p FROM Project p ")
				.getResultList();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Project> getProjects(Employee employee) {
		List<Project> list = em.createQuery("SELECT s FROM Project s "
				+ "WHERE s.employee.id = :emp")
				.setParameter("emp", employee.getId())
				.getResultList();
		return list;
	}
}

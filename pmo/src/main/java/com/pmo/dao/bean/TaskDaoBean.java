package com.pmo.dao.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import com.pmo.dao.TaskDao;
import com.pmo.model.Employee;
import com.pmo.model.ProjectTask;
import com.pmo.model.Task;

@Stateless
public class TaskDaoBean implements TaskDao {

    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;
	
	public int createTask(Task task) {
		
		if(task.getCost() < 0 || task.getDateStart() == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		try{
			em.getReference(ProjectTask.class, task.getProjectTask());
			em.getReference(Employee.class, task.getEmployee());
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't reference to projectTask or employee,"
					+ " projectTask or employee not found in database");
		}
		
		em.persist(task);
		
		return task.getId();
		
	}

	public void deleteTask(Task task) {
		try{
			task = em.getReference(Task.class, task.getId());
			em.remove(task);
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, Task not found in database");
		}
	}

	public Task getTask(int id) {
		return em.find(Task.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTasks(ProjectTask projectTask) {
		List<Task> list = em.createQuery("SELECT s FROM Task s "
							+ "WHERE s.id_projecttask = :projecttask")
							.setParameter("projecttask", projectTask.getId())
							.getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTasks(Employee employee) {
		List<Task> list = em.createQuery("SELECT s FROM Task s "
				+ "WHERE s.employee.id_employee = :emp")
				.setParameter("emp", employee.getId())
				.getResultList();
		return list;
	}

}

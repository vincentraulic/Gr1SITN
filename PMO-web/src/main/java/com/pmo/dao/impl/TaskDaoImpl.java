package com.pmo.dao.impl;

import java.util.Date;
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
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;
	
	public int createTask(int id_projectTask, int id_employee,
			int cost, Date dateStart, Date dateEnd, int weekNumber, int year) {
		
		if(cost < 0 || dateStart == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		ProjectTask projectTask = null;
		Employee employee = null;
		try{
			projectTask = em.getReference(ProjectTask.class, id_projectTask);
			employee = em.getReference(Employee.class, id_employee);
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't reference to projectTask or employee,"
					+ " projectTask or employee not found in database");
		}
		
		Task task = new Task();
		task.setProjectTask(projectTask);
		task.setEmployee(employee);
		task.setCost(cost);
		task.setDateStart(dateStart);
		task.setDateEnd(dateEnd);
		
		em.persist(task);
		
		return task.getId_task();
		
	}

	public void deleteTask(int id) {
		try{
			Task task = em.getReference(Task.class, id);
			em.remove(task);
		} catch(EntityNotFoundException e){
			throw new IllegalArgumentException("Can't delete, Task not found in database");
		}
	}

	public Task getTask(int id) {
		return em.find(Task.class, id);
	}

	public List<Task> getTasks(ProjectTask projectTask) {
		List<Task> list = em.createQuery("SELECT s FROM Task s "
							+ "WHERE s.id_projecttask = :projecttask")
							.setParameter("projecttask", projectTask.getId_projecttask())
							.getResultList();
		return list;
	}

	public List<Task> getTasks(Employee employee) {
		List<Task> list = em.createQuery("SELECT s FROM Task s "
				+ "WHERE s.employee.id_employee = :emp")
				.setParameter("emp", employee.getId_employee())
				.getResultList();
		return list;
	}

}

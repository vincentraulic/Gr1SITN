package com.exos.transactionEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pmo.model.Employee;

@Stateless
@LocalBean
public class EmployeeTransaction {	
	
	public Employee upcaseLastname(int idEmployee){	
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("pmodb_local") ;
		
		EntityManager em = emf.createEntityManager() ;
		
		em.getTransaction().begin() ;
		
		Employee employee = em.find(Employee.class, idEmployee);
		employee.setLastname(employee.getLastname().toUpperCase());
		
		em.merge(employee) ;
		
		em.getTransaction().commit();
		return employee;
	}
}

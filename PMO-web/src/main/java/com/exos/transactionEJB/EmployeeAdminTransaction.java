package com.exos.transactionEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.pmo.model.Employee;

@Stateless
@LocalBean
public class EmployeeAdminTransaction {
	
	private static final String LOCAL_DATABASE = "pmodb_local";
	
	private static final String QUERY_SELECT_EMPLOYEE_TO_MODIFY = "SELECT e FROM Employee e WHERE e.dateEnd is null and e.id_employee != :id";

	public Employee grantAdminEmployee(int idEmployee){	
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("pmodb_local") ;
		
		EntityManager em = emf.createEntityManager() ;
		
		em.getTransaction().begin() ;
		
		Employee employee = em.find(Employee.class, idEmployee);
		employee.setRole("ROLE_ADMIN");
		
		em.merge(employee) ;
		
		em.getTransaction().commit();
		return employee;
	}

}

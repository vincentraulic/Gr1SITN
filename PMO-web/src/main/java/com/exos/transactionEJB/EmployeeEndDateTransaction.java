package com.exos.transactionEJB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.pmo.model.Employee;

@Stateless
@LocalBean
public class EmployeeEndDateTransaction {
	
	private static final String LOCAL_DATABASE = "pmodb_local";
	
	private static final String QUERY_SELECT_EMPLOYEE_TO_MODIFY = "SELECT e FROM Employee e WHERE e.dateEnd is null and e.id_employee != :id";

	public List<Employee> fillEndDates(int idException) throws IllegalArgumentException {
		List<Employee> employees = new ArrayList<Employee>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(LOCAL_DATABASE);
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			if(!tx.isActive()) {
				tx.begin();
			}
			
			/** La suite aurait pu se faire en un seul UPDATE FROM,
			 * mais j'ai séparé pour avoir un rollback "utile"
			 * Après tout, c'est un servlet de test, on peut y mettre n'importe quoi... :)
			 */
			
			
			List<?> results = em.createQuery(QUERY_SELECT_EMPLOYEE_TO_MODIFY)
			.setParameter("id", idException)
			.getResultList();
			
			if(results.size() > 0) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, 365);
				
				for(Object o : results) {
					Employee emp = (Employee) o;
					emp.setDateEnd(cal.getTime());
					em.merge(emp);
					employees.add(emp);
				}
			}
			
			tx.commit();
		} catch(Exception e) {
			employees = null;
			System.out.println("Exception pendant la modification des dates : " + e);
			if(tx.isActive()) tx.rollback();
		}
		
		return employees;
	}

}

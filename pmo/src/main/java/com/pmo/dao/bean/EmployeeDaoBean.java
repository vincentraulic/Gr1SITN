package com.pmo.dao.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pmo.dao.EmployeeDao;
import com.pmo.model.Employee;
import com.pmo.utils.StringUtils;

@Stateless
public class EmployeeDaoBean implements EmployeeDao{

    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;

	public int createEmployee(Employee employee) {
		
		if(StringUtils.isEmpty(employee.getLastname()) || StringUtils.isEmpty(employee.getFirstname()) 
				|| employee.getDateStart() == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		employee.setUsername(employee.getFirstname().toLowerCase() + "." + employee.getLastname().toLowerCase());
		employee.setRole("ROLE_USER");
		
		em.persist(employee);
		
		return employee.getId();
	}

	public void endEmployee(Employee employee) {
		employee = em.merge(employee) ;

		em.remove(employee) ;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return em.createQuery("SELECT e FROM Employee e").getResultList();
	}

	public Employee getEmployee(int id) {
		return em.find(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public Employee getEmployee(String lastname, String firstname) {
		List<Employee> list = em.createQuery("SELECT e FROM Employee e "
							+ "WHERE e.lastname = :lastn "
							+ "AND e.firstname = :firstn")
				 .setParameter("lastn", lastname)
				 .setParameter("firstn", firstname)
				 .getResultList();
		
		if(! list.isEmpty())
			return list.get(0);
		return null;
	}

	


}

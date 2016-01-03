package com.pmo.dao.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pmo.dao.EmployeeDao;
import com.pmo.model.Employee;

import org.springframework.util.StringUtils;

@Stateless
public class EmployeeDaoImpl implements EmployeeDao{

    @PersistenceContext(unitName = "pmodb")
	private EntityManager em ;

	public int createEmployee(String lastname, String firstname, 
			String password, Date dateStart) {
		
		if(StringUtils.isEmpty(lastname) || StringUtils.isEmpty(firstname) 
				|| StringUtils.isEmpty(password) || dateStart == null)
			throw new IllegalArgumentException("Argument(s) null or empty");
		
		Employee employee = new Employee();
		employee.setLastname(lastname);
		employee.setFirstname(firstname);
		employee.setDateStart(dateStart);
		
		employee.setPassword(password);
		employee.setUsername(firstname.toLowerCase() + "." + lastname.toLowerCase());
		employee.setRole("ROLE_USER");
		
		em.persist(employee);
		
		return employee.getId_employee();
	}

	public int endEmployee(String id, Date dateEnd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Employee> getEmployees() {
		return em.createQuery("SELECT e FROM Employee e").getResultList();
	}

	public Employee getEmployee(int id) {
		return em.find(Employee.class, id);
	}

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

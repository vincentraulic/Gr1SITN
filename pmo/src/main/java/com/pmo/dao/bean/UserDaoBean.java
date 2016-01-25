package com.pmo.dao.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;

@Stateless(name = "pmo/UserDao", mappedName = "pmo/UserDao")
public class UserDaoBean implements UserDao{

	@PersistenceContext(unitName = "pmodb")
	private EntityManager em ;

	@SuppressWarnings("unchecked")
	public Employee getUser(String username) {
		List<Employee> list = em.createQuery("SELECT e FROM Employee e "
				+ "WHERE e.username = :username")
				.setParameter("username", username)
				.getResultList();
		if(! list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String getPassword(String username) {
		List<Employee> list = em.createQuery("SELECT e FROM Employee e "
				+ "WHERE e.username = :username")
				.setParameter("username", username)
				.getResultList();
		if(! list.isEmpty()){
			return list.get(0).getPassword();
		}
		return null;
	}

	public String updatePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}


}

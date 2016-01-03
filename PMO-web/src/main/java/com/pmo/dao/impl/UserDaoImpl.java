package com.pmo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.pmo.dao.UserDao;
import com.pmo.model.Employee;

@Stateless
public class UserDaoImpl implements UserDao{

	@PersistenceContext(unitName = "pmodb")
	private EntityManager em ;

	@Override
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

	@Override
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

	@Override
	public String updatePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}


}

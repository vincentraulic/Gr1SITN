package com.pmo.dao;

import javax.ejb.Local;

import com.pmo.model.Employee;

@Local
public interface UserDao {

	public Employee getUser(String username);
	
	public String getPassword(String username);
	
	public String updatePassword(String username, String newPassword);
}

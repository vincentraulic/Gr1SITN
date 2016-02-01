package com.pmo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYEE")
public class Employee extends AbstractPersistent{

	private static final long serialVersionUID = -4265943175939107524L;

	@Column(name="lastname", nullable=false)
	private String lastname;
	@Column(name="firstname", nullable=false)
	private String firstname;
	@Temporal(TemporalType.DATE)
	@Column(name="datestart", nullable=false)
	private Date dateStart;
	@Temporal(TemporalType.DATE)
	@Column(name="dateend")
	private Date dateEnd;
	@Temporal(TemporalType.DATE)
	@Column(name="birthdate")
	private Date birthdate;
	
	@Column(name="username")
	private String username;
	@Column(name="password", nullable=false)
	private String password;
	@Column(name="role", nullable=false)
	private String role;
	
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="poste")
	private String poste;
	
	@OneToMany(mappedBy="employee")
	private Set<Task> tasks = new HashSet<Task>();

	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	private Set<Event> events = new HashSet<Event>();
	
	@ManyToMany
	@JoinTable(
		      name="EMPLOYEES_PROJECTS",
		      joinColumns={@JoinColumn(name="id_employee", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="id_project", referencedColumnName="id")})
	private Set<Project> projects = new HashSet<Project>();

	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Set<Event> getEvents(){
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;

		Employee a = (Employee) obj;

		if(a.getId() != this.getId())
			return false;
		if( !a.lastname.equals(this.lastname))
			return false;
		if( !a.firstname.equals(this.firstname))
			return false;
		if( !a.dateStart.equals(this.dateStart))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return lastname.hashCode() + firstname.hashCode() + dateStart.hashCode();
	}

}

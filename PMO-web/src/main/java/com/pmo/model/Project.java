package com.pmo.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROJECT")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_project")
	private int id_project;
	@Column(name="name")
	private String name;
	@Column(name="cost")
	private int cost;
    @Temporal(TemporalType.DATE)
    @Column(name="datestart", nullable=false)
	private Date dateStart;
    @Temporal(TemporalType.DATE)
    @Column(name="dateend")
	private Date dateEnd;
	
    @OneToMany(fetch=FetchType.LAZY, mappedBy="project", cascade=CascadeType.ALL)
	private Set<ProjectTask> projectTasks = new HashSet<ProjectTask>();

	public int getId_project() {
		return id_project;
	}
	public void setId_project(int id_project) {
		this.id_project = id_project;
	}
	public String getName() {
		return name;
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
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public Set<ProjectTask> getProjectTasks() {
		return projectTasks;
	}
	public void setProjectTasks(Set<ProjectTask> projectTasks) {
		this.projectTasks = projectTasks;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Project a = (Project) obj;
		
		if(a.id_project != this.id_project)
			return false;
		if( !a.name.equals(this.name))
			return false;
		if(a.cost != this.cost)
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + dateStart.hashCode() + dateEnd.hashCode() + cost;

	}
}

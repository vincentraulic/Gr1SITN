package com.pmo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTTASK")
public class ProjectTask {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_projecttask")
	private int id_projecttask;
	@Column(name="name")
	private String name;
	@Column(name="cost")
	private int cost;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="projectTask")
	private Set<Task> tasks = new HashSet<Task>();
	
	@ManyToOne
	@JoinColumn(name="id")
	private Project project;

	public int getId_projecttask() {
		return id_projecttask;
	}

	public void setId_projecttask(int id_projecttask) {
		this.id_projecttask = id_projecttask;
	}

	public String getName() {
		return name;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public Set<Task> getTasks(){
		return this.tasks;
	}
	
	public void setTask(Set<Task> tasks){
		this.tasks = tasks;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		ProjectTask a = (ProjectTask) obj;
		
		if(a.id_projecttask != this.id_projecttask)
			return false;
		if( !a.name.equals(this.name))
			return false;
		if(a.cost != this.cost)
			return false;
		if( !a.project.equals(this.project))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + cost + project.hashCode();

	}
}

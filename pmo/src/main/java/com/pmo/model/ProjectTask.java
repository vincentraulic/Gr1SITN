package com.pmo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJECTTASK")
public class ProjectTask extends AbstractPersistent{

	private static final long serialVersionUID = 5957242019666021735L;
	
	@Column(name="name")
	private String name;
	@Column(name="cost")
	private int cost;
	
	@OneToMany(mappedBy="projectTask")
	private Set<Task> tasks = new HashSet<Task>();
	
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;

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
		
		if(a.getId() != this.getId())
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

package com.pmo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(
        name="Phase.findAll",
        query="SELECT s FROM Phase s"),
    @NamedQuery(
        name="Phase.findByProjectId",
        query="SELECT s FROM Phase s "
				+ "WHERE s.project.id = :proj")
})
@Entity
@Table(name="PHASE")
public class Phase extends AbstractPersistent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1415748246553662487L;

	@Column(name="name", nullable=false)
	private String name;
	@Column(name="cost")
	private int cost;
	
	@Column(name="datestart")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	public String getName() {
		return name;
	}

	@Column(name="dateend")
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;
	
	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Phase a = (Phase) obj;
		
		if(a.getId() != this.getId())
			return false;
		if( !a.name.equals(this.name))
			return false;
		if( !a.start.equals(this.start))
			return false;
		if( !a.end.equals(this.end))
			return false;
		if( !a.project.equals(this.project))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
        return result;
	}

	@Override
	public String toString() {
		return this.getName() + "" + this.getProject().getName();
	}

}

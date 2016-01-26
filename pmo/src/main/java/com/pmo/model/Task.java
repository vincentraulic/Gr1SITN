package com.pmo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TASK")
public class Task extends AbstractPersistent{

	private static final long serialVersionUID = -4391203115504285981L;

	@ManyToOne
	@JoinColumn(name="id_projecttask")
	private ProjectTask projectTask;
	
	@ManyToOne
	@JoinColumn(name="id_employee")
	private Employee employee;
	
	private int cost;
    
	@Temporal(TemporalType.DATE)
    @Column(name="datestart", nullable=false)
	private Date dateStart;
    @Temporal(TemporalType.DATE)
    @Column(name="dateend")
	private Date dateEnd;
    
    @Column (name="mandayUsed", nullable=false)
    private int mandayUsed;

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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
	
	public int getMandayUsed() {
		return mandayUsed;
	}

	public void setMandayUsed(int mandayUsed) {
		this.mandayUsed = mandayUsed;
	}	

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Task s = (Task) obj;
		
		if(getId() != s.getId())
			return false;
		if (projectTask != null ? 
				!projectTask.equals(s.projectTask) : s.projectTask != null) 
			return false;
		if (employee != null ? 
				!employee.equals(s.employee) : s.employee != null) 
			return false;
		if(! dateStart.equals(s.dateStart))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = getId();
        return result;
	}
}

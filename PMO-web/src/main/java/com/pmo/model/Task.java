package com.pmo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TASK")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_task")
	private int id_task;

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

	public int getId_task() {
		return id_task;
	}

	public void setId_task(int id_task) {
		this.id_task = id_task;
	}
	
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

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Task s = (Task) obj;
		
		if(id_task != s.id_task)
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
		int result;
        result = (projectTask != null ? projectTask.hashCode() : 0);
        result = 16 * result + (employee != null ? employee.hashCode() : 0) + dateStart.hashCode();
        return result;
	}
}

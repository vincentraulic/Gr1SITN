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
@Table(name="ABSENCE")
public class Absence{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_absence")
	private int id_absence;
	@Column(name="reason")
	private String reason;
	@Temporal(TemporalType.DATE)
	@Column(name="datestart")
	private Date dateStart;
	@Temporal(TemporalType.DATE)
	@Column(name="dateend")
	private Date dateEnd;
	
	@ManyToOne
	@JoinColumn(name="id_employee")
	private Employee employee;
	
	
	public int getId_absence() {
		return id_absence;
	}

	public void setId_absence(int id_absence) {
		this.id_absence = id_absence;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Absence a = (Absence) obj;
		
		if(a.id_absence != this.id_absence)
			return false;
		if( !a.reason.equals(this.reason))
			return false;
		if( !a.dateStart.equals(this.dateStart))
			return false;
		if( !a.dateEnd.equals(this.dateEnd))
			return false;
		if( !a.employee.equals(this.employee))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = reason.hashCode() + dateStart.hashCode() + dateEnd.hashCode();
        result = result + (employee != null ? employee.hashCode() : 0);
        return result;
	}
}

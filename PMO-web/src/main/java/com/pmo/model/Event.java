package com.pmo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="EVENT")
public class Event{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id_event;
	private String reason;
	private String type;
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	private boolean allDay;
	
	@ManyToOne
	@JoinColumn(name="id_employee")
	@JsonIgnore
	private Employee employee;
	
	@Transient
	private String title;
	
	public int getId_event() {
		return id_event;
	}

	public void setId_event(int id_event) {
		this.id_event = id_event;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date dateStart) {
		this.start = dateStart;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date dateEnd) {
		this.end = dateEnd;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getTitle() {
		return type + " : " + reason;
	}
	
	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		
		Event a = (Event) obj;
		
		if(a.id_event != this.id_event)
			return false;
		if( !a.reason.equals(this.reason))
			return false;
		if( !a.start.equals(this.start))
			return false;
		if( !a.end.equals(this.end))
			return false;
		if( !a.employee.equals(this.employee))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = id_event;
        return result;
	}


}

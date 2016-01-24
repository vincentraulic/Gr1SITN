package com.pmo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.pmo.event.type.EventType;

@Entity
@Table(name="EVENT")
public class Event extends AbstractPersistent{

	private static final long serialVersionUID = 5741436241683297737L;

	private String reason;
	
	@Enumerated(EnumType.STRING)
	private EventType type;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	private boolean allDay;
	
	@ManyToOne
	@JoinColumn(name="id_employee")
	private Employee employee;
	
	@Transient
	private String title;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
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
		
		if(a.getId() != this.getId())
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
		int result = getId();
        return result;
	}


}

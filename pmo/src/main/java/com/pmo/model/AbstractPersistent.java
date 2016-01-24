package com.pmo.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractPersistent implements Serializable{

	private static final long serialVersionUID = -1474217871155993922L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

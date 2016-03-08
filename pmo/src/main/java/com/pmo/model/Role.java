package com.pmo.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role extends AbstractPersistent{

	/**
	 * Generated serial id
	 */
	private static final long serialVersionUID = -707082766281361682L;
	
	@JoinColumn(name="name", nullable=false)
	private Role name;
}

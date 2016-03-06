package com.pmo.model;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name="PROJECT_ROLES")
public class ProjectRoles  {

	
	@ManyToOne
	@JoinColumn(name="id_project", nullable=false)
	private String idProject;
	
	@ManyToOne
	@JoinColumn(name="id_role", nullable=false)
	private Role idRole;
}

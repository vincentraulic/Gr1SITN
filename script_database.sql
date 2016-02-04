CREATE TABLE EMPLOYEE(
	id INT NOT NULL AUTO_INCREMENT,
	lastname VARCHAR(50) NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL UNIQUE,
	password VARCHAR(30) NOT NULL,
	role VARCHAR(50) NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	email VARCHAR(70) NOT NULL,
	birthdate DATE,
	phone VARCHAR(10) NOT NULL,
	poste VARCHAR(40) NOT NULL,
	CONSTRAINT pk_employee PRIMARY KEY(id)
)
ENGINE=InnoDB;

INSERT INTO EMPLOYEE
VALUES (1, 'toto', 'roland', 'roland.toto', '$2a$10$DT18wtMdGuNhR4smwOrlA.i4RwwELPOg1..qNrK8f.IO2mD9SWGQC', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);
INSERT INTO EMPLOYEE
VALUES (2, 'raulic', 'vincent', 'vincent.raulic', '$2a$10$DT18wtMdGuNhR4smwOrlA.i4RwwELPOg1..qNrK8f.IO2mD9SWGQC', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);
INSERT INTO EMPLOYEE
VALUES (3, 'combier', 'quentin', 'quentin.combier', '$2a$10$DT18wtMdGuNhR4smwOrlA.i4RwwELPOg1..qNrK8f.IO2mD9SWGQC', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);
INSERT INTO EMPLOYEE
VALUES (4, 'bethelot', 'thomas', 'thomas.bethelot', '$2a$10$DT18wtMdGuNhR4smwOrlA.i4RwwELPOg1..qNrK8f.IO2mD9SWGQC', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);


CREATE TABLE EVENT(
	id INT NOT NULL AUTO_INCREMENT,
	id_employee INT NOT NULL,
	reason VARCHAR(200),
	start TIMESTAMP NOT NULL,
	end TIMESTAMP,
	allDay BOOLEAN,
	type ENUM('ABSENCE',
	'LEAVE',
	'SICK_LEAVE',
	'FORMATION',
	'PROJECT_ENTRY',
	'PROJECT_EXIT',
	'MEETING',
	'OTHER'),
	CONSTRAINT pk_event PRIMARY KEY(id),
	CONSTRAINT fk_event_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id)
)
ENGINE=InnoDB;

CREATE TABLE PROJECT(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL UNIQUE,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_project PRIMARY KEY(id)
)
ENGINE=InnoDB;

CREATE TABLE EMPLOYEES_PROJECTS(
	id_employee INT NOT NULL,
	id_project INT NOT NULL,
	PRIMARY KEY (id_employee, id_project) ,
	CONSTRAINT fk_employee_project FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id),
	CONSTRAINT fk_project_employee FOREIGN KEY(id_project) REFERENCES PROJECT(id)
)
ENGINE=InnoDB;

CREATE TABLE PROJECTTASK(
	id INT NOT NULL AUTO_INCREMENT,
	id_project INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	CONSTRAINT pk_projecttask PRIMARY KEY(id),
	CONSTRAINT fk_projecttask_project FOREIGN KEY(id_project) REFERENCES PROJECT(id)
)
ENGINE=InnoDB;

CREATE TABLE TASK(
	id INT NOT NULL AUTO_INCREMENT,
	id_projecttask INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	mandayUsed INT NOT NULL DEFAULT 0,
	CONSTRAINT pk_task PRIMARY KEY(id),
	CONSTRAINT fk_task_projecttask FOREIGN KEY(id_projecttask) REFERENCES PROJECTtask(id),
	CONSTRAINT fk_task_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id)
)
ENGINE=InnoDB;


CREATE TABLE EMPLOYEE(
	id_employee INT NOT NULL AUTO_INCREMENT,
	lastname VARCHAR(50) NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(30) NOT NULL,
	role VARCHAR(50) NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_employee PRIMARY KEY(id_employee)
)
ENGINE=InnoDB;

INSERT INTO EMPLOYEE
VALUES (1, 'toto', 'roland', 'roland.toto', '123456', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);
INSERT INTO EMPLOYEE
VALUES (2, 'raulic', 'vincent', 'vincent.raulic', '123456', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);


CREATE TABLE EVENT(
	id_event INT NOT NULL AUTO_INCREMENT,
	id_employee INT NOT NULL,
	type VARCHAR(50) NOT NULL,
	reason VARCHAR(200),
	start TIMESTAMP NOT NULL,
	end TIMESTAMP,
	allDay BOOLEAN,
	CONSTRAINT pk_event PRIMARY KEY(id_event),
	CONSTRAINT fk_event_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;

CREATE TABLE PROJECT(
	id_project INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_project PRIMARY KEY(id_project)
)
ENGINE=InnoDB;

CREATE TABLE PROJECTTASK(
	id_projecttask INT NOT NULL AUTO_INCREMENT,
	id_project INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	cost INT NOT NULL,
	CONSTRAINT pk_projecttask PRIMARY KEY(id_projecttask),
	CONSTRAINT fk_projecttask_project FOREIGN KEY(id_project) REFERENCES PROJECT(id_project)
)
ENGINE=InnoDB;

CREATE TABLE TASK(
	id_task INT NOT NULL AUTO_INCREMENT,
	id_projecttask INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_task PRIMARY KEY(id_task),
	CONSTRAINT fk_task_projecttask FOREIGN KEY(id_projecttask) REFERENCES PROJECTtask(id_projecttask),
	CONSTRAINT fk_task_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;


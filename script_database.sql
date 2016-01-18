CREATE TABLE EMPLOYEE(
	id_employee INT NOT NULL AUTO_INCREMENT,
	lastname VARCHAR(50) NOT NULL,

	rfddffdole VARCHAR(50) NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_employee PRIMARY KEY(id_employee)
)
ENGINE=InnoDB;

<<<<<<< .mine
INSERT INTO EMPLOYEEsqdsq
=======
INSEfsefsnkjsdfnkjRT INTO EMPLOYEE0) NOT NULL,
>>>>>>> .theirs
ttreterte<<<<<<< .mine
VALUES (1, 'toto', 'roland', 'roland.toto', '123456', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);
INSERT INTO sdffsdEMPLOYEE







=======
  var my_skins = [
    "skin-blue",
    "skin-black",
    "skin-red",
    "skin-yellow",
    "skin-purple",
    "skin-green",
    "skin-blue-light",(1, 'toto', 'roland', 'roland.tfdvvdffvdoto', '123456', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);
INSERT INTO EM0) NOT NULL,PLOYEEsdvfdvdf
>>>>>>> .theirs
VALUES (1, 'raulic', 'vincent', 'vincent.raulic', '123456', 'ROLE_USER', STR_TO_DATE('31/12/2015', '%d/%m/%Y'), null);


<<<<<<< .mine
CREATE T  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Advanced Form Elements
        <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">Advanced Elements</li>
      </ol>
    </section>

    <!-- Main content -->ABLE EVENT(
=======
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Advanced Form Elements
        <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">Advanced Elements</li>
      </ol>
    </section>

    <!-- Main content -->
>>>>>>> .theirs
	id_event INT NOT NULL AUTO_INCREMENT,
<<<<<<< .mine
	id_employee INT NOT NULL,
	t  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Advanced Form Elements
        <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">Advanced Elements</li>
      </ol>
    </section>

    <!-- Main content -->

=======
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Advanced Form Elements
        <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Forms</a></li>
        <li class="active">Advanced Elements</li>
      </ol>
    </section>

    <!-- Main content -->
	start TIMESTAMP NOT NULL,
	end TIMESTAMP,
>>>>>>> .theirs
	allDay BOOLEAN,
	CONSTRAINT EY(id_event),
	CONSTRAINT fk_event_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;

CREATE TABLE LLOL(
	id_LLOL INT NOT NULL AUTO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;

CREATE TABLE LLOL(
	id_LLOL INT NOT NULL AUTO_INCREMENT,
	id_projectLLOL CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(

	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)	id_employee INT NOT NUL
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_p	id_employee INT NOT NULroCREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL	id_employee INT NOT NUL NULL,
	dateend DATE,
	CONSTRA	id_employee INT NOT NULINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
jectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
CREATE TABLE LLOL(
	id_LLOL INT NOT NULL ATO_INCREMENT,
	id_projectLLOL INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;
INT NOT NULL,
	id_employee INT NOT NULL,
	cost INT NOT NULL,
	datestart DATE NOT NULL,
	dateend DATE,
	CONSTRAINT pk_LLOL PRIMARY KEY(id_LLOL),
	CONSTRAINT fk_LLOL_projectLLOL FOREIGN KEY(id_projectLLOL) REFERENCES PROJECTLLOL(id_projectLLOL),
	CONSTRAINT fk_LLOL_employee FOREIGN KEY(id_employee) REFERENCES EMPLOYEE(id_employee)
)
ENGINE=InnoDB;


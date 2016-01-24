<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirect page</title>
</head>
<body>
<ul>
	<li>
		<a href="http://localhost:8080/PMO-web/app/login">PMO application</a>
	</li>
	<li>
		<a href="http://localhost:8080/PMO-web/upcaselastname?id=1">Homework JDBC (JPA) 1 : met à jour le nom du premier employée (n'oubliez pas de changer les identifiants du persistence-unit pmodb_local)</a>
	</li>
	<li>
		<a href="http://localhost:8080/PMO-web/fillEndDateEmployees?id=2">Homework JDBC (JPA) 2 : initialise les dates de fin de contrat des employés sans date de fin sauf pour l'id passé en paramètre</a>
	</li>
</ul>
</body>
</html>
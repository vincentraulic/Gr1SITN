package com.exos.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exos.transactionEJB.EmployeeAdminTransaction;
import com.exos.transactionEJB.EmployeeEndDateTransaction;
import com.pmo.model.Employee;

@WebServlet(value="/grantAdminEmployee")
public class GrantAdminEmployee extends HttpServlet {

	@EJB
	EmployeeAdminTransaction eat;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		String idEmployee = req.getParameter("id");
		
		Employee employee = eat.grantAdminEmployee(Integer.parseInt(idEmployee));
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Modification en ROLE_ADMIN !</title></head>");
		pw.println("<body>");
		pw.println("<h3>L'employée : '" + employee.getLastname() + "' a maintenant les droits d'admins</h3>");
		pw.println("<br />Son rôle : " + employee.getRole());
		pw.println("</body></html>");
		
		                         
	}
}

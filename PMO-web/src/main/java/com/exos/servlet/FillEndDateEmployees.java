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

import com.exos.transactionEJB.EmployeeEndDateTransaction;
import com.pmo.model.Employee;


/** 
 * 
 * @author Quentin
 * Fixe une date de fin de contrat à tous les employés qui n'ont pas de date de fin,
 * sauf à celui d'id passé en paramètre. Date par défaut à SYSDATE + 365 jours
 *
 */
@WebServlet(value="/fillEndDateEmployees")
public class FillEndDateEmployees extends HttpServlet {

	private static final long serialVersionUID = -8015830736961715008L;

	@EJB
	EmployeeEndDateTransaction employeeEndDateTransaction;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
		
		int idWithoutModif = Integer.parseInt(request.getParameter("id"));
		List<Employee> employees = employeeEndDateTransaction.fillEndDates(idWithoutModif);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Modified employees</title></head>");
		pw.println("<body>");
		
		if(employees == null) {
			pw.println("Due to an internal error, employees have not been modified");
		} else if(employees.size() == 0) {
			pw.println("All end date are filled in database. No end date has been modified");
		} else {
			pw.println("Format : [Id] Employee username : new end date");
			pw.println("<ul>");
			for(Employee emp : employees) {
				pw.println("<li>");
				pw.println("[" + emp.getId_employee() + "] " + emp.getUsername() + " : " + emp.getDateEnd().toString());
				pw.println("</li>");
			}
			pw.println("</ul>");
		}
		pw.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// Do nothing
	}
}

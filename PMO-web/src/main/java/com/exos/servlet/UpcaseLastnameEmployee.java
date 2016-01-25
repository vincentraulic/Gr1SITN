package com.exos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exos.transactionEJB.EmployeeTransaction;
import com.pmo.model.Employee;

@WebServlet(value="/upcaselastname")
public class UpcaseLastnameEmployee extends HttpServlet{

	private static final long serialVersionUID = 5390378422514471987L;

	@EJB
	EmployeeTransaction employeeTransaction;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		Employee employee = employeeTransaction.upcaseLastname(Integer.parseInt(id));

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Hello World</title></head>");
		pw.println("<body>");
		pw.println("<h1>Lastname modified : " + employee.getLastname() + "</h1>");
		pw.println("</body></html>");
	}

}

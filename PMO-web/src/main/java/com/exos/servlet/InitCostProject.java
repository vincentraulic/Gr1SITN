package com.exos.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exos.transactionEJB.ProjectTransaction;
import com.pmo.model.Project;

/** 
 * 
 * @author Vincent
 * Reviewer Roland
 * Initialise le coût d'un projet à 0
 *
 */

@WebServlet(name="initCostProject", description ="Init cost to a project", urlPatterns = "/initCostProject")
public class InitCostProject extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 344635660042183931L;
	
	@EJB
	private ProjectTransaction projectTransaction;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		Project project = projectTransaction.initCostProject(id);

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head><title>Init cost to a projet</title></head>");
		writer.println("<body>");
		writer.println("<p>Project name : " + project.getName() + "</p>");
		if(project.getCost() == 0){
			writer.println("The project "+project.getName()+" has been init and is cost is set to "+project.getCost());
		} else {
			writer.println("The project hasn't been found or an error happened");
		}
		writer.println("</body>");
		writer.println("</html>");

	}
}
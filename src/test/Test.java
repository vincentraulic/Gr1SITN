package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@WebServlet("/toto")
public class Test extends HttpServlet{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(Test.class);
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        	BasicConfigurator.configure();
            String add1 = req.getParameter("add1");
            String add2 = req.getParameter("add2");
           
            int sum = Integer.parseInt(add1) + Integer.parseInt(add2);
            LOGGER.info("ca fait "+sum);
            resp.getWriter().append("ca fait " + sum);
           
   
           
        }catch(Exception e){
            resp.sendRedirect("https://www.google.fr/#q=t%27es+con");
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
   
}
package it.geek.libreria.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;





public class LogoutServlet extends HttpServlet{

	private static Logger logger = Logger.getLogger("LogoutServlet.Class");
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		
		doPost(request,response);		
		
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException,IOException{
		
		HttpSession session = request.getSession();
		session.invalidate();
		logger.info(session.getId());
		response.sendRedirect("logout.html");
		
		
	}
}

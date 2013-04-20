package it.geek.libreria.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import it.geek.libreria.model.Utente;
import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.DAO.impl.UtenteDAO;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;


public class LoginServlet extends HttpServlet{
	
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException,IOException{
		
			doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException,IOException{
		
			String nome = request.getParameter("nome");
		    String password = request.getParameter("password");
			
		    logger.info(nome);
		    logger.info(password);
		    
			IDAO dao = new UtenteDAO();
			Utente utente = (Utente) dao.findById(nome);
			String username = utente.getUsername();
			String password2 = utente.getPassword();
			String ruolo = utente.getRuolo();
			
			logger.debug(username);
			logger.debug(password2);
			logger.debug(ruolo);
				
			
			
			if(ruolo!=null){
				
				HttpSession session = request.getSession();
				session.setAttribute("ruolo",ruolo);
			
			}
			
			request.setAttribute("Utente",utente);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request,response);
			
			
	
	}

}

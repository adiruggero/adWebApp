package it.geek.libreria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.geek.libreria.model.Utente;
import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.DAO.impl.UtenteDAO;
import org.apache.log4j.Logger;

public class InsertServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger("InsertServlet.class");
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException,IOException{
		
		IDAO dao = new UtenteDAO();
		Utente utente = new Utente();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ruolo = request.getParameter("ruolo");
		
		logger.debug(username);
		logger.debug(password);
		logger.debug(ruolo);
		
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setRuolo(ruolo);
		
		boolean ret = dao.insert(utente);
		
		if(ret==true){
			logger.info("Insert eseguita");
		}
		else{
			logger.debug("Insert non eseguita");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request,response);
		
		
	}

}

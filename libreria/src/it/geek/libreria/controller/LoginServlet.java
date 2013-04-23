package it.geek.libreria.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import it.geek.libreria.model.Utente;
import it.geek.libreria.factory.ServiceFactory;
import it.geek.libreria.service.UtenteService;
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
			
		    
			Utente utente = (Utente)ServiceFactory.getUtenteService().get(nome);
			
			if(utente==null){
			
				request.setAttribute("Messaggio","Username sbagliato");
				RequestDispatcher rd = request.getRequestDispatcher("errore.jsp");
				rd.forward(request,response);
		
			}
			
			else if(!password.equals(utente.getPassword())){
			
				request.setAttribute("Messaggio", "Password sbagliato");
				RequestDispatcher rd = request.getRequestDispatcher("errore.jsp");
				rd.forward(request, response);
			
			}
			else{

				HttpSession session = request.getSession();
				session.setAttribute("Utente", utente);
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request,response);
				
				
			}
			
			
			
		    
			
			
	
	}

}

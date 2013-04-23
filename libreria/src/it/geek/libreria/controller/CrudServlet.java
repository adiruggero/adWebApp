package it.geek.libreria.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import it.geek.libreria.factory.ServiceFactory;
import it.geek.libreria.model.Ruolo;
import it.geek.libreria.model.Utente;
import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.DAO.impl.RuoloDAO;
import it.geek.libreria.DAO.impl.UtenteDAO;

public class CrudServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException,IOException{
		
		String operazione= request.getParameter("operazione");
		
		if(operazione.equals("inserisci")){
			
			List<Ruolo> lRuoli = ServiceFactory.getRuoloService().getAll();
			request.setAttribute("listaRuoli", lRuoli);
				
			RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request,response);
			
			
		}
		
		if(operazione.equals("cancella")){
			
			String username = request.getParameter("username");
			Utente utente = new Utente();
			utente.setUsername(username);
			ServiceFactory.getUtenteService().delete(utente);
			RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			rd.forward(request,response);

		}
		
		if(operazione.equals("modifica")){
			
				String username = request.getParameter("username");
				

				
				List<Ruolo> lRuoli = ServiceFactory.getRuoloService().getAll();
				
				
				
				request.setAttribute("Utente",username);
				request.setAttribute("listaRuoli",lRuoli);
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.forward(request,response);
		
			
		}
	
		if(operazione.equals("visualizza")){
				
			List<Utente> lUtenti = ServiceFactory.getUtenteService().getAll();
			request.setAttribute("listaUtenti",lUtenti);
			RequestDispatcher rd = request.getRequestDispatcher("visualizza.jsp");
			rd.forward(request,response);
			
		}
		
	}	
	
}

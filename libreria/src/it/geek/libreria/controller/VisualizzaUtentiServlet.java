package it.geek.libreria.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import it.geek.libreria.factory.ServiceFactory;
import it.geek.libreria.model.Utente;
import java.util.List;


public class VisualizzaUtentiServlet extends HttpServlet{
	
		
	public void doGet(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		List<Utente> lUtenti = ServiceFactory.getUtenteService().getAll();
		
		request.setAttribute("listaUtenti",lUtenti);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewAll.jsp");
		rd.forward(request,response);
		
		
	}
	
	
}

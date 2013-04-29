package it.geek.libreria.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;


import it.geek.libreria.factory.ServiceFactory;
import it.geek.libreria.model.Autore;

public class VisualizzaAutoriServlet extends HttpServlet {
	
		public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException,IOException{
			
			doPost(request,response);
			
		}
		
		public void doPost(HttpServletRequest request,HttpServletResponse response)
						throws ServletException,IOException{
			
			
			String cf = request.getParameter("cf");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			
			Autore aut = new Autore();
			aut.setCodiceFiscale(cf);
			aut.setNome(nome);
			aut.setCognome(cognome);
			
			List<Autore> lAutori = ServiceFactory.getAutoreService().getWhere(aut);
			
			request.setAttribute("listaAutori",lAutori);
			RequestDispatcher rd = request.getRequestDispatcher("listaAutori.jsp");	
			rd.forward(request,response);
			
			
		}
	


}

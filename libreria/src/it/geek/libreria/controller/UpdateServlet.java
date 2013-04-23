package it.geek.libreria.controller;

import java.io.IOException;

import it.geek.libreria.factory.ServiceFactory;
import it.geek.libreria.model.Ruolo;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.geek.libreria.model.Utente;

public class UpdateServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException,IOException{
		
		doPost(request,response);
	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException,IOException{
		
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ruolo  = request.getParameter("ruolo");
	

		Utente u = new Utente();
		u.setUsername(username);
		u.setPassword(password);
		u.setRuolo(ruolo);
		
		
		
		ServiceFactory.getUtenteService().update(u,id);
		List<Utente> lUtenti = ServiceFactory.getUtenteService().getAll();
		request.setAttribute("listaUtenti",lUtenti);
		request.setAttribute("Utente",username);
		RequestDispatcher rd = request.getRequestDispatcher("viewAll.jsp");
		rd.forward(request,response);
		
		

	}

}

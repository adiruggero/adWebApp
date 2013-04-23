package it.geek.libreria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import it.geek.libreria.factory.ServiceFactory;
import it.geek.libreria.model.Utente;

public class InsertServlet extends HttpServlet {
	

	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException,IOException{
		
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String ruolo = request.getParameter("ruolo");
		
		Utente utente = new Utente();
		
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setRuolo(ruolo);
		
		ServiceFactory.getUtenteService().insert(utente);
		List<Utente> lUtenti =ServiceFactory.getUtenteService().getAll();
		
		
		request.setAttribute("listaUtenti",lUtenti);
		RequestDispatcher rd = request.getRequestDispatcher("viewAll.jsp");
		rd.forward(request,response);
		
		
		
	}

}

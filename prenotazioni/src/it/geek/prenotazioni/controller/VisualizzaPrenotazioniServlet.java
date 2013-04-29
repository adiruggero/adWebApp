package it.geek.prenotazioni.controller;

import it.geek.prenotazioni.util.GenericDAO;
import it.geek.prenotazioni.model.Corso;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class VisualizzaPrenotazioniServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		String matricola = request.getParameter("matricola");
		GenericDAO dao = new GenericDAO();
		
		List<Corso> lCorsi = dao.findIdPrenotazioni(matricola);
		
		request.setAttribute("listaCorsi",lCorsi);
		RequestDispatcher rd = request.getRequestDispatcher("corsiPrenotati.jsp");
		rd.forward(request,response);
		
		
	}
}

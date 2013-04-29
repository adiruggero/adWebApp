package it.geek.prenotazioni.controller;

import it.geek.prenotazioni.util.GenericDAO;

import java.io.IOException;

import it.geek.prenotazioni.util.GenericDAO;
import it.geek.prenotazioni.model.Corso;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisualizzaCorsiServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		GenericDAO dao = new GenericDAO();
		
		List<Corso> lCorsi = dao.findAllCorsi();
		
		request.setAttribute("listaCorsi",lCorsi);
		RequestDispatcher rd = request.getRequestDispatcher("visualizzaCorsi.jsp");
		rd.forward(request,response);
		
	}

}

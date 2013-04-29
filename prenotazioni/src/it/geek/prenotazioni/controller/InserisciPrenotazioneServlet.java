package it.geek.prenotazioni.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.geek.prenotazioni.util.GenericDAO;

public class InserisciPrenotazioneServlet extends HttpServlet {
		
	public void doGet(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		String matricola = request.getParameter("matricola");
		int codiceCorso=Integer.parseInt(request.getParameter("id"));
		
		GenericDAO dao = new GenericDAO();
		
		boolean ret = dao.insertPrenotazione(matricola, codiceCorso);
		
		if(ret==true){
			
			RequestDispatcher rd = request.getRequestDispatcher("prenotazione.jsp");
			rd.forward(request,response);
			
		}
		else{
			
			RequestDispatcher rd = request.getRequestDispatcher("errorePrenotazione.jsp");
			rd.forward(request,response);
			
		}
		
	}
	
	
}

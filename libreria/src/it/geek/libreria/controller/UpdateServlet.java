package it.geek.libreria.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.geek.libreria.DAO.IDAO;
import it.geek.libreria.DAO.impl.UtenteDAO;
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
		String ruolo = request.getParameter("ruolo");
		
		IDAO dao = new UtenteDAO();
		Utente u = new Utente();
		
		u.setUsername(username);
		u.setPassword(password);
		u.setRuolo(ruolo);
		
		boolean ret = dao.update(u,id);
		
		if(ret==true){
			
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request,response);
		
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request,response);
		}

	}

}

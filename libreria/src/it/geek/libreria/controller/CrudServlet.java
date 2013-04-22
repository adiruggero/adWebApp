package it.geek.libreria.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import it.geek.libreria.model.Utente;
import it.geek.libreria.DAO.IDAO;
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
				
			RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
			rd.forward(request,response);
			
			
		}
		
		if(operazione.equals("cancella")){
			
			String username = request.getParameter("username");
			IDAO dao = new UtenteDAO();
			
			Utente u = new Utente();
			u.setUsername(username);
			
			boolean ret = dao.delete(u);
			
			if(ret == true){
				
				RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
				rd.forward(request,response);
			}
			else{
				
				RequestDispatcher rd = request.getRequestDispatcher("errore.jsp");
				rd.forward(request,response);
			}
		}
		
		if(operazione.equals("modifica")){
			
				String username = request.getParameter("username");
				
				request.setAttribute("Utente",username);
				
				RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.forward(request,response);
		
			
		}
	
	}
	
}

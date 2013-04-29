package it.geek.prenotazioni.controller;


import it.geek.prenotazioni.util.GenericDAO;
import it.geek.prenotazioni.model.Studente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;


import org.apache.log4j.Logger;


public class RiconoscimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private static Logger log = Logger.getLogger(RiconoscimentoServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricola = request.getParameter("matricola");
		
		GenericDAO dao = new GenericDAO();
		Studente studente = dao.findById(matricola);
		
		if(studente==null){
			
			RequestDispatcher rd = request.getRequestDispatcher("errore.jsp");
			rd.forward(request,response);
			
		}
		else{
			HttpSession session = request.getSession();
			session.setAttribute("studente", studente);
			RequestDispatcher rd = request.getRequestDispatcher("benvenuto.jsp");
			rd.forward(request,response);
		}
	}

}

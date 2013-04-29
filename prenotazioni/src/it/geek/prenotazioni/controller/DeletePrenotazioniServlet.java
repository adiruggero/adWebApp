package it.geek.prenotazioni.controller;
import it.geek.prenotazioni.model.Studente;
import java.io.IOException;
import java.util.Enumeration;
import it.geek.prenotazioni.util.GenericDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

public class DeletePrenotazioniServlet extends HttpServlet {
		
	public void doGet(HttpServletRequest request,HttpServletResponse response)
					throws ServletException,IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException,IOException{
		
		Enumeration<String> parametri=request.getParameterNames();
		GenericDAO dao = new GenericDAO();
		
		HttpSession session = request.getSession();
		Studente st =(Studente) session.getAttribute("studente");
		String matricola = st.getMatricola();
		
		
		
		String nomeParametro = null;
		while(parametri.hasMoreElements()){
			
			nomeParametro = parametri.nextElement();
			if(nomeParametro.contains("cancellaPrenotazione")){
				
				int valueCheck=Integer.parseInt(request.getParameter(nomeParametro));
				boolean ret = dao.delete(matricola, valueCheck);
				
			}
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("deletePrenotazioni.jsp");
		rd.forward(request,response);
	}
}


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="it.geek.prenotazioni.model.Studente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			Studente studente = (Studente)session.getAttribute("studente");
			if(studente == null){
				
				out.println("Attenzione:INTRUSIONE");
			}
			else{
				String matricola = studente.getMatricola();
				String nome = studente.getNome();
				String cognome = studente.getCognome();
			%>
			<h4>Sei loggato come <%=cognome%> <%=nome%> Se vuoi uscire <a href="Logout">clicca qui</a></h4>
		 <%} %>
			
			
	
		
		
		
		
</body>
</html>
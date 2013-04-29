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
		<jsp:include page="header.jsp"/>
		
			<% 
			String matricola = null;
			Studente st = (Studente)session.getAttribute("studente");
			if(st==null){
				
				matricola = "";
				
			}else{
				
				matricola = st.getMatricola();
			}
			
		
		%>
	
		Prenotazione effettuata con successo!
		
		Se vuoi visualizzare la lista delle prenotazioni <a href="VisualizzaPrenotazioni?matricola=<%=matricola %>">clicca qui</a>
		<br>
		Se vuoi prenotare un altri esame <a href="VisualizzaCorsi">clicca qui!</a>
		
		
</body>
</html>
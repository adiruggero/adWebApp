
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.geek.libreria.model.Utente" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		
		<jsp:include page="header.jsp"></jsp:include>
		
		<%
			Utente utente = (Utente)session.getAttribute("Utente");
			String ruolo = utente.getRuolo();
			if(ruolo.equals("Amministratore")){
				%>
				<center>
				<a href="viewAll">Visualizza Utenti</a>
				</center>
		<%	} %>
			
			<br><br><br>
			<center>
			
			<a href="visualizzaAutori.jsp">Visualizza Autori</a>
			
			</center>			
		
	</body>
</html>
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
		<%
		Utente utente = (Utente)session.getAttribute("Utente");
		String username = utente.getUsername();
		String password = utente.getPassword();
		String ruolo = utente.getRuolo();
		%>
		Username: <%=username%> Ruolo: <%=ruolo%> <a href="logout">Logout</a>
		
</body>
</html>
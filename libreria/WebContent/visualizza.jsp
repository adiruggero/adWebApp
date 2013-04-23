<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="it.geek.libreria.model.Utente" %>
<%@ page import="java.util.List" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		List<Utente> lUtenti =(List<Utente>) request.getAttribute("listaUtenti");
		%>
		<jsp:include page="header.jsp"></jsp:include>
		<h4><a href="viewAll">Torna alla lista</a></h4>
		<br><br><br>
		<table border="2" align="center">
			<tr>
				<td>Username</td><td>Password</td><td>Nome</td><td>Cognome</td><td>Ruolo</td>
			</tr>		
			<%for(int i=0;i<lUtenti.size();i++){ %>
				<tr>	
					<td><%=lUtenti.get(i).getUsername()%></td>
					<td><%=lUtenti.get(i).getPassword() %></td>
					<td><%=lUtenti.get(i).getNome() %></td>
					<td><%=lUtenti.get(i).getCognome() %></td>
					<td><%=lUtenti.get(i).getRuolo() %></td>
				</tr>
			<%} %>
		</table>
		
		
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import= "it.geek.libreria.model.Utente" %>
<%@ page import= "java.util.List" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<%
			List<Utente> lUtenti = (List) request.getAttribute("listUtenti");
			String ruolo = (String) session.getAttribute("ruolo");	
			
			%>
				
			
			<h2><%=ruolo%></h2>
			<table border="2" align="center">
			<H2><a href="crudServlet?operazione=inserisci">Inserisci un nuovo utente</a></H2>
				<tr>
					<td>username</td><td>password</td><td>ruolo</td>
				</tr>
				<%for(int i=0;i<lUtenti.size();i++){%>
					<tr>
						<td><%=lUtenti.get(i).getUsername() %></td>
						<td><%=lUtenti.get(i).getPassword() %></td>
						<td><%=lUtenti.get(i).getRuolo() %></td>
						<td><a href="crudServlet?operazione=cancella&username=<%=lUtenti.get(i).getUsername() %>">Cancella</a></td>
						<td><a href="crudServlet?operazione=modifica&username=<%=lUtenti.get(i).getUsername() %>">Modifica</a></td>
					</tr>
				<%} %>	
			</table>

</body>
</html>
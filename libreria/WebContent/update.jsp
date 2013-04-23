<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="it.geek.libreria.model.Ruolo" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<%
			String id =(String) request.getAttribute("Utente");
			List<Ruolo> lRuoli = (List<Ruolo>) request.getAttribute("listaRuoli");
			%> 
			<jsp:include page="header.jsp"></jsp:include>
			<h4><a href="viewAll">Torna alla lista</a></h4>
			<form method="GET" action="update">
			<table border="2" align="center">
			
					<tr>
						<td>Vecchio Username</td>
						<td><input type="text" name="id" value="<%=id %>" readonly></td>
					</tr>
					<tr>	
						<td>Username</td>
						<td><input type="text" name="username" size="25"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="password" size="25"></td>
					</tr>
					<tr>
						<td>Nome</td>
						<td><input type="text" name="nome" size="25"></td>
					</tr>
					<tr>
						<td>Cognome</td>
						<td><input type="text" name="cognome" size="25"></td>
					</tr>		
					<%if(lRuoli!=null){%>
							<tr>
							<td>Ruolo</td>
					
							<td>
							<select name="ruolo">
							<%for(int i=0;i<lRuoli.size();i++){ %>
									<% String nome = lRuoli.get(i).getTipoRuolo(); %>
									<option value="<%= nome %>"> <%= nome %> </option>
						
							  <%}%>
						  
					
						</select></td>
					</tr>
					
					<%}%>	
							
			
			</table>
			<input type="submit" value="modifica">
			</form>
</body>
</html>
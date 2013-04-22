<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<%
			String id =(String) request.getAttribute("Utente");
			%>
			<h3>Pagine modifica:<%= id %> </h3>
			<h4><a href="viewAll">Torna alla lista</a></h4>
			<form method="POST" action="update">
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
						<td>Ruolo</td>
						<td><input type="text" name="ruolo" size="25"></td>
					</tr>
					<input type="submit" value="modifica">		
			
			</table>
			</form>
</body>
</html>
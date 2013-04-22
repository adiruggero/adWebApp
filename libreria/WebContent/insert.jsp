<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	<%String ruolo =(String) session.getAttribute("ruolo"); %>
		<h3><%= ruolo %></h3>
		<form method="POST" action="insert">	
		<h2><a href="viewAll">Torna indietro</a></h2>
		<table border="" align="center">
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
				<input type="submit" value="Inserisci">
		
		</table>
		</form>
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.geek.libreria.model.Ruolo"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
		
<body>	
		<jsp:include page="header.jsp"></jsp:include>
		<%String ruolo =(String) session.getAttribute("ruolo");
		  List<Ruolo> lRuoli = (List<Ruolo>) request.getAttribute("listaRuoli");
		%>
		<form method="POST" action="insert">	
		<h4><a href="viewAll">Torna alla lista</a></h4>
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
				<td>Nome</td>
				<td><input type="text" name="nome" size="25"></td>
			</tr>
 			<tr>
 				<td>Cognome</td>
 				<td><input type="text" name="cognome" size="25"></td>
			</tr>
			<%if(lRuoli!=null){ %>
			<tr>
				<td>Ruolo</td>
				<td>
					<select name="ruolo">
						<%for(int i=0;i<lRuoli.size();i++){ %>
							<%String nomeRuolo=lRuoli.get(i).getTipoRuolo(); %>
							<option value="<%=nomeRuolo%>"><%=nomeRuolo %></option>
						<%} %>
					</select>
				</td>		
			</tr>
			<%} %>	
				
		</table>
		<input type="submit" value="Inserisci">
		</form>
		
</body>
</html>
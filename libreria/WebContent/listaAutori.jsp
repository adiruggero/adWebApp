<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="it.geek.libreria.model.Autore" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
			List<Autore> lAutori =(List<Autore>) request.getAttribute("listaAutori");
		%>
		<jsp:include page="header.jsp"/>
		
		<form name="tableForm" method="POST" action="">
			
			
				<table border="" align="center">
				
					<tr>
						<td>Opzione</td>
						<td>Codice fiscale</td>
						<td>Nome</td>
						<td>Cognome</td>	
					</tr>
					<select name="radioAutori">
					<%for(int i=0;i<lAutori.size();i++){ %>
						<tr>	
							<td><input type="radio" name="selected" value="<%=lAutori.get(i).getCodiceFiscale()%>"/></td>
							<td><%=lAutori.get(i).getCodiceFiscale() %></td>
							<td><%=lAutori.get(i).getNome() %> </td>
							<td><%=lAutori.get(i).getCognome() %></td>
							
						</tr>
					<%}%>	
					</select>
					<tr>
						<td colspan="4"><input type="submit" value="cerca libri"/></td>
						
					</tr>
				</table>
		</form>
		
</body>
</html>
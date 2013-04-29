<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.geek.prenotazioni.model.Corso" %>
<%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page="header.jsp"/>
		<%	
			List<Corso> lCorsi = (List<Corso>) request.getAttribute("listaCorsi");
		%>
		
		<form method="POST" action="DeletePrenotazioni">
			
			<table border="2" align="center">
				
				<tr>
					<td>Opzione</td>
					<td>Id</td>
					<td>Materia</td>
				</tr>
				<%for(int i=0;i<lCorsi.size();i++){ %>
				<tr>
					<td><input type="checkbox" name="cancellaPrenotazione<%=i%>" value="<%=lCorsi.get(i).getCodiceCorso() %>"/></td>
					<td><%=lCorsi.get(i).getCodiceCorso() %></td>
					<td><%=lCorsi.get(i).getNomeCorso() %></td>				
				<%}%>
				<tr>
					<td><input type="submit" value="Elimina prenotazioni"/></td>
				</tr>
			</table>
		
		</form>
		
		
		
</body>
</html>
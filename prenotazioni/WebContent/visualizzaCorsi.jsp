<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.geek.prenotazioni.model.Corso" %>
<%@ page import="java.util.List"%>    
<%@ page import="it.geek.prenotazioni.model.Studente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<jsp:include page="header.jsp"/>

		<% 
			String matricola = null;
			List<Corso> lCorsi = (List<Corso>) request.getAttribute("listaCorsi");
			Studente st = (Studente)session.getAttribute("studente");
			if(st==null){
				
				matricola = "";
				
			}else{
				
				matricola = st.getMatricola();
			}
			
		
		%>
	
				
		
		<table border="2" align="center">
					
				<tr>
					<td>Id corso</td>
					<td>Materia</td>
				</tr>
				<%for(int i=0;i<lCorsi.size();i++){ %>
				<tr>
					<td><%=lCorsi.get(i).getCodiceCorso()%></td>
					<td><%=lCorsi.get(i).getNomeCorso() %></td>
					<td><a href="Prenota?id=<%=lCorsi.get(i).getCodiceCorso()%>&matricola=<%=matricola%>">Prenota</a>
				</tr>
				<%} %>
		</table>
		
</body>
</html>
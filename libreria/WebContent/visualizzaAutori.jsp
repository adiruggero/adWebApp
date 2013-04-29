<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			
			<jsp:include page="header.jsp"/>
		
				
				<form name="foundForm" method="POST" action="viewAutori">
					 
					 <table align="center">
					 	
					 	<tr>
					 	<td>Inserisci codice fiscale</td>
					 	<td><input type="text" name="cf"/></td>
					 	</tr>
					 	<tr>
					 	<td>Inserisci nome</td>
					 	<td><input type="text" name="nome"/></td>
					 	</tr>
					 	<tr>
					 	<td>Inserisci cognome</td>
					 	<td><input type="text" name="cognome"/></td>
					 	</tr>
						<tr>
						<td colspan="2"><input type="submit" value="Trova"/> </td>
						</tr>	
					 </table>
				</form>	
			
			
			
						
			
</body>
</html>
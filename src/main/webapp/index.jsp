<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,model.*,service.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Datos</title>
</head>
<body>
<form method="post" action="Insertar">
	<table width="40%" align="center">
		<tr>
			<td colspan="2" align="center"><h2>Escriba su pais</h2><hr></td>
		</tr>
		<tr>
			<td><p>Pais:</p></td>
			<td><input type="text" id="pais" name="pais" size="30"></td>
		</tr>
		
		<tr>
			<td><p>Idioma:</p></td>
			<td>
				<select name="Idioma" id="Idioma">
					<%  
						Service service = new Service();
						List<Idiomas> listAllLanguages = service.listAllLanguages(); 
						for (Idiomas language: listAllLanguages){
						   out.println("<option value ='"+language.getLanguage()+"'>"+language.getLanguage()+"</option>");
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td><p>Insertar nuevo Idioma:</p></td>
			<td><input type="text" id="nuevoIdioma" name="nuevoIdioma" size="30"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="Enviar"></td>
		</tr>
		<tr>
			<td colspan="2" align="left"><input type="button" onclick="window.location.href='Mostrar.jsp'"  value="Mostrar Paises"></td>
		</tr>
	</table>
</form>
</body>
</html>
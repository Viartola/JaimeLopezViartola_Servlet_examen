<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5;url=Paises.jsp" />
<title>Insert title here</title>
</head>
<body>
<center><h1>EL REGISTRO VA HA SER ELIMINADO</h1>
<form method="post" action="Hola">
		<input type="hidden" value="${id}" name="user">
		<br>
		<input type="submit"  value="SI, estoy seguro">
		<input type="button" onclick="window.location.href='Paises.jsp'"  value="NO, quiero eliminarlo">
	</form>	
</center>
</body>
</html>
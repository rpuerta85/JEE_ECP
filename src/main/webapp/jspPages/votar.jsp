<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>VotarView</title>
</head>
<body>
	<h2>
		Vista de <b>Votar</b>
	</h2>
	
		
	<!-- <c:set var="pView" scope="request" value="${persona}" /> -->
	<!-- <div>${pView.update()}</div> -->
	<form action="/votar/v1/persona" method="post">
		<!-- <p>
			Id: <input name="id" type="text" value="${pView.persona.id}" />
		</p>
		<p>
			Nombre: <input name="nombre" type="text"
				value="${pView.persona.nombre}" />${pView.errorMsg}</p>
		<p> -->
			
			<c:set var="pView" scope="request" value="${votar}" />
			Seleccione Tema: <select name="temas">
				<option value="0">Seleccione</option>
				<c:forEach var="tema" items="${pView.listaTemas}">
					<option value="${tema.id}">${tema.tema}</option>
				</c:forEach>
			</select>
		AQUI UN TEXT AREA EN EL QUE SE MUESTRA LA PREGUNTA EN FUNCION DE LA OPCION ESCOGIDA. Esto hacerlo por jquery
		<p>
			<input type="submit" value="Seleccionar" />
		</p>
	</form>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/home">Volver al Home</a>
	</p>
</body>
</html>

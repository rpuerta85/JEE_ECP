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
	<c:set var="pView" scope="request" value="${votar}" />
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
			Temas: <select name="tema">
				<c:forEach var="tema" items="${pView.listaTemas}">
					<option value="${tema.id}">${tema.tema}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/Web/v1/home">Volver a Home</a>
	</p>
</body>
</html>

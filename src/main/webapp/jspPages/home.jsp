<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Seleccione acción</title>
</head>
<body>
	<h1>Seleccione acción</h1>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/votar">Votar</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/votar/verVotaciones">Ver votaciones</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/tema/aniadirTema">Añadir tema</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/tema/delete">Eliminar tema</a>
	</p>
</body>
</html>

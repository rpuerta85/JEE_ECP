<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/eventos.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/funciones.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/funciones.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
<title>VotarView</title>
<script type="text/javascript">
$(function() {
	onLoad2();
	
});//ready jquery

</script>
</head>
<body>
	<h2>
		Vista de <b>Votar</b>
	</h2>
 <div style="width: 50%;padding-left: 20%;">
	<form action="/votar/v1/persona" method="post">
			<table class="fac_contenidoTabla">
					<thead>
							<tr>
								<td class="filaSeccion" colspan="4" rowspan="1">VOTAR</td>
							</tr>
					</thead>
					<tbody id="cntLineasDetalles">		
						
					</tbody>
							<tr>
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Seleccione Tema </td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   			<c:set var="pView" scope="request" value="${votar}" />
											 <select name="temas" class="InputForm">
												<option value="0">Seleccione</option>
												<c:forEach var="tema" items="${pView.listaTemas}">
													<option value="${tema.id}">${tema.tema}</option>
												</c:forEach>
											</select>
								</td>
						</tr>
						<tr>
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Seleccione Nivel de Estudios:</td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   			<select name="estudios" class="InputForm">
																	<option value="0">Seleccione</option>
																	<c:forEach var="estudio" items="${pView.listaNivelEstudios}">
																		<option value="${estudio}">${estudio}</option>
																	</c:forEach>
																</select>
							   		
							   		
							   </td>
						</tr>
						<tr>
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Asigne puntuación </td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   			<c:set var="pView" scope="request" value="${votar}" />
											 <select name="temas" class="InputForm">
												<option value="0">Seleccione</option>
												<c:forEach var="tema" items="${pView.listaTemas}">
													<option value="${tema.id}">${tema.tema}</option>
												</c:forEach>
											</select>
							   		
							   		
							   </td>
						</tr>
						
		</table>
		<p>
			<input type="submit" value="Seleccionar" />
		</p>
	</form>
</div>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/home">Volver al Home</a>
	</p>
</body>
</html>

<?xml version="1.0" encoding="UTF-8"  ?>
<%@page import="com.google.gson.Gson"%>
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
	


});//ready jquery

</script>
</head>
<body>
	<h2>
		Vista de <b>Votos</b>
	</h2>
	 <div id="trCargando" class="divCarga2" align="center">
          <span  id="mensajeCarga" class="fuente1" style="margin-top: 10%;display: block;">
	      </span>
   </div>  
	
 <div style="width: 50%;padding-left: 20%;">
	
		<table class="fac_contenidoTabla">
			<thead>
					<tr>
						<td class="filaSeccion" colspan="4" rowspan="1">VOTACIÓN MEDIA POR NIVEL DE ESTUDIOS</td>
					</tr>
				    <tr>
						<td class="filaSeccion" colspan="2" >Nivel de Estudios</td>
						<td class="filaSeccion" colspan="2" >Puntuación Media</td>
				   </tr>
					
			</thead>
			<!-- Recorremos el mapa de estudios, cada estudio tiene un objeto ListaVotosAsociados a un estudio conlos valores calculados -->
			<tbody>
				<c:set var="pView" scope="request" value="${verVotaciones}" />
				<c:forEach var="mapVotosPorEstudio" items="${pView.mapVotacionMediaSegunNivelEstudios}">
	   				 <tr>
						  <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> ${mapVotosPorEstudio.key}</td>
						  <td colspan="2" class="celdaInteractuableFormFacturacion" style="text-align: center;">
							   	    <LABEL> ${mapVotosPorEstudio.value.votacionMediaActual} </LABEL>			   								   		
						  </td>
					</tr>
				</c:forEach>			
		  </tbody>
		</table>
		<br>
		<br>
		<br>
		<table class="fac_contenidoTabla">
			<thead>
					<tr>
						<td class="filaSeccion" colspan="4" rowspan="1">NÚMERO DE VOTOS POR TEMA</td>
					</tr>
				    <tr>
						<td class="filaSeccion" colspan="2" >Tema</td>
						<td class="filaSeccion" colspan="2" >Número de Votos</td>
				   </tr>
			</thead>
			<tbody>
				<c:forEach var="listaTemas" items="${pView.listaTemas}">
	   				 <tr>
						  <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> ${listaTemas.tema}</td>
						  <td colspan="2" class="celdaInteractuableFormFacturacion" style="text-align: center;">
							   	    <LABEL>${listaTemas.votos.size()} </LABEL>			   								   		
						  </td>
					</tr>
				</c:forEach>			
		  </tbody>
		</table>		
	
</div>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/home">Volver al Home</a>
	</p>
</body>
</html>

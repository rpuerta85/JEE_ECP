<?xml version="1.0" encoding="UTF-8"  ?>
<%@page import="es.miw.jeeecp.view.web.beans.VotarView"%>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
<title>VotarView</title>
<script type="text/javascript">
$(function() {
});//ready jquery

</script>
</head>
<body>
	${eliminarTema.update()}
	<h2>
		Vista de <b>Eliminar Tema</b>
	</h2>
	
	 <div id="trCargando" class="divCarga2" align="center">
          <span  id="mensajeCarga" class="fuente1" style="margin-top: 10%;display: block;">
	      </span>
   </div>  
	
	
	 <div style="width: 50%;padding-left: 20%;">
	
		<table class="fac_contenidoTabla">
			<thead>
					<tr>
						<td class="filaSeccion" colspan="7" rowspan="1">ELIMINAR TEMA</td>
					</tr>
				    <tr>
						<td class="filaSeccion" colspan="2" >Tema</td>
						<td class="filaSeccion" colspan="3" >Pregunta</td>
						<td class="filaSeccion" colspan="1" >Número de Votos</td>
						<td class="filaSeccion" colspan="1" >Acción</td>
				   </tr>
					
			</thead>
			<!-- Recorremos el conjunto de temas -->
			<tbody>
				<c:set var="pView" scope="request" value="${eliminarTema}" />
				<c:forEach var="tema" items="${pView.listaTemas}">
	   				 <tr id="filaTema${tema.id}">
						  <td colspan="2" class="fuente3 celdaInformativoFormFacturacion" style="text-align: center;"> ${tema.tema}</td>
						  <td colspan="3" class="celdaInteractuableFormFacturacion" style="text-align: left: ;">
							   	    <LABEL> ${tema.pregunta} </LABEL>			   								   		
						  </td>
						    <td colspan="1" class="celdaInteractuableFormFacturacion" style="text-align: center;">
							   	    <LABEL> ${tema.votos.size()} </LABEL>			   								   		
						  </td>
						  <td style="text-align: center;">
						      <input id="btnEliminarTema${tema.id}"  type="button" value="Eliminar" onclick="eliminarTemaAjax('${tema.id}');">
					      </td>
					</tr>
				</c:forEach>			
		  </tbody>
		</table>
		<br>
		<br>
		<br>
		
</div>

	<p>
		<a href="${pageContext.request.contextPath}/jsp/home">Volver al Home</a>
	</p>
</body>
</html>

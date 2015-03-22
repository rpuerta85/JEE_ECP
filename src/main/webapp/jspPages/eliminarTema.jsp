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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/funciones.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
<title>VotarView</title>
<script type="text/javascript">
$(function() {
	/*onLoadEliminarTema();
	$("#temas").on("change", function(){
		var json = ${votar.toJsonString()}; 
		var obj = JSON.parse(JSON.stringify(json));
	    var arrayPreguntas = obj.listaTemas;
	   
	    var value = $(this).val();
		switch (value) {
			case '0': {				
				ocultarSelect($("#filaNivelEstudios"));
				ocultarSelect($("#puntuacion"));
				ocultarSelect($("#filaPregunta"));
				break;
			}
			default : {
				mostrarSelect($("#filaNivelEstudios"));
				var index =  buscarIndiceTemaPorId(value,arrayPreguntas);
				actualizarLabelPregunta(index,arrayPreguntas);
				break;
			}
		}
		
		
	});*/


});//ready jquery

</script>
</head>
<body>
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
						<td class="filaSeccion" colspan="4" rowspan="1">ELIMINAR TEMA</td>
					</tr>
				    <tr>
						<td class="filaSeccion" colspan="2" >Tema</td>
						<td class="filaSeccion" colspan="2" >Pregunta</td>
				   </tr>
					
			</thead>
			<!-- Recorremos el conjunto de temas -->
			<tbody>
				<c:set var="pView" scope="request" value="${eliminarTema}" />
				<c:forEach var="mapVotosPorEstudio" items="${pView.listaTemas}">
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 <div style="width: 50%;padding-left: 20%;">
	<form action="/votar/v1/persona" method="post">
			<table class="fac_contenidoTabla">
					<thead>
							<tr>
								<td class="filaSeccion" colspan="4" rowspan="1">ELIMINAR TEMA</td>
							</tr>
					</thead>
					<tbody id="cntLineasDetalles">		
						
					</tbody>
							<tr>
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Seleccione Tema a eliminar</td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   			<c:set var="pView" scope="request" value="${votar}" />
											 <select id="temas" name="temas" class="InputForm">
												<option value="0">Seleccione</option>
												<c:forEach var="tema" items="${pView.listaTemas}">
													<option value="${tema.id}">${tema.tema}</option>
												</c:forEach>
											</select>
								</td>
						</tr>
						<tr id="filaNivelEstudios">
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Seleccione Nivel de Estudios:</td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   			<select id="estudios" name="estudios" class="InputForm">
																	<option value="0">Seleccione</option>
																	<c:forEach var="estudio" items="${pView.listaNivelEstudios}">
																		<option value="${estudio}">${estudio}</option>
																	</c:forEach>
																</select>
							   		
							   		
							   </td>
						</tr>
						<tr id="filaPregunta">
							  <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Seleccione Nivel de Estudios:</td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   	    <LABEL id="labelPregunta">pppp</LABEL>			   								   		
							   </td>
						</tr>
						<tr id="puntuacion">
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Asigne puntuación </td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   			
											 <select id="notas" name="notas" class="InputForm">
												<option value="0">Seleccione</option>
												<c:forEach var="nota" items="${pView.listaNotas}">
													<option value="${nota}">${nota}</option>
												</c:forEach>
											</select>
							   	<p>
									<!-- <input type="submit" value="E" /> -->
									<input id="btnEnviarVoto"  type="button" value="Enviar voto">
								</p>
							   		
							   </td>
						</tr>
						<tr id="trError" class="trError">
						
						</tr>
						
		</table>
		
	</form>
</div>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/home">Volver al Home</a>
	</p>
</body>
</html>

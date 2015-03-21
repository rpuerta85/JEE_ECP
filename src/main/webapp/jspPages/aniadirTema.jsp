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
	onLoadAniadirTema();
	/*$("#temas").on("change", function(){
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
				actualizarLabelPregunta(value-1,arrayPreguntas);
				break;
			}
		}
		
		
	});*/


});//ready jquery

</script>
</head>
<body>
	<h2>
		Vista de <b>Añadir Tema</b>
	</h2>
	 <div id="trCargando" class="divCarga2" align="center">
          <span  id="mensajeCarga" class="fuente1" style="margin-top: 10%;display: block;">
	      </span>
   </div>  
	
 <div style="width: 50%;padding-left: 20%;">
	<form  method="post">
			<table class="fac_contenidoTabla">
					<thead>
							<tr>
								<td class="filaSeccion" colspan="4" rowspan="1">AÑADIR TEMA</td>
							</tr>
					</thead>
					<tfoot>
						<tr id="trError" class="trError">
							
						</tr>
					</tfoot>
					<tbody id="cntLineasDetalles">		
						<tr>
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Nombre del Tema: </td>
							  <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   		<input id="nombreTema"  class="inputForm Input" type="text" name="nombreTema" required="required" placeholder="nombre del tema">
							  </td>
						</tr>
						<tr>
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Pregunta:</td>
							   <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   		<input id="pregunta"  class="inputForm Input" type="text" name="pregunta" required="required" placeholder="pregunta">
							   </td>
						</tr>
						<tr>
							<td colspan="4" style="text-align: center;">
							     <input id="btnAniadirTema"  type="button" value="Enviar voto">
							</td>
						</tr>
					</tbody>
						
		</table>
		
	</form>
</div>
	<p>
		<a href="${pageContext.request.contextPath}/jsp/home">Volver al Home</a>
	</p>
</body>
</html>

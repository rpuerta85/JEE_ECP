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
		Vista de <b>Eliminar Tema</b>
	</h2>
	 <div id="trCargando" class="divCarga2" align="center">
          <span  id="mensajeCarga" class="fuente1" style="margin-top: 10%;display: block;">
	      </span>
   </div>  
	
 <div style="width: 50%;padding-left: 20%;">
	<form  action = "${pageContext.request.contextPath}/jsp/tema/autorizacion"  method="post">
			<table class="fac_contenidoTabla">
					<thead>
							<tr>
								<td class="filaSeccion" colspan="4" rowspan="1">AUTORIZACIÓN PARA ELIMINAR TEMA</td>
							</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="4" style="text-align: center;">
							     <input type="submit" value="Enviar" />
							</td>	
						</tr>
						<tr id="trError" class="trError" style="background-color: transparent;">
							<td>${autorizacion.msg}</td>
						</tr>
						
					</tfoot>
					<tbody id="cntLineasDetalles">		
						<tr>
							   <td colspan="2" class="fuente3 celdaInformativoFormFacturacion"> Identificador de autorización: </td>
							  <td colspan="2" class="celdaInteractuableFormFacturacion" >
							   		<input id="codAutorizacion"  class="inputForm Input" type="text" name="codAutorizacion" required="required" placeholder="introduzca código de autorización">
							   
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

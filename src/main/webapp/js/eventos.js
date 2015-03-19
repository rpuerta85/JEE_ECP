function cargarEventoMostrarFilaEstudios(){
//	$("#temas").on("change", function(){
//		var value = $(this).val();
//		switch (value) {
//			case '0': {				
//				ocultarSelect($("#filaNivelEstudios"));
//				ocultarSelect($("#puntuacion"));
//				ocultarSelect($("#filaPregunta"));
//				break;
//			}
//			default : {
//				
//				
//				mostrarSelect($("#filaNivelEstudios"));
//				actualizarLabelPregunta(value);
//				break;
//			}
//		}
//		
//	
//	});
}


function carcarEventoEnviarVoto(){
	$("#btnEnviarVoto").on("click", function(){
		if(	validarAccionEnviarVoto()) {
			enviarVotoAjax();
		}
		
	});
	
}
function actualizarLabelPregunta(indexPregunta,arrayPreguntas){
	//alert(JSON.stringify(arrayPreguntas[indexPregunta]));
	$("#labelPregunta").text(arrayPreguntas[indexPregunta].pregunta);
	
}

function cargarEventoMostrarFilaNotas(){
	$("#estudios").on("change", function(){
		var value = $(this).val();
		switch (value) {
			case '0': {				
				ocultarSelect($("#puntuacion"));
				ocultarSelect($("#filaPregunta"));
				break;
			}
			default : {
				mostrarSelect($("#filaPregunta"));
				mostrarSelect($("#puntuacion"));
				
				break;
			}
		}
		
		
	});
}









//
//
//function cargarEventoRadioModoMarcacion(){
//	$('input:radio[name="radioModoRecepcionCarne"]').on("change", function(){
//		var id = $(this).attr("id");
//		switch (id) {
//			case 'radioModoRecepcionCarne_Ordinario': {				
//				  mostrarCapaCorreoOrdinario();
//				 
//				
//				break;
//			}
//			case 'radioModoRecepcionCarne_Electronico': {
//				mostrarCapaCorreoElectronico();
//				break;
//			}
//			default : {
//				alert( "Error: No existe el id:"+id);
//				break;
//			}
//		}
//		
//		
//	});
//}
//
//function cargarEventoBotonCancelar(){
//	$("#btnCancelarCorreo").on("click", function(){
//		$("#cntCapasAux").addClass("displayNone");
//		$("#cntCorreoOrdinario").addClass("displayNone");
//		$("#cntCorreoElectronico").addClass("displayNone");
//		 ocultarTextoError($("#trError"));
//	});
//}
//
//function cargarEventoBotonGuardar(){
//	$("#btnGuardarCorreo").on("click", function(){
//		if($('input[name=radioModoRecepcionCarne]:radio:checked').attr("id")=='radioModoRecepcionCarne_Ordinario'){
//			btnGuardarCorreoOrdinarioPulsado();
//		}
//		else if ($('input[name=radioModoRecepcionCarne]:radio:checked').attr("id")=='radioModoRecepcionCarne_Electronico') {
//			btnGuardarCorreoElectronicoPulsado();
//		}
//		
//		
//	});
//	
//}
//
//function btnGuardarCorreoOrdinarioPulsado(){
//		if (validarCamposCorreoOrdinario()) {
//			$("#cntCapasAux").addClass("displayNone");
//			$("#cntCorreoOrdinario").addClass("displayNone");
//			$("#cntCorreoElectronico").addClass("displayNone");
//			var html = crearContenidoCapaCorreoOrdinario();
//			$("#filaCorreo").empty();
//			$("#filaCorreo").append(html);
//			$("#direccion").val($("#direccionAux").val());
//			$("#localidad").val($("#localidadAux").val());
//			ocultarTextoError($("#trError"));
//			cargarEventoOnClickCorreo();
//			
//		} 
//}
//
//function btnGuardarCorreoElectronicoPulsado(){
//	
//		if (validarDireccionCorreoElectronico($("#correoElectronicoAux"))) {
//			$("#cntCapasAux").addClass("displayNone");
//			$("#cntCorreoOrdinario").addClass("displayNone");
//			$("#cntCorreoElectronico").addClass("displayNone");
//			var html = crearContenidoCapaCorreoElectronico();
//			$("#filaCorreo").empty();
//			$("#filaCorreo").append(html);
//			$("#correoElectronico").val($("#correoElectronicoAux").val());
//			ocultarTextoError($("#trError"));
//			cargarEventoOnClickCorreo();
//			
//		} else {
//			mostrarTextoError($("#trError"), "Error: formato de email erróneo");
//		}
//}
//
//function cargarEventoOnClickCorreo(){
//	$("#correoElectronico").on("click",function(){
//		mostrarCapaCorreoElectronico();
//	});
//	
//	$("#direccion,#localidad").on("click",function(){
//		mostrarCapaCorreoOrdinario();
//	});
//	
//	
//}
//
//function cargarEventoOnBlurAlIntroducirCodigoPostal(){
//	$("#codigoPostal").blur(function () {
//
//		var param = $("#codigoPostal").val();
//		$.ajax({ 
//			type: "POST", 
//	        url:"http://www.eui.upm.es/~salonso/master/provincia.php", 
//	        dataType: "jsonp",
//	        crossDomain:true,
//	        data:{CP:param},
//	        success: function(datos){      
//	            //alert(datos);
//	            $("#provincia").val(datos);
//	        }
//			
//			
//		});
//	});
//}
//
//function cargarEventoOnBlurAlIntroducirDNI(){
//	$("#dni").blur(function () {
//		if(validarDNI()) {
//			ocultarTextoError($("#trError2"));
//		}
//		
//	});
//	
//	
//}
//
//function cargarEventoOnChangeEnRangoTamanioLetra(){
//	$("#rangoFuente").on("mousemove",function(){
//		//var tamanioDefecto = 10; //alert($(this).val());
//		//alert(parseInt($(this).val()));
//		//alert(parseInt($(this).val())*2);
//		$("html").css("fontSize",parseInt($(this).val())+"px");
//		$(".fuente3").css("fontSize",parseInt($(this).val())+"px");
//		//alert('aaaa');
//	});
//}


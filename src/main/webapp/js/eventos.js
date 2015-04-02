function carcarEventoEnviarVoto(){
	$("#btnEnviarVoto").on("click", function(){
		if(	validarAccionEnviarVoto()) {
			enviarVotoAjax();
		}
		
	});
	
}
function cargarEventoAniadirTema(){
	$("#btnAniadirTema").on("click", function(){
		if(	validarAccionAniadirTemaVoto()) {
			aniadirTemaAjax();
		}
		
	});
	
}

function actualizarLabelPregunta(indexPregunta,arrayPreguntas){
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



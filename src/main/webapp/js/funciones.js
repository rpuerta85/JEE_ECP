function mostrarSelect($select){
	$select.show();
}
function ocultarSelect($select){
	$select.hide();
}

function temaEntity(id,tema,pregunta){
	this.id = id;
	this.tema = tema;
	this.pregunta = pregunta;
	
}
function votoEntity(id,ip,nota,estudios) {
	this.id = id;
	this.ip = ip;
	this.nota = nota;
	this.estudios = estudios;
}
function eliminarTemaAjax(idTema){
	var ajaxParam = {
	 		url: '/EE_ECP/jsp/tema/eliminarTema',
	 		global: false,
	 		type: "POST",
	 		//dataType:'json',//tipo de dato devuelto
	 		data: "idTema="+idTema,
	 		scriptCharset: "UTF-8",
	 		async: true,
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
	 		//contentType:'application/json',
	 	    //contentType : 'application/x-www-form-urlencoded; charset=UTF-8'
	 		//mineType:'application/json'
			beforeSend:function(xhr) {
				mostrarPantallaDeCarga($("#trCargando"),"Cargando...");
	    	},
			complete:function() {
				ocultarPantallaDeCarga($("#trCargando"));
			}    

	        };

		$.ajax(ajaxParam)
		.success(function(data) { 
			var json = JSON.parse(data);
			alert(json.msg);
			if(json.exito==true) {
				borrarTemaTabla(idTema);
				
			} 
			
			
		})
		
		    
		.fail(function(){
		    alert("fail");
		    ocultarPantallaDeCarga($("#trCargando"));
		});



	}
function borrarTemaTabla(idTema){
	$("#filaTema"+idTema).remove();
}
function aniadirTemaAjax(){
	var tema = new temaEntity(null, $("#nombreTema").val(), $("#pregunta").val());

	var ajaxParam = {
	 		url: '/EE_ECP/jsp/tema/aniadirTema',
	 		global: false,
	 		type: "POST",
	 		//dataType:'json',//tipo de dato devuelto
	 		data: "tema="+JSON.stringify(tema),
	 		scriptCharset: "UTF-8",
	 		async: true,
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
	 		//contentType:'application/json',
	 	    //contentType : 'application/x-www-form-urlencoded; charset=UTF-8'
	 		//mineType:'application/json'
			beforeSend:function(xhr) {
				mostrarPantallaDeCarga($("#trCargando"),"Cargando...");
	    	},
			complete:function() {
				ocultarPantallaDeCarga($("#trCargando"));
			}    

	        };

		$.ajax(ajaxParam)
		.success(function(data) { 
			var json = JSON.parse(data);
			alert(json.msg);
			if(json.exito==true) {
				location.href ="/EE_ECP/jsp/home";
			} 
			
			
		})
		
		    
		.fail(function(){
		    alert("fail");
		});



	}
function enviarVotoAjax(){
	var tema = new temaEntity($("#temas option:selected").val(), $("#temas option:selected").html(), $("#labelPregunta").text());
	var voto = new votoEntity(null, null, $("#notas option:selected").html(), $("#estudios option:selected").html());	

	var ajaxParam = {
	 		url: '/EE_ECP/jsp/votar/add',
	 		global: false,
	 		type: "POST",
	 		//dataType:'json',//tipo de dato devuelto
	 		data: "tema="+JSON.stringify(tema)+"&"+"voto="+JSON.stringify(voto),
	 		scriptCharset: "UTF-8",
	 		async: true,
			contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
	 		//contentType:'application/json',
	 	    //contentType : 'application/x-www-form-urlencoded; charset=UTF-8'
	 		//mineType:'application/json'
			beforeSend:function(xhr) {
				mostrarPantallaDeCarga($("#trCargando"),"Cargando...");
	    	},
			complete:function() {
				ocultarPantallaDeCarga($("#trCargando"));
			}    

	        };

		$.ajax(ajaxParam)
		.success(function(data) { 
			var json = JSON.parse(data);
			alert(json.msg);
			if(json.exito==true) {
				location.href ="/EE_ECP/jsp/home";
			} 
			
			
		})
		
		    
		.fail(function(){
		    alert("fail");
		});



	}

function validarAccionEnviarVoto(){
	var valido = false;
	var cadena = "Los siguientes campos no tienen el formato correcto: ";
	var campo = "";
	
	if($("#temas option:selected").val() !=0 && $("#estudios option:selected").val() !=0 
			&& $("#notas option:selected").val()!=0) {
		valido = true;
	}else {
			if($("#temas option:selected").val() ==0) {
				$("#temas").addClass("inputFondoError");
				campo += campo == "" ? "Tema" : ", tema";
				
			}
			if($("#estudios option:selected").val() ==0) {
				$("#estudios").addClass("inputFondoError");
				campo += campo == "" ? "Estudios" : ", estudios";
				
			}
			if($("#notas option:selected").val() ==0) {
				$("#notas").addClass("inputFondoError");
				campo += campo == "" ? "Notas" : ", notas";
			}
	}
	
	if(campo != ""){
		mostrarTextoError($("#trError"), cadena+campo);
	}else{
		ocultarTextoError($("#trError"));
	}

 return valido;
}	
function validarAccionAniadirTemaVoto(){
	var valido = false;
	var cadena = "Los siguientes campos no se encuentran rellenos: ";
	var campo = "";
	
	if($("#nombreTema").val() !="" && $("#pregunta").val() != "") {
		valido = true;
	}else {
		if($("#nombreTema").val() =="") {
			$("#nombreTema").addClass("inputFondoError");
			campo += campo == "" ? "Tema" : ", tema";
			
		}
		if($("#pregunta").val() =="") {
			$("#pregunta").addClass("inputFondoError");
			campo += campo == "" ? "Pregunta" : ", pregunta";
			
		}
	
	}
	
	if(campo != ""){
		mostrarTextoError($("#trError"), cadena+campo);
	}else{
		ocultarTextoError($("#trError"));
	}

 return valido;
}	



/*Funciom que muestra una pantalla de Carga, en el div selector que le pasemos por parametro*/
function mostrarPantallaDeCarga($selectDivCarga,mensaje){
	$overlay = $('<div id="overlayLoading2" class="gen_fondo"></div>');
	$overlay.appendTo("body");
	
	mostrarSelector($selectDivCarga);
	$selectDivCarga.find('img').each(function() {
		$(this).remove();
	 });
	//$("#myDiv").find("img")
	$selectDivCarga.append('<img src=\"/EE_ECP/images/ajax-loader.gif\" alt=\"\" class="gifCargando"></img>');	   
	$("#mensajeCarga").html(mensaje);
}
function ocultarPantallaDeCarga($selectDivCarga){
	ocultarSelector($selectDivCarga);
	$("#overlayLoading2").remove();
   

}



function mostrarSelector($selectDiv){
	$selectDiv.css('display','block');
}
function ocultarSelector($selectDiv){
	$selectDiv.css('display','none');
}

function mostrarTextoError($select,texto){
	$select.text(texto);
	$select.removeClass("displayNone");
}

function ocultarTextoError($select){
	$select.addClass("displayNone");
	$select.empty();
}

function activarEventos() {
	cargarEventoMostrarFilaEstudios();
	cargarEventoMostrarFilaNotas();
	carcarEventoEnviarVoto();
}
function activarEventosAniadirTemaView(){
	cargarEventoAniadirTema();
}
function buscarIndiceTemaPorId(idTema,arrayPreguntas){
	var indice =-1;
	var encontrado=false;
	for(var i =0;i<arrayPreguntas.length && !encontrado;i++) {
		if(arrayPreguntas[i].id == idTema) {
    		encontrado=true;
    		indice = i;
    	}
    }
	return indice;

}

function onLoad2(){
	ocultarSelect($("#filaNivelEstudios"));
	ocultarSelect($("#puntuacion"));
	ocultarSelect($("#filaPregunta"));
	activarEventos();
}

function onLoadAniadirTema(){
	activarEventosAniadirTemaView();
	
}
function indicador(data) {
	
	if (data.status == "begin") {
		     mostrarPantallaDeCarga($("#trCargando"),"Cargando...");
		}else if (data.status == "success") {
			 ocultarPantallaDeCarga($("#trCargando"));
			// location.href ="/EE_ECP/jsf/homeJSF.jsf";
	   }else if (data.status == "error") {
	   ocultarPantallaDeCarga($("#trCargando"));
	   alert("fail");
	   }

}

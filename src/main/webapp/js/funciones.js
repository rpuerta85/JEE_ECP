function mostrarSelectNivelDeEstudios(){
	
	
}
function ocultarSelectNivelDeEstudios(){
	
}

function crearContenidoCapaCorreoOrdinario(){
	var html =
		
				'<td  class="fuente3 celdaInformativoFormFacturacion">Dirección</td>'+
				'<td class="celdaInteractuableFormFacturacion" >'+
					'<input id="direccion"  class="inputForm Input" type="text" name="direccion" required placeholder="dirección" pattern="[A-Za-z0-9]+[A-Za-z0-9 ]*" >'+
				'</td>'+
		
				'<td  class="fuente3 celdaInformativoFormFacturacion"> Localidad</td>'+
				'<td class="celdaInteractuableFormFacturacion" >'+
					'<input id="localidad"  class="inputForm Input" type="text" name="localidad" required placeholder="localidad" pattern="[A-Za-z0-9]+[A-Za-z0-9 ]*" >'+
				'</td>';
		
	return html;
	
}
function crearContenidoCapaCorreoElectronico(){
	var html =
	'<td  class="fuente3 celdaInformativoFormFacturacion"> Correo</td>'+
		'<td class="celdaInteractuableFormFacturacion" >'+
   		'<input id="correoElectronico"  class="inputForm Input" type="text" name="correoElectronico" required placeholder="correo" readonly="readonly">'+
   '</td>';
	
	
	return html;
	
}



/*Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});*/
function validarDireccionCorreoElectronico($select){
	 var expresion= /^[A-Za-z0-9]+(\.[A-Za-z0-9]+|)*@[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
	 return expresion.test($select.val());
}	
function validarCamposCorreoOrdinario(){
	var valido = true;
	var cadena = "Los siguientes campos no tienen el formato correcto: ";
	var campo = "";
	
	var expresionDireccion = /^[A-Za-z0-9]{1,}[A-Za-z0-9 ]*$/;
	if (!expresionDireccion.test($("#direccion").val())) {
		campo += campo == "" ? "Dirección" : ", dirección";
		valido = false;
		$("#direccion").addClass("inputFondoError");
	}else{
		$("#direccion").removeClass("inputFondoError");
	}
	
	
	if (!expresionDireccion.test($("#localidad").val())) {
		campo += campo == "" ? "Localidad" : ", localidad";
		valido = false;
		$("#localidad").addClass("inputFondoError");
	}else{
		$("#localidad").removeClass("inputFondoError");
	}
	
	if(campo != ""){
		mostrarTextoError($("#trError"), cadena+campo);
	}else{
		ocultarTextoError($("#trError"));
	}
	
	 return valido;
}	


function mostrarTextoError($select,texto){
	$select.text(texto);
	$select.removeClass("displayNone");
}

function ocultarTextoError($select){
	$select.addClass("displayNone");
	$select.empty();
}
function mostrarCapaCorreoElectronico(){
	$("#cntCorreoElectronico").removeClass("displayNone");
	$("#cntCapasAux").removeClass("displayNone");
	
}
function mostrarCapaCorreoOrdinario(){
	$("#cntCorreoOrdinario").removeClass("displayNone");
	$("#cntCapasAux").removeClass("displayNone");
}


function activarEventos() {
	cargarEventoRadioModoMarcacion();
	cargarEventoBotonCancelar();
	cargarEventoBotonGuardar();
	cargarEventoOnClickCorreo();
	cargarEventoOnBlurAlIntroducirCodigoPostal();
	cargarEventoOnBlurAlIntroducirDNI();
	cargarEventoOnChangeEnRangoTamanioLetra();
}

function validarDNI(){
	var valido = true; 
	var textoAImprimir = "";
	if($("#dni").val()!='') {
		
	
	
			var expresion= /^\d{1,8}[A-Za-z]$/;
			valido = expresion.test(($("#dni").val()));
			if(!valido) {
				textoAImprimir += "El DNI no tiene el formato correcto(8 digitos y una letra). Ej:12345678E. "
			}else {
		
				var letraIntroducida = $("#dni").val().substr($("#dni").val().length-1,$("#dni").val().length);
				var dni = $("#dni").val().substr(0,$("#dni").val().length-1);
				
				var letras = new Array('T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E','T');
				var letra = parseInt(dni % 23);
				//alert("La letra para el dni "+dni+" es "+letras[letra]);
				if(letras[letra] != letraIntroducida && letras[letra] != letraIntroducida.toUpperCase() ) {
					valido = false;
					textoAImprimir += "La letra introducida para el DNI "+ dni +" no es la correcta. La correcta es la "+letras[letra] +"\n";
				}
			}
			if(!valido) {
				mostrarTextoError($("#trError2"), textoAImprimir);
		
			}
	
	}
	return valido;
	
}
function inicializarSortable(){
	
	$("#sortable").sortable({
         cursor:'crosshair',
         placeholder: 'ui-state-highlight',
		 update : function(event, ui) {
			 setListaHobbiesVarHidden();
         }});
	setListaHobbiesVarHidden();
}
function setListaHobbiesVarHidden(){
	var orden = $("#sortable").sortable('toArray');
    var valor = ""; 
    for (var i = 0; i<orden.length-1;i++){
 	   valor += $("#"+orden[i]).text()+",";
    }
    valor += $("#"+orden[orden.length-1]).text();
    //alert(valor);
    $("#listaHobbiesHidden").val(valor);
}
function cargarClases(){
	$("#cntTamanioFuente").addClass("cntTamanioFuente");
	$("#cntFactura").addClass("cntFactura");
	$("#trError2").addClass("trError").addClass("displayNone");
	$("#trError").addClass("trError").addClass("displayNone");


	$("#tablaFormInscripcion").addClass("fac_contenidoTabla");
	$("#filaSeccionDatosPersonales").addClass("filaSeccion");
	cargarClasesColumnas();
	cargarClasesInputText();
	cargarClasesListaSortable();
	$("#fechaAlta").css("width","90.1%");
	
	
	$("#cntBarraBotones").addClass("barraBotones").addClass("alignCenter"); 
	$("#cntBarraBotonesAuxCorreoElectrónico").addClass("barraBotones").addClass("alignCenter"); 

	
	$("#cntCapasAux").addClass("cntModoEntregaCarne").addClass("displayNone"); 
	$("#cntCorreoElectronico").addClass("displayNone"); 
	$("#tablaCorreoElectronicoAux").addClass("fac_contenidoTabla"); 
	$("#tablaCorreoOrdinarioAux").addClass("fac_contenidoTabla");
	
	$("#celdaCorreoElectronico").addClass("fuente3").addClass("celdaInformativoFormFacturacion");
	$("#celdaCorreoOrdinarioDireccionAux").addClass("fuente3").addClass("celdaInformativoFormFacturacion");
	$("#celdaCorreoOrdinariolocalidadAux").addClass("fuente3").addClass("celdaInformativoFormFacturacion");

	$("#celdaCorreoOrdinarioDireccionInput").addClass("celdaInteractuableFormFacturacion");
	$("#celdaCorreoElectronicoCorreoInput").addClass("celdaInteractuableFormFacturacion");
	$("#celdaCorreoOrdinarioLocalidadInput").addClass("celdaInteractuableFormFacturacion");
	
	$("#direccionAux").addClass("Input").addClass("inputForm"); 	
	$("#localidadAux").addClass("Input").addClass("inputForm"); 	
	$("#correoElectronicoAux").addClass("Input").addClass("inputForm"); 	
	
	
	
}
function cargarClasesColumnas(){
	var numeroFilas = 4;
	
	for (var i = 0; i < numeroFilas; i++) {
		$("#celda"+i+"_2").addClass("fuente3").addClass("celdaInformativoFormFacturacion");
		$("#celda"+i+"_0").addClass("fuente3").addClass("celdaInformativoFormFacturacion");
		$("#celda"+i+"_1").addClass("celdaInteractuableFormFacturacion");
		$("#celda"+i+"_3").addClass("celdaInteractuableFormFacturacion");
	}
}

function cargarClasesListaSortable(){
	 $("#sortable").find('li').each(function() {
		 $(this).addClass("ui-state-default");
		 $(this).children().addClass("ui-icon ui-icon-arrowthick-2-n-s");
	 });
}

function cargarClasesInputText(){
	  $("#form1").find('input:text').each(function() {
	
		  if($(this).attr("readonly")!=undefined){
			  $(this).addClass("InputSinAcceso").addClass("inputForm"); 
		  }else {
			  $(this).addClass("Input").addClass("inputForm"); 
		  }
	  });
	
}

function onLoad2(){
	cargarClases();
	inicializarCalendario();
	inicializarSortable();
	activarEventos();
}


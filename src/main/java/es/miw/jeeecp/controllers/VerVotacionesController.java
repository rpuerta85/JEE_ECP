package es.miw.jeeecp.controllers;

import java.util.HashMap;
import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.utils.ListaVotosAsociadosAUnEstudio;

public interface VerVotacionesController {

	List<TemaEntity>  obtenerVotosPorTema();
    HashMap<String, ListaVotosAsociadosAUnEstudio> votacionMediaSegunNivelEstudios();

}

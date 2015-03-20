package es.miw.jeeecp.controllers;

import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;

public interface VerVotacionesController {

    List<TemaEntity> obtenerVotosPorTema();

}

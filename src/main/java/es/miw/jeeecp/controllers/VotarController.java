package es.miw.jeeecp.controllers;

import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;

public interface VotarController {

    List<TemaEntity> mostrarTemas();

    void mostrarPregunta();
    
    boolean votar();

}

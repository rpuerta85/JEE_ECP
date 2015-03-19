package es.miw.jeeecp.controllers;

import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public interface VotarController {

    List<TemaEntity> mostrarTemas();

    void mostrarPregunta();
    
    boolean votar(TemaEntity tema,VotoEntity voto);

}

package prueba.rest;

import java.util.HashMap;
import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;

public class VotacionMediaPorEstudios {

	//mapa de <Estudios,ListaVotosEstudio>
	private HashMap<String, ListaVotosAsociadosAUnEstudio> mapaEstudios = new HashMap<String, ListaVotosAsociadosAUnEstudio>();
	
	
	public VotacionMediaPorEstudios() {
		// TODO Auto-generated constructor stub
	}

	public void setMapaEstudios(List<TemaEntity> listaTemas) {
		for(TemaEntity tema )
		
	}

	public HashMap<String, ListaVotosAsociadosAUnEstudio> getMapaEstudios() {
		return mapaEstudios;
	}
	
}

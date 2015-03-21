package prueba.rest;

import java.util.HashMap;
import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public class VotacionMediaPorEstudios {

	//mapa de <Estudios,ListaVotosEstudio>
	private HashMap<String, ListaVotosAsociadosAUnEstudio> mapaEstudios = new HashMap<String, ListaVotosAsociadosAUnEstudio>();
	
	
	public VotacionMediaPorEstudios() {
		// TODO Auto-generated constructor stub
	}
	public void setMapaEstudios(List<TemaEntity> listaTemas) {
		
		for(TemaEntity tema :listaTemas ) { //recorremos todos los temas
			//ListaVotosAsociadosAUnEstudio listaVotosAsociadosAUnEstudio = new ListaVotosAsociadosAUnEstudio();
			//mapaEstudios.put(tema.getTema(), listaVotosAsociadosAUnEstudio);
			for(  VotoEntity voto : tema.getVotos()) { // recorremos por cada tema, los votos
				//listaVotosAsociadosAUnEstudio = mapaEstudios.get(tema.getTema());
				//listaVotosAsociadosAUnEstudio.addVoto(voto);
			}
		}
		
	}

	public HashMap<String, ListaVotosAsociadosAUnEstudio> getMapaEstudios() {
		return mapaEstudios;
	}
	
}

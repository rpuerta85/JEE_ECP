package es.miw.jeeecp.models.utils;

import java.util.HashMap;
import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;
import es.miw.jeeecp.view.web.beans.VotarView;

public class VotacionMediaPorEstudios {

	//mapa de <Estudios,ListaVotosEstudio>
	private HashMap<String, ListaVotosAsociadosAUnEstudio> mapaEstudios = new HashMap<String, ListaVotosAsociadosAUnEstudio>();
	
	
	public VotacionMediaPorEstudios() {
		super();
	}
	public void setMapaEstudios(List<TemaEntity> listaTemas) {
		//cargamos los estudios disponibles y por cada estudio una lista de votos vacia en este caso
		inicializarMapaEstudios();
		for(TemaEntity tema :listaTemas ) { //recorremos todos los temas
			List<VotoEntity> listaVotos=tema.getVotos();
			for(  VotoEntity voto : listaVotos) { // recorremos por cada tema, los votos
				mapaEstudios.get(voto.getEstudios()).addVoto(voto); //añadimos voto a la lista
			
			}
		}
		
	}
	private void inicializarMapaEstudios(){
		VotarView votarView = new VotarView();
		votarView.update();
		List<String> listaEstudios = votarView.getListaNivelEstudios();
		for (String estudio :listaEstudios) {
			mapaEstudios.put(estudio, new ListaVotosAsociadosAUnEstudio());
		}
	}
	
	public HashMap<String, ListaVotosAsociadosAUnEstudio> getMapaEstudios() {
		return mapaEstudios;
	}
	
}

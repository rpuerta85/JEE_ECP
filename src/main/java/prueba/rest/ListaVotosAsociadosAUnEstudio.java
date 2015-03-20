package prueba.rest;

import java.util.ArrayList;
import java.util.List;

import es.miw.jeeecp.models.entities.VotoEntity;

public class ListaVotosAsociadosAUnEstudio {

	
	private List<VotoEntity> listaVotos = new ArrayList<VotoEntity>();
	
	public ListaVotosAsociadosAUnEstudio() {
		// TODO Auto-generated constructor stub
	}

	public List<VotoEntity> getListaVotos() {
		return listaVotos;
	}

	public void setListaVotos(List<VotoEntity> listaVotos) {
		this.listaVotos = listaVotos;
	}
	

}

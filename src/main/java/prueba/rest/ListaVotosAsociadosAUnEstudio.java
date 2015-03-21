package prueba.rest;

import java.util.ArrayList;
import java.util.List;

import es.miw.jeeecp.models.entities.VotoEntity;

public class ListaVotosAsociadosAUnEstudio {

	
	
	private List<VotoEntity> listaVotos = new ArrayList<VotoEntity>();
	
	private int numElementos;
	private Double votacionMediaActual;
	
	
	public ListaVotosAsociadosAUnEstudio() {
		// TODO Auto-generated constructor stub
	}

	public List<VotoEntity> getListaVotos() {
		return listaVotos;
	}

	public void setListaVotos(List<VotoEntity> listaVotos) {
		this.listaVotos = listaVotos;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}

	public Double getVotacionMediaActual() {
		return votacionMediaActual;
	}

	public void setVotacionMediaActual(Double votacionMediaActual) {
		this.votacionMediaActual = votacionMediaActual;
	}
	
  
}

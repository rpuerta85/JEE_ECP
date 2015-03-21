package es.miw.jeeecp.models.utils;

import java.util.ArrayList;
import java.util.List;

import es.miw.jeeecp.models.entities.VotoEntity;

public class ListaVotosAsociadosAUnEstudio {

	
	
	private List<VotoEntity> listaVotos = new ArrayList<VotoEntity>();
	
	private int numElementos;
	private double votacionMediaActual;
	private double sumaVotacionActual;
	
	
	public ListaVotosAsociadosAUnEstudio() {
		super();
		numElementos = 0;
		votacionMediaActual = 0d;
		sumaVotacionActual = 0d;
		
	}

	public void addVoto(VotoEntity voto){
		listaVotos.add(voto);//añadimos voto
		actualizarContadores(voto);
		
	}
	private void  actualizarContadores(VotoEntity voto){
		numElementos++;
		sumaVotacionActual += voto.getNota().intValue();
		votacionMediaActual = (sumaVotacionActual / numElementos);
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

	public Double getVotacionMediaActual() {
		return votacionMediaActual;
	}

	public Double getSumaVotacionActual() {
		return sumaVotacionActual;
	}

	public void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}

	public void setVotacionMediaActual(Double votacionMediaActual) {
		this.votacionMediaActual = votacionMediaActual;
	}

	public void setSumaVotacionActual(Double sumaVotacionActual) {
		this.sumaVotacionActual = sumaVotacionActual;
	}
	
  
}

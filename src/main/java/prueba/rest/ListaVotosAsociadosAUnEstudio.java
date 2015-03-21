package prueba.rest;

import java.util.ArrayList;
import java.util.List;

import es.miw.jeeecp.models.entities.VotoEntity;

public class ListaVotosAsociadosAUnEstudio {

	
	
	private List<VotoEntity> listaVotos = new ArrayList<VotoEntity>();
	
	private int numElementos;
	private Double votacionMediaActual;
	private Double sumaVotacionActual;
	
	
	public ListaVotosAsociadosAUnEstudio() {
		super();
	}

	public void addVoto(VotoEntity voto){
		listaVotos.add(voto);//añadimos voto
		actualizarContadores(voto);
		
	}
	private void  actualizarContadores(VotoEntity voto){
		numElementos++;
		sumaVotacionActual += voto.getNota().intValue();
		sumaVotacionActual += (sumaVotacionActual / numElementos);
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
	
  
}

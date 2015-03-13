package es.miw.jeeecp.models.daos.jpa;

import java.util.List;

import es.miw.jeeecp.models.entities.VotoEntity;
import es.miw.jeeecp.models.entities.VotoEntityDataTest;

public class VotoEntityJpaDataTest{

	private   List<VotoEntity> listaVotosEntrada; 
	
	public VotoEntityJpaDataTest(){
		super();
		listaVotosEntrada = new VotoEntityDataTest().getListaVotoSalida();
	}

	public List<VotoEntity> getListaVotosEntrada() {
		return listaVotosEntrada;
	}

	public void setListaVotosEntrada(List<VotoEntity> listaVotosEntrada) {
		this.listaVotosEntrada = listaVotosEntrada;
	}

	

	
	


}

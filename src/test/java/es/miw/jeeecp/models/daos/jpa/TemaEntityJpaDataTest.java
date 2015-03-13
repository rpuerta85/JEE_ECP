package es.miw.jeeecp.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import es.miw.jeeecp.models.entities.GenericEntityDataTest;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.TemaEntityDataTest;
import es.miw.jeeecp.models.entities.VotoEntity;
import es.miw.jeeecp.models.entities.VotoEntityDataTest;

public class TemaEntityJpaDataTest{

	private   List<TemaEntity> listaTemasSoloEntrada;
	private   List<VotoEntity> listaVotosConTemaEntrada; 
	 
	
	
	public TemaEntityJpaDataTest(){
		super();
		listaTemasSoloEntrada = new TemaEntityDataTest().getListaTemaSalida();
		listaVotosConTemaEntrada = new VotoEntityDataTest().getListaVotoSalida();
	}



	public List<TemaEntity> getListaTemasSoloEntrada() {
		return listaTemasSoloEntrada;
	}



	public void setListaTemasSoloEntrada(List<TemaEntity> listaTemasSoloEntrada) {
		this.listaTemasSoloEntrada = listaTemasSoloEntrada;
	}



	public List<VotoEntity> getListaVotosConTemaEntrada() {
		return listaVotosConTemaEntrada;
	}



	public void setListaVotosConTemaEntrada(
			List<VotoEntity> listaVotosConTemaEntrada) {
		this.listaVotosConTemaEntrada = listaVotosConTemaEntrada;
	}


	
	


}

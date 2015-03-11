package es.miw.jeeecp.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import es.miw.jeeecp.models.entities.GenericEntityDataTest;

public class TemaEntityJpaDataTest extends GenericEntityDataTest{

	private static final String PATH_EXCEL_FILE = "src/test/resources/TemaEntityTestData.xlsx";
	private  List<String> listaTemaEntrada = new ArrayList<String>();
	private  List<String> listaPreguntaEntrada = new ArrayList<String>();
	
	public  List<TemaEntity> listaTemaSalida = new ArrayList<TemaEntity>();

	public TemaEntityJpaDataTest(){
		super(PATH_EXCEL_FILE);
		rellenarWorkbook();
	}
	
	protected void procesarColumna(Cell columna,int numFila,int numColumna,Sheet sheet,Workbook workbook){
		CellReference cellReference = new CellReference (numFila, numColumna);
		
		if(cellReference.formatAsString().contains("B")){ // columna INTERVALO
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
			this.listaTemaEntrada.add(valor);
			
		}else if(cellReference.formatAsString().contains("C")) {
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
			//TemaEntityDataTest.PREGUNTA_ENTRADA.add(Double.parseDouble(valor));
			this.listaPreguntaEntrada.add(valor);
		}
		else if(cellReference.formatAsString().contains("D")) {
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
		    valor = valor.substring(1, valor.length()-1);
			String[] coordenadas = valor.split(",",2);
			this.listaTemaSalida.add(new TemaEntity(coordenadas[0], (coordenadas[1])));
		}
			
	}

	public List<String> getListaTemaEntrada() {
		return listaTemaEntrada;
	}

	public void setListaTemaEntrada(List<String> listaTemaEntrada) {
		this.listaTemaEntrada = listaTemaEntrada;
	}

	public List<String> getListaPreguntaEntrada() {
		return listaPreguntaEntrada;
	}

	public void setListaPreguntaEntrada(List<String> listaPreguntaEntrada) {
		this.listaPreguntaEntrada = listaPreguntaEntrada;
	}

	public List<TemaEntity> getListaTemaSalida() {
		return listaTemaSalida;
	}

	public void setListaTemaSalida(List<TemaEntity> listaTemaSalida) {
		this.listaTemaSalida = listaTemaSalida;
	}



}

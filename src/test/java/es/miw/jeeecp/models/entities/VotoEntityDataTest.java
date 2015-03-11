package es.miw.jeeecp.models.entities;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.util.CellReference;

public class VotoEntityDataTest extends GenericEntityDataTest{

	private static final int NUM_CAMPOS_ENTRADA_EXCEL = 5;
	private static final String PATH_EXCEL_FILE = "src/test/resources/VotoEntityTestData.xlsx";
	private  List<String> listaIpEntrada = new ArrayList<String>();
	private  List<String> listaNotaEntrada = new ArrayList<String>();
	private  List<String> listaEstudiosEntrada = new ArrayList<String>();
	private  List<String> listaPreguntaEntrada = new ArrayList<String>();
	private  List<String> listaTemaEntrada = new ArrayList<String>();

	
	public  List<VotoEntity> listaVotoSalida = new ArrayList<VotoEntity>();

	public VotoEntityDataTest(){
		super(PATH_EXCEL_FILE);
		rellenarWorkbook();
	}
	
	protected void procesarColumna(Cell columna,int numFila,int numColumna,Sheet sheet,Workbook workbook){
		CellReference cellReference = new CellReference (numFila, numColumna);
		
		if(cellReference.formatAsString().contains("B")){ // columna INTERVALO
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
			this.listaIpEntrada.add(valor);
			
		}else if(cellReference.formatAsString().contains("C")) {
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
			this.listaNotaEntrada.add(valor);
		}
		else if(cellReference.formatAsString().contains("D")) {
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
			this.listaEstudiosEntrada.add(valor);
		}
		else if(cellReference.formatAsString().contains("E")) {
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
			this.listaPreguntaEntrada.add(valor);
		}
		else if(cellReference.formatAsString().contains("F")) {
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
			this.listaTemaEntrada.add(valor);
		}
		else if(cellReference.formatAsString().contains("G")) {
			String valor = obtenerValorColumnaSegunTipoDatoColumna(columna);
		    valor = valor.substring(1, valor.length()-1);
			String[] tokens = valor.split(",",NUM_CAMPOS_ENTRADA_EXCEL);
			this.listaVotoSalida.add(new VotoEntity(tokens[0], Integer.parseInt(tokens[1]), tokens[2], new TemaEntity(tokens[4], tokens[3]) ));
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

	public List<VotoEntity> getListaVotoSalida() {
		return listaVotoSalida;
	}

	public void setListaVotoSalida(List<VotoEntity> listaVotoSalida) {
		this.listaVotoSalida = listaVotoSalida;
	}

	public List<String> getListaIpEntrada() {
		return listaIpEntrada;
	}

	public void setListaIpEntrada(List<String> listaIpEntrada) {
		this.listaIpEntrada = listaIpEntrada;
	}

	public List<String> getListaNotaEntrada() {
		return listaNotaEntrada;
	}

	public void setListaNotaEntrada(List<String> listaNotaEntrada) {
		this.listaNotaEntrada = listaNotaEntrada;
	}

	public List<String> getListaEstudiosEntrada() {
		return listaEstudiosEntrada;
	}

	public void setListaEstudiosEntrada(List<String> listaEstudiosEntrada) {
		this.listaEstudiosEntrada = listaEstudiosEntrada;
	}



}

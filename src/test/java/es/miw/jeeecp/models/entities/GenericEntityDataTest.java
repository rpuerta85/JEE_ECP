package es.miw.jeeecp.models.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;

public abstract class GenericEntityDataTest {
	
	protected Workbook workbook;
	protected String pathExcelFile;
	public GenericEntityDataTest(String pathExcelFile){
		this.pathExcelFile = pathExcelFile;
		
	}
	
	protected void rellenarWorkbook(){
		try {
		    //workbook = abrirExcel("src/test/resources/TemaEntityTestData.xlsx");
		    workbook = abrirExcel(this.pathExcelFile);
			recorrerExcel();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Workbook abrirExcel(String uriRelativaAWebContent) throws InvalidFormatException, IOException {
		FileInputStream file = new FileInputStream(new File(uriRelativaAWebContent));
		workbook = WorkbookFactory.create(file);// creamos LIBRO EXCEL
		return workbook;
	}
	private void recorrerExcel(){
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);// obtenemos la HOOJA 1
		Iterator<Row> rowIterator = sheet.rowIterator();//obtenemos el ITERADOS DE FILAS del archivo
		while (rowIterator.hasNext()){//miestras existan filas, recorremos las filas
			Row hssfRow = (Row) rowIterator.next();//cogemos la fila
			Iterator<Cell> iterator = hssfRow.cellIterator();//cogemos el iterados de columnas o celdas
			if(hssfRow.getRowNum()>1){
				while (iterator.hasNext()){//recorremos las columnas
					Cell hssfCell = (Cell) iterator.next(); //cogemos la columnaa
					//System.out.println(hssfRow.getRowNum()+":"+hssfCell.getColumnIndex());
					procesarColumna(hssfCell, hssfRow.getRowNum(), hssfCell.getColumnIndex(),sheet,workbook);			    	  
	
				}
			}

		}
		
	}

	protected String obtenerValorColumnaSegunTipoDatoColumna(Cell columna) {
		String valor = "";
		if (columna.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			valor = String.valueOf(columna.getNumericCellValue());
		} else if (columna.getCellType() == Cell.CELL_TYPE_STRING) {
			valor = columna.getStringCellValue();
		}else if (columna.getCellType() == Cell.CELL_TYPE_FORMULA){ //aunque sea formula, leeemos el datos igual
			switch(columna.getCachedFormulaResultType()) {
            case Cell.CELL_TYPE_NUMERIC:
                valor = columna.getNumericCellValue()+"";
                break;
            case Cell.CELL_TYPE_STRING:
            	 valor = columna.getRichStringCellValue()+"";
            	//System.out.println("Last evaluated as \"" + columna.getRichStringCellValue() + "\"");
                break;
        }
			
		}
		else if (columna.getCellType() == Cell.CELL_TYPE_BLANK) {
			valor = "";
		}
	
		// System.out.println("VALOR:"+valor);
		return valor;
	}

	protected abstract void procesarColumna(Cell columna,int numFila,int numColumna,Sheet sheet,Workbook workbook);
		
}

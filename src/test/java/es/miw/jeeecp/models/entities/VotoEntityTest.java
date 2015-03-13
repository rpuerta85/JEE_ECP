package es.miw.jeeecp.models.entities;


import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class VotoEntityTest {

    private static  VotoEntityDataTest votoEntityDataTest;
    
    @BeforeClass
     static public void initialized() {
    	votoEntityDataTest = new VotoEntityDataTest();
    }
    
    @Test
    public void testIp() {
       
    	for (int i = 0;i<votoEntityDataTest.getListaIpEntrada().size();i++) {
        	String ip = votoEntityDataTest.getListaIpEntrada().get(i);
            VotoEntity votoEntity = new VotoEntity(ip, null, null);
            assertEquals(votoEntity.getIp(), 
            		votoEntityDataTest.getListaVotoSalida().get(i).getIp());
        }
        
        
    }

    @Test
    public void testNota() {
    	  for (int i = 0;i<votoEntityDataTest.getListaNotaEntrada().size();i++) {
          	String nota = votoEntityDataTest.getListaNotaEntrada().get(i);
          	Double notaDouble = new Double(nota);
          	 VotoEntity votoEntity = new VotoEntity(null, notaDouble.intValue(), null);
          	 assertEquals(votoEntity.getNota(), 
          			votoEntityDataTest.getListaVotoSalida().get(i).getNota());
          }
    }
    @Test
    public void testEstudios() {
    	  for (int i = 0;i<votoEntityDataTest.getListaEstudiosEntrada().size();i++) {
          	String estudios = votoEntityDataTest.getListaEstudiosEntrada().get(i);
         	 VotoEntity votoEntity = new VotoEntity(null, null, estudios);
              assertEquals(votoEntity.getEstudios(), 
            		  votoEntityDataTest.getListaVotoSalida() .get(i).getEstudios());
          }
    }
  /*  @Test
    public void testTema() {
    	  for (int i = 0;i<votoEntityDataTest.getListaTemaEntrada().size();i++) {
          	String tema = votoEntityDataTest.getListaTemaEntrada().get(i);
            String pregunta = votoEntityDataTest.getListaPreguntaEntrada().get(i);
          	TemaEntity temaEntity = new TemaEntity(tema, pregunta);
          	 VotoEntity votoEntity = new VotoEntity(null, null, null, temaEntity);
             TemaEntity aux =  votoEntityDataTest.getListaVotoSalida().get(i).getTema();
             assertEquals(temaEntity.getTema(), 
          			aux.getTema());
          }
    }*/


    
  	   

}

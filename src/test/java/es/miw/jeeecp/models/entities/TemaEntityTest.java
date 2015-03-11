package es.miw.jeeecp.models.entities;


import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TemaEntityTest {

    private static  TemaEntityDataTest temaEntityDataTest;
   // private static final ClosedInterval[] CLOSED_INTERVALS = new ClosedInterval[ENDPOINTS.length];
    
    @BeforeClass
     static public void initialized() {
    	temaEntityDataTest = new TemaEntityDataTest();
    }
    
    @Test
    public void testPregunta() {
        for (int i = 0;i<temaEntityDataTest.getListaPreguntaEntrada().size();i++) {
        	String pregunta = temaEntityDataTest.getListaPreguntaEntrada().get(i);
            TemaEntity temaEntity = new TemaEntity(null, pregunta);
            assertEquals(temaEntity.getPregunta(), 
            		temaEntityDataTest.getListaTemaSalida().get(i).getPregunta());
        }
        
        
    }

    @Test
    public void testTema() {
    	  for (int i = 0;i<temaEntityDataTest.getListaTemaEntrada().size();i++) {
          	String tema = temaEntityDataTest.getListaTemaEntrada().get(i);
              TemaEntity temaEntity = new TemaEntity(tema, null);
              assertEquals(temaEntity.getTema(), 
              		temaEntityDataTest.getListaTemaSalida().get(i).getTema());
          }
    }

}

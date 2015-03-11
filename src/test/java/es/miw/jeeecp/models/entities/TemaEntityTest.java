package es.miw.jeeecp.models.entities;


import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaEntityTest {

    private TemaEntityDataTest temaEntityDataTest;
    
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
        final int[][] VALUES = { {-5, 0, 3, 5}, {0, 7, 10}, {0}, {3, 4, 44, 96, 97}};
        assert ENDPOINTS.length == VALUES.length;
        for (int i = 0; i < CLOSED_INTERVALS.length; i++) {
            for (int j = 0; j < VALUES[i].length; j++) {
                assertTrue(CLOSED_INTERVALS[i].include(VALUES[i][j]));
            }
        }
    }

//    @Test
//    public void testGetVotos() {
//    	 fail("Not yet implemented");
//    }
    
    
  	   

}

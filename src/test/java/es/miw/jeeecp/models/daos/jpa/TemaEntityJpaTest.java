package es.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.entities.TemaEntity;

public class TemaEntityJpaTest {

	    private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();

	    private static TemaEntityJpaDataTest temaEntityJpaDataTest;
	    static List<TemaEntity> listaTemas;
	    private List<TemaEntity > temasAux;
	    @BeforeClass
	    public static void inti() {
	        //Se borrar y se crean las tablas
	         Map<String, String> properties = new HashMap<>();
	         properties. put(PersistenceUnitProperties.DDL_GENERATION,
	                 PersistenceUnitProperties.DROP_AND_CREATE);
	         EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties)
	                 .createEntityManager();
	    	
	    	temaEntityJpaDataTest = new TemaEntityJpaDataTest();
	    	listaTemas = temaEntityJpaDataTest.getListaTemasSoloEntrada();
	    }
	 
	    @Before 
	    public void intiBefore() {
	        List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
	        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
	           dao.deleteById(temaBBDD.getId() );
	        }
	    }
	    @AfterClass
	    public static void restoreBBDD(){
	       //Se borrar y se crean las tablas
//	         Map<String, String> properties = new HashMap<>();
//	         properties. put(PersistenceUnitProperties.DDL_GENERATION,
//	                 PersistenceUnitProperties.DROP_AND_CREATE);
//	         EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties).createEntityManager();
	    	TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	    	List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
		        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
		           dao.deleteById(temaBBDD.getId() );
		           System.out.println("!!!borrando tema : " + temaBBDD.getId().toString());
		        }
	    }
	    
	    
	    @Test
	    public void testCreate() {
	        
	    	
	    	temasAux = new ArrayList<TemaEntity>();
	        for(int i=0;i<listaTemas.size();i++){
	            TemaEntity tema = listaTemas.get(i);
	        	if (tema != null) {
	                System.out.println("!!!tema : " + tema.toString());
	                dao.create(tema);
	                temasAux.add(tema);
	            }
	        }
	        
	        List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
	        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
	            assertTrue(temasRecuperadosDeBaseDeDatos.contains(temaBBDD));
	        }
	        assertTrue(temasRecuperadosDeBaseDeDatos.size() == temasAux.size());
	    }

	    
	    @Test
	    public void testUpdate() {
	    	 
	       //  dao.deleteByID(data.getPiece().getId());
	       //dao.read(data.getPiece().getId());
	       //  dao.update(data.getPiece());
	         
	        // List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
	         
	         temasAux = new ArrayList<TemaEntity>();
		        for(int i=0;i<listaTemas.size();i++){
		            TemaEntity tema = listaTemas.get(i);
		            tema.setPregunta("pregunta actualizada");
		        	if (tema != null) {
		                System.out.println("!!!tema : " + tema.toString());
		                dao.update(tema);
		                temasAux.add(tema);
		            }
		        }
		        
		        List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
		        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
		            assertTrue(temasRecuperadosDeBaseDeDatos.contains(temaBBDD));
		        }
		        assertTrue(temasRecuperadosDeBaseDeDatos.size() == temasAux.size());
	    }
//
//	    @Test
//	    public void testDelete() {
//
//	    }
//
//	    @Test
//	    public void testDeleteByID() {
//
//	    }
//
//	    @Test
//	    public void testDeleteByCoordinate() {
//
//	    }
//
//	    @Test
//	    public void testRead() {
//
//	    }
//
//	    @Test
//	    public void testFindAll() {
//
//	    }

	}

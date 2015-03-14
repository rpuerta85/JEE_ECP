package es.miw.jeeecp.models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;
import es.miw.jeeecp.models.entities.VotoEntityDataTest;

public class TemaEntityJpaTest {

	    private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();

	    private static TemaEntityJpaDataTest temaEntityJpaDataTest;
	    private static List<TemaEntity> listaTemas;
	    private List<TemaEntity > temasAux;
	    
	    private static List<VotoEntity> listaVotos;
	    
	    
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
	    	
	    	//listaVotos = new VotoEntity();
	    }
	 
//	    @Before 
//	    public void intiBefore() {
//	        List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
//	        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
//	           dao.deleteById(temaBBDD.getId() );
//	        }
//	    }
	    @After
	    public void borrarRegistros() {
	    	 //Se borrar los datos insertados en los tests
	    	TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	    	List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
		        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
		           dao.deleteById(temaBBDD.getId() );
		           System.out.println("!!!borrando tema : " + temaBBDD.getId().toString());
		        }
	    }
//<<<<<<< HEAD
	    
//	    @AfterClass
//	    public static void restoreBBDD(){
//	       //Se borrar los datos insertados en los tests
//	    	TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
//	    	List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
//		        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
//		           dao.deleteById(temaBBDD.getId() );
//		           System.out.println("!!!borrando tema : " + temaBBDD.getId().toString());
//		        }
//	    }
//=======
//	    @AfterClass
//	    public static void restoreBBDD(){
//	       //Se borrar y se crean las tablas
////	         Map<String, String> properties = new HashMap<>();
////	         properties. put(PersistenceUnitProperties.DDL_GENERATION,
////	                 PersistenceUnitProperties.DROP_AND_CREATE);
////	         EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties).createEntityManager();
//	    	TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
//	    	List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
//		        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
//		           dao.deleteById(temaBBDD.getId() );
//		           System.out.println("!!!borrando tema : " + temaBBDD.getId().toString());
//		        }
//	    }
//>>>>>>> branch 'master' of https://github.com/rpuerta85/JEE_ECP.git
	    
	    
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
	    	insertamosRegistros();
	         temasAux = new ArrayList<TemaEntity>();
		        for(int i=0;i<listaTemas.size();i++){
		            TemaEntity tema = listaTemas.get(i);
		            tema.setPregunta("pregunta actualizada");
		        	if (tema != null) {
		                System.out.println("!!!tema actualizado : " + tema.toString());
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

	   
	    
	    @Test
	    public void testDeleteByID() {
	    	insertamosRegistros();
	         temasAux = new ArrayList<TemaEntity>();
		        for(int i=0;i<listaTemas.size();i++){
		            TemaEntity tema = listaTemas.get(i);
		        	if (tema != null) {
		                System.out.println("!!!tema borrado : " + tema.toString());
		                dao.deleteById(tema.getId()); 
		                temasAux.add(tema);
		            }
		        }
		        List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
		        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
		            assertFalse(temasRecuperadosDeBaseDeDatos.contains(temaBBDD));
		        }
		        assertTrue(temasRecuperadosDeBaseDeDatos.size() == 0);
		        assertTrue(temasRecuperadosDeBaseDeDatos.size() != temasAux.size());
	    }

	    @Test
	    public void testRead() {
	    	insertamosRegistros();
	   temasAux = new ArrayList<TemaEntity>();
		        for(int i=0;i<listaTemas.size();i++){
		            TemaEntity tema = listaTemas.get(i);
		        	if (tema != null) {
		                System.out.println("!!!tema leido : " + tema.toString());
		                dao.read(tema.getId()); 
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
	    public void testCreateConVoto() {
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
	    
	    
	    
	    
	    
	    
	private void insertamosRegistros(){
		temasAux = new ArrayList<TemaEntity>();
        for(int i=0;i<listaTemas.size();i++){
            TemaEntity tema = listaTemas.get(i);
        	if (tema != null) {
                System.out.println("!!!tema : " + tema.toString());
                dao.create(tema);
                
            }
        }
		
	}

	}

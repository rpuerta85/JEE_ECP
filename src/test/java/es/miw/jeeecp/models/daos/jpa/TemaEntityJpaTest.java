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
	    private List<TemaEntity > temasInsertados;
	    @BeforeClass
	    public static void inti() {
	    	temaEntityJpaDataTest = new TemaEntityJpaDataTest();
	    	listaTemas = temaEntityJpaDataTest.getListaTemasSoloEntrada();
	    }
	 
	    
	    @Test
	    public void testCreate() {
	         temasInsertados = new ArrayList<TemaEntity>();
	        for(int i=0;i<listaTemas.size();i++){
	            TemaEntity tema = listaTemas.get(i);
	        	if (tema != null) {
	                System.out.println("!!!tema : " + tema.toString());
	                dao.create(tema);
	                temasInsertados.add(tema);
	            }
	        }
	        
	        List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
	        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
	            assertTrue(temasRecuperadosDeBaseDeDatos.contains(temaBBDD));
	        }
	        assertTrue(temasRecuperadosDeBaseDeDatos.size() == temasInsertados.size());
	    }

	    @AfterClass
	    public static void restoreBBDD(){
	    	/*for (TemaEntity temaInsertado: temasInsertados){
	    		dao.
	    	}*/
	    	Map<String, String> properties = new HashMap<>();
	         properties. put(PersistenceUnitProperties.DDL_GENERATION,
	                 PersistenceUnitProperties.DROP_ONLY);
	         EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties)
	                 .createEntityManager();
	         
	    }
	    
//	    @Test
//	    public void testUpdate() {
//
//	        // dao.deleteByID(data.getPiece().getId());
//	        // dao.read(data.getPiece().getId());
//	        // dao.update(data.getPiece());
//	    }
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

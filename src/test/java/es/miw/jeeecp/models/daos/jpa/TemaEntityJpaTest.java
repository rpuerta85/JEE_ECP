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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public class TemaEntityJpaTest {

	    private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();

	    private static TemaEntityJpaDataTest temaEntityJpaDataTest;
	    private static List<TemaEntity> listaTemasOriginal;
	    private static List<TemaEntity> listaTemasCopiaAuxiliar;
	    
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
	    	listaTemasOriginal = temaEntityJpaDataTest.getListaTemasSoloEntrada();
	    
	    	
	    	listaVotos = new VotoEntityJpaDataTest().getListaVotosEntrada();
	    }
	 @Before
	 public  void inicializarVariables() {
		 listaTemasCopiaAuxiliar = new ArrayList<TemaEntity>();
		 for (TemaEntity tema :listaTemasOriginal) {
			 TemaEntity t = new TemaEntity(tema.getTema(), tema.getPregunta());
			 listaTemasCopiaAuxiliar.add(t);
		 }
		 
	 }
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

	    
	    
	    @Test
	    public void testCreate() {
	    	temasAux = new ArrayList<TemaEntity>();
	        for(int i=0;i<listaTemasCopiaAuxiliar.size();i++){
	            TemaEntity tema = listaTemasCopiaAuxiliar.get(i);
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
	    	insertamosTemasSinVoto();
	         temasAux = new ArrayList<TemaEntity>();
		        for(int i=0;i<listaTemasCopiaAuxiliar.size();i++){
		            TemaEntity tema = listaTemasCopiaAuxiliar.get(i);
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
	    	insertamosTemasSinVoto();
	         temasAux = new ArrayList<TemaEntity>();
		        for(int i=0;i<listaTemasCopiaAuxiliar.size();i++){
		            TemaEntity tema = listaTemasCopiaAuxiliar.get(i);
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
	    	insertamosTemasSinVoto();
	   temasAux = new ArrayList<TemaEntity>();
		        for(int i=0;i<listaTemasCopiaAuxiliar.size();i++){
		            TemaEntity tema = listaTemasCopiaAuxiliar.get(i);
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
	    public void testDeleteConVoto() {
	    	insertamosRegistrosConVoto();
	    	
	    	temasAux = new ArrayList<TemaEntity>();
	        for(int i=0;i<listaTemasCopiaAuxiliar.size();i++){
	            TemaEntity tema = listaTemasCopiaAuxiliar.get(i);
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
	    public void testCreateConVoto() {
	    	insertamosRegistrosConVoto();
	        List<TemaEntity> temasRecuperadosDeBaseDeDatos = dao.findAll();
	        for (TemaEntity temaBBDD : temasRecuperadosDeBaseDeDatos) {
	            assertFalse(temasRecuperadosDeBaseDeDatos.contains(temaBBDD));
	        }
	        assertTrue(temasRecuperadosDeBaseDeDatos.size() != 0);
	        assertTrue(temasRecuperadosDeBaseDeDatos.size() != temasAux.size());
	    } 
	    
		private void insertamosRegistrosConVoto(){
			VotoEntity voto = null ;
	    	temasAux = new ArrayList<TemaEntity>();
	        for(int i=0;i<listaTemasCopiaAuxiliar.size();i++){
	            TemaEntity tema = listaTemasCopiaAuxiliar.get(i);
	        	if (tema != null) {
	                if(i<listaVotos.size() && listaVotos.get(i) != null) {
						 voto = listaVotos.get(i);
						tema.getVotos().add(voto);
					}
	       
	                System.out.println("!!!tema con voto : " + tema.toString());
	                dao.create(tema);
	                temasAux.add(tema);
	            }
	        }
			
		}  
	    
	private void insertamosTemasSinVoto(){
		temasAux = new ArrayList<TemaEntity>();
        for(int i=0;i<listaTemasCopiaAuxiliar.size();i++){
            TemaEntity tema = listaTemasCopiaAuxiliar.get(i);
        	if (tema != null) {
                System.out.println("!!!tema : " + tema.toString());
                dao.create(tema);
                
            }
        }
		
	}

	}

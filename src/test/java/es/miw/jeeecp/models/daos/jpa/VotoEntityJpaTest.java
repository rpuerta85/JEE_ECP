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
import es.miw.jeeecp.models.daos.VotoDao;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public class VotoEntityJpaTest {

	    private VotoDao dao = DaoJpaFactory.getFactory().getVotoDao();

	    private static VotoEntityJpaDataTest votoEntityJpaDataTest;
	    private static List<VotoEntity> listaVotosOriginal;
	    private static List<VotoEntity> listaVotosCopiaAuxiliar;
	    
	    private List<VotoEntity> votosAux;
	    
	    private static List<VotoEntity> listaVotos;
	    
	    
	    @BeforeClass
	    public static void inti() {
	        //Se borrar y se crean las tablas
	         Map<String, String> properties = new HashMap<>();
	         properties. put(PersistenceUnitProperties.DDL_GENERATION,
	                 PersistenceUnitProperties.DROP_AND_CREATE);
	         EntityManager em = Persistence.createEntityManagerFactory("BBDD", properties)
	                 .createEntityManager();
	    	
	    	votoEntityJpaDataTest = new VotoEntityJpaDataTest();
	    	listaVotosOriginal = votoEntityJpaDataTest.getListaVotosEntrada();
	    
	    	
	    	listaVotos = new VotoEntityJpaDataTest().getListaVotosEntrada();
	    }
	 @Before
	 public  void inicializarVariables() {
		 listaVotosCopiaAuxiliar = new ArrayList<VotoEntity>();
		 for (VotoEntity voto :listaVotosOriginal) {
			 VotoEntity v = new VotoEntity(voto.getIp(), voto.getNota(),voto.getEstudios());
			 listaVotosCopiaAuxiliar.add(v);
		 }
		 
	 }
	    @After
	    public void borrarRegistros() {
	    	 //Se borrar los datos insertados en los tests
	    	VotoDao dao = DaoJpaFactory.getFactory().getVotoDao();
	    	List<VotoEntity> votosRecuperadosDeBaseDeDatos = dao.findAll();
		        for (VotoEntity votoBBDD : votosRecuperadosDeBaseDeDatos) {
		           dao.deleteById(votoBBDD.getId() );
		           System.out.println("!!!borrando voto : " + votoBBDD.getId().toString());
		        }
		        
		        
	    }

	    
	    
	    @Test
	    public void testCreate() {
	    	votosAux = new ArrayList<VotoEntity>();
	        for(int i=0;i<listaVotosCopiaAuxiliar.size();i++){
	            VotoEntity voto = listaVotosCopiaAuxiliar.get(i);
	        	if (voto != null) {
	                System.out.println("!!!voto : " + voto.toString());
	                dao.create(voto);
	                votosAux.add(voto);
	            }
	        }
	        
	        List<VotoEntity> votosRecuperadosDeBaseDeDatos = dao.findAll();
	        for (VotoEntity votoBBDD : votosRecuperadosDeBaseDeDatos) {
	            assertTrue(votosRecuperadosDeBaseDeDatos.contains(votoBBDD));
	        }
	        assertTrue(votosRecuperadosDeBaseDeDatos.size() == votosAux.size());
	    }

	    
	    @Test
	    public void testUpdate() {
	    	insertamosVoto();
	         votosAux = new ArrayList<VotoEntity>();
		        for(int i=0;i<listaVotosCopiaAuxiliar.size();i++){
		            VotoEntity voto = listaVotosCopiaAuxiliar.get(i);
		            voto.setEstudios("voto actualizado");
		        	if (voto != null) {
		                System.out.println("!!!voto actualizado : " + voto.toString());
		                dao.update(voto);
		                votosAux.add(voto);
		            }
		        }
		        
		        List<VotoEntity> votosRecuperadosDeBaseDeDatos = dao.findAll();
		        for (VotoEntity votoBBDD : votosRecuperadosDeBaseDeDatos) {
		            assertTrue(votosRecuperadosDeBaseDeDatos.contains(votoBBDD));
		        }
		        assertTrue(votosRecuperadosDeBaseDeDatos.size() == votosAux.size());
	    }

	   
	    
	    @Test
	    public void testDeleteByID() {
	    	insertamosVoto();
	         votosAux = new ArrayList<VotoEntity>();
		        for(int i=0;i<listaVotosCopiaAuxiliar.size();i++){
		            VotoEntity voto = listaVotosCopiaAuxiliar.get(i);
		        	if (voto != null) {
		                System.out.println("!!!voto borrado : " + voto.toString());
		                dao.deleteById(voto.getId()); 
		                votosAux.add(voto);
		            }
		        }
		        List<VotoEntity> votosRecuperadosDeBaseDeDatos = dao.findAll();
		        for (VotoEntity votoBBDD : votosRecuperadosDeBaseDeDatos) {
		            assertFalse(votosRecuperadosDeBaseDeDatos.contains(votoBBDD));
		        }
		        assertTrue(votosRecuperadosDeBaseDeDatos.size() == 0);
		        assertTrue(votosRecuperadosDeBaseDeDatos.size() != votosAux.size());
	    }

	    @Test
	    public void testRead() {
	    	insertamosVoto();
	   votosAux = new ArrayList<VotoEntity>();
		        for(int i=0;i<listaVotosCopiaAuxiliar.size();i++){
		            VotoEntity voto = listaVotosCopiaAuxiliar.get(i);
		        	if (voto != null) {
		                System.out.println("!!!voto leido : " + voto.toString());
		                dao.read(voto.getId()); 
		                votosAux.add(voto);
		            }
		        }
		        
		        List<VotoEntity> votosRecuperadosDeBaseDeDatos = dao.findAll();
		        for (VotoEntity votoBBDD : votosRecuperadosDeBaseDeDatos) {
		            assertTrue(votosRecuperadosDeBaseDeDatos.contains(votoBBDD));
		        }
		     
		        assertTrue(votosRecuperadosDeBaseDeDatos.size() == votosAux.size());
	    	
	    }
	    
	    
	private void insertamosVoto(){
		votosAux = new ArrayList<VotoEntity>();
        for(int i=0;i<listaVotosCopiaAuxiliar.size();i++){
        	VotoEntity voto = listaVotosCopiaAuxiliar.get(i);
        	if (voto != null) {
                System.out.println("!!!voto : " + voto.toString());
                dao.create(voto);
                
            }
        }
		
	}

	}

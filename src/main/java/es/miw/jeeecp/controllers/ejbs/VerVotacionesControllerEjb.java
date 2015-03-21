package es.miw.jeeecp.controllers.ejbs;

import java.util.HashMap;
import java.util.List;

import es.miw.jeeecp.controllers.VerVotacionesController;
import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.utils.ListaVotosAsociadosAUnEstudio;
import es.miw.jeeecp.models.utils.VotacionMediaPorEstudios;

public class VerVotacionesControllerEjb extends ControllerEjb implements VerVotacionesController  {

	public VerVotacionesControllerEjb() {
        super();
    }

	@Override
	public List<TemaEntity> obtenerVotosPorTema() {
		
		
		return null;
	}
	
	  public HashMap<String, ListaVotosAsociadosAUnEstudio> votacionMediaSegunNivelEstudios(){
		  VotacionMediaPorEstudios  mediaPorEstudios = new VotacionMediaPorEstudios();
		  List<TemaEntity> listaTemas = DaoJpaFactory.getFactory().getTemaDao().findAll();
		  mediaPorEstudios.setMapaEstudios(listaTemas);
		 return mediaPorEstudios.getMapaEstudios();
		  
	  }
	
}

package es.miw.jeeecp.controllers.ejbs;

import java.util.List;

import es.miw.jeeecp.controllers.AniadirTemaController;
import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;
import es.miw.jeeecp.models.entities.TemaEntity;


public class AniadirTemaControllerEjb extends ControllerEjb implements AniadirTemaController {

	public AniadirTemaControllerEjb() {
        super();
    }
	@Override
	public boolean aniadirTema(TemaEntity tema) {
		boolean exito = false;
		TemaDao temaDao =  DaoJpaFactory.getFactory().getTemaDao();
		List<TemaEntity> listaVotosConIp =  temaDao.findByName(tema.getTema());
		if(listaVotosConIp.size()==0) {
			temaDao.create(tema);
			exito = true;
		
	    }
		return exito;
	}

	
}

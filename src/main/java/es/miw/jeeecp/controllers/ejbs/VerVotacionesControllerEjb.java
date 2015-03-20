package es.miw.jeeecp.controllers.ejbs;

import java.util.List;

import es.miw.jeeecp.controllers.VerVotacionesController;
import es.miw.jeeecp.controllers.VotarController;
import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.daos.VotoDao;
import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;
import es.miw.jeeecp.models.daos.jpa.VotoDaoJpa;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public class VerVotacionesControllerEjb extends ControllerEjb implements VerVotacionesController  {

	public VerVotacionesControllerEjb() {
        super();
    }

	@Override
	public List<TemaEntity> obtenerVotosPorTema() {
		return null;
	}

	
}

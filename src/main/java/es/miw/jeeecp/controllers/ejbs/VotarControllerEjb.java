package es.miw.jeeecp.controllers.ejbs;

import java.util.List;

import es.miw.jeeecp.controllers.VotarController;
import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;
import es.miw.jeeecp.models.entities.TemaEntity;

public class VotarControllerEjb extends ControllerEjb implements VotarController {

//	VotarControllerEjb(Session session) {
//        super(session);
//    }
	VotarControllerEjb() {
        super();
    }

	@Override
	public List<TemaEntity> mostrarTemas() {
		List<TemaEntity> listaTemas = DaoJpaFactory.getFactory().getTemaDao().findAll();		
		return listaTemas;
	}

	@Override
	public void mostrarPregunta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean votar() {
		// TODO Auto-generated method stub
		return false;
	}

	
}

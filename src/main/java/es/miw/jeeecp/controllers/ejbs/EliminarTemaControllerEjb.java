package es.miw.jeeecp.controllers.ejbs;

import es.miw.jeeecp.controllers.EliminarTemaController;
import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;


public class EliminarTemaControllerEjb extends ControllerEjb implements EliminarTemaController {

	public EliminarTemaControllerEjb() {
        super();
    }
	
	@Override
	public boolean eliminarTema(int idTema) {
		boolean exito = false;
		TemaDao temaDao =  DaoJpaFactory.getFactory().getTemaDao();
		try {
			temaDao.deleteById(idTema);
			exito = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exito;
	}

	
}

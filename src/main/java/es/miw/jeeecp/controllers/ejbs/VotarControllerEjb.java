package es.miw.jeeecp.controllers.ejbs;

import java.util.List;

import es.miw.jeeecp.controllers.VotarController;
import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.daos.VotoDao;
import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;
import es.miw.jeeecp.models.daos.jpa.VotoDaoJpa;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

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
	public boolean votar(TemaEntity tema,VotoEntity voto) {
		//DaoJpaFactory.getFactory().getVotoDao().read(voto.getIp())
		//findByIp
		 boolean exito = false;
		TemaDao temaDao =  DaoJpaFactory.getFactory().getTemaDao();
		List<VotoEntity> listaVotosConIp =  temaDao.findByIp(voto.getIp());
		if(listaVotosConIp.size()==0) {
			tema.getVotos().add(voto);
			temaDao.update(tema);
			exito = true;
		}
		
		return exito;

	}

	
}

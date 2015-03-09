package es.miw.jeeecp.models.daos.jpa;

import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.entities.TemaEntity;

public class TemaDaoJpa extends GenericDaoJpa<TemaEntity, Integer> implements TemaDao {

    public TemaDaoJpa() {
        super(TemaEntity.class);
    }

    
}

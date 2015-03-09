package es.miw.jeeecp.models.daos.jpa;

import es.miw.jeeecp.models.daos.VotoDao;
import es.miw.jeeecp.models.entities.VotoEntity;
public class VotoDaoJpa extends GenericDaoJpa<VotoEntity, Integer> implements VotoDao {

    public VotoDaoJpa() {
        super(VotoEntity.class);
    }

    
}

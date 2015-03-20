package es.miw.jeeecp.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.miw.jeeecp.models.daos.VotoDao;
import es.miw.jeeecp.models.entities.VotoEntity;
public class VotoDaoJpa extends GenericDaoJpa<VotoEntity, Integer> implements VotoDao {
  
	 

	
    public VotoDaoJpa() {
        super(VotoEntity.class);
    }

   
}

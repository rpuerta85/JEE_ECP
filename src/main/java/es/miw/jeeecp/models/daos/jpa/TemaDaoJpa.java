package es.miw.jeeecp.models.daos.jpa;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public class TemaDaoJpa extends GenericDaoJpa<TemaEntity, Integer> implements TemaDao {
	 private static final String BUSCAR_VOTO_POR_IP = "SELECT t FROM TemaEntity t JOIN t.votos v where v.ip = :ip and t.id = :idTema";
	
	// private static final String BUSCAR_TEMAS_GROUPBY_TEMA_NIVELESTUDIOS = "SELECT t.id,v.estudios, SUM(v.nota) FROM TemaEntity t JOIN t.votos v GROUP BY t.id,v.estudios ";	 
    
	
	 
	 
	 public TemaDaoJpa() {
        super(TemaEntity.class);
    }
    public List<VotoEntity> findByIp(String ip,Integer idTema) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery(BUSCAR_VOTO_POR_IP);
        query.setParameter("ip", ip);
        query.setParameter("idTema", idTema);
        List<VotoEntity> listaResultado =(List<VotoEntity>) query.getResultList();
        entityManager.close();
        return listaResultado;
    }
  

}

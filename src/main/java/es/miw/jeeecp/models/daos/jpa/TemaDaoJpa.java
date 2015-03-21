package es.miw.jeeecp.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import es.miw.jeeecp.models.daos.TemaDao;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public class TemaDaoJpa extends GenericDaoJpa<TemaEntity, Integer> implements TemaDao {
	 private static final String BUSCAR_VOTO_POR_IP = "SELECT t FROM TemaEntity t JOIN t.votos v where v.ip = :ip and t.id = :idTema";
	 private static final String BUSCAR_TEMA_POR_NOMBRE = "SELECT t FROM TemaEntity t where t.tema = :nombreTema";

	 
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
    public List<TemaEntity> findByName(String name) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery(BUSCAR_TEMA_POR_NOMBRE);
        query.setParameter("nombreTema", name);
        List<TemaEntity> listaResultado =(List<TemaEntity>) query.getResultList();
        entityManager.close();
        return listaResultado;
    }
  

}

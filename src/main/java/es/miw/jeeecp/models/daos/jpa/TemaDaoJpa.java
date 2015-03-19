package es.miw.jeeecp.models.daos.jpa;

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
	 private static final String BUSCAR_VOTO_POR_IP = "SELECT t FROM TemaEntity t JOIN t.votos v where v.ip = :ip ";
    public TemaDaoJpa() {
        super(TemaEntity.class);
    }
    public List<VotoEntity> findByIp(String ip) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery(BUSCAR_VOTO_POR_IP);
        query.setParameter("ip", ip);
        List<VotoEntity> listaResultado =(List<VotoEntity>) query.getResultList();
        entityManager.close();
        return listaResultado;
    	
//    	 EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
//    	 // Se crea un criterio de consulta
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<TemaEntity> query = builder.createQuery(TemaEntity.class);
//        // Se establece la clausula FROM
//        Root<TemaEntity> root = query.from(TemaEntity.class);
//        // Se establece la clausula SELECT
//        query.select(root);
//        // Se configura el predicado
//        Predicate predicate = builder.equal(root.get("ip").as(VotoEntity.class),
//        		ip);
//        // Se establece el WHERE
//        query.where(predicate);
//        // Se crea el resultado
//        TypedQuery<PieceEntity> typedQuery = entityManager.createQuery(query);
//        PieceEntity pieceEntity = typedQuery.getSingleResult();
//        entityManager.close();
//        if (pieceEntity != null) {
//            this.deleteById(pieceEntity.getId());
//        }
    }
    
}

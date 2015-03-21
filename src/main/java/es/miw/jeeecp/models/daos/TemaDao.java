package es.miw.jeeecp.models.daos;

import java.util.List;

import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

public interface TemaDao extends GenericDao<TemaEntity , Integer> {
	 public List<VotoEntity> findByIp(String ip,Integer idTema);
	 public List<TemaEntity> findByName(String name); 
}

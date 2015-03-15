package es.miw.jeeecp.view.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.miw.jeeecp.models.daos.jpa.DaoJpaFactory;
import es.miw.jeeecp.models.daos.jpa.GenericDaoJpa;
import es.miw.jeeecp.models.entities.TemaEntity;

@ManagedBean
public class VotarView {
    private String errorMsg;

   private List<TemaEntity> listaTemas;
    
    public VotarView() {
    }


    public void update() {
       this.listaTemas = DaoJpaFactory.getFactory().getTemaDao().findAll();
    	LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar los temas");
        //this.roles = new String[] {"uno", "dos", "tres"};
    }

    public String process() {
//        if (this.persona.getId() == 666 && !this.persona.getNombre().equals("Demonio")) {
//            this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
//            return "persona";
//        } else {
//            LogManager.getLogger(VotarView.class).debug(
//                    "Se accede a la capa de negocio para registrar persona: " + persona);
//            return "home";
//        }
  return "";
    }

}

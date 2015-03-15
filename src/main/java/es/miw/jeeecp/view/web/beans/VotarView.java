package es.miw.jeeecp.view.web.beans;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

@ManagedBean
public class VotarView {
    private String errorMsg;

    public VotarView() {
    }

   

    public void update() {
        LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
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

package es.miw.jeeecp.view.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;
import es.miw.jeeecp.models.entities.TemaEntity;

@ManagedBean
public class VotarView extends ViewBean {
    private String errorMsg;

   private List<TemaEntity> listaTemas;
    
    public VotarView() {
    }


    public void update() {
    	LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar los temas");
        this.listaTemas =this.getControllerFactory().getVotarController().mostrarTemas();

    	
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


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public List<TemaEntity> getListaTemas() {
		return listaTemas;
	}


	public void setListaTemas(List<TemaEntity> listaTemas) {
		this.listaTemas = listaTemas;
	}

}

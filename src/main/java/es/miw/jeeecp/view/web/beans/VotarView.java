package es.miw.jeeecp.view.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;
import es.miw.jeeecp.models.entities.TemaEntity;

@ManagedBean
public class VotarView extends ViewBean {
    private String errorMsg;

   private List<TemaEntity> listaTemas;
   
   private List<String> listaNivelEstudios;
    
    public VotarView() {
    	//super(ControllerEjbFactory.getInstance());
    	//this.
    }


    public void update() {
    	LogManager.getLogger(VotarView.class).debug(
                "Se accede a la capa de negocio para recuperar los temas");
        this.listaTemas =ControllerEjbFactory.getInstance().getVotarController().mostrarTemas();
        inicializarListaEstudios();        	

    }

    public String process() {
//        if (this.persona.getId() == 666 && !this.persona.getNombre().equals("Demonio")) {
//            this.errorMsg = "SÃ³lo se acepta el nombre 'Demonio'";
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
	
	public List<String> getListaNivelEstudios() {
		return listaNivelEstudios;
	}


	public void setListaNivelEstudios(List<String> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}


	private void inicializarListaEstudios(){
		listaNivelEstudios = new ArrayList<String>();
        listaNivelEstudios.add("E.S.O");
        listaNivelEstudios.add("Formación Profesional Grado Medio");
        listaNivelEstudios.add("Bachillerato");
        listaNivelEstudios.add("Formación Profesional Grado Superior");
        listaNivelEstudios.add("Ingeniería técnica");
        listaNivelEstudios.add("Master");
        listaNivelEstudios.add("Otros");
 
       
	}

}

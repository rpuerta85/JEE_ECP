package es.miw.jeeecp.view.web.beans;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

//import org.apache.logging.log4j.LogManager;



import org.apache.logging.log4j.LogManager;

import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.utils.ListaVotosAsociadosAUnEstudio;



@ManagedBean
public class VerVotosView extends ViewBean {
    private String msg;
    private  HashMap<String, ListaVotosAsociadosAUnEstudio> mapVotacionMediaSegunNivelEstudios;
    private List<TemaEntity> listaTemas;

    
    public VerVotosView() {
    	super();
    }

    @PostConstruct
    public void update() {
    	LogManager.getLogger(VerVotosView.class).debug(
                "Se accede a la capa de negocio para recuperar la votacion por cada estudio");
    	 mapVotacionMediaSegunNivelEstudios =
    			 ControllerEjbFactory.getInstance().getVerVotacionesController().votacionMediaSegunNivelEstudios();
    	 this.listaTemas = ControllerEjbFactory.getInstance().getVotarController().mostrarTemas();
    }

    public String process() {
    
    	return "";
    }


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public HashMap<String, ListaVotosAsociadosAUnEstudio> getMapVotacionMediaSegunNivelEstudios() {
		return mapVotacionMediaSegunNivelEstudios;
	}


	public void setMapVotacionMediaSegunNivelEstudios(
			HashMap<String, ListaVotosAsociadosAUnEstudio> mapVotacionMediaSegunNivelEstudios) {
		this.mapVotacionMediaSegunNivelEstudios = mapVotacionMediaSegunNivelEstudios;
	}


	public List<TemaEntity> getListaTemas() {
		return listaTemas;
	}


	public void setListaTemas(List<TemaEntity> listaTemas) {
		this.listaTemas = listaTemas;
	}



	
}

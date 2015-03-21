package es.miw.jeeecp.view.web.beans;

import javax.faces.bean.ManagedBean;

import es.miw.jeeecp.controllers.AniadirTemaController;
import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;
import es.miw.jeeecp.models.entities.TemaEntity;


@ManagedBean
public class AniadirTemaView extends ViewBean {
    private String msg;  
   
   private TemaEntity temaRecibidoFormulario;
   
   boolean exitoInserccionTema;
    
   public AniadirTemaView() {
    	super();
    	
    }

	public void update() {
    	
    }

    public String process() {
    	String ret = "";
    	AniadirTemaController aniadirTemaController = ControllerEjbFactory.getInstance().getAniadirTemaController();
    	this.exitoInserccionTema = aniadirTemaController.aniadirTema(temaRecibidoFormulario);
    	if(exitoInserccionTema)  ret = "Tema insertado correctamente";
    	else ret = "Ya existe un tema en base de datos con ese mismo nombre. El tema no se ha insertado";
    	this.msg = ret;
        return ""; // no devolvemos nada ya que es peticion ASINCRONA CON AJAX y no redireccionamos al DISPATCHE A ningun lugar
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public TemaEntity getTemaRecibidoFormulario() {
		return temaRecibidoFormulario;
	}

	public void setTemaRecibidoFormulario(TemaEntity temaRecibidoFormulario) {
		this.temaRecibidoFormulario = temaRecibidoFormulario;
	}

	public boolean isExitoInserccionTema() {
		return exitoInserccionTema;
	}

	public void setExitoInserccionTema(boolean exitoInserccionTema) {
		this.exitoInserccionTema = exitoInserccionTema;
	}


	


	

	
}

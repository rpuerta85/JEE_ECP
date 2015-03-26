package es.miw.jeeecp.view.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.miw.jeeecp.controllers.AniadirTemaController;
import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;
import es.miw.jeeecp.models.entities.TemaEntity;


@ManagedBean
//@SessionScoped
public class AniadirTemaView extends ViewBean {
    private String msg;  
   
   private TemaEntity temaRecibidoFormulario;
   
   boolean exitoInserccionTema;
    
   public AniadirTemaView() {
    	super();
    	
    	
    }

   @PostConstruct
   public void init() {
       // lo ponemos en el POSTCONTRUCT para que esta inicialización solo tenga efecto despues de las inyecciones
	   // y utilizando el framework JSF
	   this.temaRecibidoFormulario = new TemaEntity();
   }
	public void update() {
    	
    }

    public String process() {
    	String ret = "";
    	this.msg="";
    	//System.out.println(temaRecibidoFormulario.getPregunta().equals("null"));
     //	System.out.println(temaRecibidoFormulario.getPregunta()==null);
    	if(temaRecibidoFormulario!=null && temaRecibidoFormulario.getPregunta()!=null ){
    	AniadirTemaController aniadirTemaController = ControllerEjbFactory.getInstance().getAniadirTemaController();
    	this.exitoInserccionTema = aniadirTemaController.aniadirTema(temaRecibidoFormulario);
    	if(exitoInserccionTema)  ret = "Tema insertado correctamente";
    	else ret = "Ya existe un tema en base de datos con ese mismo nombre. El tema no se ha insertado";
    	}
    	this.msg = ret;
    	
        return msg; // no devolvemos nada ya que es peticion ASINCRONA CON AJAX y no redireccionamos al DISPATCHE A ningun lugar
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

package es.miw.jeeecp.view.web.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import org.apache.logging.log4j.LogManager;
import es.miw.jeeecp.controllers.EliminarTemaController;
import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;
import es.miw.jeeecp.models.entities.TemaEntity;


@ManagedBean
public class EliminarTemaView extends ViewBean {
    private String msg;

   private List<TemaEntity> listaTemas;
   
   private int idTema;

   boolean temaEliminado;
    
   public EliminarTemaView() {
	   super();
    	
    }
    public void update() {
    	LogManager.getLogger(EliminarTemaView.class).debug(
                "Se accede a la capa de negocio para recuperar los temas");
        if(this.listaTemas== null) {
        	this.listaTemas =ControllerEjbFactory.getInstance().getVotarController().mostrarTemas();
        }
        }

    public String process() {
    	String ret = "";
    	EliminarTemaController eliminarTemaController = ControllerEjbFactory.getInstance().getEliminarTemaController(); 
    	this.temaEliminado = eliminarTemaController.eliminarTema(this.idTema);
    	if(temaEliminado)  ret = "Tema borrado correctamente";
    	else ret = "Error: El tema no se ha eliminado- Contacte con el administrador.";
    	this.msg = ret;
   
    return "";
    //no devolvemos nada ya que es peticion ASINCRONA CON AJAX y no redireccionamos al DISPATCHE A ningun lugar desde servidor, lo hacemos desde cliente
    }




	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public List<TemaEntity> getListaTemas() {
		return listaTemas;
	}


	public void setListaTemas(List<TemaEntity> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public int getIdTema() {
		return idTema;
	}
	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	public boolean isTemaEliminado() {
		return temaEliminado;
	}


	public void setTemaEliminado(boolean temaEliminado) {
		this.temaEliminado = temaEliminado;
	}
	
	



}
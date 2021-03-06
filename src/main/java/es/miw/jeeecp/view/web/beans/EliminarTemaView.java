package es.miw.jeeecp.view.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;

import es.miw.jeeecp.controllers.EliminarTemaController;
import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;
import es.miw.jeeecp.models.entities.TemaEntity;


@ManagedBean
public class EliminarTemaView extends ViewBean {
	private String msg;

   private List<TemaEntity> listaTemas;
   private Integer idTema;

   boolean temaEliminado;
    
   public EliminarTemaView() {
	   super();
	   
    	
    }
   @PostConstruct
   public void init(){
	//RECOPGEMOS EL VALRO DEL HIDDEN
	  String idTema = FacesContext.getCurrentInstance().
				getExternalContext().getRequestParameterMap().get("idTema2");
	  if(idTema!=null) { 
	   this.idTema = Integer.parseInt(idTema);
	  }
	  if(this.listaTemas== null) {
	      	this.listaTemas =ControllerEjbFactory.getInstance().getVotarController().mostrarTemas();
	      }
	 
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
    	if(this.idTema!=null){
    	this.temaEliminado = eliminarTemaController.eliminarTema(this.idTema);
    	if(temaEliminado)  ret = "Tema borrado correctamente";
    	else ret = "Error: El tema no se ha eliminado- Contacte con el administrador.";
    	}
    	this.msg = ret;
   
    return msg;//devolvemos el mensaje en vez la redireccione a una pagina ya que los estamos haciendo por ajax
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

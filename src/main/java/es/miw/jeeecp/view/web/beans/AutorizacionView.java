package es.miw.jeeecp.view.web.beans;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AutorizacionView extends ViewBean {
   private String msg;

  private String codAutorizacion;
  private boolean autorizado = false;

  
   public AutorizacionView() {
	   super();
    	
    }


    public void update() {
    	/*LogManager.getLogger(AutorizacionView.class).debug(
                "Se accede a la capa de negocio para comprobar el código de autorización");*/
       
        
    }

    public String process() {
    	String ret = "";
    	if (this.codAutorizacion.equals("666")) {
    		ret = "eliminarTema";
    		this.autorizado = true;
    	}else {
    		ret = "autorizacion";
    		this.msg = "Código de autorización incorrecto. No tiene permisos.";
    	}
    	

    	return ret;
    }


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getCodAutorizacion() {
		return codAutorizacion;
	}


	public void setCodAutorizacion(String codAutorizacion) {
		this.codAutorizacion = codAutorizacion;
	}


	public boolean isAutorizado() {
		return autorizado;
	}


	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}


	
}

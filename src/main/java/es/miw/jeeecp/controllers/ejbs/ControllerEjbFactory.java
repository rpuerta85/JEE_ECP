package es.miw.jeeecp.controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.miw.jeeecp.controllers.AniadirTemaController;
import es.miw.jeeecp.controllers.ControllerFactory;
import es.miw.jeeecp.controllers.EliminarTemaController;
import es.miw.jeeecp.controllers.VerVotacionesController;
import es.miw.jeeecp.controllers.VotarController;


@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {

    private  VotarController votarController;
    private  VerVotacionesController verVotacionesController;
    private  AniadirTemaController aniadirTemaController;
    private  EliminarTemaController eliminarTemaController;

    
    private static ControllerEjbFactory singleton;

  public ControllerEjbFactory() {
	  super();
  }
  
  //singleton hasta que utilicemos JSF, el cual lo haremos por anotaciones
    public static ControllerEjbFactory getInstance() {
    	if(singleton==null)
    		singleton = new ControllerEjbFactory();
    	return singleton;
}



	@Override
    public  VotarController getVotarController() {
        if (votarController == null) {
        	votarController = new VotarControllerEjb();
        }
        return votarController;
    }
	@Override
	public VerVotacionesController getVerVotacionesController() {
		 if (verVotacionesController == null) {
			 verVotacionesController = new VerVotacionesControllerEjb();
	        }
	        return verVotacionesController;
	}

	@Override
	public AniadirTemaController getAniadirTemaController() {
		 if (aniadirTemaController == null) {
			 aniadirTemaController = new AniadirTemaControllerEjb();
	        }
	        return aniadirTemaController;
	}

	@Override
	public EliminarTemaController getEliminarTemaController() {
		if (eliminarTemaController == null) {
			eliminarTemaController = new EliminarTemaControllerEjb();
	        }
	        return eliminarTemaController;
	}

	

}

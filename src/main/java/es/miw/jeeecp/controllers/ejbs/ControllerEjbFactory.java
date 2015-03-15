package es.miw.jeeecp.controllers.ejbs;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import es.miw.jeeecp.controllers.ControllerFactory;
import es.miw.jeeecp.controllers.VotarController;


@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {

   // private Session jeeEcpSession;

    private  VotarController votarController;
    private static ControllerEjbFactory singleton;
    
//    private LogoutController logoutController;
//
//    private CreateGameController createGameController;
//
//    private OpenGameController openGameController;
//
//    private ShowGameController showGameController;
//
//    private PlacePieceController placePieceController;
//
//    private SaveGameController saveGameController;

//    public ControllerEjbFactory() {
//    	jeeEcpSession = new Session();
//    }
  private ControllerEjbFactory() {
	 // this.singleton = new ControllerEjbFactory();
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

   

}

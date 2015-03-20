package es.miw.jeeecp.view.web.beans;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;



@ManagedBean
public class VerVotosView extends ViewBean {
    private String msg;
    
    

    
    public VerVotosView() {
    	super();
    }


    public void update() {
    	LogManager.getLogger(VerVotosView.class).debug(
                "Se accede a la capa de negocio para recuperar los votos de cada tema");
       
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



	
}

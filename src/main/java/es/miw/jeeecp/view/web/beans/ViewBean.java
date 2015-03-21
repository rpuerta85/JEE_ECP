package es.miw.jeeecp.view.web.beans;

import javax.faces.bean.ManagedProperty;

import com.google.gson.Gson;

import es.miw.jeeecp.controllers.ControllerFactory;
import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;


public abstract class ViewBean {

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory ;

    
    
//    public ViewBean(ControllerFactory controllerFactor) {
//		this.controllerFactory = controllerFactor;
//	}

	public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }
    
    public String toJsonString(){
    	return new Gson().toJson(this);
    }
    public <T> T jsonStringToObject(Class<T> clase,String json){
    	T tipo = new Gson().fromJson(json, clase);
    	return tipo;
    }



}

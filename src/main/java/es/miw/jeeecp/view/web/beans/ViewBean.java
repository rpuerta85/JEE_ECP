package es.miw.jeeecp.view.web.beans;

import javax.faces.bean.ManagedProperty;

import es.miw.jeeecp.controllers.ControllerFactory;


public abstract class ViewBean {

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
        return controllerFactory;
    }

}
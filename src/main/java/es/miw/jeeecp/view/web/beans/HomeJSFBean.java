package es.miw.jeeecp.view.web.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeJSFBean {
    private String name="Hola, desde Bean. OK!!!";

    public String getName() {
        return name;
    }
}

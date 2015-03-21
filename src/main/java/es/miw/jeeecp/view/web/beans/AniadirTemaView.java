package es.miw.jeeecp.view.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import com.google.gson.Gson;

import es.miw.jeeecp.controllers.AniadirTemaController;
import es.miw.jeeecp.controllers.VotarController;
import es.miw.jeeecp.controllers.ejbs.ControllerEjbFactory;
import es.miw.jeeecp.models.entities.TemaEntity;
import es.miw.jeeecp.models.entities.VotoEntity;

@ManagedBean
public class AniadirTemaView extends ViewBean {
    private String msg;  
   
   private TemaEntity temaRecibidoFormulario;
   
   boolean exitoInserccionTema;
    
   public AniadirTemaView() {
    	super();
    	
    }

    public void update() {
    	
    }

    public String process() {
    	String ret = "";
    	AniadirTemaController aniadirTemaController = ControllerEjbFactory.getInstance().getAniadirTemaController();
    	this.exitoInserccionTema = aniadirTemaController.aniadirTema(temaRecibidoFormulario);
    	if(exitoInserccionTema)  ret = "Voto insertado correctamente";
    	else ret = "Ya existe un tema en base de datos con ese mismo nombre. El tema no se ha insertado";
    	this.msg = ret;
        return ""; // no devolvemos nada ya que es peticion ASINCRONA CON AJAX y no redireccionamos al DISPATCHE A ningun lugar
    }


	


	public boolean getVotoInsertado() {
		return votoInsertado;
	}


	public void setVotoInsertado(boolean votoInsertado) {
		this.votoInsertado = votoInsertado;
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
	
	public List<String> getListaNivelEstudios() {
		return listaNivelEstudios;
	}


	public void setListaNivelEstudios(List<String> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}


	public List<String> getListaNotas() {
		return listaNotas;
	}


	public void setListaNotas(List<String> listaNotas) {
		this.listaNotas = listaNotas;
	}


	public TemaEntity getTemaRecibidoFormulario() {
		return temaRecibidoFormulario;
	}


	public void setTemaRecibidoFormulario(TemaEntity temaRecibidoFormulario) {
		this.temaRecibidoFormulario = temaRecibidoFormulario;
	}


	public VotoEntity getVotoRecibidoFormulario() {
		return votoRecibidoFormulario;
	}


	public void setVotoRecibidoFormulario(VotoEntity votoRecibidoFormulario) {
		this.votoRecibidoFormulario = votoRecibidoFormulario;
	}


	private void inicializarListaEstudios(){
		listaNivelEstudios = new ArrayList<String>();
        listaNivelEstudios.add("E.S.O");
        listaNivelEstudios.add("Formación Profesional Grado Medio");
        listaNivelEstudios.add("Bachillerato");
        listaNivelEstudios.add("Formación Profesional Grado Superior");
        listaNivelEstudios.add("Ingeniería técnica");
        listaNivelEstudios.add("Master");
        listaNivelEstudios.add("Otros");
 
       
	}
private void inicializarListaNotas(){
	listaNotas = new ArrayList<String>();
	for(int i = 0;i<11;i++){
		listaNotas.add(i+"");
	}
}

	
}

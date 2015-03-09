package es.miw.jeeecp.models.entities;
//package es.art83.persistence.models.entities;
//
//import java.io.Serializable;
//import java.lang.String;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//
//
//@Entity
//public class Usuario implements Serializable{
//
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 4607032942068646243L;
//
//	@Id
//	private String ip;
//	
//	@ManyToMany(cascade = {CascadeType.ALL},mappedBy="votos")
//	
//	private List<Tema> temas = new ArrayList<Tema>();
//    
//    public Usuario(String ip) {
//        this.ip = ip;
//    }
//   
//    public Usuario() {
//        super();
//    }
//
//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//
//
//	public List<Tema> getTemas() {
//		return temas;
//	}
//
//	public void setTemas(List<Tema> temas) {
//		this.temas = temas;
//	}
//
//	@Override
//    public String toString() {
//        return "User[" + ip + ":" + ":"+temas +"]";
//    }
//
//}

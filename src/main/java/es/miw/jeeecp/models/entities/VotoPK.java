package es.miw.jeeecp.models.entities;
//package es.art83.persistence.models.entities;
//
//import java.io.Serializable;
//
//import javax.persistence.Embeddable;
//import javax.persistence.OneToOne;
//@Embeddable
//public class VotoPK implements Serializable{
//     private static final long serialVersionUID = 1L;
//     
//     private String ip;
//     
//     private Tema tema;
//
//    public VotoPK() {
//    }
//
//    public VotoPK(String ip, Tema tema) {
//        super();
//        this.tema = tema;
//        this.ip = ip;
//    }
//
//    public Tema getTema() {
//		return tema;
//	}
//
//	public void setTema(Tema tema) {
//		this.tema = tema;
//	}
//
//	public String getIp() {
//		return ip;
//	}
//
//	public void setIp(String ip) {
//		this.ip = ip;
//	}
//
//	public boolean equals(Object obj) {
//        VotoPK other = (VotoPK) obj;
//        return getIp().equals(other.getIp()) && getTema().equals(other.getTema());
//    }
//
//	@Override
//	public int hashCode() {
//		String keyHash = (new StringBuilder().append(tema).append(ip)) .toString();
//		return keyHash.hashCode();
//	}
//
//}

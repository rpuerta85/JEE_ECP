package es.art83.persistence.models.entities;

import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "VOTO", uniqueConstraints= @UniqueConstraint(columnNames = { "IP" }))
//@IdClass(VotoPK.class)
public class Voto {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String ip;
	
	private Integer nota;
    
    private String estudios;
    
    @ManyToOne
    @JoinColumn
    private Tema tema;
    
 
    public Voto(String ip, Integer nota,String estudios) {
         this.ip = ip;
        this.nota = nota;
        this.estudios = estudios;
    }
    public Voto(String ip, Integer nota,String estudios,Tema tema) {
          this(ip,nota,estudios);
          this.tema = tema;
      }
    public Voto() {
        super();
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}


	
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	@Override
    public String toString() {
        return "User[" + ip + ":" + nota + ":"+estudios+":"+tema +"]";
    }

}

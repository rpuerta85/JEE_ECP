package es.miw.jeeecp.models.entities;

import java.lang.String;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "VOTO", uniqueConstraints= @UniqueConstraint(columnNames = { "IP","ID" }))
//@IdClass(VotoPK.class)
public class VotoEntity {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String ip;
	
	private Integer nota;
    
    private String estudios;
    
    public VotoEntity(String ip, Integer nota,String estudios) {
         this.ip = ip;
        this.nota = nota;
        this.estudios = estudios;
    }

    public VotoEntity() {
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
@Override
  public String toString() {
     return "User[" + ip + ":" + nota + ":"+estudios+"]";
  }
	public boolean equals(Object obj) {
		VotoEntity other = (VotoEntity) obj;
		return getId().intValue() == other.getId().intValue();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId().intValue();
		return result;
	}

}

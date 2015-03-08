package es.art83.persistence.models.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

@Entity
public class Tema implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3632602244844491316L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="TEMA")
    private String tema;
	@Column(name="PREGUNTA")
    private String pregunta;
    
	 @OneToMany(cascade = {CascadeType.ALL},mappedBy="tema")
	//@OneToMany(cascade = {CascadeType.ALL})
	 private List<Voto> votos = new ArrayList<Voto>();
	 
    public Tema(String tema,String pregunta) {
        this.tema = tema;
        this.pregunta = pregunta;
    }
   
    public Tema() {
        super();
    }

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	@Override
    public String toString() {
        return "Tema[" + id + ":" + tema + ":"+pregunta+":"+votos +"]";
   }
}

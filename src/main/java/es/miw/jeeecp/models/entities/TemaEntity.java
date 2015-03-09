package es.miw.jeeecp.models.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TemaEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3632602244844491316L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "TEMA")
	private String tema;
	@Column(name = "PREGUNTA")
	private String pregunta;

	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "tema")
	// @OneToMany(cascade = {CascadeType.ALL})
	private List<VotoEntity> votos = new ArrayList<VotoEntity>();

	public TemaEntity(String tema, String pregunta) {
		this.tema = tema;
		this.pregunta = pregunta;
	}

	public TemaEntity() {
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

	public List<VotoEntity> getVotos() {
		return votos;
	}

	public void setVotos(List<VotoEntity> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Tema[" + id + ":" + tema + ":" + pregunta + ":" + votos + "]";
	}

	public boolean equals(Object obj) {
		TemaEntity other = (TemaEntity) obj;
		return getId().intValue() == other.getId().intValue();
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId().intValue();
		return result;
	}
}

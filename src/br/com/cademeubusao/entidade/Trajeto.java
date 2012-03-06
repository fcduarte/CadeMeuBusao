package br.com.cademeubusao.entidade;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class Trajeto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key id;
	
	@ManyToOne
	private Linha linha;
	
	@Embedded
	private Coordenada coordenada;

	public Trajeto() {
	}
	
	public Trajeto(Key id, Linha linha, Coordenada coordenada) {
		super();
		this.id = id;
		this.linha = linha;
		this.coordenada = coordenada;
	}

	/**
	 * @return the id
	 */
	public Key getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Key id) {
		this.id = id;
	}

	/**
	 * @return the linha
	 */
	public Linha getLinha() {
		return linha;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	/**
	 * @return the coordenada
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}

	/**
	 * @param coordenada the coordenada to set
	 */
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

}

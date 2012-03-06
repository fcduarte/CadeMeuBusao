package br.com.cademeubusao.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.google.appengine.api.datastore.Key;

/**
 * Classe que representa a localização atual (em coordenadas) de um determinado onibus
 * 
 * @author Felipe Cerqueira Duarte - UDSC (felipe.cerqueira@dataprev.gov.br)
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(
        name="LocalizacaoAtual.obterCoordenadas",
        query="SELECT loc FROM LocalizacaoAtual loc WHERE loc.dataHoraPosicao BETWEEN ?1 AND ?2 " +
        		"AND loc.onibus = ?3 " +
        		"ORDER BY dataHoraPosicao")
})

public class LocalizacaoAtual implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Onibus onibus;
	
	@Embedded
	private Coordenada posicaoAtual;
	
	private Date dataHoraPosicao;
	
	public LocalizacaoAtual() {
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
	 * @return the onibus
	 */
	public Onibus getOnibus() {
		return onibus;
	}

	/**
	 * @param onibus the onibus to set
	 */
	public void setOnibus(Onibus onibus) {
		this.onibus = onibus;
	}

	/**
	 * @return the posicaoAtual
	 */
	public Coordenada getPosicaoAtual() {
		return posicaoAtual;
	}

	/**
	 * @param posicaoAtual the posicaoAtual to set
	 */
	public void setPosicaoAtual(Coordenada posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}

	/**
	 * @return the dataHoraPosicao
	 */
	public Date getDataHoraPosicao() {
		return dataHoraPosicao;
	}

	/**
	 * @param dataHoraPosicao the dataHoraPosicao to set
	 */
	public void setDataHoraPosicao(Date dataHoraPosicao) {
		this.dataHoraPosicao = dataHoraPosicao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalizacaoAtual other = (LocalizacaoAtual) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocalizacaoAtual [onibus=" + onibus + ", posicaoAtual="
				+ posicaoAtual + ", dataHoraPosicao=" + dataHoraPosicao + "]";
	}
}

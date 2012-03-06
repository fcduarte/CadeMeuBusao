package br.com.cademeubusao.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Onibus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String placa;
	
	@OneToMany(mappedBy = "onibus")
	private List<LocalizacaoAtual> localizacoes;
	
	public Onibus() {
	}
	
	public Onibus(String placa) {
		super();
		this.placa = placa;
	}

	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	/**
	 * @return the localizacoes
	 */
	public List<LocalizacaoAtual> getLocalizacoes() {
		return localizacoes;
	}

	/**
	 * @param localizacoes the localizacoes to set
	 */
	public void setLocalizacoes(List<LocalizacaoAtual> localizacoes) {
		this.localizacoes = localizacoes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Onibus other = (Onibus) obj;
		if (placa == null) {
			if (other.placa != null) {
				return false;
			}
		} else if (!placa.equals(other.placa)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Onibus [placa=" + placa + "]";
	}

}

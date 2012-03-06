package br.com.cademeubusao.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "Linha.obterTodas",
        query = "SELECT l FROM Linha l "  +
        		"ORDER BY numero")
})
public class Linha implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String numero;
	private String descricao;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<PontoDeOnibus> pontosDeParada;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private Set<Trajeto> trajeto;

	public Linha() {
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<PontoDeOnibus> getPontosDeParada() {
		return pontosDeParada;
	}

	public void setPontosDeParada(List<PontoDeOnibus> pontosDeParada) {
		this.pontosDeParada = pontosDeParada;
	}

	/**
	 * 
 	 * Retorna o trajeto (em coordenadas) entre os pontos de onibus
	 * de uma determinada linha.
	 * 
	 * @return the trajeto
	 */
	public Set<Trajeto> getTrajeto() {
		return trajeto;
	}

	/**
	 * @param trajeto the trajeto to set
	 */
	public void setTrajeto(Set<Trajeto> trajeto) {
		this.trajeto = trajeto;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Linha other = (Linha) obj;
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Linha [numero=" + numero + ", descricao=" + descricao
				+ ", pontosDeParada=" + pontosDeParada + ", trajeto=" + trajeto
				+ "]";
	}

}

package br.com.cademeubusao.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.cademeubusao.dao.EMF;
import br.com.cademeubusao.entidade.Linha;

public class LinhaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer firstRow;
	private Integer rowIndex;
	private static final int PAGE_SIZE = 25;
	
	private EntityManager em = EMF.get().createEntityManager();
	
	public LinhaBean() {
	}

	/**
	 * @return the firstRow
	 */
	public Integer getFirstRow() {
		return firstRow;
	}

	/**
	 * @param firstRow the firstRow to set
	 */
	public void setFirstRow(Integer firstRow) {
		this.firstRow = firstRow;
	}

	/**
	 * @return the rowIndex
	 */
	public Integer getRowIndex() {
		return rowIndex;
	}

	/**
	 * @param rowIndex the rowIndex to set
	 */
	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}
	
	/**
	 * Obtém o tamanho do dataTable usado nas páginas.
	 * 
	 * @return o tamanho do dataTable
	 */
	public int getPageSize() {
		return PAGE_SIZE;
	}

	@SuppressWarnings("unchecked")
	public List<Linha> getListaLinhas() {
		List<Linha> retorno = (List<Linha>) EMF.executarNamedQuery(em, "Linha.obterTodas");
		return retorno;
	}
	
	public void criarLinha() {
		
	}
}

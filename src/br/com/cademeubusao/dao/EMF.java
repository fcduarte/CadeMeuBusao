package br.com.cademeubusao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

public final class EMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
    
	/**
	 * @param em
	 * @param namedQuery
	 * @param parameters
	 * @return
	 */
	public static List<?> executarNamedQuery(EntityManager em, String namedQuery, Object... parameters) {
		Query query = prepareQuery(em, namedQuery, 0, 0, parameters);
		return query.getResultList();
	}
	
    /**
	 * Prepara a query de acordo com o nome informado e insere os parametros de
	 * acordo com os nomes e valores que estão nos vetores informados.
	 * 
	 * @param namedQuery - nome da <i>named query</i> a ser criada.
	 * @param parameters - valores dos parametros.
	 * @return o objeto Query criado e com os parâmetros setados.
	 */
	private static Query prepareQuery(EntityManager em, String namedQuery, 
			int firstResult, int maxResults, final Object... parameters) {
		
		Query query = null;

		if (parameters != null && parameters.length > 0) {		
			query = em.createNamedQuery(namedQuery);
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i+1, parameters[i]);
			}
		} else {
			query = em.createNamedQuery(namedQuery);
		}
		
		if (firstResult != 0) {
			query.setFirstResult(firstResult);
		}
		if (maxResults != 0) {
			query.setMaxResults(maxResults);
		}		
		
		query.setFlushMode(FlushModeType.COMMIT);
		return query;
	}
	
	public static List<?> executarNamedQuery(EntityManager em, String namedQuery,
			int firstResult, int maxResults, Object... parameters) {
		Query query = prepareQuery(em, namedQuery, firstResult, maxResults, parameters);
		return query.getResultList();
	}
     
}
package br.com.cademeubusao.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cademeubusao.dao.EMF;
import br.com.cademeubusao.entidade.Onibus;

@SuppressWarnings("serial")
public class OnibusServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(OnibusServlet.class.getName());
	 
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		EntityManager em = null;
		em = EMF.get().createEntityManager();
		
		String placa = req.getParameter("placa");

		Onibus onibus = em.find(Onibus.class, placa);
		
		if (onibus == null) {
			log.info("Placa não encontrada: " + placa);
			onibus = new Onibus(placa);
		}
		
		try {
			em.merge(onibus);
		} finally  {
			em.close();
		}
		
		resp.sendRedirect("/pages/OnibusApplication.jsp");
	}
}

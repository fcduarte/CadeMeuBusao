package br.com.cademeubusao.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cademeubusao.dao.EMF;
import br.com.cademeubusao.entidade.Coordenada;
import br.com.cademeubusao.entidade.PontoDeOnibus;

@SuppressWarnings("serial")
public class PontoDeOnibusServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
		PontoDeOnibus ponto = new PontoDeOnibus();
		ponto.setDescricao(req.getParameter("descricao"));
		ponto.setPosicaoNoMapa(new Coordenada(
				Double.valueOf(req.getParameter("latitude")), 
				Double.valueOf(req.getParameter("longitude")), 0d));
		
		EntityManager em = null;
		
		try {
			em = EMF.get().createEntityManager();
			em.merge(ponto);
		} finally  {
			em.close();
		}
		
		resp.sendRedirect("/pages/PontoApplication.jsp");
	}

}

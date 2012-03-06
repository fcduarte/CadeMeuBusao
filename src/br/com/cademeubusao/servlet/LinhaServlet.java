package br.com.cademeubusao.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cademeubusao.dao.EMF;
import br.com.cademeubusao.entidade.Linha;

@SuppressWarnings("serial")
public class LinhaServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		Linha linha = new Linha();
		linha.setNumero(req.getParameter("numero"));
		linha.setDescricao(req.getParameter("descricao"));
		
		EntityManager em = null;
		
		try {
			em = EMF.get().createEntityManager();
			em.merge(linha);
		} finally  {
			em.close();
		}
		
		resp.sendRedirect("/pages/LinhaApplication.jsp");
	}
}

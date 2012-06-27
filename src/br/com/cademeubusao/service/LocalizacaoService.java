package br.com.cademeubusao.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import br.com.cademeubusao.dao.EMF;
import br.com.cademeubusao.entidade.Coordenada;
import br.com.cademeubusao.entidade.LocalizacaoAtual;
import br.com.cademeubusao.entidade.Onibus;
import br.com.cademeubusao.util.DateUtil;

@Path("/localizacao")
public class LocalizacaoService {
	// Allows to insert contextual objects into the class,
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	private static final Logger log = Logger.getLogger(LocalizacaoService.class.getName());

	/**
	 * Javadoc
	 * @param placa
	 * @param latitude
	 * @param longitude
	 * @param data
	 * @param servletResponse
	 * @throws IOException
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void cadastrarLocalizacao(@FormParam("placa") String placa,
			@FormParam("latitude") String latitude,
			@FormParam("longitude") String longitude,
			@FormParam("data") String data,
			@Context HttpServletResponse servletResponse) throws IOException {

		salvarLocalizacaoAtual(placa, Double.valueOf(latitude),
				Double.valueOf(longitude), data);
//		servletResponse.sendRedirect("../pages/LocalizacaoApplication.jsp");
	}

	private void salvarLocalizacaoAtual(String placa, Double latitude,
			Double longitude, String data) {
		EntityManager em = null;
		em = EMF.get().createEntityManager();

		// Busca o onibus
		Onibus onibus = em.find(Onibus.class, placa);
		
		if (onibus == null) {
			onibus = new Onibus(placa);
		}
		
		LocalizacaoAtual loc = new LocalizacaoAtual();
		loc.setOnibus(onibus);
		loc.setDataHoraPosicao(DateUtil.converterStringEmData(data));
		loc.setPosicaoAtual(new Coordenada(latitude, longitude, 0d));
		
		try {
			em.merge(loc);
			log.info("Localização salva: " + loc); 
		} finally  {
			em.close();
		}
	}
	
//	@PUT
//	@Consumes(MediaType.APPLICATION_XML)
//	public Response putLocalizacaoAtualTO(JAXBElement<LocalizacaoAtualTO> loc) {
//		Response res = Response.created(uriInfo.getAbsolutePath()).build();
//		salvarLocalizacaoAtual(loc.getValue().getPlaca(), loc.getValue().getLatitude(),
//				loc.getValue().getLongitude(), loc.getValue().getVelocidadeAtual());
//		return res;
//	}
	
	@GET
	@Produces("text/plain")
	public String obterCoordenadas(@QueryParam("data") String data,
			@QueryParam("placa") String placa) {
		
		Date dataAtual = DateUtil.converterStringEmData(data);
		Date dataAtualHorasZeradas = DateUtil.zeraHoras(dataAtual);
		
		EntityManager em = EMF.get().createEntityManager();
		@SuppressWarnings("unchecked")
		List<LocalizacaoAtual> lista = (List<LocalizacaoAtual>) EMF.executarNamedQuery(
				em, "LocalizacaoAtual.obterCoordenadas",  
				dataAtualHorasZeradas, dataAtual, new Onibus(placa));
		
		StringBuilder retorno = new StringBuilder();
		
		for (LocalizacaoAtual localizacaoAtual : lista) {
			retorno.append(localizacaoAtual.getPosicaoAtual().getFormatoPadrao());
			retorno.append(" ");
		}
		
		return retorno.toString();
	}
}

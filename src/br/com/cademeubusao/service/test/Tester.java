package br.com.cademeubusao.service.test;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import br.com.cademeubusao.jaxb.LocalizacaoAtualTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class Tester {

	private static final String APP_LOCAL = "http://localhost:8889";
	private static final String APP_DESENV = "http://cademeubusao.appspot.com";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ClientConfig config = new DefaultClientConfig();
//		Client client = Client.create(config);
//		WebResource service = client.resource(getBaseURI());
//		
//		// Criar o objeto
//		LocalizacaoAtualTO loc = new LocalizacaoAtualTO("123", -27.599124, -48.5575322, new BigDecimal("35.00"));
//		
//		ClientResponse response = service.path("rest").path("localizacao").accept(MediaType.APPLICATION_XML).put(ClientResponse.class, loc);
//		
//		// Return code should be 201 == created resource
//		System.out.println(response.getStatus());
		
		System.out.println(new Date());
		
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(APP_LOCAL).build();
	}

}

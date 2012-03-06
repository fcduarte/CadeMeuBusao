package br.com.cademeubusao.jaxb;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocalizacaoAtualTO {
	private String placa;
	private Double latitude;
	private Double longitude;
	private BigDecimal velocidadeAtual;
	
	public LocalizacaoAtualTO() {
	}
	
	public LocalizacaoAtualTO(String placa, Double latitude, Double longitude, BigDecimal velocidadeAtual) {
		super();
		this.placa = placa;
		this.latitude = latitude;
		this.longitude = longitude;
		this.velocidadeAtual = velocidadeAtual;
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
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the velocidadeAtual
	 */
	public BigDecimal getVelocidadeAtual() {
		return velocidadeAtual;
	}

	/**
	 * @param velocidadeAtual the velocidadeAtual to set
	 */
	public void setVelocidadeAtual(BigDecimal velocidadeAtual) {
		this.velocidadeAtual = velocidadeAtual;
	}
	
}
